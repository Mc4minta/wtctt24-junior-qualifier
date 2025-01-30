package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;

/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: classes3.dex */
final class LazyJavaStaticClassScope$computeMemberIndex$1 extends o implements l<JavaMember, Boolean> {
    public static final LazyJavaStaticClassScope$computeMemberIndex$1 INSTANCE = new LazyJavaStaticClassScope$computeMemberIndex$1();

    LazyJavaStaticClassScope$computeMemberIndex$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(JavaMember javaMember) {
        return Boolean.valueOf(invoke2(javaMember));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(JavaMember it) {
        m.g(it, "it");
        return it.isStatic();
    }
}