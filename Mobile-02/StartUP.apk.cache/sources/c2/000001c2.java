package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: KeyFrames.java */
/* loaded from: classes.dex */
public class h {
    static HashMap<String, Constructor<? extends c>> a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, ArrayList<c>> f1121b = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends c>> hashMap = new HashMap<>();
        a = hashMap;
        try {
            hashMap.put("KeyAttribute", d.class.getConstructor(new Class[0]));
            a.put("KeyPosition", i.class.getConstructor(new Class[0]));
            a.put("KeyCycle", f.class.getConstructor(new Class[0]));
            a.put("KeyTimeCycle", k.class.getConstructor(new Class[0]));
            a.put("KeyTrigger", l.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e2) {
            Log.e("KeyFrames", "unable to load", e2);
        }
    }

    public h(Context context, XmlPullParser xmlPullParser) {
        c cVar;
        Exception e2;
        HashMap<String, androidx.constraintlayout.widget.a> hashMap;
        c cVar2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (a.containsKey(name)) {
                        try {
                            cVar = a.get(name).newInstance(new Object[0]);
                            try {
                                cVar.c(context, Xml.asAttributeSet(xmlPullParser));
                                b(cVar);
                            } catch (Exception e3) {
                                e2 = e3;
                                Log.e("KeyFrames", "unable to create ", e2);
                                cVar2 = cVar;
                                continue;
                                eventType = xmlPullParser.next();
                            }
                        } catch (Exception e4) {
                            cVar = cVar2;
                            e2 = e4;
                        }
                        cVar2 = cVar;
                        continue;
                    } else if (name.equalsIgnoreCase("CustomAttribute") && cVar2 != null && (hashMap = cVar2.f1086f) != null) {
                        androidx.constraintlayout.widget.a.g(context, xmlPullParser, hashMap);
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e6) {
            e6.printStackTrace();
        }
    }

    private void b(c cVar) {
        if (!this.f1121b.containsKey(Integer.valueOf(cVar.f1083c))) {
            this.f1121b.put(Integer.valueOf(cVar.f1083c), new ArrayList<>());
        }
        this.f1121b.get(Integer.valueOf(cVar.f1083c)).add(cVar);
    }

    public void a(n nVar) {
        ArrayList<c> arrayList = this.f1121b.get(Integer.valueOf(nVar.f1150b));
        if (arrayList != null) {
            nVar.b(arrayList);
        }
        ArrayList<c> arrayList2 = this.f1121b.get(-1);
        if (arrayList2 != null) {
            Iterator<c> it = arrayList2.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.d(((ConstraintLayout.b) nVar.a.getLayoutParams()).V)) {
                    nVar.a(next);
                }
            }
        }
    }
}