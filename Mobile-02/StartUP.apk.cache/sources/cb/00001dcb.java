package com.coinbase.wallet.features.cloudbackup.view;

import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VerifyManualBackupFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class VerifyManualBackupFragment$initViews$2$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
    final /* synthetic */ VerifyManualBackupFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyManualBackupFragment$initViews$2$2(VerifyManualBackupFragment verifyManualBackupFragment) {
        super(0);
        this.this$0 = verifyManualBackupFragment;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ kotlin.x invoke() {
        invoke2();
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e.j.f.m.u(this.this$0, R.string.verify_recovery_phrase_error, 0, 2, null);
    }
}