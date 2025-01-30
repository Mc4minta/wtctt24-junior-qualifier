package e.f.i;

import e.f.d.c.i;
import e.f.d.c.n;
import e.f.i.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ImageFormatChecker.java */
/* loaded from: classes2.dex */
public class d {
    private static d a;

    /* renamed from: b  reason: collision with root package name */
    private int f12400b;

    /* renamed from: c  reason: collision with root package name */
    private List<c.a> f12401c;

    /* renamed from: d  reason: collision with root package name */
    private final c.a f12402d = new a();

    private d() {
        f();
    }

    public static c b(InputStream inputStream) throws IOException {
        return d().a(inputStream);
    }

    public static c c(InputStream inputStream) {
        try {
            return b(inputStream);
        } catch (IOException e2) {
            throw n.a(e2);
        }
    }

    public static synchronized d d() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    private static int e(int i2, InputStream inputStream, byte[] bArr) throws IOException {
        i.g(inputStream);
        i.g(bArr);
        i.b(bArr.length >= i2);
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i2);
                return e.f.d.c.a.b(inputStream, bArr, 0, i2);
            } finally {
                inputStream.reset();
            }
        }
        return e.f.d.c.a.b(inputStream, bArr, 0, i2);
    }

    private void f() {
        this.f12400b = this.f12402d.a();
        List<c.a> list = this.f12401c;
        if (list != null) {
            for (c.a aVar : list) {
                this.f12400b = Math.max(this.f12400b, aVar.a());
            }
        }
    }

    public c a(InputStream inputStream) throws IOException {
        i.g(inputStream);
        int i2 = this.f12400b;
        byte[] bArr = new byte[i2];
        int e2 = e(i2, inputStream, bArr);
        c b2 = this.f12402d.b(bArr, e2);
        if (b2 == null || b2 == c.a) {
            List<c.a> list = this.f12401c;
            if (list != null) {
                for (c.a aVar : list) {
                    c b3 = aVar.b(bArr, e2);
                    if (b3 != null && b3 != c.a) {
                        return b3;
                    }
                }
            }
            return c.a;
        }
        return b2;
    }
}