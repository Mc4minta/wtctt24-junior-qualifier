package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.x;

/* compiled from: RuntimeModuleData.kt */
/* loaded from: classes3.dex */
public final class RuntimeModuleData {
    public static final Companion Companion = new Companion(null);
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    /* compiled from: RuntimeModuleData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader classLoader) {
            List g2;
            List j2;
            m.g(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name special = Name.special("<runtime module for " + classLoader + '>');
            m.f(special, "special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            jvmBuiltIns.initialize(moduleDescriptorImpl, true);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default = RuntimeModuleDataKt.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(classLoader, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, reflectKotlinClassFinder, deserializedDescriptorResolver, singleModuleClassResolver, null, 128, null);
            DeserializationComponentsForJava makeDeserializationComponentsForJava = RuntimeModuleDataKt.makeDeserializationComponentsForJava(moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, makeLazyJavaPackageFragmentFromClassLoaderProvider$default, reflectKotlinClassFinder, deserializedDescriptorResolver);
            deserializedDescriptorResolver.setComponents(makeDeserializationComponentsForJava);
            JavaResolverCache EMPTY = JavaResolverCache.EMPTY;
            m.f(EMPTY, "EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(makeLazyJavaPackageFragmentFromClassLoaderProvider$default, EMPTY);
            singleModuleClassResolver.setResolver(javaDescriptorResolver);
            ClassLoader stdlibClassLoader = x.class.getClassLoader();
            m.f(stdlibClassLoader, "stdlibClassLoader");
            ReflectKotlinClassFinder reflectKotlinClassFinder2 = new ReflectKotlinClassFinder(stdlibClassLoader);
            JvmBuiltInsCustomizer customizer = jvmBuiltIns.getCustomizer();
            JvmBuiltInsCustomizer customizer2 = jvmBuiltIns.getCustomizer();
            DeserializationConfiguration.Default r0 = DeserializationConfiguration.Default.INSTANCE;
            NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
            g2 = r.g();
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, reflectKotlinClassFinder2, moduleDescriptorImpl, notFoundClasses, customizer, customizer2, r0, newKotlinTypeCheckerImpl, new SamConversionResolverImpl(lockBasedStorageManager, g2));
            moduleDescriptorImpl.setDependencies(moduleDescriptorImpl);
            j2 = r.j(javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider);
            moduleDescriptorImpl.initialize(new CompositePackageFragmentProvider(j2));
            return new RuntimeModuleData(makeDeserializationComponentsForJava.getComponents(), new PackagePartScopeCache(deserializedDescriptorResolver, reflectKotlinClassFinder), null);
        }
    }

    private RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache;
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationComponents, packagePartScopeCache);
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }
}