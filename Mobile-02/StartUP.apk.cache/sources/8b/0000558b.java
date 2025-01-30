package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: classes3.dex */
final class LazyJavaStaticClassScope$computePropertyNames$1$1 extends o implements l<MemberScope, Collection<? extends Name>> {
    public static final LazyJavaStaticClassScope$computePropertyNames$1$1 INSTANCE = new LazyJavaStaticClassScope$computePropertyNames$1$1();

    LazyJavaStaticClassScope$computePropertyNames$1$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final Collection<Name> invoke(MemberScope it) {
        m.g(it, "it");
        return it.getVariableNames();
    }
}