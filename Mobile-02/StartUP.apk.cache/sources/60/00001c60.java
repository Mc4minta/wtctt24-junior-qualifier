package com.coinbase.wallet.ethereum.interfaces;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.ciphercore.SignedEthereumTransaction;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.core.extensions.ByteArray_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.extensions.CipherCore_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedTx;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;

/* compiled from: EthereumTxSigning.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxSigning;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;", "tx", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "", "skipNonceCheck", "Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "signTx", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;Ljava/lang/String;Z)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;", "sign1559Tx", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;Ljava/lang/String;Z)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;", "", "confirmedTxCount", "", "signedTransactions", "calculateNextNonce", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedTx;ILjava/util/List;Z)Lh/c/b0;", "pendingSignedTxs", "nextNonce", "(ILjava/util/List;)I", "Lcom/coinbase/ciphercore/KeyPair;", "keyPair", AdjustableMinerFeeArgs.NONCE, "sign1559Transaction", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsigned1559Tx;Lcom/coinbase/ciphercore/KeyPair;I)Lh/c/b0;", "signTransaction", "(Lcom/coinbase/wallet/ethereum/models/EthereumUnsignedLegacyTx;Lcom/coinbase/ciphercore/KeyPair;I)Lh/c/b0;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "getEthereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface EthereumTxSigning {

    /* compiled from: EthereumTxSigning.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ h.c.h0 a(EthereumTxSigning ethereumTxSigning, EthereumChain ethereumChain, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, kotlin.o oVar) {
            return m1154sign1559Tx$lambda5(ethereumTxSigning, ethereumChain, ethereumUnsigned1559Tx, oVar);
        }

        public static /* synthetic */ h.c.h0 b(EthereumTxSigning ethereumTxSigning, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, boolean z, kotlin.t tVar) {
            return m1160signTx$lambda2(ethereumTxSigning, ethereumUnsignedLegacyTx, z, tVar);
        }

        public static /* synthetic */ Integer c(boolean z, int i2, EthereumTxSigning ethereumTxSigning, int i3, List list, Optional optional) {
            return m1151calculateNextNonce$lambda12(z, i2, ethereumTxSigning, i3, list, optional);
        }

        private static h.c.b0<Integer> calculateNextNonce(final EthereumTxSigning ethereumTxSigning, EthereumUnsignedTx ethereumUnsignedTx, final int i2, final List<EthereumSignedTx> list, final boolean z) {
            Integer nonce = ethereumUnsignedTx.getNonce();
            if (nonce == null) {
                h.c.b0<Integer> just = h.c.b0.just(Integer.valueOf(nextNonce(ethereumTxSigning, i2, list)));
                kotlin.jvm.internal.m.f(just, "just(nextNonce(confirmedTxCount, signedTransactions))");
                return just;
            }
            final int intValue = nonce.intValue();
            final EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(ethereumUnsignedTx.getNetwork());
            if (asEthereumChain == null) {
                h.c.b0<Integer> error = h.c.b0.error(new NetworkException.InvalidNetwork(ethereumUnsignedTx.getNetwork()));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(tx.network))");
                return error;
            }
            h.c.b0<Integer> map = ethereumTxSigning.getEthereumSignedTxDao().getUnminedSignedTxs(asEthereumChain).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.c1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.d(intValue, asEthereumChain, (List) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.b1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.c(z, intValue, ethereumTxSigning, i2, list, (Optional) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "ethereumSignedTxDao.getUnminedSignedTxs(ethereumChain)\n            // Check if a transaction with the same nonce and chainId exists as the current one\n            .map { txs -> Optional(txs.firstOrNull { it.nonce == nonce && it.chainId == ethereumChain.chainId }) }\n\n            .map {\n                if (skipNonceCheck) { return@map nonce }\n\n                val expectedNextNonce = nextNonce(confirmedTxCount, signedTransactions)\n\n                when {\n                    // 1. If a transaction with the same nonce and chainId exists, then this nonce is valid\n                    it.value != null -> nonce\n\n                    // If 1. is false, then check if the next nonce is still the same or less than the one we just\n                    // calculated previously to fetching unconfirmed transactions, if so, then this nonce still is\n                    // valid with the same nonce. We shouldn't do this unless we intend to overwrite the previous\n                    // transaction with a higher gas cost.  A nonce must always be >= than the confirmed tx count\n                    // else, we have gotten an incorrect nonce\n                    nonce !in confirmedTxCount..expectedNextNonce -> throw EthereumException.IncorrectNonceProvided\n\n                    else -> nonce\n                }\n            }");
            return map;
        }

        public static /* synthetic */ h.c.b0 calculateNextNonce$default(EthereumTxSigning ethereumTxSigning, EthereumUnsignedTx ethereumUnsignedTx, int i2, List list, boolean z, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z = false;
                }
                return calculateNextNonce(ethereumTxSigning, ethereumUnsignedTx, i2, list, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateNextNonce");
        }

        /* renamed from: calculateNextNonce$lambda-11 */
        public static Optional m1150calculateNextNonce$lambda11(int i2, EthereumChain ethereumChain, List txs) {
            Object obj;
            boolean z;
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(txs, "txs");
            Iterator it = txs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) obj;
                if (ethereumSignedTx.getNonce() == i2 && ethereumSignedTx.getChainId() == ethereumChain.getChainId()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return new Optional(obj);
        }

        /* renamed from: calculateNextNonce$lambda-12 */
        public static Integer m1151calculateNextNonce$lambda12(boolean z, int i2, EthereumTxSigning this$0, int i3, List signedTransactions, Optional it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(signedTransactions, "$signedTransactions");
            kotlin.jvm.internal.m.g(it, "it");
            if (z) {
                return Integer.valueOf(i2);
            }
            int nextNonce = nextNonce(this$0, i3, signedTransactions);
            if (it.getValue() == null) {
                boolean z2 = false;
                if (i3 <= i2 && i2 <= nextNonce) {
                    z2 = true;
                }
                if (!z2) {
                    throw EthereumException.IncorrectNonceProvided.INSTANCE;
                }
            }
            return Integer.valueOf(i2);
        }

        public static /* synthetic */ Optional d(int i2, EthereumChain ethereumChain, List list) {
            return m1150calculateNextNonce$lambda11(i2, ethereumChain, list);
        }

        public static /* synthetic */ h.c.h0 e(EthereumTxSigning ethereumTxSigning, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, kotlin.o oVar) {
            return m1161signTx$lambda3(ethereumTxSigning, ethereumUnsignedLegacyTx, oVar);
        }

        public static /* synthetic */ h.c.h0 f(EthereumTxSigning ethereumTxSigning, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, boolean z, kotlin.t tVar) {
            return m1155sign1559Tx$lambda6(ethereumTxSigning, ethereumUnsigned1559Tx, z, tVar);
        }

        public static /* synthetic */ h.c.h0 g(EthereumTxSigning ethereumTxSigning, EthereumChain ethereumChain, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, kotlin.o oVar) {
            return m1159signTx$lambda1(ethereumTxSigning, ethereumChain, ethereumUnsignedLegacyTx, oVar);
        }

        public static /* synthetic */ EthereumSignedTx h(EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, int i2, EthereumChain ethereumChain, SignedEthereumTransaction signedEthereumTransaction) {
            return m1157signTransaction$lambda8(ethereumUnsignedLegacyTx, i2, ethereumChain, signedEthereumTransaction);
        }

        public static /* synthetic */ h.c.h0 i(EthereumTxSigning ethereumTxSigning, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, EthereumChain ethereumChain, KeyPair keyPair) {
            return m1153sign1559Tx$lambda4(ethereumTxSigning, ethereumUnsigned1559Tx, ethereumChain, keyPair);
        }

        public static /* synthetic */ EthereumSignedTx j(EthereumUnsigned1559Tx ethereumUnsigned1559Tx, int i2, EthereumChain ethereumChain, SignedEthereumTransaction signedEthereumTransaction) {
            return m1152sign1559Transaction$lambda9(ethereumUnsigned1559Tx, i2, ethereumChain, signedEthereumTransaction);
        }

        public static /* synthetic */ h.c.h0 k(EthereumTxSigning ethereumTxSigning, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, EthereumChain ethereumChain, KeyPair keyPair) {
            return m1158signTx$lambda0(ethereumTxSigning, ethereumUnsignedLegacyTx, ethereumChain, keyPair);
        }

        public static /* synthetic */ h.c.h0 l(EthereumTxSigning ethereumTxSigning, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, kotlin.o oVar) {
            return m1156sign1559Tx$lambda7(ethereumTxSigning, ethereumUnsigned1559Tx, oVar);
        }

        private static int nextNonce(EthereumTxSigning ethereumTxSigning, int i2, List<EthereumSignedTx> list) {
            int r;
            r = kotlin.a0.s.r(list, 10);
            ArrayList arrayList = new ArrayList(r);
            for (EthereumSignedTx ethereumSignedTx : list) {
                arrayList.add(Integer.valueOf(ethereumSignedTx.getNonce()));
            }
            Integer num = (Integer) kotlin.a0.p.n0(arrayList);
            if (num == null) {
                return i2;
            }
            int intValue = num.intValue();
            if (i2 <= intValue) {
                i2 = intValue + 1;
            }
            l.a.a.a(kotlin.jvm.internal.m.o("Calculated nonce = ", Integer.valueOf(i2)), new Object[0]);
            return i2;
        }

        private static h.c.b0<EthereumSignedTx> sign1559Transaction(EthereumTxSigning ethereumTxSigning, final EthereumUnsigned1559Tx ethereumUnsigned1559Tx, KeyPair keyPair, final int i2) {
            final EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(ethereumUnsigned1559Tx.getNetwork());
            if (asEthereumChain == null) {
                h.c.b0<EthereumSignedTx> error = h.c.b0.error(new NetworkException.InvalidNetwork(ethereumUnsigned1559Tx.getNetwork()));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(tx.network))");
                return error;
            }
            h.c.b0 map = ethereumTxSigning.getCipherCore().signEthereum1559Transaction(ethereumUnsigned1559Tx.getToAddress(), ethereumUnsigned1559Tx.getWeiValue(), ethereumUnsigned1559Tx.getData(), i2, ethereumUnsigned1559Tx.getMaxFeePerGas(), ethereumUnsigned1559Tx.getMaxPriorityFeePerGas(), ethereumUnsigned1559Tx.getGasLimit(), keyPair.getPrivateKey(), asEthereumChain.getChainId()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.i1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.j(EthereumUnsigned1559Tx.this, i2, asEthereumChain, (SignedEthereumTransaction) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "signTxSingle\n            // Create new `SignedTransaction` instance using the signed data\n            .map { signedTransaction ->\n                EthereumSignedTx(\n                    id = UUID.randomUUID().toString(),\n                    fromAddress = tx.fromAddress,\n                    toAddress = tx.toAddress,\n                    nonce = nonce,\n                    chainId = ethereumChain.chainId,\n                    signedTxData = signedTransaction.data,\n                    txHash = signedTransaction.hash.toPrefixedHexString(),\n                    weiValue = tx.weiValue,\n                    erc20Value = tx.erc20Value,\n                    blockchain = tx.blockchain,\n                    currencyCode = tx.currencyCode,\n                    state = TxState.PENDING,\n                    notFoundCount = 0\n                )\n            }");
            return map;
        }

        /* renamed from: sign1559Transaction$lambda-9 */
        public static EthereumSignedTx m1152sign1559Transaction$lambda9(EthereumUnsigned1559Tx tx, int i2, EthereumChain ethereumChain, SignedEthereumTransaction signedTransaction) {
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(signedTransaction, "signedTransaction");
            String uuid = UUID.randomUUID().toString();
            kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
            return new EthereumSignedTx(uuid, tx.getFromAddress(), tx.getToAddress(), i2, ethereumChain.getChainId(), signedTransaction.getData(), ByteArray_CoreKt.toPrefixedHexString(signedTransaction.getHash()), tx.getWeiValue(), tx.getErc20Value(), tx.getBlockchain(), tx.getCurrencyCode(), TxState.PENDING, 0);
        }

        public static h.c.b0<EthereumSignedTx> sign1559Tx(final EthereumTxSigning ethereumTxSigning, final EthereumUnsigned1559Tx tx, String mnemonic, final boolean z) {
            kotlin.jvm.internal.m.g(ethereumTxSigning, "this");
            kotlin.jvm.internal.m.g(tx, "tx");
            kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
            final EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(tx.getNetwork());
            if (asEthereumChain == null) {
                h.c.b0<EthereumSignedTx> error = h.c.b0.error(new NetworkException.InvalidNetwork(tx.getNetwork()));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(tx.network))");
                return error;
            }
            h.c.b0 flatMap = CipherCore_EthereumKt.getEthereumWalletKeyPair(ethereumTxSigning.getCipherCore(), tx.getWalletIndex(), mnemonic).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.h1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.i(EthereumTxSigning.this, tx, asEthereumChain, (KeyPair) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.z0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.a(EthereumTxSigning.this, asEthereumChain, tx, (kotlin.o) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.e1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.f(EthereumTxSigning.this, tx, z, (kotlin.t) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.k1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.l(EthereumTxSigning.this, tx, (kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "cipherCore.getEthereumWalletKeyPair(tx.walletIndex, mnemonic)\n\n            // get most recent nonce using CipherCore\n            .flatMap { keyPair ->\n                val confirmedTxCountSingle = cipherCore.getConfirmedEthereumTransactionCount(\n                    address = tx.fromAddress,\n                    chainId = ethereumChain.chainId\n                )\n\n                Singles.zip(Single.just(keyPair), confirmedTxCountSingle)\n            }\n\n            // Get list of signed transactions from db with nonce greater than most recent confirmed\n            // transaction count\n            .flatMap { (keyPair, confirmedTxCount) ->\n                val pendingSignedTxs = ethereumSignedTxDao.getUnminedSignedTxsAfterNonce(\n                    nonce = confirmedTxCount,\n                    chainId = ethereumChain.chainId,\n                    fromAddress = tx.fromAddress\n                )\n\n                Singles.zip(Single.just(keyPair), Single.just(confirmedTxCount), pendingSignedTxs)\n            }\n\n            // calculate nonce\n            .flatMap { (keyPair, confirmedTxCount, pendingSignedTxs) ->\n                val nonce = calculateNextNonce(tx, confirmedTxCount, pendingSignedTxs, skipNonceCheck)\n\n                Singles.zip(Single.just(keyPair), nonce)\n            }\n\n            // Sign the transaction\n            .flatMap { (keyPair, nonce) -> sign1559Transaction(tx, keyPair, nonce) }");
            return Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null);
        }

        public static /* synthetic */ h.c.b0 sign1559Tx$default(EthereumTxSigning ethereumTxSigning, EthereumUnsigned1559Tx ethereumUnsigned1559Tx, String str, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = false;
                }
                return ethereumTxSigning.sign1559Tx(ethereumUnsigned1559Tx, str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sign1559Tx");
        }

        /* renamed from: sign1559Tx$lambda-4 */
        public static h.c.h0 m1153sign1559Tx$lambda4(EthereumTxSigning this$0, EthereumUnsigned1559Tx tx, EthereumChain ethereumChain, KeyPair keyPair) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(keyPair, "keyPair");
            h.c.b0 confirmedEthereumTransactionCount$default = CipherCoreInterface.DefaultImpls.getConfirmedEthereumTransactionCount$default(this$0.getCipherCore(), tx.getFromAddress(), ethereumChain.getChainId(), null, 4, null);
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(keyPair);
            kotlin.jvm.internal.m.f(just, "just(keyPair)");
            return eVar.a(just, confirmedEthereumTransactionCount$default);
        }

        /* renamed from: sign1559Tx$lambda-5 */
        public static h.c.h0 m1154sign1559Tx$lambda5(EthereumTxSigning this$0, EthereumChain ethereumChain, EthereumUnsigned1559Tx tx, kotlin.o dstr$keyPair$confirmedTxCount) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(dstr$keyPair$confirmedTxCount, "$dstr$keyPair$confirmedTxCount");
            Integer confirmedTxCount = (Integer) dstr$keyPair$confirmedTxCount.b();
            EthereumSignedTxDao ethereumSignedTxDao = this$0.getEthereumSignedTxDao();
            kotlin.jvm.internal.m.f(confirmedTxCount, "confirmedTxCount");
            h.c.b0<List<EthereumSignedTx>> unminedSignedTxsAfterNonce = ethereumSignedTxDao.getUnminedSignedTxsAfterNonce(confirmedTxCount.intValue(), ethereumChain.getChainId(), tx.getFromAddress());
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just((KeyPair) dstr$keyPair$confirmedTxCount.a());
            kotlin.jvm.internal.m.f(just, "just(keyPair)");
            h.c.b0 just2 = h.c.b0.just(confirmedTxCount);
            kotlin.jvm.internal.m.f(just2, "just(confirmedTxCount)");
            return eVar.b(just, just2, unminedSignedTxsAfterNonce);
        }

        /* renamed from: sign1559Tx$lambda-6 */
        public static h.c.h0 m1155sign1559Tx$lambda6(EthereumTxSigning this$0, EthereumUnsigned1559Tx tx, boolean z, kotlin.t dstr$keyPair$confirmedTxCount$pendingSignedTxs) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(dstr$keyPair$confirmedTxCount$pendingSignedTxs, "$dstr$keyPair$confirmedTxCount$pendingSignedTxs");
            Integer confirmedTxCount = (Integer) dstr$keyPair$confirmedTxCount$pendingSignedTxs.b();
            List pendingSignedTxs = (List) dstr$keyPair$confirmedTxCount$pendingSignedTxs.c();
            kotlin.jvm.internal.m.f(confirmedTxCount, "confirmedTxCount");
            int intValue = confirmedTxCount.intValue();
            kotlin.jvm.internal.m.f(pendingSignedTxs, "pendingSignedTxs");
            h.c.b0<Integer> calculateNextNonce = calculateNextNonce(this$0, tx, intValue, pendingSignedTxs, z);
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just((KeyPair) dstr$keyPair$confirmedTxCount$pendingSignedTxs.a());
            kotlin.jvm.internal.m.f(just, "just(keyPair)");
            return eVar.a(just, calculateNextNonce);
        }

        /* renamed from: sign1559Tx$lambda-7 */
        public static h.c.h0 m1156sign1559Tx$lambda7(EthereumTxSigning this$0, EthereumUnsigned1559Tx tx, kotlin.o dstr$keyPair$nonce) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(dstr$keyPair$nonce, "$dstr$keyPair$nonce");
            KeyPair keyPair = (KeyPair) dstr$keyPair$nonce.a();
            Integer nonce = (Integer) dstr$keyPair$nonce.b();
            kotlin.jvm.internal.m.f(keyPair, "keyPair");
            kotlin.jvm.internal.m.f(nonce, "nonce");
            return sign1559Transaction(this$0, tx, keyPair, nonce.intValue());
        }

        private static h.c.b0<EthereumSignedTx> signTransaction(EthereumTxSigning ethereumTxSigning, final EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, KeyPair keyPair, final int i2) {
            h.c.b0<SignedEthereumTransaction> signEthereumTransaction;
            final EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(ethereumUnsignedLegacyTx.getNetwork());
            if (asEthereumChain == null) {
                h.c.b0<EthereumSignedTx> error = h.c.b0.error(new NetworkException.InvalidNetwork(ethereumUnsignedLegacyTx.getNetwork()));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(tx.network))");
                return error;
            }
            boolean z = true;
            if (asEthereumChain.getChainId() != 1 && asEthereumChain.getChainId() != 3 && asEthereumChain.getChainId() != 4 && asEthereumChain.getChainId() != 5 && asEthereumChain.getChainId() != 42) {
                z = false;
            }
            if (z) {
                signEthereumTransaction = ethereumTxSigning.getCipherCore().sign2930Transaction(ethereumUnsignedLegacyTx.getToAddress(), ethereumUnsignedLegacyTx.getWeiValue(), ethereumUnsignedLegacyTx.getData(), i2, ethereumUnsignedLegacyTx.getGasPrice(), ethereumUnsignedLegacyTx.getGasLimit(), keyPair.getPrivateKey(), asEthereumChain.getChainId());
            } else {
                signEthereumTransaction = ethereumTxSigning.getCipherCore().signEthereumTransaction(ethereumUnsignedLegacyTx.getToAddress(), ethereumUnsignedLegacyTx.getWeiValue(), ethereumUnsignedLegacyTx.getData(), i2, ethereumUnsignedLegacyTx.getGasPrice(), ethereumUnsignedLegacyTx.getGasLimit(), keyPair.getPrivateKey(), asEthereumChain.getChainId());
            }
            h.c.b0 map = signEthereumTransaction.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.g1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.h(EthereumUnsignedLegacyTx.this, i2, asEthereumChain, (SignedEthereumTransaction) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "signTxSingle\n            // Create new `SignedTransaction` instance using the signed data\n            .map { signedTransaction ->\n                EthereumSignedTx(\n                    id = UUID.randomUUID().toString(),\n                    fromAddress = tx.fromAddress,\n                    toAddress = tx.toAddress,\n                    nonce = nonce,\n                    chainId = ethereumChain.chainId,\n                    signedTxData = signedTransaction.data,\n                    txHash = signedTransaction.hash.toPrefixedHexString(),\n                    weiValue = tx.weiValue,\n                    erc20Value = tx.erc20Value,\n                    blockchain = tx.blockchain,\n                    currencyCode = tx.currencyCode,\n                    state = TxState.PENDING,\n                    notFoundCount = 0\n                )\n            }");
            return map;
        }

        /* renamed from: signTransaction$lambda-8 */
        public static EthereumSignedTx m1157signTransaction$lambda8(EthereumUnsignedLegacyTx tx, int i2, EthereumChain ethereumChain, SignedEthereumTransaction signedTransaction) {
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(signedTransaction, "signedTransaction");
            String uuid = UUID.randomUUID().toString();
            kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
            return new EthereumSignedTx(uuid, tx.getFromAddress(), tx.getToAddress(), i2, ethereumChain.getChainId(), signedTransaction.getData(), ByteArray_CoreKt.toPrefixedHexString(signedTransaction.getHash()), tx.getWeiValue(), tx.getErc20Value(), tx.getBlockchain(), tx.getCurrencyCode(), TxState.PENDING, 0);
        }

        public static h.c.b0<EthereumSignedTx> signTx(final EthereumTxSigning ethereumTxSigning, final EthereumUnsignedLegacyTx tx, String mnemonic, final boolean z) {
            kotlin.jvm.internal.m.g(ethereumTxSigning, "this");
            kotlin.jvm.internal.m.g(tx, "tx");
            kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
            final EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(tx.getNetwork());
            if (asEthereumChain == null) {
                h.c.b0<EthereumSignedTx> error = h.c.b0.error(new NetworkException.InvalidNetwork(tx.getNetwork()));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(tx.network))");
                return error;
            }
            h.c.b0 flatMap = CipherCore_EthereumKt.getEthereumWalletKeyPair(ethereumTxSigning.getCipherCore(), tx.getWalletIndex(), mnemonic).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.j1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.k(EthereumTxSigning.this, tx, asEthereumChain, (KeyPair) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.f1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.g(EthereumTxSigning.this, asEthereumChain, tx, (kotlin.o) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.a1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.b(EthereumTxSigning.this, tx, z, (kotlin.t) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.d1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSigning.DefaultImpls.e(EthereumTxSigning.this, tx, (kotlin.o) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "cipherCore.getEthereumWalletKeyPair(tx.walletIndex, mnemonic)\n\n            // get most recent nonce using CipherCore\n            .flatMap { keyPair ->\n                val confirmedTxCountSingle = cipherCore.getConfirmedEthereumTransactionCount(\n                    address = tx.fromAddress,\n                    chainId = ethereumChain.chainId\n                )\n\n                Singles.zip(Single.just(keyPair), confirmedTxCountSingle)\n            }\n\n            // Get list of signed transactions from db with nonce greater than most recent confirmed\n            // transaction count\n            .flatMap { (keyPair, confirmedTxCount) ->\n                val pendingSignedTxs = ethereumSignedTxDao.getUnminedSignedTxsAfterNonce(\n                    nonce = confirmedTxCount,\n                    chainId = ethereumChain.chainId,\n                    fromAddress = tx.fromAddress\n                )\n\n                Singles.zip(Single.just(keyPair), Single.just(confirmedTxCount), pendingSignedTxs)\n            }\n\n            // calculate nonce\n            .flatMap { (keyPair, confirmedTxCount, pendingSignedTxs) ->\n                val nonce = calculateNextNonce(tx, confirmedTxCount, pendingSignedTxs, skipNonceCheck)\n\n                Singles.zip(Single.just(keyPair), nonce)\n            }\n\n            // Sign the transaction\n            .flatMap { (keyPair, nonce) -> signTransaction(tx, keyPair, nonce) }");
            return Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null);
        }

        public static /* synthetic */ h.c.b0 signTx$default(EthereumTxSigning ethereumTxSigning, EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, String str, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = false;
                }
                return ethereumTxSigning.signTx(ethereumUnsignedLegacyTx, str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signTx");
        }

        /* renamed from: signTx$lambda-0 */
        public static h.c.h0 m1158signTx$lambda0(EthereumTxSigning this$0, EthereumUnsignedLegacyTx tx, EthereumChain ethereumChain, KeyPair keyPair) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(keyPair, "keyPair");
            h.c.b0 confirmedEthereumTransactionCount$default = CipherCoreInterface.DefaultImpls.getConfirmedEthereumTransactionCount$default(this$0.getCipherCore(), tx.getFromAddress(), ethereumChain.getChainId(), null, 4, null);
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just(keyPair);
            kotlin.jvm.internal.m.f(just, "just(keyPair)");
            return eVar.a(just, confirmedEthereumTransactionCount$default);
        }

        /* renamed from: signTx$lambda-1 */
        public static h.c.h0 m1159signTx$lambda1(EthereumTxSigning this$0, EthereumChain ethereumChain, EthereumUnsignedLegacyTx tx, kotlin.o dstr$keyPair$confirmedTxCount) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(ethereumChain, "$ethereumChain");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(dstr$keyPair$confirmedTxCount, "$dstr$keyPair$confirmedTxCount");
            Integer confirmedTxCount = (Integer) dstr$keyPair$confirmedTxCount.b();
            EthereumSignedTxDao ethereumSignedTxDao = this$0.getEthereumSignedTxDao();
            kotlin.jvm.internal.m.f(confirmedTxCount, "confirmedTxCount");
            h.c.b0<List<EthereumSignedTx>> unminedSignedTxsAfterNonce = ethereumSignedTxDao.getUnminedSignedTxsAfterNonce(confirmedTxCount.intValue(), ethereumChain.getChainId(), tx.getFromAddress());
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just((KeyPair) dstr$keyPair$confirmedTxCount.a());
            kotlin.jvm.internal.m.f(just, "just(keyPair)");
            h.c.b0 just2 = h.c.b0.just(confirmedTxCount);
            kotlin.jvm.internal.m.f(just2, "just(confirmedTxCount)");
            return eVar.b(just, just2, unminedSignedTxsAfterNonce);
        }

        /* renamed from: signTx$lambda-2 */
        public static h.c.h0 m1160signTx$lambda2(EthereumTxSigning this$0, EthereumUnsignedLegacyTx tx, boolean z, kotlin.t dstr$keyPair$confirmedTxCount$pendingSignedTxs) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(dstr$keyPair$confirmedTxCount$pendingSignedTxs, "$dstr$keyPair$confirmedTxCount$pendingSignedTxs");
            Integer confirmedTxCount = (Integer) dstr$keyPair$confirmedTxCount$pendingSignedTxs.b();
            List pendingSignedTxs = (List) dstr$keyPair$confirmedTxCount$pendingSignedTxs.c();
            kotlin.jvm.internal.m.f(confirmedTxCount, "confirmedTxCount");
            int intValue = confirmedTxCount.intValue();
            kotlin.jvm.internal.m.f(pendingSignedTxs, "pendingSignedTxs");
            h.c.b0<Integer> calculateNextNonce = calculateNextNonce(this$0, tx, intValue, pendingSignedTxs, z);
            h.c.t0.e eVar = h.c.t0.e.a;
            h.c.b0 just = h.c.b0.just((KeyPair) dstr$keyPair$confirmedTxCount$pendingSignedTxs.a());
            kotlin.jvm.internal.m.f(just, "just(keyPair)");
            return eVar.a(just, calculateNextNonce);
        }

        /* renamed from: signTx$lambda-3 */
        public static h.c.h0 m1161signTx$lambda3(EthereumTxSigning this$0, EthereumUnsignedLegacyTx tx, kotlin.o dstr$keyPair$nonce) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(dstr$keyPair$nonce, "$dstr$keyPair$nonce");
            KeyPair keyPair = (KeyPair) dstr$keyPair$nonce.a();
            Integer nonce = (Integer) dstr$keyPair$nonce.b();
            kotlin.jvm.internal.m.f(keyPair, "keyPair");
            kotlin.jvm.internal.m.f(nonce, "nonce");
            return signTransaction(this$0, tx, keyPair, nonce.intValue());
        }
    }

    CipherCoreInterface getCipherCore();

    EthereumSignedTxDao getEthereumSignedTxDao();

    StoreInterface getStore();

    h.c.b0<EthereumSignedTx> sign1559Tx(EthereumUnsigned1559Tx ethereumUnsigned1559Tx, String str, boolean z);

    h.c.b0<EthereumSignedTx> signTx(EthereumUnsignedLegacyTx ethereumUnsignedLegacyTx, String str, boolean z);
}