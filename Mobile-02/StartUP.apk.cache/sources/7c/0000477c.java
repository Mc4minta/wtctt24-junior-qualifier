package e.g.a.c.i;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
abstract class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        return Executors.newSingleThreadExecutor();
    }
}