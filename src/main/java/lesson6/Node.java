package lesson6;

public class Node {
    public Animal animal;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("Animal name: " + animal.name + "; Animal age: " + animal.age);
    }
}
