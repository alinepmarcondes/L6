package br.inatel.cdg.aline;

import br.inatel.cdg.aline.model.Game;
import br.inatel.cdg.aline.model.Plataforma;
import br.inatel.cdg.aline.model.Publisher;
import br.inatel.cdg.aline.service.ServiceGame;
import br.inatel.cdg.aline.utils.CSVUtils;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Path caminho = null;
        try {
            caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<Game> gameList = CSVUtils.readGameCsv(caminho);


        int numLines = gameList.size();
        System.out.println("Número de linhas: " + numLines);

        List<Game> ps4Games = ServiceGame.getListByPlatform(gameList, Plataforma.PS4);

        System.out.println("Número de jogos de ps4: " + ps4Games.size());
        System.out.println("Nome dos jogos de ps4: ");
        ps4Games.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos de ps4
        System.out.println("");
        List<Game> activisionGames = ServiceGame.getByPuBlisher(gameList, Publisher.Activision);
        System.out.println("Número de jogos da activision: " + activisionGames.size());
        System.out.println("Nome dos jogos da activision: ");
        activisionGames.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos da activison

    }

}
