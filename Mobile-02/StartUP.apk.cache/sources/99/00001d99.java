package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import kotlin.Metadata;

/* compiled from: CreatePasswordFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class CreatePasswordFragment$initObservers$7 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends BackupStatus>, kotlin.x> {
    public static final CreatePasswordFragment$initObservers$7 INSTANCE = new CreatePasswordFragment$initObservers$7();

    CreatePasswordFragment$initObservers$7() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends BackupStatus> optional) {
        invoke2(optional);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Optional<? extends BackupStatus> optional) {
        l.a.a.a(kotlin.jvm.internal.m.o("Backup status: ", optional), new Object[0]);
    }
}