package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.w2;
import com.google.android.gms.internal.measurement.x2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class x2<MessageType extends x2<MessageType, BuilderType>, BuilderType extends w2<MessageType, BuilderType>> implements u5 {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void k(Iterable<T> iterable, List<? super T> list) {
        q4.d(iterable);
        if (iterable instanceof e5) {
            List<?> d2 = ((e5) iterable).d();
            e5 e5Var = (e5) list;
            int size = list.size();
            for (Object obj : d2) {
                if (obj == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(e5Var.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = e5Var.size() - 1; size2 >= size; size2--) {
                        e5Var.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof h3) {
                    e5Var.L0((h3) obj);
                } else {
                    e5Var.add((String) obj);
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

    @Override // com.google.android.gms.internal.measurement.u5
    public final h3 d() {
        try {
            p3 x = h3.x(i());
            f(x.b());
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

    public final byte[] l() {
        try {
            byte[] bArr = new byte[i()];
            zzel f2 = zzel.f(bArr);
            f(f2);
            f2.N();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i2) {
        throw new UnsupportedOperationException();
    }
}