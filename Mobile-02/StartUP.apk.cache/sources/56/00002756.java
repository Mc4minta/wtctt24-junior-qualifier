package com.coinbase.wallet.txhistory.extensions;

import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.consumer.extensions.TxMetadataKey_ConsumerConnectKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Transaction+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Transaction;", "", "truncateIfNeeded", "", "entityDisplayName", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Z)Ljava/lang/String;", "isConsumerTransfer", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)Z", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Transaction_TxHistoryKt {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r0 != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String entityDisplayName(com.coinbase.wallet.blockchains.models.Transaction r9, boolean r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.g(r9, r0)
            boolean r0 = r9.isSent()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L42
            java.lang.String r3 = r9.getToAddress()
            if (r3 == 0) goto L19
            boolean r0 = kotlin.l0.o.D(r3)
            if (r0 == 0) goto L1a
        L19:
            r1 = r2
        L1a:
            if (r1 != 0) goto L28
            if (r10 == 0) goto L27
            r4 = 6
            r5 = 4
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r3 = com.coinbase.wallet.common.extensions.String_CommonKt.truncateMiddle$default(r3, r4, r5, r6, r7, r8)
        L27:
            return r3
        L28:
            com.coinbase.wallet.blockchains.models.Network r9 = r9.getNetwork()
            com.coinbase.ciphercore.ethereum.EthereumChain r9 = com.coinbase.wallet.ethereum.extensions.Network_EthereumKt.getAsEthereumChain(r9)
            if (r9 == 0) goto L3b
            com.coinbase.wallet.common.utilities.LocalizedStrings r9 = com.coinbase.wallet.common.utilities.LocalizedStrings.INSTANCE
            int r10 = com.coinbase.wallet.txhistory.R.string.transaction_destination_created_contract
            java.lang.String r9 = r9.get(r10)
            goto L41
        L3b:
            com.coinbase.wallet.core.extensions.Strings r9 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r9 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r9)
        L41:
            return r9
        L42:
            boolean r0 = isConsumerTransfer(r9)
            if (r0 == 0) goto L4b
            java.lang.String r9 = "Coinbase.com"
            return r9
        L4b:
            java.lang.String r0 = r9.getFromAddress()
            if (r0 != 0) goto L57
            com.coinbase.wallet.core.extensions.Strings r0 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r0 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r0)
        L57:
            r3 = r0
            if (r10 == 0) goto L64
            r4 = 6
            r5 = 4
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r9 = com.coinbase.wallet.common.extensions.String_CommonKt.truncateMiddle$default(r3, r4, r5, r6, r7, r8)
            return r9
        L64:
            com.coinbase.wallet.blockchains.models.TxMetadata r10 = r9.getMetadata()
            com.coinbase.wallet.blockchains.models.TxMetadataKey$Companion r0 = com.coinbase.wallet.blockchains.models.TxMetadataKey.Companion
            com.coinbase.wallet.blockchains.models.TxMetadataKey r0 = com.coinbase.wallet.bip44wallets.extensions.TxMetadataKey_BIP44WalletsKt.getInputCount(r0)
            java.lang.Object r10 = r10.get(r0)
            boolean r0 = r10 instanceof java.lang.Integer
            if (r0 == 0) goto L79
            java.lang.Integer r10 = (java.lang.Integer) r10
            goto L7a
        L79:
            r10 = 0
        L7a:
            java.lang.String r9 = r9.getFromAddress()
            if (r10 == 0) goto La1
            int r0 = r10.intValue()
            if (r0 <= r2) goto La1
            if (r9 == 0) goto La1
            com.coinbase.wallet.common.utilities.LocalizedStrings r0 = com.coinbase.wallet.common.utilities.LocalizedStrings.INSTANCE
            int r3 = com.coinbase.wallet.txhistory.R.string.nakamoto_entity_format
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r9
            int r9 = r10.intValue()
            int r9 = r9 - r2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r4[r2] = r9
            java.lang.String r9 = r0.get(r3, r4)
            return r9
        La1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.txhistory.extensions.Transaction_TxHistoryKt.entityDisplayName(com.coinbase.wallet.blockchains.models.Transaction, boolean):java.lang.String");
    }

    public static final boolean isConsumerTransfer(Transaction transaction) {
        m.g(transaction, "<this>");
        return transaction.getMetadata().get(TxMetadataKey_ConsumerConnectKt.getConsumerTxID(TxMetadataKey.Companion)) != null;
    }
}