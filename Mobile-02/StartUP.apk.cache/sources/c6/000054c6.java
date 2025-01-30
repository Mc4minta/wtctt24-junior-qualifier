package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaClass$methods$1 extends o implements l<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
        return Boolean.valueOf(invoke2(method));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Method method) {
        boolean isEnumValuesOrValueOf;
        if (!method.isSynthetic()) {
            if (!this.this$0.isEnum()) {
                return true;
            }
            ReflectJavaClass reflectJavaClass = this.this$0;
            m.f(method, "method");
            isEnumValuesOrValueOf = reflectJavaClass.isEnumValuesOrValueOf(method);
            if (!isEnumValuesOrValueOf) {
                return true;
            }
        }
        return false;
    }
}