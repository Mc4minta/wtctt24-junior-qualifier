package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$methods$2 extends j implements l<Method, ReflectJavaMethod> {
    public static final ReflectJavaClass$methods$2 INSTANCE = new ReflectJavaClass$methods$2();

    ReflectJavaClass$methods$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(ReflectJavaMethod.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @Override // kotlin.e0.c.l
    public final ReflectJavaMethod invoke(Method p0) {
        m.g(p0, "p0");
        return new ReflectJavaMethod(p0);
    }
}