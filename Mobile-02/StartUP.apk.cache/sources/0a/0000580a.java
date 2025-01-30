package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* compiled from: TypeIntersectionScope.kt */
/* loaded from: classes3.dex */
final class TypeIntersectionScope$getContributedFunctions$1 extends o implements l<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedFunctions$1 INSTANCE = new TypeIntersectionScope$getContributedFunctions$1();

    TypeIntersectionScope$getContributedFunctions$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        m.g(simpleFunctionDescriptor, "<this>");
        return simpleFunctionDescriptor;
    }
}