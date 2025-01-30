package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.e0.c.p;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
/* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1 extends j implements p<KotlinType, KotlinType, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl) {
        super(2, newKotlinTypeCheckerImpl);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "equalTypes";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(NewKotlinTypeCheckerImpl.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // kotlin.e0.c.p
    public /* bridge */ /* synthetic */ Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
        return Boolean.valueOf(invoke2(kotlinType, kotlinType2));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(KotlinType p0, KotlinType p1) {
        m.g(p0, "p0");
        m.g(p1, "p1");
        return ((NewKotlinTypeCheckerImpl) this.receiver).equalTypes(p0, p1);
    }
}