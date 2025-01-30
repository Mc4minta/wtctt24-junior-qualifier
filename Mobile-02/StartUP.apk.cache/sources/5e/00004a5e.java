package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.x;
import org.toshi.R;

/* compiled from: CurrencyAdapter.kt */
/* loaded from: classes2.dex */
public final class d extends RecyclerView.g<e.j.m.a.u.f> {
    private kotlin.e0.c.l<? super FiatCurrency, x> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<FiatCurrency> f13749b;

    public /* synthetic */ d(List list, kotlin.e0.c.l lVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : lVar);
    }

    public final kotlin.e0.c.l<FiatCurrency, x> a() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public void onBindViewHolder(e.j.m.a.u.f holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        FiatCurrency fiatCurrency = this.f13749b.get(i2);
        holder.a(fiatCurrency);
        holder.b(a(), fiatCurrency);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c */
    public e.j.m.a.u.f onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__currency, parent, false);
        kotlin.jvm.internal.m.f(v, "v");
        return new e.j.m.a.u.f(v);
    }

    public final void d(List<FiatCurrency> currencies) {
        kotlin.jvm.internal.m.g(currencies, "currencies");
        this.f13749b.clear();
        if (!currencies.isEmpty()) {
            this.f13749b.addAll(currencies);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13749b.size();
    }

    public d(List<FiatCurrency> list, kotlin.e0.c.l<? super FiatCurrency, x> lVar) {
        this.a = lVar;
        ArrayList arrayList = new ArrayList();
        if (list != null && (!list.isEmpty())) {
            arrayList.addAll(list);
        }
        x xVar = x.a;
        this.f13749b = arrayList;
    }
}