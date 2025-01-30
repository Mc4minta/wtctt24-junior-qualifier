package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: StateSet.java */
/* loaded from: classes.dex */
public class j {
    int a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f1341b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f1342c = -1;

    /* renamed from: d  reason: collision with root package name */
    private SparseArray<a> f1343d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<d> f1344e = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateSet.java */
    /* loaded from: classes.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f1345b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f1346c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1347d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f1346c = -1;
            this.f1347d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.c7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.d7) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == i.e7) {
                    this.f1346c = obtainStyledAttributes.getResourceId(index, this.f1346c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1346c);
                    context.getResources().getResourceName(this.f1346c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f1347d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f1345b.add(bVar);
        }

        public int b(float f2, float f3) {
            for (int i2 = 0; i2 < this.f1345b.size(); i2++) {
                if (this.f1345b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateSet.java */
    /* loaded from: classes.dex */
    public static class b {
        float a;

        /* renamed from: b  reason: collision with root package name */
        float f1348b;

        /* renamed from: c  reason: collision with root package name */
        float f1349c;

        /* renamed from: d  reason: collision with root package name */
        float f1350d;

        /* renamed from: e  reason: collision with root package name */
        int f1351e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1352f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.f1348b = Float.NaN;
            this.f1349c = Float.NaN;
            this.f1350d = Float.NaN;
            this.f1351e = -1;
            this.f1352f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.K7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.L7) {
                    this.f1351e = obtainStyledAttributes.getResourceId(index, this.f1351e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1351e);
                    context.getResources().getResourceName(this.f1351e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f1352f = true;
                    }
                } else if (index == i.M7) {
                    this.f1350d = obtainStyledAttributes.getDimension(index, this.f1350d);
                } else if (index == i.N7) {
                    this.f1348b = obtainStyledAttributes.getDimension(index, this.f1348b);
                } else if (index == i.O7) {
                    this.f1349c = obtainStyledAttributes.getDimension(index, this.f1349c);
                } else if (index == i.P7) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f2, float f3) {
            if (Float.isNaN(this.a) || f2 >= this.a) {
                if (Float.isNaN(this.f1348b) || f3 >= this.f1348b) {
                    if (Float.isNaN(this.f1349c) || f2 <= this.f1349c) {
                        return Float.isNaN(this.f1350d) || f3 <= this.f1350d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public j(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.h7);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == i.i7) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            }
        }
        a aVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0 && c2 != 1) {
                        if (c2 == 2) {
                            aVar = new a(context, xmlPullParser);
                            this.f1343d.put(aVar.a, aVar);
                        } else if (c2 != 3) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            b bVar = new b(context, xmlPullParser);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public int a(int i2, int i3, float f2, float f3) {
        a aVar = this.f1343d.get(i3);
        if (aVar == null) {
            return i3;
        }
        if (f2 != -1.0f && f3 != -1.0f) {
            b bVar = null;
            Iterator<b> it = aVar.f1345b.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a(f2, f3)) {
                    if (i2 == next.f1351e) {
                        return i2;
                    }
                    bVar = next;
                }
            }
            if (bVar != null) {
                return bVar.f1351e;
            }
            return aVar.f1346c;
        } else if (aVar.f1346c == i2) {
            return i2;
        } else {
            Iterator<b> it2 = aVar.f1345b.iterator();
            while (it2.hasNext()) {
                if (i2 == it2.next().f1351e) {
                    return i2;
                }
            }
            return aVar.f1346c;
        }
    }

    public int c(int i2, int i3, int i4) {
        return d(-1, i2, i3, i4);
    }

    public int d(int i2, int i3, float f2, float f3) {
        a aVar;
        int b2;
        if (i2 != i3) {
            a aVar2 = this.f1343d.get(i3);
            if (aVar2 == null) {
                return -1;
            }
            int b3 = aVar2.b(f2, f3);
            return b3 == -1 ? aVar2.f1346c : aVar2.f1345b.get(b3).f1351e;
        }
        if (i3 == -1) {
            aVar = this.f1343d.valueAt(0);
        } else {
            aVar = this.f1343d.get(this.f1341b);
        }
        if (aVar == null) {
            return -1;
        }
        return ((this.f1342c == -1 || !aVar.f1345b.get(i2).a(f2, f3)) && i2 != (b2 = aVar.b(f2, f3))) ? b2 == -1 ? aVar.f1346c : aVar.f1345b.get(b2).f1351e : i2;
    }
}