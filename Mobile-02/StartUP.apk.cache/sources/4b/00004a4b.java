package e.j.l.r;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.a0.z;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Identicon.kt */
/* loaded from: classes2.dex */
public final class b {
    private final h a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13735b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13736c;

    /* compiled from: Identicon.kt */
    /* loaded from: classes2.dex */
    static final class a extends o implements kotlin.e0.c.a<Long[]> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final Long[] invoke() {
            return new Long[]{0L, 0L, 0L, 0L};
        }
    }

    /* compiled from: Identicon.kt */
    /* renamed from: e.j.l.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0329b extends o implements kotlin.e0.c.a<Integer> {
        C0329b() {
            super(0);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return b.this.c();
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    public b(String address) {
        h b2;
        m.g(address, "address");
        b2 = k.b(a.a);
        this.a = b2;
        this.f13735b = 8;
        this.f13736c = 15;
        String lowerCase = address.toLowerCase();
        m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        g(lowerCase);
    }

    private final long b(long j2) {
        return (-2 <= j2 || j2 < 0) ? (int) j2 : j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int c() {
        return e.j.l.r.a.a(Math.floor(k() * 360.0d), 40.0d + (k() * 60.0d), 25.0d * (k() + k() + k() + k()));
    }

    private final void d(List<Double> list, d dVar, Canvas canvas) {
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!(list.get(i2).doubleValue() == 0.0d)) {
                float floor = (float) Math.floor(i2 / this.f13735b);
                float f2 = i2 % this.f13735b;
                Paint b2 = list.get(i2).doubleValue() == 1.0d ? dVar.b() : dVar.c();
                int i4 = this.f13736c;
                float f3 = f2 * i4;
                float f4 = floor * i4;
                canvas.drawRect(f3, f4, f3 + i4, f4 + i4, b2);
            }
            if (i3 > size) {
                return;
            }
            i2 = i3;
        }
    }

    private final void e(int i2, Canvas canvas, d dVar) {
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f2, f2, dVar.a());
    }

    private final List<Double> f() {
        List v0;
        int i2 = this.f13735b / 2;
        ArrayList arrayList = new ArrayList();
        int i3 = this.f13735b;
        if (i3 > 0) {
            int i4 = 0;
            do {
                i4++;
                ArrayList arrayList2 = new ArrayList();
                if (i2 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        arrayList2.add(i5, Double.valueOf(Math.floor(k() * 2.3d)));
                        if (i6 >= i2) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                v0 = z.v0(arrayList2);
                arrayList2.addAll(v0);
                arrayList.addAll(arrayList2);
            } while (i4 < i3);
            return arrayList;
        }
        return arrayList;
    }

    private final void g(String str) {
        int length = str.length() - 1;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            int i4 = i2 % 4;
            h()[i4] = Long.valueOf((b(h()[i4].longValue() << 5) - h()[i4].longValue()) + Character.codePointAt(str, i2));
            if (i3 > length) {
                return;
            }
            i2 = i3;
        }
    }

    private final Long[] h() {
        return (Long[]) this.a.getValue();
    }

    private final long i(long j2, int i2) {
        return b(j2) << i2;
    }

    private final long j(long j2, int i2) {
        return b(j2) >> i2;
    }

    private final double k() {
        long i2 = i(h()[0].longValue(), 11) ^ h()[0].longValue();
        long j2 = j(i2, 8);
        long j3 = j(h()[3].longValue(), 19);
        h()[0] = h()[1];
        h()[1] = h()[2];
        h()[2] = h()[3];
        h()[3] = Long.valueOf(b(((j3 ^ h()[3].longValue()) ^ i2) ^ j2));
        return Math.abs(h()[3].longValue()) / ((double) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public final Bitmap l() {
        d dVar = new d(new C0329b());
        List<Double> f2 = f();
        int i2 = this.f13735b * this.f13736c;
        Bitmap bitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        e(i2, canvas, dVar);
        d(f2, dVar, canvas);
        m.f(bitmap, "bitmap");
        return bitmap;
    }
}