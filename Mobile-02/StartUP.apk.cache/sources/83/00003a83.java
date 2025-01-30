package com.google.firebase.crashlytics.c.n;

import com.google.firebase.crashlytics.c.n.b;
import com.google.firebase.crashlytics.c.n.c.c;
import com.google.firebase.crashlytics.c.n.c.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class a {
    private final b.c a;

    public a(b.c cVar) {
        this.a = cVar;
    }

    public boolean a() {
        File[] b2 = this.a.b();
        File[] a = this.a.a();
        if (b2 == null || b2.length <= 0) {
            return a != null && a.length > 0;
        }
        return true;
    }

    public void b(c cVar) {
        cVar.remove();
    }

    public void c(List<c> list) {
        for (c cVar : list) {
            b(cVar);
        }
    }

    public List<c> d() {
        com.google.firebase.crashlytics.c.b.f().b("Checking for crash reports...");
        File[] b2 = this.a.b();
        File[] a = this.a.a();
        LinkedList linkedList = new LinkedList();
        if (b2 != null) {
            for (File file : b2) {
                com.google.firebase.crashlytics.c.b.f().b("Found crash report " + file.getPath());
                linkedList.add(new d(file));
            }
        }
        if (a != null) {
            for (File file2 : a) {
                linkedList.add(new com.google.firebase.crashlytics.c.n.c.b(file2));
            }
        }
        if (linkedList.isEmpty()) {
            com.google.firebase.crashlytics.c.b.f().b("No reports found.");
        }
        return linkedList;
    }
}