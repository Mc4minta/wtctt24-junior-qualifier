package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes3.dex */
/* synthetic */ class ReflectJavaClass$constructors$1 extends j implements l<Member, Boolean> {
    public static final ReflectJavaClass$constructors$1 INSTANCE = new ReflectJavaClass$constructors$1();

    ReflectJavaClass$constructors$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "isSynthetic";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(Member.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
        return Boolean.valueOf(invoke2(member));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Member p0) {
        m.g(p0, "p0");
        return p0.isSynthetic();
    }
}