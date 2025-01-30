package e.g.a.b;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* compiled from: PreviewImpl.java */
/* loaded from: classes2.dex */
abstract class i {
    private a a;

    /* renamed from: b  reason: collision with root package name */
    private int f12963b;

    /* renamed from: c  reason: collision with root package name */
    private int f12964c;

    /* compiled from: PreviewImpl.java */
    /* loaded from: classes2.dex */
    interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f12964c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Class d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Surface e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceHolder f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract View h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f12963b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void m(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i2, int i3) {
        this.f12963b = i2;
        this.f12964c = i3;
    }
}