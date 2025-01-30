package e.f.b.a;

import android.net.Uri;
import java.util.List;

/* compiled from: MultiCacheKey.java */
/* loaded from: classes2.dex */
public class f implements d {
    final List<d> a;

    public f(List<d> list) {
        this.a = (List) e.f.d.c.i.g(list);
    }

    @Override // e.f.b.a.d
    public boolean a(Uri uri) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (this.a.get(i2).a(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // e.f.b.a.d
    public String b() {
        return this.a.get(0).b();
    }

    public List<d> c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.a.equals(((f) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "MultiCacheKey:" + this.a.toString();
    }
}