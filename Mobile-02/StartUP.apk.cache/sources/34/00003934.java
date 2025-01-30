package com.google.firebase.abt.component;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
/* loaded from: classes2.dex */
public class a {
    private final Map<String, com.google.firebase.abt.b> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f8564b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.analytics.a.a f8565c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, com.google.firebase.analytics.a.a aVar) {
        this.f8564b = context;
        this.f8565c = aVar;
    }

    protected com.google.firebase.abt.b a(String str) {
        return new com.google.firebase.abt.b(this.f8564b, this.f8565c, str);
    }

    public synchronized com.google.firebase.abt.b b(String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, a(str));
        }
        return this.a.get(str);
    }
}