package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a0.p;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* loaded from: classes3.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor module) {
        m.g(storageManager, "storageManager");
        m.g(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        boolean V;
        m.g(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String asString = classId.getRelativeClassName().asString();
        m.f(asString, "classId.relativeClassName.asString()");
        V = y.V(asString, "Function", false, 2, null);
        if (V) {
            FqName packageFqName = classId.getPackageFqName();
            m.f(packageFqName, "classId.packageFqName");
            FunctionClassKind.Companion.KindWithArity parseClassName = FunctionClassKind.Companion.parseClassName(asString, packageFqName);
            if (parseClassName == null) {
                return null;
            }
            FunctionClassKind component1 = parseClassName.component1();
            int component2 = parseClassName.component2();
            List<PackageFragmentDescriptor> fragments = this.module.getPackage(packageFqName).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (obj2 instanceof FunctionInterfacePackageFragment) {
                    arrayList2.add(obj2);
                }
            }
            PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) p.a0(arrayList2);
            if (packageFragmentDescriptor == null) {
                packageFragmentDescriptor = (BuiltInsPackageFragment) p.Y(arrayList);
            }
            return new FunctionClassDescriptor(this.storageManager, packageFragmentDescriptor, component1, component2);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName packageFqName) {
        Set b2;
        m.g(packageFqName, "packageFqName");
        b2 = s0.b();
        return b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName packageFqName, Name name) {
        boolean Q;
        boolean Q2;
        boolean Q3;
        boolean Q4;
        m.g(packageFqName, "packageFqName");
        m.g(name, "name");
        String asString = name.asString();
        m.f(asString, "name.asString()");
        Q = x.Q(asString, "Function", false, 2, null);
        if (!Q) {
            Q2 = x.Q(asString, "KFunction", false, 2, null);
            if (!Q2) {
                Q3 = x.Q(asString, "SuspendFunction", false, 2, null);
                if (!Q3) {
                    Q4 = x.Q(asString, "KSuspendFunction", false, 2, null);
                    if (!Q4) {
                        return false;
                    }
                }
            }
        }
        return FunctionClassKind.Companion.parseClassName(asString, packageFqName) != null;
    }
}