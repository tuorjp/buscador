import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();
        String cep = "";
        List<Endereco> enderecos = new ArrayList<>();

        while(!cep.equalsIgnoreCase("sair")) {
            System.out.println("Digite o número do CEP, ou a palavra 'sair': ");
            cep = scan.nextLine();

            if(cep.equalsIgnoreCase("sair")) {
                System.out.println("Execução interrompida pelo usuário.");
                break;
            }

            try {
                Endereco endereco = consulta.buscaEndereco(cep);
                System.out.println(endereco);
                enderecos.add(endereco);
            } catch (RuntimeException e) {
                System.out.println("Erro em tempo de execução: ");
                System.out.println(e.getMessage());
            }
        }

        if(!enderecos.isEmpty()) {
            GeradorArquivo geradorArquivo = new GeradorArquivo();
            try {
                geradorArquivo.geraArquivo(enderecos);
            } catch (IOException e) {
                System.out.println("Erro ao salvar arquivos: ");
                System.out.println(e.getMessage());
            }
        }
    }
}