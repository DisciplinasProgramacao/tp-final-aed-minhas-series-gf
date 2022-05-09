package core.structure;

import core.entity.Serie;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lista<T> {
    private Nodo<T> primeiro = null;
    private Nodo<T> ultimo = null;

    private int size;
    public Lista() {
    }

    //Retorna o primeiro nó da lista.
    public T getPrimeiro() {
        if (primeiro == null)
            throw new IndexOutOfBoundsException("Errou feio errou rude");

        return primeiro.getValor();
    }

    //Retorna ultimo nó da lista.
    public T getUltimo() {
        if (ultimo == null)
            throw new IndexOutOfBoundsException("Errou feio errou rude");

        return ultimo.getValor();

    }

    //Percorre os nós da lista comparando os valores de cada nó com o valor passado por parametro enquanto o próximo nó não for nulo.
    public T procura(Object valor) {

        if (getPrimeiro() == null){
            return null;
        }

        Nodo<T> aux = primeiro;

        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return aux.getValor();
            }
            aux = aux.getProximo();
        }
        return null;
    }

    //Insere valor passado por parametro no inicio da lista, se o valor não existir na lista.
    public void insereInicio(T elemento) {

        Nodo<T> nodo = new Nodo<>(elemento);
        if (primeiro == null) {
            ultimo = nodo;
        } else {
            primeiro.setAnterior(nodo);
            nodo.setProximo(primeiro);
        }
        primeiro = nodo;
        size++;
    }

    //Insere valor passado por parametro no fim da lista, se o valor não existir na lista.
    public void insereFim(T elemento) {
        Nodo<T> nodo = new Nodo<>(elemento);

        if (ultimo == null) {
            primeiro = nodo;
        } else {
            nodo.setAnterior(ultimo);
            ultimo.setProximo(nodo);
        }
        ultimo = nodo;
        this.size++;
    }

    public int size(){
        return size;
    }

    public void forEach(Consumidor<T> consumidor) throws Exception {
        if (getPrimeiro() == null) {
            return;
        }
        Nodo<T> aux = primeiro;
        while (aux != null) {
            consumidor.aceitar(aux.getValor());
            aux = aux.getProximo();
        }
    }
}
