package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;

/* compiled from: TypeIntersectionScope.kt */
/* loaded from: classes3.dex */
final class TypeIntersectionScope$getContributedDescriptors$2 extends o implements l<CallableDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedDescriptors$2 INSTANCE = new TypeIntersectionScope$getContributedDescriptors$2();

    TypeIntersectionScope$getContributedDescriptors$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CallableDescriptor invoke(CallableDescriptor callableDescriptor) {
        m.g(callableDescriptor, "<this>");
        return callableDescriptor;
    }
}