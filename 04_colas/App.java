
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

    public static void main(String[] args) {
        Queue<GameRequest> premiunLargo = new PriorityBlockingQueue<>();
        Queue<GameRequest> premiunCorto = new PriorityBlockingQueue<>();
        Queue<GameRequest> noPremiunLargo = new LinkedBlockingQueue<>();
        Queue<GameRequest> noPremiunCorto = new LinkedBlockingQueue<>();

        readRequests("player_requests.csv", premiunLargo, premiunCorto, noPremiunLargo, noPremiunCorto);

        doMatchs();
    }

    public static int doMatchs(){
        final int premiun = 2;
        final int noPremiun = 1;
        
        return 0;
    }

    public static int readRequests(String filename, Queue<GameRequest> premiunLargo,
            Queue<GameRequest> premiunCorto, Queue<GameRequest> noPremiunLargo,
            Queue<GameRequest> noPremiunCorto) {
            int nReaded = 0;
        try {
            FicheroSecuencial<GameRequest> sf =
                    new FicheroSecuencial<GameRequest>("player_requests.csv", ";");
            sf.skip();
            System.out.println("""
            =====================
            Reading game requests
            =====================""");
            while (!sf.isEndOfFile()) {
                nReaded++;
                GameRequest request = new GameRequest();
                sf.read(request);
                System.out.println("New request: " + request);
                addRequest(request, premiunLargo, premiunCorto, noPremiunLargo,
                        noPremiunCorto);
            }
            sf.close();
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return nReaded;
    }

    public static void addRequest(GameRequest request, Queue<GameRequest> premiunLargo,
            Queue<GameRequest> premiunCorto, Queue<GameRequest> noPremiunLargo,
            Queue<GameRequest> noPremiunCorto) {
        if (request.isPremiumSubscription()) {
            if (request.getMatchType() == 'L') {
                premiunLargo.add(request);
            } else {
                premiunCorto.add(request);
            }
        } else {
            if (request.getMatchType() == 'L') {
                noPremiunLargo.add(request);
            } else {
                noPremiunCorto.add(request);
            }
        }
    }
}


