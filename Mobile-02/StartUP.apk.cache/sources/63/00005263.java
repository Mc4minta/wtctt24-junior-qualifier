package kotlin;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
public class k {
    public static <T> h<T> a(m mode, kotlin.e0.c.a<? extends T> initializer) {
        kotlin.jvm.internal.m.g(mode, "mode");
        kotlin.jvm.internal.m.g(initializer, "initializer");
        int i2 = i.a[mode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new y(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new r(initializer);
        }
        return new s(initializer, null, 2, null);
    }

    public static <T> h<T> b(kotlin.e0.c.a<? extends T> initializer) {
        kotlin.jvm.internal.m.g(initializer, "initializer");
        return new s(initializer, null, 2, null);
    }
}