package com.coinbase.wallet.features.swap.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.m;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.commonui.views.TokenAvatarView;
import com.coinbase.wallet.features.swap.models.SwapAssetPickerItem;
import e.j.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwapAssetPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0017\u0018\u0019\u001aB\u001b\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter;", "Landroidx/recyclerview/widget/m;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "holder", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "onClickListener", "Lkotlin/e0/c/l;", "<init>", "(Lkotlin/e0/c/l;)V", "AssetViewHolder", "SectionHeaderViewHolder", "SectionType", "SwapAssetPickerItemCallback", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerAdapter extends m<SwapAssetPickerItem, RecyclerView.e0> {
    private final l<SwapAssetPickerItem.SwapAssetItem, x> onClickListener;

    /* compiled from: SwapAssetPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter$AssetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SwapAssetItem;)V", "Landroid/view/View;", "Lkotlin/Function1;", "", "onClickListener", "<init>", "(Landroid/view/View;Lkotlin/e0/c/l;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AssetViewHolder extends RecyclerView.e0 {

        /* compiled from: SwapAssetPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.coinbase.wallet.features.swap.views.adapters.SwapAssetPickerAdapter$AssetViewHolder$1  reason: invalid class name */
        /* loaded from: classes.dex */
        static final class AnonymousClass1 extends o implements l<View, x> {
            final /* synthetic */ l<Integer, x> $onClickListener;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(l<? super Integer, x> lVar) {
                super(1);
                this.$onClickListener = lVar;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                int adapterPosition = AssetViewHolder.this.getAdapterPosition();
                if (adapterPosition >= 0) {
                    this.$onClickListener.invoke(Integer.valueOf(adapterPosition));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssetViewHolder(View item, l<? super Integer, x> onClickListener) {
            super(item);
            kotlin.jvm.internal.m.g(item, "item");
            kotlin.jvm.internal.m.g(onClickListener, "onClickListener");
            View_CommonKt.setOnSingleClickListener$default(item, 0L, new AnonymousClass1(onClickListener), 1, null);
        }

        public final void bind(SwapAssetPickerItem.SwapAssetItem item) {
            kotlin.jvm.internal.m.g(item, "item");
            ((TokenAvatarView) this.itemView.findViewById(a.avatar)).load(item.getCurrencyCode(), item.getImageURL());
            ((TextView) this.itemView.findViewById(a.tokenName)).setText(item.getName());
            ((TextView) this.itemView.findViewById(a.tokenTicker)).setText(item.getCurrencyCode());
            ((TextView) this.itemView.findViewById(a.tokenFiatValue)).setText(item.getFiatBalance());
            ((TextView) this.itemView.findViewById(a.tokenAmount)).setText(item.getCryptoBalance());
        }
    }

    /* compiled from: SwapAssetPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter$SectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SectionHeader;", "item", "Lkotlin/x;", "bind", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem$SectionHeader;)V", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SectionHeaderViewHolder extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeaderViewHolder(View item) {
            super(item);
            kotlin.jvm.internal.m.g(item, "item");
            item.setOnClickListener(null);
        }

        public final void bind(SwapAssetPickerItem.SectionHeader item) {
            kotlin.jvm.internal.m.g(item, "item");
            ((TextView) this.itemView.findViewById(a.K6)).setText(item.getTitle());
        }
    }

    /* compiled from: SwapAssetPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter$SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "Asset", "Header", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private enum SectionType {
        Asset,
        Header
    }

    /* compiled from: SwapAssetPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/adapters/SwapAssetPickerAdapter$SwapAssetPickerItemCallback;", "Landroidx/recyclerview/widget/h$d;", "Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerItem;)Z", "areContentsTheSame", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class SwapAssetPickerItemCallback extends h.d<SwapAssetPickerItem> {
        @Override // androidx.recyclerview.widget.h.d
        public boolean areContentsTheSame(SwapAssetPickerItem oldItem, SwapAssetPickerItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (oldItem instanceof SwapAssetPickerItem.SectionHeader) {
                return kotlin.jvm.internal.m.c((SwapAssetPickerItem.SectionHeader) newItem, oldItem);
            }
            if (oldItem instanceof SwapAssetPickerItem.SwapAssetItem) {
                SwapAssetPickerItem.SwapAssetItem swapAssetItem = (SwapAssetPickerItem.SwapAssetItem) newItem;
                SwapAssetPickerItem.SwapAssetItem swapAssetItem2 = (SwapAssetPickerItem.SwapAssetItem) oldItem;
                return kotlin.jvm.internal.m.c(swapAssetItem2.getImageURL(), swapAssetItem.getImageURL()) && kotlin.jvm.internal.m.c(swapAssetItem2.getName(), swapAssetItem.getName()) && kotlin.jvm.internal.m.c(swapAssetItem2.getCurrencyCode(), swapAssetItem.getCurrencyCode()) && kotlin.jvm.internal.m.c(swapAssetItem2.getCryptoBalance(), swapAssetItem.getCryptoBalance()) && kotlin.jvm.internal.m.c(swapAssetItem2.getFiatBalance(), swapAssetItem.getFiatBalance());
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.h.d
        public boolean areItemsTheSame(SwapAssetPickerItem oldItem, SwapAssetPickerItem newItem) {
            kotlin.jvm.internal.m.g(oldItem, "oldItem");
            kotlin.jvm.internal.m.g(newItem, "newItem");
            if (kotlin.jvm.internal.m.c(e0.b(oldItem.getClass()), e0.b(newItem.getClass()))) {
                return kotlin.jvm.internal.m.c(oldItem.getId(), newItem.getId());
            }
            return false;
        }
    }

    /* compiled from: SwapAssetPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionType.values().length];
            iArr[SectionType.Asset.ordinal()] = 1;
            iArr[SectionType.Header.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SwapAssetPickerAdapter(l<? super SwapAssetPickerItem.SwapAssetItem, x> onClickListener) {
        super(new SwapAssetPickerItemCallback());
        kotlin.jvm.internal.m.g(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        SectionType sectionType;
        SwapAssetPickerItem item = getItem(i2);
        if (item instanceof SwapAssetPickerItem.SectionHeader) {
            sectionType = SectionType.Header;
        } else if (!(item instanceof SwapAssetPickerItem.SwapAssetItem)) {
            throw new NoWhenBranchMatchedException();
        } else {
            sectionType = SectionType.Asset;
        }
        return sectionType.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        SwapAssetPickerItem item = getItem(i2);
        if (item instanceof SwapAssetPickerItem.SectionHeader) {
            ((SectionHeaderViewHolder) holder).bind((SwapAssetPickerItem.SectionHeader) item);
        } else if (item instanceof SwapAssetPickerItem.SwapAssetItem) {
            ((AssetViewHolder) holder).bind((SwapAssetPickerItem.SwapAssetItem) item);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[SectionType.values()[i2].ordinal()];
        if (i3 == 1) {
            View itemView = from.inflate(R.layout.list_item__swap_token, parent, false);
            kotlin.jvm.internal.m.f(itemView, "itemView");
            return new AssetViewHolder(itemView, new SwapAssetPickerAdapter$onCreateViewHolder$1(this));
        } else if (i3 == 2) {
            View itemView2 = from.inflate(R.layout.list_item__swap_section_title, parent, false);
            kotlin.jvm.internal.m.f(itemView2, "itemView");
            return new SectionHeaderViewHolder(itemView2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}