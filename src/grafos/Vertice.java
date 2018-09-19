/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;


/**
 *
 * @author cmrocha
 */
public class Vertice {
    int dato;
    LinkedList<Integer> Adyacencias;
    
    public Vertice(int dato) {
        this.dato = dato;
        Adyacencias = new LinkedList<Integer>();
    }

    public LinkedList<Integer> getAdyacencias() {
        return Adyacencias;
    }

    public int getDato() {
        return dato;
    }
    
}
