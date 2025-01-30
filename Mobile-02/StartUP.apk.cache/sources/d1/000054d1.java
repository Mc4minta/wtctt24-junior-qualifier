package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* loaded from: classes3.dex */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Visibility getVisibility(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            m.g(reflectJavaModifierListOwner, "this");
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return Visibilities.Public.INSTANCE;
            }
            if (Modifier.isPrivate(modifiers)) {
                return Visibilities.Private.INSTANCE;
            }
            if (Modifier.isProtected(modifiers)) {
                return Modifier.isStatic(modifiers) ? JavaVisibilities.ProtectedStaticVisibility.INSTANCE : JavaVisibilities.ProtectedAndPackage.INSTANCE;
            }
            return JavaVisibilities.PackageVisibility.INSTANCE;
        }

        public static boolean isAbstract(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            m.g(reflectJavaModifierListOwner, "this");
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            m.g(reflectJavaModifierListOwner, "this");
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            m.g(reflectJavaModifierListOwner, "this");
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}