package e.a.a.w.k;

import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class n implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f11849b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11850c;

    public n(String str, List<b> list, boolean z) {
        this.a = str;
        this.f11849b = list;
        this.f11850c = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new e.a.a.u.b.d(gVar, aVar, this);
    }

    public List<b> b() {
        return this.f11849b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.f11850c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.f11849b.toArray()) + '}';
    }
}