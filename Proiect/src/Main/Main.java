package Main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();
        ArrayList<String> map = input.getMap();
        System.out.println(map.toString());
        System.out.println(map.get(0).charAt(0));
    }
}
