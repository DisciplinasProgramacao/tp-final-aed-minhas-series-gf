package core;

import java.io.IOException;
import java.util.Arrays;

import core.entity.Avaliacao;
import core.entity.Espectador;
import core.entity.Serie;
import core.repository.EspectadorRepository;
import core.repository.SeriesRepository;
import core.structure.Lista;
import core.structure.Nodo;
import core.utils.Menu;

public class App {

    public static void main(String[] args) throws Exception {
        SeriesRepository seriesRepository = new SeriesRepository();
        seriesRepository.loadSerie();
        EspectadorRepository espectadorRepository = new EspectadorRepository();
        Espectador[] espectador = espectadorRepository.loadEspectador();

        for (Espectador espectador1 : espectador) {
            System.out.println(espectador1.getLogin());
            Lista<Avaliacao> avaliacaoLista = espectador1.getSeries();

            avaliacaoLista.forEach(avaliacao -> {
                System.out.println(avaliacao.getLogin());
                System.out.println(avaliacao.getAvaliacao());
                System.out.println(avaliacao.getEpsAssistidos());
                System.out.println(avaliacao.getIdSerie());
            });

        }
//        Menu menu = new Menu();
//        menu.mainMenu();


    }

}
