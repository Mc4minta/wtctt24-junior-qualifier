package e.j.l.r;

import android.graphics.Paint;
import kotlin.jvm.internal.m;

/* compiled from: Palette.kt */
/* loaded from: classes2.dex */
public final class d {
    private final Paint a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f13737b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f13738c;

    public d(kotlin.e0.c.a<Integer> colorGenerator) {
        m.g(colorGenerator, "colorGenerator");
        this.a = d(colorGenerator);
        this.f13737b = d(colorGenerator);
        this.f13738c = d(colorGenerator);
    }

    private final Paint d(kotlin.e0.c.a<Integer> aVar) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(aVar.invoke().intValue());
        return paint;
    }

    public final Paint a() {
        return this.f13737b;
    }

    public final Paint b() {
        return this.a;
    }

    public final Paint c() {
        return this.f13738c;
    }
}