package e.g.a.f.l;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionSpec.java */
/* loaded from: classes2.dex */
public class h {
    private final c.e.g<String, i> a = new c.e.g<>();

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.g(objectAnimator.getPropertyName(), i.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public static h b(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return c(arrayList);
            }
            return null;
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i2), e2);
            return null;
        }
    }

    private static h c(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(hVar, list.get(i2));
        }
        return hVar;
    }

    public i d(String str) {
        if (f(str)) {
            return this.a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long e() {
        int size = this.a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i valueAt = this.a.valueAt(i2);
            j2 = Math.max(j2, valueAt.c() + valueAt.d());
        }
        return j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((h) obj).a);
    }

    public boolean f(String str) {
        return this.a.get(str) != null;
    }

    public void g(String str, i iVar) {
        this.a.put(str, iVar);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}