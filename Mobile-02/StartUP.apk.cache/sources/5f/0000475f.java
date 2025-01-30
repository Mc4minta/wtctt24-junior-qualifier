package e.g.a.b;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import c.h.k.v;

/* compiled from: SurfaceViewPreview.java */
/* loaded from: classes2.dex */
class l extends i {

    /* renamed from: d  reason: collision with root package name */
    final SurfaceView f12966d;

    /* compiled from: SurfaceViewPreview.java */
    /* loaded from: classes2.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            l.this.n(i3, i4);
            if (v.R(l.this.f12966d)) {
                return;
            }
            l.this.a();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            l.this.n(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, ViewGroup viewGroup) {
        SurfaceView surfaceView = (SurfaceView) View.inflate(context, org.reactnative.camera.b.a, viewGroup).findViewById(org.reactnative.camera.a.a);
        this.f12966d = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public Class d() {
        return SurfaceHolder.class;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public Surface e() {
        return f().getSurface();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public SurfaceHolder f() {
        return this.f12966d.getHolder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public View h() {
        return this.f12966d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public boolean j() {
        return (i() == 0 || c() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public void m(int i2) {
    }
}