package e.j.m.a.u;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: SuggestionViewHolder.kt */
/* loaded from: classes2.dex */
public final class k extends RecyclerView.e0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
    }

    public static /* synthetic */ void a(kotlin.e0.c.l lVar, String str, View view) {
        c(lVar, str, view);
    }

    public static final void c(kotlin.e0.c.l lVar, String suggestion, View view) {
        m.g(suggestion, "$suggestion");
        if (lVar == null) {
            return;
        }
        lVar.invoke(suggestion);
    }

    public final void b(final kotlin.e0.c.l<? super String, x> lVar, final String suggestion) {
        m.g(suggestion, "suggestion");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.j.m.a.u.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.a(kotlin.e0.c.l.this, suggestion, view);
            }
        });
    }

    public final void d(String suggestion) {
        m.g(suggestion, "suggestion");
        View view = this.itemView;
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        textView.setText(suggestion);
    }
}