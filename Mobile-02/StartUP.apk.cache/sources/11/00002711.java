package com.coinbase.wallet.txhistory.apis;

import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Date;
import kotlin.Metadata;

/* compiled from: TxHistoryApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"", "Ljava/util/Date;", "toDate", "(Ljava/lang/String;)Ljava/util/Date;", "pagingTokenKey", "Ljava/lang/String;", "noTxFoundError", "okStatus", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryApiKt {
    private static final String noTxFoundError = "No transactions found";
    private static final String okStatus = "1";
    private static final String pagingTokenKey = "x-paging-token";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date toDate(String str) {
        return new Date(Long.parseLong(str) * ((long) RNCWebViewManager.COMMAND_CLEAR_FORM_DATA));
    }
}