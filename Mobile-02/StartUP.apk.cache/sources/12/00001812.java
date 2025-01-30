package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.util.AttributeSet;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ConsumerAuthenticatedWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001bB!\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u0017\u0010\u001eB)\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b\u0017\u0010 J-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerAuthenticatedWebView;", "Lcom/coinbase/wallet/consumer/views/ConsumerWebView;", "", "url", "", "additionalHttpHeaders", "Lkotlin/x;", "loadUrlWithAuthHeaders", "(Ljava/lang/String;Ljava/util/Map;)V", "loadUrl", "(Ljava/lang/String;)V", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "setStore", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "getToken", "()Ljava/lang/String;", ApiConstants.TOKEN, "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAuthenticatedWebView extends ConsumerWebView {
    public StoreInterface store;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAuthenticatedWebView(Context ctx) {
        super(ctx);
        kotlin.jvm.internal.m.g(ctx, "ctx");
    }

    private final String getToken() {
        String str = (String) getStore().get(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(StoreKeys.INSTANCE));
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("no token");
    }

    private final void loadUrlWithAuthHeaders(String str, Map<String, String> map) {
        if (getConsumerWebViewClient().validUrl(str)) {
            super.loadUrl(str, ConsumerAuthenticateWebViewClient.Companion.appendAuthHeaders(map, getToken()));
        }
    }

    @Override // com.coinbase.wallet.consumer.views.ConsumerWebView
    public void _$_clearFindViewByIdCache() {
    }

    public final StoreInterface getStore() {
        StoreInterface storeInterface = this.store;
        if (storeInterface != null) {
            return storeInterface;
        }
        kotlin.jvm.internal.m.w(Payload.TYPE_STORE);
        throw null;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        loadUrlWithAuthHeaders(url, null);
    }

    public final void setStore(StoreInterface storeInterface) {
        kotlin.jvm.internal.m.g(storeInterface, "<set-?>");
        this.store = storeInterface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAuthenticatedWebView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        kotlin.jvm.internal.m.g(attrs, "attrs");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        kotlin.jvm.internal.m.g(url, "url");
        kotlin.jvm.internal.m.g(additionalHttpHeaders, "additionalHttpHeaders");
        loadUrlWithAuthHeaders(url, additionalHttpHeaders);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAuthenticatedWebView(Context ctx, AttributeSet attrs, int i2) {
        super(ctx, attrs, i2);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        kotlin.jvm.internal.m.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAuthenticatedWebView(Context ctx, AttributeSet attrs, int i2, int i3) {
        super(ctx, attrs, i2, i3);
        kotlin.jvm.internal.m.g(ctx, "ctx");
        kotlin.jvm.internal.m.g(attrs, "attrs");
    }
}