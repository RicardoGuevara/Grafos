/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author cmrocha
 */
public class Grafos {

    static int[][] M = {{0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 0},
                        {1, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 0, 1, 1, 0}};
    static boolean[]visitados = new boolean[M.length];
    static LinkedList<Vertice> vertices = new LinkedList<Vertice>();
    /**
     * @param args the command line arguments
     */
    public static void DFS(int u){
        System.out.print(u+" ");
        visitados[u]=true;
        for (int v = 0; v < visitados.length; v++) 
            if (M[u][v] == 1) 
                if (!visitados[v]) 
                    DFS(v);
                
            
        
    }
    public static void BFS(int i){
        Queue<Integer> cola = new LinkedList<Integer>();
        visitados[i] = true;
        cola.add(i);
        int u;
        while(!cola.isEmpty()){
            u = cola.remove();
            System.out.println(u+" ");
            for (int v = 0; v < M.length; v++) 
                if (M[u][v] == 1){
                    if (!visitados[v]){ 
                        visitados[v] = true;
                        cola.add(v);
                    }
                }
        }
    }
//    public static void visualizarLisa(){
//        for (Vertice vertice : vertices) {
//            System.out.println(vertice.getDato()+"-->");
//            for (Integer e : vertice.getAdyacencias()) {
//                System.out.println(e+", ");
//            }
//            System.out.println("");
//        }
//    }
    public static void main(String[] args) {
        
        System.out.println("DFS: ");
        DFS(0);
        
        System.out.println("\n\rBFS: ");
        BFS(0);
        System.out.println("MATRIZ DE ADYACENCIA: ");
        for (int i = 0; i < M.length; i++) {
            Vertice v = new Vertice(i);
            System.out.print(i+" - ");
            for (int j = 0; j < M.length; j++)
                if (M[i][j] == 1) {
                    System.out.print(j+" ");
                    v.Adyacencias.add(j);
                }else{
                    System.out.print("x ");
                }
            System.out.println(" ");
            vertices.add(v);
        }
        
       
    }

}
