package ExerciciosLaboratorios;

import stack.ArrayStack;
import stack.Stack;

import java.util.Scanner;

public class Diamantes {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String sequencia = " ";
        int[] quantidadeDiamantes = new int[N];

        for (int i = 0; i < N; i++) {
            sequencia = s.nextLine();
            quantidadeDiamantes[i] = extrairDiamante(sequencia);
        }

        for (int i = 0; i < quantidadeDiamantes.length; i++) {
            System.out.println(quantidadeDiamantes[i]);
        }
    }

    static int extrairDiamante(String sequencia) {
        Stack<String> pilha = new ArrayStack<>();
        int diamantes = 0;

        for (char seq : sequencia.toCharArray()) {
            if (seq == '<') {
                pilha.push(sequencia);
            } else if (seq == '>' && !pilha.isEmpty()) {
                pilha.pop();
                diamantes++;
            }
        }

        return diamantes;
    }

}


