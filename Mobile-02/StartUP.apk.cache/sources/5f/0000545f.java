package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: AbstractTypeAliasDescriptor.kt */
/* loaded from: classes3.dex */
final class AbstractTypeAliasDescriptor$isInner$1 extends o implements l<UnwrappedType, Boolean> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (((r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && !kotlin.jvm.internal.m.c(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5).getContainingDeclaration(), r0)) != false) goto L9;
     */
    @Override // kotlin.e0.c.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5) {
        /*
            r4 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.m.f(r5, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r5)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L2d
            kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor r0 = r4.this$0
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.mo2214getDeclarationDescriptor()
            boolean r3 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r3 == 0) goto L29
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            boolean r5 = kotlin.jvm.internal.m.c(r5, r0)
            if (r5 != 0) goto L29
            r5 = r1
            goto L2a
        L29:
            r5 = r2
        L2a:
            if (r5 == 0) goto L2d
            goto L2e
        L2d:
            r1 = r2
        L2e:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$isInner$1.invoke(kotlin.reflect.jvm.internal.impl.types.UnwrappedType):java.lang.Boolean");
    }
}