package com.desafio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void calculaPremio() {
        int bolas[][] = {
                        {3,0,0,0},
                        {-5,3,0,0},
                        {-8,2,-8,0},
                        {3,9,-2,7}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 7);
    }

    @Test
    public void calculaPremio2() {
        int bolas[][] = {
                        {-2,0},
                        {1,-10}};
        
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 0);
    }
    

    @Test
    public void calculaPremio3() {
        int bolas[][] = {
                        {1,0,0},
                        {-5,3,0},
                        {6,-4,1}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 6);
    }

    @Test
    public void calculaPremio4() {
        int bolas[][] = {
                        {-1,0,0},
                        {-1,-1,0},
                        {-1,-1,-1}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 0);
    }

    @Test
    public void calculaPremio5() {
        int bolas[][] = {
                        {1,0,0},
                        {1,1,0},
                        {1,1,1}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 6);
    }


    @Test
    public void calculaPremio8() {
        int bolas[][] = {
                        {1,0,0},
                        {-200,2,0},
                        {100,1,1}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 4);
    }

    @Test
    public void calculaPremio9() {
        int bolas[][] = {
                        {-1,0,0,0},
                        {-1,2,0,0},
                        {-1,-1,-1,0},
                        {-1,-1,-1,3}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 3);
    }

    @Test
    public void calculaPremio10() {
        int bolas[][] = {
                            {-1,0,0,0},
                            {-1,2,0,0},
                            {-1,-1,-1,0},
                            {-1,-1,-1,10}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 10);
    }


    @Test
    public void calculaPremio11() {
        int bolas[][] = {
            {1,       0,     0,      0,      0,      0,      0,      0,      0,      0},
            {-2,      -1,     0,     0,      0,      0,      0,      0,      0,      0},
            {1,       1,      -1,     0,     0,      0,      0,      0,      0,      0},
            {-1,      0,      -2,     -2,     0,     0,      0,      0,      0,      0},
            {-1,      -2,     -1,     1,      -1,     0,     0,      0,      0,      0},
            {1,       -1,     0,      1,      1,      -1,     0,     0,      0,      0},
            {-1,      -2,     -2,     -1,     -2,     -2,     1,      0,     0,      0},
            {-2,      0,      -2,     -2,     1,      1,      -2,     -1,     0,     0},
            {1,       1,      -1,     -2,     -2,     -1,     -1,     1,      -1,     0},
            {1,       -1,     -2,     -2,     1,      1,      1,      1,      1,      -1}};
        int resultado = Main.calculaPremio(bolas);
        System.out.println(resultado);
        assertTrue(resultado == 1);
    }



}
