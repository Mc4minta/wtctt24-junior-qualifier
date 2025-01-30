package com.google.firebase.f;

import android.content.Context;
import com.google.firebase.components.e;
import com.google.firebase.components.n;
import com.google.firebase.f.c;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public class b implements c {
    private d a;

    private b(Context context) {
        this.a = d.a(context);
    }

    public static com.google.firebase.components.d<c> b() {
        return com.google.firebase.components.d.a(c.class).b(n.f(Context.class)).f(a.b()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c c(e eVar) {
        return new b((Context) eVar.a(Context.class));
    }

    @Override // com.google.firebase.f.c
    public c.a a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean c2 = this.a.c(str, currentTimeMillis);
        boolean b2 = this.a.b(currentTimeMillis);
        if (c2 && b2) {
            return c.a.COMBINED;
        }
        if (b2) {
            return c.a.GLOBAL;
        }
        if (c2) {
            return c.a.SDK;
        }
        return c.a.NONE;
    }
}