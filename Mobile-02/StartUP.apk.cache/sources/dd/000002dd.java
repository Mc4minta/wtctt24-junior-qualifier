package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.i;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class u {
    private final i a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f1677b;

    /* renamed from: d  reason: collision with root package name */
    int f1679d;

    /* renamed from: e  reason: collision with root package name */
    int f1680e;

    /* renamed from: f  reason: collision with root package name */
    int f1681f;

    /* renamed from: g  reason: collision with root package name */
    int f1682g;

    /* renamed from: h  reason: collision with root package name */
    int f1683h;

    /* renamed from: i  reason: collision with root package name */
    boolean f1684i;

    /* renamed from: k  reason: collision with root package name */
    String f1686k;

    /* renamed from: l  reason: collision with root package name */
    int f1687l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList<String> p;
    ArrayList<String> q;
    ArrayList<Runnable> s;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<a> f1678c = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    boolean f1685j = true;
    boolean r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransaction.java */
    /* loaded from: classes.dex */
    public static final class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f1688b;

        /* renamed from: c  reason: collision with root package name */
        int f1689c;

        /* renamed from: d  reason: collision with root package name */
        int f1690d;

        /* renamed from: e  reason: collision with root package name */
        int f1691e;

        /* renamed from: f  reason: collision with root package name */
        int f1692f;

        /* renamed from: g  reason: collision with root package name */
        i.b f1693g;

        /* renamed from: h  reason: collision with root package name */
        i.b f1694h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i2, Fragment fragment) {
            this.a = i2;
            this.f1688b = fragment;
            i.b bVar = i.b.RESUMED;
            this.f1693g = bVar;
            this.f1694h = bVar;
        }

        a(int i2, Fragment fragment, i.b bVar) {
            this.a = i2;
            this.f1688b = fragment;
            this.f1693g = fragment.mMaxState;
            this.f1694h = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(i iVar, ClassLoader classLoader) {
        this.a = iVar;
        this.f1677b = classLoader;
    }

    public u A(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }

    public u b(int i2, Fragment fragment) {
        p(i2, fragment, null, 1);
        return this;
    }

    public u c(int i2, Fragment fragment, String str) {
        p(i2, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public u e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f1678c.add(aVar);
        aVar.f1689c = this.f1679d;
        aVar.f1690d = this.f1680e;
        aVar.f1691e = this.f1681f;
        aVar.f1692f = this.f1682g;
    }

    public u g(View view, String str) {
        if (v.C()) {
            String H = c.h.k.v.H(view);
            if (H != null) {
                if (this.p == null) {
                    this.p = new ArrayList<>();
                    this.q = new ArrayList<>();
                } else if (!this.q.contains(str)) {
                    if (this.p.contains(H)) {
                        throw new IllegalArgumentException("A shared element with the source name '" + H + "' has already been added to the transaction.");
                    }
                } else {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                this.p.add(H);
                this.q.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    public u h(String str) {
        if (this.f1685j) {
            this.f1684i = true;
            this.f1686k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public u i(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public u n(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public u o() {
        if (!this.f1684i) {
            this.f1685j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = fragment.mTag;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                }
                fragment.mTag = str;
            }
            if (i2 != 0) {
                if (i2 != -1) {
                    int i4 = fragment.mFragmentId;
                    if (i4 != 0 && i4 != i2) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
                    }
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            f(new a(i3, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public u q(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public u r(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public u s(int i2, Fragment fragment) {
        return t(i2, fragment, null);
    }

    public u t(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            p(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public u u(Runnable runnable) {
        o();
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(runnable);
        return this;
    }

    public u v(int i2, int i3, int i4, int i5) {
        this.f1679d = i2;
        this.f1680e = i3;
        this.f1681f = i4;
        this.f1682g = i5;
        return this;
    }

    public u w(Fragment fragment, i.b bVar) {
        f(new a(10, fragment, bVar));
        return this;
    }

    public u x(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public u y(boolean z) {
        this.r = z;
        return this;
    }

    public u z(int i2) {
        this.f1683h = i2;
        return this;
    }
}