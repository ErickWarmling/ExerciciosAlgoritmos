package ExerciciosLaboratorios;

import stack.Stack;
import stack.ArrayStack;

public class JogoBeisebol {

    public static void main(String[] args) {
        String[] pontuacoes = {"5", "2", "C", "D", "+"};
        int resultado = calculaPontuacao(pontuacoes);
        System.out.println(resultado);
    }

    static int calculaPontuacao(String[] pontuacoes) {
        Stack<Integer> pilha = new ArrayStack<>();

        for (String pontuacao : pontuacoes) {
            try {
                pilha.push(Integer.parseInt(pontuacao));
            } catch (Exception e) {
                if (pontuacao.equalsIgnoreCase("+")) {
                    if (pilha.size() >= 2) {
                        int ultimaPontuacao = pilha.pop();
                        int penultimaPontuacao = pilha.pop();
                        pilha.push(penultimaPontuacao);
                        pilha.push(ultimaPontuacao);
                        pilha.push(ultimaPontuacao + penultimaPontuacao);
                    }
                } else if (pontuacao.equalsIgnoreCase("D")) {
                    if (!pilha.isEmpty()) {
                        pilha.push(pilha.top() * 2);
                    }
                } else if (pontuacao.equalsIgnoreCase("C")) {
                    pilha.pop();
                }
            }
        }

        int somaPontuacao = 0;
        while (!pilha.isEmpty()) {
            somaPontuacao += pilha.pop();
        }
        return somaPontuacao;
    }

}