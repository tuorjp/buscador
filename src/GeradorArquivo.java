import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorArquivo {
    public void geraArquivo(List<Endereco> enderecos) throws IOException {
        for(Endereco endereco : enderecos) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            FileWriter escrita = new FileWriter(endereco.cep() + ".json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
        }
    }
}
