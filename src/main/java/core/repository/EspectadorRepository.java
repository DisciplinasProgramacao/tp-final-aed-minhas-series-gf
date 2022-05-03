package core.repository;

import core.entity.Espectador;
import core.entity.Serie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EspectadorRepository {

    static final File arch = new File("espectadores.txt");


    public Espectador[] loadEspectador() throws FileNotFoundException {

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
        return espectador;
    }
}