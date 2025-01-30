package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* loaded from: classes3.dex */
final class IntegerLiteralTypeConstructor$valueToString$1 extends o implements l<KotlinType, CharSequence> {
    public static final IntegerLiteralTypeConstructor$valueToString$1 INSTANCE = new IntegerLiteralTypeConstructor$valueToString$1();

    IntegerLiteralTypeConstructor$valueToString$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(KotlinType it) {
        m.g(it, "it");
        return it.toString();
    }
}