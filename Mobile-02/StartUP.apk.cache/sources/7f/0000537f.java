package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.h;
import kotlin.k;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInsLoader.kt */
/* loaded from: classes3.dex */
public interface BuiltInsLoader {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: BuiltInsLoader.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final h<BuiltInsLoader> Instance$delegate;

        static {
            h<BuiltInsLoader> a;
            a = k.a(m.PUBLICATION, BuiltInsLoader$Companion$Instance$2.INSTANCE);
            Instance$delegate = a;
        }

        private Companion() {
        }

        public final BuiltInsLoader getInstance() {
            return Instance$delegate.getValue();
        }
    }

    PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z);
}