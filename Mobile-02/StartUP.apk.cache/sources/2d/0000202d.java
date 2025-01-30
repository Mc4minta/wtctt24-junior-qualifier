package com.coinbase.wallet.features.send.viewmodels;

import android.content.ClipboardManager;
import android.content.Context;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/ClipboardManager;", "<anonymous>", "()Landroid/content/ClipboardManager;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel$clipboardManager$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ClipboardManager> {
    final /* synthetic */ SendDestinationPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerViewModel$clipboardManager$2(SendDestinationPickerViewModel sendDestinationPickerViewModel) {
        super(0);
        this.this$0 = sendDestinationPickerViewModel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final ClipboardManager invoke() {
        Context context;
        context = this.this$0.context;
        Object systemService = context.getSystemService("clipboard");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }
}