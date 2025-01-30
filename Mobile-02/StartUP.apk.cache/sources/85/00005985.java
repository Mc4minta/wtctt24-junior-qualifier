package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
final class OperatorChecks$checks$2 extends o implements l<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor);
    }

    @Override // kotlin.e0.c.l
    public final String invoke(FunctionDescriptor functionDescriptor) {
        boolean z;
        m.g(functionDescriptor, "<this>");
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        m.f(containingDeclaration, "containingDeclaration");
        boolean z2 = true;
        if (!invoke$isAny(containingDeclaration)) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            m.f(overriddenDescriptors, "overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                for (FunctionDescriptor functionDescriptor2 : overriddenDescriptors) {
                    DeclarationDescriptor containingDeclaration2 = functionDescriptor2.getContainingDeclaration();
                    m.f(containingDeclaration2, "it.containingDeclaration");
                    if (invoke$isAny(containingDeclaration2)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                z2 = false;
            }
        }
        if (z2) {
            return null;
        }
        return "must override ''equals()'' in Any";
    }
}