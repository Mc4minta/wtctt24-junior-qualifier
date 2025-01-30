package com.coinbase.wallet.features.walletlink.models;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WalletLinkCompleteArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/models/WalletLinkCompleteArgs;", "", "", WalletLinkCompleteArgs.DAPP_NAME, "Landroid/os/Bundle;", "createArgs", "(Ljava/lang/String;)Landroid/os/Bundle;", "DAPP_NAME", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkCompleteArgs {
    public static final String DAPP_NAME = "dappName";
    public static final WalletLinkCompleteArgs INSTANCE = new WalletLinkCompleteArgs();

    private WalletLinkCompleteArgs() {
    }

    public final Bundle createArgs(String dappName) {
        m.g(dappName, "dappName");
        Bundle bundle = new Bundle();
        bundle.putString(DAPP_NAME, dappName);
        return bundle;
    }
}