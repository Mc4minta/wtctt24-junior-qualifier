package com.coinbase.wallet.features.lend.views;

import com.coinbase.wallet.features.lend.models.LendDashboardItem;
import com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel;
import com.coinbase.wallet.features.lend.views.adapters.DashboardListAdapter;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: LendDashboardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter;", "<anonymous>", "()Lcom/coinbase/wallet/features/lend/views/adapters/DashboardListAdapter;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendDashboardFragment$adapter$2 extends o implements kotlin.e0.c.a<DashboardListAdapter> {
    final /* synthetic */ LendDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendDashboardFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "provider", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.lend.views.LendDashboardFragment$adapter$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<LendDashboardItem.Provider, x> {
        final /* synthetic */ LendDashboardFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LendDashboardFragment lendDashboardFragment) {
            super(1);
            this.this$0 = lendDashboardFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(LendDashboardItem.Provider provider) {
            invoke2(provider);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(LendDashboardItem.Provider provider) {
            LendDashboardViewModel lendDashboardViewModel;
            m.g(provider, "provider");
            lendDashboardViewModel = this.this$0.viewModel;
            if (lendDashboardViewModel != null) {
                lendDashboardViewModel.showLendingActionSheet(provider);
            } else {
                m.w("viewModel");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendDashboardFragment$adapter$2(LendDashboardFragment lendDashboardFragment) {
        super(0);
        this.this$0 = lendDashboardFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final DashboardListAdapter invoke() {
        return new DashboardListAdapter(new AnonymousClass1(this.this$0));
    }
}