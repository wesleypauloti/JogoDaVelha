import java.security.spec.PSSParameterSpec;
import java.util.Scanner;

public class JogoVelha {
    
    public static void main(String[] args) {    
        
        Scanner scan = new Scanner(System.in);
        Campo[][] velha = new Campo[3][3];
        char simboloAtual = 'X';
        Boolean game = true;
        String vitoria = " ";

        iniciarJogo(velha);

        int cont = 0;
        while(game) {
            desenhaJogo(velha);
            vitoria = verificarVitoria(velha);
            if(!vitoria.equals(" ")) {
                System.out.printf("\n %s \n", vitoria);
                break;
            }
            cont++;
            if (cont > 9) {
                break;
            }
            try {                
                if(verificarJogada(velha, jogar(scan, simboloAtual), simboloAtual)) {
                    if(simboloAtual == 'X') {
                        simboloAtual = 'O';
                    } else {
                        simboloAtual = 'X';
                    }
                }
            } catch(Exception e) {
                System.out.println("Erro");
            }
        }
        if(vitoria.equals(" ")) {
            System.out.println("\nEmpatou");
        }
        System.out.println("\nFim de Jogo\n\n");
    }

    static void desenhaJogo(Campo[][] velha){
        // limparTela();
        System.out.println("  0   1   2");
        System.out.printf("0 %c | %c | %c\n", velha[0][0].getSimbolo(),
        velha[0][1].getSimbolo(), velha[0][2].getSimbolo() );
        System.out.println(" -----------");
        System.out.printf("1 %c | %c | %c\n", velha[1][0].getSimbolo(),
        velha[1][1].getSimbolo(), velha[1][2].getSimbolo() );
        System.out.println(" -----------");
        System.out.printf("2 %c | %c | %c\n", velha[2][0].getSimbolo(),
        velha[2][1].getSimbolo(), velha[2][2].getSimbolo() );
    }

    static void limparTela() {
        for (int i = 0; i < 200; i++) {
            System.out.println(' ');
        }
    }
    
    static int[] jogar(Scanner scan, char sa) {
        int p[] = new int[2];
        System.out.printf("\n%s %c\n", "Quem Joga: ", sa);
        System.out.println("Informe a linha");
        p[0] = scan.nextInt();
        System.out.println("Informe a coluna");
        p[1] = scan.nextInt();
        return p;
    }
    
    static boolean verificarJogada(Campo[][] velha, int p[], char simboloAtual) {
         if (velha[p[0]][p[1]].getSimbolo() == ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    static void iniciarJogo(Campo[][] velha) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                velha[i][j] = new Campo();
            }
        }
    }

    static String verificarVitoria(Campo[][] velha) {
        String res = " ";
        for (int i = 0; i < 3; i++) {             
            if ((velha[i][0].getSimbolo() == 'X') && (velha[i][1].getSimbolo() == 'X') && (velha[i][2].getSimbolo() == 'X') ||
                (velha[0][i].getSimbolo() == 'X') && (velha[1][i].getSimbolo() == 'X') && (velha[2][i].getSimbolo() == 'X') ||
                (velha[0][0].getSimbolo() == 'X') && (velha[1][1].getSimbolo() == 'X') && (velha[2][2].getSimbolo() == 'X') ||
                (velha[0][2].getSimbolo() == 'X') && (velha[1][1].getSimbolo() == 'X') && (velha[2][0].getSimbolo() == 'X')) {
                res = "O jogador Xis Venceu!";                
            } else if ((velha[i][0].getSimbolo() == 'O') && (velha[i][1].getSimbolo() == 'O') && (velha[i][2].getSimbolo() == 'O') ||
                       (velha[0][i].getSimbolo() == 'O') && (velha[1][i].getSimbolo() == 'O') && (velha[2][i].getSimbolo() == 'O') ||
                       (velha[0][0].getSimbolo() == 'O') && (velha[1][1].getSimbolo() == 'O') && (velha[2][2].getSimbolo() == 'O') ||
                       (velha[0][2].getSimbolo() == 'O') && (velha[1][1].getSimbolo() == 'O') && (velha[2][0].getSimbolo() == 'O')) {
                    res = "O Jogador Bolinha Venceu!";                
            } 
        }        
        return res;
    }
        
}
