package e.a.a.w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class e {
    public static final e a = new e("COMPOSITION");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f11762b;

    /* renamed from: c  reason: collision with root package name */
    private f f11763c;

    public e(String... strArr) {
        this.f11762b = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f11762b;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f11762b.add(str);
        return eVar;
    }

    public boolean c(String str, int i2) {
        if (i2 >= this.f11762b.size()) {
            return false;
        }
        boolean z = i2 == this.f11762b.size() - 1;
        String str2 = this.f11762b.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.f11762b.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f11762b.get(i2 + 1).equals(str)) {
            return i2 == this.f11762b.size() + (-2) || (i2 == this.f11762b.size() + (-3) && b());
        } else if (z) {
            return true;
        } else {
            int i3 = i2 + 1;
            if (i3 < this.f11762b.size() - 1) {
                return false;
            }
            return this.f11762b.get(i3).equals(str);
        }
    }

    public f d() {
        return this.f11763c;
    }

    public int e(String str, int i2) {
        if (f(str)) {
            return 0;
        }
        if (this.f11762b.get(i2).equals("**")) {
            return (i2 != this.f11762b.size() - 1 && this.f11762b.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean g(String str, int i2) {
        if (f(str)) {
            return true;
        }
        if (i2 >= this.f11762b.size()) {
            return false;
        }
        return this.f11762b.get(i2).equals(str) || this.f11762b.get(i2).equals("**") || this.f11762b.get(i2).equals("*");
    }

    public boolean h(String str, int i2) {
        return "__container".equals(str) || i2 < this.f11762b.size() - 1 || this.f11762b.get(i2).equals("**");
    }

    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f11763c = fVar;
        return eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f11762b);
        sb.append(",resolved=");
        sb.append(this.f11763c != null);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.f11762b = new ArrayList(eVar.f11762b);
        this.f11763c = eVar.f11763c;
    }
}