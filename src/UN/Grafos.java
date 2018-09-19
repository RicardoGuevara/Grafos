
package UN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafos { 
    static LinkedList<Vertice> lista = new LinkedList<Vertice>();
    static Queue<Vertice> prioridad = new LinkedList<>();
    
    static int[][]  M = {{0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 0},
                        {1, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 0, 1, 1, 0}},
                    MPesos;
    
    
    
    //DFS: 01243    
    //BFS: 01234
    static boolean[] visitados = new boolean[M.length];
    
    static void pesos()
    {
        MPesos = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j]!=0)
                    MPesos[i][j]= (int)(Math.random()*(20));
                else     
                    MPesos[i][j]= 0;
            }
        }
    }
    
    static void mostrarpesos()
    {
        System.out.println("\nMATRIZ DE PESO DE ARISTAS\n");
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                System.out.print(MPesos[i][j]+"   ");
            }
            System.out.println("");
        }
    }
    
    public static void llenarLista(){
        for (int i = 0; i < M.length; i++) {
            Vertice tmp = new Vertice(i);
            for (int j = 0; j < M.length; j++) {
                if(M[i][j]==1)
                    tmp.adyacentes.add(new Vertice(j));
            }
            lista.add(tmp);
        }
    }
    public static void visualizarLista(){
        for (Vertice vertice : lista) {
            System.out.print(vertice.getDato()+"->");
            for (Vertice e : vertice.getAdyacentes()) {
                System.out.print(e.dato+", ");
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
        
        pesos(); // asigna peso random a las "aristas" y ubica el peso de cuerdo la matriz de adyacencia
        mostrarpesos();
        dijkstra(lista.get(0));
        System.out.println("\n"+prioridad);
    }
    
    public static void dijkstra(Vertice o)
    {
        o.distancia=0;
        Queue<Vertice> prioridad = new LinkedList<>();
        prioridad.add(o);
        Vertice u;
        int peso;
        
        while(!prioridad.isEmpty())
        {
            u=prioridad.remove();
            
                System.out.println("u = "+u.dato);
            while(u.visitado_dijkstra)
            {
                u=prioridad.remove();
            }
            u.visitado_dijkstra = true;
            
                System.out.println("u = "+u.dato);
            
            for (Vertice ady : u.getAdyacentes()) 
            {
                if (!ady.visitado_dijkstra)
                {
                    peso=MPesos[u.dato][ady.dato];//como c ac ?
                    metodito(u,ady,peso);
                }
            }
        }
        
        
    }
    
    static void metodito(Vertice actual,Vertice ady,int peso)
    {
        System.out.println(peso);
        System.out.println(actual.distancia);
        System.out.println(ady.distancia);
        int tmp = actual.distancia+peso;
        if (tmp< ady.distancia ) 
        {
            ady.distancia =tmp;
            
            prioridad.add(ady);
            System.out.println(prioridad);
        }
    }
    
}