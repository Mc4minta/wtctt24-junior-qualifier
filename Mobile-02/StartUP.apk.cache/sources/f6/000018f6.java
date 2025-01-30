package com.coinbase.wallet.core.extensions;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.h0;

/* compiled from: String+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "byte", "", "<anonymous>", "(B)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class String_CoreKt$asHexString$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Byte, CharSequence> {
    public static final String_CoreKt$asHexString$1 INSTANCE = new String_CoreKt$asHexString$1();

    String_CoreKt$asHexString$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
        return invoke(b2.byteValue());
    }

    public final CharSequence invoke(byte b2) {
        h0 h0Var = h0.a;
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
        kotlin.jvm.internal.m.f(format, "java.lang.String.format(format, *args)");
        return format;
    }
}