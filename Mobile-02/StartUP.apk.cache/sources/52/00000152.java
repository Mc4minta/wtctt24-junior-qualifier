package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.content.d.f;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
class u {
    private final TextView a;

    /* renamed from: b  reason: collision with root package name */
    private q0 f909b;

    /* renamed from: c  reason: collision with root package name */
    private q0 f910c;

    /* renamed from: d  reason: collision with root package name */
    private q0 f911d;

    /* renamed from: e  reason: collision with root package name */
    private q0 f912e;

    /* renamed from: f  reason: collision with root package name */
    private q0 f913f;

    /* renamed from: g  reason: collision with root package name */
    private q0 f914g;

    /* renamed from: h  reason: collision with root package name */
    private q0 f915h;

    /* renamed from: i  reason: collision with root package name */
    private final v f916i;

    /* renamed from: j  reason: collision with root package name */
    private int f917j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f918k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f919l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatTextHelper.java */
    /* loaded from: classes.dex */
    public class a extends f.a {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f920b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f921c;

        a(int i2, int i3, WeakReference weakReference) {
            this.a = i2;
            this.f920b = i3;
            this.f921c = weakReference;
        }

        @Override // androidx.core.content.d.f.a
        public void d(int i2) {
        }

        @Override // androidx.core.content.d.f.a
        public void e(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.f920b & 2) != 0);
            }
            u.this.n(this.f921c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TextView textView) {
        this.a = textView;
        this.f916i = new v(textView);
    }

    private void A(int i2, float f2) {
        this.f916i.y(i2, f2);
    }

    private void B(Context context, s0 s0Var) {
        String o;
        this.f917j = s0Var.k(c.a.j.a3, this.f917j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int k2 = s0Var.k(c.a.j.j3, -1);
            this.f918k = k2;
            if (k2 != -1) {
                this.f917j = (this.f917j & 2) | 0;
            }
        }
        int i3 = c.a.j.i3;
        if (!s0Var.s(i3) && !s0Var.s(c.a.j.k3)) {
            int i4 = c.a.j.Z2;
            if (s0Var.s(i4)) {
                this.m = false;
                int k3 = s0Var.k(i4, 1);
                if (k3 == 1) {
                    this.f919l = Typeface.SANS_SERIF;
                    return;
                } else if (k3 == 2) {
                    this.f919l = Typeface.SERIF;
                    return;
                } else if (k3 != 3) {
                    return;
                } else {
                    this.f919l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f919l = null;
        int i5 = c.a.j.k3;
        if (s0Var.s(i5)) {
            i3 = i5;
        }
        int i6 = this.f918k;
        int i7 = this.f917j;
        if (!context.isRestricted()) {
            try {
                Typeface j2 = s0Var.j(i3, this.f917j, new a(i6, i7, new WeakReference(this.a)));
                if (j2 != null) {
                    if (i2 >= 28 && this.f918k != -1) {
                        this.f919l = Typeface.create(Typeface.create(j2, 0), this.f918k, (this.f917j & 2) != 0);
                    } else {
                        this.f919l = j2;
                    }
                }
                this.m = this.f919l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f919l != null || (o = s0Var.o(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && this.f918k != -1) {
            this.f919l = Typeface.create(Typeface.create(o, 0), this.f918k, (this.f917j & 2) != 0);
        } else {
            this.f919l = Typeface.create(o, this.f917j);
        }
    }

    private void a(Drawable drawable, q0 q0Var) {
        if (drawable == null || q0Var == null) {
            return;
        }
        h.i(drawable, q0Var, this.a.getDrawableState());
    }

    private static q0 d(Context context, h hVar, int i2) {
        ColorStateList f2 = hVar.f(context, i2);
        if (f2 != null) {
            q0 q0Var = new q0();
            q0Var.f876d = true;
            q0Var.a = f2;
            return q0Var;
        }
        return null;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
        } else {
            if (i2 >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                    TextView textView2 = this.a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            TextView textView3 = this.a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void y() {
        q0 q0Var = this.f915h;
        this.f909b = q0Var;
        this.f910c = q0Var;
        this.f911d = q0Var;
        this.f912e = q0Var;
        this.f913f = q0Var;
        this.f914g = q0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f909b != null || this.f910c != null || this.f911d != null || this.f912e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.f909b);
            a(compoundDrawables[1], this.f910c);
            a(compoundDrawables[2], this.f911d);
            a(compoundDrawables[3], this.f912e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f913f == null && this.f914g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f913f);
            a(compoundDrawablesRelative[2], this.f914g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f916i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f916i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f916i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f916i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f916i.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f916i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        q0 q0Var = this.f915h;
        if (q0Var != null) {
            return q0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        q0 q0Var = this.f915h;
        if (q0Var != null) {
            return q0Var.f874b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f916i.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c5 A[ADDED_TO_REGION] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.f919l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f917j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z, int i2, int i3, int i4, int i5) {
        if (androidx.core.widget.b.f1574i) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i2) {
        String o;
        ColorStateList c2;
        s0 t = s0.t(context, i2, c.a.j.X2);
        int i3 = c.a.j.m3;
        if (t.s(i3)) {
            r(t.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = c.a.j.b3;
            if (t.s(i5) && (c2 = t.c(i5)) != null) {
                this.a.setTextColor(c2);
            }
        }
        int i6 = c.a.j.Y2;
        if (t.s(i6) && t.f(i6, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        B(context, t);
        if (i4 >= 26) {
            int i7 = c.a.j.l3;
            if (t.s(i7) && (o = t.o(i7)) != null) {
                this.a.setFontVariationSettings(o);
            }
        }
        t.w();
        Typeface typeface = this.f919l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.f917j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f916i.u(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i2) throws IllegalArgumentException {
        this.f916i.v(iArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i2) {
        this.f916i.w(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.f915h == null) {
            this.f915h = new q0();
        }
        q0 q0Var = this.f915h;
        q0Var.a = colorStateList;
        q0Var.f876d = colorStateList != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.f915h == null) {
            this.f915h = new q0();
        }
        q0 q0Var = this.f915h;
        q0Var.f874b = mode;
        q0Var.f875c = mode != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i2, float f2) {
        if (androidx.core.widget.b.f1574i || l()) {
            return;
        }
        A(i2, f2);
    }
}