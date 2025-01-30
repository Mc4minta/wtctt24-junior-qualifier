package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.h;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import e.f.d.c.i;
import e.f.d.c.n;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

/* compiled from: GingerbreadPurgeableDecoder.java */
/* loaded from: classes2.dex */
public class c extends DalvikPurgeableDecoder {

    /* renamed from: c  reason: collision with root package name */
    private static Method f4633c;

    /* renamed from: d  reason: collision with root package name */
    private final e.f.d.h.b f4634d = e.f.d.h.c.i();

    private static MemoryFile i(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, byte[] bArr) throws IOException {
        OutputStream outputStream;
        e.f.d.g.a aVar2;
        h hVar = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i2);
        memoryFile.allowPurging(false);
        try {
            h hVar2 = new h(aVar.n());
            try {
                aVar2 = new e.f.d.g.a(hVar2, i2);
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                aVar2 = null;
            }
            try {
                outputStream2 = memoryFile.getOutputStream();
                e.f.d.c.a.a(aVar2, outputStream2);
                if (bArr != null) {
                    memoryFile.writeBytes(bArr, 0, i2, bArr.length);
                }
                com.facebook.common.references.a.f(aVar);
                e.f.d.c.b.b(hVar2);
                e.f.d.c.b.b(aVar2);
                e.f.d.c.b.a(outputStream2, true);
                return memoryFile;
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                hVar = hVar2;
                com.facebook.common.references.a.f(aVar);
                e.f.d.c.b.b(hVar);
                e.f.d.c.b.b(aVar2);
                e.f.d.c.b.a(outputStream, true);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            aVar2 = null;
        }
    }

    private Bitmap j(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            try {
                MemoryFile i3 = i(aVar, i2, bArr);
                try {
                    FileDescriptor l2 = l(i3);
                    e.f.d.h.b bVar = this.f4634d;
                    if (bVar != null) {
                        Bitmap bitmap = (Bitmap) i.h(bVar.c(l2, null, options), "BitmapFactory returned null");
                        if (i3 != null) {
                            i3.close();
                        }
                        return bitmap;
                    }
                    throw new IllegalStateException("WebpBitmapFactory is null");
                } catch (IOException e2) {
                    e = e2;
                    memoryFile = i3;
                    throw n.a(e);
                } catch (Throwable th) {
                    th = th;
                    memoryFile = i3;
                    if (memoryFile != null) {
                        memoryFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    private synchronized Method k() {
        if (f4633c == null) {
            try {
                f4633c = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e2) {
                throw n.a(e2);
            }
        }
        return f4633c;
    }

    private FileDescriptor l(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) k().invoke(memoryFile, new Object[0]);
        } catch (Exception e2) {
            throw n.a(e2);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap d(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        return j(aVar, aVar.n().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap e(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, BitmapFactory.Options options) {
        return j(aVar, i2, DalvikPurgeableDecoder.f(aVar, i2) ? null : DalvikPurgeableDecoder.a, options);
    }
}