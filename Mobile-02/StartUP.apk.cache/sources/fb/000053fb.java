package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ModuleDescriptor.kt */
/* loaded from: classes3.dex */
public interface ModuleDescriptor extends DeclarationDescriptor {

    /* compiled from: ModuleDescriptor.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <R, D> R accept(ModuleDescriptor moduleDescriptor, DeclarationDescriptorVisitor<R, D> visitor, D d2) {
            m.g(moduleDescriptor, "this");
            m.g(visitor, "visitor");
            return visitor.visitModuleDeclaration(moduleDescriptor, d2);
        }

        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor moduleDescriptor) {
            m.g(moduleDescriptor, "this");
            return null;
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> moduleCapability);

    List<ModuleDescriptor> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, l<? super Name, Boolean> lVar);

    boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor);
}