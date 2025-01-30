package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintLayoutStates.java */
/* loaded from: classes.dex */
public class c {
    private final ConstraintLayout a;

    /* renamed from: b  reason: collision with root package name */
    d f1271b;

    /* renamed from: c  reason: collision with root package name */
    int f1272c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f1273d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<a> f1274e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<d> f1275f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private f f1276g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintLayoutStates.java */
    /* loaded from: classes.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f1277b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f1278c;

        /* renamed from: d  reason: collision with root package name */
        d f1279d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f1278c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.c7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.d7) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == i.e7) {
                    this.f1278c = obtainStyledAttributes.getResourceId(index, this.f1278c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1278c);
                    context.getResources().getResourceName(this.f1278c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1279d = dVar;
                        dVar.i(context, this.f1278c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f1277b.add(bVar);
        }

        public int b(float f2, float f3) {
            for (int i2 = 0; i2 < this.f1277b.size(); i2++) {
                if (this.f1277b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintLayoutStates.java */
    /* loaded from: classes.dex */
    public static class b {
        float a;

        /* renamed from: b  reason: collision with root package name */
        float f1280b;

        /* renamed from: c  reason: collision with root package name */
        float f1281c;

        /* renamed from: d  reason: collision with root package name */
        float f1282d;

        /* renamed from: e  reason: collision with root package name */
        int f1283e;

        /* renamed from: f  reason: collision with root package name */
        d f1284f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.f1280b = Float.NaN;
            this.f1281c = Float.NaN;
            this.f1282d = Float.NaN;
            this.f1283e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.K7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.L7) {
                    this.f1283e = obtainStyledAttributes.getResourceId(index, this.f1283e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1283e);
                    context.getResources().getResourceName(this.f1283e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1284f = dVar;
                        dVar.i(context, this.f1283e);
                    }
                } else if (index == i.M7) {
                    this.f1282d = obtainStyledAttributes.getDimension(index, this.f1282d);
                } else if (index == i.N7) {
                    this.f1280b = obtainStyledAttributes.getDimension(index, this.f1280b);
                } else if (index == i.O7) {
                    this.f1281c = obtainStyledAttributes.getDimension(index, this.f1281c);
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
                if (Float.isNaN(this.f1280b) || f3 >= this.f1280b) {
                    if (Float.isNaN(this.f1281c) || f2 <= this.f1281c) {
                        return Float.isNaN(this.f1282d) || f3 <= this.f1282d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, ConstraintLayout constraintLayout, int i2) {
        this.a = constraintLayout;
        a(context, i2);
    }

    private void a(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
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
                            aVar = new a(context, xml);
                            this.f1274e.put(aVar.a, aVar);
                            continue;
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                                continue;
                            } else {
                                continue;
                            }
                        } else if (c2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            continue;
                        } else {
                            b(context, xml);
                            continue;
                        }
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if ("id".equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.y(context, xmlPullParser);
                this.f1275f.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(f fVar) {
    }

    public void d(int i2, float f2, float f3) {
        d dVar;
        a aVar;
        int b2;
        d dVar2;
        int i3 = this.f1272c;
        if (i3 == i2) {
            if (i2 == -1) {
                aVar = this.f1274e.valueAt(0);
            } else {
                aVar = this.f1274e.get(i3);
            }
            int i4 = this.f1273d;
            if ((i4 == -1 || !aVar.f1277b.get(i4).a(f2, f3)) && this.f1273d != (b2 = aVar.b(f2, f3))) {
                if (b2 == -1) {
                    dVar2 = this.f1271b;
                } else {
                    dVar2 = aVar.f1277b.get(b2).f1284f;
                }
                if (b2 != -1) {
                    int i5 = aVar.f1277b.get(b2).f1283e;
                }
                if (dVar2 == null) {
                    return;
                }
                this.f1273d = b2;
                if (this.f1276g == null) {
                    dVar2.d(this.a);
                    if (this.f1276g != null) {
                        throw null;
                    }
                    return;
                }
                throw null;
            }
            return;
        }
        this.f1272c = i2;
        a aVar2 = this.f1274e.get(i2);
        int b3 = aVar2.b(f2, f3);
        if (b3 == -1) {
            dVar = aVar2.f1279d;
        } else {
            dVar = aVar2.f1277b.get(b3).f1284f;
        }
        if (b3 != -1) {
            int i6 = aVar2.f1277b.get(b3).f1283e;
        }
        if (dVar == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i2 + ", dim =" + f2 + ", " + f3);
            return;
        }
        this.f1273d = b3;
        if (this.f1276g == null) {
            dVar.d(this.a);
            if (this.f1276g != null) {
                throw null;
            }
            return;
        }
        throw null;
    }
}