package com.example.cadastroalunos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import api.AlunoService;
import api.RetrofitClient;
import model.Aluno;
import adapter.AlunoAdapter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListagemAlunosActivity extends AppCompatActivity {

    private RecyclerView recyclerAlunos;
    private AlunoAdapter adapter;
    private static final String BASE_URL = "https://673b9deb96b8dcd5f3f6f2d4.mockapi.io/";
    private static final String TAG = "ListagemAlunos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_alunos);

        recyclerAlunos = findViewById(R.id.recyclerAlunos);
        recyclerAlunos.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AlunoAdapter(new ArrayList<>());
        recyclerAlunos.setAdapter(adapter);

        buscarAlunos();
    }

    private void buscarAlunos() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlunoService service = retrofit.create(AlunoService.class);

        Log.d(TAG, "Iniciando requisição para listar alunos...");

        service.listarAlunos().enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Aluno> listaAlunos = response.body();

                    adapter = new AlunoAdapter(listaAlunos);
                    recyclerAlunos.setAdapter(adapter);

                    Log.d(TAG, "Alunos carregados com sucesso. Total: " + listaAlunos.size());
                } else {
                    Log.e(TAG, "Erro na resposta: " + response.code());
                    Toast.makeText(ListagemAlunosActivity.this,
                            "Erro ao carregar alunos: Código " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.e(TAG, "Erro de rede", t);
                Toast.makeText(ListagemAlunosActivity.this,
                        "Erro de rede: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
