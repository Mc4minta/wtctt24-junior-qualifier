package e.f.h.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import e.f.h.e.i;

/* compiled from: DefaultDrawableFactory.java */
/* loaded from: classes2.dex */
public class a implements e.f.j.h.a {
    private final Resources a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.h.a f12134b;

    public a(Resources resources, e.f.j.h.a aVar) {
        this.a = resources;
        this.f12134b = aVar;
    }

    private static boolean c(e.f.j.i.c cVar) {
        return (cVar.j() == 1 || cVar.j() == 0) ? false : true;
    }

    private static boolean d(e.f.j.i.c cVar) {
        return (cVar.m() == 0 || cVar.m() == -1) ? false : true;
    }

    @Override // e.f.j.h.a
    public boolean a(e.f.j.i.b bVar) {
        return true;
    }

    @Override // e.f.j.h.a
    public Drawable b(e.f.j.i.b bVar) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("DefaultDrawableFactory#createDrawable");
            }
            if (bVar instanceof e.f.j.i.c) {
                e.f.j.i.c cVar = (e.f.j.i.c) bVar;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a, cVar.d());
                if (d(cVar) || c(cVar)) {
                    i iVar = new i(bitmapDrawable, cVar.m(), cVar.j());
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                    }
                    return iVar;
                }
                return bitmapDrawable;
            }
            e.f.j.h.a aVar = this.f12134b;
            if (aVar != null && aVar.a(bVar)) {
                Drawable b2 = this.f12134b.b(bVar);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
                return b2;
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return null;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }
}