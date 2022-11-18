package com.desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws Exception {
        List<Integer> resultados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        while(tamanho != 0) {
            int bolas[][] = new int[tamanho][tamanho];
            int limite_bolas = 1;
            for (int i = 0; i < bolas.length; i++) {
                String bolas_entradas[] = sc.nextLine().split(" ");
                if (bolas_entradas.length == limite_bolas) {
                    for (int j = 0; j < limite_bolas; j++) {
                        bolas[i][j] = Integer.parseInt(bolas_entradas[j]);
                    }
                    limite_bolas++;
                } else {
                    sc.close();
                    throw new  Exception("Entrada com mais bolas do que devia.");
                }
            }


            resultados.add(calculaPremio(bolas));
            tamanho = Integer.parseInt(sc.nextLine());
        }
        resultados.forEach(System.out::println);
        sc.close();
    }

    public static int calculaPremio(int bolas[][]){
        int limite_bolas = bolas.length + 1;
        int memoria[][] = new int[bolas.length][bolas.length];
        for (int linha = bolas.length - 1; linha >= 0; linha--) {
            for (int coluna = 0; coluna < limite_bolas - 1; coluna++) {
                if (linha == bolas.length - 1){
                    memoria[linha][coluna] = bolas[linha][coluna];
                } else {
                    if (memoria[linha + 1][coluna] != Integer.MIN_VALUE && (memoria[linha + 1][coluna] + memoria[linha + 1][coluna + 1]) > memoria[linha + 1][coluna + 1] && 
                    (memoria[linha + 1][coluna] + memoria[linha + 1][coluna + 1]) > memoria[linha + 1][coluna]) {
                        memoria[linha][coluna] = bolas[linha][coluna] + memoria[linha + 1][coluna] + memoria[linha + 1][coluna + 1];
                        memoria[linha + 1][coluna] = Integer.MIN_VALUE;
                        memoria[linha + 1][coluna + 1] = Integer.MIN_VALUE;
                    } else if (memoria[linha + 1][coluna] != Integer.MIN_VALUE && memoria[linha + 1][coluna] > memoria[linha + 1][coluna + 1] && memoria[linha + 1][coluna] > 0) {
                        memoria[linha][coluna] = bolas[linha][coluna] + memoria[linha + 1][coluna];
                        memoria[linha + 1][coluna] = Integer.MIN_VALUE;
                    } else if (memoria[linha + 1][coluna + 1] != Integer.MIN_VALUE && memoria[linha + 1][coluna] < memoria[linha + 1][coluna + 1] && memoria[linha + 1][coluna + 1] > 0) {
                        memoria[linha][coluna] = bolas[linha][coluna] + memoria[linha + 1][coluna + 1];
                        memoria[linha + 1][coluna + 1] = Integer.MIN_VALUE;
                    } else {
                        memoria[linha][coluna] = bolas[linha][coluna];
                    }
                }
            }
            limite_bolas--;
        }
        if (memoria[0][0] > 0) {
            return memoria[0][0];
        } else {
            return 0;
        }
    }
    
}
