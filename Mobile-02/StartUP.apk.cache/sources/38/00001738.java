package com.coinbase.wallet.consumer.utils;

import android.widget.Toast;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.EventFeature_ConsumerKt;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;
import l.a.a;

/* compiled from: UMOEventHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/consumer/utils/UMOEventHandler;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "", "getName", "()Ljava/lang/String;", "status", "Lcom/facebook/react/bridge/ReadableMap;", "info", "Lkotlin/x;", "completed", "(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)V", "accessToken", "refreshToken", "", "expiresIn", "authTokenRefresh", "(Ljava/lang/String;Ljava/lang/String;I)V", "eventName", "properties", "sendAnalyticsEvent", "Ljava/lang/Runnable;", "onSignOut", "Ljava/lang/Runnable;", "Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;", "refreshTokenCallback", "Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;", "onSuccess", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/Runnable;Ljava/lang/Runnable;Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;)V", "RefreshTokenCallback", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UMOEventHandler extends ReactContextBaseJavaModule {
    private final Runnable onSignOut;
    private final Runnable onSuccess;
    private final RefreshTokenCallback refreshTokenCallback;

    /* compiled from: UMOEventHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/utils/UMOEventHandler$RefreshTokenCallback;", "", "", "accessToken", "refreshToken", "", "expiresIn", "Lkotlin/x;", "run", "(Ljava/lang/String;Ljava/lang/String;I)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface RefreshTokenCallback {
        void run(String str, String str2, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMOEventHandler(ReactApplicationContext reactContext, Runnable onSuccess, Runnable onSignOut, RefreshTokenCallback refreshTokenCallback) {
        super(reactContext);
        m.g(reactContext, "reactContext");
        m.g(onSuccess, "onSuccess");
        m.g(onSignOut, "onSignOut");
        m.g(refreshTokenCallback, "refreshTokenCallback");
        this.onSuccess = onSuccess;
        this.onSignOut = onSignOut;
        this.refreshTokenCallback = refreshTokenCallback;
    }

    @ReactMethod
    public final void authTokenRefresh(String accessToken, String refreshToken, int i2) {
        m.g(accessToken, "accessToken");
        m.g(refreshToken, "refreshToken");
        this.refreshTokenCallback.run(accessToken, refreshToken, i2);
    }

    @ReactMethod
    public final void completed(String status, ReadableMap info) {
        m.g(status, "status");
        m.g(info, "info");
        int hashCode = status.hashCode();
        if (hashCode == -1867169789) {
            if (status.equals("success")) {
                this.onSuccess.run();
            }
        } else if (hashCode == -1367724422) {
            if (status.equals("cancel")) {
                this.onSignOut.run();
            }
        } else if (hashCode == 96784904 && status.equals("error")) {
            if (getCurrentActivity() != null) {
                Toast.makeText(getCurrentActivity(), R.string.error_occurred_try_again, 0).show();
            }
            a.d(info.toString(), new Object[0]);
            this.onSignOut.run();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CallbackWrapper";
    }

    @ReactMethod
    public final void sendAnalyticsEvent(String eventName, ReadableMap properties) {
        Map r;
        m.g(eventName, "eventName");
        m.g(properties, "properties");
        HashMap<String, Object> hashMap = properties.toHashMap();
        m.f(hashMap, "properties\n            .toHashMap()");
        ArrayList arrayList = new ArrayList(hashMap.size());
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            m.f(key, "key");
            arrayList.add(u.a(new EventProperty(key), value.toString()));
        }
        r = m0.r(arrayList);
        Analytics.INSTANCE.log(new AnalyticsEvent(EventType.PRODUCT, eventName, EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, r));
    }
}