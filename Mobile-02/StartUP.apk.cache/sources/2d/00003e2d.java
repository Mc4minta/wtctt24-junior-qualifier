package com.journeyapps.barcodescanner.q;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.n;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: PreviewScalingStrategy.java */
/* loaded from: classes2.dex */
public abstract class l {
    private static final String a = "l";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreviewScalingStrategy.java */
    /* loaded from: classes2.dex */
    public class a implements Comparator<n> {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(n nVar, n nVar2) {
            return Float.compare(l.this.c(nVar2, this.a), l.this.c(nVar, this.a));
        }
    }

    public List<n> a(List<n> list, n nVar) {
        if (nVar == null) {
            return list;
        }
        Collections.sort(list, new a(nVar));
        return list;
    }

    public n b(List<n> list, n nVar) {
        List<n> a2 = a(list, nVar);
        String str = a;
        Log.i(str, "Viewfinder size: " + nVar);
        Log.i(str, "Preview in order of preference: " + a2);
        return a2.get(0);
    }

    protected abstract float c(n nVar, n nVar2);

    public abstract Rect d(n nVar, n nVar2);
}