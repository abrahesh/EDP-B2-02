import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class Principal {

    private static final int MAIN_START = 14 * 60;
    private static final int RIVER_START = 13 * 60 + 30;
    private static final int BREAK_TIME = 30;
    public static void main(String[] args) {
        List<Artist> day1_Main = new ArrayList<>();
        List<Artist> day1_River = new ArrayList<>();
        List<Artist> day2_Main = new ArrayList<>();
        List<Artist> day2_River = new ArrayList<>();
        List<Artist> day3_Main = new ArrayList<>();
        List<Artist> day3_River = new ArrayList<>();
        readArtists("artists.csv", day1_River, day1_Main, day2_River, day2_Main, day3_River, day3_Main);
    }
   
    public static void addList(Artist artist,List<Artist> day1_River, List<Artist> day1_Main, List<Artist> day2_River, List<Artist> day2_Main, List<Artist> day3_River, List<Artist> day3_Main){
        if(artist.getDay() == 1){
            if(artist.getStage().equals("Main")){
                day1_Main.add(artist);
            }else{
                day1_River.add(artist);
            }
        }
        else if(artist.getDay() == 2){
            if(artist.getStage().equals("Main")){
                day2_Main.add(artist);
            }else{
                day2_River.add(artist);
            }
        }else{
            if(artist.getStage().equals("Main")){
                day3_Main.add(artist);
            }else{
                day3_River.add(artist);
            }
        }
    }

    public static int readArtists(String filename, List<Artist> day1_River, List<Artist> day1_Main, List<Artist> day2_River, List<Artist> day2_Main, List<Artist> day3_River, List<Artist> day3_Main){
        int nReaded = 0;
        try {
            FicheroSecuencial<Artist> sf =
                    new FicheroSecuencial<Artist>(filename, ";");
            sf.skip();
            System.out.println("""
                    =====================
                    Reading Artist
                    =====================""");
            while (!sf.isEndOfFile()) {
                nReaded++;
                Artist artist = new Artist();
                sf.read(artist);
                addList(artist, day1_River, day1_Main, day2_River, day2_Main, day3_River, day3_Main);
            }
            sf.close();
        } catch (java.io.FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return nReaded;
    }


    
}
