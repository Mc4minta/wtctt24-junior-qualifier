package e.g.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: TextureViewPreview.java */
@TargetApi(14)
/* loaded from: classes2.dex */
class m extends i {

    /* renamed from: d  reason: collision with root package name */
    private final TextureView f12967d;

    /* renamed from: e  reason: collision with root package name */
    private int f12968e;

    /* compiled from: TextureViewPreview.java */
    /* loaded from: classes2.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            m.this.n(i2, i3);
            m.this.o();
            m.this.a();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            m.this.n(0, 0);
            m.this.b();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            m.this.n(i2, i3);
            m.this.o();
            m.this.a();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, ViewGroup viewGroup) {
        TextureView textureView = (TextureView) View.inflate(context, org.reactnative.camera.b.f17625b, viewGroup).findViewById(org.reactnative.camera.a.f17624b);
        this.f12967d = textureView;
        textureView.setSurfaceTextureListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public Class d() {
        return SurfaceTexture.class;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public Surface e() {
        return new Surface(this.f12967d.getSurfaceTexture());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public View h() {
        return this.f12967d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public boolean j() {
        return this.f12967d.getSurfaceTexture() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    @TargetApi(15)
    public void k(int i2, int i3) {
        this.f12967d.getSurfaceTexture().setDefaultBufferSize(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    public void m(int i2) {
        this.f12968e = i2;
        o();
    }

    void o() {
        Matrix matrix = new Matrix();
        int i2 = this.f12968e;
        if (i2 % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 90) {
            float i3 = i();
            float c2 = c();
            matrix.setPolyToPoly(new float[]{0.0f, 0.0f, i3, 0.0f, 0.0f, c2, i3, c2}, 0, this.f12968e == 90 ? new float[]{0.0f, c2, 0.0f, 0.0f, i3, c2, i3, 0.0f} : new float[]{i3, 0.0f, i3, c2, 0.0f, 0.0f, 0.0f, c2}, 0, 4);
        } else if (i2 == 180) {
            matrix.postRotate(180.0f, i() / 2, c() / 2);
        }
        this.f12967d.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.i
    /* renamed from: p */
    public SurfaceTexture g() {
        return this.f12967d.getSurfaceTexture();
    }
}