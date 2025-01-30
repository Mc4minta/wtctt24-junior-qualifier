package c.t.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import c.h.e.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends c.t.a.a.h {

    /* renamed from: b  reason: collision with root package name */
    static final PorterDuff.Mode f3427b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private h f3428c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f3429d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f3430e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3431f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3432g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable.ConstantState f3433h;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f3434j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f3435k;

    /* renamed from: l  reason: collision with root package name */
    private final Rect f3436l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3456b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.a = c.h.e.c.d(string2);
            }
            this.f3457c = androidx.core.content.d.h.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // c.t.a.a.i.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.d.h.j(xmlPullParser, "pathData")) {
                TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3407d);
                f(k2, xmlPullParser);
                k2.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        int a;

        /* renamed from: b  reason: collision with root package name */
        g f3470b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f3471c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f3472d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3473e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f3474f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f3475g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f3476h;

        /* renamed from: i  reason: collision with root package name */
        int f3477i;

        /* renamed from: j  reason: collision with root package name */
        boolean f3478j;

        /* renamed from: k  reason: collision with root package name */
        boolean f3479k;

        /* renamed from: l  reason: collision with root package name */
        Paint f3480l;

        public h(h hVar) {
            this.f3471c = null;
            this.f3472d = i.f3427b;
            if (hVar != null) {
                this.a = hVar.a;
                g gVar = new g(hVar.f3470b);
                this.f3470b = gVar;
                if (hVar.f3470b.f3463f != null) {
                    gVar.f3463f = new Paint(hVar.f3470b.f3463f);
                }
                if (hVar.f3470b.f3462e != null) {
                    this.f3470b.f3462e = new Paint(hVar.f3470b.f3462e);
                }
                this.f3471c = hVar.f3471c;
                this.f3472d = hVar.f3472d;
                this.f3473e = hVar.f3473e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f3474f.getWidth() && i3 == this.f3474f.getHeight();
        }

        public boolean b() {
            return !this.f3479k && this.f3475g == this.f3471c && this.f3476h == this.f3472d && this.f3478j == this.f3473e && this.f3477i == this.f3470b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f3474f == null || !a(i2, i3)) {
                this.f3474f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f3479k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3474f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (f() || colorFilter != null) {
                if (this.f3480l == null) {
                    Paint paint = new Paint();
                    this.f3480l = paint;
                    paint.setFilterBitmap(true);
                }
                this.f3480l.setAlpha(this.f3470b.getRootAlpha());
                this.f3480l.setColorFilter(colorFilter);
                return this.f3480l;
            }
            return null;
        }

        public boolean f() {
            return this.f3470b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f3470b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.f3470b.g(iArr);
            this.f3479k |= g2;
            return g2;
        }

        public void i() {
            this.f3475g = this.f3471c;
            this.f3476h = this.f3472d;
            this.f3477i = this.f3470b.getRootAlpha();
            this.f3478j = this.f3473e;
            this.f3479k = false;
        }

        public void j(int i2, int i3) {
            this.f3474f.eraseColor(0);
            this.f3470b.b(new Canvas(this.f3474f), i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            this.f3471c = null;
            this.f3472d = i.f3427b;
            this.f3470b = new g();
        }
    }

    i() {
        this.f3432g = true;
        this.f3434j = new float[9];
        this.f3435k = new Matrix();
        this.f3436l = new Rect();
        this.f3428c = new h();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static i b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.a = androidx.core.content.d.f.b(resources, i2, theme);
            iVar.f3433h = new C0093i(iVar.a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f3428c;
        g gVar = hVar.f3470b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f3466i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (ClientCookie.PATH_ATTR.equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3445b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.q.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.a = cVar.f3458d | hVar.a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3445b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.q.put(bVar.getPathName(), bVar);
                    }
                    hVar.a = bVar.f3458d | hVar.a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f3445b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.q.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.a = dVar2.f3454k | hVar.a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f3428c;
        g gVar = hVar.f3470b;
        hVar.f3472d = g(androidx.core.content.d.h.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c2 = androidx.core.content.d.h.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c2 != null) {
            hVar.f3471c = c2;
        }
        hVar.f3473e = androidx.core.content.d.h.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f3473e);
        gVar.f3469l = androidx.core.content.d.h.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f3469l);
        float f2 = androidx.core.content.d.h.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.m);
        gVar.m = f2;
        if (gVar.f3469l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f2 > 0.0f) {
            gVar.f3467j = typedArray.getDimension(3, gVar.f3467j);
            float dimension = typedArray.getDimension(2, gVar.f3468k);
            gVar.f3468k = dimension;
            if (gVar.f3467j <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(androidx.core.content.d.h.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.o = string;
                    gVar.q.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable);
            return false;
        }
        return false;
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f3428c.f3470b.q.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f3436l);
        if (this.f3436l.width() <= 0 || this.f3436l.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f3430e;
        if (colorFilter == null) {
            colorFilter = this.f3429d;
        }
        canvas.getMatrix(this.f3435k);
        this.f3435k.getValues(this.f3434j);
        float abs = Math.abs(this.f3434j[0]);
        float abs2 = Math.abs(this.f3434j[4]);
        float abs3 = Math.abs(this.f3434j[1]);
        float abs4 = Math.abs(this.f3434j[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min((int) PKIFailureInfo.wrongIntegrity, (int) (this.f3436l.width() * abs));
        int min2 = Math.min((int) PKIFailureInfo.wrongIntegrity, (int) (this.f3436l.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f3436l;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f3436l.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f3436l.offsetTo(0, 0);
        this.f3428c.c(min, min2);
        if (!this.f3432g) {
            this.f3428c.j(min, min2);
        } else if (!this.f3428c.b()) {
            this.f3428c.j(min, min2);
            this.f3428c.i();
        }
        this.f3428c.d(canvas, colorFilter, this.f3436l);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f3428c.f3470b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f3428c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f3430e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.a != null && Build.VERSION.SDK_INT >= 24) {
            return new C0093i(this.a.getConstantState());
        }
        this.f3428c.a = getChangingConfigurations();
        return this.f3428c;
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f3428c.f3470b.f3468k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f3428c.f3470b.f3467j;
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z) {
        this.f3432g = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f3428c.f3473e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f3428c) != null && (hVar.g() || ((colorStateList = this.f3428c.f3471c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f3431f && super.mutate() == this) {
            this.f3428c = new h(this.f3428c);
            this.f3431f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f3428c;
        ColorStateList colorStateList = hVar.f3471c;
        if (colorStateList != null && (mode = hVar.f3472d) != null) {
            this.f3429d = j(this.f3429d, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.g() && hVar.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f3428c.f3470b.getRootAlpha() != i2) {
            this.f3428c.f3470b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.f3428c.f3473e = z;
        }
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // c.t.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f3428c;
        if (hVar.f3471c != colorStateList) {
            hVar.f3471c = colorStateList;
            this.f3429d = j(this.f3429d, colorStateList, hVar.f3472d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f3428c;
        if (hVar.f3472d != mode) {
            hVar.f3472d = mode;
            this.f3429d = j(this.f3429d, hVar.f3471c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: c.t.a.a.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0093i extends Drawable.ConstantState {
        private final Drawable.ConstantState a;

        public C0093i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.a = (VectorDrawable) this.a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.a = (VectorDrawable) this.a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.a = (VectorDrawable) this.a.newDrawable(resources, theme);
            return iVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f3430e = colorFilter;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f extends e {
        protected c.b[] a;

        /* renamed from: b  reason: collision with root package name */
        String f3456b;

        /* renamed from: c  reason: collision with root package name */
        int f3457c;

        /* renamed from: d  reason: collision with root package name */
        int f3458d;

        public f() {
            super();
            this.a = null;
            this.f3457c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.f3456b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!c.h.e.c.b(this.a, bVarArr)) {
                this.a = c.h.e.c.f(bVarArr);
            } else {
                c.h.e.c.j(this.a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.a = null;
            this.f3457c = 0;
            this.f3456b = fVar.f3456b;
            this.f3458d = fVar.f3458d;
            this.a = c.h.e.c.f(fVar.a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f3428c;
        hVar.f3470b = new g();
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.a);
        i(k2, xmlPullParser, theme);
        k2.recycle();
        hVar.a = getChangingConfigurations();
        hVar.f3479k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f3429d = j(this.f3429d, hVar.f3471c, hVar.f3472d);
    }

    i(h hVar) {
        this.f3432g = true;
        this.f3434j = new float[9];
        this.f3435k = new Matrix();
        this.f3436l = new Rect();
        this.f3428c = hVar;
        this.f3429d = j(this.f3429d, hVar.f3471c, hVar.f3472d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f3437e;

        /* renamed from: f  reason: collision with root package name */
        androidx.core.content.d.b f3438f;

        /* renamed from: g  reason: collision with root package name */
        float f3439g;

        /* renamed from: h  reason: collision with root package name */
        androidx.core.content.d.b f3440h;

        /* renamed from: i  reason: collision with root package name */
        float f3441i;

        /* renamed from: j  reason: collision with root package name */
        float f3442j;

        /* renamed from: k  reason: collision with root package name */
        float f3443k;

        /* renamed from: l  reason: collision with root package name */
        float f3444l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        c() {
            this.f3439g = 0.0f;
            this.f3441i = 1.0f;
            this.f3442j = 1.0f;
            this.f3443k = 0.0f;
            this.f3444l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return i2 != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return i2 != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f3437e = null;
            if (androidx.core.content.d.h.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3456b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.a = c.h.e.c.d(string2);
                }
                this.f3440h = androidx.core.content.d.h.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f3442j = androidx.core.content.d.h.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f3442j);
                this.n = e(androidx.core.content.d.h.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(androidx.core.content.d.h.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.d.h.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f3438f = androidx.core.content.d.h.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f3441i = androidx.core.content.d.h.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3441i);
                this.f3439g = androidx.core.content.d.h.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f3439g);
                this.f3444l = androidx.core.content.d.h.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f3444l);
                this.m = androidx.core.content.d.h.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.f3443k = androidx.core.content.d.h.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f3443k);
                this.f3457c = androidx.core.content.d.h.g(typedArray, xmlPullParser, "fillType", 13, this.f3457c);
            }
        }

        @Override // c.t.a.a.i.e
        public boolean a() {
            return this.f3440h.i() || this.f3438f.i();
        }

        @Override // c.t.a.a.i.e
        public boolean b(int[] iArr) {
            return this.f3438f.j(iArr) | this.f3440h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3406c);
            h(k2, xmlPullParser, theme);
            k2.recycle();
        }

        float getFillAlpha() {
            return this.f3442j;
        }

        int getFillColor() {
            return this.f3440h.e();
        }

        float getStrokeAlpha() {
            return this.f3441i;
        }

        int getStrokeColor() {
            return this.f3438f.e();
        }

        float getStrokeWidth() {
            return this.f3439g;
        }

        float getTrimPathEnd() {
            return this.f3444l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.f3443k;
        }

        void setFillAlpha(float f2) {
            this.f3442j = f2;
        }

        void setFillColor(int i2) {
            this.f3440h.k(i2);
        }

        void setStrokeAlpha(float f2) {
            this.f3441i = f2;
        }

        void setStrokeColor(int i2) {
            this.f3438f.k(i2);
        }

        void setStrokeWidth(float f2) {
            this.f3439g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.f3444l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        void setTrimPathStart(float f2) {
            this.f3443k = f2;
        }

        c(c cVar) {
            super(cVar);
            this.f3439g = 0.0f;
            this.f3441i = 1.0f;
            this.f3442j = 1.0f;
            this.f3443k = 0.0f;
            this.f3444l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f3437e = cVar.f3437e;
            this.f3438f = cVar.f3438f;
            this.f3439g = cVar.f3439g;
            this.f3441i = cVar.f3441i;
            this.f3440h = cVar.f3440h;
            this.f3457c = cVar.f3457c;
            this.f3442j = cVar.f3442j;
            this.f3443k = cVar.f3443k;
            this.f3444l = cVar.f3444l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final Path f3459b;

        /* renamed from: c  reason: collision with root package name */
        private final Path f3460c;

        /* renamed from: d  reason: collision with root package name */
        private final Matrix f3461d;

        /* renamed from: e  reason: collision with root package name */
        Paint f3462e;

        /* renamed from: f  reason: collision with root package name */
        Paint f3463f;

        /* renamed from: g  reason: collision with root package name */
        private PathMeasure f3464g;

        /* renamed from: h  reason: collision with root package name */
        private int f3465h;

        /* renamed from: i  reason: collision with root package name */
        final d f3466i;

        /* renamed from: j  reason: collision with root package name */
        float f3467j;

        /* renamed from: k  reason: collision with root package name */
        float f3468k;

        /* renamed from: l  reason: collision with root package name */
        float f3469l;
        float m;
        int n;
        String o;
        Boolean p;
        final c.e.a<String, Object> q;

        public g() {
            this.f3461d = new Matrix();
            this.f3467j = 0.0f;
            this.f3468k = 0.0f;
            this.f3469l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new c.e.a<>();
            this.f3466i = new d();
            this.f3459b = new Path();
            this.f3460c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.f3453j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f3445b.size(); i4++) {
                e eVar = dVar.f3445b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.f3469l;
            float f3 = i3 / this.m;
            float min = Math.min(f2, f3);
            Matrix matrix = dVar.a;
            this.f3461d.set(matrix);
            this.f3461d.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 == 0.0f) {
                return;
            }
            fVar.d(this.f3459b);
            Path path = this.f3459b;
            this.f3460c.reset();
            if (fVar.c()) {
                this.f3460c.setFillType(fVar.f3457c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f3460c.addPath(path, this.f3461d);
                canvas.clipPath(this.f3460c);
                return;
            }
            c cVar = (c) fVar;
            float f4 = cVar.f3443k;
            if (f4 != 0.0f || cVar.f3444l != 1.0f) {
                float f5 = cVar.m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.f3444l + f5) % 1.0f;
                if (this.f3464g == null) {
                    this.f3464g = new PathMeasure();
                }
                this.f3464g.setPath(this.f3459b, false);
                float length = this.f3464g.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f3464g.getSegment(f8, length, path, true);
                    this.f3464g.getSegment(0.0f, f9, path, true);
                } else {
                    this.f3464g.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f3460c.addPath(path, this.f3461d);
            if (cVar.f3440h.l()) {
                androidx.core.content.d.b bVar = cVar.f3440h;
                if (this.f3463f == null) {
                    Paint paint = new Paint(1);
                    this.f3463f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f3463f;
                if (bVar.h()) {
                    Shader f10 = bVar.f();
                    f10.setLocalMatrix(this.f3461d);
                    paint2.setShader(f10);
                    paint2.setAlpha(Math.round(cVar.f3442j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(i.a(bVar.e(), cVar.f3442j));
                }
                paint2.setColorFilter(colorFilter);
                this.f3460c.setFillType(cVar.f3457c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f3460c, paint2);
            }
            if (cVar.f3438f.l()) {
                androidx.core.content.d.b bVar2 = cVar.f3438f;
                if (this.f3462e == null) {
                    Paint paint3 = new Paint(1);
                    this.f3462e = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f3462e;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (bVar2.h()) {
                    Shader f11 = bVar2.f();
                    f11.setLocalMatrix(this.f3461d);
                    paint4.setShader(f11);
                    paint4.setAlpha(Math.round(cVar.f3441i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(i.a(bVar2.e(), cVar.f3441i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f3439g * min * e2);
                canvas.drawPath(this.f3460c, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f3466i, a, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.f3466i.a());
            }
            return this.p.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f3466i.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.n = i2;
        }

        public g(g gVar) {
            this.f3461d = new Matrix();
            this.f3467j = 0.0f;
            this.f3468k = 0.0f;
            this.f3469l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            c.e.a<String, Object> aVar = new c.e.a<>();
            this.q = aVar;
            this.f3466i = new d(gVar.f3466i, aVar);
            this.f3459b = new Path(gVar.f3459b);
            this.f3460c = new Path(gVar.f3460c);
            this.f3467j = gVar.f3467j;
            this.f3468k = gVar.f3468k;
            this.f3469l = gVar.f3469l;
            this.m = gVar.m;
            this.f3465h = gVar.f3465h;
            this.n = gVar.n;
            this.o = gVar.o;
            String str = gVar.o;
            if (str != null) {
                aVar.put(str, this);
            }
            this.p = gVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {
        final Matrix a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f3445b;

        /* renamed from: c  reason: collision with root package name */
        float f3446c;

        /* renamed from: d  reason: collision with root package name */
        private float f3447d;

        /* renamed from: e  reason: collision with root package name */
        private float f3448e;

        /* renamed from: f  reason: collision with root package name */
        private float f3449f;

        /* renamed from: g  reason: collision with root package name */
        private float f3450g;

        /* renamed from: h  reason: collision with root package name */
        private float f3451h;

        /* renamed from: i  reason: collision with root package name */
        private float f3452i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f3453j;

        /* renamed from: k  reason: collision with root package name */
        int f3454k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f3455l;
        private String m;

        public d(d dVar, c.e.a<String, Object> aVar) {
            super();
            f bVar;
            this.a = new Matrix();
            this.f3445b = new ArrayList<>();
            this.f3446c = 0.0f;
            this.f3447d = 0.0f;
            this.f3448e = 0.0f;
            this.f3449f = 1.0f;
            this.f3450g = 1.0f;
            this.f3451h = 0.0f;
            this.f3452i = 0.0f;
            Matrix matrix = new Matrix();
            this.f3453j = matrix;
            this.m = null;
            this.f3446c = dVar.f3446c;
            this.f3447d = dVar.f3447d;
            this.f3448e = dVar.f3448e;
            this.f3449f = dVar.f3449f;
            this.f3450g = dVar.f3450g;
            this.f3451h = dVar.f3451h;
            this.f3452i = dVar.f3452i;
            this.f3455l = dVar.f3455l;
            String str = dVar.m;
            this.m = str;
            this.f3454k = dVar.f3454k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f3453j);
            ArrayList<e> arrayList = dVar.f3445b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f3445b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f3445b.add(bVar);
                    String str2 = bVar.f3456b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f3453j.reset();
            this.f3453j.postTranslate(-this.f3447d, -this.f3448e);
            this.f3453j.postScale(this.f3449f, this.f3450g);
            this.f3453j.postRotate(this.f3446c, 0.0f, 0.0f);
            this.f3453j.postTranslate(this.f3451h + this.f3447d, this.f3452i + this.f3448e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f3455l = null;
            this.f3446c = androidx.core.content.d.h.f(typedArray, xmlPullParser, "rotation", 5, this.f3446c);
            this.f3447d = typedArray.getFloat(1, this.f3447d);
            this.f3448e = typedArray.getFloat(2, this.f3448e);
            this.f3449f = androidx.core.content.d.h.f(typedArray, xmlPullParser, "scaleX", 3, this.f3449f);
            this.f3450g = androidx.core.content.d.h.f(typedArray, xmlPullParser, "scaleY", 4, this.f3450g);
            this.f3451h = androidx.core.content.d.h.f(typedArray, xmlPullParser, "translateX", 6, this.f3451h);
            this.f3452i = androidx.core.content.d.h.f(typedArray, xmlPullParser, "translateY", 7, this.f3452i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // c.t.a.a.i.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f3445b.size(); i2++) {
                if (this.f3445b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // c.t.a.a.i.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f3445b.size(); i2++) {
                z |= this.f3445b.get(i2).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3405b);
            e(k2, xmlPullParser);
            k2.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f3453j;
        }

        public float getPivotX() {
            return this.f3447d;
        }

        public float getPivotY() {
            return this.f3448e;
        }

        public float getRotation() {
            return this.f3446c;
        }

        public float getScaleX() {
            return this.f3449f;
        }

        public float getScaleY() {
            return this.f3450g;
        }

        public float getTranslateX() {
            return this.f3451h;
        }

        public float getTranslateY() {
            return this.f3452i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f3447d) {
                this.f3447d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f3448e) {
                this.f3448e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f3446c) {
                this.f3446c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f3449f) {
                this.f3449f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f3450g) {
                this.f3450g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3451h) {
                this.f3451h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f3452i) {
                this.f3452i = f2;
                d();
            }
        }

        public d() {
            super();
            this.a = new Matrix();
            this.f3445b = new ArrayList<>();
            this.f3446c = 0.0f;
            this.f3447d = 0.0f;
            this.f3448e = 0.0f;
            this.f3449f = 1.0f;
            this.f3450g = 1.0f;
            this.f3451h = 0.0f;
            this.f3452i = 0.0f;
            this.f3453j = new Matrix();
            this.m = null;
        }
    }
}