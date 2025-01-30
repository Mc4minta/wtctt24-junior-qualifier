package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: AdapterListUpdateCallback.java */
/* loaded from: classes.dex */
public final class b implements n {
    private final RecyclerView.g a;

    public b(RecyclerView.g gVar) {
        this.a = gVar;
    }

    @Override // androidx.recyclerview.widget.n
    public void a(int i2, int i3) {
        this.a.notifyItemMoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n
    public void b(int i2, int i3) {
        this.a.notifyItemRangeInserted(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n
    public void c(int i2, int i3) {
        this.a.notifyItemRangeRemoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.n
    public void d(int i2, int i3, Object obj) {
        this.a.notifyItemRangeChanged(i2, i3, obj);
    }
}