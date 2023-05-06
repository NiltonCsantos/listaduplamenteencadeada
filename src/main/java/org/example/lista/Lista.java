package org.example.lista;

abstract class Lista <T extends Comparable>{

    public abstract void adicionar(T elemento); //1

    public abstract void adicionarInicio(T elemento) ;//2

    public abstract void adicionarComPosicao(T elemento, int posicao);//3


    public abstract T getElemento(int posicao)  throws Exception;


    public abstract Integer getPosElemento(T elemento);//4


    public abstract void remover(int posicao) ;//5


    public abstract void limpar();//6

    public abstract int getTamanho();

    public abstract boolean contem(T elemento);//7


}

