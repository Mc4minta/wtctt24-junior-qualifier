package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {
    private static final String TAG = "RMFragment";
    private final Set<RequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private Fragment parentFragmentHint;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private RequestManagerFragment rootRequestManagerFragment;

    /* loaded from: classes.dex */
    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        FragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> descendantRequestManagerFragments = RequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    @TargetApi(17)
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @TargetApi(17)
    private boolean isDescendant(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(Activity activity) {
        unregisterFragmentWithRoot();
        RequestManagerFragment requestManagerFragment = Glide.get(activity).getRequestManagerRetriever().getRequestManagerFragment(activity);
        this.rootRequestManagerFragment = requestManagerFragment;
        if (equals(requestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @TargetApi(17)
    Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
                if (isDescendant(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            registerFragmentWithRoot(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParentFragmentHint(Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getActivity());
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }
}