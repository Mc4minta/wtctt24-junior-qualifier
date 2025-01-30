package com.coinbase.wallet.blockchains.interfaces;

import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import h.c.b0;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: WalletManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "", "Lh/c/b0;", "", "hasWallets", "()Lh/c/b0;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lkotlin/x;", "createWallets", "(Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "refresh", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface WalletManaging {
    b0<x> createWallets(String str);

    WalletConfiguration getConfiguration();

    b0<Boolean> hasWallets();

    b0<x> refresh(RefreshContext refreshContext);
}