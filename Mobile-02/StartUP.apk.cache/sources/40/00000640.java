package c.s;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: b  reason: collision with root package name */
    public View f3289b;
    public final Map<String, Object> a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<y> f3290c = new ArrayList<>();

    @Deprecated
    public e0() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            return this.f3289b == e0Var.f3289b && this.a.equals(e0Var.a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f3289b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f3289b + "\n") + "    values:";
        for (String str2 : this.a.keySet()) {
            str = str + "    " + str2 + ": " + this.a.get(str2) + "\n";
        }
        return str;
    }

    public e0(View view) {
        this.f3289b = view;
    }
}