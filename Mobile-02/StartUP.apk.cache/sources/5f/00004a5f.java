package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.x;
import org.toshi.R;

/* compiled from: LegalAdapter.kt */
/* loaded from: classes2.dex */
public final class e extends RecyclerView.g<e.j.m.a.u.h> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f13750b;

    /* renamed from: c  reason: collision with root package name */
    private kotlin.e0.c.l<? super Integer, x> f13751c;

    /* compiled from: LegalAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(List<String> legalOptions) {
        kotlin.jvm.internal.m.g(legalOptions, "legalOptions");
        this.f13750b = legalOptions;
    }

    public final kotlin.e0.c.l<Integer, x> a() {
        return this.f13751c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public void onBindViewHolder(e.j.m.a.u.h holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        holder.a(this.f13750b.get(i2));
        holder.b(i2, a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c */
    public e.j.m.a.u.h onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__legal, parent, false);
        kotlin.jvm.internal.m.f(v, "v");
        return new e.j.m.a.u.h(v);
    }

    public final void d(kotlin.e0.c.l<? super Integer, x> lVar) {
        this.f13751c = lVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13750b.size();
    }
}