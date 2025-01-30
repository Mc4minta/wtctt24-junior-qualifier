package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: MotionScene.java */
/* loaded from: classes.dex */
public class r {
    private final MotionLayout a;
    private MotionEvent n;
    private MotionLayout.f p;
    private boolean q;
    float r;
    float s;

    /* renamed from: b  reason: collision with root package name */
    androidx.constraintlayout.widget.j f1174b = null;

    /* renamed from: c  reason: collision with root package name */
    b f1175c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1176d = false;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<b> f1177e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private b f1178f = null;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<b> f1179g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private SparseArray<androidx.constraintlayout.widget.d> f1180h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, Integer> f1181i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private SparseIntArray f1182j = new SparseIntArray();

    /* renamed from: k  reason: collision with root package name */
    private boolean f1183k = false;

    /* renamed from: l  reason: collision with root package name */
    private int f1184l = HttpStatus.SC_BAD_REQUEST;
    private int m = 0;
    private boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MotionScene.java */
    /* loaded from: classes.dex */
    public class a implements Interpolator {
        final /* synthetic */ c.f.a.a.c a;

        a(c.f.a.a.c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) this.a.a(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context, MotionLayout motionLayout, int i2) {
        this.a = motionLayout;
        D(context, i2);
        SparseArray<androidx.constraintlayout.widget.d> sparseArray = this.f1180h;
        int i3 = androidx.constraintlayout.widget.h.a;
        sparseArray.put(i3, new androidx.constraintlayout.widget.d());
        this.f1181i.put("motion_base", Integer.valueOf(i3));
    }

    private boolean B(int i2) {
        int i3 = this.f1182j.get(i2);
        int size = this.f1182j.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.f1182j.get(i3);
            size = i4;
        }
        return false;
    }

