package androidx.lifecycle;

import androidx.lifecycle.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements m {
    private final g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(g gVar) {
        this.a = gVar;
    }

    @Override // androidx.lifecycle.m
    public void c(o oVar, i.a aVar) {
        this.a.a(oVar, aVar, false, null);
        this.a.a(oVar, aVar, true, null);
    }
}