package lesson1;

import java.util.ArrayList;

//Алгоритм из жизни- кратчайшие утренние сборы на работу; структура данных - фотоальбом;
//Алгоритм программирования - итерация элементов массива для поиска нужных значений; структура данных - TreeMap
public class Main {


    public static void main(String[] args) {
        ArrayList<Character> initGreeting = new ArrayList<>();
        initGreeting.add('H');
        initGreeting.add('e');
        initGreeting.add('l');
        initGreeting.add('l');
        initGreeting.add('o');

        MyData myData = new MyData(25, initGreeting);
        myData.outputData();
        ArrayList<Character> listToCompare = new ArrayList<>();
        listToCompare.add('H');
        listToCompare.add('o');
        listToCompare.add('l');
        listToCompare.add('r');
        listToCompare.add('o');
        long start = System.nanoTime();
        ArrayList<Character> result = myData.compareWithGreeting(listToCompare);
        long finish = System.nanoTime();
        System.out.println(result);
        System.out.println("elapsed :" + (finish - start) + "ns");
    }
}
