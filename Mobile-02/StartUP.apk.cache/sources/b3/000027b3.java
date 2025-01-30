package com.coinbase.wallet.txhistory.views;

import android.net.Uri;
import c.c.b.c;
import java.net.URL;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: TxHistoryDetailFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/net/URL;", "kotlin.jvm.PlatformType", "url", "Lkotlin/x;", "<anonymous>", "(Ljava/net/URL;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class TxHistoryDetailFragment$onViewCreated$5 extends o implements l<URL, x> {
    final /* synthetic */ TxHistoryDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxHistoryDetailFragment$onViewCreated$5(TxHistoryDetailFragment txHistoryDetailFragment) {
        super(1);
        this.this$0 = txHistoryDetailFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(URL url) {
        invoke2(url);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(URL url) {
        new c.a().f(true).b().a(this.this$0.requireContext(), Uri.parse(url.toString()));
    }
}