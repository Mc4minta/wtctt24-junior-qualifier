package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.blockchains.models.Address;
import java.util.ArrayList;
import java.util.List;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletAdapter.kt */
/* loaded from: classes2.dex */
public final class r extends RecyclerView.g<e.j.m.a.u.l> {
    private final kotlin.e0.c.l<Address, x> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Address> f13778b;

    /* renamed from: c  reason: collision with root package name */
    private int f13779c;

    /* renamed from: d  reason: collision with root package name */
    private int f13780d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WalletAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Integer, x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13781b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Address f13782c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, Address address) {
            super(1);
            this.f13781b = i2;
            this.f13782c = address;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Integer num) {
            invoke(num.intValue());
            return x.a;
        }

        public final void invoke(int i2) {
            r.this.c(this.f13781b);
            r.this.a.invoke(this.f13782c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(kotlin.e0.c.l<? super Address, x> onItemClickedListener) {
        kotlin.jvm.internal.m.g(onItemClickedListener, "onItemClickedListener");
        this.a = onItemClickedListener;
        this.f13778b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i2) {
        int i3 = this.f13779c;
        this.f13780d = i3;
        this.f13779c = i2;
        notifyItemChanged(i3);
        notifyItemChanged(this.f13779c);
    }

    private final void f(int i2) {
        this.f13779c = i2;
        this.f13780d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d */
    public void onBindViewHolder(e.j.m.a.u.l holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        Address address = this.f13778b.get(i2);
        boolean z = this.f13779c == i2;
        holder.f(address);
        if (z) {
            holder.d();
        } else {
            holder.e();
        }
        holder.b(i2, new a(i2, address));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: e */
    public e.j.m.a.u.l onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__wallet, parent, false);
        kotlin.jvm.internal.m.f(view, "view");
        return new e.j.m.a.u.l(view);
    }

    public final void g(List<Address> addresses, int i2) {
        kotlin.jvm.internal.m.g(addresses, "addresses");
        this.f13778b.clear();
        this.f13778b.addAll(addresses);
        f(i2);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13778b.size();
    }
}