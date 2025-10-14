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
        System.out.println("Resultado: " + pila.pop());
    }

    private static String invertir(String op1) {
        Stack<String> pilaAuxiliar = new Stack<String>();
        String invertido = "";

        for (int i = 0; i < op1.length(); i++) {
            pilaAuxiliar.push(String.valueOf(op1.charAt(i)));
        }

        while (!pilaAuxiliar.isEmpty()) {
            invertido += pilaAuxiliar.pop();
        }
        return invertido;
    }

    private static Stack<String> evaluarExpresion(String[] expr) {
        String cad, op1, op2;
        Stack<String> resultado;
        Stack<String> pila = new Stack<String>();
        for (int i = 0; i < expr.length; i++) {
            cad = expr[i];
            if (cad.equals("+")) {
                op2 = pila.pop();
                op1 = pila.pop();
                pila.push(op1 + op2);
            } else if (cad.equals("@")) {
                op1 = pila.pop();
                pila.push(invertir(op1));
            } else {
                pila.push(cad);
            }
        }
        return pila;
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
