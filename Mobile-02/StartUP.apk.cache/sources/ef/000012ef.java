package com.coinbase.wallet.bip44wallets.interfaces;

import com.coinbase.wallet.blockchains.models.AddressType;
import kotlin.Metadata;

/* compiled from: BitcoinLikeWalletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/interfaces/BitcoinLikeWalletService;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "", "index", "", "isChangeAddress", "testnet", "", "addressDerivationPath", "(Lcom/coinbase/wallet/blockchains/models/AddressType;IZZ)Ljava/lang/String;", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface BitcoinLikeWalletService extends BIP44WalletService {

    /* compiled from: BitcoinLikeWalletService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static String addressDerivationPath(BitcoinLikeWalletService bitcoinLikeWalletService, AddressType addressType, int i2, boolean z, boolean z2) {
            kotlin.jvm.internal.m.g(bitcoinLikeWalletService, "this");
            kotlin.jvm.internal.m.g(addressType, "addressType");
            String xpubKeyDerivationPath = bitcoinLikeWalletService.xpubKeyDerivationPath(addressType, z2);
            if (xpubKeyDerivationPath == null) {
                return null;
            }
            return xpubKeyDerivationPath + '/' + (z ? 1 : 0) + '/' + i2;
        }
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    String addressDerivationPath(AddressType addressType, int i2, boolean z, boolean z2);
}