package api;

import java.util.List;

import model.Aluno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlunoService {
    // Obter todos os alunos
    @GET("aluno")
    Call<List<Aluno>> listarAlunos();

    // Adicionar um novo aluno
    @POST("aluno")
    Call<Aluno> salvarAluno(@Body Aluno aluno);
}
