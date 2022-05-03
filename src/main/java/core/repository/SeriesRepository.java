package core.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import core.entity.Serie;
import core.utils.Menu;

public class SeriesRepository {

    static final File arch = new File("series.txt");

    private Serie[] loadSerie() throws IOException {
        Serie[] serie = insertRandomValues();
        serie = leitorSeries();
        return serie;
    }

    // todo add verifications to check serie obj integrity
    public void addNewSerie(Serie serie) throws IOException {
        Random gerador = new Random();
        FileWriter fWriter = new FileWriter(arch, true);

        serie.setId(gerador.nextInt(10000));
        fWriter.append(serie.toString());
        fWriter.close();

        System.out.println("Serie adicionada com sucesso :)");
    }

    /*
     * Esse metodo deveria rodar o vetor series para procurar a serie
     * informada, mas não consegui passar ele como parametro corretamente :(
     */
    public void findSerie(String nomeNew) throws IOException {
        Serie[] series = loadSerie();

        for (int i = 0; i < series.length; i++) {
            if (series[i].getNome().equals(nomeNew)) {
                System.out.println(series[i].toString());
                return;
            }
        }
        System.out.println("Nao encontramos a serie que voce procura, tente inseri-la :)");
    }

    public Serie[] ordena() throws IOException {
        Serie[] series = leitorSeries();
        FileWriter fWrtier = new FileWriter(arch, true);

        Serie aux = new Serie();

        for (int i = 0; i < series.length - 1; i++) {
            for (int j = 0; j < series.length - 1 - i; j++) {
                if (series[j].getId() > series[j + 1].getId()) {
                    aux = series[j];
                    series[j] = series[j + 1];
                    series[j + 1] = aux;
                }
            }
        }

        for (int i = 0; i < series.length; i++) {

            fWrtier.write(series[i].toString());
            System.out.println(series[i].toString());
        }

        fWrtier.close();

        return series;
    }

    public static Serie[] insertRandomValues() throws IOException {

        Serie[] series = new Serie[100];
        Random gerador = new Random();
        int aux = 1110;

        if (series.length == 0) {
            FileWriter fWrtier = new FileWriter(arch);

            for (int i = 0; i < 100; i++) {
                aux += i;
                series[i] = new Serie(gerador.nextInt(1000) + aux - 1000, "serieTeste", "01/01/2000", 999);

                fWrtier.write(series[i].toString());

            }

            fWrtier.close();
            return series;

        } else if (series.length < 500) {
            FileWriter fWrtier = new FileWriter(arch, true);

            for (int i = 0; i < 100; i++) {
                aux += i;
                series[i] = new Serie(gerador.nextInt(1000) + aux - 1000, "serieTeste", "01/01/2000", 999);

                fWrtier.append(series[i].toString());

            }

            fWrtier.close();
            return series;
        }
        return series;
    }

    public static Serie[] leitorSeries() throws IOException {

        Scanner archReader = new Scanner(arch);
        String[] serieData = new String[500];
        int i = 0;

        while (archReader.hasNextLine()) {
            String data = archReader.nextLine();
            serieData[i] = data;
            i++;
        }

        Serie[] serie = new Serie[i];

        if (i == 0) {
            serie = insertRandomValues();
            archReader.close();
            return serie;
        }

        for (int j = 0; j < serie.length; j++) {
            /*
             * ID; NOME ; DATA ; EPS
             * 01 serieDaora 31/02/2001 50
             * [0] [1] [2] [3]
             *
             */

            String[] vet = serieData[j].split(";");
            serie[j] = new Serie();
            serie[j].setId(Integer.valueOf(vet[0]));

            serie[j].setNome(vet[1]);
            serie[j].setDataLancamento(vet[2]);
            serie[j].setQtdEps(Integer.parseInt(vet[3]));

        }

        archReader.close();
        return serie;
    }

}