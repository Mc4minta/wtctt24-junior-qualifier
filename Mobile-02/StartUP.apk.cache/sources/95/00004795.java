package e.g.a.c.i.v;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public abstract class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static s a(Context context, e.g.a.c.i.v.j.c cVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.g gVar, e.g.a.c.i.w.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.datatransport.runtime.scheduling.jobscheduling.e(context, cVar, gVar);
        }
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(context, cVar, aVar, gVar);
    }
}