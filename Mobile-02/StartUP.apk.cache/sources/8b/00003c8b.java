package com.google.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ByteString.java */
/* loaded from: classes2.dex */
public abstract class e implements Iterable<Byte>, Serializable {
    public static final e a = new g(k.f9729c);

    /* renamed from: b  reason: collision with root package name */
    private static final d f9687b;

    /* renamed from: c  reason: collision with root package name */
    private int f9688c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    public class a implements InterfaceC0202e {
        private int a = 0;

        /* renamed from: b  reason: collision with root package name */
        private final int f9689b;

        a() {
            this.f9689b = e.this.size();
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.f9689b;
        }

        public byte nextByte() {
            try {
                e eVar = e.this;
                int i2 = this.a;
                this.a = i2 + 1;
                return eVar.h(i2);
            } catch (IndexOutOfBoundsException e2) {
                throw new NoSuchElementException(e2.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    private static final class b implements d {
        private b() {
        }

        @Override // com.google.protobuf.e.d
        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    public static final class c extends g {

        /* renamed from: e  reason: collision with root package name */
        private final int f9691e;

        /* renamed from: f  reason: collision with root package name */
        private final int f9692f;

        c(byte[] bArr, int i2, int i3) {
            super(bArr);
            e.k(i2, i2 + i3, bArr.length);
            this.f9691e = i2;
            this.f9692f = i3;
        }

        @Override // com.google.protobuf.e.g, com.google.protobuf.e
        public byte h(int i2) {
            e.i(i2, size());
            return this.f9693d[this.f9691e + i2];
        }

        @Override // com.google.protobuf.e.g, com.google.protobuf.e
        public int size() {
            return this.f9692f;
        }

        @Override // com.google.protobuf.e.g
        protected int z() {
            return this.f9691e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    public interface d {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    /* compiled from: ByteString.java */
    /* renamed from: com.google.protobuf.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0202e extends Iterator<Byte> {
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    static abstract class f extends e {
        f() {
        }

        @Override // com.google.protobuf.e, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    public static class g extends f {

        /* renamed from: d  reason: collision with root package name */
        protected final byte[] f9693d;

        g(byte[] bArr) {
            this.f9693d = bArr;
        }

        @Override // com.google.protobuf.e
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if ((obj instanceof e) && size() == ((e) obj).size()) {
                if (size() == 0) {
                    return true;
                }
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    int r = r();
                    int r2 = gVar.r();
                    if (r == 0 || r2 == 0 || r == r2) {
                        return y(gVar, 0, size());
                    }
                    return false;
                }
                return obj.equals(this);
            }
            return false;
        }

        @Override // com.google.protobuf.e
        public byte h(int i2) {
            return this.f9693d[i2];
        }

        @Override // com.google.protobuf.e
        public final com.google.protobuf.f p() {
            return com.google.protobuf.f.f(this.f9693d, z(), size(), true);
        }

        @Override // com.google.protobuf.e
        protected final int q(int i2, int i3, int i4) {
            return k.c(i2, this.f9693d, z() + i3, i4);
        }

        @Override // com.google.protobuf.e
        public final e s(int i2, int i3) {
            int k2 = e.k(i2, i3, size());
            if (k2 == 0) {
                return e.a;
            }
            return new c(this.f9693d, z() + i2, k2);
        }

        @Override // com.google.protobuf.e
        public int size() {
            return this.f9693d.length;
        }

        @Override // com.google.protobuf.e
        protected final String u(Charset charset) {
            return new String(this.f9693d, z(), size(), charset);
        }

        final boolean y(e eVar, int i2, int i3) {
            if (i3 <= eVar.size()) {
                int i4 = i2 + i3;
                if (i4 <= eVar.size()) {
                    if (eVar instanceof g) {
                        g gVar = (g) eVar;
                        byte[] bArr = this.f9693d;
                        byte[] bArr2 = gVar.f9693d;
                        int z = z() + i3;
                        int z2 = z();
                        int z3 = gVar.z() + i2;
                        while (z2 < z) {
                            if (bArr[z2] != bArr2[z3]) {
                                return false;
                            }
                            z2++;
                            z3++;
                        }
                        return true;
                    }
                    return eVar.s(i2, i4).equals(s(0, i3));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + eVar.size());
            }
            throw new IllegalArgumentException("Length too large: " + i3 + size());
        }

        protected int z() {
            return 0;
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes2.dex */
    private static final class h implements d {
        private h() {
        }

        @Override // com.google.protobuf.e.d
        public byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        boolean z = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f9687b = z ? new h(null) : new b(null);
    }

    e() {
    }

    static void i(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
        }
    }

    static int k(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) < 0) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
            } else if (i3 < i2) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
            } else {
                throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
            }
        }
        return i5;
    }

    public static e l(byte[] bArr, int i2, int i3) {
        return new g(f9687b.a(bArr, i2, i3));
    }

    public static e m(String str) {
        return new g(str.getBytes(k.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e w(byte[] bArr) {
        return new g(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e x(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    public abstract boolean equals(Object obj);

    public abstract byte h(int i2);

    public final int hashCode() {
        int i2 = this.f9688c;
        if (i2 == 0) {
            int size = size();
            i2 = q(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f9688c = i2;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    /* renamed from: o */
    public final InterfaceC0202e iterator() {
        return new a();
    }

    public abstract com.google.protobuf.f p();

    protected abstract int q(int i2, int i3, int i4);

    protected final int r() {
        return this.f9688c;
    }

    public abstract e s(int i2, int i3);

    public abstract int size();

    public final String t(Charset charset) {
        return size() == 0 ? "" : u(charset);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract String u(Charset charset);
}