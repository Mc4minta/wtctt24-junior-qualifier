package com.coinbase.wallet.consumer.views;

import kotlin.Metadata;

/* compiled from: Secure3DWebViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerSecure3DWebViewNavigationDelegate;", "", "Lkotlin/x;", "pageLoaded", "()V", "", "url", "paRes", "", "urlNavigated", "(Ljava/lang/String;Ljava/lang/String;)Z", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ConsumerSecure3DWebViewNavigationDelegate {
    void pageLoaded();

    boolean urlNavigated(String str, String str2);
}