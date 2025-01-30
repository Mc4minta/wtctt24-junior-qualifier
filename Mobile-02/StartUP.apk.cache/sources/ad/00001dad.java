package com.coinbase.wallet.features.cloudbackup.view;

import android.os.Bundle;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import kotlin.Metadata;

/* compiled from: ManualBackupFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ManualBackupFragment$isModal$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Boolean> {
    final /* synthetic */ ManualBackupFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualBackupFragment$isModal$2(ManualBackupFragment manualBackupFragment) {
        super(0);
        this.this$0 = manualBackupFragment;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Bundle arguments = this.this$0.getArguments();
        return (arguments == null ? null : ForwardArgs.INSTANCE.modalSourceFromArgs(arguments)) != null;
    }
}