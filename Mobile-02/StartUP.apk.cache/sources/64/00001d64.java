package com.coinbase.wallet.features.cloudbackup.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecoveryPhraseClipboardWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(J)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecoveryPhraseClipboardWrapper$copyRecoveryPhrase$1 extends o implements l<Long, x> {
    final /* synthetic */ RecoveryPhraseClipboardWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPhraseClipboardWrapper$copyRecoveryPhrase$1(RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper) {
        super(1);
        this.this$0 = recoveryPhraseClipboardWrapper;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Long l2) {
        invoke2(l2);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Long l2) {
        ClipboardManager clipboardManager;
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.recoveryPhraseClearedFromClipboard(AnalyticsEvent.Companion));
        clipboardManager = this.this$0.getClipboardManager();
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(LocalizedStrings.INSTANCE.get(R.string.recovery_phrase), Strings_CoreKt.getEmpty(Strings.INSTANCE)));
    }
}