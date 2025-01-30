package kotlin.io;

import java.io.Closeable;
import kotlin.c;

/* compiled from: Closeable.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            c.a(th, th2);
        }
    }
}