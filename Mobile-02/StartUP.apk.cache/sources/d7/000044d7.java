package e.a.a.w.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import e.a.a.l;
import e.a.a.u.c.n;
import e.a.a.u.c.p;
import e.a.a.w.b;
import e.a.a.w.j.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class h extends e.a.a.w.l.a {
    private final Paint A;
    private final Paint B;
    private final Map<e.a.a.w.d, List<e.a.a.u.b.d>> C;
    private final c.e.d<String> D;
    private final n E;
    private final e.a.a.g F;
    private final e.a.a.e G;
    private e.a.a.u.c.a<Integer, Integer> H;
    private e.a.a.u.c.a<Integer, Integer> I;
    private e.a.a.u.c.a<Integer, Integer> J;
    private e.a.a.u.c.a<Integer, Integer> K;
    private e.a.a.u.c.a<Float, Float> L;
    private e.a.a.u.c.a<Float, Float> M;
    private e.a.a.u.c.a<Float, Float> N;
    private e.a.a.u.c.a<Float, Float> O;
    private e.a.a.u.c.a<Float, Float> P;
    private e.a.a.u.c.a<Float, Float> Q;
    private final StringBuilder x;
    private final RectF y;
    private final Matrix z;

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class a extends Paint {
        a(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class b extends Paint {
        b(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.a.values().length];
            a = iArr;
            try {
                iArr[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e.a.a.g gVar, d dVar) {
        super(gVar, dVar);
        e.a.a.w.j.b bVar;
        e.a.a.w.j.b bVar2;
        e.a.a.w.j.a aVar;
        e.a.a.w.j.a aVar2;
        this.x = new StringBuilder(2);
        this.y = new RectF();
        this.z = new Matrix();
        this.A = new a(1);
        this.B = new b(1);
        this.C = new HashMap();
        this.D = new c.e.d<>();
        this.F = gVar;
        this.G = dVar.a();
        n a2 = dVar.q().a();
        this.E = a2;
        a2.a(this);
        i(a2);
        k r = dVar.r();
        if (r != null && (aVar2 = r.a) != null) {
            e.a.a.u.c.a<Integer, Integer> a3 = aVar2.a();
            this.H = a3;
            a3.a(this);
            i(this.H);
        }
        if (r != null && (aVar = r.f11770b) != null) {
            e.a.a.u.c.a<Integer, Integer> a4 = aVar.a();
            this.J = a4;
            a4.a(this);
            i(this.J);
        }
        if (r != null && (bVar2 = r.f11771c) != null) {
            e.a.a.u.c.a<Float, Float> a5 = bVar2.a();
            this.L = a5;
            a5.a(this);
            i(this.L);
        }
        if (r == null || (bVar = r.f11772d) == null) {
            return;
        }
        e.a.a.u.c.a<Float, Float> a6 = bVar.a();
        this.N = a6;
        a6.a(this);
        i(this.N);
    }

    private void J(b.a aVar, Canvas canvas, float f2) {
        int i2 = c.a[aVar.ordinal()];
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i2 != 3) {
        } else {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    private String K(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!W(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = codePointAt;
        if (this.D.e(j2)) {
            return this.D.h(j2);
        }
        this.x.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.x.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.x.toString();
        this.D.n(j2, sb);
        return sb;
    }

    private void L(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void M(e.a.a.w.d dVar, Matrix matrix, float f2, e.a.a.w.b bVar, Canvas canvas) {
        List<e.a.a.u.b.d> T = T(dVar);
        for (int i2 = 0; i2 < T.size(); i2++) {
            Path path = T.get(i2).getPath();
            path.computeBounds(this.y, false);
            this.z.set(matrix);
            this.z.preTranslate(0.0f, (-bVar.f11746g) * e.a.a.z.h.e());
            this.z.preScale(f2, f2);
            path.transform(this.z);
            if (bVar.f11750k) {
                P(path, this.A, canvas);
                P(path, this.B, canvas);
            } else {
                P(path, this.B, canvas);
                P(path, this.A, canvas);
            }
        }
    }

    private void N(String str, e.a.a.w.b bVar, Canvas canvas) {
        if (bVar.f11750k) {
            L(str, this.A, canvas);
            L(str, this.B, canvas);
            return;
        }
        L(str, this.B, canvas);
        L(str, this.A, canvas);
    }

    private void O(String str, e.a.a.w.b bVar, Canvas canvas, float f2) {
        int i2 = 0;
        while (i2 < str.length()) {
            String K = K(str, i2);
            i2 += K.length();
            N(K, bVar, canvas);
            canvas.translate(this.A.measureText(K) + f2, 0.0f);
        }
    }

    private void P(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void Q(String str, e.a.a.w.b bVar, Matrix matrix, e.a.a.w.c cVar, Canvas canvas, float f2, float f3) {
        float floatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            e.a.a.w.d f4 = this.G.c().f(e.a.a.w.d.c(str.charAt(i2), cVar.a(), cVar.c()));
            if (f4 != null) {
                M(f4, matrix, f3, bVar, canvas);
                float b2 = ((float) f4.b()) * f3 * e.a.a.z.h.e() * f2;
                float f5 = bVar.f11744e / 10.0f;
                e.a.a.u.c.a<Float, Float> aVar = this.O;
                if (aVar != null) {
                    floatValue = aVar.h().floatValue();
                } else {
                    e.a.a.u.c.a<Float, Float> aVar2 = this.N;
                    if (aVar2 != null) {
                        floatValue = aVar2.h().floatValue();
                    }
                    canvas.translate(b2 + (f5 * f2), 0.0f);
                }
                f5 += floatValue;
                canvas.translate(b2 + (f5 * f2), 0.0f);
            }
        }
    }

    private void R(e.a.a.w.b bVar, Matrix matrix, e.a.a.w.c cVar, Canvas canvas) {
        float f2;
        e.a.a.u.c.a<Float, Float> aVar = this.Q;
        if (aVar != null) {
            f2 = aVar.h().floatValue();
        } else {
            e.a.a.u.c.a<Float, Float> aVar2 = this.P;
            if (aVar2 != null) {
                f2 = aVar2.h().floatValue();
            } else {
                f2 = bVar.f11742c;
            }
        }
        float f3 = f2 / 100.0f;
        float g2 = e.a.a.z.h.g(matrix);
        String str = bVar.a;
        float e2 = bVar.f11745f * e.a.a.z.h.e();
        List<String> V = V(str);
        int size = V.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = V.get(i2);
            float U = U(str2, cVar, f3, g2);
            canvas.save();
            J(bVar.f11743d, canvas, U);
            canvas.translate(0.0f, (i2 * e2) - (((size - 1) * e2) / 2.0f));
            Q(str2, bVar, matrix, cVar, canvas, g2, f3);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3 A[LOOP:0: B:22:0x00a1->B:23:0x00a3, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void S(e.a.a.w.b r7, e.a.a.w.c r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            e.a.a.z.h.g(r9)
            e.a.a.g r9 = r6.F
            java.lang.String r0 = r8.a()
            java.lang.String r8 = r8.c()
            android.graphics.Typeface r8 = r9.E(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.a
            e.a.a.g r0 = r6.F
            e.a.a.t r0 = r0.D()
            if (r0 != 0) goto Ld8
            android.graphics.Paint r0 = r6.A
            r0.setTypeface(r8)
            e.a.a.u.c.a<java.lang.Float, java.lang.Float> r8 = r6.Q
            if (r8 == 0) goto L32
            java.lang.Object r8 = r8.h()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L43
        L32:
            e.a.a.u.c.a<java.lang.Float, java.lang.Float> r8 = r6.P
            if (r8 == 0) goto L41
            java.lang.Object r8 = r8.h()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L43
        L41:
            float r8 = r7.f11742c
        L43:
            android.graphics.Paint r0 = r6.A
            float r1 = e.a.a.z.h.e()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.B
            android.graphics.Paint r1 = r6.A
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.B
            android.graphics.Paint r1 = r6.A
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f11745f
            float r1 = e.a.a.z.h.e()
            float r0 = r0 * r1
            int r1 = r7.f11744e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            e.a.a.u.c.a<java.lang.Float, java.lang.Float> r2 = r6.O
            if (r2 == 0) goto L80
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L7e:
            float r1 = r1 + r2
            goto L8f
        L80:
            e.a.a.u.c.a<java.lang.Float, java.lang.Float> r2 = r6.N
            if (r2 == 0) goto L8f
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L7e
        L8f:
            float r2 = e.a.a.z.h.e()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.V(r9)
            int r9 = r8.size()
            r2 = 0
        La1:
            if (r2 >= r9) goto Ld7
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.B
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            e.a.a.w.b$a r5 = r7.f11743d
            r6.J(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.O(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La1
        Ld7:
            return
        Ld8:
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.w.l.h.S(e.a.a.w.b, e.a.a.w.c, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    private List<e.a.a.u.b.d> T(e.a.a.w.d dVar) {
        if (this.C.containsKey(dVar)) {
            return this.C.get(dVar);
        }
        List<e.a.a.w.k.n> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new e.a.a.u.b.d(this.F, this, a2.get(i2)));
        }
        this.C.put(dVar, arrayList);
        return arrayList;
    }

    private float U(String str, e.a.a.w.c cVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            e.a.a.w.d f5 = this.G.c().f(e.a.a.w.d.c(str.charAt(i2), cVar.a(), cVar.c()));
            if (f5 != null) {
                f4 = (float) (f4 + (f5.b() * f2 * e.a.a.z.h.e() * f3));
            }
        }
        return f4;
    }

    private List<String> V(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean W(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // e.a.a.w.l.a, e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.G.b().width(), this.G.b().height());
    }

    @Override // e.a.a.w.l.a, e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        super.g(t, cVar);
        if (t == l.a) {
            e.a.a.u.c.a<Integer, Integer> aVar = this.I;
            if (aVar != null) {
                C(aVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            p pVar = new p(cVar);
            this.I = pVar;
            pVar.a(this);
            i(this.I);
        } else if (t == l.f11564b) {
            e.a.a.u.c.a<Integer, Integer> aVar2 = this.K;
            if (aVar2 != null) {
                C(aVar2);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.K = pVar2;
            pVar2.a(this);
            i(this.K);
        } else if (t == l.o) {
            e.a.a.u.c.a<Float, Float> aVar3 = this.M;
            if (aVar3 != null) {
                C(aVar3);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            p pVar3 = new p(cVar);
            this.M = pVar3;
            pVar3.a(this);
            i(this.M);
        } else if (t == l.p) {
            e.a.a.u.c.a<Float, Float> aVar4 = this.O;
            if (aVar4 != null) {
                C(aVar4);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            p pVar4 = new p(cVar);
            this.O = pVar4;
            pVar4.a(this);
            i(this.O);
        } else if (t == l.B) {
            e.a.a.u.c.a<Float, Float> aVar5 = this.Q;
            if (aVar5 != null) {
                C(aVar5);
            }
            if (cVar == null) {
                this.Q = null;
                return;
            }
            p pVar5 = new p(cVar);
            this.Q = pVar5;
            pVar5.a(this);
            i(this.Q);
        }
    }

    @Override // e.a.a.w.l.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.F.l0()) {
            canvas.concat(matrix);
        }
        e.a.a.w.b h2 = this.E.h();
        e.a.a.w.c cVar = this.G.g().get(h2.f11741b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        e.a.a.u.c.a<Integer, Integer> aVar = this.I;
        if (aVar != null) {
            this.A.setColor(aVar.h().intValue());
        } else {
            e.a.a.u.c.a<Integer, Integer> aVar2 = this.H;
            if (aVar2 != null) {
                this.A.setColor(aVar2.h().intValue());
            } else {
                this.A.setColor(h2.f11747h);
            }
        }
        e.a.a.u.c.a<Integer, Integer> aVar3 = this.K;
        if (aVar3 != null) {
            this.B.setColor(aVar3.h().intValue());
        } else {
            e.a.a.u.c.a<Integer, Integer> aVar4 = this.J;
            if (aVar4 != null) {
                this.B.setColor(aVar4.h().intValue());
            } else {
                this.B.setColor(h2.f11748i);
            }
        }
        int intValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.A.setAlpha(intValue);
        this.B.setAlpha(intValue);
        e.a.a.u.c.a<Float, Float> aVar5 = this.M;
        if (aVar5 != null) {
            this.B.setStrokeWidth(aVar5.h().floatValue());
        } else {
            e.a.a.u.c.a<Float, Float> aVar6 = this.L;
            if (aVar6 != null) {
                this.B.setStrokeWidth(aVar6.h().floatValue());
            } else {
                this.B.setStrokeWidth(h2.f11749j * e.a.a.z.h.e() * e.a.a.z.h.g(matrix));
            }
        }
        if (this.F.l0()) {
            R(h2, matrix, cVar, canvas);
        } else {
            S(h2, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}