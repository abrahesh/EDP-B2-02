import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FicheroSecuencial {
    private File file;
    private Scanner scanner;

    public FicheroSecuencial(String nombreFichero) throws FileNotFoundException{
        file = new File(nombreFichero);
        scanner = new Scanner(file);
    }
    
    public String readLine(){
        return scanner.nextLine();
    }

    public void skip(){
        scanner.nextLine();
    }
    public void close(){
        scanner.close();
    }
    public boolean isEOF(){
        return !scanner.hasNextLine();
    }
    
}
