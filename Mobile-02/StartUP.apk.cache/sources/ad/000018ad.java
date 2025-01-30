package com.coinbase.wallet.consumer.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.i18n.ErrorBundle;

/* compiled from: ConsumerAvailablePaymentMethodsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u001b\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter$AvailablePaymentMethodViewHolder;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "list", "Lkotlin/x;", "setList", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter$AvailablePaymentMethodViewHolder;", "getItemCount", "()I", "holder", "position", "onBindViewHolder", "(Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter$AvailablePaymentMethodViewHolder;I)V", "", "Ljava/util/List;", "Lkotlin/Function1;", "onClickListener", "Lkotlin/e0/c/l;", "<init>", "(Lkotlin/e0/c/l;)V", "AvailablePaymentMethodViewHolder", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsAdapter extends RecyclerView.g<AvailablePaymentMethodViewHolder> {
    private final List<ConsumerAvailablePaymentMethod> list;
    private final l<ConsumerAvailablePaymentMethod, x> onClickListener;

    /* compiled from: ConsumerAvailablePaymentMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n \b*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/ConsumerAvailablePaymentMethodsAdapter$AvailablePaymentMethodViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "paymentMethod", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;)V", "Landroid/view/View;", "kotlin.jvm.PlatformType", "availableSoon", "Landroid/view/View;", "Landroid/widget/TextView;", ApiConstants.NAME, "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", ErrorBundle.DETAIL_ENTRY, ApiConstants.DESCRIPTION, "Lkotlin/Function1;", "onClickListener", "Lkotlin/e0/c/l;", "overlay", "itemView", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AvailablePaymentMethodViewHolder extends RecyclerView.e0 {
        private final View availableSoon;
        private final TextView description;
        private final TextView details;
        private final ImageView icon;
        private final TextView name;
        private final l<ConsumerAvailablePaymentMethod, x> onClickListener;
        private final View overlay;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AvailablePaymentMethodViewHolder(View itemView, l<? super ConsumerAvailablePaymentMethod, x> onClickListener) {
            super(itemView);
            m.g(itemView, "itemView");
            m.g(onClickListener, "onClickListener");
            this.onClickListener = onClickListener;
            this.icon = (ImageView) itemView.findViewById(R.id.paymentIcon);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.details = (TextView) itemView.findViewById(R.id.details);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.overlay = itemView.findViewById(R.id.greyedOverlay);
            this.availableSoon = itemView.findViewById(R.id.availableSoon);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
            r1 = kotlin.l0.v.j(r1);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void bind(com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod r10) {
            /*
                Method dump skipped, instructions count: 279
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.consumer.views.adapter.ConsumerAvailablePaymentMethodsAdapter.AvailablePaymentMethodViewHolder.bind(com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod):void");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConsumerAvailablePaymentMethodsAdapter(l<? super ConsumerAvailablePaymentMethod, x> onClickListener) {
        m.g(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
        this.list = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.list.size();
    }

    public final void setList(List<ConsumerAvailablePaymentMethod> list) {
        m.g(list, "list");
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(AvailablePaymentMethodViewHolder holder, int i2) {
        m.g(holder, "holder");
        holder.bind(this.list.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public AvailablePaymentMethodViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.consumer_available_payment_method_item, parent, false);
        m.f(view, "view");
        return new AvailablePaymentMethodViewHolder(view, this.onClickListener);
    }
}