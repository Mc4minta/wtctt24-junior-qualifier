package e.a.a.w;

import e.a.a.w.k.n;
import java.util.List;

/* compiled from: FontCharacter.java */
/* loaded from: classes.dex */
public class d {
    private final List<n> a;

    /* renamed from: b  reason: collision with root package name */
    private final char f11757b;

    /* renamed from: c  reason: collision with root package name */
    private final double f11758c;

    /* renamed from: d  reason: collision with root package name */
    private final double f11759d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11760e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11761f;

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.a = list;
        this.f11757b = c2;
        this.f11758c = d2;
        this.f11759d = d3;
        this.f11760e = str;
        this.f11761f = str2;
    }

    public static int c(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<n> a() {
        return this.a;
    }

    public double b() {
        return this.f11759d;
    }

    public int hashCode() {
        return c(this.f11757b, this.f11761f, this.f11760e);
    }
}