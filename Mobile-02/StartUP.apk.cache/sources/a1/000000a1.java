package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {
    private g a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.appcompat.app.c f606b;

    /* renamed from: c  reason: collision with root package name */
    e f607c;

    /* renamed from: d  reason: collision with root package name */
    private m.a f608d;

    public h(g gVar) {
        this.a = gVar;
    }

    public void a() {
        androidx.appcompat.app.c cVar = this.f606b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(g gVar, boolean z) {
        if (z || gVar == this.a) {
            a();
        }
        m.a aVar = this.f608d;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean c(g gVar) {
        m.a aVar = this.f608d;
        if (aVar != null) {
            return aVar.c(gVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        g gVar = this.a;
        c.a aVar = new c.a(gVar.w());
        e eVar = new e(aVar.b(), c.a.g.f2479j);
        this.f607c = eVar;
        eVar.g(this);
        this.a.b(this.f607c);
        aVar.c(this.f607c.a(), this);
        View A = gVar.A();
        if (A != null) {
            aVar.d(A);
        } else {
            aVar.e(gVar.y()).o(gVar.z());
        }
        aVar.k(this);
        androidx.appcompat.app.c a = aVar.a();
        this.f606b = a;
        a.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f606b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= PKIFailureInfo.unsupportedVersion;
        this.f606b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.a.N((i) this.f607c.a().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f607c.b(this.a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f606b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f606b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.a.performShortcut(i2, keyEvent, 0);
    }
}