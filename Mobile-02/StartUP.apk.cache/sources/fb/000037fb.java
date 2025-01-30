package com.google.api.client.http;

import java.io.IOException;
import org.apache.http.message.TokenParser;

/* loaded from: classes2.dex */
public class HttpResponseException extends IOException {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8320b;

    /* renamed from: c  reason: collision with root package name */
    private final transient l f8321c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8322d;

    public HttpResponseException(r rVar) {
        this(new a(rVar));
    }

    public static StringBuilder a(r rVar) {
        StringBuilder sb = new StringBuilder();
        int h2 = rVar.h();
        if (h2 != 0) {
            sb.append(h2);
        }
        String i2 = rVar.i();
        if (i2 != null) {
            if (h2 != 0) {
                sb.append(TokenParser.SP);
            }
            sb.append(i2);
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponseException(a aVar) {
        super(aVar.f8326e);
        this.a = aVar.a;
        this.f8320b = aVar.f8323b;
        this.f8321c = aVar.f8324c;
        this.f8322d = aVar.f8325d;
    }

    /* loaded from: classes2.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        String f8323b;

        /* renamed from: c  reason: collision with root package name */
        l f8324c;

        /* renamed from: d  reason: collision with root package name */
        String f8325d;

        /* renamed from: e  reason: collision with root package name */
        String f8326e;

        public a(int i2, String str, l lVar) {
            d(i2);
            e(str);
            b(lVar);
        }

        public a a(String str) {
            this.f8325d = str;
            return this;
        }

        public a b(l lVar) {
            this.f8324c = (l) e.g.b.a.d.y.d(lVar);
            return this;
        }

        public a c(String str) {
            this.f8326e = str;
            return this;
        }

        public a d(int i2) {
            e.g.b.a.d.y.a(i2 >= 0);
            this.a = i2;
            return this;
        }

        public a e(String str) {
            this.f8323b = str;
            return this;
        }

        public a(r rVar) {
            this(rVar.h(), rVar.i(), rVar.f());
            try {
                String n = rVar.n();
                this.f8325d = n;
                if (n.length() == 0) {
                    this.f8325d = null;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            StringBuilder a = HttpResponseException.a(rVar);
            if (this.f8325d != null) {
                a.append(e.g.b.a.d.c0.a);
                a.append(this.f8325d);
            }
            this.f8326e = a.toString();
        }
    }
}