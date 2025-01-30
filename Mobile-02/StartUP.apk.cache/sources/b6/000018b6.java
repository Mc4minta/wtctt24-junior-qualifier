package com.coinbase.wallet.consumer.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.bumptech.glide.Glide;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.AddPaymentTransferItem;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransferItem;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodItem;
import com.coinbase.wallet.consumer.models.PlaceholderTransferItem;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.e0;
import kotlin.x;

/* compiled from: TransferMethodsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u001c\u001d\u001e\u001f B/\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0015\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u000f\u0010\u0014R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter;", "Landroidx/recyclerview/widget/m;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "position", "getItemViewType", "(I)I", "holder", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "", "", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$e0;ILjava/util/List;)V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "onWarningClickListener", "Lkotlin/e0/c/l;", "onItemClickListener", "<init>", "(Lkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "AddPaymentMethodViewHolder", "AvailableTransferPlaceholderViewholder", "AvailableTransferViewHolder", "SectionType", "TransferMethodsCallback", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TransferMethodsAdapter extends m<ConsumerTransferMethodItem, RecyclerView.e0> {
    private final l<ConsumerTransferMethodItem, x> onItemClickListener;
    private final l<AvailableTransfer, x> onWarningClickListener;

    /* compiled from: TransferMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter$AddPaymentMethodViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/consumer/models/AddPaymentTransferItem;", "item", "Lkotlin/Function1;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "Lkotlin/x;", "onItemClickListener", "bind", "(Lcom/coinbase/wallet/consumer/models/AddPaymentTransferItem;Lkotlin/e0/c/l;)V", "Landroid/widget/TextView;", "addPaymentMethodDescription", "Landroid/widget/TextView;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AddPaymentMethodViewHolder extends RecyclerView.e0 {
        private final TextView addPaymentMethodDescription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddPaymentMethodViewHolder(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.description);
            kotlin.jvm.internal.m.f(textView, "itemView.description");
            this.addPaymentMethodDescription = textView;
        }

        public final void bind(AddPaymentTransferItem item, l<? super ConsumerTransferMethodItem, x> onItemClickListener) {
            kotlin.jvm.internal.m.g(item, "item");
            kotlin.jvm.internal.m.g(onItemClickListener, "onItemClickListener");
            this.addPaymentMethodDescription.setText(item.getDescription());
            View itemView = this.itemView;
            kotlin.jvm.internal.m.f(itemView, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new TransferMethodsAdapter$AddPaymentMethodViewHolder$bind$1(onItemClickListener, item), 1, null);
        }
    }

    /* compiled from: TransferMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter$AvailableTransferPlaceholderViewholder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lkotlin/x;", "bind", "()V", "Landroid/view/View;", "transferMethodSubtextShimmer", "Landroid/view/View;", "transferMethodNameShimmer", "itemView", "<init>", "(Landroid/view/View;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AvailableTransferPlaceholderViewholder extends RecyclerView.e0 {
        private final View transferMethodNameShimmer;
        private final View transferMethodSubtextShimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AvailableTransferPlaceholderViewholder(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) itemView.findViewById(R.id.namePlaceholderShimmer);
            kotlin.jvm.internal.m.f(shimmerFrameLayout, "itemView.namePlaceholderShimmer");
            this.transferMethodNameShimmer = shimmerFrameLayout;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) itemView.findViewById(R.id.subtextPlaceholderShimmer);
            kotlin.jvm.internal.m.f(shimmerFrameLayout2, "itemView.subtextPlaceholderShimmer");
            this.transferMethodSubtextShimmer = shimmerFrameLayout2;
        }

        public final void bind() {
            this.transferMethodNameShimmer.setVisibility(0);
            this.transferMethodSubtextShimmer.setVisibility(0);
        }
    }

    /* compiled from: TransferMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter$AvailableTransferViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/consumer/models/AvailableTransferItem;", "transferMethod", "Lkotlin/Function1;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "Lkotlin/x;", "onItemClickListener", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "onWarningClickListener", "bind", "(Lcom/coinbase/wallet/consumer/models/AvailableTransferItem;Lkotlin/e0/c/l;Lkotlin/e0/c/l;)V", "Landroid/widget/TextView;", "transferMethodSubtext", "Landroid/widget/TextView;", "Landroid/view/View;", "disabledView", "Landroid/view/View;", "transferMethodName", "transferMethodNameShimmer", "Landroidx/appcompat/widget/AppCompatImageView;", "warningIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "icon", "transferMethodSubtextShimmer", "itemView", "<init>", "(Landroid/view/View;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AvailableTransferViewHolder extends RecyclerView.e0 {
        private final View disabledView;
        private final AppCompatImageView icon;
        private final TextView transferMethodName;
        private final View transferMethodNameShimmer;
        private final TextView transferMethodSubtext;
        private final View transferMethodSubtextShimmer;
        private final AppCompatImageView warningIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AvailableTransferViewHolder(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(R.id.name);
            kotlin.jvm.internal.m.f(textView, "itemView.name");
            this.transferMethodName = textView;
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) itemView.findViewById(R.id.nameShimmer);
            kotlin.jvm.internal.m.f(shimmerFrameLayout, "itemView.nameShimmer");
            this.transferMethodNameShimmer = shimmerFrameLayout;
            TextView textView2 = (TextView) itemView.findViewById(R.id.subtext);
            kotlin.jvm.internal.m.f(textView2, "itemView.subtext");
            this.transferMethodSubtext = textView2;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) itemView.findViewById(R.id.subtextShimmer);
            kotlin.jvm.internal.m.f(shimmerFrameLayout2, "itemView.subtextShimmer");
            this.transferMethodSubtextShimmer = shimmerFrameLayout2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R.id.warningIcon);
            kotlin.jvm.internal.m.f(appCompatImageView, "itemView.warningIcon");
            this.warningIcon = appCompatImageView;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) itemView.findViewById(R.id.icon);
            kotlin.jvm.internal.m.f(appCompatImageView2, "itemView.icon");
            this.icon = appCompatImageView2;
            View findViewById = itemView.findViewById(R.id.disabledView);
            kotlin.jvm.internal.m.f(findViewById, "itemView.disabledView");
            this.disabledView = findViewById;
        }

        public final void bind(AvailableTransferItem transferMethod, l<? super ConsumerTransferMethodItem, x> onItemClickListener, l<? super AvailableTransfer, x> onWarningClickListener) {
            kotlin.jvm.internal.m.g(transferMethod, "transferMethod");
            kotlin.jvm.internal.m.g(onItemClickListener, "onItemClickListener");
            kotlin.jvm.internal.m.g(onWarningClickListener, "onWarningClickListener");
            this.transferMethodName.setText(transferMethod.getName());
            this.transferMethodSubtext.setText(transferMethod.getSubtext());
            this.warningIcon.setVisibility(transferMethod.getHasWarning() ? 0 : 8);
            this.itemView.setClickable(transferMethod.getClickable());
            this.disabledView.setVisibility(!transferMethod.getClickable() && !transferMethod.isLoading() ? 0 : 8);
            this.transferMethodName.setVisibility(transferMethod.isLoading() ? 4 : 0);
            this.transferMethodSubtext.setVisibility(transferMethod.isLoading() ? 4 : 0);
            this.transferMethodNameShimmer.setVisibility(transferMethod.isLoading() ? 0 : 8);
            this.transferMethodSubtextShimmer.setVisibility(transferMethod.isLoading() ? 0 : 8);
            if (transferMethod.getHasWarning()) {
                if (!transferMethod.getClickable()) {
                    View itemView = this.itemView;
                    kotlin.jvm.internal.m.f(itemView, "itemView");
                    View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new TransferMethodsAdapter$AvailableTransferViewHolder$bind$1(onWarningClickListener, transferMethod), 1, null);
                } else {
                    View_CommonKt.setOnSingleClickListener$default(this.warningIcon, 0L, new TransferMethodsAdapter$AvailableTransferViewHolder$bind$2(onWarningClickListener, transferMethod), 1, null);
                }
            }
            if (transferMethod.getClickable()) {
                View itemView2 = this.itemView;
                kotlin.jvm.internal.m.f(itemView2, "itemView");
                View_CommonKt.setOnSingleClickListener$default(itemView2, 0L, new TransferMethodsAdapter$AvailableTransferViewHolder$bind$3(onItemClickListener, transferMethod), 1, null);
            }
            if (transferMethod.getIconRes() != null) {
                this.icon.setImageResource(transferMethod.getIconRes().intValue());
            } else if (transferMethod.getIconUrl() != null) {
                Glide.with(this.icon.getContext()).load(transferMethod.getIconUrl()).into(this.icon);
            }
        }
    }

    /* compiled from: TransferMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter$SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE_TRANSFER", "AVAILABLE_TRANSFER_PLACEHOLDER", "ADD_PAYMENT", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private enum SectionType {
        AVAILABLE_TRANSFER,
        AVAILABLE_TRANSFER_PLACEHOLDER,
        ADD_PAYMENT
    }

    /* compiled from: TransferMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/consumer/views/adapter/TransferMethodsAdapter$TransferMethodsCallback;", "Landroidx/recyclerview/widget/h$d;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;)Z", "", "getChangePayload", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;)Ljava/lang/Object;", "areContentsTheSame", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class TransferMethodsCallback extends h.d<ConsumerTransferMethodItem> {
        @Override // androidx.recyclerview.widget.h.d
        public Object getChangePayload(ConsumerTransferMethodItem oldItem, ConsumerTransferMethodItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            return newItem;
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areContentsTheSame(ConsumerTransferMethodItem oldItem, ConsumerTransferMethodItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (oldItem instanceof AvailableTransferItem) {
                return kotlin.jvm.internal.m.c((AvailableTransferItem) newItem, oldItem);
            }
            PlaceholderTransferItem placeholderTransferItem = PlaceholderTransferItem.INSTANCE;
            if (kotlin.jvm.internal.m.c(oldItem, placeholderTransferItem)) {
                return kotlin.jvm.internal.m.c(newItem, placeholderTransferItem);
            }
            if (oldItem instanceof AddPaymentTransferItem) {
                return kotlin.jvm.internal.m.c((AddPaymentTransferItem) newItem, oldItem);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areItemsTheSame(ConsumerTransferMethodItem oldItem, ConsumerTransferMethodItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (kotlin.jvm.internal.m.c(e0.b(oldItem.getClass()), e0.b(newItem.getClass()))) {
                return areContentsTheSame(oldItem, newItem);
            }
            return false;
        }
    }

    /* compiled from: TransferMethodsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionType.values().length];
            iArr[SectionType.AVAILABLE_TRANSFER.ordinal()] = 1;
            iArr[SectionType.AVAILABLE_TRANSFER_PLACEHOLDER.ordinal()] = 2;
            iArr[SectionType.ADD_PAYMENT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransferMethodsAdapter(l<? super ConsumerTransferMethodItem, x> onItemClickListener, l<? super AvailableTransfer, x> onWarningClickListener) {
        super(new TransferMethodsCallback());
        kotlin.jvm.internal.m.g(onItemClickListener, "onItemClickListener");
        kotlin.jvm.internal.m.g(onWarningClickListener, "onWarningClickListener");
        this.onItemClickListener = onItemClickListener;
        this.onWarningClickListener = onWarningClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        SectionType sectionType;
        ConsumerTransferMethodItem item = getItem(i2);
        if (item instanceof AvailableTransferItem) {
            sectionType = SectionType.AVAILABLE_TRANSFER;
        } else if (kotlin.jvm.internal.m.c(item, PlaceholderTransferItem.INSTANCE)) {
            sectionType = SectionType.AVAILABLE_TRANSFER_PLACEHOLDER;
        } else if (!(item instanceof AddPaymentTransferItem)) {
            throw new NoWhenBranchMatchedException();
        } else {
            sectionType = SectionType.ADD_PAYMENT;
        }
        return sectionType.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        ConsumerTransferMethodItem item = getItem(i2);
        if (item instanceof AvailableTransferItem) {
            ((AvailableTransferViewHolder) holder).bind((AvailableTransferItem) item, this.onItemClickListener, this.onWarningClickListener);
        } else if (kotlin.jvm.internal.m.c(item, PlaceholderTransferItem.INSTANCE)) {
            ((AvailableTransferPlaceholderViewholder) holder).bind();
        } else if (!(item instanceof AddPaymentTransferItem)) {
            throw new NoWhenBranchMatchedException();
        } else {
            ((AddPaymentMethodViewHolder) holder).bind((AddPaymentTransferItem) item, this.onItemClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[SectionType.values()[i2].ordinal()];
        if (i3 == 1) {
            View v = from.inflate(R.layout.list_item__consumer_transfer_methods, parent, false);
            kotlin.jvm.internal.m.f(v, "v");
            return new AvailableTransferViewHolder(v);
        } else if (i3 == 2) {
            View v2 = from.inflate(R.layout.list_item__consumer_transfer_methods_placeholder, parent, false);
            kotlin.jvm.internal.m.f(v2, "v");
            return new AvailableTransferPlaceholderViewholder(v2);
        } else if (i3 == 3) {
            View v3 = from.inflate(R.layout.list_item__consumer_add_payment_method, parent, false);
            kotlin.jvm.internal.m.f(v3, "v");
            return new AddPaymentMethodViewHolder(v3);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2, List<Object> payloads) {
        kotlin.jvm.internal.m.g(holder, "holder");
        kotlin.jvm.internal.m.g(payloads, "payloads");
        onBindViewHolder(holder, i2);
    }
}