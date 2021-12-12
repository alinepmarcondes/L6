package br.inatel.cdg.aline.service;

import br.inatel.cdg.aline.model.Game;
import br.inatel.cdg.aline.model.Plataforma;
import br.inatel.cdg.aline.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class ServiceGame {

    public static List<Game> getListByPlatform(List<Game> games, Plataforma platform){
        List<Game> gamesByPlatform = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPlatform().equals(platform.name()))).
                forEach(game -> gamesByPlatform.add(game));

        return gamesByPlatform;

    }


    public static List<Game> getByPuBlisher(List<Game> games ,
                                            Publisher publisher){
        List<Game> gamesByPublisher = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))).
                forEach(game -> gamesByPublisher.add(game));

        return gamesByPublisher;
    }

}
