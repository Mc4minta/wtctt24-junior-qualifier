package e.a.a;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import c.h.k.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: LottieAnimationView.java */
/* loaded from: classes.dex */
public class d extends AppCompatImageView {
    private static final String a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final i<Throwable> f11498b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final i<e.a.a.e> f11499c;

    /* renamed from: d  reason: collision with root package name */
    private final i<Throwable> f11500d;

    /* renamed from: e  reason: collision with root package name */
    private i<Throwable> f11501e;

    /* renamed from: f  reason: collision with root package name */
    private int f11502f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.g f11503g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11504h;

    /* renamed from: j  reason: collision with root package name */
    private String f11505j;

    /* renamed from: k  reason: collision with root package name */
    private int f11506k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11507l;
    private boolean m;
    private boolean n;
    private boolean p;
    private boolean q;
    private r t;
    private Set<k> u;
    private int v;
    private n<e.a.a.e> w;
    private e.a.a.e x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieAnimationView.java */
    /* loaded from: classes.dex */
    public class a implements i<Throwable> {
        a() {
        }

        @Override // e.a.a.i
        /* renamed from: b */
        public void a(Throwable th) {
            if (e.a.a.z.h.k(th)) {
                e.a.a.z.d.d("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* compiled from: LottieAnimationView.java */
    /* loaded from: classes.dex */
    class b implements i<e.a.a.e> {
        b() {
        }

        @Override // e.a.a.i
        /* renamed from: b */
        public void a(e.a.a.e eVar) {
            d.this.setComposition(eVar);
        }
    }

    /* compiled from: LottieAnimationView.java */
    /* loaded from: classes.dex */
    class c implements i<Throwable> {
        c() {
        }

        @Override // e.a.a.i
        /* renamed from: b */
        public void a(Throwable th) {
            if (d.this.f11502f != 0) {
                d dVar = d.this;
                dVar.setImageResource(dVar.f11502f);
            }
            (d.this.f11501e == null ? d.f11498b : d.this.f11501e).a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieAnimationView.java */
    /* renamed from: e.a.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0252d implements Callable<m<e.a.a.e>> {
        final /* synthetic */ int a;

        CallableC0252d(int i2) {
            this.a = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() throws Exception {
            return d.this.q ? e.a.a.f.o(d.this.getContext(), this.a) : e.a.a.f.p(d.this.getContext(), this.a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieAnimationView.java */
    /* loaded from: classes.dex */
    public class e implements Callable<m<e.a.a.e>> {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<e.a.a.e> call() throws Exception {
            return d.this.q ? e.a.a.f.f(d.this.getContext(), this.a) : e.a.a.f.g(d.this.getContext(), this.a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieAnimationView.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r.values().length];
            a = iArr;
            try {
                iArr[r.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LottieAnimationView.java */
    /* loaded from: classes.dex */
    public static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();
        String a;

        /* renamed from: b  reason: collision with root package name */
        int f11510b;

        /* renamed from: c  reason: collision with root package name */
        float f11511c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11512d;

        /* renamed from: e  reason: collision with root package name */
        String f11513e;

        /* renamed from: f  reason: collision with root package name */
        int f11514f;

        /* renamed from: g  reason: collision with root package name */
        int f11515g;

        /* compiled from: LottieAnimationView.java */
        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        /* synthetic */ g(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.a);
            parcel.writeFloat(this.f11511c);
            parcel.writeInt(this.f11512d ? 1 : 0);
            parcel.writeString(this.f11513e);
            parcel.writeInt(this.f11514f);
            parcel.writeInt(this.f11515g);
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        private g(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.f11511c = parcel.readFloat();
            this.f11512d = parcel.readInt() == 1;
            this.f11513e = parcel.readString();
            this.f11514f = parcel.readInt();
            this.f11515g = parcel.readInt();
        }
    }

    public d(Context context) {
        super(context);
        this.f11499c = new b();
        this.f11500d = new c();
        this.f11502f = 0;
        this.f11503g = new e.a.a.g();
        this.f11507l = false;
        this.m = false;
        this.n = false;
        this.p = false;
        this.q = true;
        this.t = r.AUTOMATIC;
        this.u = new HashSet();
        this.v = 0;
        p(null, p.a);
    }

    private void j() {
        n<e.a.a.e> nVar = this.w;
        if (nVar != null) {
            nVar.k(this.f11499c);
            this.w.j(this.f11500d);
        }
    }

    private void k() {
        this.x = null;
        this.f11503g.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
        if (r3 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m() {
        /*
            r5 = this;
            int[] r0 = e.a.a.d.f.a
            e.a.a.r r1 = r5.t
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L46
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = r2
            goto L46
        L15:
            e.a.a.e r0 = r5.x
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.p()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L44
        L27:
            e.a.a.e r0 = r5.x
            if (r0 == 0) goto L33
            int r0 = r0.l()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L44
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L3a
            goto L44
        L3a:
            r4 = 24
            if (r0 == r4) goto L44
            r4 = 25
            if (r0 != r4) goto L43
            goto L44
        L43:
            r3 = r2
        L44:
            if (r3 == 0) goto L13
        L46:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L50
            r0 = 0
            r5.setLayerType(r1, r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.d.m():void");
    }

    private n<e.a.a.e> n(String str) {
        if (isInEditMode()) {
            return new n<>(new e(str), true);
        }
        return this.q ? e.a.a.f.d(getContext(), str) : e.a.a.f.e(getContext(), str, null);
    }

    private n<e.a.a.e> o(int i2) {
        if (isInEditMode()) {
            return new n<>(new CallableC0252d(i2), true);
        }
        return this.q ? e.a.a.f.m(getContext(), i2) : e.a.a.f.n(getContext(), i2, null);
    }

    private void p(AttributeSet attributeSet, int i2) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.C, i2, 0);
        this.q = obtainStyledAttributes.getBoolean(q.E, true);
        int i3 = q.M;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        int i4 = q.I;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i4);
        int i5 = q.S;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i5);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i3, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i4);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i5)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(q.H, 0));
        if (obtainStyledAttributes.getBoolean(q.D, false)) {
            this.n = true;
            this.p = true;
        }
        if (obtainStyledAttributes.getBoolean(q.K, false)) {
            this.f11503g.c0(-1);
        }
        int i6 = q.P;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatMode(obtainStyledAttributes.getInt(i6, 1));
        }
        int i7 = q.O;
        if (obtainStyledAttributes.hasValue(i7)) {
            setRepeatCount(obtainStyledAttributes.getInt(i7, -1));
        }
        int i8 = q.R;
        if (obtainStyledAttributes.hasValue(i8)) {
            setSpeed(obtainStyledAttributes.getFloat(i8, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(q.J));
        setProgress(obtainStyledAttributes.getFloat(q.L, 0.0f));
        l(obtainStyledAttributes.getBoolean(q.G, false));
        int i9 = q.F;
        if (obtainStyledAttributes.hasValue(i9)) {
            h(new e.a.a.w.e("**"), l.C, new e.a.a.a0.c(new s(obtainStyledAttributes.getColor(i9, 0))));
        }
        int i10 = q.Q;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f11503g.f0(obtainStyledAttributes.getFloat(i10, 1.0f));
        }
        int i11 = q.N;
        if (obtainStyledAttributes.hasValue(i11)) {
            r rVar = r.AUTOMATIC;
            int i12 = obtainStyledAttributes.getInt(i11, rVar.ordinal());
            if (i12 >= r.values().length) {
                i12 = rVar.ordinal();
            }
            setRenderMode(r.values()[i12]);
        }
        if (getScaleType() != null) {
            this.f11503g.g0(getScaleType());
        }
        obtainStyledAttributes.recycle();
        this.f11503g.i0(Boolean.valueOf(e.a.a.z.h.f(getContext()) != 0.0f));
        m();
        this.f11504h = true;
    }

    private void setCompositionTask(n<e.a.a.e> nVar) {
        k();
        j();
        this.w = nVar.f(this.f11499c).e(this.f11500d);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        e.a.a.c.a("buildDrawingCache");
        this.v++;
        super.buildDrawingCache(z);
        if (this.v == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(r.HARDWARE);
        }
        this.v--;
        e.a.a.c.b("buildDrawingCache");
    }

    public void g(Animator.AnimatorListener animatorListener) {
        this.f11503g.c(animatorListener);
    }

    public e.a.a.e getComposition() {
        return this.x;
    }

    public long getDuration() {
        e.a.a.e eVar = this.x;
        if (eVar != null) {
            return eVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f11503g.q();
    }

    public String getImageAssetsFolder() {
        return this.f11503g.t();
    }

    public float getMaxFrame() {
        return this.f11503g.u();
    }

    public float getMinFrame() {
        return this.f11503g.w();
    }

    public o getPerformanceTracker() {
        return this.f11503g.x();
    }

    public float getProgress() {
        return this.f11503g.y();
    }

    public int getRepeatCount() {
        return this.f11503g.z();
    }

    public int getRepeatMode() {
        return this.f11503g.A();
    }

    public float getScale() {
        return this.f11503g.B();
    }

    public float getSpeed() {
        return this.f11503g.C();
    }

    public <T> void h(e.a.a.w.e eVar, T t, e.a.a.a0.c<T> cVar) {
        this.f11503g.d(eVar, t, cVar);
    }

    public void i() {
        this.n = false;
        this.m = false;
        this.f11507l = false;
        this.f11503g.f();
        m();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        e.a.a.g gVar = this.f11503g;
        if (drawable2 == gVar) {
            super.invalidateDrawable(gVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void l(boolean z) {
        this.f11503g.k(z);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.p || this.n)) {
            s();
            this.p = false;
            this.n = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (q()) {
            i();
            this.n = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        String str = gVar.a;
        this.f11505j = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f11505j);
        }
        int i2 = gVar.f11510b;
        this.f11506k = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(gVar.f11511c);
        if (gVar.f11512d) {
            s();
        }
        this.f11503g.R(gVar.f11513e);
        setRepeatMode(gVar.f11514f);
        setRepeatCount(gVar.f11515g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        g gVar = new g(super.onSaveInstanceState());
        gVar.a = this.f11505j;
        gVar.f11510b = this.f11506k;
        gVar.f11511c = this.f11503g.y();
        gVar.f11512d = this.f11503g.F() || (!v.Q(this) && this.n);
        gVar.f11513e = this.f11503g.t();
        gVar.f11514f = this.f11503g.A();
        gVar.f11515g = this.f11503g.z();
        return gVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        if (this.f11504h) {
            if (isShown()) {
                if (this.m) {
                    t();
                } else if (this.f11507l) {
                    s();
                }
                this.m = false;
                this.f11507l = false;
            } else if (q()) {
                r();
                this.m = true;
            }
        }
    }

    public boolean q() {
        return this.f11503g.F();
    }

    public void r() {
        this.p = false;
        this.n = false;
        this.m = false;
        this.f11507l = false;
        this.f11503g.H();
        m();
    }

    public void s() {
        if (isShown()) {
            this.f11503g.I();
            m();
            return;
        }
        this.f11507l = true;
    }

    public void setAnimation(int i2) {
        this.f11506k = i2;
        this.f11505j = null;
        setCompositionTask(o(i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        w(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.q ? e.a.a.f.q(getContext(), str) : e.a.a.f.r(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f11503g.M(z);
    }

    public void setCacheComposition(boolean z) {
        this.q = z;
    }

    public void setComposition(e.a.a.e eVar) {
        if (e.a.a.c.a) {
            String str = a;
            Log.v(str, "Set Composition \n" + eVar);
        }
        this.f11503g.setCallback(this);
        this.x = eVar;
        boolean N = this.f11503g.N(eVar);
        m();
        if (getDrawable() != this.f11503g || N) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (k kVar : this.u) {
                kVar.a(eVar);
            }
        }
    }

    public void setFailureListener(i<Throwable> iVar) {
        this.f11501e = iVar;
    }

    public void setFallbackResource(int i2) {
        this.f11502f = i2;
    }

    public void setFontAssetDelegate(e.a.a.a aVar) {
        this.f11503g.O(aVar);
    }

    public void setFrame(int i2) {
        this.f11503g.P(i2);
    }

    public void setImageAssetDelegate(e.a.a.b bVar) {
        this.f11503g.Q(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f11503g.R(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        j();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        j();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        j();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f11503g.S(i2);
    }

    public void setMaxProgress(float f2) {
        this.f11503g.U(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f11503g.W(str);
    }

    public void setMinFrame(int i2) {
        this.f11503g.X(i2);
    }

    public void setMinProgress(float f2) {
        this.f11503g.Z(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f11503g.a0(z);
    }

    public void setProgress(float f2) {
        this.f11503g.b0(f2);
    }

    public void setRenderMode(r rVar) {
        this.t = rVar;
        m();
    }

    public void setRepeatCount(int i2) {
        this.f11503g.c0(i2);
    }

    public void setRepeatMode(int i2) {
        this.f11503g.d0(i2);
    }

    public void setSafeMode(boolean z) {
        this.f11503g.e0(z);
    }

    public void setScale(float f2) {
        this.f11503g.f0(f2);
        if (getDrawable() == this.f11503g) {
            setImageDrawable(null);
            setImageDrawable(this.f11503g);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        e.a.a.g gVar = this.f11503g;
        if (gVar != null) {
            gVar.g0(scaleType);
        }
    }

    public void setSpeed(float f2) {
        this.f11503g.h0(f2);
    }

    public void setTextDelegate(t tVar) {
        this.f11503g.j0(tVar);
    }

    public void t() {
        if (isShown()) {
            this.f11503g.K();
            m();
            return;
        }
        this.f11507l = false;
        this.m = true;
    }

    public void u() {
        this.f11503g.L();
    }

    public void v(InputStream inputStream, String str) {
        setCompositionTask(e.a.a.f.h(inputStream, str));
    }

    public void w(String str, String str2) {
        v(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void x(int i2, int i3) {
        this.f11503g.V(i2, i3);
    }

    public void setMaxFrame(String str) {
        this.f11503g.T(str);
    }

    public void setMinFrame(String str) {
        this.f11503g.Y(str);
    }

    public void setAnimation(String str) {
        this.f11505j = str;
        this.f11506k = 0;
        setCompositionTask(n(str));
    }
}