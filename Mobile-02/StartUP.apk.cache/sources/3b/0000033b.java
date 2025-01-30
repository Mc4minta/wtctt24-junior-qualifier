package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: SavedStateHandle.java */
/* loaded from: classes.dex */
public final class z {
    private static final Class[] a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, Object> f1816b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, b<?>> f1817c;

    /* renamed from: d  reason: collision with root package name */
    private final SavedStateRegistry.b f1818d;

    /* compiled from: SavedStateHandle.java */
    /* loaded from: classes.dex */
    class a implements SavedStateRegistry.b {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            Set<String> keySet = z.this.f1816b.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(z.this.f1816b.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i2 = Build.VERSION.SDK_INT;
        clsArr[27] = i2 >= 21 ? Size.class : cls;
        if (i2 >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        a = clsArr;
    }

    public z(Map<String, Object> map) {
        this.f1817c = new HashMap();
        this.f1818d = new a();
        this.f1816b = new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new z();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new z(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                hashMap.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
            }
            return new z(hashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state");
    }

    private <T> u<T> d(String str, boolean z, T t) {
        b<?> bVar;
        b<?> bVar2 = this.f1817c.get(str);
        if (bVar2 != null) {
            return bVar2;
        }
        if (this.f1816b.containsKey(str)) {
            bVar = new b<>(this, str, this.f1816b.get(str));
        } else if (z) {
            bVar = new b<>(this, str, t);
        } else {
            bVar = new b<>(this, str);
        }
        this.f1817c.put(str, bVar);
        return bVar;
    }

    private static void h(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : a) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    public <T> T b(String str) {
        return (T) this.f1816b.get(str);
    }

    public <T> u<T> c(String str) {
        return d(str, false, null);
    }

    public <T> T e(String str) {
        T t = (T) this.f1816b.remove(str);
        b<?> remove = this.f1817c.remove(str);
        if (remove != null) {
            remove.m();
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateRegistry.b f() {
        return this.f1818d;
    }

    public <T> void g(String str, T t) {
        h(t);
        b<?> bVar = this.f1817c.get(str);
        if (bVar != null) {
            bVar.l(t);
        } else {
            this.f1816b.put(str, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SavedStateHandle.java */
    /* loaded from: classes.dex */
    public static class b<T> extends u<T> {

        /* renamed from: k  reason: collision with root package name */
        private String f1819k;

        /* renamed from: l  reason: collision with root package name */
        private z f1820l;

        b(z zVar, String str, T t) {
            super(t);
            this.f1819k = str;
            this.f1820l = zVar;
        }

        @Override // androidx.lifecycle.u, androidx.lifecycle.LiveData
        public void l(T t) {
            z zVar = this.f1820l;
            if (zVar != null) {
                zVar.f1816b.put(this.f1819k, t);
            }
            super.l(t);
        }

        void m() {
            this.f1820l = null;
        }

        b(z zVar, String str) {
            this.f1819k = str;
            this.f1820l = zVar;
        }
    }

    public z() {
        this.f1817c = new HashMap();
        this.f1818d = new a();
        this.f1816b = new HashMap();
    }
}