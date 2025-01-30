package e.a.a.u.c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g {
    private final List<a<e.a.a.w.k.l, Path>> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f11704b;

    /* renamed from: c  reason: collision with root package name */
    private final List<e.a.a.w.k.g> f11705c;

    public g(List<e.a.a.w.k.g> list) {
        this.f11705c = list;
        this.a = new ArrayList(list.size());
        this.f11704b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.add(list.get(i2).b().a());
            this.f11704b.add(list.get(i2).c().a());
        }
    }

    public List<a<e.a.a.w.k.l, Path>> a() {
        return this.a;
    }

    public List<e.a.a.w.k.g> b() {
        return this.f11705c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f11704b;
    }
}