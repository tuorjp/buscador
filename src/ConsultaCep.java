import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public Endereco buscaEndereco(String cep) {
        String endereco = "https://viacep.com.br/ws/" + cep + "/json";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> res = null;

        try {
            res = HttpClient
                    .newHttpClient()
                    .send(req, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(res.body(), Endereco.class);
    }
}
