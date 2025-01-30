package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.j0.m;

/* compiled from: storage.kt */
/* loaded from: classes3.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> notNullLazyValue, Object obj, m<?> p) {
        kotlin.jvm.internal.m.g(notNullLazyValue, "<this>");
        kotlin.jvm.internal.m.g(p, "p");
        return (T) notNullLazyValue.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> nullableLazyValue, Object obj, m<?> p) {
        kotlin.jvm.internal.m.g(nullableLazyValue, "<this>");
        kotlin.jvm.internal.m.g(p, "p");
        return (T) nullableLazyValue.invoke();
    }
}