import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Menu();
    }

    //Funções

    private static void Figuras() {
        try {
            int i;
            int j;
            int linhasFig;
            System.out.println("\n");
            System.out.print("|Qual o tamanho do triângulo (de 1 10)?|: ");
            Scanner numLinhas = new Scanner(System.in);
            do {
                linhasFig = numLinhas.nextInt();

                System.out.println("\n");
                for (i = 0; i < linhasFig; i++) {

                    // loop para o numero de espaços
                    for (j = linhasFig - i; j > 1; j--) {
                        // print dos espaços
                        System.out.print(" ");
                    }

                    //loop colunas
                    for (j = 0; j <= i; j++) {
                        // print simbolos
                        System.out.print("* ");
                    }

                    // fim da linha
                    System.out.println();
                }
                System.out.println("\n");

                for (i = 0; i < linhasFig; i++) {
                    for (j = 0; j < linhasFig; j++) {
                        if ((i + j) % 2 == 0) {
                            System.out.print("O ");
                        } else {
                            System.out.print("X ");
                        }
                    }
                    System.out.println(); // Nova linha após cada linha do quadrado
                }
                System.out.println("\n");
                for(i=0; i<linhasFig; i++)
                {

                    System.out.print("*");

                }
                System.out.println();
                for(j=0;j<linhasFig-2;j++)
                {
                for(i=0; i<=linhasFig+j+1; i++)
                {
                   
                    if(i==0 || i==linhasFig+j){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            for(i=0; i<linhasFig+j+1; i++)
                {

                    System.out.print("*");

                }
                System.out.println("\n");
                Menu();
            } while (linhasFig <= 0 || linhasFig > 10);
        }
            catch(InputMismatchException exception){  //Irá pegar o Input errado
                System.out.println("\n  !!!!!!!!!!!  ERRO: ESSA OPÇÃO NÃO ESTÁ DISPONÍVEL  !!!!!!!!!!!");
                System.out.println("\n");
                Figuras();
            }
    }

    private static void JGalo()
        {
            char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            char jogador = 'X';
            char computador = 'O';

            System.out.println("Bem-vindo ao Jogo do Galo!");

            for (int jogadas = 0; jogadas < 9; jogadas++) {
                imprimirTabuleiro(tabuleiro);
                if (jogador == 'X') {
                    fazerJogada(tabuleiro, jogador);
                } else {
                    fazerJogadaComputador(tabuleiro, computador);
                }

                if (verificarVitoria(tabuleiro, jogador)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Parabens ganhaste!!!");
                    continue;
                }

                jogador = (jogador == 'X') ? 'O' : 'X';
            }

            if (verificarEmpate(tabuleiro)) {
                imprimirTabuleiro(tabuleiro);
                System.out.println("O jogo empatou!");
                Menu();
            }
        }

        public static void imprimirTabuleiro(char[][] tabuleiro) {
            for (int linha = 0; linha < 3; linha++) {
                for (int coluna = 0; coluna < 3; coluna++) {
                    System.out.print(tabuleiro[linha][coluna]);
                    if (coluna < 2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if (linha < 2) {
                    System.out.println("---------");
                }
            }
            System.out.println();
        }

        public static void fazerJogada(char[][] tabuleiro, char jogador) {
            Scanner scanner = new Scanner(System.in);
            int linha, coluna;
            do {
                System.out.print("Escolha uma linha (0, 1, 2) e coluna (0, 1, 2) separadas por espaço: ");
                linha = scanner.nextInt();
                coluna = scanner.nextInt();
            } while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ');
            tabuleiro[linha][coluna] = jogador;
        }

        public static void fazerJogadaComputador(char[][] tabuleiro, char computador) {
            Random rand = new Random();
            int linha, coluna;
            do {
                linha = rand.nextInt(3);
                coluna = rand.nextInt(3);
            } while (tabuleiro[linha][coluna] != ' ');
            tabuleiro[linha][coluna] = computador;
        }

        public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
            for (int linha = 0; linha < 3; linha++) {
                if (tabuleiro[linha][0] == jogador && tabuleiro[linha][1] == jogador && tabuleiro[linha][2] == jogador) {
                    return true;
                }
            }

            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[0][coluna] == jogador && tabuleiro[1][coluna] == jogador && tabuleiro[2][coluna] == jogador) {
                    return true;
                }
            }

            if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
                return true;
            }

            return tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador;
        }

        public static boolean verificarEmpate(char[][] tabuleiro) {
            for (int linha = 0; linha < 3; linha++) {
                for (int coluna = 0; coluna < 3; coluna++) {
                    if (tabuleiro[linha][coluna] == ' ') {
                        return false;
                    }
                }
            }
            return true;
    }
    private static void Menu() {
        int menu = 0;
        do {
            try {
                System.out.println("|Menu de opçoes|");
                System.out.println("(1) Desenho de figuras geomatricas ");
                System.out.println("(2) Desenho de triangulos lado a lado ");
                System.out.println("(3) Jogo do galo ");
                System.out.println("(4) Sair\n");
                System.out.print("|Escolha uma opção|: ");

                Scanner scannerMenu = new Scanner(System.in);
                menu = scannerMenu.nextInt();
                switch (menu) {
                    case 1:
                        Figuras();
                        System.out.println("\n");

                    case 2:
                        Menu();
                        System.out.println("\n");

                    case 3:
                        JGalo();
                        System.out.println("\n");

                    case 4:
                        System.out.println("\n");
                        System.out.println("|-------------------------------|");
                        System.out.println("|......A sair do Programa!......|");
                        System.out.println("|-------------------------------|");
                        System.out.println("\n");
                        Exit();

                    default:
                        System.out.println("Introduza um opção válida!!!!!!!!!!!");
                        Menu();
                }
            }
            catch (InputMismatchException exception) {  //Irá pegar o Input errado
                System.out.println("\n  !!!!!!!!!!!  ERRO: ESSA OPÇÃO NÃO ESTÁ DISPONÍVEL  !!!!!!!!!!!");
                System.out.println("\n");
                Figuras();
            }
        }
        while (menu<= 0 || menu >= 4);
    }
    public static void Exit() {
        System.exit(0);
    }
}
