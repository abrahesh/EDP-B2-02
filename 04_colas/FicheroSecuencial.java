import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FicheroSecuencial<T extends FicheroSecuencialReader> {
    private File file;
    private Scanner scanner;
    private String separator;

    public FicheroSecuencial(String nombreFichero, String separator) throws FileNotFoundException {
        file = new File(nombreFichero);
        scanner = new Scanner(file);
        this.separator = separator;
    }

    public void read(T t){
        String[] data = scanner.nextLine().split(separator);
        t.readData(data);
    }

    public void skip(){
        scanner.nextLine();
    }
    public void close(){
        scanner.close();
    }
    public boolean isEndOfFile(){
        return !scanner.hasNextLine();
    }
    
}
