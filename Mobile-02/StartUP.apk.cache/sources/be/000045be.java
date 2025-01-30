package e.f.h.e;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import org.apache.http.HttpHeaders;

/* compiled from: DrawableProperties.java */
/* loaded from: classes2.dex */
public class d {
    private int a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12258b = false;

    /* renamed from: c  reason: collision with root package name */
    private ColorFilter f12259c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f12260d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f12261e = -1;

    @SuppressLint({HttpHeaders.RANGE})
    public void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        int i2 = this.a;
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        if (this.f12258b) {
            drawable.setColorFilter(this.f12259c);
        }
        int i3 = this.f12260d;
        if (i3 != -1) {
            drawable.setDither(i3 != 0);
        }
        int i4 = this.f12261e;
        if (i4 != -1) {
            drawable.setFilterBitmap(i4 != 0);
        }
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void c(ColorFilter colorFilter) {
        this.f12259c = colorFilter;
        this.f12258b = true;
    }

    public void d(boolean z) {
        this.f12260d = z ? 1 : 0;
    }

    public void e(boolean z) {
        this.f12261e = z ? 1 : 0;
    }
}