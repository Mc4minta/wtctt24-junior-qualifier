package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
public final class KotlinTypeFactory$simpleType$1 extends o implements l<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ Annotations $annotations;
    final /* synthetic */ List<TypeProjection> $arguments;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ boolean $nullable;
    final /* synthetic */ KotlinTypeFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KotlinTypeFactory$simpleType$1(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations annotations, boolean z) {
        super(1);
        this.this$0 = kotlinTypeFactory;
        this.$constructor = typeConstructor;
        this.$arguments = list;
        this.$annotations = annotations;
        this.$nullable = z;
    }

    @Override // kotlin.e0.c.l
    public final SimpleType invoke(KotlinTypeRefiner refiner) {
        KotlinTypeFactory.ExpandedTypeOrRefinedConstructor refineConstructor;
        m.g(refiner, "refiner");
        refineConstructor = this.this$0.refineConstructor(this.$constructor, refiner, this.$arguments);
        if (refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = refineConstructor.getExpandedType();
        if (expandedType == null) {
            Annotations annotations = this.$annotations;
            TypeConstructor refinedConstructor = refineConstructor.getRefinedConstructor();
            m.e(refinedConstructor);
            return KotlinTypeFactory.simpleType(annotations, refinedConstructor, this.$arguments, this.$nullable, refiner);
        }
        return expandedType;
    }
}