package group.zhangtao.grammer.bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Test {
    public static void main(String[] args) {
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        logfileMap.put(1,"a_txt");
        logfileMap.put(2,"b_txt");
        logfileMap.put(3,"c_txt");
        logfileMap.put(4,"d_txt");
//        logfileMap.put(5,"d_txt");
        System.out.println("get 1 : "+logfileMap.get(1));
        System.out.println("get a_txt : "+logfileMap.inverse().get("a_txt"));
    }
}
