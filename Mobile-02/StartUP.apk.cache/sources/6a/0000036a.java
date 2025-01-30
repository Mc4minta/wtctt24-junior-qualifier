package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: NavDestination.java */
/* loaded from: classes.dex */
public class k {
    private static final HashMap<String, Class<?>> a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final String f1900b;

    /* renamed from: c  reason: collision with root package name */
    private l f1901c;

    /* renamed from: d  reason: collision with root package name */
    private int f1902d;

    /* renamed from: e  reason: collision with root package name */
    private String f1903e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f1904f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<h> f1905g;

    /* renamed from: h  reason: collision with root package name */
    private c.e.h<c> f1906h;

    /* renamed from: j  reason: collision with root package name */
    private HashMap<String, d> f1907j;

    /* compiled from: NavDestination.java */
    /* loaded from: classes.dex */
    static class a implements Comparable<a> {
        private final k a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f1908b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f1909c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f1910d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1911e;

        a(k kVar, Bundle bundle, boolean z, boolean z2, int i2) {
            this.a = kVar;
            this.f1908b = bundle;
            this.f1909c = z;
            this.f1910d = z2;
            this.f1911e = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(a aVar) {
            boolean z = this.f1909c;
            if (!z || aVar.f1909c) {
                if (z || !aVar.f1909c) {
                    Bundle bundle = this.f1908b;
                    if (bundle == null || aVar.f1908b != null) {
                        if (bundle != null || aVar.f1908b == null) {
                            if (bundle != null) {
                                int size = bundle.size() - aVar.f1908b.size();
                                if (size > 0) {
                                    return 1;
                                }
                                if (size < 0) {
                                    return -1;
                                }
                            }
                            boolean z2 = this.f1910d;
                            if (!z2 || aVar.f1910d) {
                                if (z2 || !aVar.f1910d) {
                                    return this.f1911e - aVar.f1911e;
                                }
                                return -1;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return 1;
                }
                return -1;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public k n() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bundle q() {
            return this.f1908b;
        }
    }

    public k(s<? extends k> sVar) {
        this(t.c(sVar.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q(Context context, int i2) {
        if (i2 <= 16777215) {
            return Integer.toString(i2);
        }
        try {
            return context.getResources().getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i2);
        }
    }

    public final void B(CharSequence charSequence) {
        this.f1904f = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(l lVar) {
        this.f1901c = lVar;
    }

    boolean D() {
        return true;
    }

    public final void h(String str, d dVar) {
        if (this.f1907j == null) {
            this.f1907j = new HashMap<>();
        }
        this.f1907j.put(str, dVar);
    }

    public final void i(h hVar) {
        if (this.f1905g == null) {
            this.f1905g = new ArrayList<>();
        }
        this.f1905g.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle k(Bundle bundle) {
        HashMap<String, d> hashMap;
        if (bundle == null && ((hashMap = this.f1907j) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, d> hashMap2 = this.f1907j;
        if (hashMap2 != null) {
            for (Map.Entry<String, d> entry : hashMap2.entrySet()) {
                entry.getValue().e(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, d> hashMap3 = this.f1907j;
            if (hashMap3 != null) {
                for (Map.Entry<String, d> entry2 : hashMap3.entrySet()) {
                    if (!entry2.getValue().f(entry2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().b().c() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] l() {
        ArrayDeque arrayDeque = new ArrayDeque();
        k kVar = this;
        while (true) {
            l u = kVar.u();
            if (u == null || u.J() != kVar.r()) {
                arrayDeque.addFirst(kVar);
            }
            if (u == null) {
                break;
            }
            kVar = u;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i2 = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((k) it.next()).r();
            i2++;
        }
        return iArr;
    }

    public final c m(int i2) {
        c.e.h<c> hVar = this.f1906h;
        c f2 = hVar == null ? null : hVar.f(i2);
        if (f2 != null) {
            return f2;
        }
        if (u() != null) {
            return u().m(i2);
        }
        return null;
    }

    public final Map<String, d> o() {
        HashMap<String, d> hashMap = this.f1907j;
        return hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
    }

    public String p() {
        if (this.f1903e == null) {
            this.f1903e = Integer.toString(this.f1902d);
        }
        return this.f1903e;
    }

    public final int r() {
        return this.f1902d;
    }

    public final CharSequence s() {
        return this.f1904f;
    }

    public final String t() {
        return this.f1900b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.f1903e;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.f1902d));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.f1904f != null) {
            sb.append(" label=");
            sb.append(this.f1904f);
        }
        return sb.toString();
    }

    public final l u() {
        return this.f1901c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a w(j jVar) {
        ArrayList<h> arrayList = this.f1905g;
        if (arrayList == null) {
            return null;
        }
        Iterator<h> it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            h next = it.next();
            Uri c2 = jVar.c();
            Bundle c3 = c2 != null ? next.c(c2, o()) : null;
            String a2 = jVar.a();
            boolean z = a2 != null && a2.equals(next.b());
            String b2 = jVar.b();
            int d2 = b2 != null ? next.d(b2) : -1;
            if (c3 != null || z || d2 > -1) {
                a aVar2 = new a(this, c3, next.e(), z, d2);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public void x(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.w.a.A);
        z(obtainAttributes.getResourceId(androidx.navigation.w.a.C, 0));
        this.f1903e = q(context, this.f1902d);
        B(obtainAttributes.getText(androidx.navigation.w.a.B));
        obtainAttributes.recycle();
    }

    public final void y(int i2, c cVar) {
        if (D()) {
            if (i2 != 0) {
                if (this.f1906h == null) {
                    this.f1906h = new c.e.h<>();
                }
                this.f1906h.l(i2, cVar);
                return;
            }
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
        throw new UnsupportedOperationException("Cannot add action " + i2 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void z(int i2) {
        this.f1902d = i2;
        this.f1903e = null;
    }

    public k(String str) {
        this.f1900b = str;
    }
}