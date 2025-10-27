import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();

        System.out.println("Digite o número do CEP: ");
        var cep = scan.nextLine();
        try {
            Endereco endereco = consulta.buscaEndereco(cep);
            System.out.println(endereco);
            GeradorArquivo gerador = new GeradorArquivo();
            gerador.geraArquivo(endereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}