import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Menu();
    }

    //Funções

    public static void Figuras() {
        try {
                int linhasFig;
                int i;
                int j;
                System.out.println("\n");
                System.out.print("|Qual o tamanho das figuras (de 1 10)?|: ");
                System.out.println();
                Scanner numLinhas = new Scanner(System.in);
                linhasFig = numLinhas.nextInt();

                if(linhasFig > 0 && linhasFig <=10) {
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
                    for (i = 0; i < linhasFig; i++) {

                        System.out.print("*");

                    }
                    System.out.println();
                    for (j = 0; j < linhasFig - 2; j++) {
                        for (i = 0; i <= linhasFig + j + 1; i++) {

                            if (i == 0 || i == linhasFig + j) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    for (i = 0; i < linhasFig + j + 1; i++) {

                        System.out.print("*");

                    }
                    System.out.println("\n");
                    Menu();
                }
                else{
                    System.out.println("|OPÇÃO INVALIDA||INTRODUZA UM NUMERO DE 1 A 10!!!!|");
                    Figuras();
                }
        }
        catch(InputMismatchException exception){  //Irá pegar o Input errado
                System.out.println("\n  !!!!!!!!!!!  ERRO: ESSA OPÇÃO NÃO ESTÁ DISPONÍVEL  !!!!!!!!!!!");
                System.out.println("\n");
                Figuras();
        }
    }

    public static void Triangulos() {
        try {

                int linhastrig;
                int spacing = 3;

                System.out.print("|Qual o tamanho do triângulo (de 1 10)?|: ");
                Scanner numLinhas = new Scanner(System.in);
                linhastrig = numLinhas.nextInt();
                if(linhastrig > 0 && linhastrig<=10) {


                    //Print das alíneas

                    String a = "(a)";
                    String b = "(b)";
                    String c = "(c)";
                    String d = "(d)";

                    System.out.print(a + " ".repeat(linhastrig - 3 + spacing));
                    System.out.print(b + " ".repeat(linhastrig - 3 + spacing));
                    System.out.print(c + " ".repeat(linhastrig - 3 + spacing));
                    System.out.print(d + " ".repeat(linhastrig - 3 + spacing));

                    System.out.println();
                    for (int i = 1; i <= linhastrig; i++) {
                        // Primeiro triângulo
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        for (int j = 0; j < linhastrig - i + spacing; j++) {
                            System.out.print(" ");
                        }

                        // Segundo triângulo
                        for (int j = 0; j < linhastrig - i + 1; j++) {
                            System.out.print("*");
                        }
                        for (int j = 0; j < i - 1 + spacing; j++) {
                            System.out.print(" ");
                        }

                        // Terceiro triângulo
                        for (int j = 0; j < i - 1; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < linhastrig - i + 1; j++) {
                            System.out.print("*");
                        }
                        for (int j = 0; j < spacing; j++) {
                            System.out.print(" ");
                        }

                        // Quarto triângulo
                        for (int j = 0; j < linhastrig - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }
                    System.out.println("\n");
                    Menu();
                }
                else{
                    System.out.println("|OPÇÃO INVALIDA||INTRODUZA UM NUMERO DE 1 A 10!!!!|");
                    Triangulos();
                }
        }
        catch(InputMismatchException exception){  //Irá pegar o Input errado
            System.out.println("\n  !!!!!!!!!!!  ERRO: ESSA OPÇÃO NÃO ESTÁ DISPONÍVEL  !!!!!!!!!!!");
            System.out.println("\n");
            Triangulos();
        }
    }

    public static void JGalo()
    {

        char[][] tabuleiro = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };

        boolean jogoEmAndamento = true;
        char jogadorAtual = 'X';

        while (jogoEmAndamento) {
            exibirTabuleiro(tabuleiro);
            if (jogadorAtual == 'X') {
                fazerJogada(tabuleiro, jogadorAtual);
            } else {
                fazerJogadaComputador(tabuleiro, jogadorAtual);
            }

            if (Vitoria(tabuleiro, jogadorAtual)) {
                exibirTabuleiro(tabuleiro);
                if (jogadorAtual == 'X') {
                    System.out.println("O jogador " + jogadorAtual + " venceu! Parabéns!");
                    Menu();
                } else {
                    System.out.println("O computador venceu! Melhor sorte da próxima vez.");
                    Menu();
                }
                jogoEmAndamento = false;
            } else if (verificarEmpate(tabuleiro)) {
                exibirTabuleiro(tabuleiro);
                System.out.println("Empate! O jogo terminou sem vencedor.");
                jogoEmAndamento = false;
                JGalo();
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }
    }

    public static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static void fazerJogada(char[][] tabuleiro, char jogador) {
        try {
            Scanner scanner = new Scanner(System.in);
            int linha, coluna;

            do {
                System.out.print("Jogador " + jogador + ", informe a linha (0-2) e a coluna (0-2) da sua jogada: ");
                linha = scanner.nextInt();
                coluna = scanner.nextInt();
            } while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ');

            tabuleiro[linha][coluna] = jogador;
        }
        catch(InputMismatchException exception){  //Irá pegar o Input errado
            System.out.println("\n  !!!!!!!!!!!  ERRO: ESSA OPÇÃO NÃO ESTÁ DISPONÍVEL  !!!!!!!!!!!");
            System.out.println("\n");
            JGalo();
        }
    }

    public static void fazerJogadaComputador(char[][] tabuleiro, char jogador) {
        Random random = new Random();
        int linha, coluna;

        do {
            linha = random.nextInt(3);
            coluna = random.nextInt(3);
        } while (tabuleiro[linha][coluna] != ' ');

        System.out.println("O computador escolheu a linha " + linha + " e coluna " + coluna);
        tabuleiro[linha][coluna] = jogador;
    }

    public static boolean Vitoria(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true; // Verificação de vitória na linha
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true; // Verificação de vitória na coluna
            }
        }

        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true; // Verificação de vitória na diagonal principal
        }

        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true; // Verificação de vitória na diagonal secundária
        }

        return false;
    }

    public static boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; // Ainda há espaços vazios, o jogo não é um empate.
                }
            }
        }
        return true;

    }
    private static void Menu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("|Menu de opçoes|");
                System.out.println();
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
                        Triangulos();
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
                Menu();
            }
        }
        while (menu<= 0 || menu >= 4);
    }
    public static void Exit() {
        System.exit(0);
    }
}
