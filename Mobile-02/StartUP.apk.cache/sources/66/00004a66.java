package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.common.extensions.List_CommonKt;
import e.j.m.a.h;
import e.j.n.a3;
import e.j.n.q2;
import e.j.n.r2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.e0;
import kotlin.x;
import org.toshi.R;

/* compiled from: NetworkAdapter.kt */
/* loaded from: classes2.dex */
public final class h extends RecyclerView.g<RecyclerView.e0> {
    private final kotlin.e0.c.l<q2, x> a;

    /* renamed from: b */
    private final List<r2> f13755b;

    /* renamed from: c */
    private final Map<Blockchain, List<Integer>> f13756c;

    /* renamed from: d */
    private final Map<Blockchain, Integer> f13757d;

    /* compiled from: NetworkAdapter.kt */
    /* loaded from: classes2.dex */
    private final class a extends RecyclerView.e0 {
        final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h this$0, View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(itemView, "itemView");
            this.a = this$0;
        }

        public static final void b(kotlin.e0.c.l listener, q2 network, h this$0, int i2, View view) {
            kotlin.jvm.internal.m.g(listener, "$listener");
            kotlin.jvm.internal.m.g(network, "$network");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            listener.invoke(network);
            this$0.f13757d.put(network.b().getBlockchain(), Integer.valueOf(i2));
            List<Number> list = (List) this$0.f13756c.get(network.b().getBlockchain());
            if (list == null) {
                return;
            }
            for (Number number : list) {
                this$0.notifyItemChanged(number.intValue());
            }
        }

        public static /* synthetic */ void c(kotlin.e0.c.l lVar, q2 q2Var, h hVar, int i2, View view) {
            b(lVar, q2Var, hVar, i2, view);
        }

        public final void a(final q2 network, final int i2, final kotlin.e0.c.l<? super q2, x> listener) {
            Boolean valueOf;
            boolean booleanValue;
            kotlin.jvm.internal.m.g(network, "network");
            kotlin.jvm.internal.m.g(listener, "listener");
            ((TextView) this.itemView.findViewById(e.j.a.n4)).setText(network.a().getName());
            Integer num = (Integer) this.a.f13757d.get(network.b().getBlockchain());
            if (num == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(num.intValue() == i2);
            }
            if (valueOf == null) {
                booleanValue = network.c();
            } else {
                booleanValue = valueOf.booleanValue();
            }
            ((CheckBox) this.itemView.findViewById(e.j.a.n0)).setChecked(booleanValue);
            View view = this.itemView;
            final h hVar = this.a;
            view.setOnClickListener(new View.OnClickListener() { // from class: e.j.m.a.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.a.c(kotlin.e0.c.l.this, network, hVar, i2, view2);
                }
            });
        }
    }

    /* compiled from: NetworkAdapter.kt */
    /* loaded from: classes2.dex */
    private static final class b extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
        }

        public final void a(a3 sectionHeader) {
            kotlin.jvm.internal.m.g(sectionHeader, "sectionHeader");
            ((TextView) this.itemView.findViewById(e.j.a.networkSectionHeader)).setText(sectionHeader.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(kotlin.e0.c.l<? super q2, x> onItemClickedListener) {
        kotlin.jvm.internal.m.g(onItemClickedListener, "onItemClickedListener");
        this.a = onItemClickedListener;
        this.f13755b = new ArrayList();
        this.f13756c = new LinkedHashMap();
        this.f13757d = new LinkedHashMap();
    }

    public final void c(List<? extends r2> networks) {
        kotlin.jvm.internal.m.g(networks, "networks");
        this.f13755b.clear();
        this.f13755b.addAll(networks);
        for (e0 e0Var : e.j.f.g.a(networks)) {
            int a2 = e0Var.a();
            r2 r2Var = (r2) e0Var.b();
            if (r2Var instanceof q2) {
                q2 q2Var = (q2) r2Var;
                List<Integer> list = this.f13756c.get(q2Var.b().getBlockchain());
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(Integer.valueOf(a2));
                this.f13756c.put(q2Var.b().getBlockchain(), list);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13755b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        r2 r2Var = (r2) List_CommonKt.require(this.f13755b, i2);
        if (r2Var instanceof a3) {
            return 1;
        }
        if (r2Var instanceof q2) {
            return 2;
        }
        throw new IllegalStateException("should not have item with unknown type position " + i2 + " item " + r2Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        r2 r2Var = this.f13755b.get(i2);
        if (r2Var instanceof q2) {
            ((a) holder).a((q2) r2Var, i2, this.a);
        } else if (r2Var instanceof a3) {
            ((b) holder).a((a3) r2Var);
        } else {
            throw new RuntimeException("Unknown item in NetworkAdapter: " + r2Var + " (position " + i2 + ')');
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i2 == 1) {
            View inflate = from.inflate(R.layout.list_item_network_section_title, parent, false);
            kotlin.jvm.internal.m.f(inflate, "inflater.inflate(R.layout.list_item_network_section_title, parent, false)");
            return new b(inflate);
        } else if (i2 == 2) {
            View inflate2 = from.inflate(R.layout.list_item__network, parent, false);
            kotlin.jvm.internal.m.f(inflate2, "inflater.inflate(R.layout.list_item__network, parent, false)");
            return new a(this, inflate2);
        } else {
            throw new IllegalStateException(kotlin.jvm.internal.m.o("NetworkAdapter should not have item with type ", Integer.valueOf(i2)));
        }
    }
}