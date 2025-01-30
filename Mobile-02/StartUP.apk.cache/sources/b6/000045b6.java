package e.f.h.c;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ForwardingControllerListener.java */
/* loaded from: classes2.dex */
public class f<INFO> implements d<INFO> {
    private final List<d<? super INFO>> a = new ArrayList(2);

    private synchronized void i(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // e.f.h.c.d
    public void a(String str, INFO info) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d<? super INFO> dVar = this.a.get(i2);
                if (dVar != null) {
                    dVar.a(str, info);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onIntermediateImageSet", e2);
            }
        }
    }

    @Override // e.f.h.c.d
    public synchronized void b(String str, INFO info, Animatable animatable) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d<? super INFO> dVar = this.a.get(i2);
                if (dVar != null) {
                    dVar.b(str, info, animatable);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onFinalImageSet", e2);
            }
        }
    }

    @Override // e.f.h.c.d
    public synchronized void c(String str, Throwable th) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d<? super INFO> dVar = this.a.get(i2);
                if (dVar != null) {
                    dVar.c(str, th);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onFailure", e2);
            }
        }
    }

    @Override // e.f.h.c.d
    public synchronized void d(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d<? super INFO> dVar = this.a.get(i2);
                if (dVar != null) {
                    dVar.d(str);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onRelease", e2);
            }
        }
    }

    @Override // e.f.h.c.d
    public synchronized void e(String str, Object obj) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d<? super INFO> dVar = this.a.get(i2);
                if (dVar != null) {
                    dVar.e(str, obj);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onSubmit", e2);
            }
        }
    }

    @Override // e.f.h.c.d
    public void f(String str, Throwable th) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d<? super INFO> dVar = this.a.get(i2);
                if (dVar != null) {
                    dVar.f(str, th);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onIntermediateImageFailed", e2);
            }
        }
    }

    public synchronized void g(d<? super INFO> dVar) {
        this.a.add(dVar);
    }

    public synchronized void h() {
        this.a.clear();
    }

    public synchronized void j(d<? super INFO> dVar) {
        int indexOf = this.a.indexOf(dVar);
        if (indexOf != -1) {
            this.a.set(indexOf, null);
        }
    }
}