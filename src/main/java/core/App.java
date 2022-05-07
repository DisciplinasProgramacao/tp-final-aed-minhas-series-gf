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
        Lista<Serie> series = seriesRepository.loadSerie();
        EspectadorRepository espectadorRepository = new EspectadorRepository();
        Espectador[] espectador = espectadorRepository.loadEspectador();

//        for (Espectador espectador1 : espectador) {
//            System.out.println(espectador1.getLogin());
//            Lista<Avaliacao> avaliacaoLista = espectador1.getSeries();
//
//            avaliacaoLista.forEach(avaliacao -> {
//                System.out.println(avaliacao.getLogin());
//                System.out.println(avaliacao.getAvaliacao());
//                System.out.println(avaliacao.getEpsAssistidos());
//                System.out.println(avaliacao.getIdSerie());
//            });
//
//        }

      /*  series.forEach(serie -> {
            System.out.println("id da serie : " + serie.getId());
            System.out.println("Nome da serie: " + serie.getNome());
            System.out.println("Quantidade de eps: "+serie.getQtdEps());
            System.out.println("Dta lancamento: " + serie.getDataLancamento());
            if (serie.getAvaliacao()==null){
                return;
            }
            serie.getAvaliacao().forEach(avaliacao -> {
                System.out.println("\t\tId da serie: "+ avaliacao.getIdSerie());
                System.out.println("\t\tAvaliador: " + avaliacao.getLogin());
                System.out.println("\t\tStars: " + avaliacao.getAvaliacao());
            });
        });  */
        Menu menu = new Menu();
        menu.mainMenu();


    }

}
