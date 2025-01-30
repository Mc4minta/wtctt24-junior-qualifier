package com.coinbase.wallet.features.cloudbackup.prompts;

import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.model.CallToAction;
import com.coinbase.wallet.application.model.DismissDestination;
import com.coinbase.wallet.application.model.NavDestination;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.features.cloudbackup.extensions.StoreKeys_CloudBackupKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import e.j.i.i2.d;
import h.c.b0;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: CloudBackupPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ?\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt;", "", "Landroid/os/Bundle;", "args", "Lkotlin/Function0;", "Lkotlin/x;", "onPromptDismiss", "onModalLaunch", "Lcom/coinbase/wallet/application/model/Notification;", "getBackupFlowPrompt", "(Landroid/os/Bundle;Lkotlin/e0/c/a;Lkotlin/e0/c/a;)Lcom/coinbase/wallet/application/model/Notification;", "Lh/c/b0;", "", "backupIfNeeded", "(Landroid/os/Bundle;Lkotlin/e0/c/a;Lkotlin/e0/c/a;)Lh/c/b0;", "Le/j/i/i2/d;", "mnemonicBackupRepository", "Le/j/i/i2/d;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;", "notificationRepository", "Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;", "<init>", "(Le/j/i/i2/d;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CloudBackupPrompt {
    public static final Companion Companion = new Companion(null);
    private static AtomicBoolean isTestingCloudBackup = new AtomicBoolean(false);
    private final d mnemonicBackupRepository;
    private final NotificationRepositoryInterface notificationRepository;
    private final StoreInterface store;

    /* compiled from: CloudBackupPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/prompts/CloudBackupPrompt$Companion;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTestingCloudBackup", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setTestingCloudBackup", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AtomicBoolean isTestingCloudBackup() {
            return CloudBackupPrompt.isTestingCloudBackup;
        }

        public final void setTestingCloudBackup(AtomicBoolean atomicBoolean) {
            m.g(atomicBoolean, "<set-?>");
            CloudBackupPrompt.isTestingCloudBackup = atomicBoolean;
        }
    }

    public CloudBackupPrompt(d mnemonicBackupRepository, StoreInterface store, NotificationRepositoryInterface notificationRepository) {
        m.g(mnemonicBackupRepository, "mnemonicBackupRepository");
        m.g(store, "store");
        m.g(notificationRepository, "notificationRepository");
        this.mnemonicBackupRepository = mnemonicBackupRepository;
        this.store = store;
        this.notificationRepository = notificationRepository;
    }

    public static /* synthetic */ Boolean a(CloudBackupPrompt cloudBackupPrompt, Bundle bundle, kotlin.e0.c.a aVar, kotlin.e0.c.a aVar2) {
        return m1218backupIfNeeded$lambda0(cloudBackupPrompt, bundle, aVar, aVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 backupIfNeeded$default(CloudBackupPrompt cloudBackupPrompt, Bundle bundle, kotlin.e0.c.a aVar, kotlin.e0.c.a aVar2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        if ((i2 & 4) != 0) {
            aVar2 = null;
        }
        return cloudBackupPrompt.backupIfNeeded(bundle, aVar, aVar2);
    }

    /* renamed from: backupIfNeeded$lambda-0 */
    public static final Boolean m1218backupIfNeeded$lambda0(CloudBackupPrompt this$0, Bundle args, kotlin.e0.c.a aVar, kotlin.e0.c.a aVar2) {
        m.g(this$0, "this$0");
        m.g(args, "$args");
        boolean z = !this$0.mnemonicBackupRepository.d();
        if (z) {
            this$0.store.set(StoreKeys_CloudBackupKt.getHasSeenBackupPrompt(StoreKeys.INSTANCE), Boolean.TRUE);
            this$0.notificationRepository.showNotification(this$0.getBackupFlowPrompt(args, aVar, aVar2));
        }
        return Boolean.valueOf(z);
    }

    private final Notification getBackupFlowPrompt(Bundle bundle, kotlin.e0.c.a<x> aVar, kotlin.e0.c.a<x> aVar2) {
        List b2;
        List b3;
        List j2;
        List b4;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str = localizedStrings.get(R.string.cloud_backup_dialog_title);
        String str2 = localizedStrings.get(R.string.cloud_backup_dialog_message);
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        b2 = q.b(AnalyticsEvent_ApplicationKt.backupPromptCTASelected(companion));
        CallToAction callToAction = new CallToAction(R.string.cloud_backup_backup_now, new NavDestination(R.id.backup_phrase_nav_graph, b2, null, bundle, null, 20, null), ActionStyle.POSITIVE, new CloudBackupPrompt$getBackupFlowPrompt$callToAction$1(aVar2));
        b3 = q.b(AnalyticsEvent_ApplicationKt.backupPromptDismissed(companion));
        j2 = r.j(callToAction, new CallToAction(R.string.cloud_backup_later, new DismissDestination(b3), ActionStyle.NEUTRAL, new CloudBackupPrompt$getBackupFlowPrompt$dismiss$1(aVar)));
        b4 = q.b(AnalyticsEvent_ApplicationKt.backupPromptDismissed(companion));
        DismissDestination dismissDestination = new DismissDestination(b4);
        b0 just = b0.just(Boolean.TRUE);
        Integer valueOf = Integer.valueOf((int) R.drawable.illustration_safe);
        m.f(just, "just(true)");
        return new Notification(null, str, str2, true, valueOf, j2, just, dismissDestination, new CloudBackupPrompt$getBackupFlowPrompt$1(aVar), null, 513, null);
    }

    public final b0<Boolean> backupIfNeeded(final Bundle args, final kotlin.e0.c.a<x> aVar, final kotlin.e0.c.a<x> aVar2) {
        m.g(args, "args");
        StoreInterface storeInterface = this.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        Object obj = storeInterface.get(StoreKeys_CloudBackupKt.getHasSeenBackupPrompt(storeKeys));
        Boolean bool = Boolean.TRUE;
        if (!m.c(obj, bool) && !m.c(this.store.get(StoreKeys_CloudBackupKt.getHasSeenOnboardingBackupPrompt(storeKeys)), bool)) {
            b0<Boolean> fromCallable = b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.features.cloudbackup.prompts.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return CloudBackupPrompt.a(CloudBackupPrompt.this, args, aVar, aVar2);
                }
            });
            m.f(fromCallable, "fromCallable {\n            val shouldShowPrompt = !mnemonicBackupRepository.hasBackup()\n            if (shouldShowPrompt) {\n                store.set(StoreKeys.hasSeenBackupPrompt, true)\n                notificationRepository.showNotification(\n                    getBackupFlowPrompt(\n                        args,\n                        onPromptDismiss,\n                        onModalLaunch\n                    )\n                )\n            }\n            shouldShowPrompt\n        }");
            return fromCallable;
        }
        b0<Boolean> just = b0.just(Boolean.FALSE);
        m.f(just, "just(false)");
        return just;
    }
}