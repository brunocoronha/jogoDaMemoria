package entities;

import javax.swing.*;

public class Score {

    private int ptsJogador1;
    private int ptsJogador2;

    public Score(){
        ptsJogador1 = 0;
        ptsJogador2 = 0;
    }

    public int getPtsJogador1(){

        return ptsJogador1;
    }

    public int getPtsJogador2(){

        return ptsJogador2;
    }

    public void incPtP1(){

        this.ptsJogador1++;
    }

    public void incPtP2(){

        this.ptsJogador2++;
    }

    public void match() {
        //frame que informa a vitoria
        JFrame jframe = new JFrame();
        JOptionPane.showMessageDialog(jframe, "Match");

    }

    public void noMatch() {
        //frame que informa que não houve vitória
        JFrame jframe = new JFrame();
        JOptionPane.showMessageDialog(jframe, "No Match");

    }

    public String getTextP1(){

        return "Jogador 1 → " + getPtsJogador1();
    }
    public String getTextP2(){

        return "Jogador 2 → " + getPtsJogador2();
    }
    public String jogadorAtual(boolean vez){
        if(vez){
            return "Vez do Jogador 1" + "";
        }else{
            return "Vez do Jogador 2" + "";
        }
    }
}
