package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.send.exceptions.SendException;
import com.coinbase.wallet.features.send.models.SendDestinationPickerState;
import java.util.ArrayList;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "err", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel$search$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ String $query;
    final /* synthetic */ SendDestinationPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerViewModel$search$1(String str, SendDestinationPickerViewModel sendDestinationPickerViewModel) {
        super(1);
        this.$query = str;
        this.this$0 = sendDestinationPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable err) {
        String str;
        SendDestinationPickerState sendDestinationPickerState;
        SendDestinationPickerState sendDestinationPickerState2;
        SendDestinationPickerState copy;
        h.c.v0.a aVar;
        kotlin.jvm.internal.m.g(err, "err");
        String str2 = this.$query;
        str = this.this$0.currentSearchQuery;
        if (kotlin.jvm.internal.m.c(str2, str)) {
            if (err instanceof SendException.InvalidSearchQuery) {
                this.this$0.setSearching(false);
                String str3 = LocalizedStrings.INSTANCE.get(R.string.send_to_username_invalid_characters);
                SendDestinationPickerViewModel sendDestinationPickerViewModel = this.this$0;
                sendDestinationPickerState2 = sendDestinationPickerViewModel.state;
                copy = sendDestinationPickerState2.copy((r30 & 1) != 0 ? sendDestinationPickerState2.errorMessage : str3, (r30 & 2) != 0 ? sendDestinationPickerState2.isNextButtonHidden : false, (r30 & 4) != 0 ? sendDestinationPickerState2.isNextButtonLoading : false, (r30 & 8) != 0 ? sendDestinationPickerState2.isPasteboardHidden : false, (r30 & 16) != 0 ? sendDestinationPickerState2.pasteboardText : null, (r30 & 32) != 0 ? sendDestinationPickerState2.isMetadataFieldHidden : false, (r30 & 64) != 0 ? sendDestinationPickerState2.isMetadataButtonHidden : false, (r30 & 128) != 0 ? sendDestinationPickerState2.isErrorMessageHidden : false, (r30 & 256) != 0 ? sendDestinationPickerState2.emptyStateTitle : null, (r30 & 512) != 0 ? sendDestinationPickerState2.emptyStateDetails : null, (r30 & 1024) != 0 ? sendDestinationPickerState2.memoTypeButtonTapped : false, (r30 & PKIFailureInfo.wrongIntegrity) != 0 ? sendDestinationPickerState2.isMetadataFieldErrorLabelHidden : false, (r30 & 4096) != 0 ? sendDestinationPickerState2.metadataFieldErrorMessage : null, (r30 & PKIFailureInfo.certRevoked) != 0 ? sendDestinationPickerState2.isPasteboardLoading : false);
                sendDestinationPickerViewModel.setState(copy);
                this.this$0.setSections(new ArrayList());
                aVar = this.this$0.destinationUpdateSubject;
                aVar.onNext(kotlin.x.a);
                return;
            }
            l.a.a.f(err, "Had unknown error searching", new Object[0]);
            this.this$0.setSearching(false);
            SendDestinationPickerViewModel sendDestinationPickerViewModel2 = this.this$0;
            sendDestinationPickerState = sendDestinationPickerViewModel2.state;
            sendDestinationPickerViewModel2.setState(sendDestinationPickerState);
        }
    }
}