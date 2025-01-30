package e.g.a.c.i;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class r implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public interface a {
        a a(Context context);

        r build();
    }

    abstract e.g.a.c.i.v.j.c a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract q b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}