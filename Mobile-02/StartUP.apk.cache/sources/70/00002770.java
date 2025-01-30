package com.coinbase.wallet.txhistory.models;

import com.coinbase.wallet.blockchains.models.Transaction;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TxHistoryCellViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Transaction;", "", "isSelfTransaction", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)Z", "Ljava/text/SimpleDateFormat;", "getDateFormatter", "()Ljava/text/SimpleDateFormat;", "dateFormatter", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryCellViewStateKt {
    public static final /* synthetic */ SimpleDateFormat access$getDateFormatter() {
        return getDateFormatter();
    }

    public static final /* synthetic */ boolean access$isSelfTransaction(Transaction transaction) {
        return isSelfTransaction(transaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleDateFormat getDateFormatter() {
        return new SimpleDateFormat("MMM dd", Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSelfTransaction(Transaction transaction) {
        Boolean valueOf;
        String fromAddress = transaction.getFromAddress();
        if (fromAddress == null) {
            return false;
        }
        String toAddress = transaction.getToAddress();
        if (toAddress == null) {
            valueOf = null;
        } else {
            Locale locale = Locale.US;
            m.f(locale, "locale");
            String lowerCase = fromAddress.toLowerCase(locale);
            m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String lowerCase2 = toAddress.toLowerCase(locale);
            m.f(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            valueOf = Boolean.valueOf(m.c(lowerCase, lowerCase2));
        }
        if (valueOf == null) {
            return false;
        }
        return valueOf.booleanValue();
    }
}