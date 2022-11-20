package com.desafio;

import java.util.Scanner;

public class Main {
    private int[][] bolas;
    private int[][][] memoria;
    private int[][] soma;
    private int tamanho;

    public Main(int tamanho) {
        this.tamanho = tamanho;
        this.bolas = new int[tamanho + 1][tamanho + 1];
        this.memoria = new int[tamanho + 1][tamanho + 1][2];
        this.soma = new int[tamanho + 1][tamanho + 1];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tamanho = Integer.parseInt(sc.nextLine());
        while (tamanho > 0) {
            Main main = new Main(tamanho);
            for (int i = 1; i <= tamanho; i++) {
                String bolas_entradas[] = sc.nextLine().split(" ");
                for (int j = 1; j <= i; j++) {
                    main.getBolas()[i][j] = Integer.parseInt(bolas_entradas[j - 1]);
                }
                bolas_entradas = null;
            }
            System.out.println(main.calculaPremio());
            main = null;
            tamanho = Integer.parseInt(sc.nextLine());
        }
        sc.close();
    }

    public int calculaPremio() {
        for (int i = 1; i <= tamanho; i++) {
            for (int j = 1; j <= i; j++) {
                this.soma[i][j] = (this.soma[i - 1][j] + this.soma[i - 1][j - 1]
                        - (i - 2 >= 0 ? this.soma[i - 2][j - 1] : 0)) + this.bolas[i][j];
            }
        }
        int ans = 0;
        for (int i = 1; i <= tamanho; i++) {
            for (int j = 1; j <= tamanho; j++) {
                this.memoria[i][j][0] = this.memoria[i][j][1] = 0;
            }
        }
        for (int j = 1; j <= tamanho; j++) {
            for (int i = j; i <= tamanho; i++) {
                this.memoria[i][j][0] = this.soma[i][j];
                this.memoria[i][j][0] = Integer.max(this.memoria[i][j][0],
                        this.memoria[i - 1][j - 1][1] + (this.soma[i][j] - this.soma[i - 1][j - 1]));
                ans = Integer.max(ans, this.memoria[i][j][0]);
            }
            this.memoria[tamanho][j][1] = this.memoria[tamanho][j][0];
            for (int i = tamanho - 1; i >= j; i--) {
                this.memoria[i][j][1] = Integer.max(this.memoria[i + 1][j][1], this.memoria[i][j][0]);
            }
        }
        return ans;
    }

    public int[][] getBolas() {
        return bolas;
    }

    public void setBolas(int[][] bolas) {
        this.bolas = bolas;
    }

    public int[][][] getMemoria() {
        return memoria;
    }

    public void setMemoria(int[][][] memoria) {
        this.memoria = memoria;
    }

    public int[][] getSoma() {
        return soma;
    }

    public void setSoma(int[][] soma) {
        this.soma = soma;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}
