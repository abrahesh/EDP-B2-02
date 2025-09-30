import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<String> pila;
        String[] expr = leerExpresion();
        pila = evaluarExpresion(expr);
    }

    private static Stack<String> invertir(Stack<String> pila) {
        Stack<String> pilaAuxiliar = new Stack<String>();
        for (int i = 0; i < pila.size(); i++) {
            pilaAuxiliar.push(pila.pop());
        }
        return pilaAuxiliar;
    }

    private static Stack<String> evaluarExpresion(String[] expr){
        String cad, resultado, op1, op2;
    }

    private static String[] leerExpresion() {
        System.out.println("Expresión a evaluar:");
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
