package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes3.dex */
public final class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toRuntimeFqName(ClassId classId) {
        String J;
        String asString = classId.getRelativeClassName().asString();
        m.f(asString, "relativeClassName.asString()");
        J = x.J(asString, '.', '$', false, 4, null);
        if (classId.getPackageFqName().isRoot()) {
            return J;
        }
        return classId.getPackageFqName() + '.' + J;
    }
}