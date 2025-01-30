package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: KotlinClassFinder.kt */
/* loaded from: classes3.dex */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, ClassId classId) {
        m.g(kotlinClassFinder, "<this>");
        m.g(classId, "classId");
        KotlinClassFinder.Result findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, JavaClass javaClass) {
        m.g(kotlinClassFinder, "<this>");
        m.g(javaClass, "javaClass");
        KotlinClassFinder.Result findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass);
        if (findKotlinClassOrContent == null) {
            return null;
        }
        return findKotlinClassOrContent.toKotlinJvmBinaryClass();
    }
}