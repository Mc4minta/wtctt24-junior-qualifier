package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes2.dex */
final class ArrayJsonAdapter extends JsonAdapter<Object> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() { // from class: com.squareup.moshi.ArrayJsonAdapter.1
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Type arrayComponentType = Types.arrayComponentType(type);
            if (arrayComponentType != null && set.isEmpty()) {
                return new ArrayJsonAdapter(Types.getRawType(arrayComponentType), moshi.adapter(arrayComponentType)).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<Object> elementAdapter;
    private final Class<?> elementClass;

    ArrayJsonAdapter(Class<?> cls, JsonAdapter<Object> jsonAdapter) {
        this.elementClass = cls;
        this.elementAdapter = jsonAdapter;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Object fromJson(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        Object newInstance = Array.newInstance(this.elementClass, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.elementAdapter.toJson(jsonWriter, (JsonWriter) Array.get(obj, i2));
        }
        jsonWriter.endArray();
    }

    public String toString() {
        return this.elementAdapter + ".array()";
    }
}