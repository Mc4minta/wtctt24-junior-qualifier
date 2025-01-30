package com.google.firebase.crashlytics.c.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class v implements w {
    private static final Pattern a = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: b  reason: collision with root package name */
    private static final String f8802b = Pattern.quote("/");

    /* renamed from: c  reason: collision with root package name */
    private final x f8803c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f8804d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8805e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.iid.b.a f8806f;

    /* renamed from: g  reason: collision with root package name */
    private String f8807g;

    public v(Context context, String str, com.google.firebase.iid.b.a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str != null) {
            this.f8804d = context;
            this.f8805e = str;
            this.f8806f = aVar;
            this.f8803c = new x();
            return;
        }
        throw new IllegalArgumentException("appIdentifier must not be null");
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String c2;
        c2 = c(UUID.randomUUID().toString());
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Created new Crashlytics IID: " + c2);
        sharedPreferences.edit().putString("crashlytics.installation.id", c2).putString("firebase.installation.id", str).apply();
        return c2;
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        return a.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    private synchronized void i(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    private String j(String str) {
        return str.replaceAll(f8802b, "");
    }

    @Override // com.google.firebase.crashlytics.c.g.w
    public synchronized String a() {
        String str = this.f8807g;
        if (str != null) {
            return str;
        }
        SharedPreferences t = h.t(this.f8804d);
        String id = this.f8806f.getId();
        String string = t.getString("firebase.installation.id", null);
        if (string == null) {
            SharedPreferences o = h.o(this.f8804d);
            String string2 = o.getString("crashlytics.installation.id", null);
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("No cached FID; legacy id is " + string2);
            if (string2 == null) {
                this.f8807g = b(id, t);
            } else {
                this.f8807g = string2;
                i(string2, id, t, o);
            }
            return this.f8807g;
        }
        if (string.equals(id)) {
            this.f8807g = t.getString("crashlytics.installation.id", null);
            com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
            f3.b("Found matching FID, using Crashlytics IID: " + this.f8807g);
            if (this.f8807g == null) {
                this.f8807g = b(id, t);
            }
        } else {
            this.f8807g = b(id, t);
        }
        return this.f8807g;
    }

    public String d() {
        return this.f8805e;
    }

    public String e() {
        return this.f8803c.a(this.f8804d);
    }

    public String f() {
        return String.format(Locale.US, "%s/%s", j(Build.MANUFACTURER), j(Build.MODEL));
    }

    public String g() {
        return j(Build.VERSION.INCREMENTAL);
    }

    public String h() {
        return j(Build.VERSION.RELEASE);
    }
}