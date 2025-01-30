package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes3.dex */
public abstract class DeclarationDescriptorNonRootImpl extends DeclarationDescriptorImpl implements DeclarationDescriptorNonRoot {
    private final DeclarationDescriptor containingDeclaration;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ApiConstants.NAME;
                break;
            case 3:
                objArr[0] = Payload.SOURCE;
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeclarationDescriptorNonRootImpl(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, SourceElement sourceElement) {
        super(annotations, name);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.containingDeclaration = declarationDescriptor;
        this.source = sourceElement;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(5);
        }
        return declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptorWithSource getOriginal() {
        DeclarationDescriptorWithSource declarationDescriptorWithSource = (DeclarationDescriptorWithSource) super.getOriginal();
        if (declarationDescriptorWithSource == null) {
            $$$reportNull$$$0(4);
        }
        return declarationDescriptorWithSource;
    }
}