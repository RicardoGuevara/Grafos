
package UN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafos { 
    static LinkedList<Vertice> lista = new LinkedList<Vertice>();
    static Queue<Vertice> prioridad = new LinkedList<>();
    
    static int[][] M = {{0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 0},
                        {1, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 0, 1, 1, 0}};
    //DFS: 01243    
    //BFS: 01234
    static boolean[] visitados = new boolean[M.length];
    
    public static void llenarLista(){
        for (int i = 0; i < M.length; i++) {
            Vertice tmp = new Vertice(i);
            for (int j = 0; j < M.length; j++) {
                if(M[i][j]==1)
                    tmp.adyacentes.add(j);
            }
            lista.add(tmp);
        }
    }
    public static void visualizarLista(){
        for (Vertice vertice : lista) {
            System.out.print(vertice.getDato()+"->");
            for (Integer e : vertice.getAdyacentes()) {
                System.out.print(e+", ");
            }
            System.out.println("");
        }
    
    }
    
    public static void DFS(int u){
        System.out.print(u+" ");
        visitados[u]=true;
        for (int v = 0; v < visitados.length; v++) 
            if (M[u][v]==1) 
                if (!visitados[v]) 
                    DFS(v);        
    }
    public static void BFS(int i){
        Queue<Integer> cola = new LinkedList<Integer>();
        visitados[i]=true;
        cola.add(i);
        int u;
        while(!cola.isEmpty()){
            u=cola.remove();
            System.out.print(u+" ");
            for (int v = 0; v < M.length; v++) {
                if (M[u][v]==1) {
                    if (!visitados[v]) {
                        visitados[v]=true;
                        cola.add(v);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {        
        System.out.println("DFS:");
        DFS(0);
        
        visitados = new boolean[M.length];
        System.out.println("\n\rBFS:");
        BFS(0);
        
        System.out.println("\n\rLa lista de adyacencia es:");
        llenarLista();
        visualizarLista();
        
        
    }
    
    public static void dijkstra(Grafos g, Vertice o)
    {
        Queue<Vertice> prioridad = new LinkedList<>();
        prioridad.add(o);
        Vertice u;
        int peso;
        
        while(!prioridad.isEmpty())
        {
            u=prioridad.remove();
            while(u.visitado_dijkstra)
            {
                u=prioridad.remove();
            }
            u.visitado_dijkstra = true;
            
            for (Integer adyacente : u.getAdyacentes()) 
            {
                peso = getpeso(u,);
            }
        }
        
    }
    
}