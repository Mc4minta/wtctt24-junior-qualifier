package e.g.a.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c.h.k.v;
import com.facebook.react.bridge.ReadableMap;
import e.g.a.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: CameraView.java */
/* loaded from: classes2.dex */
public class e extends FrameLayout {
    f a;

    /* renamed from: b  reason: collision with root package name */
    private final c f12937b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12938c;

    /* renamed from: d  reason: collision with root package name */
    private Context f12939d;

    /* renamed from: e  reason: collision with root package name */
    private final h f12940e;

    /* renamed from: f  reason: collision with root package name */
    protected HandlerThread f12941f;

    /* renamed from: g  reason: collision with root package name */
    protected Handler f12942g;

    /* compiled from: CameraView.java */
    /* loaded from: classes2.dex */
    class a extends h {
        a(Context context) {
            super(context);
        }

        @Override // e.g.a.b.h
        public void g(int i2, int i3) {
            e.this.a.D(i2);
            e.this.a.C(i3);
        }
    }

    /* compiled from: CameraView.java */
    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a(e eVar) {
        }

        public void b(e eVar) {
        }

        public void c(e eVar, byte[] bArr, int i2, int i3, int i4) {
        }

        public void d(e eVar) {
        }

        public void e(e eVar, byte[] bArr, int i2) {
        }

        public void f(e eVar) {
        }

        public void g(e eVar, String str, int i2, int i3) {
        }

