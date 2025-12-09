package DSA;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {

    private int[][] matrix;
    private int size;

    public Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    // Add edge (directed)
    public void addDirectedEdge(int u, int v) {
        matrix[u][v] = 1;
    }

    public void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[size];
        q.offer(0);
        visited[0] = true;
        while(!(q.isEmpty())){
            int removed = q.poll();
            System.out.println(removed);
            for(int j = 0; j<size; ++j){
                if(matrix[removed][j] == 1 && !visited[j]){
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }

    public void dfs(){
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[size];
        s.push(0);
        visited[0] = true;
        while(!(s.isEmpty())){
            int removed = s.pop();
            System.out.println(removed);
            for(int j = 0; j<size;++j){
                if(matrix[removed][j]==1 && !visited[j]){
                    s.push(j);
                    visited[j] = true;
                }
            }
        }
    }

    // Print adjacency matrix
    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
