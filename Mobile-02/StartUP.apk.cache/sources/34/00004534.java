package e.f.b.a;

import android.net.Uri;

/* compiled from: SimpleCacheKey.java */
/* loaded from: classes2.dex */
public class i implements d {
    final String a;

    public i(String str) {
        this.a = (String) e.f.d.c.i.g(str);
    }

    @Override // e.f.b.a.d
    public boolean a(Uri uri) {
        return this.a.contains(uri.toString());
    }

    @Override // e.f.b.a.d
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return this.a.equals(((i) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}