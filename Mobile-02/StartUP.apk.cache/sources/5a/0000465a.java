package e.f.j.l;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalFileFetchProducer.java */
/* loaded from: classes2.dex */
public class a0 extends z {
    public a0(Executor executor, com.facebook.common.memory.g gVar) {
        super(executor, gVar);
    }

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        return e(new FileInputStream(bVar.p().toString()), (int) bVar.p().length());
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "LocalFileFetchProducer";
    }
}