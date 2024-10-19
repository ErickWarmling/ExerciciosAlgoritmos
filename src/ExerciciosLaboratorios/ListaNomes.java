package ExerciciosLaboratorios;

import java.util.*;
import queue.ArrayQueue;

public class ListaNomes {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String[] nomes = new String [N];

        for (int i = 0; i < N; i++) {
            nomes[i] = s.next();
            s.nextLine();
        }

        ListaNomes listaNomes = new ListaNomes();
        listaNomes.ordenarNomes(nomes);

    }

    public void ordenarNomes(String[] nomes) {
        List<String>[] nomesPorTamanho = new ArrayList[11];

        for (int i = 2; i <= 10; i++) {
            nomesPorTamanho[i] = new ArrayList<>();
        }

        for (String nome : nomes) {
            int tamanhoNome = nome.length();
            nomesPorTamanho[tamanhoNome].add(nome);
        }

        boolean aindaTemNomes = true;

        while (aindaTemNomes) {
            aindaTemNomes = false;
            ArrayQueue<String> linha = new ArrayQueue<>();

            for (int tamanho = 2; tamanho <= 10; tamanho++) {
                if (!nomesPorTamanho[tamanho].isEmpty()) {
                    linha.enqueue(nomesPorTamanho[tamanho].remove(0));
                    aindaTemNomes = true;
                }
            }

            if (!linha.isEmpty()) {
                System.out.println(linha);
            }
        }
    }

}
