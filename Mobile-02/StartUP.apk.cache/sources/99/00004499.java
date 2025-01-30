package e.a.a.v;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import e.a.a.w.i;
import e.a.a.z.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f11732d;

    /* renamed from: e  reason: collision with root package name */
    private e.a.a.a f11733e;
    private final i<String> a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<i<String>, Typeface> f11730b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f11731c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f11734f = ".ttf";

    public a(Drawable.Callback callback, e.a.a.a aVar) {
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f11732d = null;
            return;
        }
        this.f11732d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        Typeface typeface = this.f11731c.get(str);
        if (typeface != null) {
            return typeface;
        }
        e.a.a.a aVar = this.f11733e;
        if (aVar == null) {
            if (aVar != null) {
                throw null;
            }
            Typeface createFromAsset = Typeface.createFromAsset(this.f11732d, "fonts/" + str + this.f11734f);
            this.f11731c.put(str, createFromAsset);
            return createFromAsset;
        }
        throw null;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.f11730b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.f11730b.put(this.a, d2);
        return d2;
    }

    public void c(e.a.a.a aVar) {
    }
}