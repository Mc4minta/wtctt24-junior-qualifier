package e.g.a.b;

import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: CameraViewImpl.java */
/* loaded from: classes2.dex */
abstract class f {
    protected final a a;

    /* renamed from: b  reason: collision with root package name */
    protected final i f12956b;

    /* renamed from: c  reason: collision with root package name */
    protected final Handler f12957c;

    /* compiled from: CameraViewImpl.java */
    /* loaded from: classes2.dex */
    interface a {
        void a();

        void b();

        void c(byte[] bArr, int i2, int i3, int i4);

        void d();

        void e();

        void f(String str, int i2, int i3);

        void g(byte[] bArr, int i2);

        void h(String str, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, i iVar, Handler handler) {
        this.a = aVar;
        this.f12956b = iVar;
        this.f12957c = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void A(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void B(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void C(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void D(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void E(float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void F(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void G(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void H(float f2, float f3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void I(float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void J(j jVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void K(boolean z);

    public abstract void L(SurfaceTexture surfaceTexture);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void M(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void N(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void O(float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean P();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void Q();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void R();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void S(ReadableMap readableMap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.g.a.b.a a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract SortedSet<j> c(e.g.a.b.a aVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<Properties> e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract j k();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean l();

    public abstract j m();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Set<e.g.a.b.a> o();

    public abstract ArrayList<int[]> p();

    /* JADX INFO: Access modifiers changed from: package-private */
    public View q() {
        return this.f12956b.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int r();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float s();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean t();

    public abstract void u();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void v();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean w(String str, int i2, int i3, boolean z, CamcorderProfile camcorderProfile, int i4, int i5);

    public abstract void x();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void y();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean z(e.g.a.b.a aVar);
}