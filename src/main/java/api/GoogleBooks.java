package api;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GoogleBooks {
    Dotenv dotenv = Dotenv.load();
    String apiKeyBooks = dotenv.get("GOOGLE_BOOKS_API_KEY");
    HttpClient client = HttpClient.newHttpClient();

    Scanner scr = new Scanner(System.in);

    public void run() throws IOException, InterruptedException{
        Boolean loop = true;
        while (loop) {
            Boolean aux = true;
            System.out.println("----------------------------------------------------");
            System.out.println("API GoogleBooks (Consulta de dados referente a Livros).");
            System.out.println("----------------------------------------------------");
            System.out.println("[ 1 ] Busque por titulo .");
            System.out.println("[ 0 ] Fechar o programa.");

            try {
                while (aux) {
                    System.out.println("----------------------------------------------------");
                    System.out.printf("Digite sua opção:");
                    int escolha = scr.nextInt();

                    switch (escolha) {
                        case 1:
                            aux = false;
                            System.out.print("Digite o titulo do livro: ");
                            scr.nextLine();
                            String titulo = scr.nextLine();
                            String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + titulo + "&key=" + apiKeyBooks;
                            System.out.println("Retorno de dados da API:");
                            HttpRequest request = HttpRequest.newBuilder().uri(java.net.URI.create(endereco)).build();
                            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                            System.out.println(response.body());
                            break;
                        case 0:
                            aux = false;
                            loop = false;
                            break;
                        default:
                            System.out.println("Camando invalido!");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Comando invalido!");
                scr.nextLine();
            }
        }
    }
}
