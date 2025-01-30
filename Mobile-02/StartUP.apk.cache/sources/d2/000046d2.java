package e.f.j.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import java.io.OutputStream;

/* compiled from: SimpleImageTranscoder.java */
/* loaded from: classes2.dex */
public class g implements c {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12807b;

    public g(boolean z, int i2) {
        this.a = z;
        this.f12807b = i2;
    }

    private static Bitmap.CompressFormat e(e.f.i.c cVar) {
        if (cVar == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (cVar == e.f.i.b.a) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (cVar == e.f.i.b.f12388b) {
            return Bitmap.CompressFormat.PNG;
        }
        if (Build.VERSION.SDK_INT >= 14 && e.f.i.b.a(cVar)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    private int f(e.f.j.i.d dVar, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar) {
        if (this.a) {
            return a.b(fVar, eVar, dVar, this.f12807b);
        }
        return 1;
    }

    @Override // e.f.j.n.c
    public String a() {
        return "SimpleImageTranscoder";
    }

    @Override // e.f.j.n.c
    public boolean b(e.f.j.i.d dVar, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar) {
        if (fVar == null) {
            fVar = com.facebook.imagepipeline.common.f.a();
        }
        return this.a && a.b(fVar, eVar, dVar, this.f12807b) > 1;
    }

    @Override // e.f.j.n.c
    public b c(e.f.j.i.d dVar, OutputStream outputStream, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar, e.f.i.c cVar, Integer num) {
        g gVar;
        com.facebook.imagepipeline.common.f fVar2;
        Bitmap bitmap;
        Throwable th;
        OutOfMemoryError e2;
        Integer num2 = num == null ? 85 : num;
        if (fVar == null) {
            fVar2 = com.facebook.imagepipeline.common.f.a();
            gVar = this;
        } else {
            gVar = this;
            fVar2 = fVar;
        }
        int f2 = gVar.f(dVar, fVar2, eVar);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = f2;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(dVar.z(), null, options);
            if (decodeStream == null) {
                e.f.d.d.a.i("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new b(2);
            }
            Matrix g2 = e.g(dVar, fVar2);
            if (g2 != null) {
                try {
                    bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), g2, false);
                } catch (OutOfMemoryError e3) {
                    e2 = e3;
                    bitmap = decodeStream;
                    e.f.d.d.a.j("SimpleImageTranscoder", "Out-Of-Memory during transcode", e2);
                    b bVar = new b(2);
                    bitmap.recycle();
                    decodeStream.recycle();
                    return bVar;
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = decodeStream;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } else {
                bitmap = decodeStream;
            }
            try {
                try {
                    bitmap.compress(e(cVar), num2.intValue(), outputStream);
                    b bVar2 = new b(f2 > 1 ? 0 : 1);
                    bitmap.recycle();
                    decodeStream.recycle();
                    return bVar2;
                } catch (Throwable th3) {
                    th = th3;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } catch (OutOfMemoryError e4) {
                e2 = e4;
                e.f.d.d.a.j("SimpleImageTranscoder", "Out-Of-Memory during transcode", e2);
                b bVar3 = new b(2);
                bitmap.recycle();
                decodeStream.recycle();
                return bVar3;
            }
        } catch (OutOfMemoryError e5) {
            e.f.d.d.a.j("SimpleImageTranscoder", "Out-Of-Memory during transcode", e5);
            return new b(2);
        }
    }

    @Override // e.f.j.n.c
    public boolean d(e.f.i.c cVar) {
        return cVar == e.f.i.b.f12397k || cVar == e.f.i.b.a;
    }
}