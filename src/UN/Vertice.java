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
    LinkedList<Vertice> adyacentes;

    public Vertice(int dato) {
        this.dato = dato;
        adyacentes = new LinkedList<Vertice>();
    }

    public int getDato() {
        return dato;
    }

    public LinkedList<Vertice> getAdyacentes() {
        return adyacentes;
    }
    
    public String toString(){return String.valueOf(this.dato);}
    
    public int distancia = 99999;
    public boolean visitado_dijkstra = false;
    
}
