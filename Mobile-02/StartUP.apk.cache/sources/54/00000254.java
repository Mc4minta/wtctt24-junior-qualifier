package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

/* compiled from: Person.java */
/* loaded from: classes.dex */
public class n {
    CharSequence a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f1477b;

    /* renamed from: c  reason: collision with root package name */
    String f1478c;

    /* renamed from: d  reason: collision with root package name */
    String f1479d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1480e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1481f;

    public IconCompat a() {
        return this.f1477b;
    }

    public String b() {
        return this.f1479d;
    }

    public CharSequence c() {
        return this.a;
    }

    public String d() {
        return this.f1478c;
    }

    public boolean e() {
        return this.f1480e;
    }

    public boolean f() {
        return this.f1481f;
    }

    public String g() {
        String str = this.f1478c;
        if (str != null) {
            return str;
        }
        if (this.a != null) {
            return "name:" + ((Object) this.a);
        }
        return "";
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().p() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}