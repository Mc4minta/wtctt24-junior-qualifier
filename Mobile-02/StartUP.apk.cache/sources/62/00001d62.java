package com.coinbase.wallet.features.cloudbackup.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import h.c.k0.a;
import h.c.s;
import h.c.t0.g;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: RecoveryPhraseClipboardWrapper.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001f\u0010\u000f\u001a\u0004\u0018\u00010\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lkotlin/x;", "copyRecoveryPhrase", "(Ljava/lang/String;)V", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Landroid/content/ClipboardManager;", "clipboardManager$delegate", "Lkotlin/h;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecoveryPhraseClipboardWrapper {
    private final h clipboardManager$delegate;
    private final a disposeBag;

    public RecoveryPhraseClipboardWrapper(Context context) {
        h b2;
        m.g(context, "context");
        this.disposeBag = new a();
        b2 = k.b(new RecoveryPhraseClipboardWrapper$clipboardManager$2(context));
        this.clipboardManager$delegate = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipboardManager getClipboardManager() {
        return (ClipboardManager) this.clipboardManager$delegate.getValue();
    }

    public final void copyRecoveryPhrase(String mnemonic) {
        m.g(mnemonic, "mnemonic");
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.recoveryPhraseCopiedToClipboard(AnalyticsEvent.Companion));
        this.disposeBag.d();
        ClipboardManager clipboardManager = getClipboardManager();
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(LocalizedStrings.INSTANCE.get(R.string.recovery_phrase), mnemonic));
        }
        s<Long> timer = s.timer(60L, TimeUnit.SECONDS);
        m.f(timer, "timer(60, TimeUnit.SECONDS)");
        h.c.t0.a.a(g.h(timer, null, null, new RecoveryPhraseClipboardWrapper$copyRecoveryPhrase$1(this), 3, null), this.disposeBag);
    }
}