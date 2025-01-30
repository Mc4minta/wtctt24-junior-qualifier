package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.b3;
import com.google.android.gms.internal.p000firebaseperf.c3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c3  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class c3<MessageType extends c3<MessageType, BuilderType>, BuilderType extends b3<MessageType, BuilderType>> implements v5 {
    protected int zzmu = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void f(Iterable<T> iterable, List<? super T> list) {
        n4.a(iterable);
        if (iterable instanceof b5) {
            List<?> X0 = ((b5) iterable).X0();
            b5 b5Var = (b5) list;
            int size = list.size();
            for (Object obj : X0) {
                if (obj == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(b5Var.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = b5Var.size() - 1; size2 >= size; size2--) {
                        b5Var.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof i3) {
                    b5Var.y0((i3) obj);
                } else {
                    b5Var.add((String) obj);
                }
            }
        } else if (iterable instanceof f6) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T t : iterable) {
                if (t == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(t);
            }
        }
    }

    public final byte[] a() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            zzev f2 = zzev.f(bArr);
            e(f2);
            f2.r0();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.v5
    public final i3 c() {
        try {
            q3 x = i3.x(getSerializedSize());
            e(x.b());
            return x.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i2) {
        throw new UnsupportedOperationException();
    }
}