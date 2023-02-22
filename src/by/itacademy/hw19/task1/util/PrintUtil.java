package by.itacademy.hw19.task1.util;

import java.util.Map;

public class PrintUtil {
    public static  <T,V> void printMap(Map<T,V> map, String separatorKey){
        map.forEach((key,value) -> System.out.println(key + separatorKey + value));
    }
}
