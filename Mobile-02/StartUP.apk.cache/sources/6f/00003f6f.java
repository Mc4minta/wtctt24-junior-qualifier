package com.squareup.moshi.internal;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class NullSafeJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;

    public NullSafeJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public JsonAdapter<T> delegate() {
        return this.delegate;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public T fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.NULL) {
            return (T) jsonReader.nextNull();
        }
        return this.delegate.fromJson(jsonReader);
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null) {
            jsonWriter.nullValue();
        } else {
            this.delegate.toJson(jsonWriter, (JsonWriter) t);
        }
    }

    public String toString() {
        return this.delegate + ".nullSafe()";
    }
}