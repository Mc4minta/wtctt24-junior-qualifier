package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
final class ReflectJavaClass$innerClassNames$1 extends o implements l<Class<?>, Boolean> {
    public static final ReflectJavaClass$innerClassNames$1 INSTANCE = new ReflectJavaClass$innerClassNames$1();

    ReflectJavaClass$innerClassNames$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Class<?> cls) {
        return Boolean.valueOf(invoke2(cls));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        m.f(simpleName, "it.simpleName");
        return simpleName.length() == 0;
    }
}