package org.example.lista;

public class ListaDupE <T extends Comparable<T>> extends Lista<T>{
    private No <T> primeiro;
    private No <T> ultimo;
    private int tamanho;

    public ListaDupE(){
        this.tamanho=0;
    }

    public No<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }

    public No<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void adicionar(T elemento) {//1

        No <T> novoDado= new No<>(elemento);

        if (this.primeiro==null && this.ultimo==null){
            this.primeiro=novoDado;
            this.ultimo=novoDado;
        }
        else{
            this.ultimo.setProximo(novoDado);
            novoDado.setAnterior(this.ultimo);
            this.ultimo=novoDado;
        }

        this.tamanho++;

    }

    @Override
    public void adicionarInicio(T elemento) {//2

        No <T> dado= new No<>(elemento);

        dado.setProximo(this.primeiro);

        this.primeiro.setAnterior(dado);

        this.primeiro=dado;

        this.tamanho++;

    }

    @Override
    public void adicionarComPosicao(T elemento, int posicao) {//3

           No <T> auxiliarAnterior= this.primeiro;
           No <T> auxiliarAtual= null;

           No<T> novoDado= new No<>(elemento);

           if (posicao==0){
               adicionarInicio(elemento);
           }else{

               for (int i = 0; i < posicao-1; i++) {

                   auxiliarAnterior=auxiliarAnterior.getProximo();

               }

               auxiliarAtual=auxiliarAnterior.getProximo();

               auxiliarAnterior.setProximo(novoDado);

               novoDado.setAnterior(auxiliarAnterior);

               auxiliarAtual.setAnterior(novoDado);

               novoDado.setProximo(auxiliarAtual);

               this.tamanho++;

           }




    }

    @Override
    public T getElemento(int posicao)  {//4

        No<T> auxiliarAtual= null;

        if (posicao>(int)this.tamanho/2){

            auxiliarAtual=this.ultimo;

            for (int i = tamanho; i >=posicao ; i--) {

                if (i==posicao+1){
                    return auxiliarAtual.getDado();
                }

                auxiliarAtual=auxiliarAtual.getAnterior();

            }

        }else{

          auxiliarAtual=this.primeiro;

            for (int i = 0; i <= posicao; i++) {

                if (i==posicao){
                    return auxiliarAtual.getDado();
                }
                auxiliarAtual=auxiliarAtual.getProximo();
            }

        }

        return null;

    }

    @Override
    public Integer getPosElemento(T elemento) {//5

        No<T> elementoAtual= this.primeiro;

        for (int i = 0; i <this.tamanho; i++) {

            if (elemento.equals(elementoAtual.getDado())){
                return i;
            }

            elementoAtual=elementoAtual.getProximo();

        }

        return null;

    }

    @Override
    public void remover(int posicao){//6

        No <T> auxiliarAtual= this.primeiro;
        No <T> auxiarAnterior= null;

        if(posicao==0){

            auxiliarAtual= this.primeiro.getProximo();

            this.primeiro=auxiliarAtual;
            this.primeiro.setAnterior(null);

        }else{


            for (int i = 0; i < posicao ; i++) {

                auxiliarAtual=auxiliarAtual.getProximo();

            }

            auxiarAnterior=auxiliarAtual.getAnterior();

            auxiarAnterior.setProximo(auxiliarAtual.getProximo());

            auxiliarAtual=auxiliarAtual.getProximo();

            auxiliarAtual.setAnterior(auxiarAnterior);

        }

        this.tamanho--;



    }

    @Override
    public void limpar() {//7

        this.primeiro=null;

        this.ultimo=null;

        this.tamanho=0;

    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public boolean contem(T elemento) {

        No<T> elementoAtual= this.primeiro;

        for (int i = 0; i <this.tamanho; i++) {

            if (elemento.equals(elementoAtual.getDado())){
                return true;
            }

            elementoAtual=elementoAtual.getProximo();

        }

        return false;
    }

    @Override
    public String toString() {

        if (this.primeiro!=null){
            String array="";

            No <T> auxiliarAtual=this.primeiro;
            for (int i = 0; i <this.tamanho ; i++) {

                array+= auxiliarAtual.getDado()+"\t";

                auxiliarAtual=auxiliarAtual.getProximo();

            }

            return array;
        }

        return null;

    }

    public String listarElementosAocontrario() {

        No auxiliar=this.ultimo;

        String string="";

        if (this.ultimo!=null){

            for (int i = tamanho; i >0 ; i--) {

                string+= (auxiliar.getDado()+"\t");
                auxiliar=auxiliar.getAnterior();

            }

            return string;

        }

        return null;
    }

}
