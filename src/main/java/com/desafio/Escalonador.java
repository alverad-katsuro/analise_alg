package com.desafio;

import java.util.Arrays;

public class Escalonador {
    public static void main(String[] args) {
        int tempo[] = {1,2,5,7,9};
        System.out.println(Scheduling(tempo, 5));
    }

    public static int Scheduling(int tempoServico[], int totalCliente) { // Θ(n)
        Arrays.sort(tempoServico);                      // Θ(nlog(n)) -> Segundo a Oracle QuickSort com 2 pivores.
        int acumulador = 0;                             // Θ(1)
        int tempoTotal = 0;                             // Θ(1)
        for (int i = 0; i < totalCliente; i++) {        // Θ(totalCliente)
            acumulador += tempoServico[i];              // Θ(totalCliente-1)
            tempoTotal += acumulador;                   // Θ(totalCliente-1)
        }
        return tempoTotal;                              // Θ(1)
    }
}
