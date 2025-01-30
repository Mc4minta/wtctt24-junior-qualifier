package com.coinbase.wallet.features.wallets.views;

import androidx.appcompat.app.c;
import e.j.f.k;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletsTabFragment$setupObservers$5 extends o implements l<x, x> {
    final /* synthetic */ WalletsTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletsTabFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/appcompat/app/c$a;", "Lcom/toshi/extensions/DialogBuilder;", "Lkotlin/x;", "<anonymous>", "(Landroidx/appcompat/app/c$a;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.wallets.views.WalletsTabFragment$setupObservers$5$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<c.a, x> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(c.a aVar) {
            invoke2(aVar);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(c.a showDialog) {
            m.g(showDialog, "$this$showDialog");
            showDialog.n(R.string.address_not_found_alert_title);
            showDialog.f(R.string.lend_test_requirement_message);
            k.b(showDialog, R.string.ok);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsTabFragment$setupObservers$5(WalletsTabFragment walletsTabFragment) {
        super(1);
        this.this$0 = walletsTabFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        e.j.f.m.p(this.this$0, AnonymousClass1.INSTANCE);
    }
}