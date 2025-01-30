package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;

/* compiled from: functions.kt */
/* loaded from: classes3.dex */
final class FunctionsKt$ALWAYS_TRUE$1 extends o implements l<Object, Boolean> {
    public static final FunctionsKt$ALWAYS_TRUE$1 INSTANCE = new FunctionsKt$ALWAYS_TRUE$1();

    FunctionsKt$ALWAYS_TRUE$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Object obj) {
        return true;
    }
}