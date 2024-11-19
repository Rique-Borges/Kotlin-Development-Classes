package api;

import model.Endereco;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViaCepService {
    @GET("{cep}/json/")
    Call<Endereco> buscarEndereco(@Path("cep") String cep);
}
