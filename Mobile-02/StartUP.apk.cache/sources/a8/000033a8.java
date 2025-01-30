package com.google.android.gms.internal.p000firebaseperf;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k8  reason: invalid package */
/* loaded from: classes2.dex */
final class k8<K, V> extends j8<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private static final j8<Object, Object> f6808e = new k8(null, new Object[0], 0);

    /* renamed from: f  reason: collision with root package name */
    private final transient Object f6809f;

    /* renamed from: g  reason: collision with root package name */
    private final transient Object[] f6810g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int f6811h;

    private k8(Object obj, Object[] objArr, int i2) {
        this.f6809f = obj;
        this.f6810g = objArr;
        this.f6811h = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        r0[r6] = (byte) r2;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
        r0[r6] = (short) r2;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
        r0[r7] = r2;
        r3 = r3 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <K, V> com.google.android.gms.internal.p000firebaseperf.k8<K, V> e(int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.k8.e(int, java.lang.Object[]):com.google.android.gms.internal.firebase-perf.k8");
    }

    private static IllegalArgumentException f(Object obj, Object obj2, Object[] objArr, int i2) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i2]);
        String valueOf4 = String.valueOf(objArr[i2 ^ 1]);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.j8
    final i8<Map.Entry<K, V>> b() {
        return new n8(this, this.f6810g, 0, this.f6811h);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.j8
    final i8<K> c() {
        return new p8(this, new o8(this.f6810g, 0, this.f6811h));
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.j8
    final f8<V> d() {
        return new o8(this.f6810g, 1, this.f6811h);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.j8, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.f6809f;
        Object[] objArr = this.f6810g;
        int i2 = this.f6811h;
        if (obj == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int a = d6.a(obj.hashCode());
                while (true) {
                    int i3 = a & length;
                    int i4 = bArr[i3] & 255;
                    if (i4 == 255) {
                        return null;
                    }
                    if (objArr[i4].equals(obj)) {
                        return (V) objArr[i4 ^ 1];
                    }
                    a = i3 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int a2 = d6.a(obj.hashCode());
                while (true) {
                    int i5 = a2 & length2;
                    int i6 = sArr[i5] & 65535;
                    if (i6 == 65535) {
                        return null;
                    }
                    if (objArr[i6].equals(obj)) {
                        return (V) objArr[i6 ^ 1];
                    }
                    a2 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int a3 = d6.a(obj.hashCode());
                while (true) {
                    int i7 = a3 & length3;
                    int i8 = iArr[i7];
                    if (i8 == -1) {
                        return null;
                    }
                    if (objArr[i8].equals(obj)) {
                        return (V) objArr[i8 ^ 1];
                    }
                    a3 = i7 + 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.f6811h;
    }
}