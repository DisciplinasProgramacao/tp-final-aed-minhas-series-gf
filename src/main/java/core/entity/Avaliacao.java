package core.entity;

public class Avaliacao {
    private String login;
    private int idSerie;
    private int epsAssistidos;
    private String avaliacao;

    public Avaliacao(String login, int idSerie, int epsAssistidos, String avaliacao) {
        this.login = login;
        this.idSerie = idSerie;
        this.epsAssistidos = epsAssistidos;
        this.avaliacao = avaliacao;
    }

    public Avaliacao(){
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public int getEpsAssistidos() {
        return epsAssistidos;
    }

    public void setEpsAssistidos(int epsAssistidos) {
        this.epsAssistidos = epsAssistidos;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}

