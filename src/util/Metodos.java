package util;

import entities.Score;
import entities.Tabela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Metodos {

    private int size; //quantidade de elentos por linha (somente valores pares)
    boolean temEscolhido = false;
    Score score;
    JLabel ptsJogador1;
    JLabel ptsJogador2;
    JLabel jogadorAtualLabel;
    boolean jogadorAtual = true;
    Botoes botoes;
    public Metodos(int size) {
        //construtor
        score = new Score();
        this.size = size;
    }

    public void criaTela(JFrame tela, int size) {
        //Função responsável por criar os botões e adiciona-los na tela
        botoes = new Botoes(size);
        JLabel t = new JLabel("SCORE");
        t.setBounds(700,20,150,60);
        tela.getContentPane().add(t);
        botoes.addBotao(tela);
        ptsJogador1 = new JLabel(score.getTextP1());
        ptsJogador2 = new JLabel(score.getTextP2());
        jogadorAtualLabel = new JLabel(score.jogadorAtual(jogadorAtual));

        ptsJogador1.setBounds(700,50,150,30);
        ptsJogador2.setBounds(700,90,150,30);
        jogadorAtualLabel.setBounds(700,200,150,30);

        tela.getContentPane().add(ptsJogador1);
        tela.getContentPane().add(ptsJogador2);
        tela.getContentPane().add(jogadorAtualLabel);

    }

    public void setScore(){
        ptsJogador1.setText(score.getTextP1());
        ptsJogador2.setText(score.getTextP2());
    }

}
