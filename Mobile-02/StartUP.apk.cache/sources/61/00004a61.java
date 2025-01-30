package e.j.m.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.toshi.model.local.Library;
import java.util.List;
import kotlin.x;
import org.toshi.R;

/* compiled from: LibraryAdapter.kt */
/* loaded from: classes2.dex */
public final class f extends RecyclerView.g<a> {
    private final List<Library> a;

    /* renamed from: b  reason: collision with root package name */
    private kotlin.e0.c.l<? super Library, x> f13752b;

    /* compiled from: LibraryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.e0 {
        private final TextView a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LibraryAdapter.kt */
        /* renamed from: e.j.m.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0333a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
            final /* synthetic */ kotlin.e0.c.l<Library, x> a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Library f13753b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0333a(kotlin.e0.c.l<? super Library, x> lVar, Library library) {
                super(1);
                this.a = lVar;
                this.f13753b = library;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(View view) {
                invoke2(view);
                return x.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                kotlin.jvm.internal.m.g(it, "it");
                kotlin.e0.c.l<Library, x> lVar = this.a;
                if (lVar == null) {
                    return;
                }
                lVar.invoke(this.f13753b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.m.g(itemView, "itemView");
            this.a = (TextView) itemView;
        }

        public final void a(Library library) {
            kotlin.jvm.internal.m.g(library, "library");
            this.a.setText(library.getName());
        }

        public final void b(kotlin.e0.c.l<? super Library, x> lVar, Library library) {
            kotlin.jvm.internal.m.g(library, "library");
            View itemView = this.itemView;
            kotlin.jvm.internal.m.f(itemView, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView, 0L, new C0333a(lVar, library), 1, null);
        }
    }

    public f(List<Library> libraries, kotlin.e0.c.l<? super Library, x> lVar) {
        kotlin.jvm.internal.m.g(libraries, "libraries");
        this.a = libraries;
        this.f13752b = lVar;
    }

    public final kotlin.e0.c.l<Library, x> a() {
        return this.f13752b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.m.g(holder, "holder");
        Library library = this.a.get(i2);
        holder.a(library);
        holder.b(a(), library);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__library, parent, false);
        kotlin.jvm.internal.m.f(v, "v");
        return new a(v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.a.size();
    }
}