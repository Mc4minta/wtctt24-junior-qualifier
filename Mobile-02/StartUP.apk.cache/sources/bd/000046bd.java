package e.f.j.l;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: LocalExifThumbnailProducer.java */
/* loaded from: classes2.dex */
public class y implements w0<e.f.j.i.d> {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.memory.g f12785b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f12786c;

    /* compiled from: LocalExifThumbnailProducer.java */
    /* loaded from: classes2.dex */
    class a extends q0<e.f.j.i.d> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.facebook.imagepipeline.request.b f12787f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, m0 m0Var, String str, String str2, com.facebook.imagepipeline.request.b bVar) {
            super(kVar, m0Var, str, str2);
            this.f12787f = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.d.b.d
        /* renamed from: j */
        public void b(e.f.j.i.d dVar) {
            e.f.j.i.d.c(dVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.q0
        /* renamed from: k */
        public Map<String, String> i(e.f.j.i.d dVar) {
            return e.f.d.c.f.of("createdThumbnail", Boolean.toString(dVar != null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.d.b.d
        /* renamed from: l */
        public e.f.j.i.d c() throws Exception {
            ExifInterface g2 = y.this.g(this.f12787f.q());
            if (g2 == null || !g2.hasThumbnail()) {
                return null;
            }
            return y.this.e(y.this.f12785b.b(g2.getThumbnail()), g2);
        }
    }

    /* compiled from: LocalExifThumbnailProducer.java */
    /* loaded from: classes2.dex */
    class b extends e {
        final /* synthetic */ q0 a;

        b(q0 q0Var) {
            this.a = q0Var;
        }

        @Override // e.f.j.l.l0
        public void a() {
            this.a.a();
        }
    }

    public y(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.a = executor;
        this.f12785b = gVar;
        this.f12786c = contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.f.j.i.d e(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> a2 = com.facebook.imageutils.a.a(new com.facebook.common.memory.h(pooledByteBuffer));
        int h2 = h(exifInterface);
        int intValue = a2 != null ? ((Integer) a2.first).intValue() : -1;
        int intValue2 = a2 != null ? ((Integer) a2.second).intValue() : -1;
        com.facebook.common.references.a K = com.facebook.common.references.a.K(pooledByteBuffer);
        try {
            e.f.j.i.d dVar = new e.f.j.i.d(K);
            com.facebook.common.references.a.f(K);
            dVar.w0(e.f.i.b.a);
            dVar.x0(h2);
            dVar.z0(intValue);
            dVar.s0(intValue2);
            return dVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.f(K);
            throw th;
        }
    }

    private int h(ExifInterface exifInterface) {
        return com.facebook.imageutils.c.a(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    @Override // e.f.j.l.w0
    public boolean a(com.facebook.imagepipeline.common.e eVar) {
        return x0.b(512, 512, eVar);
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        a aVar = new a(kVar, k0Var.f(), "LocalExifThumbnailProducer", k0Var.getId(), k0Var.c());
        k0Var.d(new b(aVar));
        this.a.execute(aVar);
    }

    boolean f(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }

    ExifInterface g(Uri uri) {
        String a2 = com.facebook.common.util.e.a(this.f12786c, uri);
        try {
            if (f(a2)) {
                return new ExifInterface(a2);
            }
            return null;
        } catch (IOException unused) {
            return null;
        } catch (StackOverflowError unused2) {
            e.f.d.d.a.e(y.class, "StackOverflowError in ExifInterface constructor");
            return null;
        }
    }
}