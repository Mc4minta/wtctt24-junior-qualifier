package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.navigation.k;
import androidx.navigation.p;
import androidx.navigation.s;

@s.b("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends s<a> {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final m f1864b;

    /* renamed from: c  reason: collision with root package name */
    private int f1865c = 0;

    /* renamed from: d  reason: collision with root package name */
    private androidx.lifecycle.m f1866d = new androidx.lifecycle.m() { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.m
        public void c(o oVar, i.a aVar) {
            if (aVar == i.a.ON_STOP) {
                androidx.fragment.app.c cVar = (androidx.fragment.app.c) oVar;
                if (cVar.requireDialog().isShowing()) {
                    return;
                }
                d.findNavController(cVar).t();
            }
        }
    };

    /* loaded from: classes.dex */
    public static class a extends k implements androidx.navigation.b {

        /* renamed from: k  reason: collision with root package name */
        private String f1867k;

        public a(s<? extends a> sVar) {
            super(sVar);
        }

        public final String E() {
            String str = this.f1867k;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        public final a F(String str) {
            this.f1867k = str;
            return this;
        }

        @Override // androidx.navigation.k
        public void x(Context context, AttributeSet attributeSet) {
            super.x(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, f.f1870c);
            String string = obtainAttributes.getString(f.f1871d);
            if (string != null) {
                F(string);
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, m mVar) {
        this.a = context;
        this.f1864b = mVar;
    }

    @Override // androidx.navigation.s
    /* renamed from: a */
    public a createDestination() {
        return new a(this);
    }

    @Override // androidx.navigation.s
    /* renamed from: b */
    public k navigate(a aVar, Bundle bundle, p pVar, s.a aVar2) {
        if (this.f1864b.v0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String E = aVar.E();
        if (E.charAt(0) == '.') {
            E = this.a.getPackageName() + E;
        }
        Fragment a2 = this.f1864b.g0().a(this.a.getClassLoader(), E);
        if (androidx.fragment.app.c.class.isAssignableFrom(a2.getClass())) {
            androidx.fragment.app.c cVar = (androidx.fragment.app.c) a2;
            cVar.setArguments(bundle);
            cVar.getLifecycle().a(this.f1866d);
            m mVar = this.f1864b;
            StringBuilder sb = new StringBuilder();
            sb.append("androidx-nav-fragment:navigator:dialog:");
            int i2 = this.f1865c;
            this.f1865c = i2 + 1;
            sb.append(i2);
            cVar.show(mVar, sb.toString());
            return aVar;
        }
        throw new IllegalArgumentException("Dialog destination " + aVar.E() + " is not an instance of DialogFragment");
    }

    @Override // androidx.navigation.s
    public void onRestoreState(Bundle bundle) {
        if (bundle != null) {
            this.f1865c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i2 = 0; i2 < this.f1865c; i2++) {
                m mVar = this.f1864b;
                androidx.fragment.app.c cVar = (androidx.fragment.app.c) mVar.Z("androidx-nav-fragment:navigator:dialog:" + i2);
                if (cVar != null) {
                    cVar.getLifecycle().a(this.f1866d);
                } else {
                    throw new IllegalStateException("DialogFragment " + i2 + " doesn't exist in the FragmentManager");
                }
            }
        }
    }

    @Override // androidx.navigation.s
    public Bundle onSaveState() {
        if (this.f1865c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.f1865c);
        return bundle;
    }

    @Override // androidx.navigation.s
    public boolean popBackStack() {
        if (this.f1865c == 0) {
            return false;
        }
        if (this.f1864b.v0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        m mVar = this.f1864b;
        StringBuilder sb = new StringBuilder();
        sb.append("androidx-nav-fragment:navigator:dialog:");
        int i2 = this.f1865c - 1;
        this.f1865c = i2;
        sb.append(i2);
        Fragment Z = mVar.Z(sb.toString());
        if (Z != null) {
            Z.getLifecycle().c(this.f1866d);
            ((androidx.fragment.app.c) Z).dismiss();
        }
        return true;
    }
}