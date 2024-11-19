package com.example.cadastroalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import android.widget.Toast;

import api.AlunoService;
import api.ViaCepService;
import api.RetrofitClient;
import model.Aluno;
import model.Endereco;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtNome, edtRA, edtCEP, edtLogradouro, edtComplemento, edtBairro, edtCidade, edtUF;
    private Button btnBuscarCEP, btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtRA = findViewById(R.id.edtRA);
        edtCEP = findViewById(R.id.edtCEP);
        edtLogradouro = findViewById(R.id.edtLogradouro);
        edtComplemento = findViewById(R.id.edtComplemento);
        edtBairro = findViewById(R.id.edtBairro);
        edtCidade = findViewById(R.id.edtCidade);
        edtUF = findViewById(R.id.edtUF);

        btnBuscarCEP = findViewById(R.id.btnBuscarCEP);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnBuscarCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cep = edtCEP.getText().toString();

                if (cep.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite um CEP válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                buscarEnderecoPorCEP(cep);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarAluno();
            }
        });
    }

    // Função para buscar o endereço pelo CEP
    private void buscarEnderecoPorCEP(String cep) {
        ViaCepService service = RetrofitClient
                .getRetrofitInstance("https://viacep.com.br/ws/")
                .create(ViaCepService.class);

        service.buscarEndereco(cep).enqueue(new Callback<Endereco>() {
            @Override
            public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Endereco endereco = response.body();
                    edtLogradouro.setText(endereco.getLogradouro());
                    edtComplemento.setText(endereco.getComplemento());
                    edtBairro.setText(endereco.getBairro());
                    edtCidade.setText(endereco.getLocalidade());
                    edtUF.setText(endereco.getUf());
                } else {
                    Toast.makeText(MainActivity.this, "CEP não encontrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Endereco> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro ao buscar CEP: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Função para salvar os dados do aluno
    private void salvarAluno() {
        String nome = edtNome.getText().toString();
        String raStr = edtRA.getText().toString();
        String cep = edtCEP.getText().toString();
        String logradouro = edtLogradouro.getText().toString();
        String complemento = edtComplemento.getText().toString();
        String bairro = edtBairro.getText().toString();
        String cidade = edtCidade.getText().toString();
        String uf = edtUF.getText().toString();

        // Validações simples
        if (nome.isEmpty() || raStr.isEmpty() || cep.isEmpty() || logradouro.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || uf.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
            return;
        }

        int ra;
        try {
            ra = Integer.parseInt(raStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "RA deve ser um número válido", Toast.LENGTH_SHORT).show();
            return;
        }

        Aluno aluno = new Aluno(nome, ra, cep, logradouro, complemento, bairro, cidade, uf);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://673b9deb96b8dcd5f3f6f2d4.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlunoService alunoService = retrofit.create(AlunoService.class);

        alunoService.salvarAluno(aluno).enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Aluno salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ListagemAlunosActivity.class));
                } else {
                    Log.e("Erro", "Código de erro: " + response.code());
                    Toast.makeText(MainActivity.this, "Erro ao salvar aluno", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro de rede: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }






}
