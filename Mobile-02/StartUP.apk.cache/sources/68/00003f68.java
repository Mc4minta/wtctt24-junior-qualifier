package com.squareup.moshi.adapters;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
    final T[] constants;
    final Class<T> enumType;
    final T fallbackValue;
    final String[] nameStrings;
    final JsonReader.Options options;
    final boolean useFallbackValue;

    EnumJsonAdapter(Class<T> cls, T t, boolean z) {
        this.enumType = cls;
        this.fallbackValue = t;
        this.useFallbackValue = z;
        try {
            T[] enumConstants = cls.getEnumConstants();
            this.constants = enumConstants;
            this.nameStrings = new String[enumConstants.length];
            int i2 = 0;
            while (true) {
                T[] tArr = this.constants;
                if (i2 < tArr.length) {
                    String name = tArr[i2].name();
                    Json json = (Json) cls.getField(name).getAnnotation(Json.class);
                    if (json != null) {
                        name = json.name();
                    }
                    this.nameStrings[i2] = name;
                    i2++;
                } else {
                    this.options = JsonReader.Options.of(this.nameStrings);
                    return;
                }
            }
        } catch (NoSuchFieldException e2) {
            throw new AssertionError("Missing field in " + cls.getName(), e2);
        }
    }

    public static <T extends Enum<T>> EnumJsonAdapter<T> create(Class<T> cls) {
        return new EnumJsonAdapter<>(cls, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.moshi.JsonAdapter
    public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        toJson(jsonWriter, (JsonWriter) ((Enum) obj));
    }

    public String toString() {
        return "EnumJsonAdapter(" + this.enumType.getName() + ")";
    }

    public EnumJsonAdapter<T> withUnknownFallback(T t) {
        return new EnumJsonAdapter<>(this.enumType, t, true);
    }

    @Override // com.squareup.moshi.JsonAdapter
    public T fromJson(JsonReader jsonReader) throws IOException {
        int selectString = jsonReader.selectString(this.options);
        if (selectString != -1) {
            return this.constants[selectString];
        }
        String path = jsonReader.getPath();
        if (this.useFallbackValue) {
            if (jsonReader.peek() == JsonReader.Token.STRING) {
                jsonReader.skipValue();
                return this.fallbackValue;
            }
            throw new JsonDataException("Expected a string but was " + jsonReader.peek() + " at path " + path);
        }
        String nextString = jsonReader.nextString();
        throw new JsonDataException("Expected one of " + Arrays.asList(this.nameStrings) + " but was " + nextString + " at path " + path);
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        Objects.requireNonNull(t, "value was null! Wrap in .nullSafe() to write nullable values.");
        jsonWriter.value(this.nameStrings[t.ordinal()]);
    }
}