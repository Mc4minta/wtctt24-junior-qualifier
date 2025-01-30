package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import com.bugsnag.BugsnagReactNative;
import com.coinbase.Coinbase;
import com.coinbase.android.idfa.RNIDFAPackage;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import com.coinbase.wallet.consumer.BuildConfig;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.consumer.utils.RNLaunchMailAppPackage;
import com.coinbase.wallet.consumer.utils.UMOEventHandler;
import com.coinbase.wallet.consumer.utils.UMOPackage;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.facebook.react.common.LifecycleState;
import com.horcrux.svg.e0;
import h.c.b0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* compiled from: UMOActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b^\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0017\u001a\u00020\u00062\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001f\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u00109\u001a\b\u0012\u0004\u0012\u000208078\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Lcom/coinbase/wallet/consumer/views/UMOActivity;", "Ldagger/android/g/b;", "Lcom/facebook/react/modules/core/b;", "Lcom/facebook/react/modules/core/e;", "", "email", "Lkotlin/x;", "startActivityWithEmail", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/facebook/react/modules/core/f;", "listener", "requestPermissions", "([Ljava/lang/String;ILcom/facebook/react/modules/core/f;)V", "onSignin", "()V", "onSignOut", "invokeDefaultOnBackPressed", "onPause", "onResume", "onDestroy", "onBackPressed", "Le/f/m/l;", "reactInstanceManager", "Le/f/m/l;", "permissionListener", "Lcom/facebook/react/modules/core/f;", "Lcom/coinbase/wallet/consumer/views/CustomReactRootView;", "reactRootView", "Lcom/coinbase/wallet/consumer/views/CustomReactRootView;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "getConsumerUserRepository$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "setConsumerUserRepository$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)V", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "consumerTransferRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "getConsumerTransferRepository$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;", "setConsumerTransferRepository$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerTransferRepository;)V", "Lf/a;", "Lcom/coinbase/Coinbase;", "coinbase", "Lf/a;", "getCoinbase$consumer_productionRelease", "()Lf/a;", "setCoinbase$consumer_productionRelease", "(Lf/a;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "networkConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "getNetworkConfig$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "setNetworkConfig$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;)V", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore$consumer_productionRelease", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "setStore$consumer_productionRelease", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "consumerAccountsRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "getConsumerAccountsRepository$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;", "setConsumerAccountsRepository$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerAccountsRepository;)V", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "buildConfig", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "getBuildConfig$consumer_productionRelease", "()Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "setBuildConfig$consumer_productionRelease", "(Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;)V", "<init>", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UMOActivity extends dagger.android.g.b implements com.facebook.react.modules.core.b, com.facebook.react.modules.core.e {
    private static final String APPLICATION_CONTEXT = "wallet";
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 10000;
    public static final Companion Companion = new Companion(null);
    public BuildConfigWrapper buildConfig;
    public f.a<Coinbase> coinbase;
    public ConsumerAccountsRepository consumerAccountsRepository;
    public ConsumerTransferRepository consumerTransferRepository;
    public ConsumerUserRepository consumerUserRepository;
    private final h.c.k0.a disposeBag = new h.c.k0.a();
    public ConsumerNetworkConfig networkConfig;
    private com.facebook.react.modules.core.f permissionListener;
    private e.f.m.l reactInstanceManager;
    private CustomReactRootView reactRootView;
    public StoreInterface store;

    /* compiled from: UMOActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/views/UMOActivity$Companion;", "", "", "APPLICATION_CONTEXT", "Ljava/lang/String;", "", "CAMERA_PERMISSION_REQUEST_CODE", "I", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void a(UMOActivity uMOActivity) {
        m1053startActivityWithEmail$lambda6(uMOActivity);
    }

    public static /* synthetic */ void b(UMOActivity uMOActivity) {
        m1052startActivityWithEmail$lambda5(uMOActivity);
    }

    public static /* synthetic */ OkHttpClient c(OkHttpClient.Builder builder) {
        return m1051startActivityWithEmail$lambda4(builder);
    }

    public final void startActivityWithEmail(String str) {
        String K;
        String K2;
        String K3;
        List<e.f.m.p> j2;
        View inflate = View.inflate(this, R.layout.activity_umo, null);
        CustomReactRootView customReactRootView = (CustomReactRootView) inflate.findViewById(R.id.reactView);
        customReactRootView.setLoadedListener(new UMOActivity$startActivityWithEmail$1$1(this, inflate));
        kotlin.x xVar = kotlin.x.a;
        this.reactRootView = customReactRootView;
        Bundle bundle = new Bundle();
        StoreInterface store$consumer_productionRelease = getStore$consumer_productionRelease();
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        String str2 = (String) store$consumer_productionRelease.get(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys));
        String str3 = (String) getStore$consumer_productionRelease().get(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys));
        final boolean z = str2 == null;
        if (str2 != null && str3 != null) {
            bundle.putString("email", str);
            bundle.putString("accessToken", str2);
            bundle.putLong("expiresIn", 7200000L);
            bundle.putString("refreshToken", str3);
        }
        bundle.putString("applicationContext", "wallet");
        K = kotlin.l0.x.K(getNetworkConfig$consumer_productionRelease().getBaseApiURL(), "/v2/", "", false, 4, null);
        K2 = kotlin.l0.x.K(getNetworkConfig$consumer_productionRelease().getBaseApiURL(), "/api/v2/", "", false, 4, null);
        K3 = kotlin.l0.x.K(K2, "/v2/", "", false, 4, null);
        bundle.putString("apiHost", K);
        bundle.putString("host", K3);
        bundle.putString("applicationClientId", getNetworkConfig$consumer_productionRelease().getClientId());
        bundle.putString("applicationClientSecret", getNetworkConfig$consumer_productionRelease().getClientSecret());
        bundle.putString("CBClient", ((Object) getApplicationContext().getPackageName()) + '/' + getBuildConfig$consumer_productionRelease().getVersionName() + '/' + getBuildConfig$consumer_productionRelease().getVersionCode());
        bundle.putString("CBVersion", getNetworkConfig$consumer_productionRelease().getApiVersion());
        bundle.putString("appsFlyerId", BuildConfig.APPSFLYER_KEY);
        OkHttpClient.Builder c2 = com.facebook.react.modules.network.g.c();
        Interceptor.Companion companion = Interceptor.Companion;
        final OkHttpClient.Builder addInterceptor = c2.addInterceptor(new Interceptor() { // from class: com.coinbase.wallet.consumer.views.UMOActivity$startActivityWithEmail$$inlined$-addInterceptor$1
            /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
                if ((r2.length() == 0) == true) goto L4;
             */
            @Override // okhttp3.Interceptor
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public okhttp3.Response intercept(okhttp3.Interceptor.Chain r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "chain"
                    kotlin.jvm.internal.m.h(r6, r0)
                    okhttp3.Request r0 = r6.request()
                    java.lang.String r1 = "user-agent"
                    java.lang.String r2 = r0.header(r1)
                    r3 = 1
                    r4 = 0
                    if (r2 != 0) goto L15
                L13:
                    r3 = r4
                    goto L20
                L15:
                    int r2 = r2.length()
                    if (r2 != 0) goto L1d
                    r2 = r3
                    goto L1e
                L1d:
                    r2 = r4
                L1e:
                    if (r2 != r3) goto L13
                L20:
                    if (r3 == 0) goto L2e
                    okhttp3.Request$Builder r0 = r0.newBuilder()
                    okhttp3.Request$Builder r0 = r0.removeHeader(r1)
                    okhttp3.Request r0 = r0.build()
                L2e:
                    okhttp3.Response r6 = r6.proceed(r0)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.views.UMOActivity$startActivityWithEmail$$inlined$addInterceptor$1.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
            }
        });
        com.facebook.react.modules.network.g.g(new com.facebook.react.modules.network.f() { // from class: com.coinbase.wallet.consumer.views.x
            @Override // com.facebook.react.modules.network.f
            public final OkHttpClient a() {
                return UMOActivity.c(OkHttpClient.Builder.this);
            }
        });
        e.f.m.m h2 = e.f.m.l.m().d(getApplication()).f(this).e("umo.jsbundle").h("index");
        j2 = kotlin.a0.r.j(new e.f.m.y.b(), new com.reactnativecommunity.webview.a(), new com.facebook.react.modules.email.a(), new org.reactnative.camera.c(), BugsnagReactNative.getPackage(), new com.learnium.RNDeviceInfo.b(), new RNIDFAPackage(), new com.swmansion.reanimated.c(), new com.airbnb.android.react.lottie.b(), new com.reactnativecommunity.clipboard.a(), new com.thebylito.navigationbarcolor.a(), new e.e.a.a(), new com.reactnativerestart.b(), new com.swmansion.gesturehandler.react.e(), new com.reactcommunity.rndatetimepicker.e(), new com.reactnativecommunity.netinfo.d(), new com.zoontek.rnlocalize.a(), new com.th3rdwave.safeareacontext.d(), new e0(), new com.swmansion.rnscreens.a(), new RNLaunchMailAppPackage(), new com.BV.LinearGradient.a(), new UMOPackage(new Runnable() { // from class: com.coinbase.wallet.consumer.views.w
            @Override // java.lang.Runnable
            public final void run() {
                UMOActivity.b(UMOActivity.this);
            }
        }, new Runnable() { // from class: com.coinbase.wallet.consumer.views.v
            @Override // java.lang.Runnable
            public final void run() {
                UMOActivity.a(UMOActivity.this);
            }
        }, new UMOEventHandler.RefreshTokenCallback() { // from class: com.coinbase.wallet.consumer.views.UMOActivity$startActivityWithEmail$5
            @Override // com.coinbase.wallet.consumer.utils.UMOEventHandler.RefreshTokenCallback
            public void run(String accessToken, String refreshToken, int i2) {
                List<? extends Refreshable> b2;
                h.c.k0.a aVar;
                kotlin.jvm.internal.m.g(accessToken, "accessToken");
                kotlin.jvm.internal.m.g(refreshToken, "refreshToken");
                if (z) {
                    Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerConnectSuccess(AnalyticsEvent.Companion, "create_user"));
                }
                StoreInterface store$consumer_productionRelease2 = this.getStore$consumer_productionRelease();
                StoreKeys storeKeys2 = StoreKeys.INSTANCE;
                store$consumer_productionRelease2.set(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys2), accessToken);
                this.getStore$consumer_productionRelease().set(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys2), refreshToken);
                Coinbase coinbase = this.getCoinbase$consumer_productionRelease().get();
                coinbase.setRefreshToken(refreshToken);
                coinbase.setAccessToken(accessToken);
                ConsumerTransferRepository consumerTransferRepository$consumer_productionRelease = this.getConsumerTransferRepository$consumer_productionRelease();
                b2 = kotlin.a0.q.b(this.getConsumerUserRepository$consumer_productionRelease());
                h.c.k0.b i3 = h.c.t0.g.i(consumerTransferRepository$consumer_productionRelease.refreshBlocking(b2), null, null, 3, null);
                aVar = this.disposeBag;
                h.c.t0.a.a(i3, aVar);
            }
        }));
        e.f.m.l b2 = h2.a(j2).i(getBuildConfig$consumer_productionRelease().isDebug()).g(LifecycleState.RESUMED).b();
        this.reactInstanceManager = b2;
        CustomReactRootView customReactRootView2 = this.reactRootView;
        if (customReactRootView2 != null) {
            customReactRootView2.startReactApplication(b2, "OnboardingMobile", bundle);
        }
        setContentView(inflate);
    }

    /* renamed from: startActivityWithEmail$lambda-4 */
    public static final OkHttpClient m1051startActivityWithEmail$lambda4(OkHttpClient.Builder okHttpClient) {
        kotlin.jvm.internal.m.g(okHttpClient, "$okHttpClient");
        return okHttpClient.build();
    }

    /* renamed from: startActivityWithEmail$lambda-5 */
    public static final void m1052startActivityWithEmail$lambda5(UMOActivity this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.onSignin();
    }

    /* renamed from: startActivityWithEmail$lambda-6 */
    public static final void m1053startActivityWithEmail$lambda6(UMOActivity this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.onSignOut();
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final BuildConfigWrapper getBuildConfig$consumer_productionRelease() {
        BuildConfigWrapper buildConfigWrapper = this.buildConfig;
        if (buildConfigWrapper != null) {
            return buildConfigWrapper;
        }
        kotlin.jvm.internal.m.w("buildConfig");
        throw null;
    }

    public final f.a<Coinbase> getCoinbase$consumer_productionRelease() {
        f.a<Coinbase> aVar = this.coinbase;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.m.w("coinbase");
        throw null;
    }

    public final ConsumerAccountsRepository getConsumerAccountsRepository$consumer_productionRelease() {
        ConsumerAccountsRepository consumerAccountsRepository = this.consumerAccountsRepository;
        if (consumerAccountsRepository != null) {
            return consumerAccountsRepository;
        }
        kotlin.jvm.internal.m.w("consumerAccountsRepository");
        throw null;
    }

    public final ConsumerTransferRepository getConsumerTransferRepository$consumer_productionRelease() {
        ConsumerTransferRepository consumerTransferRepository = this.consumerTransferRepository;
        if (consumerTransferRepository != null) {
            return consumerTransferRepository;
        }
        kotlin.jvm.internal.m.w("consumerTransferRepository");
        throw null;
    }

    public final ConsumerUserRepository getConsumerUserRepository$consumer_productionRelease() {
        ConsumerUserRepository consumerUserRepository = this.consumerUserRepository;
        if (consumerUserRepository != null) {
            return consumerUserRepository;
        }
        kotlin.jvm.internal.m.w("consumerUserRepository");
        throw null;
    }

    public final ConsumerNetworkConfig getNetworkConfig$consumer_productionRelease() {
        ConsumerNetworkConfig consumerNetworkConfig = this.networkConfig;
        if (consumerNetworkConfig != null) {
            return consumerNetworkConfig;
        }
        kotlin.jvm.internal.m.w("networkConfig");
        throw null;
    }

    public final StoreInterface getStore$consumer_productionRelease() {
        StoreInterface storeInterface = this.store;
        if (storeInterface != null) {
            return storeInterface;
        }
        kotlin.jvm.internal.m.w(Payload.TYPE_STORE);
        throw null;
    }

    @Override // com.facebook.react.modules.core.b
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        e.f.m.l lVar = this.reactInstanceManager;
        if (lVar == null) {
            super.onBackPressed();
        } else if (lVar == null) {
        } else {
            lVar.E();
        }
    }

    @Override // dagger.android.g.b, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.facebook.react.views.text.i c2 = com.facebook.react.views.text.i.c();
        c2.a(this, "Graphik-Regular", R.font.graphik_regular);
        c2.a(this, "Graphik-Medium", R.font.graphik_medium);
        c2.a(this, "CoinbaseIcons", R.font.coinbase_icons);
        b0 observeOn = Observable_CoreKt.takeSingle(getConsumerUserRepository$consumer_productionRelease().getUserObservable()).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "consumerUserRepository.userObservable\n            .takeSingle()\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.i(observeOn, null, new UMOActivity$onCreate$2(this), 1, null), this.disposeBag);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.disposeBag.d();
        e.f.m.l lVar = this.reactInstanceManager;
        if (lVar != null) {
            lVar.G(this);
        }
        CustomReactRootView customReactRootView = this.reactRootView;
        if (customReactRootView == null) {
            return;
        }
        customReactRootView.unmountReactApplication();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onPause() {
        super.onPause();
        e.f.m.l lVar = this.reactInstanceManager;
        if (lVar == null) {
            return;
        }
        lVar.I(this);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        int[] H0;
        kotlin.jvm.internal.m.g(permissions, "permissions");
        kotlin.jvm.internal.m.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        com.facebook.react.modules.core.f fVar = this.permissionListener;
        if (fVar == null) {
            return;
        }
        int i3 = i2 - 10000;
        ArrayList arrayList = new ArrayList(permissions.length);
        for (String str : permissions) {
            arrayList.add(0);
        }
        H0 = z.H0(arrayList);
        fVar.onRequestPermissionsResult(i3, permissions, H0);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onResume() {
        super.onResume();
        e.f.m.l lVar = this.reactInstanceManager;
        if (lVar == null) {
            return;
        }
        lVar.K(this, this);
    }

    public final void onSignOut() {
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.m.f(applicationContext, "applicationContext");
        Context_CommonKt.setComponentEnabledSetting(applicationContext, false, UMOActivity.class);
        setResult(0);
        finish();
    }

    public final void onSignin() {
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.m.f(applicationContext, "applicationContext");
        Context_CommonKt.setComponentEnabledSetting(applicationContext, false, UMOActivity.class);
        setResult(-1);
        finish();
    }

    @Override // com.facebook.react.modules.core.e
    public void requestPermissions(String[] strArr, int i2, com.facebook.react.modules.core.f fVar) {
        if (androidx.core.content.a.a(this, "android.permission.CAMERA") != 0) {
            this.permissionListener = fVar;
            requestPermissions(new String[]{"android.permission.CAMERA"}, i2 + CAMERA_PERMISSION_REQUEST_CODE);
        }
    }

    public final void setBuildConfig$consumer_productionRelease(BuildConfigWrapper buildConfigWrapper) {
        kotlin.jvm.internal.m.g(buildConfigWrapper, "<set-?>");
        this.buildConfig = buildConfigWrapper;
    }

    public final void setCoinbase$consumer_productionRelease(f.a<Coinbase> aVar) {
        kotlin.jvm.internal.m.g(aVar, "<set-?>");
        this.coinbase = aVar;
    }

    public final void setConsumerAccountsRepository$consumer_productionRelease(ConsumerAccountsRepository consumerAccountsRepository) {
        kotlin.jvm.internal.m.g(consumerAccountsRepository, "<set-?>");
        this.consumerAccountsRepository = consumerAccountsRepository;
    }

    public final void setConsumerTransferRepository$consumer_productionRelease(ConsumerTransferRepository consumerTransferRepository) {
        kotlin.jvm.internal.m.g(consumerTransferRepository, "<set-?>");
        this.consumerTransferRepository = consumerTransferRepository;
    }

    public final void setConsumerUserRepository$consumer_productionRelease(ConsumerUserRepository consumerUserRepository) {
        kotlin.jvm.internal.m.g(consumerUserRepository, "<set-?>");
        this.consumerUserRepository = consumerUserRepository;
    }

    public final void setNetworkConfig$consumer_productionRelease(ConsumerNetworkConfig consumerNetworkConfig) {
        kotlin.jvm.internal.m.g(consumerNetworkConfig, "<set-?>");
        this.networkConfig = consumerNetworkConfig;
    }

    public final void setStore$consumer_productionRelease(StoreInterface storeInterface) {
        kotlin.jvm.internal.m.g(storeInterface, "<set-?>");
        this.store = storeInterface;
    }
}