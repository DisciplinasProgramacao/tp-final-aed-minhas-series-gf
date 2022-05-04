package core.structure;

import core.entity.Serie;

public class Nodo<T> {
    private Nodo<T> anterior;
    private Nodo<T> proximo;
    private T valor;

    public Nodo(){
    }

    public Nodo(T t){
        this.valor = t;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    //Define nó anterior.
    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
    //Retorna nó anterior
    public Nodo<T> getAnterior() {
        return anterior;
    }
    //Define proximo nó.
    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }
    //Retorna proximo nó
    public Nodo<T> getProximo() {
        return proximo;
    }
}