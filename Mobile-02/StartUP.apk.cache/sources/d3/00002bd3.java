package com.coinbase.walletlink.extensions;

import com.coinbase.wallet.core.extensions.Strings;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: Strings+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/core/extensions/Strings;", "", "destroySession$delegate", "Lkotlin/h;", "getDestroySession", "(Lcom/coinbase/wallet/core/extensions/Strings;)Ljava/lang/String;", "destroySession", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Strings_WalletLinkKt {
    private static final h destroySession$delegate;

    static {
        h b2;
        b2 = k.b(Strings_WalletLinkKt$destroySession$2.INSTANCE);
        destroySession$delegate = b2;
    }

    public static final String getDestroySession(Strings strings) {
        m.g(strings, "<this>");
        return (String) destroySession$delegate.getValue();
    }
}