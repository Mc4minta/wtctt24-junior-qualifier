package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.widget.NestedScrollView;
import com.reactnativecommunity.webview.RNCWebViewManager;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TouchResponse.java */
/* loaded from: classes.dex */
public class u {
    private static final float[][] a = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: b  reason: collision with root package name */
    private static final float[][] f1219b = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private float o;
    private float p;
    private final MotionLayout q;

    /* renamed from: c  reason: collision with root package name */
    private int f1220c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1221d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1222e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1223f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f1224g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f1225h = -1;

    /* renamed from: i  reason: collision with root package name */
    private float f1226i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private float f1227j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private float f1228k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f1229l = 1.0f;
    private boolean m = false;
    private float[] n = new float[2];
    private float r = 4.0f;
    private float s = 1.2f;
    private boolean t = true;
    private float u = 1.0f;
    private int v = 0;
    private float w = 10.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TouchResponse.java */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TouchResponse.java */
    /* loaded from: classes.dex */
    public class b implements NestedScrollView.b {
        b() {
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.q = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index == androidx.constraintlayout.widget.i.P6) {
                this.f1223f = typedArray.getResourceId(index, this.f1223f);
            } else if (index == androidx.constraintlayout.widget.i.Q6) {
                int i3 = typedArray.getInt(index, this.f1220c);
                this.f1220c = i3;
                float[][] fArr = a;
                this.f1227j = fArr[i3][0];
                this.f1226i = fArr[i3][1];
            } else if (index == androidx.constraintlayout.widget.i.G6) {
                int i4 = typedArray.getInt(index, this.f1221d);
                this.f1221d = i4;
                float[][] fArr2 = f1219b;
                this.f1228k = fArr2[i4][0];
                this.f1229l = fArr2[i4][1];
            } else if (index == androidx.constraintlayout.widget.i.L6) {
                this.r = typedArray.getFloat(index, this.r);
            } else if (index == androidx.constraintlayout.widget.i.K6) {
                this.s = typedArray.getFloat(index, this.s);
            } else if (index == androidx.constraintlayout.widget.i.M6) {
                this.t = typedArray.getBoolean(index, this.t);
            } else if (index == androidx.constraintlayout.widget.i.H6) {
                this.u = typedArray.getFloat(index, this.u);
            } else if (index == androidx.constraintlayout.widget.i.I6) {
                this.w = typedArray.getFloat(index, this.w);
            } else if (index == androidx.constraintlayout.widget.i.R6) {
                this.f1224g = typedArray.getResourceId(index, this.f1224g);
            } else if (index == androidx.constraintlayout.widget.i.O6) {
                this.f1222e = typedArray.getInt(index, this.f1222e);
            } else if (index == androidx.constraintlayout.widget.i.N6) {
                this.v = typedArray.getInteger(index, 0);
            } else if (index == androidx.constraintlayout.widget.i.J6) {
                this.f1225h = typedArray.getResourceId(index, 0);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.F6);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a(float f2, float f3) {
        return (f2 * this.f1228k) + (f3 * this.f1229l);
    }

    public int d() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF e(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f1225h;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.s;
    }

