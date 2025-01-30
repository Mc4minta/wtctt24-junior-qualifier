package com.coinbase.cipherwebview.httpclient;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import okhttp3.OkHttpClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lokhttp3/OkHttpClient;", "<anonymous>", "()Lokhttp3/OkHttpClient;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HttpClient$client$2 extends o implements a<OkHttpClient> {
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClient$client$2(HttpClient httpClient) {
        super(0);
        this.this$0 = httpClient;
    }

    @Override // kotlin.e0.c.a
    public final OkHttpClient invoke() {
        OkHttpClient.Builder builder;
        WebViewCookieJar webViewCookieJar;
        builder = this.this$0.httpClientBuilder;
        webViewCookieJar = this.this$0.cookieJar;
        return builder.cookieJar(webViewCookieJar).followRedirects(false).followSslRedirects(false).build();
    }
}