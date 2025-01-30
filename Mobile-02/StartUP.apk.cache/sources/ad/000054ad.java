package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;

/* compiled from: RuntimeModuleData.kt */
/* loaded from: classes3.dex */
public final class RuntimeModuleDataKt {
    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor module, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder reflectKotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        m.g(module, "module");
        m.g(storageManager, "storageManager");
        m.g(notFoundClasses, "notFoundClasses");
        m.g(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        m.g(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        m.g(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        return new DeserializationComponentsForJava(storageManager, module, DeserializationConfiguration.Default.INSTANCE, new JavaClassDataFinder(reflectKotlinClassFinder, deserializedDescriptorResolver), new BinaryClassAnnotationAndConstantLoaderImpl(module, notFoundClasses, storageManager, reflectKotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, RuntimeErrorReporter.INSTANCE, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault());
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, ModuleDescriptor module, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder reflectKotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver singleModuleClassResolver, PackagePartProvider packagePartProvider) {
        List g2;
        m.g(classLoader, "classLoader");
        m.g(module, "module");
        m.g(storageManager, "storageManager");
        m.g(notFoundClasses, "notFoundClasses");
        m.g(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        m.g(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        m.g(singleModuleClassResolver, "singleModuleClassResolver");
        m.g(packagePartProvider, "packagePartProvider");
        JavaTypeEnhancementState javaTypeEnhancementState = JavaTypeEnhancementState.DISABLED_JSR_305;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(storageManager, javaTypeEnhancementState);
        ReflectJavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(classLoader);
        SignaturePropagator DO_NOTHING = SignaturePropagator.DO_NOTHING;
        m.f(DO_NOTHING, "DO_NOTHING");
        RuntimeErrorReporter runtimeErrorReporter = RuntimeErrorReporter.INSTANCE;
        JavaResolverCache EMPTY = JavaResolverCache.EMPTY;
        m.f(EMPTY, "EMPTY");
        JavaPropertyInitializerEvaluator.DoNothing doNothing = JavaPropertyInitializerEvaluator.DoNothing.INSTANCE;
        g2 = r.g();
        SamConversionResolverImpl samConversionResolverImpl = new SamConversionResolverImpl(storageManager, g2);
        RuntimeSourceElementFactory runtimeSourceElementFactory = RuntimeSourceElementFactory.INSTANCE;
        SupertypeLoopChecker.EMPTY empty = SupertypeLoopChecker.EMPTY.INSTANCE;
        LookupTracker.DO_NOTHING do_nothing = LookupTracker.DO_NOTHING.INSTANCE;
        ReflectionTypes reflectionTypes = new ReflectionTypes(module, notFoundClasses);
        JavaResolverSettings.Default r4 = JavaResolverSettings.Default.INSTANCE;
        return new LazyJavaPackageFragmentProvider(new JavaResolverComponents(storageManager, reflectJavaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, runtimeErrorReporter, EMPTY, doNothing, samConversionResolverImpl, runtimeSourceElementFactory, singleModuleClassResolver, packagePartProvider, empty, do_nothing, module, reflectionTypes, annotationTypeQualifierResolver, new SignatureEnhancement(annotationTypeQualifierResolver, javaTypeEnhancementState, new JavaTypeEnhancement(r4)), JavaClassesTracker.Default.INSTANCE, r4, NewKotlinTypeChecker.Companion.getDefault(), javaTypeEnhancementState));
    }
}