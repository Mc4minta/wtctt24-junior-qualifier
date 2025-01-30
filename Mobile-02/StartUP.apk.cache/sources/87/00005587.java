package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* compiled from: LazyJavaScope.kt */
/* loaded from: classes3.dex */
final class LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1 extends o implements l<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1 INSTANCE = new LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1();

    LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        m.g(simpleFunctionDescriptor, "<this>");
        return simpleFunctionDescriptor;
    }
}