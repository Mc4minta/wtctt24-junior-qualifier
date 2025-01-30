package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import j.f;
import j.g;
import j.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class JsonAdapter<T> {

    /* loaded from: classes2.dex */
    public interface Factory {
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    public final JsonAdapter<T> failOnUnknown() {
        return new JsonAdapter<T>() { // from class: com.squareup.moshi.JsonAdapter.3
            @Override // com.squareup.moshi.JsonAdapter
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean failOnUnknown = jsonReader.failOnUnknown();
                jsonReader.setFailOnUnknown(true);
                try {
                    return (T) this.fromJson(jsonReader);
                } finally {
                    jsonReader.setFailOnUnknown(failOnUnknown);
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            boolean isLenient() {
                return this.isLenient();
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                this.toJson(jsonWriter, (JsonWriter) t);
            }

            public String toString() {
                return this + ".failOnUnknown()";
            }
        };
    }

    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    public final T fromJson(h hVar) throws IOException {
        return fromJson(JsonReader.of(hVar));
    }

    public final T fromJsonValue(Object obj) {
        try {
            return fromJson(new JsonValueReader(obj));
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public JsonAdapter<T> indent(final String str) {
        Objects.requireNonNull(str, "indent == null");
        return new JsonAdapter<T>() { // from class: com.squareup.moshi.JsonAdapter.4
            @Override // com.squareup.moshi.JsonAdapter
            public T fromJson(JsonReader jsonReader) throws IOException {
                return (T) this.fromJson(jsonReader);
            }

            @Override // com.squareup.moshi.JsonAdapter
            boolean isLenient() {
                return this.isLenient();
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                String indent = jsonWriter.getIndent();
                jsonWriter.setIndent(str);
                try {
                    this.toJson(jsonWriter, (JsonWriter) t);
                } finally {
                    jsonWriter.setIndent(indent);
                }
            }

            public String toString() {
                return this + ".indent(\"" + str + "\")";
            }
        };
    }

    boolean isLenient() {
        return false;
    }

    public final JsonAdapter<T> lenient() {
        return new JsonAdapter<T>() { // from class: com.squareup.moshi.JsonAdapter.2
            @Override // com.squareup.moshi.JsonAdapter
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean isLenient = jsonReader.isLenient();
                jsonReader.setLenient(true);
                try {
                    return (T) this.fromJson(jsonReader);
                } finally {
                    jsonReader.setLenient(isLenient);
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            boolean isLenient() {
                return true;
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean isLenient = jsonWriter.isLenient();
                jsonWriter.setLenient(true);
                try {
                    this.toJson(jsonWriter, (JsonWriter) t);
                } finally {
                    jsonWriter.setLenient(isLenient);
                }
            }

            public String toString() {
                return this + ".lenient()";
            }
        };
    }

    public final JsonAdapter<T> nonNull() {
        return this instanceof NonNullJsonAdapter ? this : new NonNullJsonAdapter(this);
    }

    public final JsonAdapter<T> nullSafe() {
        return this instanceof NullSafeJsonAdapter ? this : new NullSafeJsonAdapter(this);
    }

    public final JsonAdapter<T> serializeNulls() {
        return new JsonAdapter<T>() { // from class: com.squareup.moshi.JsonAdapter.1
            @Override // com.squareup.moshi.JsonAdapter
            public T fromJson(JsonReader jsonReader) throws IOException {
                return (T) this.fromJson(jsonReader);
            }

            @Override // com.squareup.moshi.JsonAdapter
            boolean isLenient() {
                return this.isLenient();
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean serializeNulls = jsonWriter.getSerializeNulls();
                jsonWriter.setSerializeNulls(true);
                try {
                    this.toJson(jsonWriter, (JsonWriter) t);
                } finally {
                    jsonWriter.setSerializeNulls(serializeNulls);
                }
            }

            public String toString() {
                return this + ".serializeNulls()";
            }
        };
    }

    public abstract void toJson(JsonWriter jsonWriter, T t) throws IOException;

    public final void toJson(g gVar, T t) throws IOException {
        toJson(JsonWriter.of(gVar), (JsonWriter) t);
    }

    public final Object toJsonValue(T t) {
        JsonValueWriter jsonValueWriter = new JsonValueWriter();
        try {
            toJson((JsonWriter) jsonValueWriter, (JsonValueWriter) t);
            return jsonValueWriter.root();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final T fromJson(String str) throws IOException {
        JsonReader of = JsonReader.of(new f().h0(str));
        T fromJson = fromJson(of);
        if (isLenient() || of.peek() == JsonReader.Token.END_DOCUMENT) {
            return fromJson;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    public final String toJson(T t) {
        f fVar = new f();
        try {
            toJson((g) fVar, (f) t);
            return fVar.G0();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}