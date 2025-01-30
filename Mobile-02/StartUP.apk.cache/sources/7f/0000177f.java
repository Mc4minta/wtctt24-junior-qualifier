package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationArgs;
import java.util.UUID;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerSecure3DVerificationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/UUID;", "<anonymous>", "()Ljava/util/UUID;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationViewModel$uuid$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<UUID> {
    final /* synthetic */ ConsumerSecure3DVerificationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerSecure3DVerificationViewModel$uuid$2(ConsumerSecure3DVerificationViewModel consumerSecure3DVerificationViewModel) {
        super(0);
        this.this$0 = consumerSecure3DVerificationViewModel;
    }

    @Override // kotlin.e0.c.a
    public final UUID invoke() {
        androidx.lifecycle.z zVar;
        zVar = this.this$0.savedStateHandle;
        return (UUID) SavedStateHandle_CommonKt.require(zVar, ConsumerSecure3DVerificationArgs.uuidKey);
    }
}