package e.f.h.d.b;

import android.graphics.drawable.Animatable;
import e.f.h.c.c;

/* compiled from: ImageLoadingTimeControllerListener.java */
/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private long f12243b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f12244c = -1;

    /* renamed from: d  reason: collision with root package name */
    private b f12245d;

    public a(b bVar) {
        this.f12245d = bVar;
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    public void b(String str, Object obj, Animatable animatable) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f12244c = currentTimeMillis;
        b bVar = this.f12245d;
        if (bVar != null) {
            bVar.a(currentTimeMillis - this.f12243b);
        }
    }

    @Override // e.f.h.c.c, e.f.h.c.d
    public void e(String str, Object obj) {
        this.f12243b = System.currentTimeMillis();
    }
}