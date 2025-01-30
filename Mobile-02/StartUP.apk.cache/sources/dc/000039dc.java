package com.google.firebase.crashlytics.c.h;

import android.content.Context;
import com.google.firebase.crashlytics.c.g.h;
import java.io.File;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class b {
    private static final c a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final Context f8809b;

    /* renamed from: c  reason: collision with root package name */
    private final InterfaceC0168b f8810c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.firebase.crashlytics.c.h.a f8811d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0168b {
        File a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class c implements com.google.firebase.crashlytics.c.h.a {
        private c() {
        }

        @Override // com.google.firebase.crashlytics.c.h.a
        public void a() {
        }

        @Override // com.google.firebase.crashlytics.c.h.a
        public String b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.c.h.a
        public byte[] c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.c.h.a
        public void d() {
        }

        @Override // com.google.firebase.crashlytics.c.h.a
        public void e(long j2, String str) {
        }
    }

    public b(Context context, InterfaceC0168b interfaceC0168b) {
        this(context, interfaceC0168b, null);
    }

    private String e(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring(20, lastIndexOf);
    }

    private File f(String str) {
        return new File(this.f8810c.a(), "crashlytics-userlog-" + str + ".temp");
    }

    public void a() {
        this.f8811d.d();
    }

    public void b(Set<String> set) {
        File[] listFiles = this.f8810c.a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(e(file))) {
                    file.delete();
                }
            }
        }
    }

    public byte[] c() {
        return this.f8811d.c();
    }

    public String d() {
        return this.f8811d.b();
    }

    public final void g(String str) {
        this.f8811d.a();
        this.f8811d = a;
        if (str == null) {
            return;
        }
        if (!h.l(this.f8809b, "com.crashlytics.CollectCustomLogs", true)) {
            com.google.firebase.crashlytics.c.b.f().b("Preferences requested no custom logs. Aborting log file creation.");
        } else {
            h(f(str), 65536);
        }
    }

    void h(File file, int i2) {
        this.f8811d = new d(file, i2);
    }

    public void i(long j2, String str) {
        this.f8811d.e(j2, str);
    }

    public b(Context context, InterfaceC0168b interfaceC0168b, String str) {
        this.f8809b = context;
        this.f8810c = interfaceC0168b;
        this.f8811d = a;
        g(str);
    }
}