package com.coinbase.wallet.application.view.custom;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopAwareRecyclerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/recyclerview/widget/LinearLayoutManager;", "<anonymous>", "()Landroidx/recyclerview/widget/LinearLayoutManager;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TopAwareRecyclerView$linearLayoutManager$2 extends o implements kotlin.e0.c.a<LinearLayoutManager> {
    final /* synthetic */ TopAwareRecyclerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopAwareRecyclerView$linearLayoutManager$2(TopAwareRecyclerView topAwareRecyclerView) {
        super(0);
        this.this$0 = topAwareRecyclerView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final LinearLayoutManager invoke() {
        RecyclerView.o layoutManager = this.this$0.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        return (LinearLayoutManager) layoutManager;
    }
}