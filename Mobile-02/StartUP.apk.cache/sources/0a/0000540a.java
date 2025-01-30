package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: PackageViewDescriptor.kt */
/* loaded from: classes3.dex */
public interface PackageViewDescriptor extends DeclarationDescriptor {

    /* compiled from: PackageViewDescriptor.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean isEmpty(PackageViewDescriptor packageViewDescriptor) {
            m.g(packageViewDescriptor, "this");
            return packageViewDescriptor.getFragments().isEmpty();
        }
    }

    FqName getFqName();

    List<PackageFragmentDescriptor> getFragments();

    MemberScope getMemberScope();

    ModuleDescriptor getModule();

    boolean isEmpty();
}