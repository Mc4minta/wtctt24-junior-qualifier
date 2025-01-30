package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.a0.z;
import kotlin.e0.c.a;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltIns extends KotlinBuiltIns {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    private final NotNullLazyValue customizer$delegate;
    private a<Settings> settingsComputation;

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes3.dex */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Kind[] valuesCustom() {
            Kind[] valuesCustom = values();
            Kind[] kindArr = new Kind[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, kindArr, 0, valuesCustom.length);
            return kindArr;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes3.dex */
    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final ModuleDescriptor ownerModuleDescriptor;

        public Settings(ModuleDescriptor ownerModuleDescriptor, boolean z) {
            kotlin.jvm.internal.m.g(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = ownerModuleDescriptor;
            this.isAdditionalBuiltInsFeatureSupported = z;
        }

        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.valuesCustom().length];
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[Kind.FALLBACK.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(StorageManager storageManager, Kind kind) {
        super(storageManager);
        kotlin.jvm.internal.m.g(storageManager, "storageManager");
        kotlin.jvm.internal.m.g(kind, "kind");
        this.customizer$delegate = storageManager.createLazyValue(new JvmBuiltIns$customizer$2(this, storageManager));
        int i2 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i2 == 2) {
            createBuiltInsModule(false);
        } else if (i2 != 3) {
        } else {
            createBuiltInsModule(true);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    public final void initialize(ModuleDescriptor moduleDescriptor, boolean z) {
        kotlin.jvm.internal.m.g(moduleDescriptor, "moduleDescriptor");
        setPostponedSettingsComputation(new JvmBuiltIns$initialize$1(moduleDescriptor, z));
    }

    public final void setPostponedSettingsComputation(a<Settings> computation) {
        kotlin.jvm.internal.m.g(computation, "computation");
        a<Settings> aVar = this.settingsComputation;
        this.settingsComputation = computation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        List<ClassDescriptorFactory> s0;
        Iterable<ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        kotlin.jvm.internal.m.f(classDescriptorFactories, "super.getClassDescriptorFactories()");
        StorageManager storageManager = getStorageManager();
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        ModuleDescriptorImpl builtInsModule = getBuiltInsModule();
        kotlin.jvm.internal.m.f(builtInsModule, "builtInsModule");
        s0 = z.s0(classDescriptorFactories, new JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, null, 4, null));
        return s0;
    }
}