    public float g() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i(float f2, float f3) {
        this.q.getAnchorDpDt(this.f1223f, this.q.getProgress(), this.f1227j, this.f1226i, this.n);
        float f4 = this.f1228k;
        if (f4 != 0.0f) {
            float[] fArr = this.n;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f2 * f4) / fArr[0];
        }
        float[] fArr2 = this.n;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f3 * this.f1229l) / fArr2[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF j(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f1224g;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f1224g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(MotionEvent motionEvent, MotionLayout.f fVar, int i2, r rVar) {
        float f2;
        int i3;
        float f3;
        fVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.o = motionEvent.getRawX();
            this.p = motionEvent.getRawY();
            this.m = false;
        } else if (action == 1) {
            this.m = false;
            fVar.d(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
            float c2 = fVar.c();
            float b2 = fVar.b();
            float progress = this.q.getProgress();
            int i4 = this.f1223f;
            if (i4 != -1) {
                this.q.getAnchorDpDt(i4, progress, this.f1227j, this.f1226i, this.n);
            } else {
                float min = Math.min(this.q.getWidth(), this.q.getHeight());
                float[] fArr = this.n;
                fArr[1] = this.f1229l * min;
                fArr[0] = min * this.f1228k;
            }
            float f4 = this.f1228k;
            float[] fArr2 = this.n;
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            if (f4 != 0.0f) {
                f2 = c2 / fArr2[0];
            } else {
                f2 = b2 / fArr2[1];
            }
            float f7 = !Float.isNaN(f2) ? (f2 / 3.0f) + progress : progress;
            if (f7 == 0.0f || f7 == 1.0f || (i3 = this.f1222e) == 3) {
                if (0.0f >= f7 || 1.0f <= f7) {
                    this.q.setState(MotionLayout.j.FINISHED);
                    return;
                }
                return;
            }
            this.q.touchAnimateTo(i3, ((double) f7) < 0.5d ? 0.0f : 1.0f, f2);
            if (0.0f >= progress || 1.0f <= progress) {
                this.q.setState(MotionLayout.j.FINISHED);
            }
        } else if (action != 2) {
        } else {
            float rawY = motionEvent.getRawY() - this.p;
            float rawX = motionEvent.getRawX() - this.o;
            if (Math.abs((this.f1228k * rawX) + (this.f1229l * rawY)) > this.w || this.m) {
                float progress2 = this.q.getProgress();
                if (!this.m) {
                    this.m = true;
                    this.q.setProgress(progress2);
                }
                int i5 = this.f1223f;
                if (i5 != -1) {
                    this.q.getAnchorDpDt(i5, progress2, this.f1227j, this.f1226i, this.n);
                } else {
                    float min2 = Math.min(this.q.getWidth(), this.q.getHeight());
                    float[] fArr3 = this.n;
                    fArr3[1] = this.f1229l * min2;
                    fArr3[0] = min2 * this.f1228k;
                }
                float f8 = this.f1228k;
                float[] fArr4 = this.n;
                if (Math.abs(((f8 * fArr4[0]) + (this.f1229l * fArr4[1])) * this.u) < 0.01d) {
                    float[] fArr5 = this.n;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                if (this.f1228k != 0.0f) {
                    f3 = rawX / this.n[0];
                } else {
                    f3 = rawY / this.n[1];
                }
                float max = Math.max(Math.min(progress2 + f3, 1.0f), 0.0f);
                if (max != this.q.getProgress()) {
                    this.q.setProgress(max);
                    fVar.d(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
                    this.q.mLastVelocity = this.f1228k != 0.0f ? fVar.c() / this.n[0] : fVar.b() / this.n[1];
                } else {
                    this.q.mLastVelocity = 0.0f;
                }
                this.o = motionEvent.getRawX();
                this.p = motionEvent.getRawY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f2, float f3) {
        float f4;
        float progress = this.q.getProgress();
        if (!this.m) {
            this.m = true;
            this.q.setProgress(progress);
        }
        this.q.getAnchorDpDt(this.f1223f, progress, this.f1227j, this.f1226i, this.n);
        float f5 = this.f1228k;
        float[] fArr = this.n;
        if (Math.abs((f5 * fArr[0]) + (this.f1229l * fArr[1])) < 0.01d) {
            float[] fArr2 = this.n;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f6 = this.f1228k;
        if (f6 != 0.0f) {
            f4 = (f2 * f6) / this.n[0];
        } else {
            f4 = (f3 * this.f1229l) / this.n[1];
        }
        float max = Math.max(Math.min(progress + f4, 1.0f), 0.0f);
        if (max != this.q.getProgress()) {
            this.q.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f2, float f3) {
        float f4;
        this.m = false;
        float progress = this.q.getProgress();
        this.q.getAnchorDpDt(this.f1223f, progress, this.f1227j, this.f1226i, this.n);
        float f5 = this.f1228k;
        float[] fArr = this.n;
        float f6 = fArr[0];
        float f7 = this.f1229l;
        float f8 = fArr[1];
        if (f5 != 0.0f) {
            f4 = (f2 * f5) / fArr[0];
        } else {
            f4 = (f3 * f7) / fArr[1];
        }
        if (!Float.isNaN(f4)) {
            progress += f4 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z = progress != 1.0f;
            int i2 = this.f1222e;
            if ((i2 != 3) && z) {
                this.q.touchAnimateTo(i2, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f2, float f3) {
        this.o = f2;
        this.p = f3;
    }

    public void p(boolean z) {
        if (z) {
            float[][] fArr = f1219b;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = a;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f1219b;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = a;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = a;
        int i2 = this.f1220c;
        this.f1227j = fArr5[i2][0];
        this.f1226i = fArr5[i2][1];
        float[][] fArr6 = f1219b;
        int i3 = this.f1221d;
        this.f1228k = fArr6[i3][0];
        this.f1229l = fArr6[i3][1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(float f2, float f3) {
        this.o = f2;
        this.p = f3;
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        View view;
        int i2 = this.f1223f;
        if (i2 != -1) {
            view = this.q.findViewById(i2);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + androidx.constraintlayout.motion.widget.a.b(this.q.getContext(), this.f1223f));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new a());
            nestedScrollView.setOnScrollChangeListener(new b());
        }
    }

    public String toString() {
        return this.f1228k + " , " + this.f1229l;
    }
}