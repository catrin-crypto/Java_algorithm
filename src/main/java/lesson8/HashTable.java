package lesson8;

public class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getData());
            } else {
                System.out.println("###");
            }
        }
    }

    public int hashFunction(int key) {
        return key % arrSize;
    }

    public int hashFunDouble(int key) {
        return 3 - key % 3;
    }

    public void insert(Item item) {
        int key = item.getData();
        int hashValue = hashFunction(key);
        int stepSize = hashFunDouble(key);
        while (hashArr[hashValue] != null && hashArr[hashValue].getData() != -1) {
            hashValue += stepSize;
            hashValue %= arrSize;
        }
        hashArr[hashValue] = item;
    }

    public Item delete(int key) {
        int hashValue = hashFunction(key);
        int stepSize = hashFunDouble(key);
        while (hashArr[hashValue] != null) {
            if (hashArr[hashValue].getData() == key) {
                Item temp = hashArr[hashValue];
                hashArr[hashValue] = nonItem;
                return temp;
            }
            hashValue += stepSize;
            hashValue %= arrSize;
        }
        return null;
    }

    public Item find(int key) {
        int hashValue = hashFunction(key);
        int stepSize = hashFunDouble(key);
        while (hashArr[hashValue] != null) {
            if (hashArr[hashValue].getData() == key) {
                return hashArr[hashValue];
            }
            hashValue += stepSize;
            hashValue %= arrSize;
        }
        return null;
    }
}
