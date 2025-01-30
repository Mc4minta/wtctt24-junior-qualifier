package com.coinbase.wallet.blockchains.interfaces;

import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import h.c.b0;
import h.c.s;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: TxManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJe\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001f\u0010 J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010\tJ\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "", "isValidAddress", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "Lkotlin/x;", "resubmitPendingTxs", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "getConfiguration", "()Lcom/coinbase/wallet/blockchains/models/WalletConfiguration;", "configuration", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "getTxUpdatesObservable", "()Lh/c/s;", "txUpdatesObservable", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface TxManaging {

    /* compiled from: TxManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ b0 generateUnsignedTx$default(TxManaging txManaging, Wallet wallet, TransferValue transferValue, String str, Map map, BigInteger bigInteger, BigInteger bigInteger2, Integer num, int i2, Object obj) {
            if (obj == null) {
                return txManaging.generateUnsignedTx(wallet, transferValue, str, map, (i2 & 16) != 0 ? null : bigInteger, (i2 & 32) != 0 ? null : bigInteger2, (i2 & 64) != 0 ? null : num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedTx");
        }
    }

    b0<UnsignedTxResult> generateUnsignedTx(Wallet wallet, TransferValue transferValue, String str, Map<TxMetadataKey, ? extends Object> map, BigInteger bigInteger, BigInteger bigInteger2, Integer num);

    WalletConfiguration getConfiguration();

    b0<TxState> getTxState(String str, Network network);

    s<TxUpdate> getTxUpdatesObservable();

    b0<Boolean> isValidAddress(String str, Network network);

    b0<x> resubmitPendingTxs(Network network);

    b0<SignedTx> signAndSubmit(UnsignedTx unsignedTx, String str, boolean z);
}