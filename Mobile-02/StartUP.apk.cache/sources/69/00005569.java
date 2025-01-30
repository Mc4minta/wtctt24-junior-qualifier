package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 extends o implements l<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ SimpleFunctionDescriptor $function;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.$function = simpleFunctionDescriptor;
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // kotlin.e0.c.l
    public final Collection<SimpleFunctionDescriptor> invoke(Name accessorName) {
        Collection searchMethodsByNameWithoutBuiltinMagic;
        Collection searchMethodsInSupertypesWithoutBuiltinMagic;
        List t0;
        List b2;
        m.g(accessorName, "accessorName");
        if (!m.c(this.$function.getName(), accessorName)) {
            searchMethodsByNameWithoutBuiltinMagic = this.this$0.searchMethodsByNameWithoutBuiltinMagic(accessorName);
            searchMethodsInSupertypesWithoutBuiltinMagic = this.this$0.searchMethodsInSupertypesWithoutBuiltinMagic(accessorName);
            t0 = z.t0(searchMethodsByNameWithoutBuiltinMagic, searchMethodsInSupertypesWithoutBuiltinMagic);
            return t0;
        }
        b2 = q.b(this.$function);
        return b2;
    }
}