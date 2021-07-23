package lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private final int MAX_VERTEXES = 20;
    private Vertex[] vertexList;
    private int[][] adjacentMatrix;
    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEXES];
        adjacentMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
        size = 0;
        for (int i = 0; i < MAX_VERTEXES; i++) {
            for (int j = 0; j < MAX_VERTEXES; j++) {
                adjacentMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjacentMatrix[start][end] = 1;
        adjacentMatrix[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println("Vertex: " + (vertexList[vertex].label));
    }

    private int getAdjacentUnvisitedVertex(int vert) {
        for (int i = 0; i < size; i++) {
            if (adjacentMatrix[vert][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void inspectionToDeep(int f) {
        vertexList[f].wasVisited = true;
        for (int i = 0; i < size; i++) {
            int v = getAdjacentUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1) {
                totalDisplayVertex(f, v);
                inspectionToDeep(i);
            }
        }
    }

    public void inspectionToWidth() {
        Queue<Integer> myQueue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        myQueue.add(0);
        int v2;
        while (!myQueue.isEmpty()) {
            int v1 = myQueue.remove();
            while ((v2 = getAdjacentUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                myQueue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void totalDisplayVertex(int vert1, int vert2) {
        System.out.println("My vertexes: " + vertexList[vert1].label + "-" + vertexList[vert2].label);
    }
}
