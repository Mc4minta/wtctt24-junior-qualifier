package com.coinbase.wallet.features.send.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.common.extensions.List_CommonKt;
import com.coinbase.wallet.features.send.models.SendDestinationPickerRow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: SendDestinationAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004$%&'B1\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\r2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010!¨\u0006("}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "position", "getItemViewType", "(I)I", "getItemCount", "()I", "", "getItemId", "(I)J", "holder", "Lkotlin/x;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$e0;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow;", "items", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Destination;", "onSendDestinationClickListener", "Lkotlin/e0/c/l;", "", "Ljava/util/List;", "<init>", "(Ljava/util/List;Lkotlin/e0/c/l;)V", "SectionType", "SendDestinationViewHolder", "SpinnerViewHolder", "TitleViewHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationAdapter extends RecyclerView.g<RecyclerView.e0> {
    private final List<SendDestinationPickerRow> items;
    private final l<SendDestinationPickerRow.Destination, x> onSendDestinationClickListener;

    /* compiled from: SendDestinationAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter$SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "DESTINATION", "TITLE", "SPINNER", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private enum SectionType {
        DESTINATION,
        TITLE,
        SPINNER
    }

    /* compiled from: SendDestinationAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter$SendDestinationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lh/c/k0/a;", "isLoadingDisposable", "Lh/c/k0/a;", "()Lh/c/k0/a;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SendDestinationViewHolder extends RecyclerView.e0 {
        private final h.c.k0.a isLoadingDisposable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendDestinationViewHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
            this.isLoadingDisposable = new h.c.k0.a();
        }

        public final h.c.k0.a isLoadingDisposable() {
            return this.isLoadingDisposable;
        }
    }

    /* compiled from: SendDestinationAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter$SpinnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SpinnerViewHolder extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpinnerViewHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
        }
    }

    /* compiled from: SendDestinationAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class TitleViewHolder extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
        }
    }

    /* compiled from: SendDestinationAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SectionType.values().length];
            iArr[SectionType.DESTINATION.ordinal()] = 1;
            iArr[SectionType.TITLE.ordinal()] = 2;
            iArr[SectionType.SPINNER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SendDestinationAdapter() {
        this(null, null, 3, null);
    }

    public /* synthetic */ SendDestinationAdapter(List list, l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : lVar);
    }

    public static /* synthetic */ void a(SendDestinationPickerRow sendDestinationPickerRow) {
        m1423onBindViewHolder$lambda3$lambda2(sendDestinationPickerRow);
    }

    /* renamed from: onBindViewHolder$lambda-3$lambda-2 */
    public static final void m1423onBindViewHolder$lambda3$lambda2(SendDestinationPickerRow viewModel) {
        m.g(viewModel, "$viewModel");
        ((SendDestinationPickerRow.Destination) viewModel).getDestination().setLoading(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        SendDestinationPickerRow sendDestinationPickerRow = this.items.get(i2);
        if (sendDestinationPickerRow instanceof SendDestinationPickerRow.Destination) {
            sendDestinationPickerRow = ((SendDestinationPickerRow.Destination) sendDestinationPickerRow).getDestination().getDestination();
        } else if (sendDestinationPickerRow instanceof SendDestinationPickerRow.Title) {
            sendDestinationPickerRow = ((SendDestinationPickerRow.Title) sendDestinationPickerRow).getTitle();
        } else if (!(sendDestinationPickerRow instanceof SendDestinationPickerRow.Spinner)) {
            throw new NoWhenBranchMatchedException();
        }
        return sendDestinationPickerRow.hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        SectionType sectionType;
        SendDestinationPickerRow sendDestinationPickerRow = (SendDestinationPickerRow) List_CommonKt.require(this.items, i2);
        if (sendDestinationPickerRow instanceof SendDestinationPickerRow.Destination) {
            sectionType = SectionType.DESTINATION;
        } else if (sendDestinationPickerRow instanceof SendDestinationPickerRow.Title) {
            sectionType = SectionType.TITLE;
        } else if (!(sendDestinationPickerRow instanceof SendDestinationPickerRow.Spinner)) {
            throw new NoWhenBranchMatchedException();
        } else {
            sectionType = SectionType.SPINNER;
        }
        return sectionType.ordinal();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
        if ((r3.length() > 0) == true) goto L6;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.e0 r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.m.g(r10, r0)
            java.util.List<com.coinbase.wallet.features.send.models.SendDestinationPickerRow> r0 = r9.items
            java.lang.Object r11 = r0.get(r11)
            com.coinbase.wallet.features.send.models.SendDestinationPickerRow r11 = (com.coinbase.wallet.features.send.models.SendDestinationPickerRow) r11
            android.view.View r0 = r10.itemView
            java.lang.String r1 = "holder.itemView"
            kotlin.jvm.internal.m.f(r0, r1)
            com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter$onBindViewHolder$1 r3 = new com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter$onBindViewHolder$1
            r3.<init>(r11, r9)
            r1 = 0
            r4 = 1
            r5 = 0
            com.coinbase.wallet.commonui.extensions.View_CommonKt.setOnSingleClickListener$default(r0, r1, r3, r4, r5)
            boolean r0 = r11 instanceof com.coinbase.wallet.features.send.models.SendDestinationPickerRow.Destination
            if (r0 == 0) goto Ld3
            r0 = r10
            com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter$SendDestinationViewHolder r0 = (com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter.SendDestinationViewHolder) r0
            h.c.k0.a r1 = r0.isLoadingDisposable()
            r1.d()
            android.view.View r10 = r10.itemView
            int r1 = e.j.a.label
            android.view.View r1 = r10.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = r11
            com.coinbase.wallet.features.send.models.SendDestinationPickerRow$Destination r2 = (com.coinbase.wallet.features.send.models.SendDestinationPickerRow.Destination) r2
            com.coinbase.wallet.features.send.models.SendDestinationViewInfo r3 = r2.getDestination()
            java.lang.String r3 = r3.getTitle()
            r1.setText(r3)
            int r1 = e.j.a.A6
            android.view.View r3 = r10.findViewById(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            com.coinbase.wallet.features.send.models.SendDestinationViewInfo r4 = r2.getDestination()
            java.lang.String r4 = r4.getSubtitle()
            r3.setText(r4)
            android.view.View r1 = r10.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r3 = "subtitle"
            kotlin.jvm.internal.m.f(r1, r3)
            com.coinbase.wallet.features.send.models.SendDestinationViewInfo r3 = r2.getDestination()
            java.lang.String r3 = r3.getSubtitle()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L72
        L70:
            r4 = r5
            goto L7d
        L72:
            int r3 = r3.length()
            if (r3 <= 0) goto L7a
            r3 = r4
            goto L7b
        L7a:
            r3 = r5
        L7b:
            if (r3 != r4) goto L70
        L7d:
            if (r4 == 0) goto L80
            goto L82
        L80:
            r5 = 8
        L82:
            r1.setVisibility(r5)
            int r1 = e.j.a.iconImageView
            android.view.View r1 = r10.findViewById(r1)
            com.coinbase.wallet.txhistory.views.RecipientImageView r1 = (com.coinbase.wallet.txhistory.views.RecipientImageView) r1
            com.coinbase.wallet.features.send.models.SendDestinationViewInfo r3 = r2.getDestination()
            com.coinbase.wallet.txhistory.models.RecipientType r3 = r3.getRecipientType()
            com.coinbase.wallet.features.send.models.SendDestinationViewInfo r4 = r2.getDestination()
            java.lang.String r4 = r4.getTitle()
            r1.update(r3, r4)
            com.coinbase.wallet.features.send.models.SendDestinationViewInfo r1 = r2.getDestination()
            h.c.s r1 = r1.isLoadingObservable()
            h.c.a0 r2 = h.c.j0.c.a.b()
            h.c.s r1 = r1.observeOn(r2)
            com.coinbase.wallet.features.send.views.adapters.a r2 = new com.coinbase.wallet.features.send.views.adapters.a
            r2.<init>()
            h.c.s r3 = r1.doOnDispose(r2)
            java.lang.String r11 = "viewModel.destination.isLoadingObservable\n                        .observeOn(AndroidSchedulers.mainThread())\n                        .doOnDispose { viewModel.destination.isLoading = false }"
            kotlin.jvm.internal.m.f(r3, r11)
            r4 = 0
            r5 = 0
            com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter$onBindViewHolder$3$2 r6 = new com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter$onBindViewHolder$3$2
            r6.<init>(r10)
            r7 = 3
            r8 = 0
            h.c.k0.b r10 = h.c.t0.g.h(r3, r4, r5, r6, r7, r8)
            h.c.k0.a r11 = r0.isLoadingDisposable()
            h.c.t0.a.a(r10, r11)
            goto Lea
        Ld3:
            boolean r0 = r11 instanceof com.coinbase.wallet.features.send.models.SendDestinationPickerRow.Title
            if (r0 == 0) goto Lea
            android.view.View r10 = r10.itemView
            int r0 = e.j.a.K6
            android.view.View r10 = r10.findViewById(r0)
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            com.coinbase.wallet.features.send.models.SendDestinationPickerRow$Title r11 = (com.coinbase.wallet.features.send.models.SendDestinationPickerRow.Title) r11
            java.lang.String r11 = r11.getTitle()
            r10.setText(r11)
        Lea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$e0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[SectionType.values()[i2].ordinal()];
        if (i3 == 1) {
            View itemView = from.inflate(R.layout.list_item__send_destination, parent, false);
            m.f(itemView, "itemView");
            return new SendDestinationViewHolder(itemView);
        } else if (i3 == 2) {
            View itemView2 = from.inflate(R.layout.list_item__send_section_title, parent, false);
            m.f(itemView2, "itemView");
            return new TitleViewHolder(itemView2);
        } else if (i3 == 3) {
            View itemView3 = from.inflate(R.layout.list_item__send_section_spinner, parent, false);
            m.f(itemView3, "itemView");
            return new SpinnerViewHolder(itemView3);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onViewRecycled(RecyclerView.e0 holder) {
        m.g(holder, "holder");
        super.onViewRecycled(holder);
        SendDestinationViewHolder sendDestinationViewHolder = holder instanceof SendDestinationViewHolder ? (SendDestinationViewHolder) holder : null;
        if (sendDestinationViewHolder == null) {
            return;
        }
        sendDestinationViewHolder.isLoadingDisposable().d();
    }

    public final void setItems(List<? extends SendDestinationPickerRow> list) {
        this.items.clear();
        if (!(list == null || list.isEmpty())) {
            this.items.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendDestinationAdapter(List<? extends SendDestinationPickerRow> list, l<? super SendDestinationPickerRow.Destination, x> lVar) {
        this.onSendDestinationClickListener = lVar;
        boolean z = true;
        setHasStableIds(true);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (!z) {
            arrayList.addAll(list);
        }
        x xVar = x.a;
        this.items = arrayList;
    }
}