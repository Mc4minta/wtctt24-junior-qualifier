package com.google.firebase.i;

import com.google.firebase.components.n;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.message.TokenParser;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public class c implements h {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final d f9109b;

    c(Set<f> set, d dVar) {
        this.a = d(set);
        this.f9109b = dVar;
    }

    public static com.google.firebase.components.d<h> b() {
        return com.google.firebase.components.d.a(h.class).b(n.h(f.class)).f(b.b()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ h c(com.google.firebase.components.e eVar) {
        return new c(eVar.d(f.class), d.a());
    }

    private static String d(Set<f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(TokenParser.SP);
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.i.h
    public String a() {
        if (this.f9109b.b().isEmpty()) {
            return this.a;
        }
        return this.a + TokenParser.SP + d(this.f9109b.b());
    }
}