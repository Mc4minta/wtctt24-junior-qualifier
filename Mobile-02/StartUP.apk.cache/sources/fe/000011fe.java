package com.coinbase.wallet.application.model;

import kotlin.Metadata;

/* compiled from: Production.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/application/model/Production;", "", "", "walletApi", "Ljava/lang/String;", "walletBlockchain", "walletXRPNodeUrlProxy", "walletXRPNodeUrlDirect", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Production {
    public static final Production INSTANCE = new Production();
    public static final String walletApi = "https://api.wallet.coinbase.com";
    public static final String walletBlockchain = "https://blockchain.wallet.coinbase.com";
    public static final String walletXRPNodeUrlDirect = "wss://s1.ripple.com";
    public static final String walletXRPNodeUrlProxy = "https://mainnet-ripple.wallet.coinbase.com";

    private Production() {
    }
}