package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class MapJsonAdapter<K, V> extends JsonAdapter<Map<K, V>> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() { // from class: com.squareup.moshi.MapJsonAdapter.1
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType;
            if (set.isEmpty() && (rawType = Types.getRawType(type)) == Map.class) {
                Type[] mapKeyAndValueTypes = Types.mapKeyAndValueTypes(type, rawType);
                return new MapJsonAdapter(moshi, mapKeyAndValueTypes[0], mapKeyAndValueTypes[1]).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<K> keyAdapter;
    private final JsonAdapter<V> valueAdapter;

    MapJsonAdapter(Moshi moshi, Type type, Type type2) {
        this.keyAdapter = moshi.adapter(type);
        this.valueAdapter = moshi.adapter(type2);
    }

    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        toJson(jsonWriter, (Map) ((Map) obj));
    }

    public String toString() {
        return "JsonAdapter(" + this.keyAdapter + "=" + this.valueAdapter + ")";
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Map<K, V> fromJson(JsonReader jsonReader) throws IOException {
        LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            jsonReader.promoteNameToValue();
            K fromJson = this.keyAdapter.fromJson(jsonReader);
            V fromJson2 = this.valueAdapter.fromJson(jsonReader);
            Object put = linkedHashTreeMap.put(fromJson, fromJson2);
            if (put != null) {
                throw new JsonDataException("Map key '" + fromJson + "' has multiple values at path " + jsonReader.getPath() + ": " + put + " and " + fromJson2);
            }
        }
        jsonReader.endObject();
        return linkedHashTreeMap;
    }

    public void toJson(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
        jsonWriter.beginObject();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                jsonWriter.promoteValueToName();
                this.keyAdapter.toJson(jsonWriter, (JsonWriter) entry.getKey());
                this.valueAdapter.toJson(jsonWriter, (JsonWriter) entry.getValue());
            } else {
                throw new JsonDataException("Map key is null at " + jsonWriter.getPath());
            }
        }
        jsonWriter.endObject();
    }
}