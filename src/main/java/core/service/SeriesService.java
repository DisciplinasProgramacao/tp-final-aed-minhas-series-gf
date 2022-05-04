package core.service;

import java.io.IOException;
import java.util.Scanner;
import core.repository.SeriesRepository;
import core.entity.Serie;

public class SeriesService {

    public final SeriesRepository seriesRepository = new SeriesRepository();
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
}
