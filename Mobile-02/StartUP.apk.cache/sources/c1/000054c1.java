package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$constructors$2 extends j implements l<Constructor<?>, ReflectJavaConstructor> {
    public static final ReflectJavaClass$constructors$2 INSTANCE = new ReflectJavaClass$constructors$2();

    ReflectJavaClass$constructors$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(ReflectJavaConstructor.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @Override // kotlin.e0.c.l
    public final ReflectJavaConstructor invoke(Constructor<?> p0) {
        m.g(p0, "p0");
        return new ReflectJavaConstructor(p0);
    }
}