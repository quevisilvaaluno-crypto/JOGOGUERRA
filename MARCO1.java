package JOGOGUERRA;
import java.util.*;
public class MARCO1 {
    public static JOGADOR[] vJogador;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Vetor = new int [8]
        vJogador = new JOGADOR[8];

        //caso sair (flSair = true) ele encerra sessão se flSair for verdadeiro
        boolean flSair = false;

        int escolhaMenu;

        do {
            System.out.println(" ");
            System.out.println("Menu:");
            System.out.println("1 - Registrar lutadores(as)");
            System.out.println("2 - Mostrar lutadores(as)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Listar por classe");
            System.out.println("5 - Encerrar");
            escolhaMenu = entrada.nextInt();

            switch (escolhaMenu) {
                case 1: {
                    Inserir();
                    break;
                }
                case 2: {
                    Listar();
                    break;
                }
                case 3: {
                    BuscarPorNome();
                    break;
                }
                case 4: {
                    ListarPorClasses();
                    break;
                }
                case 5: {
                    flSair = true;
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }

        } while (!flSair);
        System.out.println("Sessão encerrada..!");
    }

    public static void Inserir() {
        Scanner entrada = new Scanner(System.in);

        int indice = -1;

        for (int i = 0; i < 8; i++)
            if (vJogador[i] == null) {
                indice = i;
                vJogador[i] = new JOGADOR();
                break;
            }

        if (indice == -1) {
            System.out.println("Todos os jogadores já foram preenchidos!");
            return;
        }

        int escolha = 0;

        System.out.println("Qual o nome do lutador? ");
        vJogador[indice].Nome = entrada.nextLine();

        do {
            System.out.println("Qual a classe de combate? ");
            System.out.println("Digite: ");
            System.out.println("1 - Caça ");
            System.out.println("2 - Guerra ");
            System.out.println("3 - Estratégia ");
            System.out.println("4 - Magia ");
            escolha = entrada.nextInt();

            if (escolha < 1 || escolha > 4) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                switch (escolha) {
                    case 1: vJogador[indice].ClasseCombate = EnJogador.Caca; break;
                    case 2: vJogador[indice].ClasseCombate = EnJogador.Guerra;break;
                    case 3: vJogador[indice].ClasseCombate = EnJogador.Estrategia;break;
                    case 4: vJogador[indice].ClasseCombate = EnJogador.Magia;break;
                }
        } while (escolha < 1 || escolha > 4);

        do {
            System.out.println("Digite qual o valor do ATAQUE? ");
            escolha = entrada.nextInt();
            if (escolha < 0 || escolha > 100) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                vJogador[indice].Ataque = escolha;
        } while (escolha < 0 || escolha > 100);

        do {
            System.out.println("Digite qual o valor da DEFESA? ");
            escolha = entrada.nextInt();
            if (escolha < 0 || escolha > 100) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                vJogador[indice].Defesa = escolha;
        } while (escolha < 0 || escolha > 100);

        do {
            System.out.println("Digite qual o valor da AGILIDADE? ");
            escolha = entrada.nextInt();
            if (escolha < 0 || escolha > 100) {
                System.out.println("Opção inválida!! ");
                System.out.println(" ------------------------------- ");
            } else
                vJogador[indice].Agilidade = escolha;
        } while (escolha < 0 || escolha > 100);

        System.out.println("Jogador cadastrado com sucesso!");

    }

    public static void Listar() {
        for (int i = 0; i < 8; i++)
            if(vJogador[i] != null)
            {
                MostrarDados(vJogador[i], i + 1);
            }
    }

    public static void BuscarPorNome() {
        Scanner entrada = new Scanner(System.in);


        System.out.print("Digite um nome: ");
        String nome = entrada.nextLine();


        for (int i = 0; i < 8; i++)
            if (vJogador[i] != null && nome.equalsIgnoreCase(vJogador[i].Nome))
            {
                System.out.println("JOGADOR ENCONTRADO !!!");
                MostrarDados(vJogador[i], i + 1);
                return;
            }

        System.out.println("Lutador não encontrado.");
    }

    public static void ListarPorClasses(){
        Scanner entrada = new Scanner(System.in);

        EnJogador enJog = EnJogador.Null;

        do{
            System.out.print(" Digite uma classe para pesquisar: " + "  ");
            System.out.println("1 - Caça ");
            System.out.println("2 - Guerra ");
            System.out.println("3 - Estratégia ");
            System.out.println("4 - Magia ");
            int escolha = entrada.nextInt();

            switch (escolha){
                case 1: enJog = EnJogador.Caca; break;
                case 2: enJog = EnJogador.Guerra; break;
                case 3: enJog = EnJogador.Estrategia; break;
                case 4: enJog = EnJogador.Magia; break;
                default: System.out.println("Opção inválida!"); break;
            }
        }while(enJog == EnJogador.Null);

        for (int i = 0; i < 8; i++)
            if(vJogador[i] != null && enJog == vJogador[i].ClasseCombate)
            {
                System.out.println("JOGADOR ENCONTRADO !!!");
                MostrarDados(vJogador[i], i + 1);
                return;
            }
    }

    public static void MostrarDados(JOGADOR j, int i){
        System.out.println(" ");
        System.out.println("## -------------------------------");
        if (i > 0)
            System.out.println("## ID: " + i);
        System.out.println("## Nome: " + j.Nome);
        System.out.println("## Classe: " + j.getClasseCombate());
        System.out.println("## Ataque: " + j.Ataque);
        System.out.println("## Defesa: " + j.Defesa);
        System.out.println("## Agilidade: " + j.Agilidade);
        System.out.println("## Dano: " + j.Dano());
        System.out.println("## -------------------------------");
        System.out.println(" ");
    }
}

