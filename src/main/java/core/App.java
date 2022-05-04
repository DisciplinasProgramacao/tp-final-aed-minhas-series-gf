package core;

import java.io.IOException;

import core.entity.Serie;
import core.repository.SeriesRepository;
import core.structure.Lista;
import core.structure.Nodo;
import core.utils.Menu;

public class App {

    public static void main(String[] args) throws Exception {
//      Menu menu = new Menu();
//      menu.mainMenu();
        SeriesRepository seriesRepository = new SeriesRepository();

        Serie serie = new Serie();
        serie.setNome("seriee");
        serie.setDataLancamento("01/01/0111");
        serie.setQtdEps(80);

        seriesRepository.addNewSerie(serie);

        seriesRepository.findSerie(serie.getNome());
    }

}
