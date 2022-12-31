package util;

public class Jogada {

    private int i, j, chave;
    public Jogada(int i, int j, int key){
        this.i = i; //linha do botão escolhido
        this.j = j; //coluna do botão escolhido
        this.chave = key; //valor do botão na matriz
    }
    public Jogada(){

    }
    public int getI() {

        return i;
    }

    public int getJ() {

        return j;
    }

    public int getChave() {

        return chave;
    }

    public void printJogada(){

        System.out.println(i + " " + j);
    }

    public boolean isMatch(Jogada jogada1, Jogada jogada2){
        //aqui é onde se verifica se as duas jogadas feitas resultam em um ponto
        if(jogada1.getChave() == jogada2.getChave()){
            System.out.println("MATCH");
            return true;
        }else{
            System.out.println("NO MATCH");
            return false;
        }
    }
}
