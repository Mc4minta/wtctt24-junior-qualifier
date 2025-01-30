package com.squareup.moshi;

import j.c0;
import j.f;
import j.f0;
import j.g;
import j.q;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class JsonUtf8Writer extends JsonWriter {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private String separator = ":";
    private final g sink;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            REPLACEMENT_CHARS[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Writer(g gVar) {
        Objects.requireNonNull(gVar, "sink == null");
        this.sink = gVar;
        pushScope(6);
    }

    private void beforeName() throws IOException {
        int peekScope = peekScope();
        if (peekScope == 5) {
            this.sink.R(44);
        } else if (peekScope != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int peekScope = peekScope();
        int i2 = 7;
        if (peekScope != 1) {
            if (peekScope == 2) {
                this.sink.R(44);
            } else {
                if (peekScope == 4) {
                    i2 = 5;
                    this.sink.h0(this.separator);
                } else if (peekScope == 9) {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                } else {
                    if (peekScope != 6) {
                        if (peekScope == 7) {
                            if (!this.lenient) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                }
                replaceTop(i2);
            }
        }
        newline();
        i2 = 2;
        replaceTop(i2);
    }

    private JsonWriter close(int i2, int i3, char c2) throws IOException {
        int peekScope = peekScope();
        if (peekScope != i3 && peekScope != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName == null) {
            int i4 = this.stackSize;
            int i5 = this.flattenStackSize;
            if (i4 == (~i5)) {
                this.flattenStackSize = ~i5;
                return this;
            }
            int i6 = i4 - 1;
            this.stackSize = i6;
            this.pathNames[i6] = null;
            int[] iArr = this.pathIndices;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
            if (peekScope == i3) {
                newline();
            }
            this.sink.R(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.sink.R(10);
        int i2 = this.stackSize;
        for (int i3 = 1; i3 < i2; i3++) {
            this.sink.h0(this.indent);
        }
    }

    private JsonWriter open(int i2, int i3, char c2) throws IOException {
        int i4 = this.stackSize;
        int i5 = this.flattenStackSize;
        if (i4 == i5) {
            int[] iArr = this.scopes;
            if (iArr[i4 - 1] == i2 || iArr[i4 - 1] == i3) {
                this.flattenStackSize = ~i5;
                return this;
            }
        }
        beforeValue();
        checkStack();
        pushScope(i2);
        this.pathIndices[this.stackSize - 1] = 0;
        this.sink.R(c2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void string(j.g r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.squareup.moshi.JsonUtf8Writer.REPLACEMENT_CHARS
            r1 = 34
            r7.R(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.q0(r8, r4, r3)
        L2e:
            r7.h0(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.q0(r8, r4, r2)
        L3b:
            r7.R(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Writer.string(j.g, java.lang.String):void");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.sink, this.deferredName);
            this.deferredName = null;
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginArray() throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            return open(1, 2, '[');
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter beginObject() throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            return open(3, 5, '{');
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endArray() throws IOException {
        return close(1, 2, ']');
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter endObject() throws IOException {
        this.promoteValueToName = false;
        return close(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.stackSize != 0) {
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.stackSize != 0) {
            int peekScope = peekScope();
            if ((peekScope == 3 || peekScope == 5) && this.deferredName == null && !this.promoteValueToName) {
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
            if (this.deferredName != null) {
                if (this.serializeNulls) {
                    writeDeferredName();
                } else {
                    this.deferredName = null;
                    return this;
                }
            }
            beforeValue();
            this.sink.h0("null");
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public void setIndent(String str) {
        super.setIndent(str);
        this.separator = !str.isEmpty() ? ": " : ":";
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(str);
        }
        writeDeferredName();
        beforeValue();
        string(this.sink, str);
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public g valueSink() throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            beforeValue();
            pushScope(9);
            return q.c(new c0() { // from class: com.squareup.moshi.JsonUtf8Writer.1
                @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    if (JsonUtf8Writer.this.peekScope() == 9) {
                        JsonUtf8Writer jsonUtf8Writer = JsonUtf8Writer.this;
                        int i2 = jsonUtf8Writer.stackSize - 1;
                        jsonUtf8Writer.stackSize = i2;
                        int[] iArr = jsonUtf8Writer.pathIndices;
                        int i3 = i2 - 1;
                        iArr[i3] = iArr[i3] + 1;
                        return;
                    }
                    throw new AssertionError();
                }

                @Override // j.c0, java.io.Flushable
                public void flush() throws IOException {
                    JsonUtf8Writer.this.sink.flush();
                }

                @Override // j.c0
                public f0 timeout() {
                    return f0.NONE;
                }

                @Override // j.c0
                public void write(f fVar, long j2) throws IOException {
                    JsonUtf8Writer.this.sink.write(fVar, j2);
                }
            });
        }
        throw new IllegalStateException("BufferedSink cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(boolean z) throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            beforeValue();
            this.sink.h0(z ? "true" : "false");
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.sink.close();
        int i2 = this.stackSize;
        if (i2 <= 1 && (i2 != 1 || this.scopes[i2 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        return value(bool.booleanValue());
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(double d2) throws IOException {
        if (!this.lenient && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        } else if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Double.toString(d2));
        } else {
            writeDeferredName();
            beforeValue();
            this.sink.h0(Double.toString(d2));
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
        writeDeferredName();
        beforeValue();
        this.sink.h0(Long.toString(j2));
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        } else if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(obj);
        } else {
            writeDeferredName();
            beforeValue();
            this.sink.h0(obj);
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this;
        }
    }
}