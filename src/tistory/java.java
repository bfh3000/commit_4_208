package tistory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java {
	public static void main(String[] args) {

		Map<Integer, String> Map = new HashMap<Integer, String>();

		Map.put( 22, "uuuuuuu");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 15, "aaaaaaa");
        Map.put( 44, "ddddddd");
        Map.put( 11, "ccccccc");
        Map.put( 16, "iiiiiii");
        Map.put( 31, "ttttttt");
        Map.put( 42, "bbbbbbb");

        Object[] map_key = Map.keySet().toArray();
        Arrays.sort(map_key);

        // 결과 출력
        for (Integer nKey : Map.keySet())
        {
            System.out.println(Map.get(nKey));
        }
    }
}
