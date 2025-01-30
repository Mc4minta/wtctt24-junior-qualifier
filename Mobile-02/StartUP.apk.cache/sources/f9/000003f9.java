package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.h;
import java.util.List;

/* compiled from: ListAdapter.java */
/* loaded from: classes.dex */
public abstract class m<T, VH extends RecyclerView.e0> extends RecyclerView.g<VH> {
    final d<T> mDiffer;
    private final d.b<T> mListener;

    /* compiled from: ListAdapter.java */
    /* loaded from: classes.dex */
    class a implements d.b<T> {
        a() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public void a(List<T> list, List<T> list2) {
            m.this.onCurrentListChanged(list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m(h.d<T> dVar) {
        a aVar = new a();
        this.mListener = aVar;
        d<T> dVar2 = new d<>(new b(this), new c.a(dVar).a());
        this.mDiffer = dVar2;
        dVar2.a(aVar);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T getItem(int i2) {
        return this.mDiffer.b().get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.mDiffer.b().size();
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    public void submitList(List<T> list) {
        this.mDiffer.e(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.f(list, runnable);
    }

    protected m(c<T> cVar) {
        a aVar = new a();
        this.mListener = aVar;
        d<T> dVar = new d<>(new b(this), cVar);
        this.mDiffer = dVar;
        dVar.a(aVar);
    }
}