package lesson1;

import java.util.ArrayList;

public class MyData {
    private int age = 25;
    private ArrayList<Character> greeting;

    public MyData(int age, ArrayList<Character> greeting) {
        this.age = age;
        this.greeting = greeting;
    }

    public void outputData() {
        System.out.println(greeting + " " + age + ".");
    }

    public ArrayList<Character> compareWithGreeting(ArrayList<Character> arrListToCompare) {
        ArrayList<Character> result = new ArrayList<>();
        int minLength = greeting.size() > arrListToCompare.size() ? arrListToCompare.size() : greeting.size();
        for (int i = 0; i < minLength; i++) {
            if (arrListToCompare.get(i) == greeting.get(i)) {
                result.add(i, greeting.get(i));
            } else {
                result.add(i, '#');
            }
        }
        return result;
    }

}
