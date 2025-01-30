package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ResolutionScope.kt */
/* loaded from: classes3.dex */
public interface ResolutionScope {

    /* compiled from: ResolutionScope.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope resolutionScope, DescriptorKindFilter descriptorKindFilter, l lVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    descriptorKindFilter = DescriptorKindFilter.ALL;
                }
                l<Name, Boolean> lVar2 = lVar;
                if ((i2 & 2) != 0) {
                    lVar2 = MemberScope.Companion.getALL_NAME_FILTER();
                }
                return resolutionScope.getContributedDescriptors(descriptorKindFilter, lVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void recordLookup(ResolutionScope resolutionScope, Name name, LookupLocation location) {
            m.g(resolutionScope, "this");
            m.g(name, "name");
            m.g(location, "location");
            resolutionScope.getContributedFunctions(name, location);
        }
    }

    /* renamed from: getContributedClassifier */
    ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation lookupLocation);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, l<? super Name, Boolean> lVar);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

    void recordLookup(Name name, LookupLocation lookupLocation);
}