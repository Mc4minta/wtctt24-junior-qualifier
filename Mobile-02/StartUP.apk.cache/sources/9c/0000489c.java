package e.g.b.a.b.e;

import com.caverock.androidsvg.SVGParser;
import com.google.api.client.http.f;
import com.google.api.client.http.g;
import com.google.api.client.http.h;
import com.google.api.client.http.l;
import com.google.api.client.http.o;
import com.google.api.client.http.p;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.u;
import com.google.api.client.http.w;
import com.google.api.client.http.z;
import e.g.b.a.d.a0;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* compiled from: MediaHttpUploader.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private final com.google.api.client.http.b f13358b;

    /* renamed from: c  reason: collision with root package name */
    private final p f13359c;

    /* renamed from: d  reason: collision with root package name */
    private final u f13360d;

    /* renamed from: e  reason: collision with root package name */
    private h f13361e;

    /* renamed from: f  reason: collision with root package name */
    private long f13362f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13363g;

    /* renamed from: j  reason: collision with root package name */
    private o f13366j;

    /* renamed from: k  reason: collision with root package name */
    private InputStream f13367k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13368l;
    private d m;
    private long o;
    private Byte q;
    private long r;
    private int s;
    private byte[] t;
    private boolean u;
    private a a = a.NOT_STARTED;

    /* renamed from: h  reason: collision with root package name */
    private String f13364h = HttpPost.METHOD_NAME;

    /* renamed from: i  reason: collision with root package name */
    private l f13365i = new l();
    String n = "*";
    private int p = 10485760;
    a0 v = a0.a;

    /* compiled from: MediaHttpUploader.java */
    /* loaded from: classes2.dex */
    public enum a {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public c(com.google.api.client.http.b bVar, u uVar, q qVar) {
        this.f13358b = (com.google.api.client.http.b) y.d(bVar);
        this.f13360d = (u) y.d(uVar);
        this.f13359c = qVar == null ? uVar.c() : uVar.d(qVar);
    }

    private r a(g gVar) throws IOException {
        o(a.MEDIA_IN_PROGRESS);
        h hVar = this.f13358b;
        if (this.f13361e != null) {
            hVar = new z().h(Arrays.asList(this.f13361e, this.f13358b));
            gVar.put("uploadType", "multipart");
        } else {
            gVar.put("uploadType", SVGParser.XML_STYLESHEET_ATTR_MEDIA);
        }
        o d2 = this.f13359c.d(this.f13364h, gVar, hVar);
        d2.e().putAll(this.f13365i);
        r b2 = b(d2);
        try {
            if (g()) {
                this.o = e();
            }
            o(a.MEDIA_COMPLETE);
            return b2;
        } catch (Throwable th) {
            b2.a();
            throw th;
        }
    }

    private r b(o oVar) throws IOException {
        if (!this.u && !(oVar.b() instanceof com.google.api.client.http.e)) {
            oVar.s(new f());
        }
        return c(oVar);
    }

    private r c(o oVar) throws IOException {
        new e.g.b.a.b.b().a(oVar);
        oVar.y(false);
        return oVar.a();
    }

    private r d(g gVar) throws IOException {
        o(a.INITIATION_STARTED);
        gVar.put("uploadType", "resumable");
        h hVar = this.f13361e;
        if (hVar == null) {
            hVar = new com.google.api.client.http.e();
        }
        o d2 = this.f13359c.d(this.f13364h, gVar, hVar);
        this.f13365i.set("X-Upload-Content-Type", this.f13358b.getType());
        if (g()) {
            this.f13365i.set("X-Upload-Content-Length", Long.valueOf(e()));
        }
        d2.e().putAll(this.f13365i);
        r b2 = b(d2);
        try {
            o(a.INITIATION_COMPLETE);
            return b2;
        } catch (Throwable th) {
            b2.a();
            throw th;
        }
    }

    private long e() throws IOException {
        if (!this.f13363g) {
            this.f13362f = this.f13358b.getLength();
            this.f13363g = true;
        }
        return this.f13362f;
    }

    private long f(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1)) + 1;
    }

    private boolean g() throws IOException {
        return e() >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
        r13.o = e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (r13.f13358b.b() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
        r13.f13367k.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
        o(e.g.b.a.b.e.c.a.f13372e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        return r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.api.client.http.r h(com.google.api.client.http.g r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.a.b.e.c.h(com.google.api.client.http.g):com.google.api.client.http.r");
    }

    private void j() throws IOException {
        int i2;
        int i3;
        int i4;
        h dVar;
        if (g()) {
            i2 = (int) Math.min(this.p, e() - this.o);
        } else {
            i2 = this.p;
        }
        if (g()) {
            this.f13367k.mark(i2);
            long j2 = i2;
            dVar = new w(this.f13358b.getType(), e.g.b.a.d.g.b(this.f13367k, j2)).h(true).g(j2).f(false);
            this.n = String.valueOf(e());
        } else {
            byte[] bArr = this.t;
            if (bArr == null) {
                Byte b2 = this.q;
                i3 = b2 == null ? i2 + 1 : i2;
                byte[] bArr2 = new byte[i2 + 1];
                this.t = bArr2;
                if (b2 != null) {
                    bArr2[0] = b2.byteValue();
                }
                i4 = 0;
            } else {
                int i5 = (int) (this.r - this.o);
                System.arraycopy(bArr, this.s - i5, bArr, 0, i5);
                Byte b3 = this.q;
                if (b3 != null) {
                    this.t[i5] = b3.byteValue();
                }
                i3 = i2 - i5;
                i4 = i5;
            }
            int c2 = e.g.b.a.d.g.c(this.f13367k, this.t, (i2 + 1) - i3, i3);
            if (c2 < i3) {
                int max = i4 + Math.max(0, c2);
                if (this.q != null) {
                    max++;
                    this.q = null;
                }
                if (this.n.equals("*")) {
                    this.n = String.valueOf(this.o + max);
                }
                i2 = max;
            } else {
                this.q = Byte.valueOf(this.t[i2]);
            }
            dVar = new com.google.api.client.http.d(this.f13358b.getType(), this.t, 0, i2);
            this.r = this.o + i2;
        }
        this.s = i2;
        this.f13366j.r(dVar);
        if (i2 == 0) {
            this.f13366j.e().B("bytes */" + this.n);
            return;
        }
        this.f13366j.e().B("bytes " + this.o + "-" + ((this.o + i2) - 1) + "/" + this.n);
    }

    private void o(a aVar) throws IOException {
        this.a = aVar;
        d dVar = this.m;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() throws IOException {
        y.e(this.f13366j, "The current request should not be null");
        this.f13366j.r(new com.google.api.client.http.e());
        l e2 = this.f13366j.e();
        e2.B("bytes */" + this.n);
    }

    public c k(boolean z) {
        this.u = z;
        return this;
    }

    public c l(l lVar) {
        this.f13365i = lVar;
        return this;
    }

    public c m(String str) {
        y.a(str.equals(HttpPost.METHOD_NAME) || str.equals(HttpPut.METHOD_NAME) || str.equals(HttpPatch.METHOD_NAME));
        this.f13364h = str;
        return this;
    }

    public c n(h hVar) {
        this.f13361e = hVar;
        return this;
    }

    public r p(g gVar) throws IOException {
        y.a(this.a == a.NOT_STARTED);
        if (this.f13368l) {
            return a(gVar);
        }
        return h(gVar);
    }
}