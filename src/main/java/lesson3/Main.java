package lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ListObject> myList = new ArrayList<>();
        myList.add(new ListObject(1, 5));
        myList.add(new ListObject(56, 6));
        myList.add(new ListObject(2, 9));
        myList.add(new ListObject(15, 5));
        System.out.println(myList);

        ArrayList<ListObject> myListCopy = new ArrayList<>(myList);
        ListObject objToSearch = new ListObject(7, 9);
        long startMyListCopyMethods = System.nanoTime();
        myListCopy.add(objToSearch);
//        System.out.println(myListCopy);
        if(myListCopy.contains(objToSearch)){
            System.out.println("Contains x7, y9");
        }
        System.out.println(myListCopy.get(2));
        myListCopy.remove(0);
        long finishMyListCopyMethods = System.nanoTime();
        System.out.println("methods processing took " + (finishMyListCopyMethods - startMyListCopyMethods) + "ns");

        LinkedList<ListObject> myLinkedList = new LinkedList<>();
        myLinkedList.addFirst(new ListObject(99, 12));
        myLinkedList.add(new ListObject(21, 22));
        myLinkedList.addLast(new ListObject(11, 11));
        System.out.println(myLinkedList.peekFirst());

        Iterator<ListObject> iter1 = myLinkedList.iterator();
        long startIterating = System.nanoTime();
        while (iter1.hasNext()){
            System.out.println(iter1.next());
        }
        long finishIterating = System.nanoTime();
        System.out.println("Iterating time: " + (finishIterating - startIterating) + "ns");
    }
}
