package e.f.j.l;

import android.content.ContentResolver;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: QualifiedResourceFetchProducer.java */
/* loaded from: classes2.dex */
public class n0 extends z {

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f12691c;

    public n0(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.f12691c = contentResolver;
    }

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        return e(this.f12691c.openInputStream(bVar.q()), -1);
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "QualifiedResourceFetchProducer";
    }
}