package kotlin.d0.d;

import kotlin.jvm.internal.m;

/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a extends kotlin.d0.a {
    @Override // kotlin.d0.a
    public void a(Throwable cause, Throwable exception) {
        m.g(cause, "cause");
        m.g(exception, "exception");
        cause.addSuppressed(exception);
    }
}