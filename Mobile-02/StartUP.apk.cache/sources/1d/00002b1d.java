package com.coinbase.walletengine.services.xrp;

import android.util.Base64;
import com.coinbase.ApiConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.m0;
import kotlin.u;

/* compiled from: XRPService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \b*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00070\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\t\u001a%\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0001*\u00020\nH\u0002¢\u0006\u0004\b\u0004\u0010\u000b\u001a%\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0001*\u00020\fH\u0002¢\u0006\u0004\b\u0004\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/services/xrp/AccountInfo;", "", "", "", "asJSONMap", "(Lcom/coinbase/walletengine/services/xrp/AccountInfo;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/xrp/SignedTransaction;", "", "kotlin.jvm.PlatformType", "(Lcom/coinbase/walletengine/services/xrp/SignedTransaction;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "(Lcom/coinbase/walletengine/services/xrp/TransactionResult;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/xrp/Transaction;", "(Lcom/coinbase/walletengine/services/xrp/Transaction;)Ljava/util/Map;", "wallet-engine_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPServiceKt {
    private static final Map<String, Boolean> asJSONMap(AccountInfo accountInfo) {
        Map<String, Boolean> l2;
        l2 = m0.l(u.a("disallowsIncomingXRP", Boolean.valueOf(accountInfo.getDisallowsIncomingXRP())), u.a("requiresDestinationTag", Boolean.valueOf(accountInfo.getRequiresDestinationTag())));
        return l2;
    }

    private static final Map<String, Comparable<?>> asJSONMap(SignedTransaction signedTransaction) {
        Map<String, Comparable<?>> l2;
        l2 = m0.l(u.a("hash", signedTransaction.getHash()), u.a("data", Base64.encodeToString(signedTransaction.getData(), 2)), u.a("txJSON", signedTransaction.getTxJSON()), u.a("maxLedgerVersion", UInt.h(signedTransaction.m2097getMaxLedgerVersionpVg5ArA())));
        return l2;
    }

    private static final Map<String, Comparable<?>> asJSONMap(TransactionResult transactionResult) {
        Map<String, Comparable<?>> l2;
        l2 = m0.l(u.a("status", transactionResult.getStatus().getRawValue()), u.a("resultCode", transactionResult.getResultCode()), u.a("ledgerVersion", transactionResult.m2107getLedgerVersion0hXNFcg()), u.a("indexInLedger", transactionResult.m2106getIndexInLedger0hXNFcg()));
        return l2;
    }

    private static final Map<String, Comparable<?>> asJSONMap(Transaction transaction) {
        Map<String, Comparable<?>> l2;
        l2 = m0.l(u.a("txHash", transaction.getTxHash()), u.a("address", transaction.getAddress()), u.a("destination", transaction.getDestination()), u.a(ApiConstants.FEE, transaction.getFee().toString()), u.a("amount", transaction.getAmount().toString()), u.a("destinationTag", transaction.m2101getDestinationTag0hXNFcg()), u.a("timestamp", transaction.getTimestamp()));
        return l2;
    }
}