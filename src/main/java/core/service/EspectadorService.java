package core.service;

import core.entity.Espectador;
import core.repository.EspectadorRepository;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class EspectadorService {

    public Scanner in = new Scanner(System.in);

    public EspectadorRepository espectadorRepository = new EspectadorRepository();
    public void fazerLogin() throws FileNotFoundException {
        System.out.println("Insira seu Login: ");
        String login = in.nextLine();

        Espectador response = espectadorRepository.login(login);

        if (response==null){
            System.out.println("Login nao encontrado");
        }
        else {
            System.out.printf("Bem vindo" + response.getNome());
        }
    }
}
