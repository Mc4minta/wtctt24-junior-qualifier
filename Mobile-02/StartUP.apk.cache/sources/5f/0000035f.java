package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g;
import androidx.navigation.NavController;
import androidx.navigation.fragment.b;
import androidx.navigation.n;
import androidx.navigation.r;
import androidx.navigation.s;
import androidx.navigation.v;

/* compiled from: NavHostFragment.java */
/* loaded from: classes.dex */
public class d extends Fragment {
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
    private static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
    private static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean mDefaultNavHost;
    private int mGraphId;
    private Boolean mIsPrimaryBeforeOnCreate = null;
    private n mNavController;
    private View mViewParent;

    public static d create(int i2) {
        return create(i2, null);
    }

    public static NavController findNavController(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof d) {
                return ((d) fragment2).getNavController();
            }
            Fragment l0 = fragment2.getParentFragmentManager().l0();
            if (l0 instanceof d) {
                return ((d) l0).getNavController();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return r.b(view);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    private int getContainerId() {
        int id = getId();
        return (id == 0 || id == -1) ? e.a : id;
    }

    @Deprecated
    protected s<? extends b.a> createFragmentNavigator() {
        return new b(requireContext(), getChildFragmentManager(), getContainerId());
    }

    public final NavController getNavController() {
        n nVar = this.mNavController;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.mDefaultNavHost) {
            getParentFragmentManager().j().x(this).j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        n nVar = new n(requireContext());
        this.mNavController = nVar;
        nVar.B(this);
        this.mNavController.C(requireActivity().getOnBackPressedDispatcher());
        n nVar2 = this.mNavController;
        Boolean bool = this.mIsPrimaryBeforeOnCreate;
        nVar2.c(bool != null && bool.booleanValue());
        this.mIsPrimaryBeforeOnCreate = null;
        this.mNavController.D(getViewModelStore());
        onCreateNavController(this.mNavController);
        if (bundle != null) {
            bundle2 = bundle.getBundle(KEY_NAV_CONTROLLER_STATE);
            if (bundle.getBoolean(KEY_DEFAULT_NAV_HOST, false)) {
                this.mDefaultNavHost = true;
                getParentFragmentManager().j().x(this).j();
            }
            this.mGraphId = bundle.getInt(KEY_GRAPH_ID);
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.mNavController.w(bundle2);
        }
        int i2 = this.mGraphId;
        if (i2 != 0) {
            this.mNavController.y(i2);
            return;
        }
        Bundle arguments = getArguments();
        int i3 = arguments != null ? arguments.getInt(KEY_GRAPH_ID) : 0;
        Bundle bundle3 = arguments != null ? arguments.getBundle(KEY_START_DESTINATION_ARGS) : null;
        if (i3 != 0) {
            this.mNavController.z(i3, bundle3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreateNavController(NavController navController) {
        navController.m().a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.m().a(createFragmentNavigator());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        g gVar = new g(layoutInflater.getContext());
        gVar.setId(getContainerId());
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.mViewParent;
        if (view != null && r.b(view) == this.mNavController) {
            r.e(this.mViewParent, null);
        }
        this.mViewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.p);
        int resourceId = obtainStyledAttributes.getResourceId(v.q, 0);
        if (resourceId != 0) {
            this.mGraphId = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f.r);
        if (obtainStyledAttributes2.getBoolean(f.s, false)) {
            this.mDefaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean z) {
        n nVar = this.mNavController;
        if (nVar != null) {
            nVar.c(z);
        } else {
            this.mIsPrimaryBeforeOnCreate = Boolean.valueOf(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle x = this.mNavController.x();
        if (x != null) {
            bundle.putBundle(KEY_NAV_CONTROLLER_STATE, x);
        }
        if (this.mDefaultNavHost) {
            bundle.putBoolean(KEY_DEFAULT_NAV_HOST, true);
        }
        int i2 = this.mGraphId;
        if (i2 != 0) {
            bundle.putInt(KEY_GRAPH_ID, i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            r.e(view, this.mNavController);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.mViewParent = view2;
                if (view2.getId() == getId()) {
                    r.e(this.mViewParent, this.mNavController);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }

    public static d create(int i2, Bundle bundle) {
        Bundle bundle2;
        if (i2 != 0) {
            bundle2 = new Bundle();
            bundle2.putInt(KEY_GRAPH_ID, i2);
        } else {
            bundle2 = null;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBundle(KEY_START_DESTINATION_ARGS, bundle);
        }
        d dVar = new d();
        if (bundle2 != null) {
            dVar.setArguments(bundle2);
        }
        return dVar;
    }
}