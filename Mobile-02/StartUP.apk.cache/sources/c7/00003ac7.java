package com.google.firebase.encoders.g;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.1.0 */
/* loaded from: classes2.dex */
final class e implements com.google.firebase.encoders.c, com.google.firebase.encoders.e {
    private e a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9093b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f9094c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.b<?>> f9095d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.d<?>> f9096e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.encoders.b<Object> f9097f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f9098g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Writer writer, Map<Class<?>, com.google.firebase.encoders.b<?>> map, Map<Class<?>, com.google.firebase.encoders.d<?>> map2, com.google.firebase.encoders.b<Object> bVar, boolean z) {
        this.f9094c = new JsonWriter(writer);
        this.f9095d = map;
        this.f9096e = map2;
        this.f9097f = bVar;
        this.f9098g = z;
    }

    private boolean p(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e s(String str, Object obj) throws IOException, EncodingException {
        u();
        this.f9094c.name(str);
        if (obj == null) {
            this.f9094c.nullValue();
            return this;
        }
        return h(obj, false);
    }

    private e t(String str, Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        u();
        this.f9094c.name(str);
        return h(obj, false);
    }

    private void u() throws IOException {
        if (this.f9093b) {
            e eVar = this.a;
            if (eVar != null) {
                eVar.u();
                this.a.f9093b = false;
                this.a = null;
                this.f9094c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public e f(int i2) throws IOException {
        u();
        this.f9094c.value(i2);
        return this;
    }

    public e g(long j2) throws IOException {
        u();
        this.f9094c.value(j2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e h(Object obj, boolean z) throws IOException {
        int[] iArr;
        int i2 = 0;
        if (z && p(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        } else if (obj == null) {
            this.f9094c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f9094c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return o((byte[]) obj);
            }
            this.f9094c.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i2 < length) {
                    this.f9094c.value(iArr[i2]);
                    i2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i2 < length2) {
                    g(jArr[i2]);
                    i2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i2 < length3) {
                    this.f9094c.value(dArr[i2]);
                    i2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i2 < length4) {
                    this.f9094c.value(zArr[i2]);
                    i2++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    h(number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    h(obj2, false);
                }
            }
            this.f9094c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f9094c.beginArray();
            for (Object obj3 : (Collection) obj) {
                h(obj3, false);
            }
            this.f9094c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f9094c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    e((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                }
            }
            this.f9094c.endObject();
            return this;
        } else {
            com.google.firebase.encoders.b<?> bVar = this.f9095d.get(obj.getClass());
            if (bVar != null) {
                return r(bVar, obj, z);
            }
            com.google.firebase.encoders.d<?> dVar = this.f9096e.get(obj.getClass());
            if (dVar != null) {
                dVar.a(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                add(((Enum) obj).name());
                return this;
            } else {
                return r(this.f9097f, obj, z);
            }
        }
    }

    @Override // com.google.firebase.encoders.e
    /* renamed from: i */
    public e add(String str) throws IOException {
        u();
        this.f9094c.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.c
    /* renamed from: j */
    public e c(String str, int i2) throws IOException {
        u();
        this.f9094c.name(str);
        return f(i2);
    }

    @Override // com.google.firebase.encoders.c
    /* renamed from: k */
    public e b(String str, long j2) throws IOException {
        u();
        this.f9094c.name(str);
        return g(j2);
    }

    @Override // com.google.firebase.encoders.c
    /* renamed from: l */
    public e e(String str, Object obj) throws IOException {
        if (this.f9098g) {
            return t(str, obj);
        }
        return s(str, obj);
    }

    @Override // com.google.firebase.encoders.c
    /* renamed from: m */
    public e a(String str, boolean z) throws IOException {
        u();
        this.f9094c.name(str);
        return d(z);
    }

    @Override // com.google.firebase.encoders.e
    /* renamed from: n */
    public e d(boolean z) throws IOException {
        u();
        this.f9094c.value(z);
        return this;
    }

    public e o(byte[] bArr) throws IOException {
        u();
        if (bArr == null) {
            this.f9094c.nullValue();
        } else {
            this.f9094c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() throws IOException {
        u();
        this.f9094c.flush();
    }

    e r(com.google.firebase.encoders.b<Object> bVar, Object obj, boolean z) throws IOException {
        if (!z) {
            this.f9094c.beginObject();
        }
        bVar.a(obj, this);
        if (!z) {
            this.f9094c.endObject();
        }
        return this;
    }
}