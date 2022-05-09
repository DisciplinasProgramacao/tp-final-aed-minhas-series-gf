package core.service;

import core.entity.Espectador;
import core.repository.EspectadorRepository;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class EspectadorService {

    public Scanner in = new Scanner(System.in);

    public EspectadorRepository espectadorRepository = new EspectadorRepository();
    public void fazerLogin() throws Exception {
        System.out.println("Insira seu Login: ");
        String login = in.nextLine();

        if(espectadorRepository.getLogged()!=null){
            System.out.println("Já tem alguem logado, saia antes de prosseguir");
            return;
        }

        Espectador response = espectadorRepository.login(login);

        if (response==null){
            System.out.println("Login nao encontrado");
        }
        else {
            System.out.printf("Bem vindo" + response.getNome());
        }
    }
    public void fazerLogout() throws FileNotFoundException {

        if (espectadorRepository.getLogged() == null){
            System.out.println("Não tem ningém logado :/");
            return;
        }
        espectadorRepository.logout();
        System.out.println("Até mais o/");
    }
    public void verMinhasSeries() throws Exception {
        if (espectadorRepository.getLogged() == null) {
            System.out.println("Digite seu login: ");
            String login = in.nextLine();
            espectadorRepository.login(login);
        }
        espectadorRepository.exibirMinhasSeries();
    }
}
