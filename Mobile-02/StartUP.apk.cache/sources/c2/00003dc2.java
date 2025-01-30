package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import org.apache.http.HttpStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontData.java */
/* loaded from: classes2.dex */
public class h {
    static final h a = new h();

    /* renamed from: b  reason: collision with root package name */
    final double f10229b;

    /* renamed from: c  reason: collision with root package name */
    final String f10230c;

    /* renamed from: d  reason: collision with root package name */
    final k0 f10231d;

    /* renamed from: e  reason: collision with root package name */
    final ReadableMap f10232e;

    /* renamed from: f  reason: collision with root package name */
    m0 f10233f;

    /* renamed from: g  reason: collision with root package name */
    int f10234g;

    /* renamed from: h  reason: collision with root package name */
    final String f10235h;

    /* renamed from: i  reason: collision with root package name */
    final String f10236i;

    /* renamed from: j  reason: collision with root package name */
    final l0 f10237j;

    /* renamed from: k  reason: collision with root package name */
    final n0 f10238k;

    /* renamed from: l  reason: collision with root package name */
    private final o0 f10239l;
    final double m;
    final double n;
    final double o;
    final boolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FontData.java */
    /* loaded from: classes2.dex */
    public static class a {
        private static final m0[] a;

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f10240b;

        static {
            m0 m0Var = m0.w100;
            m0 m0Var2 = m0.w900;
            a = new m0[]{m0Var, m0Var, m0.w200, m0.w300, m0.Normal, m0.w500, m0.w600, m0.Bold, m0.w800, m0Var2, m0Var2};
            f10240b = new int[]{HttpStatus.SC_BAD_REQUEST, 700, 100, 200, HttpStatus.SC_MULTIPLE_CHOICES, HttpStatus.SC_BAD_REQUEST, HttpStatus.SC_INTERNAL_SERVER_ERROR, 600, 700, 800, 900};
        }

        private static int a(int i2) {
            if (i2 < 350) {
                return HttpStatus.SC_BAD_REQUEST;
            }
            if (i2 < 550) {
                return 700;
            }
            if (i2 < 900) {
                return 900;
            }
            return i2;
        }

        static int b(m0 m0Var, h hVar) {
            if (m0Var == m0.Bolder) {
                return a(hVar.f10234g);
            }
            if (m0Var == m0.Lighter) {
                return c(hVar.f10234g);
            }
            return f10240b[m0Var.ordinal()];
        }

        private static int c(int i2) {
            if (i2 < 100) {
                return i2;
            }
            if (i2 < 550) {
                return 100;
            }
            if (i2 < 750) {
                return HttpStatus.SC_BAD_REQUEST;
            }
            return 700;
        }

        static m0 d(int i2) {
            return a[Math.round(i2 / 100.0f)];
        }
    }

    private h() {
        this.f10232e = null;
        this.f10230c = "";
        this.f10231d = k0.normal;
        this.f10233f = m0.Normal;
        this.f10234g = HttpStatus.SC_BAD_REQUEST;
        this.f10235h = "";
        this.f10236i = "";
        this.f10237j = l0.normal;
        this.f10238k = n0.start;
        this.f10239l = o0.None;
        this.p = false;
        this.m = 0.0d;
        this.f10229b = 12.0d;
        this.n = 0.0d;
        this.o = 0.0d;
    }

    private void a(h hVar, double d2) {
        long round = Math.round(d2);
        if (round >= 1 && round <= 1000) {
            int i2 = (int) round;
            this.f10234g = i2;
            this.f10233f = a.d(i2);
            return;
        }
        b(hVar);
    }

    private void b(h hVar) {
        this.f10234g = hVar.f10234g;
        this.f10233f = hVar.f10233f;
    }

    private double c(ReadableMap readableMap, String str, double d2, double d3, double d4) {
        if (readableMap.getType(str) == ReadableType.Number) {
            return readableMap.getDouble(str);
        }
        return w.b(readableMap.getString(str), d4, d2, d3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ReadableMap readableMap, h hVar, double d2) {
        double d3 = hVar.f10229b;
        if (readableMap.hasKey("fontSize")) {
            this.f10229b = c(readableMap, "fontSize", 1.0d, d3, d3);
        } else {
            this.f10229b = d3;
        }
        if (readableMap.hasKey("fontWeight")) {
            if (readableMap.getType("fontWeight") == ReadableType.Number) {
                a(hVar, readableMap.getDouble("fontWeight"));
            } else {
                String string = readableMap.getString("fontWeight");
                if (m0.n(string)) {
                    int b2 = a.b(m0.h(string), hVar);
                    this.f10234g = b2;
                    this.f10233f = a.d(b2);
                } else if (string != null) {
                    a(hVar, Double.parseDouble(string));
                } else {
                    b(hVar);
                }
            }
        } else {
            b(hVar);
        }
        this.f10232e = readableMap.hasKey("fontData") ? readableMap.getMap("fontData") : hVar.f10232e;
        this.f10230c = readableMap.hasKey("fontFamily") ? readableMap.getString("fontFamily") : hVar.f10230c;
        this.f10231d = readableMap.hasKey("fontStyle") ? k0.valueOf(readableMap.getString("fontStyle")) : hVar.f10231d;
        this.f10235h = readableMap.hasKey("fontFeatureSettings") ? readableMap.getString("fontFeatureSettings") : hVar.f10235h;
        this.f10236i = readableMap.hasKey("fontVariationSettings") ? readableMap.getString("fontVariationSettings") : hVar.f10236i;
        this.f10237j = readableMap.hasKey("fontVariantLigatures") ? l0.valueOf(readableMap.getString("fontVariantLigatures")) : hVar.f10237j;
        this.f10238k = readableMap.hasKey("textAnchor") ? n0.valueOf(readableMap.getString("textAnchor")) : hVar.f10238k;
        this.f10239l = readableMap.hasKey("textDecoration") ? o0.h(readableMap.getString("textDecoration")) : hVar.f10239l;
        boolean hasKey = readableMap.hasKey("kerning");
        this.p = hasKey || hVar.p;
        this.m = hasKey ? c(readableMap, "kerning", d2, this.f10229b, 0.0d) : hVar.m;
        this.n = readableMap.hasKey("wordSpacing") ? c(readableMap, "wordSpacing", d2, this.f10229b, 0.0d) : hVar.n;
        this.o = readableMap.hasKey("letterSpacing") ? c(readableMap, "letterSpacing", d2, this.f10229b, 0.0d) : hVar.o;
    }
}