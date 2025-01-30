package com.coinbase.wallet.features.cloudbackup.view;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackupRecoveryPhraseFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment$setupObservers$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ BackupRecoveryPhraseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRecoveryPhraseFragment$setupObservers$4(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
        super(1);
        this.this$0 = backupRecoveryPhraseFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        e.j.m.a.l recoveryPhraseAdapter;
        List<String> K0;
        recoveryPhraseAdapter = this.this$0.getRecoveryPhraseAdapter();
        kotlin.jvm.internal.m.f(it, "it");
        K0 = kotlin.l0.y.K0(it, new String[]{Strings_CoreKt.getSpace(Strings.INSTANCE)}, false, 0, 6, null);
        recoveryPhraseAdapter.c(K0);
        View view = this.this$0.getView();
        ((ProgressBar) (view == null ? null : view.findViewById(e.j.a.E3))).setVisibility(8);
        View view2 = this.this$0.getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.cloudBackupBtn))).setEnabled(true);
        View view3 = this.this$0.getView();
        ((Button) (view3 != null ? view3.findViewById(e.j.a.manualBackupBtn) : null)).setEnabled(true);
    }
}