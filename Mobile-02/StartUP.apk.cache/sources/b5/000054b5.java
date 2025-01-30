package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.a0.n;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k0.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: reflectClassUtil.kt */
/* loaded from: classes3.dex */
public final class ReflectClassUtilKt$parameterizedTypeArguments$2 extends o implements l<ParameterizedType, h<? extends Type>> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$2 INSTANCE = new ReflectClassUtilKt$parameterizedTypeArguments$2();

    ReflectClassUtilKt$parameterizedTypeArguments$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final h<Type> invoke(ParameterizedType it) {
        h<Type> s;
        m.g(it, "it");
        Type[] actualTypeArguments = it.getActualTypeArguments();
        m.f(actualTypeArguments, "it.actualTypeArguments");
        s = n.s(actualTypeArguments);
        return s;
    }
}