        public void h(e eVar, String str, int i2, int i3) {
        }
    }

    /* compiled from: CameraView.java */
    /* loaded from: classes2.dex */
    private class c implements f.a {
        private final ArrayList<b> a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private boolean f12944b;

        c() {
        }

        @Override // e.g.a.b.f.a
        public void a() {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(e.this);
            }
        }

        @Override // e.g.a.b.f.a
        public void b() {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().f(e.this);
            }
        }

        @Override // e.g.a.b.f.a
        public void c(byte[] bArr, int i2, int i3, int i4) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().c(e.this, bArr, i2, i3, i4);
            }
        }

        @Override // e.g.a.b.f.a
        public void d() {
            if (this.f12944b) {
                this.f12944b = false;
                e.this.requestLayout();
            }
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(e.this);
            }
        }

        @Override // e.g.a.b.f.a
        public void e() {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().d(e.this);
            }
        }

        @Override // e.g.a.b.f.a
        public void f(String str, int i2, int i3) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().g(e.this, str, i2, i3);
            }
        }

        @Override // e.g.a.b.f.a
        public void g(byte[] bArr, int i2) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().e(e.this, bArr, i2);
            }
        }

        @Override // e.g.a.b.f.a
        public void h(String str, int i2, int i3) {
            Iterator<b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().h(e.this, str, i2, i3);
            }
        }

        public void i(b bVar) {
            this.a.add(bVar);
        }

        public void j() {
            this.f12944b = true;
        }
    }

    public e(Context context, boolean z) {
        this(context, null, z);
    }

    private i n(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return new l(context, this);
        }
        return new m(context, this);
    }

    public boolean getAdjustViewBounds() {
        return this.f12938c;
    }

    public e.g.a.b.a getAspectRatio() {
        return this.a.a();
    }

    public boolean getAutoFocus() {
        return this.a.b();
    }

    public String getCameraId() {
        return this.a.d();
    }

    public List<Properties> getCameraIds() {
        return this.a.e();
    }

    public int getCameraOrientation() {
        return this.a.f();
    }

    public float getExposureCompensation() {
        return this.a.g();
    }

    public int getFacing() {
        return this.a.h();
    }

    public int getFlash() {
        return this.a.i();
    }

    public float getFocusDepth() {
        return this.a.j();
    }

    public j getPictureSize() {
        return this.a.k();
    }

    public boolean getPlaySoundOnCapture() {
        return this.a.l();
    }

    public j getPreviewSize() {
        return this.a.m();
    }

    public boolean getScanning() {
        return this.a.n();
    }

    public Set<e.g.a.b.a> getSupportedAspectRatios() {
        return this.a.o();
    }

    public ArrayList<int[]> getSupportedPreviewFpsRange() {
        return this.a.p();
    }

    public View getView() {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.q();
        }
        return null;
    }

    public int getWhiteBalance() {
        return this.a.r();
    }

    public float getZoom() {
        return this.a.s();
    }

    public void l(b bVar) {
        this.f12937b.i(bVar);
    }

    public void m() {
        HandlerThread handlerThread = this.f12941f;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT < 18) {
                handlerThread.quit();
            } else {
                handlerThread.quitSafely();
            }
            this.f12941f = null;
        }
    }

    public SortedSet<j> o(e.g.a.b.a aVar) {
        return this.a.c(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.f12940e.e(v.s(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f12940e.c();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (isInEditMode()) {
            super.onMeasure(i2, i3);
            return;
        }
        if (this.f12938c) {
            if (!p()) {
                this.f12937b.j();
                super.onMeasure(i2, i3);
                return;
            }
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode == 1073741824 && mode2 != 1073741824) {
                int size = (int) (View.MeasureSpec.getSize(i2) * getAspectRatio().D());
                if (mode2 == Integer.MIN_VALUE) {
                    size = Math.min(size, View.MeasureSpec.getSize(i3));
                }
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            } else if (mode != 1073741824 && mode2 == 1073741824) {
                int size2 = (int) (View.MeasureSpec.getSize(i3) * getAspectRatio().D());
                if (mode == Integer.MIN_VALUE) {
                    size2 = Math.min(size2, View.MeasureSpec.getSize(i2));
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), i3);
            } else {
                super.onMeasure(i2, i3);
            }
        } else {
            super.onMeasure(i2, i3);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        e.g.a.b.a aspectRatio = getAspectRatio();
        if (this.f12940e.f() % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 == 0) {
            aspectRatio = aspectRatio.y();
        }
        if (measuredHeight < (aspectRatio.s() * measuredWidth) / aspectRatio.q()) {
            this.a.q().measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((measuredWidth * aspectRatio.s()) / aspectRatio.q(), 1073741824));
        } else {
            this.a.q().measure(View.MeasureSpec.makeMeasureSpec((aspectRatio.q() * measuredHeight) / aspectRatio.s(), 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setFacing(dVar.a);
        setCameraId(dVar.f12946b);
        setAspectRatio(dVar.f12947c);
        setAutoFocus(dVar.f12948d);
        setFlash(dVar.f12949e);
        setExposureCompensation(dVar.f12950f);
        setFocusDepth(dVar.f12951g);
        setZoom(dVar.f12952h);
        setWhiteBalance(dVar.f12953j);
        setPlaySoundOnCapture(dVar.f12954k);
        setScanning(dVar.f12955l);
        setPictureSize(dVar.m);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.a = getFacing();
        dVar.f12946b = getCameraId();
        dVar.f12947c = getAspectRatio();
        dVar.f12948d = getAutoFocus();
        dVar.f12949e = getFlash();
        dVar.f12950f = getExposureCompensation();
        dVar.f12951g = getFocusDepth();
        dVar.f12952h = getZoom();
        dVar.f12953j = getWhiteBalance();
        dVar.f12954k = getPlaySoundOnCapture();
        dVar.f12955l = getScanning();
        dVar.m = getPictureSize();
        return dVar;
    }

    public boolean p() {
        return this.a.t();
    }

    public void q() {
        this.a.u();
    }

    public void r() {
        this.a.v();
    }

    public boolean s(String str, int i2, int i3, boolean z, CamcorderProfile camcorderProfile, int i4, int i5) {
        return this.a.w(str, i2, i3, z, camcorderProfile, i4, i5);
    }

    public void setAdjustViewBounds(boolean z) {
        if (this.f12938c != z) {
            this.f12938c = z;
            requestLayout();
        }
    }

    public void setAspectRatio(e.g.a.b.a aVar) {
        if (this.a.z(aVar)) {
            requestLayout();
        }
    }

    public void setAutoFocus(boolean z) {
        this.a.A(z);
    }

    public void setCameraId(String str) {
        this.a.B(str);
    }

    public void setExposureCompensation(float f2) {
        this.a.E(f2);
    }

    public void setFacing(int i2) {
        this.a.F(i2);
    }

    public void setFlash(int i2) {
        this.a.G(i2);
    }

    public void setFocusDepth(float f2) {
        this.a.I(f2);
    }

    public void setPictureSize(j jVar) {
        this.a.J(jVar);
    }

    public void setPlaySoundOnCapture(boolean z) {
        this.a.K(z);
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.a.L(surfaceTexture);
    }

    public void setScanning(boolean z) {
        this.a.M(z);
    }

    public void setUsingCamera2Api(boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return;
        }
        boolean p = p();
        Parcelable onSaveInstanceState = onSaveInstanceState();
        if (z && !e.g.a.b.c.f0(this.f12939d)) {
            if (p) {
                x();
            }
            if (i2 < 23) {
                this.a = new e.g.a.b.c(this.f12937b, this.a.f12956b, this.f12939d, this.f12942g);
            } else {
                this.a = new e.g.a.b.d(this.f12937b, this.a.f12956b, this.f12939d, this.f12942g);
            }
            onRestoreInstanceState(onSaveInstanceState);
        } else if (this.a instanceof e.g.a.b.b) {
            return;
        } else {
            if (p) {
                x();
            }
            this.a = new e.g.a.b.b(this.f12937b, this.a.f12956b, this.f12942g);
        }
        if (p) {
            w();
        }
    }

    public void setWhiteBalance(int i2) {
        this.a.N(i2);
    }

    public void setZoom(float f2) {
        this.a.O(f2);
    }

    public void t() {
        this.a.x();
    }

    public void u() {
        this.a.y();
    }

    public void v(float f2, float f3) {
        this.a.H(f2, f3);
    }

    public void w() {
        this.a.P();
    }

    public void x() {
        this.a.Q();
    }

    public void y() {
        this.a.R();
    }

    public void z(ReadableMap readableMap) {
        this.a.S(readableMap);
    }

    public e(Context context, AttributeSet attributeSet, boolean z) {
        this(context, attributeSet, 0, z);
    }

    public e(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2);
        int i3;
        HandlerThread handlerThread = new HandlerThread("RNCamera-Handler-Thread");
        this.f12941f = handlerThread;
        handlerThread.start();
        this.f12942g = new Handler(this.f12941f.getLooper());
        if (isInEditMode()) {
            this.f12937b = null;
            this.f12940e = null;
            return;
        }
        this.f12938c = true;
        this.f12939d = context;
        i n = n(context);
        c cVar = new c();
        this.f12937b = cVar;
        if (z || (i3 = Build.VERSION.SDK_INT) < 21 || e.g.a.b.c.f0(context)) {
            this.a = new e.g.a.b.b(cVar, n, this.f12942g);
        } else if (i3 < 23) {
            this.a = new e.g.a.b.c(cVar, n, context, this.f12942g);
        } else {
            this.a = new e.g.a.b.d(cVar, n, context, this.f12942g);
        }
        this.f12940e = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CameraView.java */
    /* loaded from: classes2.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = androidx.core.os.d.a(new a());
        int a;

        /* renamed from: b  reason: collision with root package name */
        String f12946b;

        /* renamed from: c  reason: collision with root package name */
        e.g.a.b.a f12947c;

        /* renamed from: d  reason: collision with root package name */
        boolean f12948d;

        /* renamed from: e  reason: collision with root package name */
        int f12949e;

        /* renamed from: f  reason: collision with root package name */
        float f12950f;

        /* renamed from: g  reason: collision with root package name */
        float f12951g;

        /* renamed from: h  reason: collision with root package name */
        float f12952h;

        /* renamed from: j  reason: collision with root package name */
        int f12953j;

        /* renamed from: k  reason: collision with root package name */
        boolean f12954k;

        /* renamed from: l  reason: collision with root package name */
        boolean f12955l;
        j m;

        /* compiled from: CameraView.java */
        /* loaded from: classes2.dex */
        static class a implements androidx.core.os.e<d> {
            a() {
            }

            @Override // androidx.core.os.e
            /* renamed from: a */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // androidx.core.os.e
            /* renamed from: b */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.a = parcel.readInt();
            this.f12946b = parcel.readString();
            this.f12947c = (e.g.a.b.a) parcel.readParcelable(classLoader);
            this.f12948d = parcel.readByte() != 0;
            this.f12949e = parcel.readInt();
            this.f12950f = parcel.readFloat();
            this.f12951g = parcel.readFloat();
            this.f12952h = parcel.readFloat();
            this.f12953j = parcel.readInt();
            this.f12954k = parcel.readByte() != 0;
            this.f12955l = parcel.readByte() != 0;
            this.m = (j) parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeString(this.f12946b);
            parcel.writeParcelable(this.f12947c, 0);
            parcel.writeByte(this.f12948d ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f12949e);
            parcel.writeFloat(this.f12950f);
            parcel.writeFloat(this.f12951g);
            parcel.writeFloat(this.f12952h);
            parcel.writeInt(this.f12953j);
            parcel.writeByte(this.f12954k ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f12955l ? (byte) 1 : (byte) 0);
            parcel.writeParcelable(this.m, i2);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }
}