package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: AbstractTypeAliasDescriptor.kt */
/* loaded from: classes3.dex */
final class AbstractTypeAliasDescriptor$computeDefaultType$1 extends o implements l<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor$computeDefaultType$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    @Override // kotlin.e0.c.l
    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor refineDescriptor = kotlinTypeRefiner.refineDescriptor(this.this$0);
        if (refineDescriptor == null) {
            return null;
        }
        return refineDescriptor.getDefaultType();
    }
}