package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.send.models.SendDestinationPickerState;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "", "recipientOptional", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel$refreshPasteboard$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends String>, kotlin.x> {
    final /* synthetic */ SendDestinationPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerViewModel$refreshPasteboard$1(SendDestinationPickerViewModel sendDestinationPickerViewModel) {
        super(1);
        this.this$0 = sendDestinationPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Optional<? extends String> optional) {
        invoke2((Optional<String>) optional);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Optional<String> recipientOptional) {
        SendDestinationPickerState sendDestinationPickerState;
        SendDestinationPickerState copy;
        kotlin.jvm.internal.m.g(recipientOptional, "recipientOptional");
        String nullable = recipientOptional.toNullable();
        SendDestinationPickerViewModel sendDestinationPickerViewModel = this.this$0;
        sendDestinationPickerState = sendDestinationPickerViewModel.state;
        copy = sendDestinationPickerState.copy((r30 & 1) != 0 ? sendDestinationPickerState.errorMessage : null, (r30 & 2) != 0 ? sendDestinationPickerState.isNextButtonHidden : false, (r30 & 4) != 0 ? sendDestinationPickerState.isNextButtonLoading : false, (r30 & 8) != 0 ? sendDestinationPickerState.isPasteboardHidden : nullable == null, (r30 & 16) != 0 ? sendDestinationPickerState.pasteboardText : nullable, (r30 & 32) != 0 ? sendDestinationPickerState.isMetadataFieldHidden : false, (r30 & 64) != 0 ? sendDestinationPickerState.isMetadataButtonHidden : false, (r30 & 128) != 0 ? sendDestinationPickerState.isErrorMessageHidden : false, (r30 & 256) != 0 ? sendDestinationPickerState.emptyStateTitle : null, (r30 & 512) != 0 ? sendDestinationPickerState.emptyStateDetails : null, (r30 & 1024) != 0 ? sendDestinationPickerState.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? sendDestinationPickerState.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? sendDestinationPickerState.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? sendDestinationPickerState.isPasteboardLoading : false);
        sendDestinationPickerViewModel.setState(copy);
    }
}