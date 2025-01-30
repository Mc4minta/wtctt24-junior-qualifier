package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class h3 implements Serializable, Iterable<Byte> {
    public static final h3 a = new r3(q4.f7315c);

    /* renamed from: b  reason: collision with root package name */
    private static final n3 f7153b;

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<h3> f7154c;

    /* renamed from: d  reason: collision with root package name */
    private int f7155d = 0;

    static {
        f7153b = a3.b() ? new q3(null) : new l3(null);
        f7154c = new j3();
    }

    public static h3 o(String str) {
        return new r3(str.getBytes(q4.a));
    }

    public static h3 p(byte[] bArr, int i2, int i3) {
        u(i2, i2 + i3, bArr.length);
        return new r3(f7153b.a(bArr, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int t(byte b2) {
        return b2 & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i2, int i3, int i4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p3 x(int i2) {
        return new p3(i2, null);
    }

    public abstract boolean equals(Object obj);

    public abstract byte h(int i2);

    public final int hashCode() {
        int i2 = this.f7155d;
        if (i2 == 0) {
            int i3 = i();
            i2 = l(i3, 0, i3);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f7155d = i2;
        }
        return i2;
    }

    public abstract int i();

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new g3(this);
    }

    protected abstract int l(int i2, int i3, int i4);

    public abstract h3 m(int i2, int i3);

    protected abstract String q(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void r(e3 e3Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte s(int i2);

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(i());
        objArr[2] = i() <= 50 ? a7.a(this) : String.valueOf(a7.a(m(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String w() {
        return i() == 0 ? "" : q(q4.a);
    }

    public abstract boolean y();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int z() {
        return this.f7155d;
    }
}