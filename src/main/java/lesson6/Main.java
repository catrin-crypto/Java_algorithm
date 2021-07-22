package lesson6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tree myTree = new Tree();

        long startTreeInsert = System.nanoTime();
        myTree.insert(new Animal("Garry", 2, 1));
        long finishTreeInsert = System.nanoTime();
        myTree.insert(new Animal("Tom", 5, 4));
        myTree.insert(new Animal("Kitty", 3, 6));
        myTree.insert(new Animal("Sandy", 0, 3));
        myTree.insert(new Animal("Veniamin", 7, 5));
        myTree.insert(new Animal("Rusty", 4, 2));
        System.out.println("Inserting element time: " + (finishTreeInsert - startTreeInsert) + "ms");

        myTree.min().display();
        myTree.max().display();

        long startTreeSearch = System.nanoTime();
        myTree.search(5).display();
        long finishTreeSearch = System.nanoTime();
        System.out.println("Searching time: " + (finishTreeSearch - startTreeSearch) + "ms");

        long startDeleteId = System.nanoTime();
        myTree.delete(4);
        long finishDeleteId = System.nanoTime();
        System.out.println("Delete time: " + (finishDeleteId - startDeleteId) + "ms");
        System.out.println();

        myTree.displayTree();


        //HeapSort

        int[] myArr = {5, 23, 0, 900, 21, 3, 76, 555, 1, 11};
        System.out.println(Arrays.toString(myArr));
        SortedHeap myArrSorted = new SortedHeap();
        long startHeapSort = System.nanoTime();
        myArrSorted.sort(myArr);
        long finishHeapSort = System.nanoTime();
        System.out.println(Arrays.toString(myArr) + "\n Pyramid sort time: " + (finishHeapSort - startHeapSort) + "ms");
    }

    //В сбалансированных деревьях удобно хранить список, например, абонентов, сотрудников, чтобы быстро получить доступ к данным в алфавитном порядке
}
