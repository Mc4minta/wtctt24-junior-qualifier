package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: NavGraph.java */
/* loaded from: classes.dex */
public class l extends k implements Iterable<k> {

    /* renamed from: k  reason: collision with root package name */
    final c.e.h<k> f1912k;

    /* renamed from: l  reason: collision with root package name */
    private int f1913l;
    private String m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavGraph.java */
    /* loaded from: classes.dex */
    public class a implements Iterator<k> {
        private int a = -1;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1914b = false;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public k next() {
            if (hasNext()) {
                this.f1914b = true;
                c.e.h<k> hVar = l.this.f1912k;
                int i2 = this.a + 1;
                this.a = i2;
                return hVar.q(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < l.this.f1912k.p();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f1914b) {
                l.this.f1912k.q(this.a).C(null);
                l.this.f1912k.o(this.a);
                this.a--;
                this.f1914b = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public l(s<? extends l> sVar) {
        super(sVar);
        this.f1912k = new c.e.h<>();
    }

    public final void E(k kVar) {
        if (kVar.r() != 0) {
            k f2 = this.f1912k.f(kVar.r());
            if (f2 == kVar) {
                return;
            }
            if (kVar.u() == null) {
                if (f2 != null) {
                    f2.C(null);
                }
                kVar.C(this);
                this.f1912k.l(kVar.r(), kVar);
                return;
            }
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final k F(int i2) {
        return H(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final k H(int i2, boolean z) {
        k f2 = this.f1912k.f(i2);
        if (f2 != null) {
            return f2;
        }
        if (!z || u() == null) {
            return null;
        }
        return u().F(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String I() {
        if (this.m == null) {
            this.m = Integer.toString(this.f1913l);
        }
        return this.m;
    }

    public final int J() {
        return this.f1913l;
    }

    public final void L(int i2) {
        this.f1913l = i2;
        this.m = null;
    }

    @Override // java.lang.Iterable
    public final Iterator<k> iterator() {
        return new a();
    }

    @Override // androidx.navigation.k
    public String p() {
        return r() != 0 ? super.p() : "the root navigation";
    }

    @Override // androidx.navigation.k
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        k F = F(J());
        if (F == null) {
            String str = this.m;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.f1913l));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(F.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.navigation.k
    public k.a w(j jVar) {
        k.a w = super.w(jVar);
        Iterator<k> it = iterator();
        while (it.hasNext()) {
            k.a w2 = it.next().w(jVar);
            if (w2 != null && (w == null || w2.compareTo(w) > 0)) {
                w = w2;
            }
        }
        return w;
    }

    @Override // androidx.navigation.k
    public void x(Context context, AttributeSet attributeSet) {
        super.x(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.w.a.y);
        L(obtainAttributes.getResourceId(androidx.navigation.w.a.z, 0));
        this.m = k.q(context, this.f1913l);
        obtainAttributes.recycle();
    }
}