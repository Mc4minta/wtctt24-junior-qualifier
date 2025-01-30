package e.g.b.a.b.e;

import com.caverock.androidsvg.SVGParser;
import com.google.api.client.http.g;
import com.google.api.client.http.l;
import com.google.api.client.http.o;
import com.google.api.client.http.p;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.u;
import e.g.b.a.d.y;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: MediaHttpDownloader.java */
/* loaded from: classes2.dex */
public final class a {
    private final p a;

    /* renamed from: b  reason: collision with root package name */
    private final u f13347b;

    /* renamed from: d  reason: collision with root package name */
    private b f13349d;

    /* renamed from: f  reason: collision with root package name */
    private long f13351f;

    /* renamed from: h  reason: collision with root package name */
    private long f13353h;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13348c = false;

    /* renamed from: e  reason: collision with root package name */
    private int f13350e = 33554432;

    /* renamed from: g  reason: collision with root package name */
    private EnumC0307a f13352g = EnumC0307a.NOT_STARTED;

    /* renamed from: i  reason: collision with root package name */
    private long f13354i = -1;

    /* compiled from: MediaHttpDownloader.java */
    /* renamed from: e.g.b.a.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0307a {
        NOT_STARTED,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public a(u uVar, q qVar) {
        this.f13347b = (u) y.d(uVar);
        this.a = qVar == null ? uVar.c() : uVar.d(qVar);
    }

    private r b(long j2, g gVar, l lVar, OutputStream outputStream) throws IOException {
        o a = this.a.a(gVar);
        if (lVar != null) {
            a.e().putAll(lVar);
        }
        if (this.f13353h != 0 || j2 != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(this.f13353h);
            sb.append("-");
            if (j2 != -1) {
                sb.append(j2);
            }
            a.e().I(sb.toString());
        }
        r a2 = a.a();
        try {
            e.g.b.a.d.o.b(a2.c(), outputStream);
            return a2;
        } finally {
            a2.a();
        }
    }

    private long c(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1, str.indexOf(47))) + 1;
    }

    private void d(String str) {
        if (str != null && this.f13351f == 0) {
            this.f13351f = Long.parseLong(str.substring(str.indexOf(47) + 1));
        }
    }

    private void e(EnumC0307a enumC0307a) throws IOException {
        this.f13352g = enumC0307a;
        b bVar = this.f13349d;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void a(g gVar, l lVar, OutputStream outputStream) throws IOException {
        y.a(this.f13352g == EnumC0307a.NOT_STARTED);
        gVar.put("alt", SVGParser.XML_STYLESHEET_ATTR_MEDIA);
        if (this.f13348c) {
            e(EnumC0307a.MEDIA_IN_PROGRESS);
            long longValue = b(this.f13354i, gVar, lVar, outputStream).f().i().longValue();
            this.f13351f = longValue;
            this.f13353h = longValue;
            e(EnumC0307a.MEDIA_COMPLETE);
            return;
        }
        while (true) {
            long j2 = (this.f13353h + this.f13350e) - 1;
            long j3 = this.f13354i;
            if (j3 != -1) {
                j2 = Math.min(j3, j2);
            }
            String k2 = b(j2, gVar, lVar, outputStream).f().k();
            long c2 = c(k2);
            d(k2);
            long j4 = this.f13351f;
            if (j4 <= c2) {
                this.f13353h = j4;
                e(EnumC0307a.MEDIA_COMPLETE);
                return;
            }
            this.f13353h = c2;
            e(EnumC0307a.MEDIA_IN_PROGRESS);
        }
    }
}