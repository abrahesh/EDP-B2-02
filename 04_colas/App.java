
import java.util.Queue;

public class App {

    public static void main(String[] args) {
        try {
            FicheroSecuencial<GameQueue> sf =
                    new FicheroSecuencial<GameQueue>("player_requests.csv", ";");
            sf.skip();
            while (!sf.isEndOfFile()) {
                GameQueue gameQueue = new GameQueue();
                sf.read(gameQueue);
            }
            sf.close();
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}

