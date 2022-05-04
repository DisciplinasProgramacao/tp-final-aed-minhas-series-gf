package core.structure;

import core.entity.Serie;

public class Nodo<T> {
    private Nodo anterior;
    private Nodo proximo;
    private T valor;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    //Define nó anterior.
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    //Retorna nó anterior
    public Nodo getAnterior() {
        return anterior;
    }
    //Define proximo nó.
    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
    //Retorna proximo nó
    public Nodo getProximo() {
        return proximo;
    }
}