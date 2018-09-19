/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UN;

import java.util.LinkedList;

/**
 *
 * @author jesusdavide
 */
public class Vertice {
    int dato;
    LinkedList<Integer> adyacentes;

    public Vertice(int dato) {
        this.dato = dato;
        adyacentes = new LinkedList<Integer>();
    }

    public int getDato() {
        return dato;
    }

    public LinkedList<Integer> getAdyacentes() {
        return adyacentes;
    }
    
    
}
