package e.f.m.b0.b;

import android.content.Context;
import android.net.Uri;

/* compiled from: ImageSource.java */
/* loaded from: classes2.dex */
public class a {
    private Uri a;

    /* renamed from: b  reason: collision with root package name */
    private String f12813b;

    /* renamed from: c  reason: collision with root package name */
    private double f12814c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12815d;

    public a(Context context, String str, double d2, double d3) {
        this.f12813b = str;
        this.f12814c = d2 * d3;
        this.a = b(context);
    }

    private Uri a(Context context) {
        this.f12815d = true;
        return c.a().d(context, this.f12813b);
    }

    private Uri b(Context context) {
        try {
            Uri parse = Uri.parse(this.f12813b);
            return parse.getScheme() == null ? a(context) : parse;
        } catch (Exception unused) {
            return a(context);
        }
    }

    public double c() {
        return this.f12814c;
    }

    public String d() {
        return this.f12813b;
    }

    public Uri e() {
        return (Uri) e.f.k.a.a.c(this.a);
    }

    public boolean f() {
        return this.f12815d;
    }

    public a(Context context, String str) {
        this(context, str, 0.0d, 0.0d);
    }
}