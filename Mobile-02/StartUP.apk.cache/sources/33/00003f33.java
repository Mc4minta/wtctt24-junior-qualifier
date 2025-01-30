package com.squareup.moshi;

import j.f;
import j.h;
import j.i;
import j.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class JsonReader implements Closeable {
    boolean failOnUnknown;
    boolean lenient;
    int[] pathIndices;
    String[] pathNames;
    int[] scopes;
    int stackSize;
    private Map<Class<?>, Object> tags;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.squareup.moshi.JsonReader$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$moshi$JsonReader$Token;

        static {
            int[] iArr = new int[Token.values().length];
            $SwitchMap$com$squareup$moshi$JsonReader$Token = iArr;
            try {
                iArr[Token.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Options {
        final t doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] strArr, t tVar) {
            this.strings = strArr;
            this.doubleQuoteSuffix = tVar;
        }

        public static Options of(String... strArr) {
            try {
                i[] iVarArr = new i[strArr.length];
                f fVar = new f();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    JsonUtf8Writer.string(fVar, strArr[i2]);
                    fVar.m0();
                    iVarArr[i2] = fVar.v0();
                }
                return new Options((String[]) strArr.clone(), t.r(iVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public List<String> strings() {
            return Collections.unmodifiableList(Arrays.asList(this.strings));
        }
    }

    /* loaded from: classes2.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonReader() {
        this.scopes = new int[32];
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
    }

    public static JsonReader of(h hVar) {
        return new JsonUtf8Reader(hVar);
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final boolean failOnUnknown() {
        return this.failOnUnknown;
    }

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract boolean hasNext() throws IOException;

    public final boolean isLenient() {
        return this.lenient;
    }

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract long nextLong() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract <T> T nextNull() throws IOException;

    public abstract h nextSource() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract JsonReader peekJson();

    public abstract void promoteNameToValue() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void pushScope(int i2) {
        int i3 = this.stackSize;
        int[] iArr = this.scopes;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.pathNames;
                this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.pathIndices;
                this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.scopes;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr3[i4] = i2;
    }

    public final Object readJsonValue() throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$squareup$moshi$JsonReader$Token[peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                beginArray();
                while (hasNext()) {
                    arrayList.add(readJsonValue());
                }
                endArray();
                return arrayList;
            case 2:
                LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
                beginObject();
                while (hasNext()) {
                    String nextName = nextName();
                    Object readJsonValue = readJsonValue();
                    Object put = linkedHashTreeMap.put(nextName, readJsonValue);
                    if (put != null) {
                        throw new JsonDataException("Map key '" + nextName + "' has multiple values at path " + getPath() + ": " + put + " and " + readJsonValue);
                    }
                }
                endObject();
                return linkedHashTreeMap;
            case 3:
                return nextString();
            case 4:
                return Double.valueOf(nextDouble());
            case 5:
                return Boolean.valueOf(nextBoolean());
            case 6:
                return nextNull();
            default:
                throw new IllegalStateException("Expected a value but was " + peek() + " at path " + getPath());
        }
    }

    public abstract int selectName(Options options) throws IOException;

    public abstract int selectString(Options options) throws IOException;

    public final void setFailOnUnknown(boolean z) {
        this.failOnUnknown = z;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
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

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return (T) map.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonDataException typeMismatch(Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + getPath());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + getPath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonReader(JsonReader jsonReader) {
        this.stackSize = jsonReader.stackSize;
        this.scopes = (int[]) jsonReader.scopes.clone();
        this.pathNames = (String[]) jsonReader.pathNames.clone();
        this.pathIndices = (int[]) jsonReader.pathIndices.clone();
        this.lenient = jsonReader.lenient;
        this.failOnUnknown = jsonReader.failOnUnknown;
    }
}