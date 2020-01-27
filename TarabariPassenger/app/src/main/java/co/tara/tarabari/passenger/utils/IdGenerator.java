package co.tara.tarabari.passenger.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ali on 9/10/2016.
 */
public class IdGenerator {

    public static HashMap<String, Integer> id = new HashMap<String, Integer>();
    public static int lastid = 0x7f100000;

    public static int getId(String key) {

        if (id.get(key) == null) {
            Map map =new HashMap<>();
            map.put(key,lastid);
            id.putAll(map);
            id.put(key, lastid);
            lastid++;}
        return id.get(key);
    }





}
