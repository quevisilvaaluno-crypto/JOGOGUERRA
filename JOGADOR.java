package JOGOGUERRA;
import java.util.*;
//Classe para criar novos jogadores
/*Os jogadores terão:
Nome
ClasseCombate
Ataque
Defesa
Agilidade
Um metodo para calcular o Dano()
Um metodo para obter o nome da classe getClasseCombate()
 */
public class JOGADOR {
    public String Nome;
    public EnJogador ClasseCombate;
    public int Ataque;
    public int Defesa;
    public int Agilidade;
    public int Dano() { return Ataque + Defesa + Agilidade; }
    public String getClasseCombate(){

        //METODO PARA TRANSFORMAR ENUM EM TEXTO
        //Criei uma variavel vazia
        String classe = "";

        /*O Switch pergunta: Qual é a classe deste jogador?
        (Caso seja Caça) case Caca: classe = "Caça"; break;
        Se: ClasseCombate = EnJogador.Caca;
        Então: classe = "Caça";
         */
        switch (ClasseCombate)
        {
            case Caca: classe = "Caça"; break;
            case Guerra: classe = "Guerra"; break;
            case Estrategia: classe = "Estratégia"; break;
            case Magia: classe = "Magia"; break;
            default: classe = "Indefinida"; break; //Nulo é classe indefinida
        }

        return classe; //Aqui retorna o resultado
    }
}
