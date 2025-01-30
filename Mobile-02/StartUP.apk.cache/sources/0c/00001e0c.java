package com.coinbase.wallet.features.collectibles;

import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.toshi.model.local.room.CollectibleType;
import com.uber.autodispose.d;
import e.j.n.d2;
import h.c.a0;
import h.c.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectibleTypesTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CollectibleTypesTabFragment$initObservers$1 extends o implements l<x, x> {
    final /* synthetic */ CollectibleTypesTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectibleTypesTabFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.collectibles.CollectibleTypesTabFragment$initObservers$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<Throwable, x> {
        final /* synthetic */ CollectibleTypesTabFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CollectibleTypesTabFragment collectibleTypesTabFragment) {
            super(1);
            this.this$0 = collectibleTypesTabFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable it) {
            m.g(it, "it");
            e.j.f.m.v(this.this$0, "Unable to fetch collectibles", 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectibleTypesTabFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/toshi/model/local/room/CollectibleType;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.collectibles.CollectibleTypesTabFragment$initObservers$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends o implements l<List<? extends CollectibleType>, x> {
        final /* synthetic */ CollectibleTypesTabFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CollectibleTypesTabFragment collectibleTypesTabFragment) {
            super(1);
            this.this$0 = collectibleTypesTabFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(List<? extends CollectibleType> list) {
            invoke2((List<CollectibleType>) list);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<CollectibleType> list) {
            if (list != null) {
                this.this$0.showTokensOrEmptyState(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectibleTypesTabFragment$initObservers$1(CollectibleTypesTabFragment collectibleTypesTabFragment) {
        super(1);
        this.this$0 = collectibleTypesTabFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        d2 d2Var;
        a0 a0Var;
        FragmentLifecycleScopeProvider scopeProvider;
        d2Var = this.this$0.viewModel;
        if (d2Var != null) {
            s<List<CollectibleType>> b2 = d2Var.b();
            a0Var = this.this$0.mainScheduler;
            s<List<CollectibleType>> observeOn = b2.observeOn(a0Var);
            scopeProvider = this.this$0.getScopeProvider();
            Object as = observeOn.as(d.a(scopeProvider));
            m.f(as, "viewModel.collectibleTypesObservable\n                    .observeOn(mainScheduler)\n                    .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new AnonymousClass1(this.this$0), null, new AnonymousClass2(this.this$0), 2, null);
            return;
        }
        m.w("viewModel");
        throw null;
    }
}