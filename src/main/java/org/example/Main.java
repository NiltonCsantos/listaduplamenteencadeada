package org.example;

import org.example.lista.ListaDupE;
import org.example.lista.Menu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main{
    public static void main(String[] args) {

        ListaDupE<Integer> listaDupE= new ListaDupE<Integer>();

        Menu menu= new Menu();

        listaDupE.adicionar(7);
        listaDupE.adicionar(4);
        listaDupE.adicionar(2);
        listaDupE.adicionar(0);
        listaDupE.adicionar(9);

        System.out.println(listaDupE);

        System.out.println("limpando lista: ");

        listaDupE.limpar();

        System.out.println(listaDupE);








    }
}