/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tablashash;

/**
 *
 * @author carlo
 */
public class T_Hash {
    int dato;
    int estado; 

    static int funcion(int n, int m) {
        return ((n + 1) % m);
    }

    static void insertaT_Hash(T_Hash[] h, int m, int n) {
        boolean i = false;
        int j = funcion(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].estado = 2;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);
        if (i) {
            javax.swing.JOptionPane.showMessageDialog(null, "Elemento insertado");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Tabla llena");
        }
    }

    static int buscaT_Hash(T_Hash[] h, int m, int n) {
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;
    }

    static int eliminaT_Hash(T_Hash[] h, int m, int n) {
        int i = buscaT_Hash(h, m, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            return 1;
        }
    }
}
