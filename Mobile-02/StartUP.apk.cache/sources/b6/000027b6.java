package com.coinbase.wallet.txhistory.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.coinbase.wallet.txhistory.models.ReceiptCellViewState;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: TxHistoryDetailViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R%\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR%\u0010\u0010\u001a\n \b*\u0004\u0018\u00010\u00070\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR%\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00110\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0018\u001a\n \b*\u0004\u0018\u00010\u00070\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR%\u0010\u001b\u001a\n \b*\u0004\u0018\u00010\u00110\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/TxHistoryDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/txhistory/models/ReceiptCellViewState;", "row", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/txhistory/models/ReceiptCellViewState;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "valueLabel$delegate", "Lkotlin/h;", "getValueLabel", "()Landroid/widget/TextView;", "valueLabel", "valueDetailLabel$delegate", "getValueDetailLabel", "valueDetailLabel", "Landroid/widget/ImageView;", "valueImage$delegate", "getValueImage", "()Landroid/widget/ImageView;", "valueImage", "titleLabel$delegate", "getTitleLabel", "titleLabel", "valueDetailImage$delegate", "getValueDetailImage", "valueDetailImage", "Landroid/view/View;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDetailViewHolder extends RecyclerView.e0 {
    private final h titleLabel$delegate;
    private final h valueDetailImage$delegate;
    private final h valueDetailLabel$delegate;
    private final h valueImage$delegate;
    private final h valueLabel$delegate;
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryDetailViewHolder(View view) {
        super(view);
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        m.g(view, "view");
        this.view = view;
        b2 = k.b(new TxHistoryDetailViewHolder$titleLabel$2(this));
        this.titleLabel$delegate = b2;
        b3 = k.b(new TxHistoryDetailViewHolder$valueLabel$2(this));
        this.valueLabel$delegate = b3;
        b4 = k.b(new TxHistoryDetailViewHolder$valueImage$2(this));
        this.valueImage$delegate = b4;
        b5 = k.b(new TxHistoryDetailViewHolder$valueDetailLabel$2(this));
        this.valueDetailLabel$delegate = b5;
        b6 = k.b(new TxHistoryDetailViewHolder$valueDetailImage$2(this));
        this.valueDetailImage$delegate = b6;
    }

    public static final /* synthetic */ View access$getView$p(TxHistoryDetailViewHolder txHistoryDetailViewHolder) {
        return txHistoryDetailViewHolder.view;
    }

    private final TextView getTitleLabel() {
        return (TextView) this.titleLabel$delegate.getValue();
    }

    private final ImageView getValueDetailImage() {
        return (ImageView) this.valueDetailImage$delegate.getValue();
    }

    private final TextView getValueDetailLabel() {
        return (TextView) this.valueDetailLabel$delegate.getValue();
    }

    private final ImageView getValueImage() {
        return (ImageView) this.valueImage$delegate.getValue();
    }

    private final TextView getValueLabel() {
        return (TextView) this.valueLabel$delegate.getValue();
    }

    public final void bind(ReceiptCellViewState row) {
        m.g(row, "row");
        getTitleLabel().setText(row.getTitle());
        TextView valueLabel = getValueLabel();
        String value = row.getValue();
        if (value == null) {
            value = row.getValueDetail();
        }
        valueLabel.setText(value);
        boolean z = (row.getValue() == null || row.getValueDetail() == null) ? false : true;
        ImageView targetImageView = z ? getValueDetailImage() : getValueImage();
        ImageView disabledImageView = z ? getValueImage() : getValueDetailImage();
        URL valueDetailImageUrl = row.getValueDetailImageUrl();
        String url = valueDetailImageUrl == null ? null : valueDetailImageUrl.toString();
        m.f(disabledImageView, "disabledImageView");
        disabledImageView.setVisibility(8);
        if (url != null) {
            m.f(targetImageView, "targetImageView");
            targetImageView.setVisibility(0);
            Glide.with(this.view.getContext()).load(url).into(targetImageView);
        } else {
            m.f(targetImageView, "targetImageView");
            targetImageView.setVisibility(8);
        }
        if (z) {
            getValueDetailLabel().setText(row.getValueDetail());
            TextView valueDetailLabel = getValueDetailLabel();
            m.f(valueDetailLabel, "valueDetailLabel");
            valueDetailLabel.setVisibility(0);
            return;
        }
        TextView valueDetailLabel2 = getValueDetailLabel();
        m.f(valueDetailLabel2, "valueDetailLabel");
        valueDetailLabel2.setVisibility(8);
    }
}