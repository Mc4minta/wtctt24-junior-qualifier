package e.j.m.a;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.coinbase.wallet.common.extensions.List_CommonKt;
import com.coinbase.wallet.commonui.extensions.CharSequence_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.toshi.view.custom.t;
import de.hdodenhof.circleimageview.CircleImageView;
import e.j.f.y;
import e.j.n.m3;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import kotlin.a0.z;
import kotlin.x;
import org.toshi.R;

/* compiled from: SectionedCompactCoinAdapter.kt */
/* loaded from: classes2.dex */
public final class o extends RecyclerView.g<RecyclerView.e0> {
    private final Resources a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.e0.c.l<m3, x> f13768b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.e0.c.a<x> f13769c;

    /* renamed from: d  reason: collision with root package name */
    private List<? extends p> f13770d;

    /* renamed from: e  reason: collision with root package name */
    private List<? extends p> f13771e;

    /* compiled from: SectionedCompactCoinAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.e0 {
        private final View a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13772b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13773c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13774d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13775e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
            this.a = view;
            this.f13772b = androidx.core.content.a.d(view.getContext(), R.color.grey_80);
            this.f13773c = view.getResources().getDimensionPixelSize(R.dimen.avatar_size_small);
            this.f13774d = view.getResources().getDimensionPixelSize(R.dimen.avatar_text_size);
            this.f13775e = view.getResources().getDimensionPixelSize(R.dimen.avatar_text_thickness);
        }

        private final void c(String str, String str2, ImageView imageView) {
            Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).apply((BaseRequestOptions<?>) new RequestOptions().error(t.a.a().g().h(this.f13773c).d(this.f13773c).f(this.f13774d).c(this.f13775e).e().b().a(CharSequence_CommonKt.buildTickerText(str2).toString(), this.f13772b))).into(imageView);
        }

        public final void a(m3 walletCell) {
            kotlin.jvm.internal.m.g(walletCell, "walletCell");
            ((TextView) this.a.findViewById(e.j.a.coinName)).setText(walletCell.c());
            ((TextView) this.a.findViewById(e.j.a.coinCode)).setText(walletCell.b().getCode().getRawValue());
            URL imageUrl = walletCell.b().getImageUrl();
            String url = imageUrl == null ? null : imageUrl.toString();
            String rawValue = walletCell.b().getCode().getRawValue();
            CircleImageView circleImageView = (CircleImageView) this.a.findViewById(e.j.a.coinAvatar);
            kotlin.jvm.internal.m.f(circleImageView, "view.coinAvatar");
            c(url, rawValue, circleImageView);
        }

        public final View b() {
            return this.a;
        }
    }

    /* compiled from: SectionedCompactCoinAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.e0 {
        private final View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
            this.a = view;
        }

        public final View a() {
            return this.a;
        }
    }

    /* compiled from: SectionedCompactCoinAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class c extends RecyclerView.e0 {
        private final View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            kotlin.jvm.internal.m.g(view, "view");
            this.a = view;
        }

        public final void a(n title) {
            kotlin.jvm.internal.m.g(title, "title");
            View view = this.a;
            int i2 = e.j.a.sectionTitle;
            ((TextView) view.findViewById(i2)).setText(title.d());
            int n = title.c().n();
            ViewGroup.LayoutParams layoutParams = ((TextView) this.a.findViewById(i2)).getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = y.g(b(), n);
            x xVar = x.a;
            ((TextView) this.a.findViewById(i2)).setLayoutParams(marginLayoutParams);
        }

        public final View b() {
            return this.a;
        }
    }

    /* compiled from: SectionedCompactCoinAdapter.kt */
    /* loaded from: classes2.dex */
    static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m3 f13776b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(m3 m3Var) {
            super(1);
            this.f13776b = m3Var;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.l lVar = o.this.f13768b;
            if (lVar == null) {
                return;
            }
            lVar.invoke(this.f13776b);
        }
    }

    /* compiled from: SectionedCompactCoinAdapter.kt */
    /* loaded from: classes2.dex */
    static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        e() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.a aVar = o.this.f13769c;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Resources resources, kotlin.e0.c.l<? super m3, x> lVar, kotlin.e0.c.a<x> aVar) {
        List<? extends p> g2;
        List<? extends p> g3;
        kotlin.jvm.internal.m.g(resources, "resources");
        this.a = resources;
        this.f13768b = lVar;
        this.f13769c = aVar;
        g2 = kotlin.a0.r.g();
        this.f13770d = g2;
        g3 = kotlin.a0.r.g();
        this.f13771e = g3;
        setHasStableIds(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
        if (r3 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<e.j.m.a.p> d(java.lang.String r8) {
        /*
            r7 = this;
            java.util.List<? extends e.j.m.a.p> r0 = r7.f13771e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        Lb:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L43
            java.lang.Object r2 = r0.next()
            r3 = r2
            e.j.m.a.p r3 = (e.j.m.a.p) r3
            boolean r4 = r3 instanceof e.j.n.m3
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L3d
            e.j.n.m3 r3 = (e.j.n.m3) r3
            com.coinbase.wallet.wallets.models.CryptoCurrency r4 = r3.b()
            com.coinbase.wallet.blockchains.models.CurrencyCode r4 = r4.getCode()
            java.lang.String r4 = r4.getRawValue()
            boolean r4 = kotlin.l0.o.T(r4, r8, r6)
            if (r4 != 0) goto L3c
            java.lang.String r3 = r3.c()
            boolean r3 = kotlin.l0.o.T(r3, r8, r6)
            if (r3 == 0) goto L3d
        L3c:
            r5 = r6
        L3d:
            if (r5 == 0) goto Lb
            r1.add(r2)
            goto Lb
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.m.a.o.d(java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            if (r9 == 0) goto Ld
            boolean r2 = kotlin.l0.o.D(r9)
            if (r2 == 0) goto Lb
            goto Ld
        Lb:
            r2 = r0
            goto Le
        Ld:
            r2 = r1
        Le:
            if (r2 == 0) goto L15
            java.util.List<? extends e.j.m.a.p> r9 = r8.f13771e
            r8.f13770d = r9
            goto L75
        L15:
            java.util.List r9 = r8.d(r9)
            java.util.List r9 = kotlin.a0.p.K0(r9)
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L45
            e.j.m.a.n r0 = new e.j.m.a.n
            android.content.res.Resources r2 = r8.a
            r3 = 2131952180(0x7f130234, float:1.9540795E38)
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "resources.getString(R.string.no_results)"
            kotlin.jvm.internal.m.f(r2, r3)
            e.j.m.a.k r3 = e.j.m.a.k.SMALL
            r0.<init>(r2, r3)
            r9.add(r0)
            e.j.m.a.i r0 = new e.j.m.a.i
            r2 = 0
            r0.<init>(r2, r1, r2)
            r9.add(r0)
            goto L73
        L45:
            java.util.List<? extends e.j.m.a.p> r2 = r8.f13770d
            int r2 = r2.size()
            e.j.m.a.n r3 = new e.j.m.a.n
            android.content.res.Resources r4 = r8.a
            r5 = 2131820545(0x7f110001, float:1.9273808E38)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.text.NumberFormat r6 = java.text.NumberFormat.getInstance()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            java.lang.String r6 = r6.format(r7)
            r1[r0] = r6
            java.lang.String r1 = r4.getQuantityString(r5, r2, r1)
            java.lang.String r2 = "resources.getQuantityString(\n                        R.plurals.x_results,\n                        size,\n                        NumberFormat.getInstance().format(size)\n                    )"
            kotlin.jvm.internal.m.f(r1, r2)
            e.j.m.a.k r2 = e.j.m.a.k.SMALL
            r3.<init>(r1, r2)
            r9.add(r0, r3)
        L73:
            r8.f13770d = r9
        L75:
            r8.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.m.a.o.c(java.lang.String):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13770d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return this.f13771e.indexOf(this.f13770d.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        p pVar = (p) List_CommonKt.require(this.f13770d, i2);
        if (pVar instanceof m3) {
            return 2;
        }
        if (pVar instanceof n) {
            return 1;
        }
        if (pVar instanceof i) {
            return 3;
        }
        throw new IllegalStateException("should not have item which is neither WalletCompactCell nor SectionTitle");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        p pVar = this.f13770d.get(i2);
        if (pVar instanceof m3) {
            a aVar = (a) holder;
            m3 m3Var = (m3) pVar;
            View_CommonKt.setOnSingleClickListener$default(aVar.b(), 0L, new d(m3Var), 1, null);
            aVar.a(m3Var);
        } else if (pVar instanceof n) {
            ((c) holder).a((n) pVar);
        } else if (pVar instanceof i) {
            View_CommonKt.setOnSingleClickListener$default(((b) holder).a(), 0L, new e(), 1, null);
        } else {
            throw new IllegalStateException("should not have item which is neither WalletCompactCell nor SectionTitle");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i2 == 1) {
            View inflate = from.inflate(R.layout.list_item__section_title, parent, false);
            kotlin.jvm.internal.m.f(inflate, "inflater.inflate(R.layout.list_item__section_title, parent, false)");
            return new c(inflate);
        } else if (i2 == 2) {
            View inflate2 = from.inflate(R.layout.list_item__coin_compact, parent, false);
            kotlin.jvm.internal.m.f(inflate2, "inflater.inflate(R.layout.list_item__coin_compact, parent, false)");
            return new a(inflate2);
        } else if (i2 == 3) {
            View inflate3 = from.inflate(R.layout.list_item__add_any_erc20, parent, false);
            kotlin.jvm.internal.m.f(inflate3, "inflater.inflate(R.layout.list_item__add_any_erc20, parent, false)");
            return new b(inflate3);
        } else {
            throw new IllegalStateException("should not have item which is neither WalletCompactCell nor SectionTitle");
        }
    }

    public final void setItems(List<? extends p> items) {
        List<? extends p> K0;
        kotlin.jvm.internal.m.g(items, "items");
        K0 = z.K0(items);
        this.f13771e = K0;
        this.f13770d = K0;
        notifyDataSetChanged();
    }
}