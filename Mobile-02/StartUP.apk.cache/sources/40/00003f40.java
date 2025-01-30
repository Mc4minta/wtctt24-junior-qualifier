package com.squareup.moshi;

import j.g;
import j.h;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class JsonWriter implements Closeable, Flushable {
    String indent;
    boolean lenient;
    boolean promoteValueToName;
    boolean serializeNulls;
    private Map<Class<?>, Object> tags;
    int stackSize = 0;
    int[] scopes = new int[32];
    String[] pathNames = new String[32];
    int[] pathIndices = new int[32];
    int flattenStackSize = -1;

    public static JsonWriter of(g gVar) {
        return new JsonUtf8Writer(gVar);
    }

    public abstract JsonWriter beginArray() throws IOException;

    public final int beginFlatten() {
        int peekScope = peekScope();
        if (peekScope != 5 && peekScope != 3 && peekScope != 2 && peekScope != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        int i2 = this.flattenStackSize;
        this.flattenStackSize = this.stackSize;
        return i2;
    }

    public abstract JsonWriter beginObject() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean checkStack() {
        int i2 = this.stackSize;
        int[] iArr = this.scopes;
        if (i2 != iArr.length) {
            return false;
        }
        if (i2 != 256) {
            this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.pathNames;
            this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.pathIndices;
            this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
            if (this instanceof JsonValueWriter) {
                JsonValueWriter jsonValueWriter = (JsonValueWriter) this;
                Object[] objArr = jsonValueWriter.stack;
                jsonValueWriter.stack = Arrays.copyOf(objArr, objArr.length * 2);
                return true;
            }
            return true;
        }
        throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
    }

    public abstract JsonWriter endArray() throws IOException;

    public final void endFlatten(int i2) {
        this.flattenStackSize = i2;
    }

    public abstract JsonWriter endObject() throws IOException;

    public final String getIndent() {
        String str = this.indent;
        return str != null ? str : "";
    }

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public final JsonWriter jsonValue(Object obj) throws IOException {
        if (obj instanceof Map) {
            beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw new IllegalArgumentException(key == null ? "Map keys must be non-null" : "Map keys must be of type String: " + key.getClass().getName());
                }
                name((String) key);
                jsonValue(entry.getValue());
            }
            endObject();
        } else if (obj instanceof List) {
            beginArray();
            for (Object obj2 : (List) obj) {
                jsonValue(obj2);
            }
            endArray();
        } else if (obj instanceof String) {
            value((String) obj);
        } else if (obj instanceof Boolean) {
            value(((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            value(((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            value(((Long) obj).longValue());
        } else if (obj instanceof Number) {
            value((Number) obj);
        } else if (obj == null) {
            nullValue();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getName());
        }
        return this;
    }

    public abstract JsonWriter name(String str) throws IOException;

    public abstract JsonWriter nullValue() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int peekScope() {
        int i2 = this.stackSize;
        if (i2 != 0) {
            return this.scopes[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void promoteValueToName() throws IOException {
        int peekScope = peekScope();
        if (peekScope != 5 && peekScope != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.promoteValueToName = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void pushScope(int i2) {
        int[] iArr = this.scopes;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr[i3] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void replaceTop(int i2) {
        this.scopes[this.stackSize - 1] = i2;
    }

    public void setIndent(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.indent = str;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public final <T> void setTag(Class<T> cls, T t) {
        if (cls.isAssignableFrom(t.getClass())) {
            if (this.tags == null) {
                this.tags = new LinkedHashMap();
            }
            this.tags.put(cls, t);
            return;
        }
        throw new IllegalArgumentException("Tag value must be of type " + cls.getName());
    }

    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return (T) map.get(cls);
    }

    public abstract JsonWriter value(double d2) throws IOException;

    public abstract JsonWriter value(long j2) throws IOException;

    public final JsonWriter value(h hVar) throws IOException {
        if (!this.promoteValueToName) {
            g valueSink = valueSink();
            try {
                hVar.T0(valueSink);
                if (valueSink != null) {
                    valueSink.close();
                }
                return this;
            } catch (Throwable th) {
                if (valueSink != null) {
                    try {
                        valueSink.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        throw new IllegalStateException("BufferedSource cannot be used as a map key in JSON at path " + getPath());
    }

    public abstract JsonWriter value(Boolean bool) throws IOException;

    public abstract JsonWriter value(Number number) throws IOException;

    public abstract JsonWriter value(String str) throws IOException;

    public abstract JsonWriter value(boolean z) throws IOException;

    public abstract g valueSink() throws IOException;
}