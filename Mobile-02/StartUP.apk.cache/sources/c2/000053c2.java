package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes3.dex */
final class JvmBuiltInsCustomizer$getFunctions$2 extends o implements l<MemberScope, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ Name $name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$getFunctions$2(Name name) {
        super(1);
        this.$name = name;
    }

    @Override // kotlin.e0.c.l
    public final Collection<SimpleFunctionDescriptor> invoke(MemberScope it) {
        m.g(it, "it");
        return it.getContributedFunctions(this.$name, NoLookupLocation.FROM_BUILTINS);
    }
}