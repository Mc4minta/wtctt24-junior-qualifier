package com.squareup.wire;

import com.squareup.wire.o;
import java.lang.reflect.Method;
import kotlin.TypeCastException;

/* compiled from: RuntimeEnumAdapter.kt */
/* loaded from: classes2.dex */
public final class n<E extends o> extends b<E> {
    private Method a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f10875b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Class<E> javaType) {
        super(kotlin.e0.a.e(javaType));
        kotlin.jvm.internal.m.h(javaType, "javaType");
        this.f10875b = javaType;
    }

    private final Method a() {
        Method method = this.a;
        if (method != null) {
            return method;
        }
        Method method2 = this.f10875b.getMethod("fromValue", Integer.TYPE);
        this.a = method2;
        kotlin.jvm.internal.m.d(method2, "javaType.getMethod(\"from…romValueMethod = it\n    }");
        return method2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && kotlin.jvm.internal.m.c(((n) obj).getType(), getType());
    }

    @Override // com.squareup.wire.b
    protected E fromValue(int i2) {
        Object invoke = a().invoke(null, Integer.valueOf(i2));
        if (invoke != null) {
            return (E) invoke;
        }
        throw new TypeCastException("null cannot be cast to non-null type E");
    }

    public int hashCode() {
        kotlin.j0.d<?> type = getType();
        if (type != null) {
            return type.hashCode();
        }
        return 0;
    }
}