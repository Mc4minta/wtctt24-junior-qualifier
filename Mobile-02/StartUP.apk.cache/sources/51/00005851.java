package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInsLoaderImpl.kt */
/* loaded from: classes3.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    private final BuiltInsResourceLoader resourceLoader = new BuiltInsResourceLoader();

    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor module, Set<FqName> packageFqNames, Iterable<? extends ClassDescriptorFactory> classDescriptorFactories, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z, l<? super String, ? extends InputStream> loadResource) {
        int r;
        List g2;
        m.g(storageManager, "storageManager");
        m.g(module, "module");
        m.g(packageFqNames, "packageFqNames");
        m.g(classDescriptorFactories, "classDescriptorFactories");
        m.g(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        m.g(additionalClassPartsProvider, "additionalClassPartsProvider");
        m.g(loadResource, "loadResource");
        r = s.r(packageFqNames, 10);
        ArrayList<BuiltInsPackageFragmentImpl> arrayList = new ArrayList(r);
        for (FqName fqName : packageFqNames) {
            String builtInsFilePath = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName);
            InputStream invoke = loadResource.invoke(builtInsFilePath);
            if (invoke != null) {
                arrayList.add(BuiltInsPackageFragmentImpl.Companion.create(fqName, storageManager, module, invoke, z));
            } else {
                throw new IllegalStateException(m.o("Resource not found in classpath: ", builtInsFilePath));
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, module);
        DeserializationConfiguration.Default r3 = DeserializationConfiguration.Default.INSTANCE;
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(packageFragmentProviderImpl);
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.INSTANCE;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(module, notFoundClasses, builtInSerializerProtocol);
        LocalClassifierTypeSettings.Default r7 = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter DO_NOTHING = ErrorReporter.DO_NOTHING;
        m.f(DO_NOTHING, "DO_NOTHING");
        LookupTracker.DO_NOTHING do_nothing = LookupTracker.DO_NOTHING.INSTANCE;
        FlexibleTypeDeserializer.ThrowException throwException = FlexibleTypeDeserializer.ThrowException.INSTANCE;
        ContractDeserializer contractDeserializer = ContractDeserializer.Companion.getDEFAULT();
        ExtensionRegistryLite extensionRegistry = builtInSerializerProtocol.getExtensionRegistry();
        g2 = r.g();
        DeserializationComponents deserializationComponents = new DeserializationComponents(storageManager, module, r3, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl, r7, DO_NOTHING, do_nothing, throwException, classDescriptorFactories, notFoundClasses, contractDeserializer, additionalClassPartsProvider, platformDependentDeclarationFilter, extensionRegistry, null, new SamConversionResolverImpl(storageManager, g2), null, 327680, null);
        for (BuiltInsPackageFragmentImpl builtInsPackageFragmentImpl : arrayList) {
            builtInsPackageFragmentImpl.initialize(deserializationComponents);
        }
        return packageFragmentProviderImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    public PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor builtInsModule, Iterable<? extends ClassDescriptorFactory> classDescriptorFactories, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z) {
        m.g(storageManager, "storageManager");
        m.g(builtInsModule, "builtInsModule");
        m.g(classDescriptorFactories, "classDescriptorFactories");
        m.g(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        m.g(additionalClassPartsProvider, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(storageManager, builtInsModule, StandardNames.BUILT_INS_PACKAGE_FQ_NAMES, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.resourceLoader));
    }
}