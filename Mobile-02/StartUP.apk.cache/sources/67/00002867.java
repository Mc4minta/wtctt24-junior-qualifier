package com.coinbase.wallet.wallets.apis;

import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: ExchangeRateAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "<anonymous>", "(Ljava/lang/String;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class ExchangeRateAPI$encodeChainIds$2 extends o implements l<String, CharSequence> {
    public static final ExchangeRateAPI$encodeChainIds$2 INSTANCE = new ExchangeRateAPI$encodeChainIds$2();

    ExchangeRateAPI$encodeChainIds$2() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(String it) {
        m.g(it, "it");
        String encode = URLEncoder.encode(it, "UTF-8");
        m.f(encode, "encode(it, \"UTF-8\")");
        return encode;
    }
}