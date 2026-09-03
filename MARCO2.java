package JOGOGUERRA;
import java.util.*;
public class MARCO2 {
    public static JOGADOR[] vJogador;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Vetor = new int [8]
        vJogador = new JOGADOR[8];

        /*jogadores prontos*/
        PreencherDadosJogadores();

        //(flSair = true) ele encerra sessão se flSair for verdadeiro
        boolean flSair = false;

        int escolhaMenu;


        do {
            System.out.println(" ");
            System.out.println("Menu:");
            System.out.println("1 - Registrar lutadores(as)");
            System.out.println("2 - Mostrar lutadores(as)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Listar por classe");
            System.out.println("5 - Mostrar combates");
            System.out.println("6 - Executar lutas");
            System.out.println("7 - Mostrar pontuações");
            System.out.println("8 - Mostrar ranking");
            System.out.println("9 - Encerrar" );

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
                    MostrarCombates();
                    break;
                }
                case 6: {
                    ExecutarLutas();
                    break;
                }
                case 7: {
                    MostrarPontuacoes();
                    break;
                }
                case 8: {
                    MostrarRanking();
                    break;
                }
                case 9: {
                    flSair = true;
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
            // Enguanto flSair for falso vai rodar após ser verdadeiro encerra a sessão
        } while (!flSair);
        System.out.println("Sessão encerrada..!");
    }

    public static void Inserir() {
        Scanner entrada = new Scanner(System.in);

        //Procura qual a próxima posição disponivel no vetor.
        int indice = -1;

        /*vjogador é um vetor de [8] jogadores, e o i inicia como 0, o indici é -1 pq tem que estar na sequencia de 0 a 8
        e se vjogador[i] for igual a nada ele vai criar um novo jogador
         */

        for (int i = 0; i < 8; i++)
            if (vJogador[i] == null) {
                indice = i;
                vJogador[i] = new JOGADOR();
                break;
            }
        //Rodou o for e nenhum é nulo
        if (indice == -1) {
            System.out.println("Todos os jogadores já foram preenchidos!");
            return;
        }
        //Se no caso alguma possição ex 1 estiver nulo vai começar a adicionar dados de um novo jogador
        int escolha = 0;

        System.out.println("Qual o nome do lutador? ");
        vJogador[indice].Nome = entrada.nextLine();

        // do (faça) while (enquanto) a escolha for de 1 a 4
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

        /* do-while (fazer-enquanto) a escolha for de 0 a 100*/

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

    /*Enquanto a posição do vetor não for nula, o programa mostra os dados do jogador armazenado naquela posição
    O for percorre todas as posições do vetor vJogador.
    Em cada posição, o if verifica se existe um jogador (vJogador[i] != null).
    Se existir, chama MostrarDados() para exibir as informações daquele jogador.
    Se a posição estiver vazia (null), ela é ignorada.
    */
    public static void Listar() {
        for (int i = 0; i < 8; i++)
            if(vJogador[i] != null)
            {
                MostrarDados(vJogador[i], i + 1);
            }
    }

    //Aqui o usuario digita um nome e é guardado a variavel (nome) depois vem o for e percorre as 8 posições
    public static void BuscarPorNome() {
        Scanner entrada = new Scanner(System.in);


        System.out.print("Digite um nome: ");
        String nome = entrada.nextLine();

        /*VERIFICA
        (vJogador[i] != null) Se existe um jogador naquela posição.
        (nome.equalsIgnoreCase(vJogador[i].Nome)) Se o nome digitado é igual ao nome do jogador.*/
        for (int i = 0; i < 8; i++)
            if (vJogador[i] != null && nome.equalsIgnoreCase(vJogador[i].Nome))
            {
                System.out.println("JOGADOR ENCONTRADO !!!");
                MostrarDados(vJogador[i], i + 1);
                return;//encontrou o 1 saiu da função
            }
        //Se percorrer o for e não encontrar na tela aparece:
        System.out.println("Lutador não encontrado.");
    }

    //Metodo que serve para procurar jogadores de uma determinada classe.
    public static void ListarPorClasses(){
        Scanner entrada = new Scanner(System.in);

        //Cria uma variável chamada enJog do tipo EnJogador.
        //Inicialmente ela recebe Null, indicando que nenhuma classe de jogador foi escolhida ainda.
        EnJogador enJog = EnJogador.Null;

        //Começa um laço que será executado pelo menos uma vez e mostra o menu para o usuário escolher uma classe.
        do{
            System.out.println(" Digite uma classe para pesquisar: " + "  ");
            System.out.println("-----------------");
            System.out.println("1 - Caça ");
            System.out.println("2 - Guerra ");
            System.out.println("3 - Estratégia ");
            System.out.println("4 - Magia ");
            System.out.println("-----------------");

            //Lê o número digitado.
            int escolha = entrada.nextInt();

            //Verifica qual opção foi escolhida.
            switch (escolha){
                case 1: enJog = EnJogador.Caca; break;
                case 2: enJog = EnJogador.Guerra; break;
                case 3: enJog = EnJogador.Estrategia; break;
                case 4: enJog = EnJogador.Magia; break;
                default: System.out.println("Opção inválida!"); break;
            }
        }while(enJog == EnJogador.Null);
        //Se a opção foi inválida, enJog continua sendo Null.
        //Então o menu aparece novamente até o usuário escolher uma opção válida.


        //Percorre todas as 8 posições do vetor vJogador.
        /*Verifica duas condições:
        (vJogador[i] != null)Existe um jogador nessa posição?
        (enJog == vJogador[i].ClasseCombate)A classe escolhida é igual à classe do jogador?
        Se as duas condições forem verdadeiras: Mostra na tela "JOGADOR ENCONTRADO !!!" e mostra os dados do jogador.
        */
        for (int i = 0; i < 8; i++)
            if(vJogador[i] != null && enJog == vJogador[i].ClasseCombate)
            {
                System.out.println("JOGADOR ENCONTRADO !!!");
                MostrarDados(vJogador[i], i + 1);
                return;
            }
    }

    /*Metodo que serve para mostrar na tela os dados de um jogador.
    JOGADOR j É o objeto do jogador que contém os atributos (Nome, Ataque, Defesa, etc.).
    int id É um número usado como ID do jogador.
    */
    public static void MostrarDados(JOGADOR j, int id){
        System.out.println(" ");
        System.out.println("## -------------------------------");
        /*Se o valor de i for maior que zero, mostra o ID.
        Mostra o nome, mostra a classe do jogador usando o metodo getClasseCombate(), mostra o atributo de ataque,defesa,agilidade e dano.
        */
        if (id > 0)
            System.out.println("## ID: " + id);
        System.out.println("## Nome: " + j.Nome);
        System.out.println("## Classe: " + j.getClasseCombate());
        System.out.println("## Ataque: " + j.Ataque);
        System.out.println("## Defesa: " + j.Defesa);
        System.out.println("## Agilidade: " + j.Agilidade);
        System.out.println("## Dano: " + j.Dano());
        System.out.println("## -------------------------------");
        System.out.println(" ");
    }

    /*Exemplo
    Se existir um jogador:
    JOGADOR j = new JOGADOR();
    j.Nome = "Arthur";
    j.Ataque = 50;
    j.Defesa = 30;
    j.Agilidade = 20;
    E se voce chamar "MostrarDados(j, 1);"
    A saída poderá ser algo parecido com:
    ## -------------------------------
    ## ID: 1
    ## Nome: Arthur
    ## Classe: Guerreiro
    ## Ataque: 50
    ## Defesa: 30
    ## Agilidade: 20
    ## Dano: 75
    ## -------------------------------
    Resumindo: o metodo recebe um jogador e imprime todas as informações dele de forma organizada no console.
    */

    //Aqui criei um metodo para os jogadores já estarem prenchidos e eu conseguir testar sem precisar cadastrar eles um por um.
    public static void PreencherDadosJogadores(){
        /* Registrando os dados dos 8 jogadores */

        //#1
        vJogador[0] = new JOGADOR();
        vJogador[0].Nome = "João";
        vJogador[0].ClasseCombate = EnJogador.Guerra;
        vJogador[0].Ataque = 90;
        vJogador[0].Defesa = 20;
        vJogador[0].Agilidade = 40;

        //#2
        vJogador[1] = new JOGADOR();
        vJogador[1].Nome = "Joana";
        vJogador[1].ClasseCombate = EnJogador.Magia;
        vJogador[1].Ataque = 90;
        vJogador[1].Defesa = 50;
        vJogador[1].Agilidade = 43;

        //#3
        vJogador[2] = new JOGADOR();
        vJogador[2].Nome = "Lucas";
        vJogador[2].ClasseCombate = EnJogador.Caca;
        vJogador[2].Ataque = 42;
        vJogador[2].Defesa = 50;
        vJogador[2].Agilidade = 40;

        //#4
        vJogador[3] = new JOGADOR();
        vJogador[3].Nome = "Joaquim";
        vJogador[3].ClasseCombate = EnJogador.Estrategia;
        vJogador[3].Ataque = 80;
        vJogador[3].Defesa = 60;
        vJogador[3].Agilidade = 43;

        //#5
        vJogador[4] = new JOGADOR();
        vJogador[4].Nome = "Raquel";
        vJogador[4].ClasseCombate = EnJogador.Caca;
        vJogador[4].Ataque = 96;
        vJogador[4].Defesa = 70;
        vJogador[4].Agilidade = 40;

        //#6
        vJogador[5] = new JOGADOR();
        vJogador[5].Nome = "Elena";
        vJogador[5].ClasseCombate = EnJogador.Guerra;
        vJogador[5].Ataque = 95;
        vJogador[5].Defesa = 50;
        vJogador[5].Agilidade = 30;

        //#7
        vJogador[6] = new JOGADOR();
        vJogador[6].Nome = "Luana";
        vJogador[6].ClasseCombate = EnJogador.Estrategia;
        vJogador[6].Ataque = 90;
        vJogador[6].Defesa = 20;
        vJogador[6].Agilidade = 43;

        //#8
        vJogador[7] = new JOGADOR();
        vJogador[7].Nome = "Amanda";
        vJogador[7].ClasseCombate = EnJogador.Magia;
        vJogador[7].Ataque = 90;
        vJogador[7].Defesa = 40;
        vJogador[7].Agilidade = 43;
    }



    /* Criação de duas matrizes mCombates12x2,mPontucoes8x3 */

    //Matriz de combates 12x2 são 12 combates 1 VS 2 pois 2 jogadores irão lutar contra
    public static int [][] mCombates = {
            {3,4},
            {3,5},
            {1,7},
            {4,5},
            {6,3},
            {7,0},
            {7,5},
            {1,0},
            {6,4},
            {2,6},
            {1,2},
    };

    //Matriz de Pontuacoes com 8 jogadores e serão 3 colunas porque cada jogador participa de até 3 lutas.
    public static int[][] mPontuacoes = new int[8][3];

    public static void MostrarCombates(){
        /* Mostrar combates e nome dos lutadores que irão lutar */

        //Percorre toda a matriz 12x2 e a primeira volta é {3,4} (mCombates[0])
        for (int i = 0; i < mCombates.length; i++){

            //Então o lutador1 vale 3 e o lutador2 vale 4 aí mostra na tela os nomes deles ex seria Goku VS Vegeta
            int lutador1 = mCombates[i][0];
            int lutador2 = mCombates[i][1];

            //Se eles não foram cadastrados o combate não acontece
            if (vJogador[lutador1] == null || vJogador[lutador2] == null) {
                System.out.println("Combate ignorado: lutador não cadastrado.");
                continue;
            }


            System.out.println( vJogador[lutador1].Nome+  " VS " + vJogador[lutador2].Nome);

        }


    }

    public static void ExecutarLutas(){
        /* Executar lutas
    A pontuação de cada combate é:(dano do lutador - dano do oponente)
    O termo coluna livre significa a próxima coluna vazia da linha do lutador na matriz de pontuações.
    O código implementa isso usando o vetor colunaLivre[].
     */

        //(Vetor colunaLivre) começa assim [0,0,0,0,0,0,0,0] aí ele controla em qual coluna guardar a próxima pontuação.
        int[] colunaLivre = new int[8];

        //Percorre todos os combates 12x2 (Vai passar por todas as linhas da matriz de combates)
        for (int i =0; i < mCombates.length; i++){

            /*Pega os dois lutadores da luta lá na matriz mCombates a= 0 [3] b= 1 [4]
            {3,4} Jogador 3 dano = 183 e Jogador 4 dano = 206
            */
            int a = mCombates[i][0];
            int b = mCombates[i][1];

            //Verifica se existem (no caso se os jogadores estão cadastrado)
            if (vJogador[a] == null || vJogador[b] == null) {
                System.out.println("Lutador não cadastrado.");
                continue;
            }

            /* faz o calculo para verificar a pontuação do combate.
            Lutador 3 -> dano = 183
            Lutador 4 -> dano = 206
            int pontosA 183 - 206 = -23 int ponstosB 206 - 183 = 23
            */
            int pontosA = vJogador[a].Dano() - vJogador[b].Dano();
            int pontosB= vJogador[b].Dano() - vJogador[a].Dano();

            //Guarda na matriz de mPontuacoes (Supondo: colunaLivre[3] = 0; ai fica mPontuacoes[3][0] = -23
            //colunaLivre[a]++ fica colunaLivre [3] = 1
            mPontuacoes[a][colunaLivre[a]] = pontosA;
            colunaLivre[a]++;
            mPontuacoes[b][colunaLivre[b]] = pontosB;
            colunaLivre[b]++;

            /*E aqui é mostrado o valor de resto que sobra a cada combate para o lutador a conforme ele realiza os 3 combates
                     L1    L2    L3
          Jogador0   10   -5    20
          Jogador1  -10   15    -8
          Jogador2   25   -3     7 */
        }

        System.out.println("Lutas executadas!" );
    }

    public static void MostrarPontuacoes(){
        /* Mostrar pontuações (Mostrar os 3 combates e a soma final.)*/

        //Percorre todos os lutadores.
        for(int i = 0; i < 8; i++){

            //Verifica se existe(Só mostra quem foi cadastrado.)
            if (vJogador[i] != null){
                /*
                Soma as 3 lutas
                int total =
                mPontuacoes[i][0]
                + mPontuacoes[i][1]
                + mPontuacoes[i][2];
                ex: 70,-20,35 o resultado é 85 está como "total"
                 */
                int total = mPontuacoes[i][0]+ mPontuacoes[i][1]+ mPontuacoes[i][2];

                System.out.println(vJogador[i].Nome);
                System.out.println( mPontuacoes[i][0] + " | " + mPontuacoes[i][1] + " | "  + mPontuacoes[i][2]);
                System.out.println("Total: " + total );
                System.out.println();
            }

        }
    }

    public static void MostrarRanking(){
        /* Mostrar ranking (Ordenar pela pontuação final. (do maior ao menor) */

        //Percorre as posições do ranking.
        for (int i = 0; i < 7; i++){

            //Assume que o melhor é o atual. ex i = 0;
            int melhor = i;

            //Procura alguém melhor(Compara todos os outros.)
            for (int j = i + 1; j < 8; j++){

                /*(Soma do atual melhor)     ex: atual melhor [i] Goku 70,20,30 = 120 candidato [j] Piccolo 50,40,50 = 140
                 int totalMelhor =
                 mPontuacoes[melhor][0]
                 + mPontuacoes[melhor][1]
                 + mPontuacoes[melhor][2];
                 */
                int totalMelhor = mPontuacoes[melhor][0]+ mPontuacoes[melhor][1]+ mPontuacoes[melhor][2];

                /*(Soma do candidato)
                 mPontuacoes[melhor][0]
                 + mPontuacoes[melhor][1]
                 + mPontuacoes[melhor][2];
                 */
                int totalIJ = mPontuacoes[j][0]+ mPontuacoes[j][1]+ mPontuacoes[j][2];

                /*Compara os dois: 140 é maior que 120? "SIM" então o melhor atual se torna J
                Se encontrou alguém melhor(Atualiza quem está liderando.)*/
                if (totalIJ > totalMelhor)
                    melhor = j;
            }

            /*Troca os jogadores
            JOGADOR auxJog = vJogador[i]; Guarda temporariamente (FICA auxJog = Goku)
            vJogador[i] = vJogador[melhor]; Coloca o melhor na frente. (FICA Posição 0 -> Piccolo)
            vJogador[melhor] = auxJog; Finaliza a troca. (FICA Posição 3 -> Goku)
            */
            JOGADOR auxJog = vJogador[i];
            vJogador[i] = vJogador[melhor];
            vJogador[melhor] = auxJog;

            /*Troca também as pontuações.
            int[] auxPont = mPontuacoes[i]; Guarda as pontuações.
            mPontuacoes[i] = mPontuacoes[melhor]; Move as pontuações. (TROCA ELAS)
            mPontuacoes[melhor] = auxPont; Completa a troca. (FINALIZA)
            */
            int[] auxPont = mPontuacoes[i];
            mPontuacoes[i] = mPontuacoes[melhor];
            mPontuacoes[melhor] = auxPont;
        }

        //System.out.println("=== RANKING ==="); (Exibe o RANKING)
        System.out.println("=== RANKING ===");

        /*Mostra cada posição (IMPRIME E CALCULA AS 3 LUTAS DO LUTADOR)
        System.out.println(
            (i + 1)
            + "º - "
            + vJogador[i].Nome
            + " ("
            + total
            + " pontos)");
            ex: 1º - Goku (120 pontos)
                2º - Vegeta (95 pontos)
                3º - Kuririn (70 pontos)
         */
        for (int i = 0; i < 8; i++){

            int total = mPontuacoes[i][0]+ mPontuacoes[i][1]+ mPontuacoes[i][2];

            System.out.println((i + 1) + "º - " + vJogador[i].Nome + " (" + total + "pontos ");
        }

    }
    

}

