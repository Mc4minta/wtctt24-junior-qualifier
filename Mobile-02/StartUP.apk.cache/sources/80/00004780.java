package e.g.a.c.i;

import android.util.Base64;
import e.g.a.c.i.c;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class l {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract l a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(e.g.a.c.d dVar);
    }

    public static a a() {
        return new c.b().d(e.g.a.c.d.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract e.g.a.c.d d();

    public l e(e.g.a.c.d dVar) {
        return a().b(b()).d(dVar).c(c()).a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}