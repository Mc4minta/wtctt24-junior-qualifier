package com.coinbase.wallet.txhistory.views;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.extensions.Context_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.models.TxHistoryDetail;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: TxHistoryDetailFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryDetail;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class TxHistoryDetailFragment$onViewCreated$4 extends o implements l<TxHistoryDetail, x> {
    final /* synthetic */ View $view;
    final /* synthetic */ TxHistoryDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TxHistoryDetailFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.txhistory.views.TxHistoryDetailFragment$onViewCreated$4$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends o implements l<View, x> {
        final /* synthetic */ TxHistoryDetail $state;
        final /* synthetic */ View $view;
        final /* synthetic */ TxHistoryDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(View view, TxHistoryDetailFragment txHistoryDetailFragment, TxHistoryDetail txHistoryDetail) {
            super(1);
            this.$view = view;
            this.this$0 = txHistoryDetailFragment;
            this.$state = txHistoryDetail;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            x xVar;
            m.g(it, "it");
            Context context = this.$view.getContext();
            ClipData newPlainText = ClipData.newPlainText(this.this$0.getString(R.string.address), this.$state.getDestination());
            m.f(context, "context");
            ClipboardManager clipboardManager = Context_CommonKt.getClipboardManager(context);
            if (clipboardManager == null) {
                xVar = null;
            } else {
                clipboardManager.setPrimaryClip(newPlainText);
                xVar = x.a;
            }
            if (xVar == null) {
                return;
            }
            Toast.makeText(context, R.string.address_copied, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryDetailFragment$onViewCreated$4(TxHistoryDetailFragment txHistoryDetailFragment, View view) {
        super(1);
        this.this$0 = txHistoryDetailFragment;
        this.$view = view;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(TxHistoryDetail txHistoryDetail) {
        invoke2(txHistoryDetail);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TxHistoryDetail txHistoryDetail) {
        TxHistoryDetailAdapter txHistoryDetailAdapter;
        TxHistoryDetailViewModel txHistoryDetailViewModel;
        View view = this.this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(R.id.title))).setText(txHistoryDetail.getTitle());
        View view2 = this.this$0.getView();
        ((RecipientImageView) (view2 == null ? null : view2.findViewById(R.id.image))).update(txHistoryDetail.getRecipientType(), txHistoryDetail.getDestination());
        View view3 = this.this$0.getView();
        ((TextView) (view3 == null ? null : view3.findViewById(R.id.destinationLabel))).setText(txHistoryDetail.getDestination());
        View view4 = this.this$0.getView();
        View destinationLabel = view4 == null ? null : view4.findViewById(R.id.destinationLabel);
        m.f(destinationLabel, "destinationLabel");
        View_CommonKt.setOnSingleClickListener$default(destinationLabel, 0L, new AnonymousClass1(this.$view, this.this$0, txHistoryDetail), 1, null);
        View view5 = this.this$0.getView();
        ((TextView) (view5 == null ? null : view5.findViewById(R.id.destinationLabelDetails))).setText(txHistoryDetail.getDestinationDetails());
        View view6 = this.this$0.getView();
        ((TextView) (view6 == null ? null : view6.findViewById(R.id.primaryAmountLabel))).setText(txHistoryDetail.getPrimaryAmount());
        View view7 = this.this$0.getView();
        ((TextView) (view7 == null ? null : view7.findViewById(R.id.secondaryAmountLabel))).setText(txHistoryDetail.getSecondaryAmount());
        String viewOnButtonTitle = txHistoryDetail.getViewOnButtonTitle();
        if (viewOnButtonTitle == null || viewOnButtonTitle.length() == 0) {
            View view8 = this.this$0.getView();
            ((Button) (view8 == null ? null : view8.findViewById(R.id.actionButton))).setVisibility(8);
        } else {
            View view9 = this.this$0.getView();
            ((Button) (view9 == null ? null : view9.findViewById(R.id.actionButton))).setText(txHistoryDetail.getViewOnButtonTitle());
        }
        txHistoryDetailAdapter = this.this$0.txHistoryDetailAdapter;
        txHistoryDetailViewModel = this.this$0.viewModel;
        if (txHistoryDetailViewModel != null) {
            txHistoryDetailAdapter.setItems(txHistoryDetailViewModel.getCellViewStates());
        } else {
            m.w("viewModel");
            throw null;
        }
    }
}