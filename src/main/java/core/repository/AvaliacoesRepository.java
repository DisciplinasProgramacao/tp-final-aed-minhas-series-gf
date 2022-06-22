package core.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import core.entity.Avaliacao;
import core.entity.Espectador;
import core.entity.Serie;
import core.structure.Lista;

public class AvaliacoesRepository {
    
    static final File arch = new File("avaliacoes.txt");
    private SeriesRepository seriesRepository = new SeriesRepository();
    private double soma;

    public Lista<Avaliacao> loadAvaliacao() throws FileNotFoundException {
        Scanner archReader = new Scanner(arch);
        String[] avaliacaoData = new String[30000];
        int i = 0;

        while (archReader.hasNextLine()) {
            String data = archReader.nextLine();
            avaliacaoData[i] = data;
            i++;
        }

        Lista<Avaliacao> avaliacoes = new Lista<>();
        for (int j = 0; j < i; j++) {
            /*
                 Login;IdSerie;EpsAssistidos;Avaliação
                  [0];  [1];       [2];        [3]
            */
            Avaliacao avaliacao = new Avaliacao();
            String[] vet = avaliacaoData[j].split(";");
            avaliacao.setLogin(vet[0]);
            avaliacao.setIdSerie(Integer.parseInt(vet[1]));
            avaliacao.setEpsAssistidos(Integer.parseInt(vet[2]));
            avaliacao.setAvaliacao(vet[3]);
            avaliacoes.insereFim(avaliacao);
        }

        archReader.close();
        return avaliacoes;
    }

    public double mediaAvaliacoes(String nome) throws Exception{
       double media = 0;
       soma = 0.0;
       Serie theSerie = seriesRepository.findSerieByName(nome);

       if (theSerie.getAvaliacao() == null)
           return -1;

       theSerie.getAvaliacao().forEach(avaliacao -> {
           soma += Double.parseDouble(avaliacao.getAvaliacao());
       });

        media = soma/theSerie.getAvaliacao().size();

        return media;
    }

    public double mediaSeriesPorEspectador() throws Exception {
        EspectadorRepository espectadorRepository = new EspectadorRepository();
        Lista<Serie> serieLista = seriesRepository.loadSerie();
        Espectador[] espectadores = espectadorRepository.loadEspectador();

        int seriePerEspectador = 0;

//        for (int i = 0; i < espectadores.length; i++) {
//            if (espectadores[i].getSeries() != null || espectadores[i].getSeries().size() != 0 || espectadores[i] != null)
//                seriePerEspectador += espectadores[i].getSeries().size();
//        }

        return espectadores.length/serieLista.size();
    }
}
