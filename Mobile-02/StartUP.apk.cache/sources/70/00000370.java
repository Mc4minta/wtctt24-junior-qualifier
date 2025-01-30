package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.d;
import androidx.navigation.h;
import androidx.navigation.p;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: NavInflater.java */
/* loaded from: classes.dex */
public final class o {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f1916b;

    /* renamed from: c  reason: collision with root package name */
    private t f1917c;

    public o(Context context, t tVar) {
        this.f1916b = context;
        this.f1917c = tVar;
    }

    private static q a(TypedValue typedValue, q qVar, q qVar2, String str, String str2) throws XmlPullParserException {
        if (qVar == null || qVar == qVar2) {
            return qVar != null ? qVar : qVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private k b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i2) throws XmlPullParserException, IOException {
        int depth;
        k createDestination = this.f1917c.d(xmlResourceParser.getName()).createDestination();
        createDestination.x(this.f1916b, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    g(resources, createDestination, attributeSet, i2);
                } else if ("deepLink".equals(name)) {
                    h(resources, createDestination, attributeSet);
                } else if ("action".equals(name)) {
                    d(resources, createDestination, attributeSet, xmlResourceParser, i2);
                } else if ("include".equals(name) && (createDestination instanceof l)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, v.r);
                    ((l) createDestination).E(c(obtainAttributes.getResourceId(v.s, 0)));
                    obtainAttributes.recycle();
                } else if (createDestination instanceof l) {
                    ((l) createDestination).E(b(resources, xmlResourceParser, attributeSet, i2));
                }
            }
        }
        return createDestination;
    }

    private void d(Resources resources, k kVar, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i2) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.w.a.f1957f);
        int resourceId = obtainAttributes.getResourceId(androidx.navigation.w.a.f1958g, 0);
        c cVar = new c(obtainAttributes.getResourceId(androidx.navigation.w.a.f1959h, 0));
        p.a aVar = new p.a();
        aVar.d(obtainAttributes.getBoolean(androidx.navigation.w.a.f1962k, false));
        aVar.g(obtainAttributes.getResourceId(androidx.navigation.w.a.n, -1), obtainAttributes.getBoolean(androidx.navigation.w.a.o, false));
        aVar.b(obtainAttributes.getResourceId(androidx.navigation.w.a.f1960i, -1));
        aVar.c(obtainAttributes.getResourceId(androidx.navigation.w.a.f1961j, -1));
        aVar.e(obtainAttributes.getResourceId(androidx.navigation.w.a.f1963l, -1));
        aVar.f(obtainAttributes.getResourceId(androidx.navigation.w.a.m, -1));
        cVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                f(resources, bundle, attributeSet, i2);
            }
        }
        if (!bundle.isEmpty()) {
            cVar.d(bundle);
        }
        kVar.y(resourceId, cVar);
        obtainAttributes.recycle();
    }

    private d e(TypedArray typedArray, Resources resources, int i2) throws XmlPullParserException {
        d.a aVar = new d.a();
        aVar.c(typedArray.getBoolean(androidx.navigation.w.a.t, false));
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.w.a.s);
        Object obj = null;
        q<Integer> a2 = string != null ? q.a(string, resources.getResourcePackageName(i2)) : null;
        int i3 = androidx.navigation.w.a.r;
        if (typedArray.getValue(i3, typedValue)) {
            q<Integer> qVar = q.f1930b;
            if (a2 == qVar) {
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    obj = Integer.valueOf(i4);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    obj = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a2.c() + ". Must be a reference to a resource.");
                }
            } else {
                int i5 = typedValue.resourceId;
                if (i5 != 0) {
                    if (a2 == null) {
                        a2 = qVar;
                        obj = Integer.valueOf(i5);
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a2.c() + ". You must use a \"" + qVar.c() + "\" type to reference other resources.");
                    }
                } else if (a2 == q.f1938j) {
                    obj = typedArray.getString(i3);
                } else {
                    int i6 = typedValue.type;
                    if (i6 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (a2 == null) {
                            a2 = q.d(charSequence);
                        }
                        obj = a2.h(charSequence);
                    } else if (i6 == 4) {
                        a2 = a(typedValue, a2, q.f1934f, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    } else if (i6 == 5) {
                        a2 = a(typedValue, a2, q.a, string, "dimension");
                        obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i6 == 18) {
                        a2 = a(typedValue, a2, q.f1936h, string, "boolean");
                        obj = Boolean.valueOf(typedValue.data != 0);
                    } else if (i6 >= 16 && i6 <= 31) {
                        a2 = a(typedValue, a2, q.a, string, "integer");
                        obj = Integer.valueOf(typedValue.data);
                    } else {
                        throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                    }
                }
            }
        }
        if (obj != null) {
            aVar.b(obj);
        }
        if (a2 != null) {
            aVar.d(a2);
        }
        return aVar.a();
    }

    private void f(Resources resources, Bundle bundle, AttributeSet attributeSet, int i2) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.w.a.p);
        String string = obtainAttributes.getString(androidx.navigation.w.a.q);
        if (string != null) {
            d e2 = e(obtainAttributes, resources, i2);
            if (e2.c()) {
                e2.e(string, bundle);
            }
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void g(Resources resources, k kVar, AttributeSet attributeSet, int i2) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.w.a.p);
        String string = obtainAttributes.getString(androidx.navigation.w.a.q);
        if (string != null) {
            kVar.h(string, e(obtainAttributes, resources, i2));
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void h(Resources resources, k kVar, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.w.a.u);
        String string = obtainAttributes.getString(androidx.navigation.w.a.x);
        String string2 = obtainAttributes.getString(androidx.navigation.w.a.v);
        String string3 = obtainAttributes.getString(androidx.navigation.w.a.w);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        h.a aVar = new h.a();
        if (string != null) {
            aVar.d(string.replace("${applicationId}", this.f1916b.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            aVar.b(string2.replace("${applicationId}", this.f1916b.getPackageName()));
        }
        if (string3 != null) {
            aVar.c(string3.replace("${applicationId}", this.f1916b.getPackageName()));
        }
        kVar.i(aVar.a());
        obtainAttributes.recycle();
    }

    @SuppressLint({"ResourceType"})
    public l c(int i2) {
        int next;
        Resources resources = this.f1916b.getResources();
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            try {
                try {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i2) + " line " + xml.getLineNumber(), e2);
                }
            } finally {
                xml.close();
            }
        }
        if (next == 2) {
            String name = xml.getName();
            k b2 = b(resources, xml, asAttributeSet, i2);
            if (b2 instanceof l) {
                return (l) b2;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }
}