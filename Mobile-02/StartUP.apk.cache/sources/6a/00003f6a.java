package com.squareup.moshi.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class PolymorphicJsonAdapterFactory<T> implements JsonAdapter.Factory {
    final Class<T> baseType;
    final JsonAdapter<Object> fallbackJsonAdapter;
    final String labelKey;
    final List<String> labels;
    final List<Type> subtypes;

    /* loaded from: classes2.dex */
    static final class PolymorphicJsonAdapter extends JsonAdapter<Object> {
        final JsonAdapter<Object> fallbackJsonAdapter;
        final List<JsonAdapter<Object>> jsonAdapters;
        final String labelKey;
        final JsonReader.Options labelKeyOptions;
        final JsonReader.Options labelOptions;
        final List<String> labels;
        final List<Type> subtypes;

        PolymorphicJsonAdapter(String str, List<String> list, List<Type> list2, List<JsonAdapter<Object>> list3, JsonAdapter<Object> jsonAdapter) {
            this.labelKey = str;
            this.labels = list;
            this.subtypes = list2;
            this.jsonAdapters = list3;
            this.fallbackJsonAdapter = jsonAdapter;
            this.labelKeyOptions = JsonReader.Options.of(str);
            this.labelOptions = JsonReader.Options.of((String[]) list.toArray(new String[0]));
        }

        private int labelIndex(JsonReader jsonReader) throws IOException {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(this.labelKeyOptions) == -1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    int selectString = jsonReader.selectString(this.labelOptions);
                    if (selectString == -1 && this.fallbackJsonAdapter == null) {
                        throw new JsonDataException("Expected one of " + this.labels + " for key '" + this.labelKey + "' but found '" + jsonReader.nextString() + "'. Register a subtype for this label.");
                    }
                    return selectString;
                }
            }
            throw new JsonDataException("Missing label for " + this.labelKey);
        }

        @Override // com.squareup.moshi.JsonAdapter
        public Object fromJson(JsonReader jsonReader) throws IOException {
            JsonReader peekJson = jsonReader.peekJson();
            peekJson.setFailOnUnknown(false);
            try {
                int labelIndex = labelIndex(peekJson);
                peekJson.close();
                if (labelIndex == -1) {
                    return this.fallbackJsonAdapter.fromJson(jsonReader);
                }
                return this.jsonAdapters.get(labelIndex).fromJson(jsonReader);
            } catch (Throwable th) {
                peekJson.close();
                throw th;
            }
        }

        @Override // com.squareup.moshi.JsonAdapter
        public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            JsonAdapter<Object> jsonAdapter;
            int indexOf = this.subtypes.indexOf(obj.getClass());
            if (indexOf == -1) {
                jsonAdapter = this.fallbackJsonAdapter;
                if (jsonAdapter == null) {
                    throw new IllegalArgumentException("Expected one of " + this.subtypes + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.");
                }
            } else {
                jsonAdapter = this.jsonAdapters.get(indexOf);
            }
            jsonWriter.beginObject();
            if (jsonAdapter != this.fallbackJsonAdapter) {
                jsonWriter.name(this.labelKey).value(this.labels.get(indexOf));
            }
            int beginFlatten = jsonWriter.beginFlatten();
            jsonAdapter.toJson(jsonWriter, (JsonWriter) obj);
            jsonWriter.endFlatten(beginFlatten);
            jsonWriter.endObject();
        }

        public String toString() {
            return "PolymorphicJsonAdapter(" + this.labelKey + ")";
        }
    }

    PolymorphicJsonAdapterFactory(Class<T> cls, String str, List<String> list, List<Type> list2, JsonAdapter<Object> jsonAdapter) {
        this.baseType = cls;
        this.labelKey = str;
        this.labels = list;
        this.subtypes = list2;
        this.fallbackJsonAdapter = jsonAdapter;
    }

    private JsonAdapter<Object> buildFallbackJsonAdapter(final T t) {
        return new JsonAdapter<Object>() { // from class: com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory.1
            @Override // com.squareup.moshi.JsonAdapter
            public Object fromJson(JsonReader jsonReader) throws IOException {
                jsonReader.skipValue();
                return t;
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                throw new IllegalArgumentException("Expected one of " + PolymorphicJsonAdapterFactory.this.subtypes + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.");
            }
        };
    }

    public static <T> PolymorphicJsonAdapterFactory<T> of(Class<T> cls, String str) {
        Objects.requireNonNull(cls, "baseType == null");
        Objects.requireNonNull(str, "labelKey == null");
        return new PolymorphicJsonAdapterFactory<>(cls, str, Collections.emptyList(), Collections.emptyList(), null);
    }

    @Override // com.squareup.moshi.JsonAdapter.Factory
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        if (Types.getRawType(type) == this.baseType && set.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.subtypes.size());
            int size = this.subtypes.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(moshi.adapter(this.subtypes.get(i2)));
            }
            return new PolymorphicJsonAdapter(this.labelKey, this.labels, this.subtypes, arrayList, this.fallbackJsonAdapter).nullSafe();
        }
        return null;
    }

    public PolymorphicJsonAdapterFactory<T> withDefaultValue(T t) {
        return withFallbackJsonAdapter(buildFallbackJsonAdapter(t));
    }

    public PolymorphicJsonAdapterFactory<T> withFallbackJsonAdapter(JsonAdapter<Object> jsonAdapter) {
        return new PolymorphicJsonAdapterFactory<>(this.baseType, this.labelKey, this.labels, this.subtypes, jsonAdapter);
    }

    public PolymorphicJsonAdapterFactory<T> withSubtype(Class<? extends T> cls, String str) {
        Objects.requireNonNull(cls, "subtype == null");
        Objects.requireNonNull(str, "label == null");
        if (!this.labels.contains(str)) {
            ArrayList arrayList = new ArrayList(this.labels);
            arrayList.add(str);
            ArrayList arrayList2 = new ArrayList(this.subtypes);
            arrayList2.add(cls);
            return new PolymorphicJsonAdapterFactory<>(this.baseType, this.labelKey, arrayList, arrayList2, this.fallbackJsonAdapter);
        }
        throw new IllegalArgumentException("Labels must be unique.");
    }
}