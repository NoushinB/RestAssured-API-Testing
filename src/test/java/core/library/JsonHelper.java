package core.library;

import com.google.gson.Gson;

public class JsonHelper {
    /*
    Convert an object to json string
     */
    public static <T> String toJson(T pojo) {
        return new Gson().toJson(pojo);
    }

    /*
    Convert json string to an object
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
