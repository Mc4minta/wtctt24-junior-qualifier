package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import j.f;
import j.h;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class JsonValueReader extends JsonReader {
    private static final Object JSON_READER_CLOSED = new Object();
    private Object[] stack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class JsonIterator implements Iterator<Object>, Cloneable {
        final Object[] array;
        final JsonReader.Token endToken;
        int next;

        JsonIterator(JsonReader.Token token, Object[] objArr, int i2) {
            this.endToken = token;
            this.array = objArr;
            this.next = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next < this.array.length;
        }

        @Override // java.util.Iterator
        public Object next() {
            Object[] objArr = this.array;
            int i2 = this.next;
            this.next = i2 + 1;
            return objArr[i2];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: clone */
        public JsonIterator m2200clone() {
            return new JsonIterator(this.endToken, this.array, this.next);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueReader(Object obj) {
        int[] iArr = this.scopes;
        int i2 = this.stackSize;
        iArr[i2] = 7;
        Object[] objArr = new Object[32];
        this.stack = objArr;
        this.stackSize = i2 + 1;
        objArr[i2] = obj;
    }

    private void push(Object obj) {
        int i2 = this.stackSize;
        if (i2 == this.stack.length) {
            if (i2 != 256) {
                int[] iArr = this.scopes;
                this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.pathNames;
                this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.pathIndices;
                this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
                Object[] objArr = this.stack;
                this.stack = Arrays.copyOf(objArr, objArr.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        Object[] objArr2 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        objArr2[i3] = obj;
    }

    private void remove() {
        int i2 = this.stackSize - 1;
        this.stackSize = i2;
        Object[] objArr = this.stack;
        objArr[i2] = null;
        this.scopes[i2] = 0;
        if (i2 > 0) {
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            Object obj = objArr[i2 - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    push(it.next());
                }
            }
        }
    }

    private <T> T require(Class<T> cls, JsonReader.Token token) throws IOException {
        int i2 = this.stackSize;
        Object obj = i2 != 0 ? this.stack[i2 - 1] : null;
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        if (obj == null && token == JsonReader.Token.NULL) {
            return null;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, token);
    }

    private String stringKey(Map.Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
            return (String) key;
        }
        throw typeMismatch(key, JsonReader.Token.NAME);
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginArray() throws IOException {
        List list = (List) require(List.class, JsonReader.Token.BEGIN_ARRAY);
        JsonIterator jsonIterator = new JsonIterator(JsonReader.Token.END_ARRAY, list.toArray(new Object[list.size()]), 0);
        Object[] objArr = this.stack;
        int i2 = this.stackSize;
        objArr[i2 - 1] = jsonIterator;
        this.scopes[i2 - 1] = 1;
        this.pathIndices[i2 - 1] = 0;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginObject() throws IOException {
        Map map = (Map) require(Map.class, JsonReader.Token.BEGIN_OBJECT);
        JsonIterator jsonIterator = new JsonIterator(JsonReader.Token.END_OBJECT, map.entrySet().toArray(new Object[map.size()]), 0);
        Object[] objArr = this.stack;
        int i2 = this.stackSize;
        objArr[i2 - 1] = jsonIterator;
        this.scopes[i2 - 1] = 3;
        if (jsonIterator.hasNext()) {
            push(jsonIterator.next());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Arrays.fill(this.stack, 0, this.stackSize, (Object) null);
        this.stack[0] = JSON_READER_CLOSED;
        this.scopes[0] = 8;
        this.stackSize = 1;
    }

    @Override // com.squareup.moshi.JsonReader
    public void endArray() throws IOException {
        JsonReader.Token token = JsonReader.Token.END_ARRAY;
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, token);
        if (jsonIterator.endToken == token && !jsonIterator.hasNext()) {
            remove();
            return;
        }
        throw typeMismatch(jsonIterator, token);
    }

    @Override // com.squareup.moshi.JsonReader
    public void endObject() throws IOException {
        JsonReader.Token token = JsonReader.Token.END_OBJECT;
        JsonIterator jsonIterator = (JsonIterator) require(JsonIterator.class, token);
        if (jsonIterator.endToken == token && !jsonIterator.hasNext()) {
            this.pathNames[this.stackSize - 1] = null;
            remove();
            return;
        }
        throw typeMismatch(jsonIterator, token);
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean hasNext() throws IOException {
        int i2 = this.stackSize;
        if (i2 == 0) {
            return false;
        }
        Object obj = this.stack[i2 - 1];
        return !(obj instanceof Iterator) || ((Iterator) obj).hasNext();
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
        remove();
        return ((Boolean) require(Boolean.class, JsonReader.Token.BOOLEAN)).booleanValue();
    }

    @Override // com.squareup.moshi.JsonReader
    public double nextDouble() throws IOException {
        double parseDouble;
        JsonReader.Token token = JsonReader.Token.NUMBER;
        Object require = require(Object.class, token);
        if (require instanceof Number) {
            parseDouble = ((Number) require).doubleValue();
        } else if (require instanceof String) {
            try {
                parseDouble = Double.parseDouble((String) require);
            } catch (NumberFormatException unused) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, token);
        }
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        }
        remove();
        return parseDouble;
    }

    @Override // com.squareup.moshi.JsonReader
    public int nextInt() throws IOException {
        int intValueExact;
        JsonReader.Token token = JsonReader.Token.NUMBER;
        Object require = require(Object.class, token);
        if (require instanceof Number) {
            intValueExact = ((Number) require).intValue();
        } else if (require instanceof String) {
            try {
                try {
                    intValueExact = Integer.parseInt((String) require);
                } catch (NumberFormatException unused) {
                    intValueExact = new BigDecimal((String) require).intValueExact();
                }
            } catch (NumberFormatException unused2) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, token);
        }
        remove();
        return intValueExact;
    }

    @Override // com.squareup.moshi.JsonReader
    public long nextLong() throws IOException {
        long longValueExact;
        JsonReader.Token token = JsonReader.Token.NUMBER;
        Object require = require(Object.class, token);
        if (require instanceof Number) {
            longValueExact = ((Number) require).longValue();
        } else if (require instanceof String) {
            try {
                try {
                    longValueExact = Long.parseLong((String) require);
                } catch (NumberFormatException unused) {
                    longValueExact = new BigDecimal((String) require).longValueExact();
                }
            } catch (NumberFormatException unused2) {
                throw typeMismatch(require, JsonReader.Token.NUMBER);
            }
        } else {
            throw typeMismatch(require, token);
        }
        remove();
        return longValueExact;
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextName() throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME);
        String stringKey = stringKey(entry);
        this.stack[this.stackSize - 1] = entry.getValue();
        this.pathNames[this.stackSize - 2] = stringKey;
        return stringKey;
    }

    @Override // com.squareup.moshi.JsonReader
    public <T> T nextNull() throws IOException {
        require(Void.class, JsonReader.Token.NULL);
        remove();
        return null;
    }

    @Override // com.squareup.moshi.JsonReader
    public h nextSource() throws IOException {
        Object readJsonValue = readJsonValue();
        f fVar = new f();
        JsonWriter of = JsonWriter.of(fVar);
        try {
            of.jsonValue(readJsonValue);
            of.close();
            return fVar;
        } catch (Throwable th) {
            if (of != null) {
                try {
                    of.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextString() throws IOException {
        int i2 = this.stackSize;
        String str = i2 != 0 ? this.stack[i2 - 1] : null;
        if (str instanceof String) {
            remove();
            return str;
        } else if (str instanceof Number) {
            remove();
            return str.toString();
        } else if (str == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        } else {
            throw typeMismatch(str, JsonReader.Token.STRING);
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        int i2 = this.stackSize;
        if (i2 == 0) {
            return JsonReader.Token.END_DOCUMENT;
        }
        Object obj = this.stack[i2 - 1];
        if (obj instanceof JsonIterator) {
            return ((JsonIterator) obj).endToken;
        }
        if (obj instanceof List) {
            return JsonReader.Token.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return JsonReader.Token.BEGIN_OBJECT;
        }
        if (obj instanceof Map.Entry) {
            return JsonReader.Token.NAME;
        }
        if (obj instanceof String) {
            return JsonReader.Token.STRING;
        }
        if (obj instanceof Boolean) {
            return JsonReader.Token.BOOLEAN;
        }
        if (obj instanceof Number) {
            return JsonReader.Token.NUMBER;
        }
        if (obj == null) {
            return JsonReader.Token.NULL;
        }
        if (obj == JSON_READER_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw typeMismatch(obj, "a JSON value");
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader peekJson() {
        return new JsonValueReader(this);
    }

    @Override // com.squareup.moshi.JsonReader
    public void promoteNameToValue() throws IOException {
        if (hasNext()) {
            push(nextName());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME);
        String stringKey = stringKey(entry);
        int length = options.strings.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (options.strings[i2].equals(stringKey)) {
                this.stack[this.stackSize - 1] = entry.getValue();
                this.pathNames[this.stackSize - 2] = stringKey;
                return i2;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object[]] */
    @Override // com.squareup.moshi.JsonReader
    public int selectString(JsonReader.Options options) throws IOException {
        int i2 = this.stackSize;
        String str = i2 != 0 ? this.stack[i2 - 1] : null;
        if (!(str instanceof String)) {
            if (str != JSON_READER_CLOSED) {
                return -1;
            }
            throw new IllegalStateException("JsonReader is closed");
        }
        String str2 = str;
        int length = options.strings.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (options.strings[i3].equals(str2)) {
                remove();
                return i3;
            }
        }
        return -1;
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
            this.stack[this.stackSize - 1] = ((Map.Entry) require(Map.Entry.class, JsonReader.Token.NAME)).getValue();
            this.pathNames[this.stackSize - 2] = "null";
            return;
        }
        JsonReader.Token peek = peek();
        nextName();
        throw new JsonDataException("Cannot skip unexpected " + peek + " at " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            int i2 = this.stackSize;
            if (i2 > 1) {
                this.pathNames[i2 - 2] = "null";
            }
            Object obj = i2 != 0 ? this.stack[i2 - 1] : null;
            if (!(obj instanceof JsonIterator)) {
                if (obj instanceof Map.Entry) {
                    Object[] objArr = this.stack;
                    objArr[i2 - 1] = ((Map.Entry) objArr[i2 - 1]).getValue();
                    return;
                } else if (i2 > 0) {
                    remove();
                    return;
                } else {
                    throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                }
            }
            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    JsonValueReader(JsonValueReader jsonValueReader) {
        super(jsonValueReader);
        this.stack = (Object[]) jsonValueReader.stack.clone();
        for (int i2 = 0; i2 < this.stackSize; i2++) {
            Object[] objArr = this.stack;
            if (objArr[i2] instanceof JsonIterator) {
                objArr[i2] = ((JsonIterator) objArr[i2]).m2200clone();
            }
        }
    }
}