package core.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import core.entity.Serie;
import core.structure.Lista;
import core.structure.Nodo;
import core.utils.Menu;

public class SeriesRepository {

    static final File arch = new File("series.txt");

    private Lista<Serie> loadSerie() throws Exception {
        Lista<Serie> serie = insertRandomValues();
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

    public void findSerie(String nome) throws Exception {
        Lista<Serie> series = loadSerie();

        while(series.getPrimeiro() != null){

        }
        series.procura(nome);

        System.out.println("Nao encontramos a serie que voce procura, tente inseri-la :)");
    }

//    public Serie[] ordena() throws IOException {
//        Lista<Serie> series = leitorSeries();
//        FileWriter fWrtier = new FileWriter(arch, true);
//
//        Serie aux = new Serie();
//
//        for (int i = 0; i < series.length - 1; i++) {
//            for (int j = 0; j < series.length - 1 - i; j++) {
//                if (series[j].getId() > series[j + 1].getId()) {
//                    aux = series[j];
//                    series[j] = series[j + 1];
//                    series[j + 1] = aux;
//                }
//            }
//        }
//
//        for (int i = 0; i < series.length; i++) {
//
//            fWrtier.write(series[i].toString());
//            System.out.println(series[i].toString());
//        }
//
//        fWrtier.close();
//
//        return series;
//    }

    public static Lista<Serie> insertRandomValues() throws Exception {

        Nodo<Serie> serieNodo = new Nodo<>();
        Lista<Serie> series = new Lista<>();
        Random gerador = new Random();
        int aux = 1110;

        if (series.getPrimeiro() == null) {
            FileWriter fWrtier = new FileWriter(arch);
            for (int i = 0; i < 100; i++) {
                aux += i;
                serieNodo.setValor(new Serie(gerador.nextInt(1000) + aux - 1000, "serieTeste", "01/01/2000", 999));
                series.insereFim(serieNodo);

                fWrtier.write(series.getUltimo().toString());

            }

            fWrtier.close();
            return series;

            //todo make sizeOf better
        } else if (series.sizeOf(series) < 500) {
            FileWriter fWrtier = new FileWriter(arch, true);

            for (int i = 0; i < 100; i++) {
                aux += i;
                serieNodo.setValor(new Serie(gerador.nextInt(1000) + aux - 1000, "serieTeste", "01/01/2000", 999));
                series.insereFim(serieNodo);

                fWrtier.append(series.getUltimo().toString());
            }

            fWrtier.close();
            return series;
        }
        return series;
    }

    public static Lista<Serie> leitorSeries() throws Exception {

        Scanner archReader = new Scanner(arch);
        String[] serieData = new String[500];
        int i = 0;

        while (archReader.hasNextLine()) {
            String data = archReader.nextLine();
            serieData[i] = data;
            i++;
        }

        Lista<Serie> serie = new Lista<>();

        if (i == 0) {
            serie = insertRandomValues();
            archReader.close();
            return serie;
        }

        for (int j = 0; j < serie.sizeOf(serie); j++) {
            /*
             * ID; NOME ; DATA ; EPS
             * 01 serieDaora 31/02/2001 50
             * [0] [1] [2] [3]
             *
             */

            String[] vet = serieData[j].split(";");
            Serie serie1 = new Serie(Integer.parseInt(vet[0]),vet[1], vet[2], Integer.parseInt(vet[3]));
            Nodo<Serie> serieNodo = new Nodo<>();
            serieNodo.setValor(serie1);
            serie.insereInicio(serieNodo);

        }

        archReader.close();
        return serie;
    }

}