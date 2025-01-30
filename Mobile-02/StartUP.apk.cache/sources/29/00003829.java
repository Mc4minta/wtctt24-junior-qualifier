package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultipartContent.java */
/* loaded from: classes2.dex */
public class z extends com.google.api.client.http.a {

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f8410c;

    /* compiled from: MultipartContent.java */
    /* loaded from: classes2.dex */
    public static final class a {
        h a;

        /* renamed from: b  reason: collision with root package name */
        l f8411b;

        /* renamed from: c  reason: collision with root package name */
        i f8412c;

        public a() {
            this(null);
        }

        public a a(h hVar) {
            this.a = hVar;
            return this;
        }

        public a b(l lVar) {
            this.f8411b = lVar;
            return this;
        }

        public a(h hVar) {
            this(null, hVar);
        }

        public a(l lVar, h hVar) {
            b(lVar);
            a(hVar);
        }
    }

    public z() {
        super(new n("multipart/related").m("boundary", "__END_OF_PART__"));
        this.f8410c = new ArrayList<>();
    }

    @Override // com.google.api.client.http.a, com.google.api.client.http.h
    public boolean a() {
        Iterator<a> it = this.f8410c.iterator();
        while (it.hasNext()) {
            if (!it.next().a.a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z f(a aVar) {
        this.f8410c.add(e.g.b.a.d.y.d(aVar));
        return this;
    }

    public final String g() {
        return e().f("boundary");
    }

    public z h(Collection<? extends h> collection) {
        this.f8410c = new ArrayList<>(collection.size());
        for (h hVar : collection) {
            f(new a(hVar));
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.api.client.http.j] */
    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        long j2;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, d());
        String g2 = g();
        Iterator<a> it = this.f8410c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            l v = new l().v(null);
            l lVar = next.f8411b;
            if (lVar != null) {
                v.d(lVar);
            }
            v.y(null).J(null).C(null).A(null).set("Content-Transfer-Encoding", null);
            h hVar = next.a;
            if (hVar != null) {
                v.set("Content-Transfer-Encoding", Arrays.asList("binary"));
                v.C(hVar.getType());
                i iVar = next.f8412c;
                if (iVar == null) {
                    j2 = hVar.getLength();
                } else {
                    v.y(iVar.getName());
                    ?? jVar = new j(hVar, iVar);
                    long c2 = com.google.api.client.http.a.c(hVar);
                    hVar = jVar;
                    j2 = c2;
                }
                if (j2 != -1) {
                    v.A(Long.valueOf(j2));
                }
            } else {
                hVar = null;
            }
            outputStreamWriter.write("--");
            outputStreamWriter.write(g2);
            outputStreamWriter.write("\r\n");
            l.t(v, null, null, outputStreamWriter);
            if (hVar != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                hVar.writeTo(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write("--");
        outputStreamWriter.write(g2);
        outputStreamWriter.write("--");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }
}