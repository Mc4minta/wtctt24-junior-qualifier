package c.s;

import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class u {
    private ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f3360b;

    public static u b(ViewGroup viewGroup) {
        return (u) viewGroup.getTag(s.f3354f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, u uVar) {
        viewGroup.setTag(s.f3354f, uVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.a) != this || (runnable = this.f3360b) == null) {
            return;
        }
        runnable.run();
    }
}