package e.j.m.a.u;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.toshi.model.local.dapp.DappGoogleSearch;
import com.toshi.model.local.dapp.DappUrl;
import e.j.f.y;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: DappUrlViewHolder.kt */
/* loaded from: classes2.dex */
public final class g extends RecyclerView.e0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
    }

    public static /* synthetic */ void a(kotlin.e0.c.l lVar, DappGoogleSearch dappGoogleSearch, View view) {
        h(lVar, dappGoogleSearch, view);
    }

    public static /* synthetic */ void b(kotlin.e0.c.l lVar, DappUrl dappUrl, View view) {
        f(lVar, dappUrl, view);
    }

    public static final void f(kotlin.e0.c.l listener, DappUrl dappUrl, View view) {
        m.g(listener, "$listener");
        m.g(dappUrl, "$dappUrl");
        listener.invoke(dappUrl.getUrl());
    }

    public static final void h(kotlin.e0.c.l listener, DappGoogleSearch searchItem, View view) {
        m.g(listener, "$listener");
        m.g(searchItem, "$searchItem");
        listener.invoke(searchItem.getSearchValue());
    }

    public final void c(DappUrl dappUrl) {
        m.g(dappUrl, "dappUrl");
        View view = this.itemView;
        int i2 = e.j.a.query;
        m.f(view, "");
        ((TextView) view.findViewById(i2)).setTextColor(y.b(view, R.color.colorPrimary));
        ((TextView) view.findViewById(i2)).setText(y.e(view, R.string.value_with_space_at_end, dappUrl.getUrl()));
        TextView postfix = (TextView) view.findViewById(e.j.a.postfix);
        m.f(postfix, "postfix");
        postfix.setVisibility(8);
    }

    public final void d(DappGoogleSearch searchItem) {
        m.g(searchItem, "searchItem");
        View view = this.itemView;
        int i2 = e.j.a.query;
        m.f(view, "");
        ((TextView) view.findViewById(i2)).setTextColor(y.b(view, R.color.textColorPrimary));
        ((TextView) view.findViewById(i2)).setText(y.e(view, R.string.value_with_space_at_end, searchItem.getSearchValue()));
        TextView postfix = (TextView) view.findViewById(e.j.a.postfix);
        m.f(postfix, "postfix");
        postfix.setVisibility(0);
    }

    public final void e(final DappUrl dappUrl, final kotlin.e0.c.l<? super String, x> listener) {
        m.g(dappUrl, "dappUrl");
        m.g(listener, "listener");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.j.m.a.u.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.b(kotlin.e0.c.l.this, dappUrl, view);
            }
        });
    }

    public final void g(final DappGoogleSearch searchItem, final kotlin.e0.c.l<? super String, x> listener) {
        m.g(searchItem, "searchItem");
        m.g(listener, "listener");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.j.m.a.u.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.a(kotlin.e0.c.l.this, searchItem, view);
            }
        });
    }
}