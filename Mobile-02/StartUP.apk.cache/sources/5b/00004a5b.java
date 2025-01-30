package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.toshi.model.local.room.CollectibleType;
import java.util.List;
import kotlin.x;
import org.toshi.R;

/* compiled from: CollectibleTypeAdapter.kt */
/* loaded from: classes2.dex */
public final class c extends RecyclerView.g<a> {
    private final List<CollectibleType> a;

    /* renamed from: b  reason: collision with root package name */
    private kotlin.e0.c.l<? super CollectibleType, x> f13747b;

    /* compiled from: CollectibleTypeAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectibleTypeAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CollectibleType f13748b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CollectibleType collectibleType) {
            super(1);
            this.f13748b = collectibleType;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            kotlin.e0.c.l<CollectibleType, x> a = c.this.a();
            if (a == null) {
                return;
            }
            a.invoke(this.f13748b);
        }
    }

    public c(List<CollectibleType> collectibleTypes) {
        kotlin.jvm.internal.m.g(collectibleTypes, "collectibleTypes");
        this.a = collectibleTypes;
    }

    public final kotlin.e0.c.l<CollectibleType, x> a() {
        return this.f13747b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        CollectibleType collectibleType = this.a.get(i2);
        View view = holder.itemView;
        kotlin.jvm.internal.m.f(view, "holder.itemView");
        View_CommonKt.setOnSingleClickListener$default(view, 0L, new b(collectibleType), 1, null);
        ((TextView) holder.itemView.findViewById(e.j.a.collectibleDesc)).setText(e.j.l.l.a.a(collectibleType.getCount(), "NFT"));
        ((TextView) holder.itemView.findViewById(e.j.a.collectibleName)).setText(collectibleType.getName());
        Glide.with(holder.itemView.getContext()).asDrawable().load(collectibleType.getImage()).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.collectible_empty)).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.collectible_empty)).into((ImageView) holder.itemView.findViewById(e.j.a.collectibleAvatar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item__collectible_types, parent, false);
        kotlin.jvm.internal.m.f(v, "v");
        return new a(v);
    }

    public final void d(List<CollectibleType> collectibles) {
        kotlin.jvm.internal.m.g(collectibles, "collectibles");
        List<CollectibleType> list = this.a;
        list.clear();
        list.addAll(collectibles);
        notifyDataSetChanged();
    }

    public final void e(kotlin.e0.c.l<? super CollectibleType, x> lVar) {
        this.f13747b = lVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.a.size();
    }
}