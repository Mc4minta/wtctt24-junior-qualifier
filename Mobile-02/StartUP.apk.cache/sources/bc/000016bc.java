package com.coinbase.wallet.consumer.networking.interceptor;

import kotlin.Metadata;
import okhttp3.Request;

/* compiled from: DeviceInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a#\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lokhttp3/Request$Builder;", "", "header", "value", "replaceHeader", "(Lokhttp3/Request$Builder;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DeviceInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Request.Builder replaceHeader(Request.Builder builder, String str, String str2) {
        return builder.removeHeader(str).addHeader(str, str2);
    }
}