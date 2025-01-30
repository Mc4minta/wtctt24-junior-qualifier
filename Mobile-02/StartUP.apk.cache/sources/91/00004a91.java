package e.j.m.a.u;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.blockchains.models.Address;
import com.toshi.view.custom.CollapsingTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: WalletViewHolder.kt */
/* loaded from: classes2.dex */
public final class l extends RecyclerView.e0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
    }

    public static /* synthetic */ void a(l lVar, kotlin.e0.c.l lVar2, int i2, View view) {
        c(lVar, lVar2, i2, view);
    }

    public static final void c(l this$0, kotlin.e0.c.l listener, int i2, View view) {
        m.g(this$0, "this$0");
        m.g(listener, "$listener");
        this$0.g();
        listener.invoke(Integer.valueOf(i2));
    }

    private final void g() {
        View view = this.itemView;
        int i2 = e.j.a.n0;
        ((CheckBox) view.findViewById(i2)).setChecked(!((CheckBox) this.itemView.findViewById(i2)).isChecked());
    }

    public final void b(final int i2, final kotlin.e0.c.l<? super Integer, x> listener) {
        m.g(listener, "listener");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: e.j.m.a.u.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.a(l.this, listener, i2, view);
            }
        });
    }

    public final void d() {
        ((CheckBox) this.itemView.findViewById(e.j.a.n0)).setChecked(true);
    }

    public final void e() {
        ((CheckBox) this.itemView.findViewById(e.j.a.n0)).setChecked(false);
    }

    public final void f(Address address) {
        m.g(address, "address");
        View view = this.itemView;
        ((TextView) view.findViewById(e.j.a.n4)).setText(view.getContext().getString(R.string.active_wallet_name, Integer.valueOf(address.getIndex() + 1)));
        ((CollapsingTextView) view.findViewById(e.j.a.paymentAddress)).setCollapsedText(address.getAddress());
        e.j.l.h.a.l(address.getAddress(), (CircleImageView) view.findViewById(e.j.a.avatar));
    }
}