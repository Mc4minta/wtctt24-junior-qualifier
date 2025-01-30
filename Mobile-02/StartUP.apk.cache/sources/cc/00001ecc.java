package com.coinbase.wallet.features.lend.views;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coinbase.wallet.features.lend.models.LendDashboardItem;
import com.coinbase.wallet.features.lend.views.adapters.DashboardListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendDashboardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "kotlin.jvm.PlatformType", "data", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendDashboardFragment$onViewCreated$6 extends o implements l<List<? extends LendDashboardItem>, x> {
    final /* synthetic */ LendDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendDashboardFragment$onViewCreated$6(LendDashboardFragment lendDashboardFragment) {
        super(1);
        this.this$0 = lendDashboardFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(List<? extends LendDashboardItem> list) {
        invoke2(list);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends LendDashboardItem> data) {
        DashboardListAdapter adapter;
        List list;
        List t0;
        View view = this.this$0.getView();
        View toolbar = view == null ? null : view.findViewById(e.j.a.T6);
        m.f(toolbar, "toolbar");
        toolbar.setVisibility(0);
        View view2 = this.this$0.getView();
        View earnMore = view2 == null ? null : view2.findViewById(e.j.a.earnMore);
        m.f(earnMore, "earnMore");
        earnMore.setVisibility(0);
        View view3 = this.this$0.getView();
        View lendBackground = view3 == null ? null : view3.findViewById(e.j.a.lendBackground);
        m.f(lendBackground, "lendBackground");
        lendBackground.setVisibility(0);
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        View view4 = this.this$0.getView();
        dVar.j((ConstraintLayout) (view4 == null ? null : view4.findViewById(e.j.a.dashboardContainer)));
        if (data.size() == 1) {
            dVar.m(R.id.dashboardList, 4, 0, 4, 0);
        } else {
            dVar.h(R.id.dashboardList, 4);
        }
        View view5 = this.this$0.getView();
        dVar.d((ConstraintLayout) (view5 != null ? view5.findViewById(e.j.a.dashboardContainer) : null));
        adapter = this.this$0.getAdapter();
        m.f(data, "data");
        list = this.this$0.blankListItem;
        t0 = z.t0(data, list);
        adapter.submitList(t0);
    }
}