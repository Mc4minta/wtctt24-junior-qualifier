package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class d {
    private final Account a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f6208b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f6209c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b> f6210d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6211e;

    /* renamed from: f  reason: collision with root package name */
    private final View f6212f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6213g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6214h;

    /* renamed from: i  reason: collision with root package name */
    private final e.g.a.e.h.a f6215i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f6216j;

    /* renamed from: k  reason: collision with root package name */
    private Integer f6217k;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static final class a {
        private Account a;

        /* renamed from: b  reason: collision with root package name */
        private c.e.b<Scope> f6218b;

        /* renamed from: c  reason: collision with root package name */
        private Map<com.google.android.gms.common.api.a<?>, b> f6219c;

        /* renamed from: e  reason: collision with root package name */
        private View f6221e;

        /* renamed from: f  reason: collision with root package name */
        private String f6222f;

        /* renamed from: g  reason: collision with root package name */
        private String f6223g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f6225i;

        /* renamed from: d  reason: collision with root package name */
        private int f6220d = 0;

        /* renamed from: h  reason: collision with root package name */
        private e.g.a.e.h.a f6224h = e.g.a.e.h.a.a;

        public final a a(Collection<Scope> collection) {
            if (this.f6218b == null) {
                this.f6218b = new c.e.b<>();
            }
            this.f6218b.addAll(collection);
            return this;
        }

        public final d b() {
            return new d(this.a, this.f6218b, this.f6219c, this.f6220d, this.f6221e, this.f6222f, this.f6223g, this.f6224h, this.f6225i);
        }

        public final a c(Account account) {
            this.a = account;
            return this;
        }

        public final a d(String str) {
            this.f6223g = str;
            return this;
        }

        public final a e(String str) {
            this.f6222f = str;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static final class b {
        public final Set<Scope> a;
    }

    public d(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i2, View view, String str, String str2, e.g.a.e.h.a aVar, boolean z) {
        this.a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f6208b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f6210d = map;
        this.f6212f = view;
        this.f6211e = i2;
        this.f6213g = str;
        this.f6214h = str2;
        this.f6215i = aVar;
        this.f6216j = z;
        HashSet hashSet = new HashSet(emptySet);
        for (b bVar : map.values()) {
            hashSet.addAll(bVar.a);
        }
        this.f6209c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.a;
    }

    @Deprecated
    public final String b() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public final Account c() {
        Account account = this.a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> d() {
        return this.f6209c;
    }

    public final Set<Scope> e(com.google.android.gms.common.api.a<?> aVar) {
        b bVar = this.f6210d.get(aVar);
        if (bVar != null && !bVar.a.isEmpty()) {
            HashSet hashSet = new HashSet(this.f6208b);
            hashSet.addAll(bVar.a);
            return hashSet;
        }
        return this.f6208b;
    }

    public final Integer f() {
        return this.f6217k;
    }

    public final String g() {
        return this.f6214h;
    }

    public final String h() {
        return this.f6213g;
    }

    public final Set<Scope> i() {
        return this.f6208b;
    }

    public final e.g.a.e.h.a j() {
        return this.f6215i;
    }

    public final void k(Integer num) {
        this.f6217k = num;
    }
}