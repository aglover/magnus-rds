package utils;

import java.lang.annotation.*;
import java.lang.reflect.Type;

import com.google.gson.*;

import play.data.binding.*;

@Global
public class GsonBinder implements TypeBinder<JsonObject> {

    public Object bind(String name, Annotation[] antns, String value, Class type) throws Exception {
        return new JsonParser().parse(value);
    }

    public Object bind(String s, Annotation[] annotations, String s1, Class aClass, Type type) throws Exception {
        return new JsonParser().parse(s1);
    }
}
