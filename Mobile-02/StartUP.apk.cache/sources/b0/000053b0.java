package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a0.p;
import kotlin.a0.r0;
import kotlin.a0.s0;
import kotlin.e0.c.l;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    private static final ClassId CLONEABLE_CLASS_ID;
    private static final Name CLONEABLE_NAME;
    private final NotNullLazyValue cloneable$delegate;
    private final l<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    private final ModuleDescriptor moduleDescriptor;
    public static final Companion Companion = new Companion(null);
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    private static final FqName KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends o implements l<ModuleDescriptor, BuiltInsPackageFragment> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public final BuiltInsPackageFragment invoke(ModuleDescriptor module) {
            kotlin.jvm.internal.m.g(module, "module");
            List<PackageFragmentDescriptor> fragments = module.getPackage(JvmBuiltInClassDescriptorFactory.KOTLIN_FQ_NAME).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            return (BuiltInsPackageFragment) p.Y(arrayList);
        }
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.CLONEABLE_CLASS_ID;
        }
    }

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames.cloneable;
        Name shortName = fqNameUnsafe.shortName();
        kotlin.jvm.internal.m.f(shortName, "cloneable.shortName()");
        CLONEABLE_NAME = shortName;
        ClassId classId = ClassId.topLevel(fqNameUnsafe.toSafe());
        kotlin.jvm.internal.m.f(classId, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        CLONEABLE_CLASS_ID = classId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, l<? super ModuleDescriptor, ? extends DeclarationDescriptor> computeContainingDeclaration) {
        kotlin.jvm.internal.m.g(storageManager, "storageManager");
        kotlin.jvm.internal.m.g(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.m.g(computeContainingDeclaration, "computeContainingDeclaration");
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = computeContainingDeclaration;
        this.cloneable$delegate = storageManager.createLazyValue(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, storageManager));
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        kotlin.jvm.internal.m.g(classId, "classId");
        if (kotlin.jvm.internal.m.c(classId, Companion.getCLONEABLE_CLASS_ID())) {
            return getCloneable();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName packageFqName) {
        Set b2;
        Set a;
        kotlin.jvm.internal.m.g(packageFqName, "packageFqName");
        if (kotlin.jvm.internal.m.c(packageFqName, KOTLIN_FQ_NAME)) {
            a = r0.a(getCloneable());
            return a;
        }
        b2 = s0.b();
        return b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName packageFqName, Name name) {
        kotlin.jvm.internal.m.g(packageFqName, "packageFqName");
        kotlin.jvm.internal.m.g(name, "name");
        return kotlin.jvm.internal.m.c(name, CLONEABLE_NAME) && kotlin.jvm.internal.m.c(packageFqName, KOTLIN_FQ_NAME);
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, (i2 & 4) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }
}