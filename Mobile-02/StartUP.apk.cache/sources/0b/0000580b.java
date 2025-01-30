package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: TypeIntersectionScope.kt */
/* loaded from: classes3.dex */
final class TypeIntersectionScope$getContributedVariables$1 extends o implements l<PropertyDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedVariables$1 INSTANCE = new TypeIntersectionScope$getContributedVariables$1();

    TypeIntersectionScope$getContributedVariables$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CallableDescriptor invoke(PropertyDescriptor propertyDescriptor) {
        m.g(propertyDescriptor, "<this>");
        return propertyDescriptor;
    }
}