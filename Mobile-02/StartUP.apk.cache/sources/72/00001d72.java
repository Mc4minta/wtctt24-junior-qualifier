package com.coinbase.wallet.features.cloudbackup.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.Button;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment$doCopyAndAnimate$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
    final /* synthetic */ ValueAnimator $colorSwitch;
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$doCopyAndAnimate$2(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, ValueAnimator valueAnimator) {
        super(0);
        this.this$0 = backupRecoveryPhraseFragment;
        this.$colorSwitch = valueAnimator;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ kotlin.x invoke() {
        invoke2();
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.getActivity() != null) {
            View view = this.this$0.getView();
            if ((view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn)) != null) {
                View view2 = this.this$0.getView();
                ((Button) (view2 == null ? null : view2.findViewById(e.j.a.copyToClipboardBtn))).setClickable(true);
                View view3 = this.this$0.getView();
                ((Button) (view3 != null ? view3.findViewById(e.j.a.copyToClipboardBtn) : null)).setText(this.this$0.getString(R.string.copy_to_clipboard));
                this.$colorSwitch.start();
            }
        }
    }
}