package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
import c.h.k.v;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class l {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final g f628b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f629c;

    /* renamed from: d  reason: collision with root package name */
    private final int f630d;

    /* renamed from: e  reason: collision with root package name */
    private final int f631e;

    /* renamed from: f  reason: collision with root package name */
    private View f632f;

    /* renamed from: g  reason: collision with root package name */
    private int f633g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f634h;

    /* renamed from: i  reason: collision with root package name */
    private m.a f635i;

    /* renamed from: j  reason: collision with root package name */
    private k f636j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f637k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f638l;

    /* compiled from: MenuPopupHelper.java */
    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2) {
        this(context, gVar, view, z, i2, 0);
    }

    private k a() {
        k qVar;
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(c.a.d.f2439c)) {
            qVar = new d(this.a, this.f632f, this.f630d, this.f631e, this.f629c);
        } else {
            qVar = new q(this.a, this.f628b, this.f632f, this.f630d, this.f631e, this.f629c);
        }
        qVar.n(this.f628b);
        qVar.w(this.f638l);
        qVar.r(this.f632f);
        qVar.g(this.f635i);
        qVar.t(this.f634h);
        qVar.u(this.f633g);
        return qVar;
    }

    private void l(int i2, int i3, boolean z, boolean z2) {
        k c2 = c();
        c2.x(z2);
        if (z) {
            if ((c.h.k.d.b(this.f633g, v.y(this.f632f)) & 7) == 5) {
                i2 -= this.f632f.getWidth();
            }
            c2.v(i2);
            c2.y(i3);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.s(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        c2.h();
    }

    public void b() {
        if (d()) {
            this.f636j.dismiss();
        }
    }

    public k c() {
        if (this.f636j == null) {
            this.f636j = a();
        }
        return this.f636j;
    }

    public boolean d() {
        k kVar = this.f636j;
        return kVar != null && kVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f636j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f637k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f632f = view;
    }

    public void g(boolean z) {
        this.f634h = z;
        k kVar = this.f636j;
        if (kVar != null) {
            kVar.t(z);
        }
    }

    public void h(int i2) {
        this.f633g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f637k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f635i = aVar;
        k kVar = this.f636j;
        if (kVar != null) {
            kVar.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f632f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f632f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f633g = 8388611;
        this.f638l = new a();
        this.a = context;
        this.f628b = gVar;
        this.f632f = view;
        this.f629c = z;
        this.f630d = i2;
        this.f631e = i3;
    }
}