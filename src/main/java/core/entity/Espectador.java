package core.entity;

import core.structure.Lista;

public class Espectador {

    private String nome;
    private String login;

    private Lista<Avaliacao> series;

    public Lista<Avaliacao> getSeries() {
        return series;
    }

    public void setSeries(Lista<Avaliacao> series) {
        this.series = series;
    }

    public Espectador() {
    }

    public Espectador(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
