package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* loaded from: classes.dex */
public class l {
    private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final m f1627b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    /* loaded from: classes.dex */
    public static final class a {
        final m.f a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f1628b;

        a(m.f fVar, boolean z) {
            this.a = fVar;
            this.f1628b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar) {
        this.f1627b = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentActivityCreated(this.f1627b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, Context context, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().b(fragment, context, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentAttached(this.f1627b, fragment, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentCreated(this.f1627b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().d(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentDestroyed(this.f1627b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().e(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentDetached(this.f1627b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().f(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentPaused(this.f1627b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, Context context, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().g(fragment, context, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentPreAttached(this.f1627b, fragment, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentPreCreated(this.f1627b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().i(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentResumed(this.f1627b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentSaveInstanceState(this.f1627b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().k(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentStarted(this.f1627b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().l(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentStopped(this.f1627b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentViewCreated(this.f1627b, fragment, view, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z) {
        Fragment k0 = this.f1627b.k0();
        if (k0 != null) {
            k0.getParentFragmentManager().j0().n(fragment, true);
        }
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f1628b) {
                next.a.onFragmentViewDestroyed(this.f1627b, fragment);
            }
        }
    }

    public void o(m.f fVar, boolean z) {
        this.a.add(new a(fVar, z));
    }

    public void p(m.f fVar) {
        synchronized (this.a) {
            int i2 = 0;
            int size = this.a.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.a.get(i2).a == fVar) {
                    this.a.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }
}