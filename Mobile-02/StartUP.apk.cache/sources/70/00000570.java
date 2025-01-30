package c.h.k;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private a f3000b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0068b f3001c;

    /* compiled from: ActionProvider.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: c.h.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public b(Context context) {
        this.a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f3001c = null;
        this.f3000b = null;
    }

    public void i(a aVar) {
        this.f3000b = aVar;
    }

    public void j(InterfaceC0068b interfaceC0068b) {
        if (this.f3001c != null && interfaceC0068b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f3001c = interfaceC0068b;
    }
}