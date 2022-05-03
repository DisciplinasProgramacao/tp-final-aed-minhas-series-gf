package core.structure;

import core.entity.Serie;

import java.util.ArrayList;

public class Lista<T> {
    private Nodo<Serie> primeiro = null, ultimo = null;

    public Lista() {
    }

    public Lista(Nodo primeiro, Nodo ultimo) {
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }

    //Define nó como primeiro da lista.
    public void setPrimeiro(Nodo primeiro) {
        this.primeiro = primeiro;
    }

    //Retorna o primeiro nó da lista.
    public Nodo getPrimeiro() {
        return primeiro;
    }

    //Define nó como ultimo da lista.
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    //Retorna ultimo nó da lista.
    public Nodo getUltimo() {
        return ultimo;
    }

    //Percorre os nós da lista atribuindo os valores de cada nó em um ArrayList enquanto o próximo nó não for nulo.
    public ArrayList<Object> listar() throws Exception {
        ArrayList<Object> lista = new ArrayList<>();
        if (primeiro == null)
            throw new Exception("A lista esta vazia!");
        else {
            Nodo aux = getPrimeiro();
            while (aux != null) {
                Object vl = aux.getValor();
                lista.add(vl);
                aux = aux.getProximo();
            }
            return lista;
        }
    }

    //Percorre os nós da lista comparando os valores de cada nó com o valor passado por parametro enquanto o próximo nó não for nulo.
    public boolean procura(String valor) {
        Nodo aux = getPrimeiro();
        while (aux != null) {
            if (valor.equals(aux.getValor())) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    //Insere valor passado por parametro no inicio da lista, se o valor não existir na lista.
    public void insereInicio(String valor) throws Exception {
        boolean procura = false;
        procura = procura(valor);
        if (procura == false) {
            Nodo novo = new Nodo();
            if (primeiro == null) {
                novo.setValor(valor);
                setPrimeiro(novo);
                setUltimo(novo);
            } else {
                primeiro.setAnterior(novo);
                novo.setValor(valor);
                novo.setProximo(primeiro);
                setPrimeiro(novo);
            }
        } else {
            throw new Exception("Valor já existe na lista!");
        }
    }

    //Insere valor passado por parametro no fim da lista, se o valor não existir na lista.
    public void insereFim(String valor) throws Exception {
        Nodo novo = new Nodo();
        boolean procura = false;
        procura = procura(valor);
        if (procura == true)
            throw new Exception("Valor já existe na lista!");
        else {
            if (ultimo == null) {
                novo.setValor(valor);
                primeiro = novo;
                ultimo = novo;
            } else {
                ultimo.setProximo(novo);
                novo.setValor(valor);
                ultimo = novo;
            }
        }
    }
}
