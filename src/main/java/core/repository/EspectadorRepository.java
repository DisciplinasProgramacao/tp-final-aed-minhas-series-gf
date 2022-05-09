package core.repository;

import core.entity.Avaliacao;
import core.entity.Espectador;
import core.entity.Serie;
import core.structure.Lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EspectadorRepository {

    static final File arch = new File("espectadores.txt");

    private AvaliacoesRepository avaliacoesRepository = new AvaliacoesRepository();

    private SeriesRepository seriesRepository = new SeriesRepository();
    public Espectador logged = null;

    public Espectador[] loadEspectador() throws Exception {

        Scanner archReader = new Scanner(arch);
        String[] espectadorData = new String[500];
        int i = 0;

        while (archReader.hasNextLine()) {
            String data = archReader.nextLine();
            espectadorData[i] = data;
            i++;
        }

        Espectador[] espectador = new Espectador[i];

        for (int j = 0; j < espectador.length; j++) {
           /*
                file data appearance:
                   Nome;Login
                    [0];[1]
           */
            String[] vet = espectadorData[j].split(";");
            espectador[j] = new Espectador();
            espectador[j].setNome(vet[0]);
            espectador[j].setLogin(vet[1]);
        }

        archReader.close();

        Lista<Avaliacao> avaliacaoLista = avaliacoesRepository.loadAvaliacao();
        Lista<Avaliacao> avaliacaoEspectador = new Lista<>();


        avaliacaoLista.forEach(avaliacao -> {
            for (int j = 0; j < espectador.length; j++) {
                int finalJ = j;
                if (avaliacao.getLogin().equals(espectador[finalJ].getLogin())) {
                    avaliacaoEspectador.insereFim(avaliacao);
                    espectador[finalJ].setSeries(avaliacaoEspectador);
                }
            }
        });
        return espectador;
    }

    public Espectador login(String login) throws Exception {
        Espectador[] espectadores = loadEspectador();

        for (Espectador spec : espectadores) {
            if (login.equals(spec.getLogin())) {
                logged = spec;
                return logged;
            }
        }
        return null;
    }

    public Espectador getLogged() {
        return logged;
    }

    public void setLogged(Espectador logged) {
        this.logged = logged;
    }

    public void logout() throws FileNotFoundException {
        logged = null;
    }

    public Espectador procuraEspectador(String login) throws Exception {
        Espectador[] espectadores = loadEspectador();

            for(int i=0; i<espectadores.length; i++){

                if(login.equals(espectadores[i].getLogin())){
                    return espectadores[i];
                }
            }
            
        return null;
    }

    public void exibirMinhasSeries(String login) throws Exception {
       Espectador espectador = procuraEspectador(login);

       Lista<Avaliacao> avaliacaoLista = espectador.getSeries();

       avaliacaoLista.forEach(avaliacao -> {
           System.out.println("Avaliador: " + avaliacao.getLogin());
           System.out.println("Eps assistidos: " + avaliacao.getEpsAssistidos());
           System.out.println("Avaliação: "+ avaliacao.getAvaliacao());
           Serie serie = seriesRepository.serieHelp(String.valueOf(avaliacao.getIdSerie()));
           System.out.println(serie == null ? "Serie não encontrada" : serie.getNome()); //< expressao ? true : false >
       });

    }

}
