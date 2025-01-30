package e.f.h.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import e.f.h.d.b.b;
import e.f.h.e.q;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DebugControllerOverlayDrawable.java */
/* loaded from: classes2.dex */
public class a extends Drawable implements b {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f12233b;

    /* renamed from: c  reason: collision with root package name */
    private int f12234c;

    /* renamed from: d  reason: collision with root package name */
    private int f12235d;

    /* renamed from: e  reason: collision with root package name */
    private int f12236e;

    /* renamed from: f  reason: collision with root package name */
    private String f12237f;

    /* renamed from: g  reason: collision with root package name */
    private q.b f12238g;

    /* renamed from: j  reason: collision with root package name */
    private int f12240j;

    /* renamed from: k  reason: collision with root package name */
    private int f12241k;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private long y;
    private String z;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f12239h = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private int f12242l = 80;
    private final Paint m = new Paint(1);
    private final Matrix n = new Matrix();
    private final Rect p = new Rect();
    private final RectF q = new RectF();

    public a() {
        e();
    }

    private void b(Canvas canvas, String str, Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.w, this.x, this.m);
        } else {
            canvas.drawText(String.format(str, objArr), this.w, this.x, this.m);
        }
        this.x += this.v;
    }

    private void d(Rect rect, int i2, int i3) {
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / i3, rect.height() / i2)));
        this.m.setTextSize(min);
        int i4 = min + 8;
        this.v = i4;
        int i5 = this.f12242l;
        if (i5 == 80) {
            this.v = i4 * (-1);
        }
        this.t = rect.left + 10;
        this.u = i5 == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    @Override // e.f.h.d.b.b
    public void a(long j2) {
        this.y = j2;
        invalidateSelf();
    }

    int c(int i2, int i3, q.b bVar) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i2 > 0 && i3 > 0) {
            if (bVar != null) {
                Rect rect = this.p;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.n.reset();
                bVar.a(this.n, this.p, i2, i3, 0.0f, 0.0f);
                RectF rectF = this.q;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i2;
                rectF.bottom = i3;
                this.n.mapRect(rectF);
                width = Math.min(width, (int) this.q.width());
                height = Math.min(height, (int) this.q.height());
            }
            float f2 = width;
            float f3 = f2 * 0.1f;
            float f4 = f2 * 0.5f;
            float f5 = height;
            float f6 = 0.1f * f5;
            float f7 = f5 * 0.5f;
            int abs = Math.abs(i2 - width);
            int abs2 = Math.abs(i3 - height);
            float f8 = abs;
            if (f8 < f3 && abs2 < f6) {
                return 1716301648;
            }
            if (f8 < f4 && abs2 < f7) {
                return 1728026624;
            }
        }
        return 1727284022;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(2.0f);
        this.m.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.m);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setColor(c(this.f12234c, this.f12235d, this.f12238g));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.m);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setStrokeWidth(0.0f);
        this.m.setColor(-1);
        this.w = this.t;
        this.x = this.u;
        String str = this.f12233b;
        if (str != null) {
            b(canvas, "IDs: %s, %s", this.a, str);
        } else {
            b(canvas, "ID: %s", this.a);
        }
        b(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        b(canvas, "I: %dx%d", Integer.valueOf(this.f12234c), Integer.valueOf(this.f12235d));
        b(canvas, "I: %d KiB", Integer.valueOf(this.f12236e / 1024));
        String str2 = this.f12237f;
        if (str2 != null) {
            b(canvas, "i format: %s", str2);
        }
        int i2 = this.f12240j;
        if (i2 > 0) {
            b(canvas, "anim: f %d, l %d", Integer.valueOf(i2), Integer.valueOf(this.f12241k));
        }
        q.b bVar = this.f12238g;
        if (bVar != null) {
            b(canvas, "scale: %s", bVar);
        }
        long j2 = this.y;
        if (j2 >= 0) {
            b(canvas, "t: %d ms", Long.valueOf(j2));
        }
        String str3 = this.z;
        if (str3 != null) {
            b(canvas, "origin: %s", str3);
        }
        for (Map.Entry<String, String> entry : this.f12239h.entrySet()) {
            b(canvas, "%s: %s", entry.getKey(), entry.getValue());
        }
    }

    public void e() {
        this.f12234c = -1;
        this.f12235d = -1;
        this.f12236e = -1;
        this.f12239h = new HashMap<>();
        this.f12240j = -1;
        this.f12241k = -1;
        this.f12237f = null;
        f(null);
        this.y = -1L;
        this.z = null;
        invalidateSelf();
    }

    public void f(String str) {
        if (str == null) {
            str = "none";
        }
        this.a = str;
        invalidateSelf();
    }

    public void g(int i2, int i3) {
        this.f12234c = i2;
        this.f12235d = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i2) {
        this.f12236e = i2;
    }

    public void i(String str) {
        this.z = str;
        invalidateSelf();
    }

    public void j(q.b bVar) {
        this.f12238g = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        d(rect, 9, 8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}