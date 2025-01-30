package e.j.m.a;

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
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.toshi.model.local.room.Erc721Token;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.h0;
import kotlin.x;
import org.toshi.R;

/* compiled from: CollectibleAdapter.kt */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.g<a> {
    private kotlin.e0.c.p<? super Erc721Token, ? super View, x> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Erc721Token> f13744b;

    /* compiled from: CollectibleAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectibleAdapter.kt */
    /* renamed from: e.j.m.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0332b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Erc721Token f13745b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f13746c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0332b(Erc721Token erc721Token, a aVar) {
            super(1);
            this.f13745b = erc721Token;
            this.f13746c = aVar;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.p<Erc721Token, View, x> a = b.this.a();
            if (a == null) {
                return;
            }
            Erc721Token erc721Token = this.f13745b;
            ImageView imageView = (ImageView) this.f13746c.itemView.findViewById(e.j.a.imageView);
            kotlin.jvm.internal.m.f(imageView, "holder.itemView.imageView");
            a.invoke(erc721Token, imageView);
        }
    }

    public b() {
        this(null, 1, null);
    }

    public /* synthetic */ b(kotlin.e0.c.p pVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : pVar);
    }

    public final kotlin.e0.c.p<Erc721Token, View, x> a() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        Erc721Token erc721Token = this.f13744b.get(i2);
        View view = holder.itemView;
        ((TextView) view.findViewById(e.j.a.K6)).setText(erc721Token.getName());
        h0 h0Var = h0.a;
        boolean z = true;
        String format = String.format("# %s", Arrays.copyOf(new Object[]{erc721Token.getTokenId()}, 1));
        kotlin.jvm.internal.m.f(format, "java.lang.String.format(format, *args)");
        ((TextView) view.findViewById(e.j.a.A6)).setText(format);
        String image = erc721Token.getImage();
        if (image != null && image.length() != 0) {
            z = false;
        }
        if (z) {
            ((ImageView) view.findViewById(e.j.a.imageView)).setImageDrawable(null);
        } else {
            Glide.with(view.getContext()).asDrawable().load(erc721Token.getImage()).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.collectible_empty)).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.collectible_empty)).into((ImageView) view.findViewById(e.j.a.imageView));
        }
        ((ImageView) view.findViewById(e.j.a.imageView)).setTransitionName(kotlin.jvm.internal.m.o("Collectible-", Integer.valueOf(i2)));
        view.setId(View.generateViewId());
        kotlin.jvm.internal.m.f(view, "");
        View_CommonKt.setOnSingleClickListener$default(view, 0L, new C0332b(erc721Token, holder), 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__collectible, parent, false);
        kotlin.jvm.internal.m.f(v, "v");
        return new a(v);
    }

    public final void d(List<Erc721Token> collectibles) {
        kotlin.jvm.internal.m.g(collectibles, "collectibles");
        this.f13744b.clear();
        if (!collectibles.isEmpty()) {
            this.f13744b.addAll(collectibles);
        }
        notifyDataSetChanged();
    }

    public final void e(kotlin.e0.c.p<? super Erc721Token, ? super View, x> pVar) {
        this.a = pVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13744b.size();
    }

    public b(kotlin.e0.c.p<? super Erc721Token, ? super View, x> pVar) {
        this.a = pVar;
        this.f13744b = new ArrayList();
    }
}