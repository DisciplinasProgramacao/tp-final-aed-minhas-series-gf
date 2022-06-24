package core.utils;

import core.service.EspectadorService;
import core.service.SeriesService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private SeriesService serieService = new SeriesService();
    private EspectadorService espectadorService = new EspectadorService();


    public void mainMenu() throws Exception {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("Digite a opção desejada: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Consultar série");
            System.out.println("2 - Adicionar nova série");
            System.out.println("3 - Ordenar séries");
            System.out.println("4 - Login");
            System.out.println("5 - Logout");
            System.out.println("6 - Ver Minhas Series (Precisa estar logado)");
            System.out.println("7 - Ver Média de avaliações de uma série");
            System.out.println("8 - Ver Média de series por espectador");
            System.out.println("9 - Ver 10 melhores séries");

            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Ate mais :)");
                    break;
                case 1:
                    serieService.searchSerie();
                    break;
                case 2:
                    serieService.addNewSerie();
                    break;
                case 3:
                    //serieService.sort();
                    System.out.println("Funcionalidade Interditada :P");
                    break;
                case 4:
                    espectadorService.fazerLogin();
                    break;
                case 5:
                    espectadorService.fazerLogout();
                    break;
                case 6:
                    espectadorService.verMinhasSeries();
                    break;
                case 7:
                    serieService.mediaAvalicao();
                    break;
                case 8:
                    serieService.mediaSeriesPorEspectador();
                    break;
                case 9:
                    serieService.melhoresSeries();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}
