package com.coinbase.wallet.features.wallets.views;

import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.application.view.custom.TopAwareRecyclerView;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.wallets.models.ListItem;
import com.coinbase.wallet.features.wallets.views.adapters.WalletAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062>\u0010\u0005\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/features/wallets/models/ListItem$WalletListItem;", "Lcom/coinbase/wallet/features/wallets/models/ListItem;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabFragment$setupObservers$3 extends o implements l<kotlin.o<? extends List<? extends ListItem.WalletListItem>, ? extends List<? extends ListItem>>, x> {
    final /* synthetic */ WalletsTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsTabFragment$setupObservers$3(WalletsTabFragment walletsTabFragment) {
        super(1);
        this.this$0 = walletsTabFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends List<? extends ListItem.WalletListItem>, ? extends List<? extends ListItem>> oVar) {
        invoke2((kotlin.o<? extends List<ListItem.WalletListItem>, ? extends List<? extends ListItem>>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends List<ListItem.WalletListItem>, ? extends List<? extends ListItem>> oVar) {
        TimerTask timerTask;
        WalletAdapter walletAdapter;
        TimerTask timerTask2;
        List<ListItem.WalletListItem> a = oVar.a();
        List<? extends ListItem> b2 = oVar.b();
        ArrayList arrayList = new ArrayList();
        if (!b2.isEmpty()) {
            arrayList.add(new ListItem.SectionHeader(LocalizedStrings.INSTANCE.get(R.string.wallets_section_actions)));
        }
        arrayList.addAll(b2);
        if (!a.isEmpty()) {
            arrayList.add(new ListItem.SectionHeader(LocalizedStrings.INSTANCE.get(R.string.wallets_section_balance)));
        }
        arrayList.addAll(a);
        timerTask = this.this$0.blankWalletListTimer;
        if (timerTask != null) {
            timerTask2 = this.this$0.blankWalletListTimer;
            if (timerTask2 != null) {
                timerTask2.cancel();
            }
            this.this$0.blankWalletListTimer = null;
        }
        View view = this.this$0.getView();
        RecyclerView.o layoutManager = ((TopAwareRecyclerView) (view == null ? null : view.findViewById(e.j.a.tokensRecyclerView))).getLayoutManager();
        Parcelable j1 = layoutManager == null ? null : layoutManager.j1();
        walletAdapter = this.this$0.walletAdapter;
        if (walletAdapter != null) {
            walletAdapter.submitList(arrayList);
            View view2 = this.this$0.getView();
            RecyclerView.o layoutManager2 = ((TopAwareRecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.tokensRecyclerView))).getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.i1(j1);
            }
            View view3 = this.this$0.getView();
            View emptyTransferView = view3 == null ? null : view3.findViewById(e.j.a.emptyTransferView);
            m.f(emptyTransferView, "emptyTransferView");
            emptyTransferView.setVisibility(a.isEmpty() ? 0 : 8);
            View view4 = this.this$0.getView();
            View tokensRecyclerView = view4 != null ? view4.findViewById(e.j.a.tokensRecyclerView) : null;
            m.f(tokensRecyclerView, "tokensRecyclerView");
            tokensRecyclerView.setVisibility(a.isEmpty() ^ true ? 0 : 8);
            return;
        }
        m.w("walletAdapter");
        throw null;
    }
}