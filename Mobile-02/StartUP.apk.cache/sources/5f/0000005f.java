package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import c.a.o.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class f {
    private static int a = -100;

    /* renamed from: b  reason: collision with root package name */
    private static final c.e.b<WeakReference<f>> f448b = new c.e.b<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f449c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(f fVar) {
        synchronized (f449c) {
            z(fVar);
            f448b.add(new WeakReference<>(fVar));
        }
    }

    public static f g(Activity activity, e eVar) {
        return new g(activity, eVar);
    }

    public static f h(Dialog dialog, e eVar) {
        return new g(dialog, eVar);
    }

    public static int j() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y(f fVar) {
        synchronized (f449c) {
            z(fVar);
        }
    }

    private static void z(f fVar) {
        synchronized (f449c) {
            Iterator<WeakReference<f>> it = f448b.iterator();
            while (it.hasNext()) {
                f fVar2 = it.next().get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract boolean A(int i2);

    public abstract void B(int i2);

    public abstract void C(View view);

    public abstract void D(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void E(Toolbar toolbar);

    public void F(int i2) {
    }

    public abstract void G(CharSequence charSequence);

    public abstract c.a.o.b H(b.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract <T extends View> T i(int i2);

    public abstract b k();

    public int l() {
        return -100;
    }

    public abstract MenuInflater m();

    public abstract a n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Configuration configuration);

    public abstract void r(Bundle bundle);

    public abstract void s();

    public abstract void t(Bundle bundle);

    public abstract void u();

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x();
}