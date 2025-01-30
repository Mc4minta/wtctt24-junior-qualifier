package com.coinbase.walletengine.services.stellar;

import android.util.Base64;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.m0;
import kotlin.u;

/* compiled from: StellarService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/coinbase/walletengine/services/stellar/SignedTransaction;", "", "", "kotlin.jvm.PlatformType", "asJSONMap", "(Lcom/coinbase/walletengine/services/stellar/SignedTransaction;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/stellar/TransactionResult;", "", "(Lcom/coinbase/walletengine/services/stellar/TransactionResult;)Ljava/util/Map;", "wallet-engine_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarServiceKt {
    private static final Map<String, String> asJSONMap(SignedTransaction signedTransaction) {
        Map<String, String> l2;
        l2 = m0.l(u.a("hash", signedTransaction.getHash()), u.a("data", Base64.encodeToString(signedTransaction.getData(), 2)));
        return l2;
    }

    private static final Map<String, Comparable<?>> asJSONMap(TransactionResult transactionResult) {
        Map<String, Comparable<?>> l2;
        l2 = m0.l(u.a("successful", Boolean.valueOf(transactionResult.getSuccessful())), u.a("ledgerSequence", UInt.h(transactionResult.m2087getLedgerSequencepVg5ArA())), u.a("feePaid", transactionResult.getFeePaid().toString()));
        return l2;
    }
}