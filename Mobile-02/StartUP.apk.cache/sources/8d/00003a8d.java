package com.google.firebase.crashlytics.c.n.c;

import com.google.firebase.crashlytics.c.n.c.c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class d implements c {
    private final File a;

    /* renamed from: b  reason: collision with root package name */
    private final File[] f9017b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f9018c;

    public d(File file) {
        this(file, Collections.emptyMap());
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public String a() {
        String e2 = e();
        return e2.substring(0, e2.lastIndexOf(46));
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public Map<String, String> b() {
        return Collections.unmodifiableMap(this.f9018c);
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public File c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public File[] d() {
        return this.f9017b;
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public String e() {
        return c().getName();
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public c.a getType() {
        return c.a.JAVA;
    }

    @Override // com.google.firebase.crashlytics.c.n.c.c
    public void remove() {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Removing report at " + this.a.getPath());
        this.a.delete();
    }

    public d(File file, Map<String, String> map) {
        this.a = file;
        this.f9017b = new File[]{file};
        this.f9018c = new HashMap(map);
    }
}