package androidx.core.content.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpStatus;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {
        private final C0027c[] a;

        public b(C0027c[] c0027cArr) {
            this.a = c0027cArr;
        }

        public C0027c[] a() {
            return this.a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0027c {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private int f1496b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1497c;

        /* renamed from: d  reason: collision with root package name */
        private String f1498d;

        /* renamed from: e  reason: collision with root package name */
        private int f1499e;

        /* renamed from: f  reason: collision with root package name */
        private int f1500f;

        public C0027c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.a = str;
            this.f1496b = i2;
            this.f1497c = z;
            this.f1498d = str2;
            this.f1499e = i3;
            this.f1500f = i4;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f1500f;
        }

        public int c() {
            return this.f1499e;
        }

        public String d() {
            return this.f1498d;
        }

        public int e() {
            return this.f1496b;
        }

        public boolean f() {
            return this.f1497c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {
        private final c.h.i.d a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1501b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1502c;

        /* renamed from: d  reason: collision with root package name */
        private final String f1503d;

        public d(c.h.i.d dVar, int i2, int i3, String str) {
            this.a = dVar;
            this.f1502c = i2;
            this.f1501b = i3;
            this.f1503d = str;
        }

        public int a() {
            return this.f1502c;
        }

        public c.h.i.d b() {
            return this.a;
        }

        public String c() {
            return this.f1503d;
        }

        public int d() {
            return this.f1501b;
        }
    }

    private static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.h.d.f2917e);
        String string = obtainAttributes.getString(c.h.d.f2918f);
        String string2 = obtainAttributes.getString(c.h.d.f2922j);
        String string3 = obtainAttributes.getString(c.h.d.f2923k);
        int resourceId = obtainAttributes.getResourceId(c.h.d.f2919g, 0);
        int integer = obtainAttributes.getInteger(c.h.d.f2920h, 1);
        int integer2 = obtainAttributes.getInteger(c.h.d.f2921i, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        String string4 = obtainAttributes.getString(c.h.d.f2924l);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new c.h.i.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0027c[]) arrayList.toArray(new C0027c[arrayList.size()]));
    }

    private static C0027c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), c.h.d.m);
        int i2 = c.h.d.v;
        if (!obtainAttributes.hasValue(i2)) {
            i2 = c.h.d.o;
        }
        int i3 = obtainAttributes.getInt(i2, HttpStatus.SC_BAD_REQUEST);
        int i4 = c.h.d.t;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = c.h.d.p;
        }
        boolean z = 1 == obtainAttributes.getInt(i4, 0);
        int i5 = c.h.d.w;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = c.h.d.q;
        }
        int i6 = c.h.d.u;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = c.h.d.r;
        }
        String string = obtainAttributes.getString(i6);
        int i7 = obtainAttributes.getInt(i5, 0);
        int i8 = c.h.d.s;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = c.h.d.n;
        }
        int resourceId = obtainAttributes.getResourceId(i8, 0);
        String string2 = obtainAttributes.getString(i8);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0027c(string2, i3, z, string, i7, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}