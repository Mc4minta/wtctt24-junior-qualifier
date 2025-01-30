package com.coinbase.wallet.features.cloudbackup.viewModel;

import androidx.lifecycle.b0;
import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.cloudbackup.extensions.StoreKeys_CloudBackupKt;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: OnboardingBackupRecoveryPhraseViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel;", "Landroidx/lifecycle/b0;", "Lkotlin/x;", "backupMnemonic", "()V", "Lh/c/s;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "navigationObservable", "Lh/c/s;", "getNavigationObservable", "()Lh/c/s;", "Landroidx/lifecycle/z;", "savedStateHandle", "Landroidx/lifecycle/z;", "Lh/c/v0/b;", "navigationSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Landroidx/lifecycle/z;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OnboardingBackupRecoveryPhraseViewModel extends b0 {
    private final s<ViewModelNavRoute> navigationObservable;
    private final h.c.v0.b<ViewModelNavRoute> navigationSubject;
    private final z savedStateHandle;

    /* compiled from: OnboardingBackupRecoveryPhraseViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel$Factory;", "", "Landroidx/lifecycle/z;", "savedStateHandle", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel;", "create", "(Landroidx/lifecycle/z;)Lcom/coinbase/wallet/features/cloudbackup/viewModel/OnboardingBackupRecoveryPhraseViewModel;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        OnboardingBackupRecoveryPhraseViewModel create(z zVar);
    }

    public OnboardingBackupRecoveryPhraseViewModel(StoreInterface store, z savedStateHandle) {
        m.g(store, "store");
        m.g(savedStateHandle, "savedStateHandle");
        this.savedStateHandle = savedStateHandle;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        m.f(d2, "create()");
        this.navigationSubject = d2;
        s<ViewModelNavRoute> hide = d2.hide();
        m.f(hide, "navigationSubject.hide()");
        this.navigationObservable = hide;
        store.set(StoreKeys_CloudBackupKt.getHasSeenOnboardingBackupPrompt(StoreKeys.INSTANCE), Boolean.TRUE);
    }

    public final void backupMnemonic() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.backupPromptCTASelected(AnalyticsEvent.Companion));
        this.navigationSubject.onNext(new ViewModelNavRoute(R.id.action_onboardingBackupRecoveryPhraseFragment_to_backupRecoveryPhraseFragment, BackupRecoveryPhraseFragment.Companion.createArgs$default(BackupRecoveryPhraseFragment.Companion, false, (String) SavedStateHandle_CommonKt.require(this.savedStateHandle, OnboardingBackupRecoveryPhraseArgs.mnemonicKey), BackupRecoveryPhraseViewModel.BackupMode.BackupOne, 1, null), null, 4, null));
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.navigationObservable;
    }
}