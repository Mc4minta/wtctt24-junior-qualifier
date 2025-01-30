package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class x {
    private final Resources a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6279b;

    public x(Context context) {
        t.k(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.f6279b = resources.getResourcePackageName(com.google.android.gms.common.j.a);
    }

    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.f6279b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}