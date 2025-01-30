package com.coinbase.wallet.blockchains.models;

import kotlin.Metadata;

/* compiled from: TxSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "RemoteLend", "Send", "WalletLink", "DesktopExtension", "DappBrowser", "Dex", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum TxSource {
    RemoteLend("remote-lend"),
    Send("send"),
    WalletLink("walletlink"),
    DesktopExtension("extension"),
    DappBrowser("dapp-browser"),
    Dex("dex");
    
    private final String value;

    TxSource(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}