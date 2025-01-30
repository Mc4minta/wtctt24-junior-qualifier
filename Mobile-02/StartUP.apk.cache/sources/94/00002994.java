package com.coinbase.wallet.wallets.interfaces;

import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.s;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.x;

/* compiled from: ITxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\rJg\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u007f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\"\u0010#JC\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H&¢\u0006\u0004\b%\u0010&J-\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u000bH&¢\u0006\u0004\b,\u0010-J-\u00100\u001a\b\u0012\u0004\u0012\u00020/0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH&¢\u0006\u0004\b0\u0010\rR\u001c\u00105\u001a\b\u0012\u0004\u0012\u000202018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "address", "Lh/c/b0;", "", "isValidAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "maxFeePerGas", "baseFeePerGas", "maxPriorityFeePerGas", "generateUnsigned1559Tx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lkotlin/x;", "validateTransferTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "getTxUpdatesObservable", "()Lh/c/s;", "txUpdatesObservable", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ITxRepository extends Refreshable, Startable, Destroyable {

    /* compiled from: ITxRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ b0 generateUnsigned1559Tx$default(ITxRepository iTxRepository, Wallet wallet, TransferValue transferValue, String str, Map map, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, int i2, Object obj) {
            Map map2;
            Map i3;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i3 = m0.i();
                    map2 = i3;
                } else {
                    map2 = map;
                }
                return iTxRepository.generateUnsigned1559Tx(wallet, transferValue, str, map2, (i2 & 16) != 0 ? null : bigInteger, (i2 & 32) != 0 ? null : bigInteger2, (i2 & 64) != 0 ? null : bigInteger3, (i2 & 128) != 0 ? null : bigInteger4, (i2 & 256) != 0 ? null : num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsigned1559Tx");
        }

        public static /* synthetic */ b0 generateUnsignedTx$default(ITxRepository iTxRepository, Wallet wallet, TransferValue transferValue, String str, Map map, BigInteger bigInteger, BigInteger bigInteger2, Integer num, int i2, Object obj) {
            Map map2;
            Map i3;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i3 = m0.i();
                    map2 = i3;
                } else {
                    map2 = map;
                }
                return iTxRepository.generateUnsignedTx(wallet, transferValue, str, map2, (i2 & 16) != 0 ? null : bigInteger, (i2 & 32) != 0 ? null : bigInteger2, (i2 & 64) != 0 ? null : num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateUnsignedTx");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b0 validateTransferTx$default(ITxRepository iTxRepository, Wallet wallet, TransferValue transferValue, String str, Map map, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    map = m0.i();
                }
                return iTxRepository.validateTransferTx(wallet, transferValue, str, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateTransferTx");
        }
    }

    b0<UnsignedTxResult> generateUnsigned1559Tx(Wallet wallet, TransferValue transferValue, String str, Map<TxMetadataKey, ? extends Object> map, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num);

    b0<UnsignedTxResult> generateUnsignedTx(Wallet wallet, TransferValue transferValue, String str, Map<TxMetadataKey, ? extends Object> map, BigInteger bigInteger, BigInteger bigInteger2, Integer num);

    b0<TxState> getTxState(Blockchain blockchain, Network network, String str);

    s<TxUpdate> getTxUpdatesObservable();

    b0<Boolean> isValidAddress(Blockchain blockchain, Network network, String str);

    b0<SignedTx> signAndSubmit(UnsignedTx unsignedTx, String str, boolean z);

    b0<x> validateTransferTx(Wallet wallet, TransferValue transferValue, String str, Map<TxMetadataKey, ? extends Object> map);
}