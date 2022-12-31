package entities;

import javax.swing.JFrame;
import util.Metodos;

import java.awt.event.ActionEvent;


public class Tela extends JFrame{

    private int size;
    private static final long serialVersionUID = 1L;

    public Tela(int size) {
        this.size = size;
        Metodos metodos = new Metodos(size);
        setTitle("Jogo da memoria");
        setResizable(false);
        setSize(1000, 800);
        getContentPane().setLayout(null);
        metodos.criaTela(this, size);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
