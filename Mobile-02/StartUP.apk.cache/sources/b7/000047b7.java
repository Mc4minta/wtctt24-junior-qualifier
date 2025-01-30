package e.g.a.c.i.v.j;

import android.database.Cursor;
import e.g.a.c.i.v.j.b0;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class p implements b0.b {
    private final Map a;

    private p(Map map) {
        this.a = map;
    }

    public static b0.b a(Map map) {
        return new p(map);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return b0.g0(this.a, (Cursor) obj);
    }
}