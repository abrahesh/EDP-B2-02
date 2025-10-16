

public class GameRequest implements FicheroSecuencialReader, Comparable<GameRequest> {
    private String requestID;
    private String playerID;
    private boolean premiumSubscription;
    private int skillLevel;
    private char matchType;

    public GameRequest() {

    }

    public String getRequestID() {
        return requestID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public boolean isPremiumSubscription() {
        return premiumSubscription;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public char getMatchType() {
        return matchType;
    }

    @Override
    public int compareTo(GameRequest other) {
        return Integer.compare(other.skillLevel, this.skillLevel);
    }

    @Override
    public void readData(String[] data) {
        this.requestID = data[0];
        this.playerID = data[1];
        this.premiumSubscription = Boolean.parseBoolean(data[2]);
        this.skillLevel = Integer.parseInt(data[3]);
        this.matchType = data[4].charAt(0);
    }

    @Override
    public String toString() {
        return "request [requestID=" + requestID + ", playerID=" + playerID + ", premiumSubscription="
                + premiumSubscription + ", skillLevel=" + skillLevel + ", matchType=" + matchType + "]";
    }
}
