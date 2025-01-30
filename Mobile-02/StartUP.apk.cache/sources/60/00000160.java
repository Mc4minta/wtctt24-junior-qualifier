package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;

/* compiled from: DecorToolbar.java */
/* loaded from: classes.dex */
public interface y {
    void a(Menu menu, m.a aVar);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    Context e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    boolean h();

    void i();

    void j(l0 l0Var);

    boolean k();

    void l(int i2);

    Menu m();

    void n(int i2);

    int o();

    c.h.k.z p(int i2, long j2);

    void q(m.a aVar, g.a aVar2);

    ViewGroup r();

    void s(boolean z);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i2);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    int t();

    void u();

    void v();

    void w(Drawable drawable);

    void x(boolean z);
}