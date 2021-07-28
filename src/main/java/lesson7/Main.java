package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph myGraph = new Graph();

        long startAddVertex = System.nanoTime();
        myGraph.addVertex('A');
        long finishAddVertex = System.nanoTime();

        myGraph.addVertex('B');
        myGraph.addVertex('C');
        myGraph.addVertex('D');
        myGraph.addVertex('E');
        myGraph.addVertex('F');

        long startAddEdge = System.nanoTime();
        myGraph.addEdge(0, 1);
        long finishAddEdge = System.nanoTime();

        myGraph.addEdge(0, 2);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(0, 5);

        myGraph.displayVertex(0);
        myGraph.displayVertex(1);
        myGraph.displayVertex(2);
        myGraph.displayVertex(3);
        myGraph.displayVertex(4);
        System.out.println("Adding vertex time: " + (finishAddVertex - startAddVertex) + "ms" +
                "\nAdding edge time: " + (finishAddEdge - startAddEdge) + "ms");

        long startDeepInspect = System.nanoTime();
        myGraph.inspectionToDeep(0);
        long finishDeepInspect = System.nanoTime();
        System.out.println("Visiting vertexes to deep time: " + (finishDeepInspect - startDeepInspect) + "ms");

        long startWidthInspect = System.nanoTime();
        myGraph.inspectionToWidth();
        long finishWidthInspect = System.nanoTime();
        System.out.println("Visiting vertexes to width time: " + (finishWidthInspect - startWidthInspect) + "ms");
    }

    //Применение графа - поиск кратчайшего или неповторяющегося пути из точки А в точку В
}
