package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.e0.c.l;
import kotlin.e0.c.p;
import kotlin.e0.c.q;
import kotlin.x;

/* compiled from: functions.kt */
/* loaded from: classes3.dex */
public final class FunctionsKt {
    private static final l<Object, Object> IDENTITY = FunctionsKt$IDENTITY$1.INSTANCE;
    private static final l<Object, Boolean> ALWAYS_TRUE = FunctionsKt$ALWAYS_TRUE$1.INSTANCE;
    private static final l<Object, Object> ALWAYS_NULL = FunctionsKt$ALWAYS_NULL$1.INSTANCE;
    private static final l<Object, x> DO_NOTHING = FunctionsKt$DO_NOTHING$1.INSTANCE;
    private static final p<Object, Object, x> DO_NOTHING_2 = FunctionsKt$DO_NOTHING_2$1.INSTANCE;
    private static final q<Object, Object, Object, x> DO_NOTHING_3 = FunctionsKt$DO_NOTHING_3$1.INSTANCE;

    public static final <T> l<T, Boolean> alwaysTrue() {
        return (l<T, Boolean>) ALWAYS_TRUE;
    }

    public static final q<Object, Object, Object, x> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}