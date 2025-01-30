package com.google.firebase.crashlytics.c.r;

import android.content.Context;
import com.google.firebase.crashlytics.c.g.h;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class a implements b {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9077b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f9078c;

    public a(Context context) {
        this.a = context;
    }

    @Override // com.google.firebase.crashlytics.c.r.b
    public String a() {
        if (!this.f9077b) {
            this.f9078c = h.G(this.a);
            this.f9077b = true;
        }
        String str = this.f9078c;
        if (str != null) {
            return str;
        }
        return null;
    }
}