package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.t;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class a<O extends d> {
    private final AbstractC0138a<?, O> a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f6043b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6044c;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0138a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, d.a aVar, d.b bVar) {
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface b {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static class c<C extends b> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface d {

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0139a extends d {
            Account m();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        /* loaded from: classes2.dex */
        public interface b extends d {
            GoogleSignInAccount k0();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static abstract class e<T extends b, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface f extends b {
        Set<Scope> a();

        void b(com.google.android.gms.common.internal.l lVar, Set<Scope> set);

        boolean d();

        void disconnect();

        String e();

        void f(c.InterfaceC0141c interfaceC0141c);

        void i(c.e eVar);

        boolean j();

        boolean m();

        int n();

        com.google.android.gms.common.d[] o();

        boolean p();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface h<T extends IInterface> extends b {
        void h(int i2, T t);

        String k();

        T l(IBinder iBinder);

        String q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0138a<C, O> abstractC0138a, g<C> gVar) {
        t.l(abstractC0138a, "Cannot construct an Api with a null ClientBuilder");
        t.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f6044c = str;
        this.a = abstractC0138a;
        this.f6043b = gVar;
    }

    public final c<?> a() {
        g<?> gVar = this.f6043b;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String b() {
        return this.f6044c;
    }

    public final AbstractC0138a<?, O> c() {
        t.o(this.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }
}