package utils;

import com.google.gson.Gson;

public class JsonUtils {
    private static Gson Gson = new Gson();
    public static String toJson(Object obj) {
        return Gson.toJson(obj);
    }
//    public static String toJson() {
//        return Gson.(obj);
//    }
}
