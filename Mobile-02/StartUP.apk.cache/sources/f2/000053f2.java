package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: findClassInModule.kt */
/* loaded from: classes3.dex */
final class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 extends o implements l<ClassId, Integer> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 INSTANCE = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2();

    FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2(ClassId it) {
        m.g(it, "it");
        return 0;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Integer invoke(ClassId classId) {
        return Integer.valueOf(invoke2(classId));
    }
}