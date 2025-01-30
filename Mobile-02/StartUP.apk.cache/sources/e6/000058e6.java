package kotlin.reflect.jvm.internal.impl.types;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntersectionTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class IntersectionTypeConstructor$createType$1 extends o implements l<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ IntersectionTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntersectionTypeConstructor$createType$1(IntersectionTypeConstructor intersectionTypeConstructor) {
        super(1);
        this.this$0 = intersectionTypeConstructor;
    }

    @Override // kotlin.e0.c.l
    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.this$0.refine(kotlinTypeRefiner).createType();
    }
}