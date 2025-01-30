package e.j.m.a.u;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.toshi.model.local.dapp.Dapp;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: SearchDappViewHolder.kt */
/* loaded from: classes2.dex */
public final class j extends RecyclerView.e0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
    }

    public static /* synthetic */ void a(kotlin.e0.c.l lVar, Dapp dapp, View view) {
        d(lVar, dapp, view);
    }

    public static final void d(kotlin.e0.c.l listener, Dapp dapp, View view) {
        m.g(listener, "$listener");
        m.g(dapp, "$dapp");
        listener.invoke(dapp);
    }

    public final void b(Dapp dapp) {
        m.g(dapp, "dapp");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(e.j.a.n4);
        String name = dapp.getName();
        if (name == null) {
            name = "";
        }
        textView.setText(name);
        TextView textView2 = (TextView) view.findViewById(e.j.a.k7);
        String url = dapp.getUrl();
        textView2.setText(url != null ? url : "");
        e.j.l.h hVar = e.j.l.h.a;
        RoundedImageView image = (RoundedImageView) view.findViewById(e.j.a.R2);
        m.f(image, "image");
        hVar.n(image, dapp.getIcon());
    }

    public final void c(final Dapp dapp, final kotlin.e0.c.l<? super Dapp, x> listener) {
        m.g(dapp, "dapp");
        m.g(listener, "listener");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.j.m.a.u.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.a(kotlin.e0.c.l.this, dapp, view);
            }
        });
    }
}