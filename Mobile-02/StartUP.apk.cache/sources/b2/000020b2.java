package com.coinbase.wallet.features.send.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendDestinationPickerState;
import com.toshi.view.custom.ProgressBarButton;
import kotlin.Metadata;

/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/SendDestinationPickerState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendDestinationPickerFragment$setupObservables$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SendDestinationPickerState, kotlin.x> {
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupObservables$1(SendDestinationPickerFragment sendDestinationPickerFragment) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SendDestinationPickerState sendDestinationPickerState) {
        invoke2(sendDestinationPickerState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SendDestinationPickerState sendDestinationPickerState) {
        View view = this.this$0.getView();
        ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.s4))).setProgressBarIsVisible(sendDestinationPickerState.isNextButtonLoading());
        View view2 = this.this$0.getView();
        View pasteboardActivityIndicatorView = view2 == null ? null : view2.findViewById(e.j.a.pasteboardActivityIndicatorView);
        kotlin.jvm.internal.m.f(pasteboardActivityIndicatorView, "pasteboardActivityIndicatorView");
        pasteboardActivityIndicatorView.setVisibility(sendDestinationPickerState.isPasteboardLoading() ? 0 : 8);
        String errorMessage = sendDestinationPickerState.getErrorMessage();
        if (errorMessage != null) {
            View view3 = this.this$0.getView();
            ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.h2))).setText(errorMessage);
        }
        View view4 = this.this$0.getView();
        ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.metadataFieldErrorLabel))).setText(sendDestinationPickerState.getMetadataFieldErrorMessage());
        View view5 = this.this$0.getView();
        View metadataFieldErrorLabel = view5 == null ? null : view5.findViewById(e.j.a.metadataFieldErrorLabel);
        kotlin.jvm.internal.m.f(metadataFieldErrorLabel, "metadataFieldErrorLabel");
        metadataFieldErrorLabel.setVisibility(sendDestinationPickerState.isMetadataFieldErrorLabelHidden() ^ true ? 0 : 8);
        View view6 = this.this$0.getView();
        View pasteIcon = view6 == null ? null : view6.findViewById(e.j.a.pasteIcon);
        kotlin.jvm.internal.m.f(pasteIcon, "pasteIcon");
        pasteIcon.setVisibility(sendDestinationPickerState.isPasteboardLoading() ? 4 : 0);
        View view7 = this.this$0.getView();
        View pasteButton = view7 == null ? null : view7.findViewById(e.j.a.pasteButton);
        kotlin.jvm.internal.m.f(pasteButton, "pasteButton");
        pasteButton.setVisibility(sendDestinationPickerState.isPasteboardContainerViewHidden() ^ true ? 0 : 8);
        View view8 = this.this$0.getView();
        ((TextView) (view8 == null ? null : view8.findViewById(e.j.a.emptyStateTitle))).setText(sendDestinationPickerState.getEmptyStateTitle());
        View view9 = this.this$0.getView();
        ((TextView) (view9 == null ? null : view9.findViewById(e.j.a.emptyStateDescription))).setText(sendDestinationPickerState.getEmptyStateDetails());
        View view10 = this.this$0.getView();
        ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.pasteAddress))).setText(sendDestinationPickerState.getPasteboardText());
        View view11 = this.this$0.getView();
        View errorLabel = view11 == null ? null : view11.findViewById(e.j.a.h2);
        kotlin.jvm.internal.m.f(errorLabel, "errorLabel");
        errorLabel.setVisibility(sendDestinationPickerState.isErrorLabelHidden() ^ true ? 0 : 8);
        View view12 = this.this$0.getView();
        View metadataContainerView = view12 == null ? null : view12.findViewById(e.j.a.metadataContainerView);
        kotlin.jvm.internal.m.f(metadataContainerView, "metadataContainerView");
        metadataContainerView.setVisibility(!sendDestinationPickerState.isMetadataButtonHidden() || !sendDestinationPickerState.isMetadataFieldHidden() ? 0 : 8);
        View view13 = this.this$0.getView();
        View nextButton = view13 == null ? null : view13.findViewById(e.j.a.s4);
        kotlin.jvm.internal.m.f(nextButton, "nextButton");
        nextButton.setVisibility(sendDestinationPickerState.isNextButtonHidden() ^ true ? 0 : 8);
        View view14 = this.this$0.getView();
        View memoTypePicker = view14 == null ? null : view14.findViewById(e.j.a.memoTypePicker);
        kotlin.jvm.internal.m.f(memoTypePicker, "memoTypePicker");
        memoTypePicker.setVisibility(sendDestinationPickerState.isMetadataButtonHidden() ^ true ? 0 : 8);
        View view15 = this.this$0.getView();
        View metadataField = view15 != null ? view15.findViewById(e.j.a.metadataField) : null;
        kotlin.jvm.internal.m.f(metadataField, "metadataField");
        metadataField.setVisibility(sendDestinationPickerState.isMetadataFieldHidden() ^ true ? 0 : 8);
    }
}