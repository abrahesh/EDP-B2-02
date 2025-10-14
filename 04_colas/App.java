
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

    public static void main(String[] args) {
        Queue<GameQueue> premiunLargo = new PriorityBlockingQueue<>();
        Queue<GameQueue> premiunCorto = new PriorityBlockingQueue<>();
        Queue<GameQueue> noPremiunLargo = new LinkedBlockingQueue<>();
        Queue<GameQueue> noPremiunCorto = new LinkedBlockingQueue<>();

        try {
            FicheroSecuencial<GameQueue> sf =
                    new FicheroSecuencial<GameQueue>("player_requests.csv", ";");
            sf.skip();
            while (!sf.isEndOfFile()) {
                GameQueue gameQueue = new GameQueue();
                sf.read(gameQueue);
                if(gameQueue.isPremiumSubscription() == true){
                    if(gameQueue.getMatchType() == 'L'){
                        premiunLargo.offer(gameQueue);
                    }else if(gameQueue.getMatchType() == 'S'){
                        premiunCorto.offer(gameQueue);
                    }
                }else if(gameQueue.isPremiumSubscription() == false){
                    if(gameQueue.getMatchType() == 'L'){
                        noPremiunLargo.offer(gameQueue);
                    }else if(gameQueue.getMatchType() == 'S'){
                        noPremiunCorto.offer(gameQueue);
                    }
            }
        }
            sf.close();
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}

