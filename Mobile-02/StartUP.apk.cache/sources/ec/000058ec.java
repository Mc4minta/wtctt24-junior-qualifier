package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
public final class KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 extends o implements l<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ Annotations $annotations;
    final /* synthetic */ List<TypeProjection> $arguments;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ MemberScope $memberScope;
    final /* synthetic */ boolean $nullable;
    final /* synthetic */ KotlinTypeFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations annotations, boolean z, MemberScope memberScope) {
        super(1);
        this.this$0 = kotlinTypeFactory;
        this.$constructor = typeConstructor;
        this.$arguments = list;
        this.$annotations = annotations;
        this.$nullable = z;
        this.$memberScope = memberScope;
    }

    @Override // kotlin.e0.c.l
    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        KotlinTypeFactory.ExpandedTypeOrRefinedConstructor refineConstructor;
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        refineConstructor = this.this$0.refineConstructor(this.$constructor, kotlinTypeRefiner, this.$arguments);
        if (refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = refineConstructor.getExpandedType();
        if (expandedType == null) {
            Annotations annotations = this.$annotations;
            TypeConstructor refinedConstructor = refineConstructor.getRefinedConstructor();
            m.e(refinedConstructor);
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
        }
        return expandedType;
    }
}