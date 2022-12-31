package util;

import entities.Score;
import entities.Tabela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botoes implements ActionListener{

    private int size;
    private Tabela tabela;
    private Score score;
    private Jogada[] jogada;
    private JButton[][] array_botoes;
    int cont = 0; //esse cont é usado para determinar se dois valores foram escolhidos
    //classe responsável por guardar posições e determinar se houve vitória

    public Botoes(int size){
        array_botoes = new JButton[size][size];
        tabela = new Tabela(size);
        tabela.criaMatriz();
        tabela.sortMatriz();
        tabela.imprimeMatriz();
        score = new Score();
        jogada = new Jogada[2];
        this.size = size;
    }

    public void addBotao(JFrame tela){
        int posC = 20, posL = 50, tamL = 75, altL = 75;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j = j + 2) {
                //cria botoes impares
                array_botoes[i][j] = criaBotao(posC, posL, tamL, altL, this);
                tela.getContentPane().add(array_botoes[i][j]);
                posC = posC + 100;
                //cria botoes pares
                array_botoes[i][j + 1] = criaBotao(posC, posL, tamL, altL, this);
                tela.getContentPane().add(array_botoes[i][j + 1]);
                posC = posC + 100;
            }
            posC = 20;
            posL = posL + 100;
        }
    }

    public JButton criaBotao(int posC, int posL, int tamL, int altL, ActionListener e){
        JButton botao = new JButton();
        botao.setBounds(posC, posL, tamL, altL);
        botao.setText("x");
        botao.setBackground(Color.white);
        botao.addActionListener(e);
        return botao;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        //Aqui a cada botão pressionado é verificado se houve vitória
        //caso exista um popup aparece na tela
        //caso nao os botões recebem a cor branca e seu texto muda para 'x'
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if (evento.getSource() == array_botoes[i][j])  {
                    paintButton(array_botoes[i][j], tabela.getValor(i,j));
                    jogada[cont] = new Jogada(i,j,tabela.getValor(i,j));
                    jogada[cont].printJogada();
                    cont++;
                    if(cont == 2){
                        Jogada aux = new Jogada();
                        if(aux.isMatch(jogada[0],jogada[1])){
                            score.match();
                        }else{
                            score.noMatch();
                            paintButton(array_botoes[jogada[0].getI()][jogada[0].getJ()], 0);
                            paintButton(array_botoes[jogada[1].getI()][jogada[1].getJ()], 0);
                        }
                        cont = 0;
                    }
                }
            }
        }
    }

    public void paintButton(JButton bt, int key){
        //essa função recebe um JButton e uma chave para pintar na tela o botão escolhido
        if(key != 0){ //se a chave for diferente de zero o botão é pintado de amarelo
            bt.setBackground(Color.yellow);
            bt.setText(key+"");
        }else{//se for 0 ele volta a ser branco
            bt.setBackground(Color.white);
            bt.setText("x");
        }

    }


}
