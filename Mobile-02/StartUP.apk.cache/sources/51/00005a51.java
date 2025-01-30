package kotlinx.coroutines;

import kotlin.p;

/* compiled from: DebugStrings.kt */
/* loaded from: classes3.dex */
public final class y {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(kotlin.c0.d<?> dVar) {
        String a;
        if (dVar instanceof kotlinx.coroutines.internal.d) {
            return dVar.toString();
        }
        try {
            p.a aVar = kotlin.p.a;
            a = kotlin.p.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            p.a aVar2 = kotlin.p.a;
            a = kotlin.p.a(kotlin.q.a(th));
        }
        if (kotlin.p.b(a) != null) {
            a = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) a;
    }
}