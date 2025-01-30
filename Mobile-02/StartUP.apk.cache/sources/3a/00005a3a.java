package kotlinx.coroutines;

/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class q {
    public static final <T> Object a(Object obj, kotlin.e0.c.l<? super Throwable, kotlin.x> lVar) {
        Throwable b2 = kotlin.p.b(obj);
        if (b2 == null) {
            return lVar != null ? new o(obj, lVar) : obj;
        }
        return new n(b2, false, 2, null);
    }

    public static final <T> Object b(Object obj, e<?> eVar) {
        Throwable b2 = kotlin.p.b(obj);
        if (b2 != null) {
            if (x.c() && (eVar instanceof kotlin.c0.i.a.d)) {
                b2 = kotlinx.coroutines.internal.n.j(b2, (kotlin.c0.i.a.d) eVar);
            }
            obj = new n(b2, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, kotlin.e0.c.l lVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            lVar = null;
        }
        return a(obj, lVar);
    }
}