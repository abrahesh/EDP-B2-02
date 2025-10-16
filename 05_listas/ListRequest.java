public class ListRequest implements FicheroSecuencialReader {
    private String Artist;
    private String Genre;
    private int day;
    private String Stage;
    private int duration;
    private int popularity;

    public ListRequest() {
        
    }

    public String getArtist() {
        return Artist;
    }

    public String getGenre() {
        return Genre;
    }

    public int getDay() {
        return day;
    }

    public String getStage() {
        return Stage;
    }

    public int getDuration() {
        return duration;
    }

    public int getPopularity() {
        return popularity;
    }

    @Override
    public void readData(String[] data) {
        this.Artist = data[0];
        this.Genre = data[1];
        this.day = Integer.parseInt(data[2]);
        this.Stage = data[3];
        this.duration = Integer.parseInt(data[4]);
        this.popularity = Integer.parseInt(data[5]);
    }

    @Override
    public String toString() {
        return "ListRequest [Artist=" + Artist + ", Genre=" + Genre + ", day=" + day + ", Stage=" + Stage
                + ", duration=" + duration + ", popularity=" + popularity + "]";
    }
}
