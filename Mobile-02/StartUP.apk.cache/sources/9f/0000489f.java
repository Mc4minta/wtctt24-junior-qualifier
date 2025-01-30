package e.g.b.a.b.e;

import com.google.api.client.http.m;
import com.google.api.client.http.o;
import com.google.api.client.http.r;
import com.google.api.client.http.v;
import e.g.b.a.d.y;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: MediaUploadErrorHandler.java */
/* loaded from: classes2.dex */
class e implements v, m {
    static final Logger a = Logger.getLogger(e.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final c f13374b;

    /* renamed from: c  reason: collision with root package name */
    private final m f13375c;

    /* renamed from: d  reason: collision with root package name */
    private final v f13376d;

    public e(c cVar, o oVar) {
        this.f13374b = (c) y.d(cVar);
        this.f13375c = oVar.f();
        this.f13376d = oVar.n();
        oVar.t(this);
        oVar.z(this);
    }

    @Override // com.google.api.client.http.m
    public boolean a(o oVar, boolean z) throws IOException {
        m mVar = this.f13375c;
        boolean z2 = mVar != null && mVar.a(oVar, z);
        if (z2) {
            try {
                this.f13374b.i();
            } catch (IOException e2) {
                a.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e2);
            }
        }
        return z2;
    }

    @Override // com.google.api.client.http.v
    public boolean b(o oVar, r rVar, boolean z) throws IOException {
        v vVar = this.f13376d;
        boolean z2 = vVar != null && vVar.b(oVar, rVar, z);
        if (z2 && z && rVar.h() / 100 == 5) {
            try {
                this.f13374b.i();
            } catch (IOException e2) {
                a.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e2);
            }
        }
        return z2;
    }
}