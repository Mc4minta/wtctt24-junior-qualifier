package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.navigation.k;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: FragmentNavigator.java */
@s.b("fragment")
/* loaded from: classes.dex */
public class b extends s<a> {
    private static final String KEY_BACK_STACK_IDS = "androidx-nav-fragment:navigator:backStackIds";
    private static final String TAG = "FragmentNavigator";
    private ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    private final int mContainerId;
    private final Context mContext;
    private final m mFragmentManager;

    /* compiled from: FragmentNavigator.java */
    /* loaded from: classes.dex */
    public static class a extends k {

        /* renamed from: k  reason: collision with root package name */
        private String f1868k;

        public a(s<? extends a> sVar) {
            super(sVar);
        }

        public final String E() {
            String str = this.f1868k;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        public final a F(String str) {
            this.f1868k = str;
            return this;
        }

        @Override // androidx.navigation.k
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f1868k;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            return sb.toString();
        }

        @Override // androidx.navigation.k
        public void x(Context context, AttributeSet attributeSet) {
            super.x(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, f.f1876i);
            String string = obtainAttributes.getString(f.f1877j);
            if (string != null) {
                F(string);
            }
            obtainAttributes.recycle();
        }
    }

    /* compiled from: FragmentNavigator.java */
    /* renamed from: androidx.navigation.fragment.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0036b implements s.a {
        private final LinkedHashMap<View, String> a;

        /* compiled from: FragmentNavigator.java */
        /* renamed from: androidx.navigation.fragment.b$b$a */
        /* loaded from: classes.dex */
        public static final class a {
            private final LinkedHashMap<View, String> a = new LinkedHashMap<>();

            public a a(View view, String str) {
                this.a.put(view, str);
                return this;
            }

            public C0036b b() {
                return new C0036b(this.a);
            }
        }

        C0036b(Map<View, String> map) {
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this.a = linkedHashMap;
            linkedHashMap.putAll(map);
        }

        public Map<View, String> a() {
            return Collections.unmodifiableMap(this.a);
        }
    }

    public b(Context context, m mVar, int i2) {
        this.mContext = context;
        this.mFragmentManager = mVar;
        this.mContainerId = i2;
    }

    private String generateBackStackName(int i2, int i3) {
        return i2 + "-" + i3;
    }

    @Deprecated
    public Fragment instantiateFragment(Context context, m mVar, String str, Bundle bundle) {
        return mVar.g0().a(context.getClassLoader(), str);
    }

    @Override // androidx.navigation.s
    public void onRestoreState(Bundle bundle) {
        int[] intArray;
        if (bundle == null || (intArray = bundle.getIntArray(KEY_BACK_STACK_IDS)) == null) {
            return;
        }
        this.mBackStack.clear();
        for (int i2 : intArray) {
            this.mBackStack.add(Integer.valueOf(i2));
        }
    }

    @Override // androidx.navigation.s
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.mBackStack.size()];
        Iterator<Integer> it = this.mBackStack.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        bundle.putIntArray(KEY_BACK_STACK_IDS, iArr);
        return bundle;
    }

    @Override // androidx.navigation.s
    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        if (this.mFragmentManager.v0()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.mFragmentManager.H0(generateBackStackName(this.mBackStack.size(), this.mBackStack.peekLast().intValue()), 1);
        this.mBackStack.removeLast();
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.s
    public a createDestination() {
        return new a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0134 A[RETURN] */
    @Override // androidx.navigation.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.navigation.k navigate(androidx.navigation.fragment.b.a r9, android.os.Bundle r10, androidx.navigation.p r11, androidx.navigation.s.a r12) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.b.navigate(androidx.navigation.fragment.b$a, android.os.Bundle, androidx.navigation.p, androidx.navigation.s$a):androidx.navigation.k");
    }
}