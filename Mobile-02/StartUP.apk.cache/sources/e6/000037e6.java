package com.google.api.client.auth.oauth2;

import com.coinbase.ApiConstants;
import com.google.api.client.http.b0;
import com.google.api.client.http.g;
import com.google.api.client.http.k;
import com.google.api.client.http.o;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.u;
import e.g.b.a.c.c;
import e.g.b.a.c.e;
import e.g.b.a.d.n;
import java.io.IOException;

/* compiled from: TokenRequest.java */
/* loaded from: classes2.dex */
public class a extends n {
    q a;

    /* renamed from: b  reason: collision with root package name */
    k f8306b;

    /* renamed from: c  reason: collision with root package name */
    private final u f8307c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8308d;

    /* renamed from: e  reason: collision with root package name */
    private g f8309e;
    @e.g.b.a.d.q(ApiConstants.GRANT_TYPE)
    private String grantType;
    @e.g.b.a.d.q("scope")
    private String scopes;

    /* compiled from: TokenRequest.java */
    /* renamed from: com.google.api.client.auth.oauth2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0151a implements q {

        /* compiled from: TokenRequest.java */
        /* renamed from: com.google.api.client.auth.oauth2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0152a implements k {
            final /* synthetic */ k a;

            C0152a(k kVar) {
                this.a = kVar;
            }

            @Override // com.google.api.client.http.k
            public void a(o oVar) throws IOException {
                k kVar = this.a;
                if (kVar != null) {
                    kVar.a(oVar);
                }
                k kVar2 = a.this.f8306b;
                if (kVar2 != null) {
                    kVar2.a(oVar);
                }
            }
        }

        C0151a() {
        }

        @Override // com.google.api.client.http.q
        public void b(o oVar) throws IOException {
            q qVar = a.this.a;
            if (qVar != null) {
                qVar.b(oVar);
            }
            oVar.u(new C0152a(oVar.g()));
        }
    }

    @Override // e.g.b.a.d.n
    /* renamed from: b */
    public a set(String str, Object obj) {
        return (a) super.set(str, obj);
    }

    public final r executeUnparsed() throws IOException {
        o b2 = this.f8307c.d(new C0151a()).b(this.f8309e, new b0(this));
        b2.v(new e(this.f8308d));
        b2.y(false);
        r a = b2.a();
        if (a.l()) {
            return a;
        }
        throw TokenResponseException.b(this.f8308d, a);
    }
}