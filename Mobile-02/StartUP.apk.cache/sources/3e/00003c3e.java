package com.google.gson.u.n;

import com.google.gson.o;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonTreeReader.java */
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader u = new a();
    private static final Object v = new Object();
    private Object[] w;
    private int x;
    private String[] y;
    private int[] z;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes2.dex */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    public e(com.google.gson.l lVar) {
        super(u);
        this.w = new Object[32];
        this.x = 0;
        this.y = new String[32];
        this.z = new int[32];
        S0(lVar);
    }

    private void M0(com.google.gson.stream.b bVar) throws IOException {
        if (k0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + k0() + z());
    }

    private Object O0() {
        return this.w[this.x - 1];
    }

    private Object Q0() {
        Object[] objArr = this.w;
        int i2 = this.x - 1;
        this.x = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    private void S0(Object obj) {
        int i2 = this.x;
        Object[] objArr = this.w;
        if (i2 == objArr.length) {
            Object[] objArr2 = new Object[i2 * 2];
            int[] iArr = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.z, 0, iArr, 0, this.x);
            System.arraycopy(this.y, 0, strArr, 0, this.x);
            this.w = objArr2;
            this.z = iArr;
            this.y = strArr;
        }
        Object[] objArr3 = this.w;
        int i3 = this.x;
        this.x = i3 + 1;
        objArr3[i3] = obj;
    }

    private String z() {
        return " at path " + getPath();
    }

    @Override // com.google.gson.stream.a
    public boolean A() throws IOException {
        M0(com.google.gson.stream.b.BOOLEAN);
        boolean r = ((o) Q0()).r();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return r;
    }

    @Override // com.google.gson.stream.a
    public double G() throws IOException {
        com.google.gson.stream.b k0 = k0();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.NUMBER;
        if (k0 != bVar && k0 != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + k0 + z());
        }
        double t = ((o) O0()).t();
        if (!n() && (Double.isNaN(t) || Double.isInfinite(t))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + t);
        }
        Q0();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return t;
    }

    @Override // com.google.gson.stream.a
    public void J0() throws IOException {
        if (k0() == com.google.gson.stream.b.NAME) {
            O();
            this.y[this.x - 2] = "null";
        } else {
            Q0();
            int i2 = this.x;
            if (i2 > 0) {
                this.y[i2 - 1] = "null";
            }
        }
        int i3 = this.x;
        if (i3 > 0) {
            int[] iArr = this.z;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public int K() throws IOException {
        com.google.gson.stream.b k0 = k0();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.NUMBER;
        if (k0 != bVar && k0 != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + k0 + z());
        }
        int u2 = ((o) O0()).u();
        Q0();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return u2;
    }

    @Override // com.google.gson.stream.a
    public long N() throws IOException {
        com.google.gson.stream.b k0 = k0();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.NUMBER;
        if (k0 != bVar && k0 != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + k0 + z());
        }
        long w = ((o) O0()).w();
        Q0();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return w;
    }

    @Override // com.google.gson.stream.a
    public String O() throws IOException {
        M0(com.google.gson.stream.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) O0()).next();
        String str = (String) entry.getKey();
        this.y[this.x - 1] = str;
        S0(entry.getValue());
        return str;
    }

    public void R0() throws IOException {
        M0(com.google.gson.stream.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) O0()).next();
        S0(entry.getValue());
        S0(new o((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a
    public void a() throws IOException {
        M0(com.google.gson.stream.b.BEGIN_ARRAY);
        S0(((com.google.gson.i) O0()).iterator());
        this.z[this.x - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void a0() throws IOException {
        M0(com.google.gson.stream.b.NULL);
        Q0();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void b() throws IOException {
        M0(com.google.gson.stream.b.BEGIN_OBJECT);
        S0(((com.google.gson.n) O0()).s().iterator());
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.w = new Object[]{v};
        this.x = 1;
    }

    @Override // com.google.gson.stream.a
    public String e0() throws IOException {
        com.google.gson.stream.b k0 = k0();
        com.google.gson.stream.b bVar = com.google.gson.stream.b.STRING;
        if (k0 != bVar && k0 != com.google.gson.stream.b.NUMBER) {
            throw new IllegalStateException("Expected " + bVar + " but was " + k0 + z());
        }
        String l2 = ((o) Q0()).l();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return l2;
    }

    @Override // com.google.gson.stream.a
    public void f() throws IOException {
        M0(com.google.gson.stream.b.END_ARRAY);
        Q0();
        Q0();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void g() throws IOException {
        M0(com.google.gson.stream.b.END_OBJECT);
        Q0();
        Q0();
        int i2 = this.x;
        if (i2 > 0) {
            int[] iArr = this.z;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (i2 < this.x) {
            Object[] objArr = this.w;
            if (objArr[i2] instanceof com.google.gson.i) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.z[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof com.google.gson.n) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.y;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.b k0() throws IOException {
        if (this.x == 0) {
            return com.google.gson.stream.b.END_DOCUMENT;
        }
        Object O0 = O0();
        if (O0 instanceof Iterator) {
            boolean z = this.w[this.x - 2] instanceof com.google.gson.n;
            Iterator it = (Iterator) O0;
            if (!it.hasNext()) {
                return z ? com.google.gson.stream.b.END_OBJECT : com.google.gson.stream.b.END_ARRAY;
            } else if (z) {
                return com.google.gson.stream.b.NAME;
            } else {
                S0(it.next());
                return k0();
            }
        } else if (O0 instanceof com.google.gson.n) {
            return com.google.gson.stream.b.BEGIN_OBJECT;
        } else {
            if (O0 instanceof com.google.gson.i) {
                return com.google.gson.stream.b.BEGIN_ARRAY;
            }
            if (O0 instanceof o) {
                o oVar = (o) O0;
                if (oVar.D()) {
                    return com.google.gson.stream.b.STRING;
                }
                if (oVar.y()) {
                    return com.google.gson.stream.b.BOOLEAN;
                }
                if (oVar.B()) {
                    return com.google.gson.stream.b.NUMBER;
                }
                throw new AssertionError();
            } else if (O0 instanceof com.google.gson.m) {
                return com.google.gson.stream.b.NULL;
            } else {
                if (O0 == v) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.google.gson.stream.a
    public boolean m() throws IOException {
        com.google.gson.stream.b k0 = k0();
        return (k0 == com.google.gson.stream.b.END_OBJECT || k0 == com.google.gson.stream.b.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return e.class.getSimpleName();
    }
}