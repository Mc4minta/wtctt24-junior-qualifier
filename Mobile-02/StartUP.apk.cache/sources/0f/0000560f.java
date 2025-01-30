package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: DeserializationComponentsForJava.kt */
/* loaded from: classes3.dex */
public final class DeserializationComponentsForJava {
    private final DeserializationComponents components;

    public DeserializationComponentsForJava(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration configuration, JavaClassDataFinder classDataFinder, BinaryClassAnnotationAndConstantLoaderImpl annotationAndConstantLoader, LazyJavaPackageFragmentProvider packageFragmentProvider, NotFoundClasses notFoundClasses, ErrorReporter errorReporter, LookupTracker lookupTracker, ContractDeserializer contractDeserializer, NewKotlinTypeChecker kotlinTypeChecker) {
        List g2;
        List g3;
        m.g(storageManager, "storageManager");
        m.g(moduleDescriptor, "moduleDescriptor");
        m.g(configuration, "configuration");
        m.g(classDataFinder, "classDataFinder");
        m.g(annotationAndConstantLoader, "annotationAndConstantLoader");
        m.g(packageFragmentProvider, "packageFragmentProvider");
        m.g(notFoundClasses, "notFoundClasses");
        m.g(errorReporter, "errorReporter");
        m.g(lookupTracker, "lookupTracker");
        m.g(contractDeserializer, "contractDeserializer");
        m.g(kotlinTypeChecker, "kotlinTypeChecker");
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        JvmBuiltIns jvmBuiltIns = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
        LocalClassifierTypeSettings.Default r7 = LocalClassifierTypeSettings.Default.INSTANCE;
        JavaFlexibleTypeDeserializer javaFlexibleTypeDeserializer = JavaFlexibleTypeDeserializer.INSTANCE;
        g2 = r.g();
        AdditionalClassPartsProvider customizer = jvmBuiltIns == null ? null : jvmBuiltIns.getCustomizer();
        AdditionalClassPartsProvider additionalClassPartsProvider = customizer == null ? AdditionalClassPartsProvider.None.INSTANCE : customizer;
        PlatformDependentDeclarationFilter customizer2 = jvmBuiltIns != null ? jvmBuiltIns.getCustomizer() : null;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter = customizer2 == null ? PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE : customizer2;
        ExtensionRegistryLite extension_registry = JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY();
        g3 = r.g();
        this.components = new DeserializationComponents(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, r7, errorReporter, lookupTracker, javaFlexibleTypeDeserializer, g2, notFoundClasses, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter, extension_registry, kotlinTypeChecker, new SamConversionResolverImpl(storageManager, g3), null, PKIFailureInfo.transactionIdInUse, null);
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }
}