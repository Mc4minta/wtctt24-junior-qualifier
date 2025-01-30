package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.p0;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.Comparator;

/* compiled from: ReactTextView.java */
/* loaded from: classes2.dex */
public class r extends AppCompatTextView implements com.facebook.react.uimanager.t {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewGroup.LayoutParams f5446e = new ViewGroup.LayoutParams(0, 0);

    /* renamed from: f  reason: collision with root package name */
    private boolean f5447f;

    /* renamed from: g  reason: collision with root package name */
    private int f5448g;

    /* renamed from: h  reason: collision with root package name */
    private int f5449h;

    /* renamed from: j  reason: collision with root package name */
    private int f5450j;

    /* renamed from: k  reason: collision with root package name */
    private int f5451k;

    /* renamed from: l  reason: collision with root package name */
    private TextUtils.TruncateAt f5452l;
    private boolean m;
    private int n;
    private boolean p;
    private com.facebook.react.views.view.e q;
    private Spannable t;

    /* compiled from: ReactTextView.java */
    /* loaded from: classes2.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((WritableMap) obj).getInt("index") - ((WritableMap) obj2).getInt("index");
        }
    }

    public r(Context context) {
        super(context);
        this.f5450j = 0;
        this.f5451k = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f5452l = TextUtils.TruncateAt.END;
        this.m = false;
        this.n = 0;
        this.q = new com.facebook.react.views.view.e(this);
        this.f5448g = getGravity() & 8388615;
        this.f5449h = getGravity() & 112;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof p0) {
            context = ((p0) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    private static WritableMap h(int i2, int i3, int i4, int i5, int i6, int i7) {
        WritableMap createMap = Arguments.createMap();
        if (i2 == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i3);
        } else if (i2 == 0) {
            createMap.putString("visibility", "visible");
            createMap.putInt("index", i3);
            createMap.putDouble("left", com.facebook.react.uimanager.o.a(i4));
            createMap.putDouble("top", com.facebook.react.uimanager.o.a(i5));
            createMap.putDouble("right", com.facebook.react.uimanager.o.a(i6));
            createMap.putDouble("bottom", com.facebook.react.uimanager.o.a(i7));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt("index", i3);
        }
        return createMap;
    }

    @Override // com.facebook.react.uimanager.t
    public int c(float f2, float f3) {
        int i2;
        CharSequence text = getText();
        int id = getId();
        int i3 = (int) f2;
        int i4 = (int) f3;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i4);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i3 >= lineLeft && i3 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, i3);
                n[] nVarArr = (n[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, n.class);
                if (nVarArr != null) {
                    int length = text.length();
                    for (int i5 = 0; i5 < nVarArr.length; i5++) {
                        int spanStart = spanned.getSpanStart(nVarArr[i5]);
                        int spanEnd = spanned.getSpanEnd(nVarArr[i5]);
                        if (spanEnd > offsetForHorizontal && (i2 = spanEnd - spanStart) <= length) {
                            id = nVarArr[i5].a();
                            length = i2;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e.f.d.d.a.i("ReactNative", "Crash in HorizontalMeasurementProvider: " + e2.getMessage());
            }
        }
        return id;
    }

    public Spannable getSpanned() {
        return this.t;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void i(int i2, float f2, float f3) {
        this.q.c(i2, f2, f3);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.f5447f && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (z zVar : (z[]) spanned.getSpans(0, spanned.length(), z.class)) {
                if (zVar.a() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void j(float f2, int i2) {
        this.q.e(f2, i2);
    }

    public void k(int i2, float f2) {
        this.q.g(i2, f2);
    }

    public void l() {
        setEllipsize((this.f5451k == Integer.MAX_VALUE || this.m) ? null : this.f5452l);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5447f && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (z zVar : (z[]) spanned.getSpans(0, spanned.length(), z.class)) {
                zVar.c();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5447f && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (z zVar : (z[]) spanned.getSpans(0, spanned.length(), z.class)) {
                zVar.d();
            }
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f5447f && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (z zVar : (z[]) spanned.getSpans(0, spanned.length(), z.class)) {
                zVar.e();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00da, code lost:
        if (r2 != false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143 A[SYNTHETIC] */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.r.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f5447f && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (z zVar : (z[]) spanned.getSpans(0, spanned.length(), z.class)) {
                zVar.f();
            }
        }
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.q.b(i2);
    }

    public void setBorderRadius(float f2) {
        this.q.d(f2);
    }

    public void setBorderStyle(String str) {
        this.q.f(str);
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.f5452l = truncateAt;
    }

    void setGravityHorizontal(int i2) {
        if (i2 == 0) {
            i2 = this.f5448g;
        }
        setGravity(i2 | (getGravity() & (-8) & (-8388616)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGravityVertical(int i2) {
        if (i2 == 0) {
            i2 = this.f5449h;
        }
        setGravity(i2 | (getGravity() & (-113)));
    }

    public void setLinkifyMask(int i2) {
        this.n = i2;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.p = z;
    }

    public void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        }
        this.f5451k = i2;
        setSingleLine(i2 == 1);
        setMaxLines(this.f5451k);
    }

    public void setSpanned(Spannable spannable) {
        this.t = spannable;
    }

    public void setText(q qVar) {
        int i2;
        this.f5447f = qVar.b();
        if (getLayoutParams() == null) {
            setLayoutParams(f5446e);
        }
        Spannable k2 = qVar.k();
        int i3 = this.n;
        if (i3 > 0) {
            Linkify.addLinks(k2, i3);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(k2);
        float f2 = qVar.f();
        float h2 = qVar.h();
        float g2 = qVar.g();
        float e2 = qVar.e();
        if (f2 != -1.0f && e2 != -1.0f && g2 != -1.0f && i2 != 0) {
            setPadding((int) Math.floor(f2), (int) Math.floor(h2), (int) Math.floor(g2), (int) Math.floor(e2));
        }
        int l2 = qVar.l();
        if (this.f5450j != l2) {
            this.f5450j = l2;
        }
        setGravityHorizontal(this.f5450j);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23 && getBreakStrategy() != qVar.m()) {
            setBreakStrategy(qVar.m());
        }
        if (i4 >= 26 && getJustificationMode() != qVar.d()) {
            setJustificationMode(qVar.d());
        }
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.f5447f && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (z zVar : (z[]) spanned.getSpans(0, spanned.length(), z.class)) {
                if (zVar.a() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}