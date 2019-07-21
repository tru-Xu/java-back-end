package generalType;

import java.util.*;

public class erase {

    public static void main(String[] args){
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        Map<Integer, String> integerStringMap = new HashMap<>();
        Map<String, String> stringStringMap = new HashMap<>();
        System.out.println(Arrays.toString(integerStringMap.getClass().getTypeParameters()));
        System.out.println(integerStringMap.getClass() == stringStringMap.getClass());
        System.out.println(integers.getClass() == strings.getClass());
        System.out.println(integers.equals(strings));

    }
}
