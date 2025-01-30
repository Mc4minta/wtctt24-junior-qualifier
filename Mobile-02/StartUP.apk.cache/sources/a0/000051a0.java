package kotlin;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public class c {
    public static void a(Throwable addSuppressed, Throwable exception) {
        kotlin.jvm.internal.m.g(addSuppressed, "$this$addSuppressed");
        kotlin.jvm.internal.m.g(exception, "exception");
        if (addSuppressed != exception) {
            kotlin.d0.b.a.a(addSuppressed, exception);
        }
    }
}