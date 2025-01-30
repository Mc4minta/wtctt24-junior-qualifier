package com.coinbase.wallet.dogecoin.services;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception;
import com.coinbase.wallet.bip44wallets.interfaces.BitcoinLikeWalletService;
import com.coinbase.wallet.bip44wallets.models.BIP44CoinSelection;
import com.coinbase.wallet.bip44wallets.models.BIP44SignedData;
import com.coinbase.wallet.bip44wallets.models.BIP44UTXO;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.dogecoin.extensions.AddressKind_DogecoinKt;
import com.coinbase.wallet.dogecoin.extensions.BIP44CoinSelection_DogecoinKt;
import com.coinbase.wallet.dogecoin.extensions.BIP44UTXO_DogecoinKt;
import com.coinbase.wallet.dogecoin.extensions.CoinSelection_DogecoinKt;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.dogecoin.CoinSelection;
import com.coinbase.walletengine.services.dogecoin.DogecoinService;
import com.coinbase.walletengine.services.dogecoin.SignedTransaction;
import com.coinbase.walletengine.services.dogecoin.TransactionResult;
import com.coinbase.walletengine.services.dogecoin.TransactionStatus;
import com.coinbase.walletengine.services.dogecoin.UTXO;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: DOGEService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0019\u0010\u001aJK\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b \u0010!JC\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J!\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010,J%\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u000b2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lcom/coinbase/wallet/dogecoin/services/DOGEService;", "Lcom/coinbase/walletengine/services/dogecoin/DogecoinService;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BitcoinLikeWalletService;", "", "", "", "privateKeys", "Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "coinSelection", "", "testnet", "Lh/c/b0;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedData;", "signTx", "(Ljava/util/Map;Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;Z)Lh/c/b0;", "signedTxData", "Lkotlin/x;", "submitTx", "([BZ)Lh/c/b0;", "", "Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "utxos", "toAddress", "Ljava/math/BigInteger;", "feeRate", "generateCoinSweep", "(Ljava/util/List;Ljava/lang/String;Ljava/math/BigInteger;Z)Lh/c/b0;", "changeAddress", "amount", "generateCoinSelection", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Z)Lh/c/b0;", ApiConstants.ADDRESSES, "getUnspentTxs", "(Ljava/util/List;Z)Lh/c/b0;", "xpubKey", "Lkotlin/UInt;", "index", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "change", "deriveAddressFromXpubKey-roUYKiI", "(Ljava/lang/String;ILcom/coinbase/wallet/blockchains/models/AddressType;ZZ)Lh/c/b0;", "deriveAddressFromXpubKey", "xpubKeyDerivationPath", "(Lcom/coinbase/wallet/blockchains/models/AddressType;Z)Ljava/lang/String;", "txHash", "isTestnet", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxStatus", "(Ljava/lang/String;Z)Lh/c/b0;", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "dogecoin_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DOGEService extends DogecoinService implements BitcoinLikeWalletService {

    /* compiled from: DOGEService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TransactionStatus.values().length];
            iArr[TransactionStatus.CONFIRMED.ordinal()] = 1;
            iArr[TransactionStatus.NOT_FOUND.ordinal()] = 2;
            iArr[TransactionStatus.PENDING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DOGEService(WalletEngine walletEngine) {
        super(walletEngine);
        m.g(walletEngine, "walletEngine");
    }

    /* renamed from: generateCoinSelection$lambda-5 */
    public static final h0 m1082generateCoinSelection$lambda5(DOGEService this$0, String toAddress, String changeAddress, BigInteger amount, BigInteger feeRate, boolean z, List it) {
        m.g(this$0, "this$0");
        m.g(toAddress, "$toAddress");
        m.g(changeAddress, "$changeAddress");
        m.g(amount, "$amount");
        m.g(feeRate, "$feeRate");
        m.g(it, "it");
        return this$0.selectCoins(it, toAddress, changeAddress, amount, feeRate, z);
    }

    /* renamed from: generateCoinSelection$lambda-6 */
    public static final BIP44CoinSelection m1083generateCoinSelection$lambda6(CoinSelection it) {
        m.g(it, "it");
        return CoinSelection_DogecoinKt.asBIP44CoinSelection(it);
    }

    /* renamed from: generateCoinSweep$lambda-2 */
    public static final h0 m1084generateCoinSweep$lambda2(DOGEService this$0, String toAddress, BigInteger feeRate, boolean z, List it) {
        m.g(this$0, "this$0");
        m.g(toAddress, "$toAddress");
        m.g(feeRate, "$feeRate");
        m.g(it, "it");
        return this$0.sweepCoins(it, toAddress, feeRate, z);
    }

    /* renamed from: generateCoinSweep$lambda-3 */
    public static final BIP44CoinSelection m1085generateCoinSweep$lambda3(CoinSelection it) {
        m.g(it, "it");
        return CoinSelection_DogecoinKt.asBIP44CoinSelection(it);
    }

    /* renamed from: getTxStatus$lambda-9 */
    public static final TxState m1086getTxStatus$lambda9(TransactionResult it) {
        m.g(it, "it");
        int i2 = WhenMappings.$EnumSwitchMapping$0[it.getStatus().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return TxState.PENDING;
                }
                throw new NoWhenBranchMatchedException();
            }
            return TxState.DROPPED;
        }
        return TxState.CONFIRMED;
    }

    /* renamed from: getUnspentTxs$lambda-8 */
    public static final List m1087getUnspentTxs$lambda8(List utxos) {
        int r;
        m.g(utxos, "utxos");
        r = s.r(utxos, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = utxos.iterator();
        while (it.hasNext()) {
            UTXO utxo = (UTXO) it.next();
            arrayList.add(new BIP44UTXO(utxo.getAddress(), utxo.getHash(), utxo.m2020getIndexpVg5ArA(), utxo.getValue(), utxo.getScript(), null));
        }
        return arrayList;
    }

    public static /* synthetic */ List m(List list) {
        return m1087getUnspentTxs$lambda8(list);
    }

    public static /* synthetic */ BIP44SignedData n(SignedTransaction signedTransaction) {
        return m1088signTx$lambda0(signedTransaction);
    }

    public static /* synthetic */ h0 o(DOGEService dOGEService, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, boolean z, List list) {
        return m1082generateCoinSelection$lambda5(dOGEService, str, str2, bigInteger, bigInteger2, z, list);
    }

    public static /* synthetic */ BIP44CoinSelection p(CoinSelection coinSelection) {
        return m1085generateCoinSweep$lambda3(coinSelection);
    }

    public static /* synthetic */ BIP44CoinSelection q(CoinSelection coinSelection) {
        return m1083generateCoinSelection$lambda6(coinSelection);
    }

    public static /* synthetic */ TxState r(TransactionResult transactionResult) {
        return m1086getTxStatus$lambda9(transactionResult);
    }

    public static /* synthetic */ h0 s(DOGEService dOGEService, String str, BigInteger bigInteger, boolean z, List list) {
        return m1084generateCoinSweep$lambda2(dOGEService, str, bigInteger, z, list);
    }

    /* renamed from: signTx$lambda-0 */
    public static final BIP44SignedData m1088signTx$lambda0(SignedTransaction it) {
        m.g(it, "it");
        return new BIP44SignedData(it.getHash(), it.getData());
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BitcoinLikeWalletService, com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public String addressDerivationPath(AddressType addressType, int i2, boolean z, boolean z2) {
        return BitcoinLikeWalletService.DefaultImpls.addressDerivationPath(this, addressType, i2, z, z2);
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    /* renamed from: deriveAddressFromXpubKey-roUYKiI */
    public b0<String> mo760deriveAddressFromXpubKeyroUYKiI(String xpubKey, int i2, AddressType addressType, boolean z, boolean z2) {
        m.g(xpubKey, "xpubKey");
        m.g(addressType, "addressType");
        if (m.c(addressType, AddressKind_DogecoinKt.getDogecoin(AddressType.Companion))) {
            return m2010deriveLegacyAddressFromXpubKeyYuhug_o(xpubKey, i2, z, z2);
        }
        b0<String> error = b0.error(new BIP44Exception.UnableToDeriveXpubKey(addressType, z2));
        m.f(error, "error(BIP44Exception.UnableToDeriveXpubKey(addressType, testnet))");
        return error;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public b0<BIP44CoinSelection> generateCoinSelection(List<BIP44UTXO> utxos, final String toAddress, final String changeAddress, final BigInteger amount, final BigInteger feeRate, final boolean z) {
        int r;
        m.g(utxos, "utxos");
        m.g(toAddress, "toAddress");
        m.g(changeAddress, "changeAddress");
        m.g(amount, "amount");
        m.g(feeRate, "feeRate");
        r = s.r(utxos, 10);
        ArrayList arrayList = new ArrayList(r);
        for (BIP44UTXO bip44utxo : utxos) {
            arrayList.add(BIP44UTXO_DogecoinKt.asUTXO(bip44utxo));
        }
        b0<BIP44CoinSelection> map = b0.just(arrayList).flatMap(new n() { // from class: com.coinbase.wallet.dogecoin.services.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.o(DOGEService.this, toAddress, changeAddress, amount, feeRate, z, (List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.dogecoin.services.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.q((CoinSelection) obj);
            }
        });
        m.f(map, "just(utxos.map { it.asUTXO() })\n        .flatMap { selectCoins(it, toAddress, changeAddress, amount, feeRate, testnet) }\n        .map { it.asBIP44CoinSelection() }");
        return map;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public b0<BIP44CoinSelection> generateCoinSweep(List<BIP44UTXO> utxos, final String toAddress, final BigInteger feeRate, final boolean z) {
        int r;
        m.g(utxos, "utxos");
        m.g(toAddress, "toAddress");
        m.g(feeRate, "feeRate");
        r = s.r(utxos, 10);
        ArrayList arrayList = new ArrayList(r);
        for (BIP44UTXO bip44utxo : utxos) {
            arrayList.add(BIP44UTXO_DogecoinKt.asUTXO(bip44utxo));
        }
        b0<BIP44CoinSelection> map = b0.just(arrayList).flatMap(new n() { // from class: com.coinbase.wallet.dogecoin.services.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.s(DOGEService.this, toAddress, feeRate, z, (List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.dogecoin.services.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.p((CoinSelection) obj);
            }
        });
        m.f(map, "just(utxos.map { it.asUTXO() })\n        .flatMap { sweepCoins(it, toAddress, feeRate, testnet) }\n        .map { it.asBIP44CoinSelection() }");
        return map;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public b0<TxState> getTxStatus(String txHash, boolean z) {
        m.g(txHash, "txHash");
        b0 map = getTransactionResult(txHash, z).map(new n() { // from class: com.coinbase.wallet.dogecoin.services.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.r((TransactionResult) obj);
            }
        });
        m.f(map, "getTransactionResult(txHash, isTestnet)\n        .map {\n            when (it.status) {\n                TransactionStatus.CONFIRMED -> TxState.CONFIRMED\n                TransactionStatus.NOT_FOUND -> TxState.DROPPED\n                TransactionStatus.PENDING -> TxState.PENDING\n            }\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public b0<List<BIP44UTXO>> getUnspentTxs(List<String> addresses, boolean z) {
        m.g(addresses, "addresses");
        b0 map = getUTXOs(addresses, z).map(new n() { // from class: com.coinbase.wallet.dogecoin.services.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.m((List) obj);
            }
        });
        m.f(map, "getUTXOs(addresses, testnet).map { utxos ->\n            utxos.map { utxo ->\n                BIP44UTXO(\n                    address = utxo.address,\n                    hash = utxo.hash,\n                    index = utxo.index,\n                    value = utxo.value,\n                    script = utxo.script\n                )\n            }\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public b0<BIP44SignedData> signTx(Map<String, byte[]> privateKeys, BIP44CoinSelection coinSelection, boolean z) {
        m.g(privateKeys, "privateKeys");
        m.g(coinSelection, "coinSelection");
        b0 map = signTransaction(privateKeys, BIP44CoinSelection_DogecoinKt.asCoinSelection(coinSelection), z).map(new n() { // from class: com.coinbase.wallet.dogecoin.services.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DOGEService.n((SignedTransaction) obj);
            }
        });
        m.f(map, "signTransaction(privateKeys, coinSelection.asCoinSelection(), testnet)\n        .map { BIP44SignedData(it.hash, it.data) }");
        return map;
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public b0<x> submitTx(byte[] signedTxData, boolean z) {
        m.g(signedTxData, "signedTxData");
        return submitSignedTransaction(signedTxData, z);
    }

    @Override // com.coinbase.wallet.bip44wallets.interfaces.BIP44WalletService
    public String xpubKeyDerivationPath(AddressType addressType, boolean z) {
        m.g(addressType, "addressType");
        if (m.c(addressType, AddressKind_DogecoinKt.getDogecoin(AddressType.Companion))) {
            return z ? "m/44'/1'/0'" : "m/44'/3'/0'";
        }
        return null;
    }
}