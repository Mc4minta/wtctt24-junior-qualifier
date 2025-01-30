package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
final class SignatureEnhancement$enhanceTypeParameterBounds$1$1 extends o implements l<UnwrappedType, Boolean> {
    public static final SignatureEnhancement$enhanceTypeParameterBounds$1$1 INSTANCE = new SignatureEnhancement$enhanceTypeParameterBounds$1$1();

    SignatureEnhancement$enhanceTypeParameterBounds$1$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
        return Boolean.valueOf(invoke2(unwrappedType));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(UnwrappedType it) {
        m.g(it, "it");
        return it instanceof RawType;
    }
}