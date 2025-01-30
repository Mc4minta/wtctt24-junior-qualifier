package e.f.j.n;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ImageTranscoder.java */
/* loaded from: classes2.dex */
public interface c {
    String a();

    boolean b(e.f.j.i.d dVar, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar);

    b c(e.f.j.i.d dVar, OutputStream outputStream, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar, e.f.i.c cVar, Integer num) throws IOException;

    boolean d(e.f.i.c cVar);
}