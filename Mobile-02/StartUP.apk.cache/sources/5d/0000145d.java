package com.coinbase.wallet.common.extensions;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.l0.k;

/* compiled from: String+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/l0/k;", "<anonymous>", "()Lkotlin/l0/k;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class String_CommonKt$scientificNotationRegex$2 extends o implements kotlin.e0.c.a<k> {
    public static final String_CommonKt$scientificNotationRegex$2 INSTANCE = new String_CommonKt$scientificNotationRegex$2();

    String_CommonKt$scientificNotationRegex$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final k invoke() {
        Pattern compile = Pattern.compile("^[\\-]{0,1}\\d*(\\.\\d+)*e[\\-]{0,1}[+]{0,1}\\d+$", 2);
        m.f(compile, "compile(\n        \"^[\\\\-]{0,1}\\\\d*(\\\\.\\\\d+)*e[\\\\-]{0,1}[+]{0,1}\\\\d+$\",\n        Pattern.CASE_INSENSITIVE\n    )");
        return new k(compile);
    }
}