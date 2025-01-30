package c.a.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.z;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {
    static final Class<?>[] a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f2562b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f2563c;

    /* renamed from: d  reason: collision with root package name */
    final Object[] f2564d;

    /* renamed from: e  reason: collision with root package name */
    Context f2565e;

    /* renamed from: f  reason: collision with root package name */
    private Object f2566f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f2567b;

        /* renamed from: c  reason: collision with root package name */
        private Method f2568c;

        public a(Object obj, String str) {
            this.f2567b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2568c = cls.getMethod(str, a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2568c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2568c.invoke(this.f2567b, menuItem)).booleanValue();
                }
                this.f2568c.invoke(this.f2567b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {
        c.h.k.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;

        /* renamed from: b  reason: collision with root package name */
        private int f2569b;

        /* renamed from: c  reason: collision with root package name */
        private int f2570c;

        /* renamed from: d  reason: collision with root package name */
        private int f2571d;

        /* renamed from: e  reason: collision with root package name */
        private int f2572e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2573f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2574g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2575h;

        /* renamed from: i  reason: collision with root package name */
        private int f2576i;

        /* renamed from: j  reason: collision with root package name */
        private int f2577j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f2578k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f2579l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f2565e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f2579l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f2565e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.a, g.this.f2563c));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            c.h.k.b bVar = this.A;
            if (bVar != null) {
                c.h.k.h.a(menuItem, bVar);
            }
            c.h.k.h.c(menuItem, this.B);
            c.h.k.h.g(menuItem, this.C);
            c.h.k.h.b(menuItem, this.n, this.o);
            c.h.k.h.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                c.h.k.h.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                c.h.k.h.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f2575h = true;
            i(this.a.add(this.f2569b, this.f2576i, this.f2577j, this.f2578k));
        }

        public SubMenu b() {
            this.f2575h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.f2569b, this.f2576i, this.f2577j, this.f2578k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f2575h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f2565e.obtainStyledAttributes(attributeSet, c.a.j.r1);
            this.f2569b = obtainStyledAttributes.getResourceId(c.a.j.t1, 0);
            this.f2570c = obtainStyledAttributes.getInt(c.a.j.v1, 0);
            this.f2571d = obtainStyledAttributes.getInt(c.a.j.w1, 0);
            this.f2572e = obtainStyledAttributes.getInt(c.a.j.x1, 0);
            this.f2573f = obtainStyledAttributes.getBoolean(c.a.j.u1, true);
            this.f2574g = obtainStyledAttributes.getBoolean(c.a.j.s1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            s0 u = s0.u(g.this.f2565e, attributeSet, c.a.j.y1);
            this.f2576i = u.n(c.a.j.B1, 0);
            this.f2577j = (u.k(c.a.j.E1, this.f2570c) & (-65536)) | (u.k(c.a.j.F1, this.f2571d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f2578k = u.p(c.a.j.G1);
            this.f2579l = u.p(c.a.j.H1);
            this.m = u.n(c.a.j.z1, 0);
            this.n = c(u.o(c.a.j.I1));
            this.o = u.k(c.a.j.P1, 4096);
            this.p = c(u.o(c.a.j.J1));
            this.q = u.k(c.a.j.T1, 4096);
            int i2 = c.a.j.K1;
            if (u.s(i2)) {
                this.r = u.a(i2, false) ? 1 : 0;
            } else {
                this.r = this.f2572e;
            }
            this.s = u.a(c.a.j.C1, false);
            this.t = u.a(c.a.j.D1, this.f2573f);
            this.u = u.a(c.a.j.A1, this.f2574g);
            this.v = u.k(c.a.j.U1, -1);
            this.z = u.o(c.a.j.L1);
            this.w = u.n(c.a.j.M1, 0);
            this.x = u.o(c.a.j.O1);
            String o = u.o(c.a.j.N1);
            this.y = o;
            boolean z = o != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (c.h.k.b) e(o, g.f2562b, g.this.f2564d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u.p(c.a.j.Q1);
            this.C = u.p(c.a.j.V1);
            int i3 = c.a.j.S1;
            if (u.s(i3)) {
                this.E = z.e(u.k(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = c.a.j.R1;
            if (u.s(i4)) {
                this.D = u.c(i4);
            } else {
                this.D = null;
            }
            u.w();
            this.f2575h = false;
        }

        public void h() {
            this.f2569b = 0;
            this.f2570c = 0;
            this.f2571d = 0;
            this.f2572e = 0;
            this.f2573f = true;
            this.f2574g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        a = clsArr;
        f2562b = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f2565e = context;
        Object[] objArr = {context};
        this.f2563c = objArr;
        this.f2564d = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r6 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r15 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r15 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r15 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r15.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r15.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r0.d() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        if (r15.a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (r15.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r15.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
        if (r15.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
        if (r15.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            c.a.o.g$b r0 = new c.a.o.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = r5
            r7 = r6
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r4
            r7 = r5
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            c.h.k.b r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.a()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = r3
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = r3
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.o.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.f2566f == null) {
            this.f2566f = a(this.f2565e);
        }
        return this.f2566f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof c.h.g.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f2565e.getResources().getLayout(i2);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}