    private boolean C() {
        return this.p != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void D(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        b bVar = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c2 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    if (this.f1183k) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 793277014:
                            if (name.equals("MotionScene")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            H(context, xml);
                            continue;
                        case 1:
                            ArrayList<b> arrayList = this.f1177e;
                            b bVar2 = new b(this, context, xml);
                            arrayList.add(bVar2);
                            if (this.f1175c == null && !bVar2.f1186b) {
                                this.f1175c = bVar2;
                                if (bVar2.f1196l != null) {
                                    this.f1175c.f1196l.p(this.q);
                                }
                            }
                            if (bVar2.f1186b) {
                                if (bVar2.f1187c == -1) {
                                    this.f1178f = bVar2;
                                } else {
                                    this.f1179g.add(bVar2);
                                }
                                this.f1177e.remove(bVar2);
                            }
                            bVar = bVar2;
                            continue;
                        case 2:
                            if (bVar == null) {
                                Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i2) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            bVar.f1196l = new u(context, this.a, xml);
                            continue;
                        case 3:
                            bVar.t(context, xml);
                            continue;
                        case 4:
                            this.f1174b = new androidx.constraintlayout.widget.j(context, xml);
                            continue;
                        case 5:
                            G(context, xml);
                            continue;
                        case 6:
                            bVar.f1195k.add(new h(context, xml));
                            continue;
                        default:
                            Log.v("MotionScene", "WARNING UNKNOWN ATTRIBUTE " + name);
                            continue;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void G(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.D(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            String attributeName = xmlPullParser.getAttributeName(i4);
            String attributeValue = xmlPullParser.getAttributeValue(i4);
            if (this.f1183k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                i3 = p(context, attributeValue);
            } else if (attributeName.equals("id")) {
                i2 = p(context, attributeValue);
                this.f1181i.put(T(attributeValue), Integer.valueOf(i2));
            }
        }
        if (i2 != -1) {
            if (this.a.mDebugPath != 0) {
                dVar.E(true);
            }
            dVar.y(context, xmlPullParser);
            if (i3 != -1) {
                this.f1182j.put(i2, i3);
            }
            this.f1180h.put(i2, dVar);
        }
    }

    private void H(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.i.y6);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == androidx.constraintlayout.widget.i.z6) {
                this.f1184l = obtainStyledAttributes.getInt(index, this.f1184l);
            } else if (index == androidx.constraintlayout.widget.i.A6) {
                this.m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void L(int i2) {
        int i3 = this.f1182j.get(i2);
        if (i3 > 0) {
            L(this.f1182j.get(i2));
            androidx.constraintlayout.widget.d dVar = this.f1180h.get(i2);
            androidx.constraintlayout.widget.d dVar2 = this.f1180h.get(i3);
            if (dVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + androidx.constraintlayout.motion.widget.a.b(this.a.getContext(), i3));
                return;
            }
            dVar.C(dVar2);
            this.f1182j.put(i2, -1);
        }
    }

    public static String T(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    private int p(Context context, String str) {
        int i2;
        if (str.contains("/")) {
            i2 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f1183k) {
                System.out.println("id getMap res = " + i2);
            }
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
            return i2;
        }
        return i2;
    }

    private int w(int i2) {
        int c2;
        androidx.constraintlayout.widget.j jVar = this.f1174b;
        return (jVar == null || (c2 = jVar.c(i2, -1, -1)) == -1) ? i2 : c2;
    }

    public List<b> A(int i2) {
        int w = w(i2);
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = this.f1177e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1188d == w || next.f1187c == w) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int E(String str) {
        return this.f1181i.get(str).intValue();
    }

    public String F(int i2) {
        for (Map.Entry<String, Integer> entry : this.f1181i.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(float f2, float f3) {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return;
        }
        this.f1175c.f1196l.m(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(float f2, float f3) {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return;
        }
        this.f1175c.f1196l.n(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.f fVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.p == null) {
            this.p = this.a.obtainVelocityTracker();
        }
        this.p.a(motionEvent);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
                this.n = motionEvent;
                if (this.f1175c.f1196l != null) {
                    RectF e2 = this.f1175c.f1196l.e(this.a, rectF);
                    if (e2 == null || e2.contains(this.n.getX(), this.n.getY())) {
                        RectF j2 = this.f1175c.f1196l.j(this.a, rectF);
                        if (j2 != null && !j2.contains(this.n.getX(), this.n.getY())) {
                            this.o = true;
                        } else {
                            this.o = false;
                        }
                        this.f1175c.f1196l.o(this.r, this.s);
                        return;
                    }
                    this.n = null;
                    return;
                }
                return;
            } else if (action == 2) {
                float rawY = motionEvent.getRawY() - this.s;
                float rawX = motionEvent.getRawX() - this.r;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.n) == null) {
                    return;
                }
                b g2 = g(i2, rawX, rawY, motionEvent2);
                if (g2 != null) {
                    motionLayout.setTransition(g2);
                    RectF j3 = this.f1175c.f1196l.j(this.a, rectF);
                    if (j3 != null && !j3.contains(this.n.getX(), this.n.getY())) {
                        z = true;
                    }
                    this.o = z;
                    this.f1175c.f1196l.q(this.r, this.s);
                }
            }
        }
        b bVar = this.f1175c;
        if (bVar != null && bVar.f1196l != null && !this.o) {
            this.f1175c.f1196l.l(motionEvent, this.p, i2, this);
        }
        this.r = motionEvent.getRawX();
        this.s = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (fVar = this.p) == null) {
            return;
        }
        fVar.recycle();
        this.p = null;
        int i3 = motionLayout.mCurrentState;
        if (i3 != -1) {
            f(motionLayout, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(MotionLayout motionLayout) {
        for (int i2 = 0; i2 < this.f1180h.size(); i2++) {
            int keyAt = this.f1180h.keyAt(i2);
            if (B(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            L(keyAt);
        }
        for (int i3 = 0; i3 < this.f1180h.size(); i3++) {
            this.f1180h.valueAt(i3).B(motionLayout);
        }
    }

    public void N(int i2, androidx.constraintlayout.widget.d dVar) {
        this.f1180h.put(i2, dVar);
    }

    public void O(int i2) {
        b bVar = this.f1175c;
        if (bVar != null) {
            bVar.E(i2);
        } else {
            this.f1184l = i2;
        }
    }

    public void P(boolean z) {
        this.q = z;
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return;
        }
        this.f1175c.f1196l.p(this.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r2 != (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Q(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.j r0 = r6.f1174b
            r1 = -1
            if (r0 == 0) goto L16
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.j r2 = r6.f1174b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L17
            goto L18
        L16:
            r0 = r7
        L17:
            r2 = r8
        L18:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.r$b> r3 = r6.f1177e
            java.util.Iterator r3 = r3.iterator()
        L1e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L58
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.r$b r4 = (androidx.constraintlayout.motion.widget.r.b) r4
            int r5 = androidx.constraintlayout.motion.widget.r.b.a(r4)
            if (r5 != r2) goto L36
            int r5 = androidx.constraintlayout.motion.widget.r.b.c(r4)
            if (r5 == r0) goto L42
        L36:
            int r5 = androidx.constraintlayout.motion.widget.r.b.a(r4)
            if (r5 != r8) goto L1e
            int r5 = androidx.constraintlayout.motion.widget.r.b.c(r4)
            if (r5 != r7) goto L1e
        L42:
            r6.f1175c = r4
            if (r4 == 0) goto L57
            androidx.constraintlayout.motion.widget.u r7 = androidx.constraintlayout.motion.widget.r.b.m(r4)
            if (r7 == 0) goto L57
            androidx.constraintlayout.motion.widget.r$b r7 = r6.f1175c
            androidx.constraintlayout.motion.widget.u r7 = androidx.constraintlayout.motion.widget.r.b.m(r7)
            boolean r8 = r6.q
            r7.p(r8)
        L57:
            return
        L58:
            androidx.constraintlayout.motion.widget.r$b r7 = r6.f1178f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.r$b> r3 = r6.f1179g
            java.util.Iterator r3 = r3.iterator()
        L60:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L74
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.r$b r4 = (androidx.constraintlayout.motion.widget.r.b) r4
            int r5 = androidx.constraintlayout.motion.widget.r.b.a(r4)
            if (r5 != r8) goto L60
            r7 = r4
            goto L60
        L74:
            androidx.constraintlayout.motion.widget.r$b r8 = new androidx.constraintlayout.motion.widget.r$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.r.b.d(r8, r0)
            androidx.constraintlayout.motion.widget.r.b.b(r8, r2)
            if (r0 == r1) goto L86
            java.util.ArrayList<androidx.constraintlayout.motion.widget.r$b> r7 = r6.f1177e
            r7.add(r8)
        L86:
            r6.f1175c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.r.Q(int, int):void");
    }

    public void R(b bVar) {
        this.f1175c = bVar;
        if (bVar == null || bVar.f1196l == null) {
            return;
        }
        this.f1175c.f1196l.p(this.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return;
        }
        this.f1175c.f1196l.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean U() {
        Iterator<b> it = this.f1177e.iterator();
        while (it.hasNext()) {
            if (it.next().f1196l != null) {
                return true;
            }
        }
        b bVar = this.f1175c;
        return (bVar == null || bVar.f1196l == null) ? false : true;
    }

    public void e(MotionLayout motionLayout, int i2) {
        Iterator<b> it = this.f1177e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.m.size() > 0) {
                Iterator it2 = next.m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it3 = this.f1179g.iterator();
        while (it3.hasNext()) {
            b next2 = it3.next();
            if (next2.m.size() > 0) {
                Iterator it4 = next2.m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it5 = this.f1177e.iterator();
        while (it5.hasNext()) {
            b next3 = it5.next();
            if (next3.m.size() > 0) {
                Iterator it6 = next3.m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).a(motionLayout, i2, next3);
                }
            }
        }
        Iterator<b> it7 = this.f1179g.iterator();
        while (it7.hasNext()) {
            b next4 = it7.next();
            if (next4.m.size() > 0) {
                Iterator it8 = next4.m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).a(motionLayout, i2, next4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(MotionLayout motionLayout, int i2) {
        if (C() || this.f1176d) {
            return false;
        }
        Iterator<b> it = this.f1177e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.n != 0) {
                if (i2 != next.f1188d || (next.n != 4 && next.n != 2)) {
                    if (i2 == next.f1187c && (next.n == 3 || next.n == 1)) {
                        MotionLayout.j jVar = MotionLayout.j.FINISHED;
                        motionLayout.setState(jVar);
                        motionLayout.setTransition(next);
                        if (next.n == 3) {
                            motionLayout.transitionToStart();
                            motionLayout.setState(MotionLayout.j.SETUP);
                            motionLayout.setState(MotionLayout.j.MOVING);
                        } else {
                            motionLayout.setProgress(0.0f);
                            motionLayout.evaluate(true);
                            motionLayout.setState(MotionLayout.j.SETUP);
                            motionLayout.setState(MotionLayout.j.MOVING);
                            motionLayout.setState(jVar);
                        }
                        return true;
                    }
                } else {
                    MotionLayout.j jVar2 = MotionLayout.j.FINISHED;
                    motionLayout.setState(jVar2);
                    motionLayout.setTransition(next);
                    if (next.n == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.j.SETUP);
                        motionLayout.setState(MotionLayout.j.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.j.SETUP);
                        motionLayout.setState(MotionLayout.j.MOVING);
                        motionLayout.setState(jVar2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b g(int i2, float f2, float f3, MotionEvent motionEvent) {
        if (i2 != -1) {
            List<b> A = A(i2);
            float f4 = 0.0f;
            b bVar = null;
            RectF rectF = new RectF();
            for (b bVar2 : A) {
                if (!bVar2.o && bVar2.f1196l != null) {
                    bVar2.f1196l.p(this.q);
                    RectF j2 = bVar2.f1196l.j(this.a, rectF);
                    if (j2 == null || motionEvent == null || j2.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF j3 = bVar2.f1196l.j(this.a, rectF);
                        if (j3 == null || motionEvent == null || j3.contains(motionEvent.getX(), motionEvent.getY())) {
                            float a2 = bVar2.f1196l.a(f2, f3) * (bVar2.f1187c == i2 ? -1.0f : 1.1f);
                            if (a2 > f4) {
                                bVar = bVar2;
                                f4 = a2;
                            }
                        }
                    }
                }
            }
            return bVar;
        }
        return this.f1175c;
    }

    public void h(boolean z) {
        this.f1176d = z;
    }

    public int i() {
        b bVar = this.f1175c;
        if (bVar != null) {
            return bVar.p;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.constraintlayout.widget.d j(int i2) {
        return k(i2, -1, -1);
    }

    androidx.constraintlayout.widget.d k(int i2, int i3, int i4) {
        int c2;
        if (this.f1183k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i2);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.f1180h.size());
        }
        androidx.constraintlayout.widget.j jVar = this.f1174b;
        if (jVar != null && (c2 = jVar.c(i2, i3, i4)) != -1) {
            i2 = c2;
        }
        if (this.f1180h.get(i2) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + androidx.constraintlayout.motion.widget.a.b(this.a.getContext(), i2) + " In MotionScene");
            SparseArray<androidx.constraintlayout.widget.d> sparseArray = this.f1180h;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.f1180h.get(i2);
    }

    public int[] l() {
        int size = this.f1180h.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.f1180h.keyAt(i2);
        }
        return iArr;
    }

    public ArrayList<b> m() {
        return this.f1177e;
    }

    public int n() {
        b bVar = this.f1175c;
        if (bVar != null) {
            return bVar.f1192h;
        }
        return this.f1184l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        b bVar = this.f1175c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f1187c;
    }

    public Interpolator q() {
        int i2 = this.f1175c.f1189e;
        if (i2 != -2) {
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return null;
                                }
                                return new BounceInterpolator();
                            }
                            return new AnticipateInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new a(c.f.a.a.c.c(this.f1175c.f1190f));
        }
        return AnimationUtils.loadInterpolator(this.a.getContext(), this.f1175c.f1191g);
    }

    public void r(n nVar) {
        b bVar = this.f1175c;
        if (bVar != null) {
            Iterator it = bVar.f1195k.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(nVar);
            }
            return;
        }
        b bVar2 = this.f1178f;
        if (bVar2 != null) {
            Iterator it2 = bVar2.f1195k.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).a(nVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return 0.0f;
        }
        return this.f1175c.f1196l.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return 0.0f;
        }
        return this.f1175c.f1196l.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return false;
        }
        return this.f1175c.f1196l.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float v(float f2, float f3) {
        b bVar = this.f1175c;
        if (bVar == null || bVar.f1196l == null) {
            return 0.0f;
        }
        return this.f1175c.f1196l.i(f2, f3);
    }

    public float x() {
        b bVar = this.f1175c;
        if (bVar != null) {
            return bVar.f1193i;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        b bVar = this.f1175c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f1188d;
    }

    public b z(int i2) {
        Iterator<b> it = this.f1177e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.a == i2) {
                return next;
            }
        }
        return null;
    }

    /* compiled from: MotionScene.java */
    /* loaded from: classes.dex */
    public static class b {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1186b;

        /* renamed from: c  reason: collision with root package name */
        private int f1187c;

        /* renamed from: d  reason: collision with root package name */
        private int f1188d;

        /* renamed from: e  reason: collision with root package name */
        private int f1189e;

        /* renamed from: f  reason: collision with root package name */
        private String f1190f;

        /* renamed from: g  reason: collision with root package name */
        private int f1191g;

        /* renamed from: h  reason: collision with root package name */
        private int f1192h;

        /* renamed from: i  reason: collision with root package name */
        private float f1193i;

        /* renamed from: j  reason: collision with root package name */
        private final r f1194j;

        /* renamed from: k  reason: collision with root package name */
        private ArrayList<h> f1195k;

        /* renamed from: l  reason: collision with root package name */
        private u f1196l;
        private ArrayList<a> m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MotionScene.java */
        /* loaded from: classes.dex */
        public static class a implements View.OnClickListener {
            private final b a;

            /* renamed from: b  reason: collision with root package name */
            int f1197b;

            /* renamed from: c  reason: collision with root package name */
            int f1198c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f1197b = -1;
                this.f1198c = 17;
                this.a = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.constraintlayout.widget.i.C6);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == androidx.constraintlayout.widget.i.E6) {
                        this.f1197b = obtainStyledAttributes.getResourceId(index, this.f1197b);
                    } else if (index == androidx.constraintlayout.widget.i.D6) {
                        this.f1198c = obtainStyledAttributes.getInt(index, this.f1198c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void a(MotionLayout motionLayout, int i2, b bVar) {
                int i3 = this.f1197b;
                MotionLayout motionLayout2 = motionLayout;
                if (i3 != -1) {
                    motionLayout2 = motionLayout.findViewById(i3);
                }
                if (motionLayout2 != null) {
                    int i4 = bVar.f1188d;
                    int i5 = bVar.f1187c;
                    if (i4 == -1) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    int i6 = this.f1198c;
                    boolean z = false;
                    boolean z2 = ((i6 & 1) != 0 && i2 == i4) | ((i6 & 1) != 0 && i2 == i4) | ((i6 & 256) != 0 && i2 == i4) | ((i6 & 16) != 0 && i2 == i5);
                    if ((i6 & 4096) != 0 && i2 == i5) {
                        z = true;
                    }
                    if (z2 || z) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                Log.e("MotionScene", "OnClick could not find id " + this.f1197b);
            }

            boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i2 = bVar2.f1187c;
                int i3 = this.a.f1188d;
                if (i3 == -1) {
                    return motionLayout.mCurrentState != i2;
                }
                int i4 = motionLayout.mCurrentState;
                return i4 == i3 || i4 == i2;
            }

            public void c(MotionLayout motionLayout) {
                int i2 = this.f1197b;
                if (i2 == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i2);
                if (findViewById == null) {
                    Log.e("MotionScene", " (*)  could not find id " + this.f1197b);
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
            /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r8) {
                /*
                    Method dump skipped, instructions count: 233
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.r.b.a.onClick(android.view.View):void");
            }
        }

        b(r rVar, b bVar) {
            this.a = -1;
            this.f1186b = false;
            this.f1187c = -1;
            this.f1188d = -1;
            this.f1189e = 0;
            this.f1190f = null;
            this.f1191g = -1;
            this.f1192h = HttpStatus.SC_BAD_REQUEST;
            this.f1193i = 0.0f;
            this.f1195k = new ArrayList<>();
            this.f1196l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f1194j = rVar;
            if (bVar != null) {
                this.p = bVar.p;
                this.f1189e = bVar.f1189e;
                this.f1190f = bVar.f1190f;
                this.f1191g = bVar.f1191g;
                this.f1192h = bVar.f1192h;
                this.f1195k = bVar.f1195k;
                this.f1193i = bVar.f1193i;
                this.q = bVar.q;
            }
        }

        private void v(r rVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                if (index == androidx.constraintlayout.widget.i.B7) {
                    this.f1187c = typedArray.getResourceId(index, this.f1187c);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f1187c))) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        dVar.x(context, this.f1187c);
                        rVar.f1180h.append(this.f1187c, dVar);
                    }
                } else if (index == androidx.constraintlayout.widget.i.C7) {
                    this.f1188d = typedArray.getResourceId(index, this.f1188d);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f1188d))) {
                        androidx.constraintlayout.widget.d dVar2 = new androidx.constraintlayout.widget.d();
                        dVar2.x(context, this.f1188d);
                        rVar.f1180h.append(this.f1188d, dVar2);
                    }
                } else if (index == androidx.constraintlayout.widget.i.F7) {
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f1191g = resourceId;
                        if (resourceId != -1) {
                            this.f1189e = -2;
                        }
                    } else if (i3 == 3) {
                        String string = typedArray.getString(index);
                        this.f1190f = string;
                        if (string.indexOf("/") > 0) {
                            this.f1191g = typedArray.getResourceId(index, -1);
                            this.f1189e = -2;
                        } else {
                            this.f1189e = -1;
                        }
                    } else {
                        this.f1189e = typedArray.getInteger(index, this.f1189e);
                    }
                } else if (index == androidx.constraintlayout.widget.i.D7) {
                    this.f1192h = typedArray.getInt(index, this.f1192h);
                } else if (index == androidx.constraintlayout.widget.i.H7) {
                    this.f1193i = typedArray.getFloat(index, this.f1193i);
                } else if (index == androidx.constraintlayout.widget.i.A7) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == androidx.constraintlayout.widget.i.z7) {
                    this.a = typedArray.getResourceId(index, this.a);
                } else if (index == androidx.constraintlayout.widget.i.I7) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == androidx.constraintlayout.widget.i.G7) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == androidx.constraintlayout.widget.i.E7) {
                    this.q = typedArray.getInteger(index, 0);
                } else if (index == androidx.constraintlayout.widget.i.J7) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f1188d == -1) {
                this.f1186b = true;
            }
        }

        private void w(r rVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.y7);
            v(rVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f1188d;
        }

        public u B() {
            return this.f1196l;
        }

        public boolean C() {
            return !this.o;
        }

        public boolean D(int i2) {
            return (i2 & this.r) != 0;
        }

        public void E(int i2) {
            this.f1192h = i2;
        }

        public void F(boolean z) {
            this.o = !z;
        }

        public void t(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new a(context, this, xmlPullParser));
        }

        public String u(Context context) {
            String resourceEntryName = this.f1188d == -1 ? "null" : context.getResources().getResourceEntryName(this.f1188d);
            if (this.f1187c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f1187c);
        }

        public int x() {
            return this.f1192h;
        }

        public int y() {
            return this.f1187c;
        }

        public int z() {
            return this.q;
        }

        b(r rVar, Context context, XmlPullParser xmlPullParser) {
            this.a = -1;
            this.f1186b = false;
            this.f1187c = -1;
            this.f1188d = -1;
            this.f1189e = 0;
            this.f1190f = null;
            this.f1191g = -1;
            this.f1192h = HttpStatus.SC_BAD_REQUEST;
            this.f1193i = 0.0f;
            this.f1195k = new ArrayList<>();
            this.f1196l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f1192h = rVar.f1184l;
            this.q = rVar.m;
            this.f1194j = rVar;
            w(rVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}