package com.squareup.moshi;

import j.f;
import j.g;
import j.k;
import j.q;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class JsonValueWriter extends JsonWriter {
    private String deferredName;
    Object[] stack = new Object[32];

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueWriter() {
        pushScope(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JsonValueWriter add(Object obj) {
        String str;
        Object put;
        int peekScope = peekScope();
        int i2 = this.stackSize;
        if (i2 == 1) {
            if (peekScope == 6) {
                this.scopes[i2 - 1] = 7;
                this.stack[i2 - 1] = obj;
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (peekScope != 3 || (str = this.deferredName) == null) {
            if (peekScope != 1) {
                if (peekScope == 9) {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                }
                throw new IllegalStateException("Nesting problem.");
            }
            ((List) this.stack[i2 - 1]).add(obj);
        } else if ((obj == null && !this.serializeNulls) || (put = ((Map) this.stack[i2 - 1]).put(str, obj)) == null) {
            this.deferredName = null;
        } else {
            throw new IllegalArgumentException("Map key '" + this.deferredName + "' has multiple values at path " + getPath() + ": " + put + " and " + obj);
        }
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginArray() throws IOException {
        if (!this.promoteValueToName) {
            int i2 = this.stackSize;
            int i3 = this.flattenStackSize;
            if (i2 == i3 && this.scopes[i2 - 1] == 1) {
                this.flattenStackSize = ~i3;
                return this;
            }
            checkStack();
            ArrayList arrayList = new ArrayList();
            add(arrayList);
            Object[] objArr = this.stack;
            int i4 = this.stackSize;
            objArr[i4] = arrayList;
            this.pathIndices[i4] = 0;
            pushScope(1);
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginObject() throws IOException {
        if (!this.promoteValueToName) {
            int i2 = this.stackSize;
            int i3 = this.flattenStackSize;
            if (i2 == i3 && this.scopes[i2 - 1] == 3) {
                this.flattenStackSize = ~i3;
                return this;
            }
            checkStack();
            LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
            add(linkedHashTreeMap);
            this.stack[this.stackSize] = linkedHashTreeMap;
            pushScope(3);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i2 = this.stackSize;
        if (i2 <= 1 && (i2 != 1 || this.scopes[i2 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endArray() throws IOException {
        if (peekScope() == 1) {
            int i2 = this.stackSize;
            int i3 = this.flattenStackSize;
            if (i2 == (~i3)) {
                this.flattenStackSize = ~i3;
                return this;
            }
            int i4 = i2 - 1;
            this.stackSize = i4;
            this.stack[i4] = null;
            int[] iArr = this.pathIndices;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endObject() throws IOException {
        if (peekScope() == 3) {
            if (this.deferredName == null) {
                int i2 = this.stackSize;
                int i3 = this.flattenStackSize;
                if (i2 == (~i3)) {
                    this.flattenStackSize = ~i3;
                    return this;
                }
                this.promoteValueToName = false;
                int i4 = i2 - 1;
                this.stackSize = i4;
                this.stack[i4] = null;
                this.pathNames[i4] = null;
                int[] iArr = this.pathIndices;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.stackSize != 0) {
            if (peekScope() == 3 && this.deferredName == null && !this.promoteValueToName) {
                this.deferredName = str;
                this.pathNames[this.stackSize - 1] = str;
                return this;
            }
            throw new IllegalStateException("Nesting problem.");
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter nullValue() throws IOException {
        if (!this.promoteValueToName) {
            add(null);
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    public Object root() {
        int i2 = this.stackSize;
        if (i2 <= 1 && (i2 != 1 || this.scopes[i2 - 1] == 7)) {
            return this.stack[0];
        }
        throw new IllegalStateException("Incomplete document");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(str);
        }
        add(str);
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public g valueSink() {
        if (!this.promoteValueToName) {
            if (peekScope() != 9) {
                pushScope(9);
                final f fVar = new f();
                return q.c(new k(fVar) { // from class: com.squareup.moshi.JsonValueWriter.1
                    @Override // j.k, j.c0, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        if (JsonValueWriter.this.peekScope() == 9) {
                            JsonValueWriter jsonValueWriter = JsonValueWriter.this;
                            Object[] objArr = jsonValueWriter.stack;
                            int i2 = jsonValueWriter.stackSize;
                            if (objArr[i2] == null) {
                                jsonValueWriter.stackSize = i2 - 1;
                                Object readJsonValue = JsonReader.of(fVar).readJsonValue();
                                JsonValueWriter jsonValueWriter2 = JsonValueWriter.this;
                                boolean z = jsonValueWriter2.serializeNulls;
                                jsonValueWriter2.serializeNulls = true;
                                try {
                                    jsonValueWriter2.add(readJsonValue);
                                    JsonValueWriter jsonValueWriter3 = JsonValueWriter.this;
                                    jsonValueWriter3.serializeNulls = z;
                                    int[] iArr = jsonValueWriter3.pathIndices;
                                    int i3 = jsonValueWriter3.stackSize - 1;
                                    iArr[i3] = iArr[i3] + 1;
                                    return;
                                } catch (Throwable th) {
                                    JsonValueWriter.this.serializeNulls = z;
                                    throw th;
                                }
                            }
                        }
                        throw new AssertionError();
                    }
                });
            }
            throw new IllegalStateException("Sink from valueSink() was not closed");
        }
        throw new IllegalStateException("BufferedSink cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(boolean z) throws IOException {
        if (!this.promoteValueToName) {
            add(Boolean.valueOf(z));
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (!this.promoteValueToName) {
            add(bool);
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(double d2) throws IOException {
        if (!this.lenient && (Double.isNaN(d2) || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        } else if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Double.toString(d2));
        } else {
            add(Double.valueOf(d2));
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(long j2) throws IOException {
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Long.toString(j2));
        }
        add(Long.valueOf(j2));
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (!(number instanceof Byte) && !(number instanceof Short) && !(number instanceof Integer) && !(number instanceof Long)) {
            if ((number instanceof Float) || (number instanceof Double)) {
                return value(number.doubleValue());
            }
            if (number == null) {
                return nullValue();
            }
            BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
            if (this.promoteValueToName) {
                this.promoteValueToName = false;
                return name(bigDecimal.toString());
            }
            add(bigDecimal);
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        return value(number.longValue());
    }
}