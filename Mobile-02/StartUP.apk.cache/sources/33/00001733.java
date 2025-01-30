package com.coinbase.wallet.consumer.utils;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NoopBugsnag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/utils/NoopBugsnag;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactNativApplicationContext", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NoopBugsnag extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: NoopBugsnag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/utils/NoopBugsnag$Companion;", "", "Lcom/coinbase/wallet/consumer/utils/NoopBugsnagPackage;", "getPackage", "()Lcom/coinbase/wallet/consumer/utils/NoopBugsnagPackage;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NoopBugsnagPackage getPackage() {
            return new NoopBugsnagPackage();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoopBugsnag(ReactApplicationContext reactNativApplicationContext) {
        super(reactNativApplicationContext);
        m.g(reactNativApplicationContext, "reactNativApplicationContext");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "BugsnagReactNative";
    }
}