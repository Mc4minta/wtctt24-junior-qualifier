package e.g.a.f.l;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f13296b;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f13296b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f13296b.containsKey(drawable)) {
            return this.f13296b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f13296b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}