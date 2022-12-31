package entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Tabela {

    private int matriz[][];
    private int size;
    public Tabela(int size) {
        this.size = size;
    }

    public int getValor(int i, int j) {
        return matriz[i][j];
    }

    public void criaMatriz() {
        this.matriz = new int[size][size];
    }

    public void sortMatriz(){
        //aqui os valores são gerados, embaralhados e inseridos na matriz
        ArrayList<Integer> keys = new ArrayList<Integer>();
        int valor_1 = 1;
        int valor_2 = 1;
        for(int i = 0; i < (size * size) / 2; i++){
            keys.add(valor_1);
            keys.add(valor_2);
            valor_1 = valor_2 = valor_1 + 1;
        }
        System.out.println("Array before Shuffle -> " + keys.toString());
        Collections.shuffle(keys);
        System.out.println("Array after Shuffle -> " + keys.toString());
        Collections.shuffle(keys);
        System.out.println("Array after Shuffle -> " + keys.toString());
        int index = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matriz[i][j] = keys.get(index);
                index++;
            }
        }
    }

    public void imprimeMatriz(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
