package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.e0.c.a;

/* compiled from: storage.kt */
/* loaded from: classes3.dex */
public interface NotNullLazyValue<T> extends a<T> {
    @Override // kotlin.e0.c.a
    /* synthetic */ R invoke();

    boolean isComputed();
}