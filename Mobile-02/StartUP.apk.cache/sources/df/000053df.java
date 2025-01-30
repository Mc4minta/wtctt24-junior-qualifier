package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: descriptorUtil.kt */
/* loaded from: classes3.dex */
public final class DescriptorUtilKt {
    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        MemberScope unsubstitutedInnerClassesScope;
        ClassifierDescriptor mo2216getContributedClassifier;
        m.g(moduleDescriptor, "<this>");
        m.g(fqName, "fqName");
        m.g(lookupLocation, "lookupLocation");
        if (fqName.isRoot()) {
            return null;
        }
        FqName parent = fqName.parent();
        m.f(parent, "fqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = fqName.shortName();
        m.f(shortName, "fqName.shortName()");
        ClassifierDescriptor mo2216getContributedClassifier2 = memberScope.mo2216getContributedClassifier(shortName, lookupLocation);
        ClassDescriptor classDescriptor = mo2216getContributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) mo2216getContributedClassifier2 : null;
        if (classDescriptor == null) {
            FqName parent2 = fqName.parent();
            m.f(parent2, "fqName.parent()");
            ClassDescriptor resolveClassByFqName = resolveClassByFqName(moduleDescriptor, parent2, lookupLocation);
            if (resolveClassByFqName == null || (unsubstitutedInnerClassesScope = resolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) {
                mo2216getContributedClassifier = null;
            } else {
                Name shortName2 = fqName.shortName();
                m.f(shortName2, "fqName.shortName()");
                mo2216getContributedClassifier = unsubstitutedInnerClassesScope.mo2216getContributedClassifier(shortName2, lookupLocation);
            }
            if (mo2216getContributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) mo2216getContributedClassifier;
            }
            return null;
        }
        return classDescriptor;
    }
}