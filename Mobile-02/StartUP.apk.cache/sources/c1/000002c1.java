package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.g0;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class h {
    private final j<?> a;

    private h(j<?> jVar) {
        this.a = jVar;
    }

    public static h b(j<?> jVar) {
        return new h((j) androidx.core.util.h.c(jVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.a;
        jVar.f1626e.h(jVar, jVar, fragment);
    }

    public void c() {
        this.a.f1626e.s();
    }

    public void d(Configuration configuration) {
        this.a.f1626e.t(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.a.f1626e.u(menuItem);
    }

    public void f() {
        this.a.f1626e.v();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.a.f1626e.w(menu, menuInflater);
    }

    public void h() {
        this.a.f1626e.x();
    }

    public void i() {
        this.a.f1626e.z();
    }

    public void j(boolean z) {
        this.a.f1626e.A(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.a.f1626e.B(menuItem);
    }

    public void l(Menu menu) {
        this.a.f1626e.C(menu);
    }

    public void m() {
        this.a.f1626e.E();
    }

    public void n(boolean z) {
        this.a.f1626e.F(z);
    }

    public boolean o(Menu menu) {
        return this.a.f1626e.G(menu);
    }

    public void p() {
        this.a.f1626e.I();
    }

    public void q() {
        this.a.f1626e.J();
    }

    public void r() {
        this.a.f1626e.L();
    }

    public boolean s() {
        return this.a.f1626e.R(true);
    }

    public Fragment t(String str) {
        return this.a.f1626e.a0(str);
    }

    public m u() {
        return this.a.f1626e;
    }

    public void v() {
        this.a.f1626e.D0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.f1626e.i0().onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        j<?> jVar = this.a;
        if (jVar instanceof g0) {
            jVar.f1626e.T0(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public Parcelable y() {
        return this.a.f1626e.V0();
    }
}