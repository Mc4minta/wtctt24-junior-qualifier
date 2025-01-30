package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import kotlin.Metadata;

/* compiled from: EnterPasswordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "<anonymous>", "()Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class EnterPasswordFragment$backup$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<BackupPayload> {
    final /* synthetic */ EnterPasswordFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterPasswordFragment$backup$2(EnterPasswordFragment enterPasswordFragment) {
        super(0);
        this.this$0 = enterPasswordFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final BackupPayload invoke() {
        return (BackupPayload) e.j.f.e.b(this.this$0.getArguments(), "extra__backup");
    }
}