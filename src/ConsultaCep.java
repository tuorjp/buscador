import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public Endereco buscaEndereco(String cep) {
        String endereco = "https://viacep.com.br/ws/" + cep + "/json";

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> res = HttpClient
                    .newHttpClient()
                    .send(req, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(res.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
