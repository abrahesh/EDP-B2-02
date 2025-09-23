import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        try {
            FicheroSecuencial<Satelite> sf = new FicheroSecuencial<Satelite>("weather.csv",";"){
                sf.skip();
                while(!sf.isEndOfFile()){
                    Satelite sat = new Satelite();
                    sf.read(sat);
                    if(sat.getMeanMotion() >= 10){
                        System.out.println(sat);
                    }
                }
                sf.close();
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
