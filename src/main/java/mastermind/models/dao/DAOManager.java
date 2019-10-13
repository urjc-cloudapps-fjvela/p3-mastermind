package mastermind.models.dao;

import java.io.*;
import java.nio.file.Paths;

import mastermind.models.Session;
import mastermind.models.StateValue;

public class DAOManager {

    public static final String FILE_EXTENSION = ".mastermind";

    public static final String DIRECTORY = Paths.get(System.getProperty("user.dir"), "games").toString();

    private static File directory;

    static {
        DAOManager.directory = new File(DAOManager.DIRECTORY);
        if (!DAOManager.directory.exists()) {
            DAOManager.directory.mkdir();
        }
    }

    private final Session sessionImplementation;

    private final GameDAO gameDAO;

    public DAOManager(Session sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        gameDAO = new GameDAO(sessionImplementation.getGame());
    }

    public void save(String name) {
        if (!name.endsWith(DAOManager.FILE_EXTENSION)) {
            name = name + DAOManager.FILE_EXTENSION;
        }
        File file = new File(DAOManager.directory, name);
        try {
            FileWriter fileWriter = new FileWriter(file);
            gameDAO.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String name) {
        File file = new File(DAOManager.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            gameDAO.load(bufferedReader);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TO-DO: review this set....
        sessionImplementation.setGame(gameDAO.getGame());
        sessionImplementation.setStateValue(StateValue.IN_GAME);
        if (sessionImplementation.isGameFinished()) {
            sessionImplementation.setStateValue(StateValue.FINAL);
        }
    }

    public String[] getGamesNames() {
        return DAOManager.directory.list();
    }

    public boolean exists(String name) {
        return Paths.get(DIRECTORY, name + FILE_EXTENSION).toFile().exists();
    }
}
