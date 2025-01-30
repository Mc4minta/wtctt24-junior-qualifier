package e.f.j.l;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: LocalAssetFetchProducer.java */
/* loaded from: classes2.dex */
public class v extends z {

    /* renamed from: c  reason: collision with root package name */
    private final AssetManager f12772c;

    public v(Executor executor, com.facebook.common.memory.g gVar, AssetManager assetManager) {
        super(executor, gVar);
        this.f12772c = assetManager;
    }

    private static String g(com.facebook.imagepipeline.request.b bVar) {
        return bVar.q().getPath().substring(1);
    }

    private int h(com.facebook.imagepipeline.request.b bVar) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = this.f12772c.openFd(g(bVar));
            int length = (int) assetFileDescriptor.getLength();
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
            return length;
        } catch (IOException unused2) {
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

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        return e(this.f12772c.open(g(bVar), 2), h(bVar));
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "LocalAssetFetchProducer";
    }
}