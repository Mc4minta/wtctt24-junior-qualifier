package com.coinbase.wallet.txhistory.views;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.txhistory.models.TxHistoryCellViewState;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxHistoryHeaderViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Header;", "header", "", "position", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/txhistory/models/TxHistoryCellViewState$Header;I)V", "Landroid/widget/TextView;", "titleTextView$delegate", "Lkotlin/h;", "getTitleTextView", "()Landroid/widget/TextView;", "titleTextView", "", "addedFirstHeaderPadding", "Z", "Landroid/view/View;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Companion", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryHeaderViewHolder extends RecyclerView.e0 {
    public static final Companion Companion = new Companion(null);
    private static final int FIRST_HEADER_EXTRA_PADDING_DP = 4;
    private boolean addedFirstHeaderPadding;
    private final h titleTextView$delegate;
    private final View view;

    /* compiled from: TxHistoryHeaderViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryHeaderViewHolder$Companion;", "", "", "FIRST_HEADER_EXTRA_PADDING_DP", "I", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryHeaderViewHolder(View view) {
        super(view);
        h b2;
        m.g(view, "view");
        this.view = view;
        b2 = k.b(new TxHistoryHeaderViewHolder$titleTextView$2(this));
        this.titleTextView$delegate = b2;
    }

    private final TextView getTitleTextView() {
        Object value = this.titleTextView$delegate.getValue();
        m.f(value, "<get-titleTextView>(...)");
        return (TextView) value;
    }

    public final void bind(TxHistoryCellViewState.Header header, int i2) {
        m.g(header, "header");
        if (i2 == 0) {
            View view = this.view;
            if (!this.addedFirstHeaderPadding) {
                this.addedFirstHeaderPadding = true;
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + ((int) ((4 * view.getContext().getResources().getDisplayMetrics().density) + 0.5f)), view.getPaddingRight(), view.getPaddingBottom());
            }
        }
        getTitleTextView().setText(this.view.getContext().getString(header.getTitle()));
    }
}