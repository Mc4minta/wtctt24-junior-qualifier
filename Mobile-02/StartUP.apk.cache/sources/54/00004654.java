package e.f.j.j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ForwardingRequestListener.java */
/* loaded from: classes2.dex */
public class b implements c {
    private final List<c> a;

    public b(Set<c> set) {
        this.a = new ArrayList(set.size());
        for (c cVar : set) {
            if (cVar != null) {
                this.a.add(cVar);
            }
        }
    }

    private void m(String str, Throwable th) {
        e.f.d.d.a.j("ForwardingRequestListener", str, th);
    }

    @Override // e.f.j.j.c
    public void a(com.facebook.imagepipeline.request.b bVar, Object obj, String str, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).a(bVar, obj, str, z);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestStart", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public void b(String str, String str2) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).b(str, str2);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerStart", e2);
            }
        }
    }

    @Override // e.f.j.j.c
    public void c(com.facebook.imagepipeline.request.b bVar, String str, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).c(bVar, str, z);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public void d(String str, String str2, Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).d(str, str2, map);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public void e(String str, String str2, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).e(str, str2, z);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public boolean f(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.a.get(i2).f(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // e.f.j.j.c
    public void g(com.facebook.imagepipeline.request.b bVar, String str, Throwable th, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).g(bVar, str, th, z);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public void h(String str, String str2, String str3) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).h(str, str2, str3);
            } catch (Exception e2) {
                m("InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public void i(String str, String str2, Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).i(str, str2, map);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // e.f.j.l.m0
    public void j(String str, String str2, Throwable th, Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).j(str, str2, th, map);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }

    @Override // e.f.j.j.c
    public void k(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).k(str);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    public void l(c cVar) {
        this.a.add(cVar);
    }

    public b(c... cVarArr) {
        this.a = new ArrayList(cVarArr.length);
        for (c cVar : cVarArr) {
            if (cVar != null) {
                this.a.add(cVar);
            }
        }
    }
}