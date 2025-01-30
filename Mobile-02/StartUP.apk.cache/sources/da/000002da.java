package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.g0;
import androidx.lifecycle.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
public class s {
    private final l a;

    /* renamed from: b  reason: collision with root package name */
    private final Fragment f1674b;

    /* renamed from: c  reason: collision with root package name */
    private int f1675c = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.b.values().length];
            a = iArr;
            try {
                iArr[i.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar, Fragment fragment) {
        this.a = lVar;
        this.f1674b = fragment;
    }

    private Bundle n() {
        Bundle bundle = new Bundle();
        this.f1674b.performSaveInstanceState(bundle);
        this.a.j(this.f1674b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f1674b.mView != null) {
            p();
        }
        if (this.f1674b.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f1674b.mSavedViewState);
        }
        if (!this.f1674b.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f1674b.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1674b);
        }
        Fragment fragment = this.f1674b;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        l lVar = this.a;
        Fragment fragment2 = this.f1674b;
        lVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j<?> jVar, m mVar, Fragment fragment) {
        Fragment fragment2 = this.f1674b;
        fragment2.mHost = jVar;
        fragment2.mParentFragment = fragment;
        fragment2.mFragmentManager = mVar;
        this.a.g(fragment2, jVar.e(), false);
        this.f1674b.performAttach();
        Fragment fragment3 = this.f1674b;
        Fragment fragment4 = fragment3.mParentFragment;
        if (fragment4 == null) {
            jVar.g(fragment3);
        } else {
            fragment4.onAttachFragment(fragment3);
        }
        this.a.b(this.f1674b, jVar.e(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i2 = this.f1675c;
        Fragment fragment = this.f1674b;
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                i2 = Math.max(i2, 1);
            } else if (i2 < 2) {
                i2 = Math.min(i2, fragment.mState);
            } else {
                i2 = Math.min(i2, 1);
            }
        }
        if (!this.f1674b.mAdded) {
            i2 = Math.min(i2, 1);
        }
        Fragment fragment2 = this.f1674b;
        if (fragment2.mRemoving) {
            if (fragment2.isInBackStack()) {
                i2 = Math.min(i2, 1);
            } else {
                i2 = Math.min(i2, -1);
            }
        }
        Fragment fragment3 = this.f1674b;
        if (fragment3.mDeferStart && fragment3.mState < 3) {
            i2 = Math.min(i2, 2);
        }
        int i3 = a.a[this.f1674b.mMaxState.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return Math.min(i2, -1);
                }
                return Math.min(i2, 1);
            }
            return Math.min(i2, 3);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1674b);
        }
        Fragment fragment = this.f1674b;
        if (!fragment.mIsCreated) {
            this.a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f1674b;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            l lVar = this.a;
            Fragment fragment3 = this.f1674b;
            lVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f1674b.mState = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(f fVar) {
        String str;
        if (this.f1674b.mFromLayout) {
            return;
        }
        if (m.r0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1674b);
        }
        ViewGroup viewGroup = null;
        Fragment fragment = this.f1674b;
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment.mContainerId;
            if (i2 != 0) {
                if (i2 != -1) {
                    viewGroup = (ViewGroup) fVar.b(i2);
                    if (viewGroup == null) {
                        Fragment fragment2 = this.f1674b;
                        if (!fragment2.mRestored) {
                            try {
                                str = fragment2.getResources().getResourceName(this.f1674b.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1674b.mContainerId) + " (" + str + ") for fragment " + this.f1674b);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1674b + " for a container view with no id");
                }
            }
        }
        Fragment fragment3 = this.f1674b;
        fragment3.mContainer = viewGroup;
        fragment3.performCreateView(fragment3.performGetLayoutInflater(fragment3.mSavedFragmentState), viewGroup, this.f1674b.mSavedFragmentState);
        View view = this.f1674b.mView;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f1674b;
            fragment4.mView.setTag(c.l.b.a, fragment4);
            if (viewGroup != null) {
                viewGroup.addView(this.f1674b.mView);
            }
            Fragment fragment5 = this.f1674b;
            if (fragment5.mHidden) {
                fragment5.mView.setVisibility(8);
            }
            c.h.k.v.h0(this.f1674b.mView);
            Fragment fragment6 = this.f1674b;
            fragment6.onViewCreated(fragment6.mView, fragment6.mSavedFragmentState);
            l lVar = this.a;
            Fragment fragment7 = this.f1674b;
            lVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            Fragment fragment8 = this.f1674b;
            if (fragment8.mView.getVisibility() == 0 && this.f1674b.mContainer != null) {
                z = true;
            }
            fragment8.mIsNewlyAdded = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(j<?> jVar, p pVar) {
        if (m.r0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1674b);
        }
        Fragment fragment = this.f1674b;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2 || pVar.j(this.f1674b)) {
            if (jVar instanceof g0) {
                z = pVar.h();
            } else if (jVar.e() instanceof Activity) {
                z = true ^ ((Activity) jVar.e()).isChangingConfigurations();
            }
            if (z2 || z) {
                pVar.b(this.f1674b);
            }
            this.f1674b.performDestroy();
            this.a.d(this.f1674b, false);
            return;
        }
        this.f1674b.mState = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(p pVar) {
        if (m.r0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1674b);
        }
        this.f1674b.performDetach();
        boolean z = false;
        this.a.e(this.f1674b, false);
        Fragment fragment = this.f1674b;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || pVar.j(this.f1674b)) {
            if (m.r0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f1674b);
            }
            this.f1674b.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Fragment fragment = this.f1674b;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (m.r0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1674b);
            }
            Fragment fragment2 = this.f1674b;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f1674b.mSavedFragmentState);
            View view = this.f1674b.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1674b;
                fragment3.mView.setTag(c.l.b.a, fragment3);
                Fragment fragment4 = this.f1674b;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                Fragment fragment5 = this.f1674b;
                fragment5.onViewCreated(fragment5.mView, fragment5.mSavedFragmentState);
                l lVar = this.a;
                Fragment fragment6 = this.f1674b;
                lVar.m(fragment6, fragment6.mView, fragment6.mSavedFragmentState, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i() {
        return this.f1674b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1674b);
        }
        this.f1674b.performPause();
        this.a.f(this.f1674b, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ClassLoader classLoader) {
        Bundle bundle = this.f1674b.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f1674b;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f1674b;
        fragment2.mTargetWho = fragment2.mSavedFragmentState.getString("android:target_state");
        Fragment fragment3 = this.f1674b;
        if (fragment3.mTargetWho != null) {
            fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment4 = this.f1674b;
        Boolean bool = fragment4.mSavedUserVisibleHint;
        if (bool != null) {
            fragment4.mUserVisibleHint = bool.booleanValue();
            this.f1674b.mSavedUserVisibleHint = null;
        } else {
            fragment4.mUserVisibleHint = fragment4.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment5 = this.f1674b;
        if (fragment5.mUserVisibleHint) {
            return;
        }
        fragment5.mDeferStart = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.f1674b);
        }
        Fragment fragment = this.f1674b;
        if (fragment.mView != null) {
            fragment.restoreViewState(fragment.mSavedFragmentState);
        }
        this.f1674b.mSavedFragmentState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1674b);
        }
        this.f1674b.performResume();
        this.a.i(this.f1674b, false);
        Fragment fragment = this.f1674b;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r o() {
        r rVar = new r(this.f1674b);
        Fragment fragment = this.f1674b;
        if (fragment.mState > -1 && rVar.n == null) {
            Bundle n = n();
            rVar.n = n;
            if (this.f1674b.mTargetWho != null) {
                if (n == null) {
                    rVar.n = new Bundle();
                }
                rVar.n.putString("android:target_state", this.f1674b.mTargetWho);
                int i2 = this.f1674b.mTargetRequestCode;
                if (i2 != 0) {
                    rVar.n.putInt("android:target_req_state", i2);
                }
            }
        } else {
            rVar.n = fragment.mSavedFragmentState;
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (this.f1674b.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1674b.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1674b.mSavedViewState = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i2) {
        this.f1675c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1674b);
        }
        this.f1674b.performStart();
        this.a.k(this.f1674b, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        if (m.r0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1674b);
        }
        this.f1674b.performStop();
        this.a.l(this.f1674b, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar, ClassLoader classLoader, i iVar, r rVar) {
        this.a = lVar;
        Fragment a2 = iVar.a(classLoader, rVar.a);
        this.f1674b = a2;
        Bundle bundle = rVar.f1672k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.setArguments(rVar.f1672k);
        a2.mWho = rVar.f1664b;
        a2.mFromLayout = rVar.f1665c;
        a2.mRestored = true;
        a2.mFragmentId = rVar.f1666d;
        a2.mContainerId = rVar.f1667e;
        a2.mTag = rVar.f1668f;
        a2.mRetainInstance = rVar.f1669g;
        a2.mRemoving = rVar.f1670h;
        a2.mDetached = rVar.f1671j;
        a2.mHidden = rVar.f1673l;
        a2.mMaxState = i.b.values()[rVar.m];
        Bundle bundle2 = rVar.n;
        if (bundle2 != null) {
            a2.mSavedFragmentState = bundle2;
        } else {
            a2.mSavedFragmentState = new Bundle();
        }
        if (m.r0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar, Fragment fragment, r rVar) {
        this.a = lVar;
        this.f1674b = fragment;
        fragment.mSavedViewState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = rVar.n;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}