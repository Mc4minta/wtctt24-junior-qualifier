package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.reactnativecommunity.webview.RNCWebViewManager;
import org.apache.http.message.TokenParser;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> a = new a(Float.class, "thumbPos");

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f709b = {16842912};
    private float A;
    private VelocityTracker B;
    private int C;
    float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private final TextPaint L;
    private ColorStateList M;
    private Layout N;
    private Layout O;
    private TransformationMethod P;
    ObjectAnimator Q;
    private final u R;
    private final Rect S;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f710c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f711d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f712e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f713f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f714g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f715h;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f716j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f717k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f718l;
    private boolean m;
    private int n;
    private int p;
    private int q;
    private boolean t;
    private CharSequence u;
    private CharSequence v;
    private boolean w;
    private int x;
    private int y;
    private float z;

    /* loaded from: classes.dex */
    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.D);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private void a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, a, z ? 1.0f : 0.0f);
        this.Q = ofFloat;
        ofFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.Q.setAutoCancel(true);
        }
        this.Q.start();
    }

    private void b() {
        Drawable drawable = this.f710c;
        if (drawable != null) {
            if (this.f713f || this.f714g) {
                Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f710c = mutate;
                if (this.f713f) {
                    androidx.core.graphics.drawable.a.o(mutate, this.f711d);
                }
                if (this.f714g) {
                    androidx.core.graphics.drawable.a.p(this.f710c, this.f712e);
                }
                if (this.f710c.isStateful()) {
                    this.f710c.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f715h;
        if (drawable != null) {
            if (this.f718l || this.m) {
                Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f715h = mutate;
                if (this.f718l) {
                    androidx.core.graphics.drawable.a.o(mutate, this.f716j);
                }
                if (this.m) {
                    androidx.core.graphics.drawable.a.p(this.f715h, this.f717k);
                }
                if (this.f715h.isStateful()) {
                    this.f715h.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.Q;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private boolean g(float f2, float f3) {
        if (this.f710c == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f710c.getPadding(this.S);
        int i2 = this.I;
        int i3 = this.y;
        int i4 = i2 - i3;
        int i5 = (this.H + thumbOffset) - i3;
        Rect rect = this.S;
        return f2 > ((float) i5) && f2 < ((float) ((((this.G + i5) + rect.left) + rect.right) + i3)) && f3 > ((float) i4) && f3 < ((float) (this.K + i3));
    }

    private boolean getTargetCheckedState() {
        return this.D > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (y0.b(this)) {
            f2 = 1.0f - this.D;
        } else {
            f2 = this.D;
        }
        return (int) ((f2 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f715h;
        if (drawable != null) {
            Rect rect2 = this.S;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f710c;
            if (drawable2 != null) {
                rect = z.d(drawable2);
            } else {
                rect = z.f952c;
            }
            return ((((this.E - this.G) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.P;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.L;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 != 2) {
            typeface = i2 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        j(typeface, i3);
    }

    private void l(MotionEvent motionEvent) {
        this.x = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.B.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
            float xVelocity = this.B.getXVelocity();
            if (Math.abs(xVelocity) > this.C) {
                if (!y0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z = false;
                }
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        e(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.S;
        int i4 = this.H;
        int i5 = this.I;
        int i6 = this.J;
        int i7 = this.K;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f710c;
        if (drawable != null) {
            rect = z.d(drawable);
        } else {
            rect = z.f952c;
        }
        Drawable drawable2 = this.f715h;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f715h.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f715h.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f710c;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.G + rect2.right;
            this.f710c.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f710c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f2, f3);
        }
        Drawable drawable2 = this.f715h;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f710c;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f715h;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!y0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.q : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (y0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.q : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.w;
    }

    public boolean getSplitTrack() {
        return this.t;
    }

    public int getSwitchMinWidth() {
        return this.p;
    }

    public int getSwitchPadding() {
        return this.q;
    }

    public CharSequence getTextOff() {
        return this.v;
    }

    public CharSequence getTextOn() {
        return this.u;
    }

    public Drawable getThumbDrawable() {
        return this.f710c;
    }

    public int getThumbTextPadding() {
        return this.n;
    }

    public ColorStateList getThumbTintList() {
        return this.f711d;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f712e;
    }

    public Drawable getTrackDrawable() {
        return this.f715h;
    }

    public ColorStateList getTrackTintList() {
        return this.f716j;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f717k;
    }

    public void i(Context context, int i2) {
        s0 t = s0.t(context, i2, c.a.j.X2);
        ColorStateList c2 = t.c(c.a.j.b3);
        if (c2 != null) {
            this.M = c2;
        } else {
            this.M = getTextColors();
        }
        int f2 = t.f(c.a.j.Y2, 0);
        if (f2 != 0) {
            float f3 = f2;
            if (f3 != this.L.getTextSize()) {
                this.L.setTextSize(f3);
                requestLayout();
            }
        }
        k(t.k(c.a.j.Z2, -1), t.k(c.a.j.a3, -1));
        if (t.a(c.a.j.m3, false)) {
            this.P = new c.a.n.a(getContext());
        } else {
            this.P = null;
        }
        t.w();
    }

    public void j(Typeface typeface, int i2) {
        Typeface create;
        if (i2 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i2);
            } else {
                create = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(create);
            int i3 = (~(create != null ? create.getStyle() : 0)) & i2;
            this.L.setFakeBoldText((i3 & 1) != 0);
            this.L.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.L.setFakeBoldText(false);
        this.L.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f710c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f715h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.Q;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.Q.end();
        this.Q = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, f709b);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.S;
        Drawable drawable = this.f715h;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.I;
        int i3 = this.K;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f710c;
        if (drawable != null) {
            if (this.t && drawable2 != null) {
                Rect d2 = z.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.N : this.O;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.M;
            if (colorStateList != null) {
                this.L.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.L.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.u : this.v;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(TokenParser.SP);
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        super.onLayout(z, i2, i3, i4, i5);
        int i10 = 0;
        if (this.f710c != null) {
            Rect rect = this.S;
            Drawable drawable = this.f715h;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = z.d(this.f710c);
            i6 = Math.max(0, d2.left - rect.left);
            i10 = Math.max(0, d2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (y0.b(this)) {
            i7 = getPaddingLeft() + i6;
            width = ((this.E + i7) - i6) - i10;
        } else {
            width = (getWidth() - getPaddingRight()) - i10;
            i7 = (width - this.E) + i6 + i10;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i8 = this.F;
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i8 / 2);
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            i8 = this.F;
        } else {
            i9 = getHeight() - getPaddingBottom();
            paddingTop = i9 - this.F;
            this.H = i7;
            this.I = paddingTop;
            this.K = i9;
            this.J = width;
        }
        i9 = i8 + paddingTop;
        this.H = i7;
        this.I = paddingTop;
        this.K = i9;
        this.J = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.w) {
            if (this.N == null) {
                this.N = h(this.u);
            }
            if (this.O == null) {
                this.O = h(this.v);
            }
        }
        Rect rect = this.S;
        Drawable drawable = this.f710c;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f710c.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.f710c.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        this.G = Math.max(this.w ? Math.max(this.N.getWidth(), this.O.getWidth()) + (this.n * 2) : 0, i4);
        Drawable drawable2 = this.f715h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f715h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f710c;
        if (drawable3 != null) {
            Rect d2 = z.d(drawable3);
            i7 = Math.max(i7, d2.left);
            i8 = Math.max(i8, d2.right);
        }
        int max = Math.max(this.p, (this.G * 2) + i7 + i8);
        int max2 = Math.max(i6, i5);
        this.E = max;
        this.F = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.u : this.v;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.B
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.x
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.z
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = androidx.appcompat.widget.y0.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.D
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.D
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.z = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.z
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.y
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.A
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.y
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.x = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.z = r0
            r6.A = r3
            return r1
        L89:
            int r0 = r6.x
            if (r0 != r2) goto L94
            r6.l(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.x = r0
            android.view.VelocityTracker r0 = r6.B
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.g(r0, r2)
            if (r3 == 0) goto Lb7
            r6.x = r1
            r6.z = r0
            r6.A = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && c.h.k.v.S(this)) {
            a(isChecked);
            return;
        }
        d();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.s(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.w != z) {
            this.w = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.t = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.p = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.L.getTypeface() == null || this.L.getTypeface().equals(typeface)) && (this.L.getTypeface() != null || typeface == null)) {
            return;
        }
        this.L.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.v = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.u = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f710c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f710c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f2) {
        this.D = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f711d = colorStateList;
        this.f713f = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f712e = mode;
        this.f714g = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f715h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f715h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(c.a.k.a.a.d(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f716j = colorStateList;
        this.f718l = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f717k = mode;
        this.m = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f710c || drawable == this.f715h;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.L);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f711d = null;
        this.f712e = null;
        this.f713f = false;
        this.f714g = false;
        this.f716j = null;
        this.f717k = null;
        this.f718l = false;
        this.m = false;
        this.B = VelocityTracker.obtain();
        this.S = new Rect();
        n0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.L = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = c.a.j.I2;
        s0 v = s0.v(context, attributeSet, iArr, i2, 0);
        c.h.k.v.i0(this, context, iArr, attributeSet, v.r(), i2, 0);
        Drawable g2 = v.g(c.a.j.L2);
        this.f710c = g2;
        if (g2 != null) {
            g2.setCallback(this);
        }
        Drawable g3 = v.g(c.a.j.U2);
        this.f715h = g3;
        if (g3 != null) {
            g3.setCallback(this);
        }
        this.u = v.p(c.a.j.J2);
        this.v = v.p(c.a.j.K2);
        this.w = v.a(c.a.j.M2, true);
        this.n = v.f(c.a.j.R2, 0);
        this.p = v.f(c.a.j.O2, 0);
        this.q = v.f(c.a.j.P2, 0);
        this.t = v.a(c.a.j.N2, false);
        ColorStateList c2 = v.c(c.a.j.S2);
        if (c2 != null) {
            this.f711d = c2;
            this.f713f = true;
        }
        PorterDuff.Mode e2 = z.e(v.k(c.a.j.T2, -1), null);
        if (this.f712e != e2) {
            this.f712e = e2;
            this.f714g = true;
        }
        if (this.f713f || this.f714g) {
            b();
        }
        ColorStateList c3 = v.c(c.a.j.V2);
        if (c3 != null) {
            this.f716j = c3;
            this.f718l = true;
        }
        PorterDuff.Mode e3 = z.e(v.k(c.a.j.W2, -1), null);
        if (this.f717k != e3) {
            this.f717k = e3;
            this.m = true;
        }
        if (this.f718l || this.m) {
            c();
        }
        int n = v.n(c.a.j.Q2, 0);
        if (n != 0) {
            i(context, n);
        }
        u uVar = new u(this);
        this.R = uVar;
        uVar.m(attributeSet, i2);
        v.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.y = viewConfiguration.getScaledTouchSlop();
        this.C = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}