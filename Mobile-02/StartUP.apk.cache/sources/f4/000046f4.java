package e.f.m.b0.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ResourceDrawableIdHelper.java */
/* loaded from: classes2.dex */
public class c {
    private static volatile c a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Integer> f12817b = new HashMap();

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public Drawable b(Context context, String str) {
        int c2 = c(context, str);
        if (c2 > 0) {
            return context.getResources().getDrawable(c2);
        }
        return null;
    }

    public int c(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String replace = str.toLowerCase().replace("-", "_");
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException unused) {
            synchronized (this) {
                if (this.f12817b.containsKey(replace)) {
                    return this.f12817b.get(replace).intValue();
                }
                int identifier = context.getResources().getIdentifier(replace, "drawable", context.getPackageName());
                this.f12817b.put(replace, Integer.valueOf(identifier));
                return identifier;
            }
        }
    }

    public Uri d(Context context, String str) {
        int c2 = c(context, str);
        return c2 > 0 ? new Uri.Builder().scheme("res").path(String.valueOf(c2)).build() : Uri.EMPTY;
    }
}