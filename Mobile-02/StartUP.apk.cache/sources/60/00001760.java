package com.coinbase.wallet.consumer.viewmodels;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.consumer.BuildConfig;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.models.AppToAppConfig;
import com.coinbase.wallet.consumer.models.AppToAppInitiatorStatus;
import com.coinbase.wallet.consumer.models.AppToAppResult;
import com.coinbase.wallet.consumer.models.Fallback;
import com.coinbase.wallet.consumer.models.Success;
import com.coinbase.wallet.consumer.repositories.AppToAppAuthRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* compiled from: ConsumerAppToAppViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005J/\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/coinbase/wallet/consumer/viewmodels/ConsumerAppToAppViewModel;", "Landroidx/lifecycle/b0;", "Lh/c/b0;", "", "shouldUseAppToApp", "()Lh/c/b0;", "Lcom/coinbase/wallet/consumer/models/AppToAppInitiatorStatus;", "tryInitiateAppToApp", "", "status", "", "code", "error", "Lcom/coinbase/wallet/consumer/models/AppToAppResult;", "handleActivityResultStatus", "(ILjava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Landroid/content/pm/PackageManager;", "packageManager", "Landroid/content/pm/PackageManager;", "Landroid/content/Intent;", "getAppToAppIntent", "()Landroid/content/Intent;", "appToAppIntent", "Lcom/coinbase/wallet/consumer/repositories/AppToAppAuthRepository;", "appToAppAuthRepository", "Lcom/coinbase/wallet/consumer/repositories/AppToAppAuthRepository;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "<init>", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Lcom/coinbase/wallet/consumer/repositories/AppToAppAuthRepository;Landroid/content/pm/PackageManager;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAppToAppViewModel extends androidx.lifecycle.b0 {
    private final AppToAppAuthRepository appToAppAuthRepository;
    private final ConsumerUserRepository consumerUserRepository;
    private final PackageManager packageManager;

    public ConsumerAppToAppViewModel(ConsumerUserRepository consumerUserRepository, AppToAppAuthRepository appToAppAuthRepository, PackageManager packageManager) {
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(appToAppAuthRepository, "appToAppAuthRepository");
        kotlin.jvm.internal.m.g(packageManager, "packageManager");
        this.consumerUserRepository = consumerUserRepository;
        this.appToAppAuthRepository = appToAppAuthRepository;
        this.packageManager = packageManager;
    }

    public static /* synthetic */ AppToAppResult a(kotlin.x xVar) {
        return m980handleActivityResultStatus$lambda6$lambda5(xVar);
    }

    public static /* synthetic */ Boolean b(ConsumerAppToAppViewModel consumerAppToAppViewModel, String str) {
        return m981shouldUseAppToApp$lambda1(consumerAppToAppViewModel, str);
    }

    public static /* synthetic */ AppToAppInitiatorStatus c(ConsumerAppToAppViewModel consumerAppToAppViewModel, Boolean bool) {
        return m982tryInitiateAppToApp$lambda4(consumerAppToAppViewModel, bool);
    }

    private final Intent getAppToAppIntent() {
        String M;
        Intent intent = new Intent();
        intent.setComponent(AppToAppConfig.INSTANCE.getAppToAppComponent());
        Uri parse = Uri.parse("https://www.coinbase.com/apptoapp");
        kotlin.jvm.internal.m.f(parse, "Uri.parse(this)");
        Uri.Builder appendQueryParameter = parse.buildUpon().appendQueryParameter(ApiConstants.CLIENT_ID, BuildConfig.CLIENT_ID);
        M = kotlin.a0.n.M(this.consumerUserRepository.getWalletScopes(), ",", null, null, 0, null, null, 62, null);
        intent.setData(appendQueryParameter.appendQueryParameter("scope", M).build());
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        Intent addCategory = intent.addCategory("android.intent.category.BROWSABLE");
        kotlin.jvm.internal.m.f(addCategory, "Intent()\n            .apply { component = AppToAppConfig.appToAppComponent }\n            .run {\n                val uri = \"https://www.coinbase.com/apptoapp\".toUri()\n                    .buildUpon()\n                    .appendQueryParameter(\"client_id\", BuildConfig.CLIENT_ID)\n                    .appendQueryParameter(\"scope\", consumerUserRepository.walletScopes.joinToString(separator = \",\"))\n                    .build()\n\n                data = uri\n                action = Intent.ACTION_VIEW\n                addCategory(Intent.CATEGORY_DEFAULT)\n                addCategory(Intent.CATEGORY_BROWSABLE)\n            }");
        return addCategory;
    }

    /* renamed from: handleActivityResultStatus$lambda-6$lambda-5 */
    public static final AppToAppResult m980handleActivityResultStatus$lambda6$lambda5(kotlin.x it) {
        kotlin.jvm.internal.m.g(it, "it");
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerConnectSuccess(AnalyticsEvent.Companion, "app_to_app"));
        return AppToAppResult.SUCCESS;
    }

    private final h.c.b0<Boolean> shouldUseAppToApp() {
        ComponentName component = getAppToAppIntent().getComponent();
        final String packageName = component == null ? null : component.getPackageName();
        if (packageName == null) {
            h.c.b0<Boolean> just = h.c.b0.just(Boolean.FALSE);
            kotlin.jvm.internal.m.f(just, "just(false)");
            return just;
        }
        h.c.b0<Boolean> subscribeOn = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.viewmodels.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerAppToAppViewModel.b(ConsumerAppToAppViewModel.this, packageName);
            }
        }).subscribeOn(h.c.u0.a.c());
        kotlin.jvm.internal.m.f(subscribeOn, "fromCallable {\n                val retailAppIsValid = appToAppAuthRepository.isInstalled(targetPackage) &&\n                    appToAppAuthRepository.checkTargetPackageSigner(targetPackage) &&\n                    appToAppIntent.run { resolveActivityInfo(packageManager, flags)?.exported ?: false }\n\n                val metadata = packageManager.getApplicationInfo(targetPackage, PackageManager.GET_META_DATA).metaData\n                val appToAppEnabled = metadata.getString(\"com.coinbase.android.apptoapp\") == \"enabled\"\n\n                return@fromCallable retailAppIsValid && appToAppEnabled\n            }\n            .subscribeOn(Schedulers.io())");
        return subscribeOn;
    }

    /* renamed from: shouldUseAppToApp$lambda-1 */
    public static final Boolean m981shouldUseAppToApp$lambda1(ConsumerAppToAppViewModel this$0, String targetPackage) {
        boolean z;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(targetPackage, "$targetPackage");
        boolean z2 = true;
        if (this$0.appToAppAuthRepository.isInstalled(targetPackage) && this$0.appToAppAuthRepository.checkTargetPackageSigner(targetPackage)) {
            Intent appToAppIntent = this$0.getAppToAppIntent();
            ActivityInfo resolveActivityInfo = appToAppIntent.resolveActivityInfo(this$0.packageManager, appToAppIntent.getFlags());
            if (resolveActivityInfo == null ? false : resolveActivityInfo.exported) {
                z = true;
                boolean c2 = kotlin.jvm.internal.m.c(this$0.packageManager.getApplicationInfo(targetPackage, 128).metaData.getString("com.coinbase.android.apptoapp"), "enabled");
                if (z || !c2) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        }
        z = false;
        boolean c22 = kotlin.jvm.internal.m.c(this$0.packageManager.getApplicationInfo(targetPackage, 128).metaData.getString("com.coinbase.android.apptoapp"), "enabled");
        if (z) {
        }
        z2 = false;
        return Boolean.valueOf(z2);
    }

    /* renamed from: tryInitiateAppToApp$lambda-4 */
    public static final AppToAppInitiatorStatus m982tryInitiateAppToApp$lambda4(ConsumerAppToAppViewModel this$0, Boolean it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue() ? new Success(this$0.getAppToAppIntent()) : Fallback.INSTANCE;
    }

    public final h.c.b0<AppToAppResult> handleActivityResultStatus(int i2, String str, String str2) {
        kotlin.x xVar = null;
        if (i2 == AppToAppResult.SUCCESS.getValue()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerApptoAppSuccess(AnalyticsEvent.Companion));
            h.c.b0<AppToAppResult> map = str != null ? this.consumerUserRepository.getAccessToken(BuildConfig.REDIRECT_URI, str).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.d0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAppToAppViewModel.a((kotlin.x) obj);
                }
            }) : null;
            if (map == null) {
                h.c.b0<AppToAppResult> error = h.c.b0.error(new IllegalStateException("No code specified in success"));
                kotlin.jvm.internal.m.f(error, "error(IllegalStateException(\"No code specified in success\"))");
                return error;
            }
            return map;
        }
        AppToAppResult appToAppResult = AppToAppResult.ERROR;
        if (i2 == appToAppResult.getValue()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerApptoAppError(AnalyticsEvent.Companion));
            if (str2 != null) {
                l.a.a.d(str2, "Error in app to app");
                xVar = kotlin.x.a;
            }
            if (xVar == null) {
                l.a.a.d("Unknown error in app to app", new Object[0]);
            }
            h.c.b0<AppToAppResult> just = h.c.b0.just(appToAppResult);
            kotlin.jvm.internal.m.f(just, "{\n                Analytics.log(AnalyticsEvent.consumerApptoAppError())\n                error?.let {\n                    Timber.e(it, \"Error in app to app\")\n                } ?: Timber.e(\"Unknown error in app to app\")\n                Single.just(AppToAppResult.ERROR)\n            }");
            return just;
        }
        AppToAppResult appToAppResult2 = AppToAppResult.DISABLED;
        if (i2 == appToAppResult2.getValue()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerApptoAppDisabled(AnalyticsEvent.Companion));
            h.c.b0<AppToAppResult> just2 = h.c.b0.just(appToAppResult2);
            kotlin.jvm.internal.m.f(just2, "{\n                Analytics.log(AnalyticsEvent.consumerApptoAppDisabled())\n                Single.just(AppToAppResult.DISABLED)\n            }");
            return just2;
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerApptoAppUserCanceled(AnalyticsEvent.Companion));
        h.c.b0<AppToAppResult> just3 = h.c.b0.just(AppToAppResult.USER_CANCELLED);
        kotlin.jvm.internal.m.f(just3, "{\n                Analytics.log(AnalyticsEvent.consumerApptoAppUserCanceled())\n                Single.just(AppToAppResult.USER_CANCELLED)\n            }");
        return just3;
    }

    public final h.c.b0<AppToAppInitiatorStatus> tryInitiateAppToApp() {
        h.c.b0 map = shouldUseAppToApp().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.viewmodels.f0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAppToAppViewModel.c(ConsumerAppToAppViewModel.this, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "shouldUseAppToApp()\n            .map { if (it) Success(appToAppIntent) else Fallback }");
        return map;
    }
}