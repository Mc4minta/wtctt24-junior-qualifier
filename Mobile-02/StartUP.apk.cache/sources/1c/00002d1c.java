package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeAnimatedNodesManager.java */
/* loaded from: classes2.dex */
public class l implements com.facebook.react.uimanager.events.e {

    /* renamed from: e  reason: collision with root package name */
    private final UIManagerModule.e f4743e;

    /* renamed from: f  reason: collision with root package name */
    private final UIManagerModule f4744f;
    private final SparseArray<b> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<d> f4740b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<b> f4741c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, List<EventAnimationDriver>> f4742d = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private int f4745g = 0;

    /* renamed from: h  reason: collision with root package name */
    private final List<b> f4746h = new LinkedList();

    /* compiled from: NativeAnimatedNodesManager.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ com.facebook.react.uimanager.events.c a;

        a(com.facebook.react.uimanager.events.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.m(this.a);
        }
    }

    public l(UIManagerModule uIManagerModule) {
        this.f4744f = uIManagerModule;
        uIManagerModule.getEventDispatcher().s(this);
        this.f4743e = uIManagerModule.getDirectEventNamesResolver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.facebook.react.uimanager.events.c cVar) {
        if (this.f4742d.isEmpty()) {
            return;
        }
        String a2 = this.f4743e.a(cVar.f());
        Map<String, List<EventAnimationDriver>> map = this.f4742d;
        List<EventAnimationDriver> list = map.get(cVar.i() + a2);
        if (list != null) {
            for (EventAnimationDriver eventAnimationDriver : list) {
                w(eventAnimationDriver.mValueNode);
                cVar.c(eventAnimationDriver);
                this.f4746h.add(eventAnimationDriver.mValueNode);
            }
            y(this.f4746h);
            this.f4746h.clear();
        }
    }

    private void w(b bVar) {
        int i2 = 0;
        while (i2 < this.f4740b.size()) {
            d valueAt = this.f4740b.valueAt(i2);
            if (bVar.equals(valueAt.f4709b)) {
                if (valueAt.f4710c != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.f4710c.invoke(createMap);
                }
                this.f4740b.removeAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void y(List<b> list) {
        int i2 = this.f4745g + 1;
        this.f4745g = i2;
        if (i2 == 0) {
            this.f4745g = i2 + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = 0;
        for (b bVar : list) {
            int i4 = bVar.f4707c;
            int i5 = this.f4745g;
            if (i4 != i5) {
                bVar.f4707c = i5;
                i3++;
                arrayDeque.add(bVar);
            }
        }
        while (!arrayDeque.isEmpty()) {
            b bVar2 = (b) arrayDeque.poll();
            if (bVar2.a != null) {
                for (int i6 = 0; i6 < bVar2.a.size(); i6++) {
                    b bVar3 = bVar2.a.get(i6);
                    bVar3.f4706b++;
                    int i7 = bVar3.f4707c;
                    int i8 = this.f4745g;
                    if (i7 != i8) {
                        bVar3.f4707c = i8;
                        i3++;
                        arrayDeque.add(bVar3);
                    }
                }
            }
        }
        int i9 = this.f4745g + 1;
        this.f4745g = i9;
        if (i9 == 0) {
            this.f4745g = i9 + 1;
        }
        int i10 = 0;
        for (b bVar4 : list) {
            if (bVar4.f4706b == 0) {
                int i11 = bVar4.f4707c;
                int i12 = this.f4745g;
                if (i11 != i12) {
                    bVar4.f4707c = i12;
                    i10++;
                    arrayDeque.add(bVar4);
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            b bVar5 = (b) arrayDeque.poll();
            bVar5.e();
            if (bVar5 instanceof m) {
                try {
                    ((m) bVar5).i();
                } catch (IllegalViewOperationException e2) {
                    e.f.d.d.a.j("ReactNative", "Native animation workaround, frame lost as result of race condition", e2);
                }
            }
            if (bVar5 instanceof s) {
                ((s) bVar5).j();
            }
            if (bVar5.a != null) {
                for (int i13 = 0; i13 < bVar5.a.size(); i13++) {
                    b bVar6 = bVar5.a.get(i13);
                    int i14 = bVar6.f4706b - 1;
                    bVar6.f4706b = i14;
                    int i15 = bVar6.f4707c;
                    int i16 = this.f4745g;
                    if (i15 != i16 && i14 == 0) {
                        bVar6.f4707c = i16;
                        i10++;
                        arrayDeque.add(bVar6);
                    }
                }
            }
        }
        if (i3 == i10) {
            return;
        }
        throw new IllegalStateException("Looks like animated nodes graph has cycles, there are " + i3 + " but toposort visited only " + i10);
    }

    @Override // com.facebook.react.uimanager.events.e
    public void a(com.facebook.react.uimanager.events.c cVar) {
        if (UiThreadUtil.isOnUiThread()) {
            m(cVar);
        } else {
            UiThreadUtil.runOnUiThread(new a(cVar));
        }
    }

    public void c(int i2, String str, ReadableMap readableMap) {
        int i3 = readableMap.getInt("animatedValueTag");
        b bVar = this.a.get(i3);
        if (bVar != null) {
            if (bVar instanceof s) {
                ReadableArray array = readableMap.getArray("nativeEventPath");
                ArrayList arrayList = new ArrayList(array.size());
                for (int i4 = 0; i4 < array.size(); i4++) {
                    arrayList.add(array.getString(i4));
                }
                EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (s) bVar);
                String str2 = i2 + str;
                if (this.f4742d.containsKey(str2)) {
                    this.f4742d.get(str2).add(eventAnimationDriver);
                    return;
                }
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(eventAnimationDriver);
                this.f4742d.put(str2, arrayList2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + s.class.getName());
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i3 + " does not exists");
    }

    public void d(int i2, int i3) {
        b bVar = this.a.get(i2);
        if (bVar != null) {
            if (bVar instanceof m) {
                ((m) bVar).f(i3);
                this.f4741c.put(i2, bVar);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + m.class.getName());
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
    }

    public void e(int i2, int i3) {
        b bVar = this.a.get(i2);
        if (bVar != null) {
            b bVar2 = this.a.get(i3);
            if (bVar2 != null) {
                bVar.a(bVar2);
                this.f4741c.put(i3, bVar2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i3 + " does not exists");
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
    }

    public void f(int i2, ReadableMap readableMap) {
        b qVar;
        if (this.a.get(i2) == null) {
            String string = readableMap.getString("type");
            if ("style".equals(string)) {
                qVar = new o(readableMap, this);
            } else if ("value".equals(string)) {
                qVar = new s(readableMap);
            } else if ("props".equals(string)) {
                qVar = new m(readableMap, this, this.f4744f);
            } else if ("interpolation".equals(string)) {
                qVar = new i(readableMap);
            } else if ("addition".equals(string)) {
                qVar = new com.facebook.react.animated.a(readableMap, this);
            } else if ("subtraction".equals(string)) {
                qVar = new p(readableMap, this);
            } else if ("division".equals(string)) {
                qVar = new g(readableMap, this);
            } else if ("multiplication".equals(string)) {
                qVar = new k(readableMap, this);
            } else if ("modulus".equals(string)) {
                qVar = new j(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                qVar = new f(readableMap, this);
            } else if ("transform".equals(string)) {
                qVar = new r(readableMap, this);
            } else if ("tracking".equals(string)) {
                qVar = new q(readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            qVar.f4708d = i2;
            this.a.put(i2, qVar);
            this.f4741c.put(i2, qVar);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " already exists");
    }

    public void g(int i2, int i3) {
        b bVar = this.a.get(i2);
        if (bVar != null) {
            if (bVar instanceof m) {
                ((m) bVar).g(i3);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + m.class.getName());
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
    }

    public void h(int i2, int i3) {
        b bVar = this.a.get(i2);
        if (bVar != null) {
            b bVar2 = this.a.get(i3);
            if (bVar2 != null) {
                bVar.d(bVar2);
                this.f4741c.put(i3, bVar2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i3 + " does not exists");
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
    }

    public void i(int i2) {
        this.a.remove(i2);
        this.f4741c.remove(i2);
    }

    public void j(int i2) {
        b bVar = this.a.get(i2);
        if (bVar != null && (bVar instanceof s)) {
            ((s) bVar).f();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists or is not a 'value' node");
    }

    public void k(int i2) {
        b bVar = this.a.get(i2);
        if (bVar != null && (bVar instanceof s)) {
            ((s) bVar).g();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists or is not a 'value' node");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b l(int i2) {
        return this.a.get(i2);
    }

    public boolean n() {
        return this.f4740b.size() > 0 || this.f4741c.size() > 0;
    }

    public void o(int i2, String str, int i3) {
        String str2 = i2 + str;
        if (this.f4742d.containsKey(str2)) {
            List<EventAnimationDriver> list = this.f4742d.get(str2);
            if (list.size() == 1) {
                this.f4742d.remove(i2 + str);
                return;
            }
            ListIterator<EventAnimationDriver> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().mValueNode.f4708d == i3) {
                    listIterator.remove();
                    return;
                }
            }
        }
    }

    public void p(int i2) {
        b bVar = this.a.get(i2);
        if (bVar == null) {
            return;
        }
        if (bVar instanceof m) {
            ((m) bVar).h();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + m.class.getName());
    }

    public void q(long j2) {
        UiThreadUtil.assertOnUiThread();
        for (int i2 = 0; i2 < this.f4741c.size(); i2++) {
            this.f4746h.add(this.f4741c.valueAt(i2));
        }
        this.f4741c.clear();
        boolean z = false;
        for (int i3 = 0; i3 < this.f4740b.size(); i3++) {
            d valueAt = this.f4740b.valueAt(i3);
            valueAt.b(j2);
            this.f4746h.add(valueAt.f4709b);
            if (valueAt.a) {
                z = true;
            }
        }
        y(this.f4746h);
        this.f4746h.clear();
        if (z) {
            for (int size = this.f4740b.size() - 1; size >= 0; size--) {
                d valueAt2 = this.f4740b.valueAt(size);
                if (valueAt2.a) {
                    if (valueAt2.f4710c != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.f4710c.invoke(createMap);
                    }
                    this.f4740b.removeAt(size);
                }
            }
        }
    }

    public void r(int i2, double d2) {
        b bVar = this.a.get(i2);
        if (bVar != null && (bVar instanceof s)) {
            ((s) bVar).f4780g = d2;
            this.f4741c.put(i2, bVar);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists or is not a 'value' node");
    }

    public void s(int i2, double d2) {
        b bVar = this.a.get(i2);
        if (bVar != null && (bVar instanceof s)) {
            w(bVar);
            ((s) bVar).f4779f = d2;
            this.f4741c.put(i2, bVar);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists or is not a 'value' node");
    }

    public void t(int i2, int i3, ReadableMap readableMap, Callback callback) {
        d eVar;
        b bVar = this.a.get(i3);
        if (bVar != null) {
            if (bVar instanceof s) {
                d dVar = this.f4740b.get(i2);
                if (dVar != null) {
                    dVar.a(readableMap);
                    return;
                }
                String string = readableMap.getString("type");
                if ("frames".equals(string)) {
                    eVar = new h(readableMap);
                } else if ("spring".equals(string)) {
                    eVar = new n(readableMap);
                } else if ("decay".equals(string)) {
                    eVar = new e(readableMap);
                } else {
                    throw new JSApplicationIllegalArgumentException("Unsupported animation type: " + string);
                }
                eVar.f4711d = i2;
                eVar.f4710c = callback;
                eVar.f4709b = (s) bVar;
                this.f4740b.put(i2, eVar);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node should be of type " + s.class.getName());
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i3 + " does not exists");
    }

    public void u(int i2, c cVar) {
        b bVar = this.a.get(i2);
        if (bVar != null && (bVar instanceof s)) {
            ((s) bVar).k(cVar);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists or is not a 'value' node");
    }

    public void v(int i2) {
        for (int i3 = 0; i3 < this.f4740b.size(); i3++) {
            d valueAt = this.f4740b.valueAt(i3);
            if (valueAt.f4711d == i2) {
                if (valueAt.f4710c != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.f4710c.invoke(createMap);
                }
                this.f4740b.removeAt(i3);
                return;
            }
        }
    }

    public void x(int i2) {
        b bVar = this.a.get(i2);
        if (bVar != null && (bVar instanceof s)) {
            ((s) bVar).k(null);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists or is not a 'value' node");
    }
}