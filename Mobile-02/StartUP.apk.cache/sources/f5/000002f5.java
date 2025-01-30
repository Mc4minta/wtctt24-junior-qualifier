package androidx.lifecycle;

import androidx.lifecycle.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements m {
    private final g[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(g[] gVarArr) {
        this.a = gVarArr;
    }

    @Override // androidx.lifecycle.m
    public void c(o oVar, i.a aVar) {
        t tVar = new t();
        for (g gVar : this.a) {
            gVar.a(oVar, aVar, false, tVar);
        }
        for (g gVar2 : this.a) {
            gVar2.a(oVar, aVar, true, tVar);
        }
    }
}