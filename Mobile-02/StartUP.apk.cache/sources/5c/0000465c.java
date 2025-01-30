package e.f.j.l;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalResourceFetchProducer.java */
/* loaded from: classes2.dex */
public class b0 extends z {

    /* renamed from: c  reason: collision with root package name */
    private final Resources f12584c;

    public b0(Executor executor, com.facebook.common.memory.g gVar, Resources resources) {
        super(executor, gVar);
        this.f12584c = resources;
    }

    private int g(com.facebook.imagepipeline.request.b bVar) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = this.f12584c.openRawResourceFd(h(bVar));
            int length = (int) assetFileDescriptor.getLength();
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
            return length;
        } catch (Resources.NotFoundException unused2) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    private static int h(com.facebook.imagepipeline.request.b bVar) {
        return Integer.parseInt(bVar.q().getPath().substring(1));
    }

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        return e(this.f12584c.openRawResource(h(bVar)), g(bVar));
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "LocalResourceFetchProducer";
    }
}