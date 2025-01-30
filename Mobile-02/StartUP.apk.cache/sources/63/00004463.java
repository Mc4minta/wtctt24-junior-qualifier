package e.a.a;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class o {
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f11580b = new c.e.b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, e.a.a.z.f> f11581c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<androidx.core.util.e<String, Float>> f11582d = new a();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    class a implements Comparator<androidx.core.util.e<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(androidx.core.util.e<String, Float> eVar, androidx.core.util.e<String, Float> eVar2) {
            float floatValue = eVar.f1541b.floatValue();
            float floatValue2 = eVar2.f1541b.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.a) {
            e.a.a.z.f fVar = this.f11581c.get(str);
            if (fVar == null) {
                fVar = new e.a.a.z.f();
                this.f11581c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                for (b bVar : this.f11580b) {
                    bVar.a(f2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.a = z;
    }
}