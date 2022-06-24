package core.service;

import java.io.IOException;
import java.util.Scanner;
import core.repository.AvaliacoesRepository;
import core.repository.SeriesRepository;
import core.entity.Serie;

public class SeriesService {

    public final SeriesRepository seriesRepository = new SeriesRepository();
    public final AvaliacoesRepository avaliacoesRepository = new AvaliacoesRepository();
    public Scanner in = new Scanner(System.in);

    public void addNewSerie() throws IOException {

        Serie serieToAdd = new Serie();

        System.out.println("Qual o nome da série?");
        String nomeNew = in.nextLine();
        serieToAdd.setNome(nomeNew);

        System.out.println("Qual a data de lançamento da série?");
        String dataNew = in.nextLine();
        serieToAdd.setDataLancamento(dataNew);

        System.out.println("Qual a quantidade de episodios da série?");
        int epsNew = in.nextInt();
        serieToAdd.setQtdEps(epsNew);

        seriesRepository.addNewSerie(serieToAdd);
    }

    public void searchSerie() throws Exception {
        System.out.println("Qual o nome da série?");
        String nomeNew = in.nextLine();
        seriesRepository.findSerie(nomeNew);
    }

    public void sort() throws IOException {
        System.out.println("ordenando o vetor usando bubble sort, o melhor e pior metodo de todos");
        //seriesRepository.ordena();
    }

    public void mediaAvalicao() throws Exception{
        System.out.println("Qual o nome da série?");
        String nomeNew = in.nextLine();
        double media = avaliacoesRepository.mediaAvaliacoes(nomeNew);

        if (media == -1){
            System.out.println("Serie não encontrada ou não possui avaliações");
        }
        else {
            System.out.printf("Média de avaliações: %.2f", media);
        }

        System.out.println();
    }

    public void mediaSeriesPorEspectador() throws Exception {
        System.out.println("Media de series por espectadores " + avaliacoesRepository.mediaSeriesPorEspectador());
    }

    public void melhoresSeries() throws Exception {
        avaliacoesRepository.topSeries();
    }
}
