package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.x;
import org.toshi.R;

/* compiled from: SuggestionAdapter.kt */
/* loaded from: classes2.dex */
public final class q extends RecyclerView.g<e.j.m.a.u.k> {
    private final List<String> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private kotlin.e0.c.l<? super String, x> f13777b;

    public final kotlin.e0.c.l<String, x> a() {
        return this.f13777b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public void onBindViewHolder(e.j.m.a.u.k holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        String str = this.a.get(i2);
        holder.d(str);
        holder.b(a(), str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c */
    public e.j.m.a.u.k onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__suggestion, parent, false);
        kotlin.jvm.internal.m.f(itemView, "itemView");
        return new e.j.m.a.u.k(itemView);
    }

    public final void d(kotlin.e0.c.l<? super String, x> lVar) {
        this.f13777b = lVar;
    }

    public final void e(List<String> newSuggestions) {
        kotlin.jvm.internal.m.g(newSuggestions, "newSuggestions");
        this.a.clear();
        this.a.addAll(newSuggestions);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.a.size();
    }
}