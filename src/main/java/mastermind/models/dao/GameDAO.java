package mastermind.models.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import mastermind.models.Game;

public class GameDAO implements DAO {

    private Game game;
    private final Gson gson;

    GameDAO(Game game) {
        this.game = game;
        gson = new Gson();
    }

    public void save(FileWriter fileWriter) {
        String json = gson.toJson(game);

        try {
            fileWriter.write(json);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(BufferedReader bufferedReader) {
        try {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            game =  gson.fromJson(sb.toString(), Game.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Game getGame() {
        return game;
    }
}
