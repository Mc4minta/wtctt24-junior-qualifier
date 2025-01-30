package com.coinbase.wallet.qr.parsers;

import kotlin.Metadata;

/* compiled from: WalletLinkQrParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "<anonymous>", "(Ljava/lang/String;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class WalletLinkQrParser$parse$url$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, CharSequence> {
    public static final WalletLinkQrParser$parse$url$1 INSTANCE = new WalletLinkQrParser$parse$url$1();

    WalletLinkQrParser$parse$url$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it, "/#/") ? "/" : it;
    }
}