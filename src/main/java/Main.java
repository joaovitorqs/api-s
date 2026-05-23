import api.GoogleBooks;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) throws IOException, InterruptedException {
        Scanner scr = new Scanner(System.in);

        GoogleBooks consultaLivro = new GoogleBooks();
        api.CoinGecko consultaCripto = new api.CoinGecko();
        api.TheMealDB consultaReceita = new api.TheMealDB();

        Boolean loop = true;

        System.out.println("----------------------------------------------------");
        System.out.println("Consulta de API's");
        System.out.println("----------------------------------------------------");
        System.out.println(" ");

        while (loop) {
            Boolean aux = true;
            System.out.println("----------------------------------------------------");
            System.out.println("Selecione qual das API's abaixo deseja rodar.");
            System.out.println("----------------------------------------------------");
            System.out.println("[ 1 ] Google Books.");
            System.out.println("[ 2 ] CoinGecko.");
            System.out.println("[ 3 ] TheMealDB.");
            System.out.println("[ 0 ] Fechar o programa.");

            try {
                while (aux) {
                    System.out.println("----------------------------------------------------");
                    System.out.printf("Digite sua opção:");
                    int escolha = scr.nextInt();

                    switch (escolha) {
                        case 1:
                            aux = false;
                            consultaLivro.run();
                            break;

                        case 2:
                            aux = false;
                            consultaCripto.run();
                            break;

                        case 3:
                            aux = false;
                            consultaReceita.run();
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
        scr.close();
    }
}
