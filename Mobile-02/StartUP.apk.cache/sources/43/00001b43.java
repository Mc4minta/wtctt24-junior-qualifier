package com.coinbase.wallet.di;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.model.CallToAction;
import com.coinbase.wallet.application.model.DismissDestination;
import com.coinbase.wallet.application.model.MainTab;
import com.coinbase.wallet.application.model.NavDestination;
import com.coinbase.wallet.application.model.NoDestination;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.NavController_CommonKt;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.di.NotificationsModule;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.cloudbackup.extensions.StoreKeys_CloudBackupKt;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import com.coinbase.wallet.features.swap.models.SwapInterstitialFragmentArgs;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import e.g.a.e.f.d;
import e.j.i.a2;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.m0.n;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: NotificationsModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/di/NotificationsModule;", "", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class NotificationsModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: NotificationsModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0017\u0010\u0015J\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/di/NotificationsModule$Companion;", "", "Lcom/coinbase/wallet/application/BaseApplication;", "appContext", "Lcom/coinbase/wallet/application/model/Notification;", "providesSecurityProviderPrompt$app_productionRelease", "(Lcom/coinbase/wallet/application/BaseApplication;)Lcom/coinbase/wallet/application/model/Notification;", "providesSecurityProviderPrompt", "providesVerifyAppsPrompt$app_productionRelease", "providesVerifyAppsPrompt", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Le/j/j/b;", "prefs", "providesSwapTOSNotification$app_productionRelease", "(Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Le/j/j/b;)Lcom/coinbase/wallet/application/model/Notification;", "providesSwapTOSNotification", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "appPrefs", "providesConsumerNotification$app_productionRelease", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;Le/j/j/b;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;)Lcom/coinbase/wallet/application/model/Notification;", "providesConsumerNotification", "providesConsumerOnrampNotification$app_productionRelease", "providesConsumerOnrampNotification", "Le/j/i/a2;", "mnemonicBackupRepository", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "providesNewUserCloudBackupPrompt$app_productionRelease", "(Le/j/i/a2;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/application/model/Notification;", "providesNewUserCloudBackupPrompt", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Boolean a(StoreInterface storeInterface, a2 a2Var) {
            return m1076providesNewUserCloudBackupPrompt$lambda6(storeInterface, a2Var);
        }

        public static /* synthetic */ Boolean b(BaseApplication baseApplication, AtomicInteger atomicInteger) {
            return m1077providesSecurityProviderPrompt$lambda0(baseApplication, atomicInteger);
        }

        public static /* synthetic */ void c(d0 d0Var, com.google.android.gms.tasks.g gVar) {
            m1080providesVerifyAppsPrompt$lambda2$lambda1(d0Var, gVar);
        }

        public static /* synthetic */ void d(BaseApplication baseApplication, d0 d0Var) {
            m1079providesVerifyAppsPrompt$lambda2(baseApplication, d0Var);
        }

        public static /* synthetic */ Boolean e(ConsumerUserRepository consumerUserRepository, e.j.j.b bVar, ConsumerConnectionStatus consumerConnectionStatus) {
            return m1074providesConsumerNotification$lambda4(consumerUserRepository, bVar, consumerConnectionStatus);
        }

        public static /* synthetic */ Boolean f(e.j.j.b bVar, Boolean bool) {
            return m1078providesSwapTOSNotification$lambda3(bVar, bool);
        }

        public static /* synthetic */ Boolean g(ConsumerUserRepository consumerUserRepository, e.j.j.b bVar, ConsumerConnectionStatus consumerConnectionStatus) {
            return m1075providesConsumerOnrampNotification$lambda5(consumerUserRepository, bVar, consumerConnectionStatus);
        }

        /* renamed from: providesConsumerNotification$lambda-4 */
        public static final Boolean m1074providesConsumerNotification$lambda4(ConsumerUserRepository consumerUserRepository, e.j.j.b appPrefs, ConsumerConnectionStatus status) {
            m.g(consumerUserRepository, "$consumerUserRepository");
            m.g(appPrefs, "$appPrefs");
            m.g(status, "status");
            return Boolean.valueOf((consumerUserRepository.isAuthenticated() || appPrefs.j(Notification.Id.ANNOUNCEMENT_CONSUMER_CONNECT) || status.getOnrampEnabled()) ? false : true);
        }

        /* renamed from: providesConsumerOnrampNotification$lambda-5 */
        public static final Boolean m1075providesConsumerOnrampNotification$lambda5(ConsumerUserRepository consumerUserRepository, e.j.j.b appPrefs, ConsumerConnectionStatus status) {
            m.g(consumerUserRepository, "$consumerUserRepository");
            m.g(appPrefs, "$appPrefs");
            m.g(status, "status");
            return Boolean.valueOf((consumerUserRepository.isAuthenticated() || appPrefs.j(Notification.Id.ANNOUNCEMENT_CONSUMER_CONNECT_ONRAMP) || !status.getOnrampEnabled()) ? false : true);
        }

        /* renamed from: providesNewUserCloudBackupPrompt$lambda-6 */
        public static final Boolean m1076providesNewUserCloudBackupPrompt$lambda6(StoreInterface store, a2 mnemonicBackupRepository) {
            m.g(store, "$store");
            m.g(mnemonicBackupRepository, "$mnemonicBackupRepository");
            StoreKeys storeKeys = StoreKeys.INSTANCE;
            Boolean bool = (Boolean) store.get(StoreKeys_CloudBackupKt.getHasSeenFirstBackupPrompt(storeKeys));
            boolean z = false;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (!mnemonicBackupRepository.d() && !booleanValue) {
                z = true;
            }
            store.set(StoreKeys_CloudBackupKt.getHasSeenFirstBackupPrompt(storeKeys), Boolean.TRUE);
            return Boolean.valueOf(z);
        }

        /* renamed from: providesSecurityProviderPrompt$lambda-0 */
        public static final Boolean m1077providesSecurityProviderPrompt$lambda0(BaseApplication appContext, AtomicInteger connectionStatusCode) {
            m.g(appContext, "$appContext");
            m.g(connectionStatusCode, "$connectionStatusCode");
            try {
                e.g.a.e.g.a.a(appContext);
                return Boolean.FALSE;
            } catch (GooglePlayServicesNotAvailableException unused) {
                Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.updateSecurityProviderNotPossible(AnalyticsEvent.Companion));
                return Boolean.FALSE;
            } catch (GooglePlayServicesRepairableException e2) {
                connectionStatusCode.set(e2.b());
                return Boolean.TRUE;
            }
        }

        /* renamed from: providesSwapTOSNotification$lambda-3 */
        public static final Boolean m1078providesSwapTOSNotification$lambda3(e.j.j.b prefs, Boolean isSwapEnabled) {
            m.g(prefs, "$prefs");
            m.g(isSwapEnabled, "isSwapEnabled");
            boolean z = false;
            boolean z2 = !prefs.p() || prefs.l() > 1;
            if (isSwapEnabled.booleanValue() && z2 && !prefs.j(Notification.Id.SWAP_TOS)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        /* renamed from: providesVerifyAppsPrompt$lambda-2 */
        public static final void m1079providesVerifyAppsPrompt$lambda2(BaseApplication appContext, final d0 emitter) {
            m.g(appContext, "$appContext");
            m.g(emitter, "emitter");
            if (!e.j.l.q.a.a.a(appContext)) {
                emitter.onSuccess(Boolean.FALSE);
                return;
            }
            try {
                e.g.a.e.f.c.a(appContext).p().b(new com.google.android.gms.tasks.c() { // from class: com.coinbase.wallet.di.e
                    @Override // com.google.android.gms.tasks.c
                    public final void a(com.google.android.gms.tasks.g gVar) {
                        NotificationsModule.Companion.c(d0.this, gVar);
                    }
                });
            } catch (RuntimeExecutionException unused) {
                emitter.onSuccess(Boolean.FALSE);
            }
        }

        /* renamed from: providesVerifyAppsPrompt$lambda-2$lambda-1 */
        public static final void m1080providesVerifyAppsPrompt$lambda2$lambda1(d0 emitter, com.google.android.gms.tasks.g response) {
            m.g(emitter, "$emitter");
            m.g(response, "response");
            d.a aVar = (d.a) response.m();
            emitter.onSuccess(Boolean.valueOf(!(aVar == null ? true : aVar.c())));
        }

        @ApplicationScoped
        public final Notification providesConsumerNotification$app_productionRelease(final ConsumerUserRepository consumerUserRepository, final e.j.j.b appPrefs, FeatureFlagsRepository featureFlagsRepository) {
            List b2;
            m.g(consumerUserRepository, "consumerUserRepository");
            m.g(appPrefs, "appPrefs");
            m.g(featureFlagsRepository, "featureFlagsRepository");
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str = localizedStrings.get(R.string.consumer_connect_cta_title);
            String str2 = localizedStrings.get(R.string.consumer_connect_cta_description);
            CallToAction callToAction = new CallToAction(R.string.connect_to_coinbase, new NavDestination(R.id.action_walletFragment_to_consumerNavGraph, null, MainTab.WALLET, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, false, consumerUserRepository.getConnectStatus(), null, false, 12, null), null, 18, null), ActionStyle.POSITIVE, null, 8, null);
            b0<R> map = consumerUserRepository.getConnectStatus(true).map(new n() { // from class: com.coinbase.wallet.di.g
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return NotificationsModule.Companion.e(ConsumerUserRepository.this, appPrefs, (ConsumerConnectionStatus) obj);
                }
            });
            m.f(map, "consumerUserRepository.getConnectStatus(requireRefresh = true)\n                .map { status ->\n                    !consumerUserRepository.isAuthenticated &&\n                        !appPrefs.hasSeenNotification(Notification.Id.ANNOUNCEMENT_CONSUMER_CONNECT) &&\n                        !status.onrampEnabled\n                }");
            Integer valueOf = Integer.valueOf((int) R.drawable.illustration_coinbase_and_wallet_connect);
            b2 = q.b(callToAction);
            return new Notification(Notification.Id.ANNOUNCEMENT_CONSUMER_CONNECT, str, str2, true, valueOf, b2, map, null, null, null, 896, null);
        }

        @ApplicationScoped
        public final Notification providesConsumerOnrampNotification$app_productionRelease(final ConsumerUserRepository consumerUserRepository, final e.j.j.b appPrefs, FeatureFlagsRepository featureFlagsRepository) {
            List b2;
            m.g(consumerUserRepository, "consumerUserRepository");
            m.g(appPrefs, "appPrefs");
            m.g(featureFlagsRepository, "featureFlagsRepository");
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str = localizedStrings.get(R.string.consumer_connect_cta_title_onramp);
            String str2 = localizedStrings.get(R.string.consumer_connect_cta_description_onramp);
            CallToAction callToAction = new CallToAction(R.string.connect_to_coinbase, new NavDestination(R.id.action_walletFragment_to_consumerNavGraph, null, MainTab.WALLET, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, false, consumerUserRepository.getConnectStatus(), null, false, 12, null), null, 18, null), ActionStyle.POSITIVE, null, 8, null);
            b0<R> map = consumerUserRepository.getConnectStatus(true).map(new n() { // from class: com.coinbase.wallet.di.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return NotificationsModule.Companion.g(ConsumerUserRepository.this, appPrefs, (ConsumerConnectionStatus) obj);
                }
            });
            m.f(map, "consumerUserRepository.getConnectStatus(requireRefresh = true)\n                .map { status ->\n                    !consumerUserRepository.isAuthenticated &&\n                        !appPrefs.hasSeenNotification(Notification.Id.ANNOUNCEMENT_CONSUMER_CONNECT_ONRAMP) &&\n                        status.onrampEnabled\n                }");
            Integer valueOf = Integer.valueOf((int) R.drawable.illustration_coinbase_and_wallet_connect);
            b2 = q.b(callToAction);
            return new Notification(Notification.Id.ANNOUNCEMENT_CONSUMER_CONNECT_ONRAMP, str, str2, true, valueOf, b2, map, null, null, null, 896, null);
        }

        @ApplicationScoped
        public final Notification providesNewUserCloudBackupPrompt$app_productionRelease(final a2 mnemonicBackupRepository, final StoreInterface store) {
            List j2;
            List b2;
            List j3;
            List b3;
            m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
            m.g(store, "store");
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str = localizedStrings.get(R.string.cloud_backup_dialog_title);
            String str2 = localizedStrings.get(R.string.cloud_backup_dialog_message);
            b0 fromCallable = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.di.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return NotificationsModule.Companion.a(StoreInterface.this, mnemonicBackupRepository);
                }
            });
            m.f(fromCallable, "fromCallable {\n                if (BuildConfig.DEBUG && !CloudBackupPrompt.isTestingCloudBackup.get()) {\n                    return@fromCallable false\n                }\n\n                val hasSeenFirstBackupPrompt = store.get(StoreKeys.hasSeenFirstBackupPrompt) ?: false\n                val result = !mnemonicBackupRepository.hasBackup() && !hasSeenFirstBackupPrompt\n                store.set(StoreKeys.hasSeenFirstBackupPrompt, true)\n                result\n            }");
            Bundle createArgs$default = BackupRecoveryPhraseFragment.Companion.createArgs$default(BackupRecoveryPhraseFragment.Companion, false, null, BackupRecoveryPhraseViewModel.BackupMode.BackupOne, 3, null);
            createArgs$default.putAll(ForwardArgs.INSTANCE.create(R.id.walletFragment));
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            j2 = r.j(AnalyticsEvent_ApplicationKt.backupPromptCTASelected(companion), AnalyticsEvent_ApplicationKt.backupCloudStart(companion));
            CallToAction callToAction = new CallToAction(R.string.cloud_backup_backup_now, new NavDestination(R.id.backup_phrase_nav_graph, j2, null, createArgs$default, null, 20, null), ActionStyle.POSITIVE, null, 8, null);
            b2 = q.b(AnalyticsEvent_ApplicationKt.backupPromptDismissed(companion));
            CallToAction callToAction2 = new CallToAction(R.string.cloud_backup_later, new DismissDestination(b2), ActionStyle.NEUTRAL, null, 8, null);
            Integer valueOf = Integer.valueOf((int) R.drawable.illustration_safe);
            j3 = r.j(callToAction, callToAction2);
            b3 = q.b(AnalyticsEvent_ApplicationKt.backupPromptDismissed(companion));
            return new Notification(Notification.Id.KEY_BACKUP_PROMPT, str, str2, true, valueOf, j3, fromCallable, new DismissDestination(b3), null, null, 768, null);
        }

        @ApplicationScoped
        public final Notification providesSecurityProviderPrompt$app_productionRelease(final BaseApplication appContext) {
            List b2;
            m.g(appContext, "appContext");
            final AtomicInteger atomicInteger = new AtomicInteger(-1);
            CallToAction callToAction = new CallToAction(R.string.security_prompt_update_provider_cta_affirmative, NoDestination.INSTANCE, ActionStyle.POSITIVE, new NotificationsModule$Companion$providesSecurityProviderPrompt$callToAction$1(appContext, atomicInteger));
            b0 fromCallable = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.di.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return NotificationsModule.Companion.b(BaseApplication.this, atomicInteger);
                }
            });
            m.f(fromCallable, "fromCallable {\n                try {\n                    ProviderInstaller.installIfNeeded(appContext)\n                } catch (e: GooglePlayServicesRepairableException) {\n                    // Indicates that Google Play services is out of date, disabled, etc.\n                    connectionStatusCode.set(e.connectionStatusCode)\n                    return@fromCallable true\n                } catch (e: GooglePlayServicesNotAvailableException) {\n                    // Indicates a non-recoverable error; the ProviderInstaller is not able\n                    // to install an up-to-date Provider.\n                    Analytics.log(AnalyticsEvent.updateSecurityProviderNotPossible())\n                    return@fromCallable false\n                }\n                false\n            }");
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str = localizedStrings.get(R.string.security_prompt_update_provider_title);
            String str2 = localizedStrings.get(R.string.security_prompt_update_provider_message);
            b2 = q.b(callToAction);
            return new Notification(Notification.Id.PROVIDER_SECURITY, str, str2, true, null, b2, fromCallable, null, null, null, 896, null);
        }

        @ApplicationScoped
        public final Notification providesSwapTOSNotification$app_productionRelease(FeatureFlagsRepository featureFlagsRepository, final e.j.j.b prefs) {
            List j2;
            m.g(featureFlagsRepository, "featureFlagsRepository");
            m.g(prefs, "prefs");
            b0 map = FeatureFlagsRepository.value$default(featureFlagsRepository, FeatureFlag.NATIVE_DEX, true, 0L, 4, null).map(new n() { // from class: com.coinbase.wallet.di.h
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return NotificationsModule.Companion.f(e.j.j.b.this, (Boolean) obj);
                }
            });
            m.f(map, "featureFlagsRepository.value(FeatureFlag.NATIVE_DEX, true)\n                .map { isSwapEnabled ->\n                    val isNotNewUser = !(prefs.isNewUser() && prefs.getSessionNumber() <= 1)\n\n                    return@map isSwapEnabled && isNotNewUser && !prefs.hasSeenNotification(Notification.Id.SWAP_TOS)\n                }");
            CallToAction callToAction = new CallToAction(R.string.swap_tos_try_converting, new NavDestination(R.id.action_walletFragment_to_swapInterstitialFragment, null, MainTab.WALLET, SwapInterstitialFragmentArgs.createArguments$default(SwapInterstitialFragmentArgs.INSTANCE, false, null, null, 6, null), NavController_CommonKt.getVerticalNavOptionsBuilder().a(), 2, null), ActionStyle.POSITIVE, null, 8, null);
            CallToAction callToAction2 = new CallToAction(R.string.swap_tos_maybe_later, new DismissDestination(null, 1, null), ActionStyle.NEUTRAL, null, 8, null);
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str = localizedStrings.get(R.string.swap_tos_prompt_title);
            String str2 = localizedStrings.get(R.string.swap_tos_prompt_description);
            j2 = r.j(callToAction, callToAction2);
            return new Notification(Notification.Id.SWAP_TOS, str, str2, true, Integer.valueOf((int) R.drawable.illustration_swap_tos_prompt), j2, map, new DismissDestination(null, 1, null), null, null, 768, null);
        }

        @ApplicationScoped
        public final Notification providesVerifyAppsPrompt$app_productionRelease(final BaseApplication appContext) {
            List b2;
            List b3;
            m.g(appContext, "appContext");
            CallToAction callToAction = new CallToAction(R.string.security_prompt_verify_apps_cta_affirmative, NoDestination.INSTANCE, ActionStyle.POSITIVE, new NotificationsModule$Companion$providesVerifyAppsPrompt$callToAction$1(appContext));
            b0 create = b0.create(new f0() { // from class: com.coinbase.wallet.di.f
                @Override // h.c.f0
                public final void subscribe(d0 d0Var) {
                    NotificationsModule.Companion.d(BaseApplication.this, d0Var);
                }
            });
            m.f(create, "create<Boolean> { emitter ->\n                if (!GcmUtil.isGooglePlayServicesAvailable(appContext)) return@create emitter.onSuccess(false)\n                try {\n                    SafetyNet.getClient(appContext).isVerifyAppsEnabled.addOnCompleteListener { response ->\n                        val isVerifyAppsEnabled = response.result?.isVerifyAppsEnabled ?: true\n                        emitter.onSuccess(!isVerifyAppsEnabled)\n                    }\n                } catch (e: RuntimeExecutionException) {\n                    // exception thrown on mostly Huawei devices. most likely incompatibility w/ google play services\n                    emitter.onSuccess(false)\n                }\n            }");
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            String str = localizedStrings.get(R.string.security_prompt_verify_apps_title);
            String str2 = localizedStrings.get(R.string.security_prompt_verify_apps_message);
            b2 = q.b(callToAction);
            b3 = q.b(AnalyticsEvent_ApplicationKt.verifyAppsPromptDismissed(AnalyticsEvent.Companion));
            return new Notification(Notification.Id.VERIFY_APPS_PROMPT, str, str2, true, null, b2, create, new DismissDestination(b3), null, null, 768, null);
        }
    }
}