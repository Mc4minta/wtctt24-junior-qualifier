package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import e.j.f.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: RecoveryPhraseAdapter.kt */
/* loaded from: classes2.dex */
public final class l extends RecyclerView.g<a> {
    private final List<String> a;

    /* compiled from: RecoveryPhraseAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
        }

        public final void a(String word, int i2) {
            kotlin.jvm.internal.m.g(word, "word");
            ((TextView) this.itemView.findViewById(e.j.a.mnemonicWordPosition)).setText(String.valueOf(i2 + 1));
            ((TextView) this.itemView.findViewById(e.j.a.mnemonicWord)).setText(word);
        }
    }

    public l() {
        this(null, 1, null);
    }

    public /* synthetic */ l(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        holder.a(this.a.get(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__backup_phrase, parent, false);
        kotlin.jvm.internal.m.f(v, "v");
        y.a(v);
        return new a(v);
    }

    public final void c(List<String> recoveryPhrase) {
        kotlin.jvm.internal.m.g(recoveryPhrase, "recoveryPhrase");
        this.a.clear();
        this.a.addAll(recoveryPhrase);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.a.size();
    }

    public l(List<String> recoveryPhrase) {
        kotlin.jvm.internal.m.g(recoveryPhrase, "recoveryPhrase");
        this.a = recoveryPhrase;
    }
}