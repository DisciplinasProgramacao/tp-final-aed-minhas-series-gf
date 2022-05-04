package core.structure;

import core.entity.Serie;

import java.util.ArrayList;

public class Lista<T> {
    private Nodo<T> primeiro = null;
    private Nodo<T> ultimo = null;

    private int size;
    public Lista() {
    }

    public Lista(Nodo<T> primeiro, Nodo<T> ultimo) {
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }

    //Define nó como primeiro da lista.
    public void setPrimeiro(Nodo<T> primeiro) {
        this.primeiro = primeiro;
    }

    //Retorna o primeiro nó da lista.
    public Nodo getPrimeiro() {
        return primeiro;
    }

    //Define nó como ultimo da lista.
    public void setUltimo(Nodo<T> ultimo) {
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
    public boolean procura(Nodo valor) {

        if (getPrimeiro() == null || getPrimeiro().equals(null)){
            return false;
        }

        Serie serieAux = new Serie();
        if (valor.getValor() instanceof Serie)
            serieAux = (Serie) valor.getValor();

        Serie serie = new Serie();
        serie.setNome(serieAux.getNome());
        Nodo<Serie> aux = (Nodo<Serie>) getPrimeiro().getValor();

        while (aux != null) {
            if (serieAux.getNome().equals(aux.getValor().getNome())) {
                returnSerie(serieAux);
                return true;
            }
            aux = getPrimeiro().getProximo();
        }
        return false;
    }

    public void returnSerie(Serie serie){
        StringBuilder el = new StringBuilder();
        el.append("Nome: ").append(serie.getNome()).append("\n")
                .append("Quantidade de Eps: ").append(serie.getQtdEps()).append("\n")
                .append("Data de lancamento: ").append(serie.getDataLancamento());

        System.out.println(el);
    }

    //Insere valor passado por parametro no inicio da lista, se o valor não existir na lista.
    public void insereInicio(Nodo valor) throws Exception {
        boolean procura = false;

        Serie aux = new Serie();
        if (valor.getValor() instanceof Serie)
            aux = (Serie) valor.getValor();


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
    public void insereFim(Nodo nodo) throws Exception {
        Nodo novo = new Nodo();
        boolean procura = false;

        Serie aux = new Serie();
        if (nodo.getValor() instanceof Serie)
            aux = (Serie) nodo.getValor();

        procura = procura(nodo);

        if (procura == true)
            throw new Exception("Valor já existe na lista!");
        else {
            if (ultimo == null) {
                novo.setValor(nodo);
                primeiro = novo;
                ultimo = novo;
            } else {
                ultimo.setProximo(novo);
                novo.setValor(nodo);
                ultimo = novo;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int size(){
        return size;
    }
}
