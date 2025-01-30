package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.e0.c.p;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 extends j implements p<KotlinType, KotlinType, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(TypeIntersector typeIntersector) {
        super(2, typeIntersector);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "isStrictSupertype";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(TypeIntersector.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // kotlin.e0.c.p
    public /* bridge */ /* synthetic */ Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
        return Boolean.valueOf(invoke2(kotlinType, kotlinType2));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(KotlinType p0, KotlinType p1) {
        boolean isStrictSupertype;
        m.g(p0, "p0");
        m.g(p1, "p1");
        isStrictSupertype = ((TypeIntersector) this.receiver).isStrictSupertype(p0, p1);
        return isStrictSupertype;
    }
}