package e.j.m.a.u;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: LegalViewHolder.kt */
/* loaded from: classes2.dex */
public final class h extends RecyclerView.e0 {
    private final TextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LegalViewHolder.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements kotlin.e0.c.l<View, x> {
        final /* synthetic */ kotlin.e0.c.l<Integer, x> a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13795b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.e0.c.l<? super Integer, x> lVar, int i2) {
            super(1);
            this.a = lVar;
            this.f13795b = i2;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            kotlin.e0.c.l<Integer, x> lVar = this.a;
            if (lVar == null) {
                return;
            }
            lVar.invoke(Integer.valueOf(this.f13795b));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
        this.a = (TextView) itemView;
    }

    public final void a(String option) {
        m.g(option, "option");
        this.a.setText(option);
    }

    public final void b(int i2, kotlin.e0.c.l<? super Integer, x> lVar) {
        View itemView = this.itemView;
        m.f(itemView, "itemView");
        View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new a(lVar, i2), 1, null);
    }
}