package com.google.firebase.crashlytics.c.g;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public abstract class a {
    private static final Pattern a = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: b  reason: collision with root package name */
    private final String f8663b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.k.c f8664c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.k.a f8665d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8666e;

    public a(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar, com.google.firebase.crashlytics.c.k.a aVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (cVar != null) {
            this.f8666e = str;
            this.f8663b = f(str2);
            this.f8664c = cVar;
            this.f8665d = aVar;
            return;
        }
        throw new IllegalArgumentException("requestFactory must not be null.");
    }

    private String f(String str) {
        return !h.D(this.f8666e) ? a.matcher(str).replaceFirst(this.f8666e) : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.google.firebase.crashlytics.c.k.b c() {
        return d(Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.google.firebase.crashlytics.c.k.b d(Map<String, String> map) {
        com.google.firebase.crashlytics.c.k.b a2 = this.f8664c.a(this.f8665d, e(), map);
        return a2.d("User-Agent", "Crashlytics Android SDK/" + k.i()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e() {
        return this.f8663b;
    }
}