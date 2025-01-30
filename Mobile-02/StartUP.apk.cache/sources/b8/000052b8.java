package kotlin;

import kotlin.p;

/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class q {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.m.g(exception, "exception");
        return new p.b(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof p.b) {
            throw ((p.b) obj).a;
        }
    }
}