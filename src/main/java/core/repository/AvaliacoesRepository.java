package core.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import core.entity.Avaliacao;
import core.entity.Serie;
import core.structure.Lista;

public class AvaliacoesRepository {
    
    static final File arch = new File("avaliacoes.txt");
    private SeriesRepository seriesRepository = new SeriesRepository();
    public Scanner in = new Scanner(System.in);
    private double soma;




    public Lista<Avaliacao> loadAvaliacao() throws FileNotFoundException {
        Scanner archReader = new Scanner(arch);
        String[] avaliacaoData = new String[500];
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
       Serie theSerie =  seriesRepository.serieHelp(nome);

       theSerie.getAvaliacao().forEach(avaliacao -> {
           soma += Double.parseDouble(avaliacao.getAvaliacao());
       });

        media = soma/theSerie.getAvaliacao().size();

        return media;
    }
}
