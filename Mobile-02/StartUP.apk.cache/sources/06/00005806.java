package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubstitutingScope.kt */
/* loaded from: classes3.dex */
public final class SubstitutingScope$_allDescriptors$2 extends o implements a<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ SubstitutingScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        super(0);
        this.this$0 = substitutingScope;
    }

    @Override // kotlin.e0.c.a
    public final Collection<? extends DeclarationDescriptor> invoke() {
        MemberScope memberScope;
        Collection<? extends DeclarationDescriptor> substitute;
        SubstitutingScope substitutingScope = this.this$0;
        memberScope = substitutingScope.workerScope;
        substitute = substitutingScope.substitute(ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, null, null, 3, null));
        return substitute;
    }
}