package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class j {

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        final Bundle a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f1412b;

        /* renamed from: c  reason: collision with root package name */
        private final o[] f1413c;

        /* renamed from: d  reason: collision with root package name */
        private final o[] f1414d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1415e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1416f;

        /* renamed from: g  reason: collision with root package name */
        private final int f1417g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f1418h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f1419i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f1420j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f1421k;

        /* compiled from: NotificationCompat.java */
        /* renamed from: androidx.core.app.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0025a {
            private final IconCompat a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f1422b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f1423c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f1424d;

            /* renamed from: e  reason: collision with root package name */
            private final Bundle f1425e;

            /* renamed from: f  reason: collision with root package name */
            private ArrayList<o> f1426f;

            /* renamed from: g  reason: collision with root package name */
            private int f1427g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f1428h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f1429i;

            public C0025a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2 != 0 ? IconCompat.c(null, "", i2) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            private void b() {
                if (this.f1429i) {
                    Objects.requireNonNull(this.f1423c, "Contextual Actions must contain a valid PendingIntent");
                }
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<o> arrayList3 = this.f1426f;
                if (arrayList3 != null) {
                    Iterator<o> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        o next = it.next();
                        if (next.j()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                o[] oVarArr = arrayList.isEmpty() ? null : (o[]) arrayList.toArray(new o[arrayList.size()]);
                return new a(this.a, this.f1422b, this.f1423c, this.f1425e, arrayList2.isEmpty() ? null : (o[]) arrayList2.toArray(new o[arrayList2.size()]), oVarArr, this.f1424d, this.f1427g, this.f1428h, this.f1429i);
            }

            private C0025a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, o[] oVarArr, boolean z, int i2, boolean z2, boolean z3) {
                this.f1424d = true;
                this.f1428h = true;
                this.a = iconCompat;
                this.f1422b = e.e(charSequence);
                this.f1423c = pendingIntent;
                this.f1425e = bundle;
                this.f1426f = oVarArr == null ? null : new ArrayList<>(Arrays.asList(oVarArr));
                this.f1424d = z;
                this.f1427g = i2;
                this.f1428h = z2;
                this.f1429i = z3;
            }
        }

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.c(null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f1421k;
        }

        public boolean b() {
            return this.f1415e;
        }

        public o[] c() {
            return this.f1414d;
        }

        public Bundle d() {
            return this.a;
        }

        public IconCompat e() {
            int i2;
            if (this.f1412b == null && (i2 = this.f1419i) != 0) {
                this.f1412b = IconCompat.c(null, "", i2);
            }
            return this.f1412b;
        }

        public o[] f() {
            return this.f1413c;
        }

        public int g() {
            return this.f1417g;
        }

        public boolean h() {
            return this.f1416f;
        }

        public CharSequence i() {
            return this.f1420j;
        }

        public boolean j() {
            return this.f1418h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, o[] oVarArr, o[] oVarArr2, boolean z, int i2, boolean z2, boolean z3) {
            this.f1416f = true;
            this.f1412b = iconCompat;
            if (iconCompat != null && iconCompat.i() == 2) {
                this.f1419i = iconCompat.e();
            }
            this.f1420j = e.e(charSequence);
            this.f1421k = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.f1413c = oVarArr;
            this.f1414d = oVarArr2;
            this.f1415e = z;
            this.f1417g = i2;
            this.f1416f = z2;
            this.f1418h = z3;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class b extends f {

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f1430e;

        /* renamed from: f  reason: collision with root package name */
        private IconCompat f1431f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1432g;

        /* compiled from: NotificationCompat.java */
        /* loaded from: classes.dex */
        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* compiled from: NotificationCompat.java */
        /* renamed from: androidx.core.app.j$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0026b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @Override // androidx.core.app.j.f
        public void b(i iVar) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(iVar.a()).setBigContentTitle(this.f1445b).bigPicture(this.f1430e);
                if (this.f1432g) {
                    IconCompat iconCompat = this.f1431f;
                    if (iconCompat == null) {
                        a.a(bigPicture, null);
                    } else if (i2 >= 23) {
                        C0026b.a(bigPicture, this.f1431f.q(iVar instanceof k ? ((k) iVar).f() : null));
                    } else if (iconCompat.i() == 1) {
                        a.a(bigPicture, this.f1431f.d());
                    } else {
                        a.a(bigPicture, null);
                    }
                }
                if (this.f1447d) {
                    a.b(bigPicture, this.f1446c);
                }
            }
        }

        @Override // androidx.core.app.j.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b h(Bitmap bitmap) {
            this.f1431f = bitmap == null ? null : IconCompat.b(bitmap);
            this.f1432g = true;
            return this;
        }

        public b i(Bitmap bitmap) {
            this.f1430e = bitmap;
            return this;
        }

        public b j(CharSequence charSequence) {
            this.f1445b = e.e(charSequence);
            return this;
        }

        public b k(CharSequence charSequence) {
            this.f1446c = e.e(charSequence);
            this.f1447d = true;
            return this;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f1433e;

        @Override // androidx.core.app.j.f
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f1433e);
            }
        }

        @Override // androidx.core.app.j.f
        public void b(i iVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(iVar.a()).setBigContentTitle(this.f1445b).bigText(this.f1433e);
                if (this.f1447d) {
                    bigText.setSummaryText(this.f1446c);
                }
            }
        }

        @Override // androidx.core.app.j.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c h(CharSequence charSequence) {
            this.f1433e = e.e(charSequence);
            return this;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: NotificationCompat.java */
        /* loaded from: classes.dex */
        public static class a {
            static Notification.BubbleMetadata a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                throw null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: NotificationCompat.java */
        /* loaded from: classes.dex */
        public static class b {
            static Notification.BubbleMetadata a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                throw null;
            }
        }

        public static Notification.BubbleMetadata a(d dVar) {
            if (dVar == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return b.a(dVar);
            }
            if (i2 == 29) {
                return a.a(dVar);
            }
            return null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        protected e a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f1445b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f1446c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1447d = false;

        public void a(Bundle bundle) {
            if (this.f1447d) {
                bundle.putCharSequence("android.summaryText", this.f1446c);
            }
            CharSequence charSequence = this.f1445b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c2 = c();
            if (c2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
            }
        }

        public abstract void b(i iVar);

        protected abstract String c();

        public RemoteViews d(i iVar) {
            return null;
        }

        public RemoteViews e(i iVar) {
            return null;
        }

        public RemoteViews f(i iVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.a != eVar) {
                this.a = eVar;
                if (eVar != null) {
                    eVar.D(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return l.c(notification);
        }
        return null;
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        androidx.core.content.b N;
        long O;
        int P;
        boolean Q;
        d R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f1434b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<n> f1435c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f1436d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f1437e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f1438f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f1439g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f1440h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f1441i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f1442j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f1443k;

        /* renamed from: l  reason: collision with root package name */
        int f1444l;
        int m;
        boolean n;
        boolean o;
        f p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        public e(Context context, String str) {
            this.f1434b = new ArrayList<>();
            this.f1435c = new ArrayList<>();
            this.f1436d = new ArrayList<>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap f(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(c.h.b.f2902b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(c.h.b.a);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
            }
            return bitmap;
        }

        private void p(int i2, boolean z) {
            if (z) {
                Notification notification = this.S;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.S;
            notification2.flags = (~i2) & notification2.flags;
        }

        public e A(boolean z) {
            this.n = z;
            return this;
        }

        public e B(int i2) {
            this.S.icon = i2;
            return this;
        }

        public e C(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public e D(f fVar) {
            if (this.p != fVar) {
                this.p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public e E(CharSequence charSequence) {
            this.q = e(charSequence);
            return this;
        }

        public e F(CharSequence charSequence) {
            this.S.tickerText = e(charSequence);
            return this;
        }

        public e G(long j2) {
            this.O = j2;
            return this;
        }

        public e H(boolean z) {
            this.o = z;
            return this;
        }

        public e I(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e J(int i2) {
            this.F = i2;
            return this;
        }

        public e K(long j2) {
            this.S.when = j2;
            return this;
        }

        public e a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1434b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f1434b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new k(this).c();
        }

        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e g(boolean z) {
            p(16, z);
            return this;
        }

        public e h(String str) {
            this.C = str;
            return this;
        }

        public e i(String str) {
            this.K = str;
            return this;
        }

        public e j(int i2) {
            this.E = i2;
            return this;
        }

        public e k(PendingIntent pendingIntent) {
            this.f1439g = pendingIntent;
            return this;
        }

        public e l(CharSequence charSequence) {
            this.f1438f = e(charSequence);
            return this;
        }

        public e m(CharSequence charSequence) {
            this.f1437e = e(charSequence);
            return this;
        }

        public e n(int i2) {
            Notification notification = this.S;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e o(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public e q(String str) {
            this.w = str;
            return this;
        }

        public e r(boolean z) {
            this.x = z;
            return this;
        }

        public e s(Bitmap bitmap) {
            this.f1442j = f(bitmap);
            return this;
        }

        public e t(int i2, int i3, int i4) {
            Notification notification = this.S;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e u(boolean z) {
            this.z = z;
            return this;
        }

        public e v(int i2) {
            this.f1444l = i2;
            return this;
        }

        public e w(boolean z) {
            p(2, z);
            return this;
        }

        public e x(boolean z) {
            p(8, z);
            return this;
        }

        public e y(int i2) {
            this.m = i2;
            return this;
        }

        public e z(String str) {
            this.M = str;
            return this;
        }

        @Deprecated
        public e(Context context) {
            this(context, null);
        }
    }
}