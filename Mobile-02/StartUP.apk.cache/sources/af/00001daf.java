package com.coinbase.wallet.features.cloudbackup.view;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: ManualBackupFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0007\n\u0002\b\u0003*\u0001\u0000\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/coinbase/wallet/features/cloudbackup/view/ManualBackupFragment$screenshotObserver$2$1", "<anonymous>", "()Lcom/coinbase/wallet/features/cloudbackup/view/ManualBackupFragment$screenshotObserver$2$1;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ManualBackupFragment$screenshotObserver$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<AnonymousClass1> {
    final /* synthetic */ ManualBackupFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualBackupFragment$screenshotObserver$2(ManualBackupFragment manualBackupFragment) {
        super(0);
        this.this$0 = manualBackupFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.coinbase.wallet.features.cloudbackup.view.ManualBackupFragment$screenshotObserver$2$1] */
    @Override // kotlin.e0.c.a
    public final AnonymousClass1 invoke() {
        Handler handler = new Handler(Looper.getMainLooper());
        final ManualBackupFragment manualBackupFragment = this.this$0;
        return new ContentObserver(handler) { // from class: com.coinbase.wallet.features.cloudbackup.view.ManualBackupFragment$screenshotObserver$2.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                View view = ManualBackupFragment.this.getView();
                ((TextView) (view == null ? null : view.findViewById(e.j.a.descriptionText))).setText(ManualBackupFragment.this.getText(R.string.screenshots_are_not_secure_description));
            }
        };
    }
}