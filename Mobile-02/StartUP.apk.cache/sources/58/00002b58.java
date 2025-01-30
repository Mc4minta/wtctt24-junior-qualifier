package com.coinbase.walletlink.apis;

import com.coinbase.walletlink.exceptions.WalletLinkException;
import kotlin.Metadata;

/* compiled from: WalletLinkConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkConnection$submitWeb3Response$3<T, R> implements h.c.m0.n {
    public static final WalletLinkConnection$submitWeb3Response$3<T, R> INSTANCE = new WalletLinkConnection$submitWeb3Response$3<>();

    @Override // h.c.m0.n
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        apply((Boolean) obj);
        return kotlin.x.a;
    }

    public final void apply(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        if (!it.booleanValue()) {
            throw WalletLinkException.UnableToSendSignatureRequestConfirmation.INSTANCE;
        }
    }
}