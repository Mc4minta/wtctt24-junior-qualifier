package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class r0 extends j0 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f883b;

    public r0(Context context, Resources resources) {
        super(resources);
        this.f883b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.j0, android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.f883b.get();
        if (drawable != null && context != null) {
            i0.h().x(context, i2, drawable);
        }
        return drawable;
    }
}