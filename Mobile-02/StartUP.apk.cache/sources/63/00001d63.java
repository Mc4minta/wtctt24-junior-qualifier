package com.coinbase.wallet.features.cloudbackup.util;

import android.content.ClipboardManager;
import android.content.Context;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: RecoveryPhraseClipboardWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/ClipboardManager;", "<anonymous>", "()Landroid/content/ClipboardManager;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class RecoveryPhraseClipboardWrapper$clipboardManager$2 extends o implements a<ClipboardManager> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPhraseClipboardWrapper$clipboardManager$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ClipboardManager invoke() {
        return Context_CommonKt.getClipboardManager(this.$context);
    }
}