package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes3.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        m.g(classLoader, "classLoader");
        this.classLoader = classLoader;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String str) {
        ReflectKotlinClass create;
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, str);
        if (tryLoadClass == null || (create = ReflectKotlinClass.Factory.create(tryLoadClass)) == null) {
            return null;
        }
        return new KotlinClassFinder.Result.KotlinClass(create, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName packageFqName) {
        m.g(packageFqName, "packageFqName");
        if (packageFqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(packageFqName));
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId classId) {
        String runtimeFqName;
        m.g(classId, "classId");
        runtimeFqName = ReflectKotlinClassFinderKt.toRuntimeFqName(classId);
        return findKotlinClass(runtimeFqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass javaClass) {
        m.g(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        String asString = fqName == null ? null : fqName.asString();
        if (asString == null) {
            return null;
        }
        return findKotlinClass(asString);
    }
}