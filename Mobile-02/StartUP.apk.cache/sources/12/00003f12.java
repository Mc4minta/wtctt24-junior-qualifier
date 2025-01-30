package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AdapterMethodsFactory implements JsonAdapter.Factory {
    private final List<AdapterMethod> fromAdapters;
    private final List<AdapterMethod> toAdapters;

    AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.toAdapters = list;
        this.fromAdapters = list2;
    }

    static AdapterMethod fromAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(method);
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != Void.TYPE && parametersAreJsonAdapters(1, genericParameterTypes)) {
            return new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, genericParameterTypes.length, 1, true) { // from class: com.squareup.moshi.AdapterMethodsFactory.4
                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return invoke(jsonReader);
                }
            };
        }
        if (genericParameterTypes.length == 1 && genericReturnType != Void.TYPE) {
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            return new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) { // from class: com.squareup.moshi.AdapterMethodsFactory.5
                JsonAdapter<Object> delegate;

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                    JsonAdapter<Object> adapter;
                    super.bind(moshi, factory);
                    if (Types.equals(genericParameterTypes[0], genericReturnType) && jsonAnnotations2.equals(jsonAnnotations)) {
                        adapter = moshi.nextAdapter(factory, genericParameterTypes[0], jsonAnnotations2);
                    } else {
                        adapter = moshi.adapter(genericParameterTypes[0], jsonAnnotations2);
                    }
                    this.delegate = adapter;
                }

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return invoke(this.delegate.fromJson(jsonReader));
                }
            };
        }
        throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
    }

    public static AdapterMethodsFactory get(Object obj) {
        Method[] declaredMethods;
        AdapterMethod adapterMethod;
        AdapterMethod adapterMethod2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ToJson.class)) {
                    AdapterMethod adapter = toAdapter(obj, method);
                    if (get(arrayList, adapter.type, adapter.annotations) == null) {
                        arrayList.add(adapter);
                    } else {
                        throw new IllegalArgumentException("Conflicting @ToJson methods:\n    " + adapterMethod2.method + "\n    " + adapter.method);
                    }
                }
                if (method.isAnnotationPresent(FromJson.class)) {
                    AdapterMethod fromAdapter = fromAdapter(obj, method);
                    if (get(arrayList2, fromAdapter.type, fromAdapter.annotations) == null) {
                        arrayList2.add(fromAdapter);
                    } else {
                        throw new IllegalArgumentException("Conflicting @FromJson methods:\n    " + adapterMethod.method + "\n    " + fromAdapter.method);
                    }
                }
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            throw new IllegalArgumentException("Expected at least one @ToJson or @FromJson method on " + obj.getClass().getName());
        }
        return new AdapterMethodsFactory(arrayList, arrayList2);
    }

    private static boolean parametersAreJsonAdapters(int i2, Type[] typeArr) {
        int length = typeArr.length;
        while (i2 < length) {
            if (!(typeArr[i2] instanceof ParameterizedType) || ((ParameterizedType) typeArr[i2]).getRawType() != JsonAdapter.class) {
                return false;
            }
            i2++;
        }
        return true;
    }

    static AdapterMethod toAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 2 && genericParameterTypes[0] == JsonWriter.class && genericReturnType == Void.TYPE && parametersAreJsonAdapters(2, genericParameterTypes)) {
            return new AdapterMethod(genericParameterTypes[1], Util.jsonAnnotations(parameterAnnotations[1]), obj, method, genericParameterTypes.length, 2, true) { // from class: com.squareup.moshi.AdapterMethodsFactory.2
                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj2) throws IOException, InvocationTargetException {
                    invoke(jsonWriter, obj2);
                }
            };
        } else if (genericParameterTypes.length == 1 && genericReturnType != Void.TYPE) {
            final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(method);
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            return new AdapterMethod(genericParameterTypes[0], jsonAnnotations2, obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) { // from class: com.squareup.moshi.AdapterMethodsFactory.3
                private JsonAdapter<Object> delegate;

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                    JsonAdapter<Object> adapter;
                    super.bind(moshi, factory);
                    if (Types.equals(genericParameterTypes[0], genericReturnType) && jsonAnnotations2.equals(jsonAnnotations)) {
                        adapter = moshi.nextAdapter(factory, genericReturnType, jsonAnnotations);
                    } else {
                        adapter = moshi.adapter(genericReturnType, jsonAnnotations);
                    }
                    this.delegate = adapter;
                }

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj2) throws IOException, InvocationTargetException {
                    this.delegate.toJson(jsonWriter, (JsonWriter) invoke(obj2));
                }
            };
        } else {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        }
    }

    @Override // com.squareup.moshi.JsonAdapter.Factory
    public JsonAdapter<?> create(final Type type, final Set<? extends Annotation> set, final Moshi moshi) {
        final AdapterMethod adapterMethod = get(this.toAdapters, type, set);
        final AdapterMethod adapterMethod2 = get(this.fromAdapters, type, set);
        JsonAdapter jsonAdapter = null;
        if (adapterMethod == null && adapterMethod2 == null) {
            return null;
        }
        if (adapterMethod == null || adapterMethod2 == null) {
            try {
                jsonAdapter = moshi.nextAdapter(this, type, set);
            } catch (IllegalArgumentException e2) {
                String str = adapterMethod == null ? "@ToJson" : "@FromJson";
                throw new IllegalArgumentException("No " + str + " adapter for " + Util.typeAnnotatedWithAnnotations(type, set), e2);
            }
        }
        final JsonAdapter jsonAdapter2 = jsonAdapter;
        if (adapterMethod != null) {
            adapterMethod.bind(moshi, this);
        }
        if (adapterMethod2 != null) {
            adapterMethod2.bind(moshi, this);
        }
        return new JsonAdapter<Object>() { // from class: com.squareup.moshi.AdapterMethodsFactory.1
            @Override // com.squareup.moshi.JsonAdapter
            public Object fromJson(JsonReader jsonReader) throws IOException {
                AdapterMethod adapterMethod3 = adapterMethod2;
                if (adapterMethod3 == null) {
                    return jsonAdapter2.fromJson(jsonReader);
                }
                if (!adapterMethod3.nullable && jsonReader.peek() == JsonReader.Token.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return adapterMethod2.fromJson(moshi, jsonReader);
                } catch (InvocationTargetException e3) {
                    Throwable cause = e3.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    }
                    throw new JsonDataException(cause + " at " + jsonReader.getPath(), cause);
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                AdapterMethod adapterMethod3 = adapterMethod;
                if (adapterMethod3 == null) {
                    jsonAdapter2.toJson(jsonWriter, (JsonWriter) obj);
                } else if (!adapterMethod3.nullable && obj == null) {
                    jsonWriter.nullValue();
                } else {
                    try {
                        adapterMethod3.toJson(moshi, jsonWriter, obj);
                    } catch (InvocationTargetException e3) {
                        Throwable cause = e3.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonWriter.getPath(), cause);
                    }
                }
            }

            public String toString() {
                return "JsonAdapter" + set + "(" + type + ")";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class AdapterMethod {
        final Object adapter;
        final int adaptersOffset;
        final Set<? extends Annotation> annotations;
        final JsonAdapter<?>[] jsonAdapters;
        final Method method;
        final boolean nullable;
        final Type type;

        AdapterMethod(Type type, Set<? extends Annotation> set, Object obj, Method method, int i2, int i3, boolean z) {
            this.type = Util.canonicalize(type);
            this.annotations = set;
            this.adapter = obj;
            this.method = method;
            this.adaptersOffset = i3;
            this.jsonAdapters = new JsonAdapter[i2 - i3];
            this.nullable = z;
        }

        public void bind(Moshi moshi, JsonAdapter.Factory factory) {
            JsonAdapter<?> adapter;
            if (this.jsonAdapters.length > 0) {
                Type[] genericParameterTypes = this.method.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i2 = this.adaptersOffset; i2 < length; i2++) {
                    Type type = ((ParameterizedType) genericParameterTypes[i2]).getActualTypeArguments()[0];
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(parameterAnnotations[i2]);
                    JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
                    int i3 = i2 - this.adaptersOffset;
                    if (Types.equals(this.type, type) && this.annotations.equals(jsonAnnotations)) {
                        adapter = moshi.nextAdapter(factory, type, jsonAnnotations);
                    } else {
                        adapter = moshi.adapter(type, jsonAnnotations);
                    }
                    jsonAdapterArr[i3] = adapter;
                }
            }
        }

        public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        protected Object invoke(Object obj) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[jsonAdapterArr.length + 1];
            objArr[0] = obj;
            System.arraycopy(jsonAdapterArr, 0, objArr, 1, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        protected Object invoke(Object obj, Object obj2) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[jsonAdapterArr.length + 2];
            objArr[0] = obj;
            objArr[1] = obj2;
            System.arraycopy(jsonAdapterArr, 0, objArr, 2, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }

    private static AdapterMethod get(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterMethod adapterMethod = list.get(i2);
            if (Types.equals(adapterMethod.type, type) && adapterMethod.annotations.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }
}