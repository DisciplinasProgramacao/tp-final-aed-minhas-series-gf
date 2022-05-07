package core.entity;

import core.structure.Lista;

public class Serie {

    private int id;
    private String nome;
    private String dataLancamento;
    private int qtdEps;

    private Lista<Avaliacao> avaliacao;

    public Lista<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Lista<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Serie() {

    }

    public Serie(int id, String nome, String dataLancamento, int qtdEps) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.qtdEps = qtdEps;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getQtdEps() {
        return qtdEps;
    }

    public void setQtdEps(int qtdEps) {
        this.qtdEps = qtdEps;
    }



    @Override
    public String toString() {
        return "\n" + id + ";" + nome + ";" + dataLancamento + ";" + qtdEps;
    }

    public String toStringPt2() {
        return "id: " + id + "\nNome: " + nome + "\nDate de lancamento: " + dataLancamento + "\nQuantidade de Eps: " + qtdEps;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof String){
            return this.getNome().equals(obj);
        }
        if (obj instanceof Serie){
            return this.getNome().equals(((Serie) obj).getNome());
        }
        return false;
    }
}
