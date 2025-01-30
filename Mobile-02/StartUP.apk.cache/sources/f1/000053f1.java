package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: findClassInModule.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 extends j implements l<ClassId, ClassId> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 INSTANCE = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1();

    FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(ClassId.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    @Override // kotlin.e0.c.l
    public final ClassId invoke(ClassId p0) {
        m.g(p0, "p0");
        return p0.getOuterClassId();
    }
}