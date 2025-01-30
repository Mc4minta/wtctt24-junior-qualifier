package com.coinbase.wallet.features.lend.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.lend.models.LendCoinPickerItem;
import de.hdodenhof.circleimageview.CircleImageView;
import java.net.URL;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendCoinPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001f B\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u000b2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter;", "Landroidx/recyclerview/widget/m;", "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter$LendTokenViewHolder;", "", "url", "symbol", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "defaultTokenAvatar", "Lkotlin/x;", "loadImageOrDefault", "(Ljava/lang/String;Ljava/lang/String;Landroid/widget/ImageView;Landroid/widget/TextView;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter$LendTokenViewHolder;", "holder", "position", "onBindViewHolder", "(Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter$LendTokenViewHolder;I)V", "Lkotlin/Function1;", "onItemClickListener", "Lkotlin/e0/c/l;", "getOnItemClickListener", "()Lkotlin/e0/c/l;", "<init>", "(Lkotlin/e0/c/l;)V", "LendCoinPickerItemCallback", "LendTokenViewHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerAdapter extends m<LendCoinPickerItem, LendTokenViewHolder> {
    private final l<LendCoinPickerItem, x> onItemClickListener;

    /* compiled from: LendCoinPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter$LendCoinPickerItemCallback;", "Landroidx/recyclerview/widget/h$d;", "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;)Z", "areContentsTheSame", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class LendCoinPickerItemCallback extends h.d<LendCoinPickerItem> {
        @Override // androidx.recyclerview.widget.h.d
        public boolean areContentsTheSame(LendCoinPickerItem oldItem, LendCoinPickerItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            return kotlin.jvm.internal.m.c(oldItem.getSupplyRate(), newItem.getSupplyRate()) && kotlin.jvm.internal.m.c(oldItem.getImageURL(), newItem.getImageURL()) && kotlin.jvm.internal.m.c(oldItem.getFiatAmount(), newItem.getFiatAmount()) && kotlin.jvm.internal.m.c(oldItem.getTitle(), newItem.getTitle());
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areItemsTheSame(LendCoinPickerItem oldItem, LendCoinPickerItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            Wallet wallet = oldItem.getWallet();
            String id = wallet == null ? null : wallet.getId();
            Wallet wallet2 = newItem.getWallet();
            return kotlin.jvm.internal.m.c(id, wallet2 != null ? wallet2.getId() : null);
        }
    }

    /* compiled from: LendCoinPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter$LendTokenViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;)V", "Landroid/view/View;", "itemView", "<init>", "(Lcom/coinbase/wallet/features/lend/views/adapters/LendCoinPickerAdapter;Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public final class LendTokenViewHolder extends RecyclerView.e0 {
        final /* synthetic */ LendCoinPickerAdapter this$0;

        /* compiled from: LendCoinPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.lend.views.adapters.LendCoinPickerAdapter$LendTokenViewHolder$1  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass1 extends o implements l<View, x> {
            final /* synthetic */ LendCoinPickerAdapter this$0;
            final /* synthetic */ LendTokenViewHolder this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LendCoinPickerAdapter lendCoinPickerAdapter, LendTokenViewHolder lendTokenViewHolder) {
                super(1);
                this.this$0 = lendCoinPickerAdapter;
                this.this$1 = lendTokenViewHolder;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                l<LendCoinPickerItem, x> onItemClickListener = this.this$0.getOnItemClickListener();
                LendCoinPickerItem access$getItem = LendCoinPickerAdapter.access$getItem(this.this$0, this.this$1.getAdapterPosition());
                kotlin.jvm.internal.m.f(access$getItem, "getItem(adapterPosition)");
                onItemClickListener.invoke(access$getItem);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LendTokenViewHolder(LendCoinPickerAdapter this$0, View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(itemView, "itemView");
            this.this$0 = this$0;
            View_CommonKt.setRippleBackground$default(itemView, View_CommonKt.getPxSize(itemView, R.dimen.view_size_16), null, 2, null);
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new AnonymousClass1(this$0, this), 1, null);
        }

        public final void bind(LendCoinPickerItem item) {
            CurrencyCode currencyCode;
            kotlin.jvm.internal.m.g(item, "item");
            ((TextView) this.itemView.findViewById(e.j.a.tokenName)).setText(item.getTitle());
            ((TextView) this.itemView.findViewById(e.j.a.tokenFiatValue)).setText(item.getFiatAmount());
            ((TextView) this.itemView.findViewById(e.j.a.tokenAPR)).setText(item.getSupplyRate());
            LendCoinPickerAdapter lendCoinPickerAdapter = this.this$0;
            URL imageURL = item.getImageURL();
            String str = null;
            String url = imageURL == null ? null : imageURL.toString();
            Wallet wallet = item.getWallet();
            if (wallet != null && (currencyCode = wallet.getCurrencyCode()) != null) {
                str = currencyCode.getRawValue();
            }
            CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(e.j.a.avatar);
            kotlin.jvm.internal.m.f(circleImageView, "itemView.avatar");
            TextView textView = (TextView) this.itemView.findViewById(e.j.a.defaultTokenAvatar);
            kotlin.jvm.internal.m.f(textView, "itemView.defaultTokenAvatar");
            lendCoinPickerAdapter.loadImageOrDefault(url, str, circleImageView, textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LendCoinPickerAdapter(l<? super LendCoinPickerItem, x> onItemClickListener) {
        super(new LendCoinPickerItemCallback());
        kotlin.jvm.internal.m.g(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    public static final /* synthetic */ LendCoinPickerItem access$getItem(LendCoinPickerAdapter lendCoinPickerAdapter, int i2) {
        return lendCoinPickerAdapter.getItem(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void loadImageOrDefault(java.lang.String r7, java.lang.String r8, android.widget.ImageView r9, android.widget.TextView r10) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto Ld
            boolean r2 = kotlin.l0.o.D(r7)
            if (r2 == 0) goto Lb
            goto Ld
        Lb:
            r2 = r1
            goto Le
        Ld:
            r2 = r0
        Le:
            r3 = 4
            if (r2 == 0) goto L13
            r2 = r3
            goto L14
        L13:
            r2 = r1
        L14:
            r9.setVisibility(r2)
            if (r7 == 0) goto L22
            boolean r2 = kotlin.l0.o.D(r7)
            if (r2 == 0) goto L20
            goto L22
        L20:
            r2 = r1
            goto L23
        L22:
            r2 = r0
        L23:
            r2 = r2 ^ r0
            if (r2 == 0) goto L27
            goto L28
        L27:
            r3 = r1
        L28:
            r10.setVisibility(r3)
            if (r7 == 0) goto L35
            boolean r2 = kotlin.l0.o.D(r7)
            if (r2 == 0) goto L34
            goto L35
        L34:
            r0 = r1
        L35:
            if (r0 == 0) goto L3f
            java.lang.CharSequence r7 = com.coinbase.wallet.commonui.extensions.CharSequence_CommonKt.buildTickerText(r8)
            r10.setText(r7)
            goto L48
        L3f:
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r9
            r1 = r7
            com.coinbase.wallet.commonui.extensions.ImageView_CommonKt.load$default(r0, r1, r2, r3, r4, r5)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.lend.views.adapters.LendCoinPickerAdapter.loadImageOrDefault(java.lang.String, java.lang.String, android.widget.ImageView, android.widget.TextView):void");
    }

    public final l<LendCoinPickerItem, x> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(LendTokenViewHolder holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        LendCoinPickerItem item = getItem(i2);
        kotlin.jvm.internal.m.f(item, "getItem(position)");
        holder.bind(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public LendTokenViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__lend_coin, parent, false);
        kotlin.jvm.internal.m.f(item, "item");
        return new LendTokenViewHolder(this, item);
    }
}