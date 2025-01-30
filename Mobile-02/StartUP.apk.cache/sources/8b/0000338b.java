package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i3  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class i3 implements Serializable, Iterable<Byte> {
    public static final i3 a = new s3(n4.f6852c);

    /* renamed from: b  reason: collision with root package name */
    private static final o3 f6752b;

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<i3> f6753c;

    /* renamed from: d  reason: collision with root package name */
    private int f6754d = 0;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f6752b = g3.b() ? new v3(null) : new m3(null);
        f6753c = new k3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte b2) {
        return b2 & 255;
    }

    public static i3 l(String str) {
        return new s3(str.getBytes(n4.a));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q3 x(int i2) {
        return new q3(i2, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.f6754d;
        if (i2 == 0) {
            int size = size();
            i2 = o(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f6754d = i2;
        }
        return i2;
    }

    protected abstract String i(Charset charset);

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new l3(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void k(j3 j3Var) throws IOException;

    protected abstract int o(int i2, int i3, int i4);

    public abstract i3 q(int i2, int i3);

    public final String r() {
        return size() == 0 ? "" : i(n4.a);
    }

    public abstract boolean s();

    public abstract int size();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int t() {
        return this.f6754d;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? a7.a(this) : String.valueOf(a7.a(q(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte u(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte w(int i2);
}