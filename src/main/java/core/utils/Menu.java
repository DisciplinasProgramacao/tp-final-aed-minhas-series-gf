package core.utils;

import core.service.SeriesService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private SeriesService serieService = new SeriesService();

    public void mainMenu() throws Exception {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("Digite a opção desejada: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Consultar série");
            System.out.println("2 - Adicionar nova série");
            System.out.println("3 - ordenar series");
            System.out.println("4 - fazer Login");
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
                    serieService.sort();
                    break;
                case 4:

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}
