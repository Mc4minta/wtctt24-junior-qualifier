package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class b implements m {
    protected Context a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f554b;

    /* renamed from: c  reason: collision with root package name */
    protected g f555c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f556d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f557e;

    /* renamed from: f  reason: collision with root package name */
    private m.a f558f;

    /* renamed from: g  reason: collision with root package name */
    private int f559g;

    /* renamed from: h  reason: collision with root package name */
    private int f560h;

    /* renamed from: j  reason: collision with root package name */
    protected n f561j;

    /* renamed from: k  reason: collision with root package name */
    private int f562k;

    public b(Context context, int i2, int i3) {
        this.a = context;
        this.f556d = LayoutInflater.from(context);
        this.f559g = i2;
        this.f560h = i3;
    }

    protected void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f561j).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.f558f;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f561j;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f555c;
        int i2 = 0;
        if (gVar != null) {
            gVar.t();
            ArrayList<i> G = this.f555c.G();
            int size = G.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = G.get(i4);
                if (s(i3, iVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View p = p(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        p.setPressed(false);
                        p.jumpDrawablesToCurrentState();
                    }
                    if (p != childAt) {
                        a(p, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!n(viewGroup, i2)) {
                i2++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(m.a aVar) {
        this.f558f = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.f562k;
    }

    public abstract void h(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void i(Context context, g gVar) {
        this.f554b = context;
        this.f557e = LayoutInflater.from(context);
        this.f555c = gVar;
    }

    public n.a k(ViewGroup viewGroup) {
        return (n.a) this.f556d.inflate(this.f560h, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.g] */
    @Override // androidx.appcompat.view.menu.m
    public boolean l(r rVar) {
        m.a aVar = this.f558f;
        r rVar2 = rVar;
        if (aVar != null) {
            if (rVar == null) {
                rVar2 = this.f555c;
            }
            return aVar.c(rVar2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public m.a o() {
        return this.f558f;
    }

    public View p(i iVar, View view, ViewGroup viewGroup) {
        n.a k2;
        if (view instanceof n.a) {
            k2 = (n.a) view;
        } else {
            k2 = k(viewGroup);
        }
        h(iVar, k2);
        return (View) k2;
    }

    public n q(ViewGroup viewGroup) {
        if (this.f561j == null) {
            n nVar = (n) this.f556d.inflate(this.f559g, viewGroup, false);
            this.f561j = nVar;
            nVar.b(this.f555c);
            c(true);
        }
        return this.f561j;
    }

    public void r(int i2) {
        this.f562k = i2;
    }

    public abstract boolean s(int i2, i iVar);
}