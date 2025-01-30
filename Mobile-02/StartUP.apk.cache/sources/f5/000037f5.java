package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import com.coinbase.wallet.consumer.views.ConsumerAuthenticateWebViewClient;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.http.k;
import com.google.api.client.http.l;
import com.google.api.client.http.o;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.v;
import e.g.b.a.d.a0;
import e.g.b.a.d.c;
import e.g.b.a.d.d;
import e.g.b.a.d.p;
import e.g.b.a.d.y;
import java.io.IOException;
import java.util.Collection;
import org.apache.http.message.TokenParser;

/* compiled from: GoogleAccountCredential.java */
/* loaded from: classes2.dex */
public class a implements q {
    final Context a;

    /* renamed from: b  reason: collision with root package name */
    final String f8311b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.b.a.b.d.a.a.a f8312c;

    /* renamed from: d  reason: collision with root package name */
    private String f8313d;

    /* renamed from: e  reason: collision with root package name */
    private Account f8314e;

    /* renamed from: f  reason: collision with root package name */
    private a0 f8315f = a0.a;

    /* renamed from: g  reason: collision with root package name */
    private c f8316g;

    /* compiled from: GoogleAccountCredential.java */
    /* renamed from: com.google.api.client.googleapis.extensions.android.gms.auth.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0153a implements k, v {
        boolean a;

        /* renamed from: b  reason: collision with root package name */
        String f8317b;

        C0153a() {
        }

        @Override // com.google.api.client.http.k
        public void a(o oVar) throws IOException {
            try {
                this.f8317b = a.this.a();
                l e2 = oVar.e();
                e2.w(ConsumerAuthenticateWebViewClient.BEARER + this.f8317b);
            } catch (GooglePlayServicesAvailabilityException e3) {
                throw new GooglePlayServicesAvailabilityIOException(e3);
            } catch (UserRecoverableAuthException e4) {
                throw new UserRecoverableAuthIOException(e4);
            } catch (GoogleAuthException e5) {
                throw new GoogleAuthIOException(e5);
            }
        }

        @Override // com.google.api.client.http.v
        public boolean b(o oVar, r rVar, boolean z) {
            if (rVar.h() != 401 || this.a) {
                return false;
            }
            this.a = true;
            com.google.android.gms.auth.a.e(a.this.a, this.f8317b);
            return true;
        }
    }

    public a(Context context, String str) {
        this.f8312c = new e.g.b.a.b.d.a.a.a(context);
        this.a = context;
        this.f8311b = str;
    }

    public static a d(Context context, Collection<String> collection) {
        y.a(collection != null && collection.iterator().hasNext());
        return new a(context, "oauth2: " + p.b(TokenParser.SP).a(collection));
    }

    public String a() throws IOException, GoogleAuthException {
        c cVar;
        c cVar2 = this.f8316g;
        if (cVar2 != null) {
            cVar2.reset();
        }
        while (true) {
            try {
                return com.google.android.gms.auth.a.d(this.a, this.f8313d, this.f8311b);
            } catch (IOException e2) {
                try {
                    cVar = this.f8316g;
                } catch (InterruptedException unused) {
                }
                if (cVar == null || !d.a(this.f8315f, cVar)) {
                    throw e2;
                    break;
                }
            }
        }
    }

    @Override // com.google.api.client.http.q
    public void b(o oVar) {
        C0153a c0153a = new C0153a();
        oVar.u(c0153a);
        oVar.z(c0153a);
    }

    public final a c(Account account) {
        this.f8314e = account;
        this.f8313d = account == null ? null : account.name;
        return this;
    }
}