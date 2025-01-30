package androidx.fragment.app;

import androidx.lifecycle.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public class y implements androidx.lifecycle.o {
    private androidx.lifecycle.p a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i.a aVar) {
        this.a.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.a == null) {
            this.a = new androidx.lifecycle.p(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.a != null;
    }

    @Override // androidx.lifecycle.o
    public androidx.lifecycle.i getLifecycle() {
        b();
        return this.a;
    }
}