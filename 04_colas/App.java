
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

    public static void main(String[] args) {
        Queue<GameRequest> premiunLargo = new PriorityBlockingQueue<>();
        Queue<GameRequest> premiunCorto = new PriorityBlockingQueue<>();
        Queue<GameRequest> noPremiunLargo = new LinkedBlockingQueue<>();
        Queue<GameRequest> noPremiunCorto = new LinkedBlockingQueue<>();

        readRequests("player_requests.csv", premiunLargo, premiunCorto, noPremiunLargo,
                noPremiunCorto);

        doMatchs(premiunLargo, premiunCorto, noPremiunLargo, noPremiunCorto);
    }

    public static int doMatchs(Queue<GameRequest> premiunLargo, Queue<GameRequest> premiunCorto,
            Queue<GameRequest> noPremiunLargo, Queue<GameRequest> noPremiunCorto) {
        final int premiun = 2;
        final int noPremiun = 1;
        GameRequest player1;
        GameRequest player2;
        int nMatchs = 0;

        System.out.println("""
                =====================
                Making the matchs
                =====================""");

        while (premiunLargo.size() >= 2 || premiunCorto.size() >= 2 || noPremiunLargo.size() >= 2
                || noPremiunCorto.size() >= 2) {
            for (int i = 0; i < premiun && premiunLargo.size() >= 2; i++) {
                player1 = premiunLargo.poll();
                player2 = premiunLargo.poll();
                nMatchs++;
                System.out.printf("[PREMIUN] Long match between %s (%d) and %s (%d)\n", player1.getPlayerID(), player1.getSkillLevel(), player2.getPlayerID(), player2.getSkillLevel());
            }
            for (int i = 0; i < premiun && premiunCorto.size() >= 2; i++) {
                player1 = premiunCorto.poll();
                player2 = premiunCorto.poll();
                nMatchs++;
                System.out.printf("[PREMIUN] Short match between %s (%d) and %s (%d)\n", player1.getPlayerID(), player1.getSkillLevel(), player2.getPlayerID(), player2.getSkillLevel());
            }
            for (int i = 0; i < noPremiun && noPremiunLargo.size() >= 2; i++) {
                player1 = noPremiunLargo.poll();
                player2 = noPremiunLargo.poll();
                nMatchs++;
                System.out.printf("[NO PREMIUN] Long match between %s (%d) and %s (%d)\n", player1.getPlayerID(), player1.getSkillLevel(), player2.getPlayerID(), player2.getSkillLevel());
            }
            for (int i = 0; i < noPremiun && noPremiunCorto.size() >= 2; i++) {
                player1 = noPremiunCorto.poll();
                player2 = noPremiunCorto.poll();
                nMatchs++;
                System.out.printf("[NO PREMIUN] Short match between %s (%d) and %s (%d)\n", player1.getPlayerID(), player1.getSkillLevel(), player2.getPlayerID(), player2.getSkillLevel());
            }
        }

        return nMatchs;
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
                addRequest(request, premiunLargo, premiunCorto, noPremiunLargo, noPremiunCorto);
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


