package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
final class LazyJavaClassMemberScope$computeNonDeclaredProperties$2 extends o implements l<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$computeNonDeclaredProperties$2(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // kotlin.e0.c.l
    public final Collection<SimpleFunctionDescriptor> invoke(Name it) {
        Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic;
        m.g(it, "it");
        searchMethodsInSupertypesWithoutBuiltinMagic = this.this$0.searchMethodsInSupertypesWithoutBuiltinMagic(it);
        return searchMethodsInSupertypesWithoutBuiltinMagic;
    }
}