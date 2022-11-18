package com.desafio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void calculaPremio() {
        int bolas[][] = {
                        {3,0,0,0},
                        {-5,3,0,0},
                        {-8,2,-8,0},
                        {3,9,-2,7}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 7D);
    }

    @Test
    public void calculaPremio2() {
        int bolas[][] = {
                        {-2,0},
                        {1,-10}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 0);
    }
    

    @Test
    public void calculaPremio3() {
        int bolas[][] = {
                        {1,0,0},
                        {-5,3,0},
                        {6,-4,1}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 6);
    }

    @Test
    public void calculaPremio4() {
        int bolas[][] = {
                        {-1,0,0},
                        {-1,-1,0},
                        {-1,-1,-1}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 0);
    }

    @Test
    public void calculaPremio5() {
        int bolas[][] = {
                        {1,0,0},
                        {1,1,0},
                        {1,1,1}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 6);
    }

    @Test
    public void calculaPremio7() {
        int bolas[][] = {
                        {1,0,0},
                        {1,1,0},
                        {1,1,1}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 6);
    }

    @Test
    public void calculaPremio8() {
        int bolas[][] = {
                        {1,0,0},
                        {-200,2,0},
                        {100,1,1}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 4);
    }

    @Test
    public void calculaPremio9() {
        int bolas[][] = {
                        {-1,0,0,0},
                        {-1,2,0,0},
                        {-1,-1,-1,0},
                        {-1,-1,-1,3}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 3);
    }

    @Test
    public void calculaPremio10() {
        int bolas[][] = {
                            {-1,0,0,0},
                            {-1,2,0,0},
                            {-1,-1,-1,0},
                            {-1,-1,-1,10}};
        System.out.println(Main.calculaPremio(bolas));
        assertTrue(Main.calculaPremio(bolas) == 10);
    }

    @Test
    public void calculaPremioEstress() {
        Random random = new Random();

        int bolas[][] = new int[1000][1000];
        for (int i = 0; i < bolas.length; i++) {
            for (int j = 0; j < bolas.length; j++) {
                bolas[i][j] = random.nextInt(10);
            }
        }
        System.out.println(Main.calculaPremio(bolas));
        //assertTrue(Main.calculaPremio(bolas) == 10);
    }

}
