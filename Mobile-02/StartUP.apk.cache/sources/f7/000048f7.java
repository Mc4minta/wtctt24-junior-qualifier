package e.h.a.b;

import android.os.Looper;
import h.c.k0.c;
import h.c.z;
import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class a {
    public static boolean a(z<?> zVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            zVar.onSubscribe(c.b());
            zVar.onError(new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName()));
            return false;
        }
        return true;
    }

    public static void b(Object obj, String str) {
        Objects.requireNonNull(obj, str);
    }
}