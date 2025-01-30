package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.toshi.model.local.dapp.Dapp;
import com.toshi.model.local.dapp.DappCategory;
import com.toshi.model.local.dapp.DappGoogleSearch;
import com.toshi.model.local.dapp.DappListItem;
import com.toshi.model.local.dapp.DappUrl;
import java.util.ArrayList;
import java.util.List;
import kotlin.a0.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.x;
import org.toshi.R;

/* compiled from: SearchDappAdapter.kt */
/* loaded from: classes2.dex */
public final class m extends RecyclerView.g<RecyclerView.e0> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f13763b;

    /* renamed from: c  reason: collision with root package name */
    private kotlin.e0.c.l<? super String, x> f13764c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.e0.c.l<? super String, x> f13765d;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.e0.c.l<? super Dapp, x> f13766e;

    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<List<DappListItem>> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final List<DappListItem> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Dapp, x> {
        c() {
            super(1);
        }

        public final void a(Dapp it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.l<Dapp, x> i2 = m.this.i();
            if (i2 == null) {
                return;
            }
            i2.invoke(it);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Dapp dapp) {
            a(dapp);
            return x.a;
        }
    }

    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, x> {
        d() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(String str) {
            invoke2(str);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.l<String, x> j2 = m.this.j();
            if (j2 == null) {
                return;
            }
            j2.invoke(it);
        }
    }

    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, x> {
        e() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(String str) {
            invoke2(str);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.l<String, x> h2 = m.this.h();
            if (h2 == null) {
                return;
            }
            h2.invoke(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DappListItem, Boolean> {
        public static final f a = new f();

        f() {
            super(1);
        }

        public final boolean a(DappListItem it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it instanceof DappGoogleSearch;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(DappListItem dappListItem) {
            return Boolean.valueOf(a(dappListItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchDappAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DappListItem, Boolean> {
        public static final g a = new g();

        g() {
            super(1);
        }

        public final boolean a(DappListItem it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it instanceof DappUrl;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(DappListItem dappListItem) {
            return Boolean.valueOf(a(dappListItem));
        }
    }

    public m() {
        kotlin.h b2;
        b2 = kotlin.k.b(b.a);
        this.f13763b = b2;
    }

    private final void a(int i2, String str) {
        g().add(i2, new DappGoogleSearch(str));
        notifyItemChanged(i2);
    }

    private final void c(int i2, String str) {
        g().add(i2, new DappUrl(str));
        notifyDataSetChanged();
    }

    private final int e() {
        return l() ? 1 : 0;
    }

    private final int f() {
        return 0;
    }

    private final List<DappListItem> g() {
        return (List) this.f13763b.getValue();
    }

    private final boolean k() {
        int e2 = e();
        return g().size() > e2 && (g().get(e2) instanceof DappGoogleSearch);
    }

    private final boolean l() {
        int f2 = f();
        return g().size() > f2 && (g().get(f2) instanceof DappUrl);
    }

    private final void m() {
        w.D(g(), f.a);
        notifyDataSetChanged();
    }

    private final void r(int i2, String str) {
        g().set(i2, new DappGoogleSearch(str));
        notifyItemChanged(i2);
    }

    private final void s(int i2, String str) {
        g().set(i2, new DappUrl(str));
        notifyItemChanged(i2);
    }

    public final void b(String input) {
        kotlin.jvm.internal.m.g(input, "input");
        int e2 = e();
        if (input.length() > 0) {
            if (k()) {
                r(e2, input);
            } else {
                a(e2, input);
            }
        } else if (k()) {
            m();
        }
    }

    public final void d(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        int f2 = f();
        if (l()) {
            s(f2, url);
        } else {
            c(f2, url);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        DappListItem dappListItem = g().get(i2);
        if (dappListItem instanceof DappCategory) {
            return 2;
        }
        if (dappListItem instanceof DappGoogleSearch) {
            return 3;
        }
        return dappListItem instanceof DappUrl ? 4 : 1;
    }

    public final kotlin.e0.c.l<String, x> h() {
        return this.f13765d;
    }

    public final kotlin.e0.c.l<Dapp, x> i() {
        return this.f13766e;
    }

    public final kotlin.e0.c.l<String, x> j() {
        return this.f13764c;
    }

    public final void n() {
        if (l()) {
            w.D(g(), g.a);
            notifyItemRangeRemoved(0, 2);
        }
    }

    public final void o(kotlin.e0.c.l<? super String, x> lVar) {
        this.f13765d = lVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        DappListItem dappListItem = g().get(i2);
        if ((holder instanceof e.j.m.a.u.j) && (dappListItem instanceof Dapp)) {
            e.j.m.a.u.j jVar = (e.j.m.a.u.j) holder;
            Dapp dapp = (Dapp) dappListItem;
            jVar.b(dapp);
            jVar.c(dapp, new c());
        } else if ((holder instanceof e.j.m.a.u.i) && (dappListItem instanceof DappCategory)) {
            ((e.j.m.a.u.i) holder).a((DappCategory) dappListItem);
        } else {
            boolean z = holder instanceof e.j.m.a.u.g;
            if (z && (dappListItem instanceof DappGoogleSearch)) {
                e.j.m.a.u.g gVar = (e.j.m.a.u.g) holder;
                DappGoogleSearch dappGoogleSearch = (DappGoogleSearch) dappListItem;
                gVar.d(dappGoogleSearch);
                gVar.g(dappGoogleSearch, new d());
            } else if (z && (dappListItem instanceof DappUrl)) {
                e.j.m.a.u.g gVar2 = (e.j.m.a.u.g) holder;
                DappUrl dappUrl = (DappUrl) dappListItem;
                gVar2.c(dappUrl);
                gVar2.e(dappUrl, new e());
            } else {
                l.a.a.d(kotlin.jvm.internal.m.o("Invalid dapp in this context ", dappListItem), new Object[0]);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i2 == 2) {
            View view = from.inflate(R.layout.list_item__search_dapp_category, parent, false);
            kotlin.jvm.internal.m.f(view, "view");
            return new e.j.m.a.u.i(view);
        } else if (i2 != 3 && i2 != 4) {
            View view2 = from.inflate(R.layout.list_item__dapp_search, parent, false);
            kotlin.jvm.internal.m.f(view2, "view");
            return new e.j.m.a.u.j(view2);
        } else {
            View view3 = from.inflate(R.layout.list_item__dapp_url, parent, false);
            kotlin.jvm.internal.m.f(view3, "view");
            return new e.j.m.a.u.g(view3);
        }
    }

    public final void p(kotlin.e0.c.l<? super Dapp, x> lVar) {
        this.f13766e = lVar;
    }

    public final void q(kotlin.e0.c.l<? super String, x> lVar) {
        this.f13764c = lVar;
    }
}