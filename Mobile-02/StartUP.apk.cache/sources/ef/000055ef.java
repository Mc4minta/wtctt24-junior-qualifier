package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
public final class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 extends o implements l<UnwrappedType, Boolean> {
    public static final SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 INSTANCE = new SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1();

    SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final Boolean invoke(UnwrappedType unwrappedType) {
        ClassifierDescriptor mo2214getDeclarationDescriptor = unwrappedType.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor == null) {
            return Boolean.FALSE;
        }
        Name name = mo2214getDeclarationDescriptor.getName();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        return Boolean.valueOf(m.c(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && m.c(DescriptorUtilsKt.fqNameOrNull(mo2214getDeclarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
    }
}