package e.j.m.a.u;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: CurrencyViewHolder.kt */
/* loaded from: classes2.dex */
public final class f extends RecyclerView.e0 {
    private final TextView a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13792b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13793c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CurrencyViewHolder.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements kotlin.e0.c.l<View, x> {
        final /* synthetic */ kotlin.e0.c.l<FiatCurrency, x> a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FiatCurrency f13794b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.e0.c.l<? super FiatCurrency, x> lVar, FiatCurrency fiatCurrency) {
            super(1);
            this.a = lVar;
            this.f13794b = fiatCurrency;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            kotlin.e0.c.l<FiatCurrency, x> lVar = this.a;
            if (lVar == null) {
                return;
            }
            lVar.invoke(this.f13794b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.currency);
        m.f(findViewById, "itemView.findViewById(R.id.currency)");
        this.a = (TextView) findViewById;
        this.f13792b = itemView.getResources().getDimension(R.dimen.text_size_subtitle);
        Context context = itemView.getContext();
        m.f(context, "itemView.context");
        this.f13793c = e.j.f.h.f(context, R.color.textColorPrimary);
    }

    public final void a(FiatCurrency currency) {
        m.g(currency, "currency");
        TextView textView = this.a;
        textView.setTextSize(0, this.f13792b);
        textView.setTextColor(this.f13793c);
        textView.setText(this.itemView.getResources().getString(R.string.currency_name_code_format, currency.getName(), currency.getCode().getRawValue()));
    }

    public final void b(kotlin.e0.c.l<? super FiatCurrency, x> lVar, FiatCurrency currency) {
        m.g(currency, "currency");
        View itemView = this.itemView;
        m.f(itemView, "itemView");
        View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new a(lVar, currency), 1, null);
    }
}