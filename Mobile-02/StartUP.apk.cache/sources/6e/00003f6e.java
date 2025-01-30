package com.squareup.moshi.internal;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class NonNullJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;

    public NonNullJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public JsonAdapter<T> delegate() {
        return this.delegate;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public T fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonReader.Token.NULL) {
            return this.delegate.fromJson(jsonReader);
        }
        throw new JsonDataException("Unexpected null at " + jsonReader.getPath());
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        if (t != null) {
            this.delegate.toJson(jsonWriter, (JsonWriter) t);
            return;
        }
        throw new JsonDataException("Unexpected null at " + jsonWriter.getPath());
    }

    public String toString() {
        return this.delegate + ".nonNull()";
    }
}