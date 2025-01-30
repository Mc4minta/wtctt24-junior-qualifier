package com.coinbase.wallet.wallets.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import h.c.b0;
import h.c.s;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: IWalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004H&¢\u0006\u0004\b\u000f\u0010\u0007J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00102\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\r0\u00042\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\rH&¢\u0006\u0004\b\"\u0010#J-\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\bH&¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0019H&¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*H&¢\u0006\u0004\b,\u0010-J+\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\r0\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0019H&¢\u0006\u0004\b/\u00100J!\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u000202010\u0004H&¢\u0006\u0004\b3\u0010\u0007¨\u00064"}, d2 = {"Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lh/c/b0;", "", "hasWallets", "()Lh/c/b0;", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lkotlin/x;", "createWallets", "(Ljava/lang/String;)Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getAllActiveEthWallets", "Lh/c/s;", "", "consumerWalletsObservableAVAXFix", "()Lh/c/s;", "onlyUsable", "observeWallets", "(Z)Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Network;", "observeNetwork", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/s;", "network", "isSynced", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodes", "Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "getCryptoCurrencies", "(Ljava/util/List;)Lh/c/b0;", AppsFlyerProperties.CURRENCY_CODE, "address", "containsAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;)Lh/c/b0;", "switchNetwork", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)V", "", "index", "switchIndex", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;I)V", "Lcom/coinbase/wallet/blockchains/models/Address;", "getUsedAddresses", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "getPrimaryReceiveAddresses", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IWalletRepository extends Destroyable, Refreshable, Startable {

    /* compiled from: IWalletRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b0 getCryptoCurrencies$default(IWalletRepository iWalletRepository, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    list = null;
                }
                return iWalletRepository.getCryptoCurrencies(list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCryptoCurrencies");
        }

        public static /* synthetic */ s observeWallets$default(IWalletRepository iWalletRepository, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                return iWalletRepository.observeWallets(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeWallets");
        }
    }

    s<Set<Wallet>> consumerWalletsObservableAVAXFix();

    b0<Boolean> containsAddress(Blockchain blockchain, CurrencyCode currencyCode, String str);

    b0<x> createWallets(String str);

    b0<List<Wallet>> getAllActiveEthWallets();

    b0<List<CryptoCurrency>> getCryptoCurrencies(List<CurrencyCode> list);

    b0<Map<Blockchain, WalletAddress>> getPrimaryReceiveAddresses();

    b0<List<Address>> getUsedAddresses(Blockchain blockchain, Network network);

    b0<Boolean> hasWallets();

    s<Boolean> isSynced(Blockchain blockchain, Network network);

    s<Network> observeNetwork(Blockchain blockchain);

    s<List<Wallet>> observeWallets(boolean z);

    void switchIndex(Blockchain blockchain, int i2);

    void switchNetwork(Blockchain blockchain, Network network);
}