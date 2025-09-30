import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class practicapilas {
    private static final Scanner scanner = new Scanner(System.in);

    private static String[] leerEntrada() {
        String linea = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(linea);
        String[] entrada = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            entrada[i++] = st.nextToken();
        }
        return entrada;
    }
}
