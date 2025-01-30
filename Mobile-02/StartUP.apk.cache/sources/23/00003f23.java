package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class CollectionJsonAdapter<C extends Collection<T>, T> extends JsonAdapter<C> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() { // from class: com.squareup.moshi.CollectionJsonAdapter.1
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType = Types.getRawType(type);
            if (set.isEmpty()) {
                if (rawType != List.class && rawType != Collection.class) {
                    if (rawType == Set.class) {
                        return CollectionJsonAdapter.newLinkedHashSetAdapter(type, moshi).nullSafe();
                    }
                    return null;
                }
                return CollectionJsonAdapter.newArrayListAdapter(type, moshi).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<T> elementAdapter;

    static <T> JsonAdapter<Collection<T>> newArrayListAdapter(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Collection<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) { // from class: com.squareup.moshi.CollectionJsonAdapter.2
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
                return super.fromJson(jsonReader);
            }

            @Override // com.squareup.moshi.CollectionJsonAdapter
            Collection<T> newCollection() {
                return new ArrayList();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                super.toJson(jsonWriter, (JsonWriter) ((Collection) obj));
            }
        };
    }

    static <T> JsonAdapter<Set<T>> newLinkedHashSetAdapter(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Set<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) { // from class: com.squareup.moshi.CollectionJsonAdapter.3
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
                return super.fromJson(jsonReader);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                super.toJson(jsonWriter, (JsonWriter) ((Collection) obj));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.squareup.moshi.CollectionJsonAdapter
            public Set<T> newCollection() {
                return new LinkedHashSet();
            }
        };
    }

    abstract C newCollection();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        toJson(jsonWriter, (JsonWriter) ((Collection) obj));
    }

    public String toString() {
        return this.elementAdapter + ".collection()";
    }

    private CollectionJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.elementAdapter = jsonAdapter;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public C fromJson(JsonReader jsonReader) throws IOException {
        C newCollection = newCollection();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            newCollection.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        return newCollection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void toJson(JsonWriter jsonWriter, C c2) throws IOException {
        jsonWriter.beginArray();
        for (Object obj : c2) {
            this.elementAdapter.toJson(jsonWriter, (JsonWriter) obj);
        }
        jsonWriter.endArray();
    }
}