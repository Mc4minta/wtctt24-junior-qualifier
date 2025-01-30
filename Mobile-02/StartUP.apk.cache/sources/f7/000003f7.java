package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: b  reason: collision with root package name */
    int f2190b;

    /* renamed from: c  reason: collision with root package name */
    int f2191c;

    /* renamed from: d  reason: collision with root package name */
    int f2192d;

    /* renamed from: e  reason: collision with root package name */
    int f2193e;

    /* renamed from: h  reason: collision with root package name */
    boolean f2196h;

    /* renamed from: i  reason: collision with root package name */
    boolean f2197i;
    boolean a = true;

    /* renamed from: f  reason: collision with root package name */
    int f2194f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f2195g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.b0 b0Var) {
        int i2 = this.f2191c;
        return i2 >= 0 && i2 < b0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o = vVar.o(this.f2191c);
        this.f2191c += this.f2192d;
        return o;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2190b + ", mCurrentPosition=" + this.f2191c + ", mItemDirection=" + this.f2192d + ", mLayoutDirection=" + this.f2193e + ", mStartLine=" + this.f2194f + ", mEndLine=" + this.f2195g + '}';
    }
}