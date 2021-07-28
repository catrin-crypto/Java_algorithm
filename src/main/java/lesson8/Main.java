package lesson8;

import java.util.Random;

public class Main {

    //1.Хеш-таблица для хранения списка флоры, фауны ареала
    //2. ключи разные(строки, например), хеш-код одинаковый.коллизия)
    //3.эффективная хеш-функция - поиск элемента.
    public static void hashFunction2(int key, int size) {
        System.out.println(key % size);
    }

    public static void main(String[] args) {
        Item myDataItem;
        int myKey;
        int size = 50;

        HashTable myHashTable = new HashTable(size);
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            myKey = rand.nextInt(999);
            myDataItem = new Item(myKey);
            myHashTable.insert(myDataItem);
        }
        myHashTable.insert(new Item(995));
        myHashTable.insert(new Item(997));

        myHashTable.display();
        System.out.println();

        hashFunction2(995, 50);
        System.out.println(myHashTable.find(995).getData());

        myHashTable.delete(997);
        myHashTable.display();
    }
}
