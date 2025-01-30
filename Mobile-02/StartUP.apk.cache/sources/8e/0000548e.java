package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* loaded from: classes3.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    private final DeclarationDescriptor containingDeclaration;
    private final ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "value";
        } else if (i2 == 2) {
            objArr[0] = "annotations";
        } else if (i2 == 3 || i2 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i2 != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i2 == 3) {
            objArr[1] = "getValue";
        } else if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i2 != 3 && i2 != 4) {
            if (i2 != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, ReceiverValue receiverValue, Annotations annotations) {
        super(annotations);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (receiverValue == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations == null) {
            $$$reportNull$$$0(2);
        }
        this.containingDeclaration = declarationDescriptor;
        this.value = receiverValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        return declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.value;
        if (receiverValue == null) {
            $$$reportNull$$$0(3);
        }
        return receiverValue;
    }
}