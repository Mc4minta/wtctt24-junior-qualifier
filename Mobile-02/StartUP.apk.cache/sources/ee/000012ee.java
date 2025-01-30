package com.coinbase.wallet.bip44wallets.interfaces;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.bip44wallets.models.BIP44CoinSelection;
import com.coinbase.wallet.bip44wallets.models.BIP44SignedData;
import com.coinbase.wallet.bip44wallets.models.BIP44UTXO;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.TxState;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: BIP44WalletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001JC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0017J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u0017J#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001b0\u000b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000b2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b(\u0010)J%\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u000b2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b,\u0010\u0017J1\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u001b0\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\n\u001a\u00020\bH'¢\u0006\u0004\b/\u00100JK\u00106\u001a\b\u0012\u0004\u0012\u00020!0\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u001b2\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\bH'¢\u0006\u0004\b6\u00107J;\u00108\u001a\b\u0012\u0004\u0012\u00020!0\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u001b2\u0006\u00102\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\bH'¢\u0006\u0004\b8\u00109\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44WalletService;", "", "", "xpubKey", "Lkotlin/UInt;", "index", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "", "change", "testnet", "Lh/c/b0;", "deriveAddressFromXpubKey-roUYKiI", "(Ljava/lang/String;ILcom/coinbase/wallet/blockchains/models/AddressType;ZZ)Lh/c/b0;", "deriveAddressFromXpubKey", "xpubKeyDerivationPath", "(Lcom/coinbase/wallet/blockchains/models/AddressType;Z)Ljava/lang/String;", "", "isChangeAddress", "addressDerivationPath", "(Lcom/coinbase/wallet/blockchains/models/AddressType;IZZ)Ljava/lang/String;", "address", "isAddressUsed", "(Ljava/lang/String;Z)Lh/c/b0;", "isAddressValid", "Ljava/math/BigInteger;", "getBalance", "", "estimateFee", "(Z)Lh/c/b0;", "", "", "privateKeys", "Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "coinSelection", "Lcom/coinbase/wallet/bip44wallets/models/BIP44SignedData;", "signTx", "(Ljava/util/Map;Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;Z)Lh/c/b0;", "signedTxData", "Lkotlin/x;", "submitTx", "([BZ)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxStatus", ApiConstants.ADDRESSES, "Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "getUnspentTxs", "(Ljava/util/List;Z)Lh/c/b0;", "utxos", "toAddress", "changeAddress", "amount", "feeRate", "generateCoinSelection", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Z)Lh/c/b0;", "generateCoinSweep", "(Ljava/util/List;Ljava/lang/String;Ljava/math/BigInteger;Z)Lh/c/b0;", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface BIP44WalletService {
    String addressDerivationPath(AddressType addressType, int i2, boolean z, boolean z2);

    /* renamed from: deriveAddressFromXpubKey-roUYKiI  reason: not valid java name */
    h.c.b0<String> mo760deriveAddressFromXpubKeyroUYKiI(String str, int i2, AddressType addressType, boolean z, boolean z2);

    h.c.b0<List<BigInteger>> estimateFee(boolean z);

    h.c.b0<BIP44CoinSelection> generateCoinSelection(List<BIP44UTXO> list, String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, boolean z);

    h.c.b0<BIP44CoinSelection> generateCoinSweep(List<BIP44UTXO> list, String str, BigInteger bigInteger, boolean z);

    h.c.b0<BigInteger> getBalance(String str, boolean z);

    h.c.b0<TxState> getTxStatus(String str, boolean z);

    h.c.b0<List<BIP44UTXO>> getUnspentTxs(List<String> list, boolean z);

    h.c.b0<Boolean> isAddressUsed(String str, boolean z);

    h.c.b0<Boolean> isAddressValid(String str, boolean z);

    h.c.b0<BIP44SignedData> signTx(Map<String, byte[]> map, BIP44CoinSelection bIP44CoinSelection, boolean z);

    h.c.b0<kotlin.x> submitTx(byte[] bArr, boolean z);

    String xpubKeyDerivationPath(AddressType addressType, boolean z);
}