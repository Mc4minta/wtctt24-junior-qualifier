package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class a0 implements Serializable, Iterable<Byte> {
    public static final a0 a = new h0(g1.f6449c);

    /* renamed from: b  reason: collision with root package name */
    private static final e0 f6364b;

    /* renamed from: c  reason: collision with root package name */
    private int f6365c = 0;

    static {
        f6364b = u.b() ? new i0(null) : new c0(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) < 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Beginning index: ");
                sb.append(i2);
                sb.append(" < 0");
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i3 < i2) {
                StringBuilder sb2 = new StringBuilder(66);
                sb2.append("Beginning index larger than ending index: ");
                sb2.append(i2);
                sb2.append(", ");
                sb2.append(i3);
                throw new IndexOutOfBoundsException(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("End index: ");
                sb3.append(i3);
                sb3.append(" >= ");
                sb3.append(i4);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
        }
        return i5;
    }

    public static a0 q(byte[] bArr, int i2, int i3) {
        return new h0(f6364b.a(bArr, i2, i3));
    }

    public static a0 r(String str) {
        return new h0(str.getBytes(g1.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f0 t(int i2) {
        return new f0(i2, null);
    }

    public abstract boolean equals(Object obj);

    protected abstract int h(int i2, int i3, int i4);

    public final int hashCode() {
        int i2 = this.f6365c;
        if (i2 == 0) {
            int size = size();
            i2 = h(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f6365c = i2;
        }
        return i2;
    }

    public abstract a0 i(int i2, int i3);

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new b0(this);
    }

    protected abstract String k(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void l(z zVar) throws IOException;

    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int o() {
        return this.f6365c;
    }

    public abstract byte s(int i2);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public final String u() {
        return size() == 0 ? "" : k(g1.a);
    }
}