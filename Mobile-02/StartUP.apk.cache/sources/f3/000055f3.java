package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
final class SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 extends o implements l<CallableMemberDescriptor, KotlinType> {
    public static final SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 INSTANCE = new SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1();

    SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(CallableMemberDescriptor it) {
        m.g(it, "it");
        KotlinType returnType = it.getReturnType();
        m.e(returnType);
        return returnType;
    }
}