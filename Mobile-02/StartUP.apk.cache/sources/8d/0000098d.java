package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import c.e.a;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    final Map<m, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private final a<View, Fragment> tempViewToSupportFragment = new a<>();
    private final a<View, android.app.Fragment> tempViewToFragment = new a<>();
    private final Bundle tempBundle = new Bundle();

    /* loaded from: classes.dex */
    public interface RequestManagerFactory {
        RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void assertNotDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void findAllFragmentsWithViews(FragmentManager fragmentManager, a<View, android.app.Fragment> aVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    aVar.put(fragment.getView(), fragment);
                    findAllFragmentsWithViews(fragment.getChildFragmentManager(), aVar);
                }
            }
            return;
        }
        findAllFragmentsWithViewsPreO(fragmentManager, aVar);
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(FragmentManager fragmentManager, a<View, android.app.Fragment> aVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.tempBundle.putInt(FRAGMENT_INDEX_KEY, i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, FRAGMENT_INDEX_KEY);
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                aVar.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    findAllFragmentsWithViews(fragment.getChildFragmentManager(), aVar);
                }
            }
            i2 = i3;
        }
    }

    private static void findAllSupportFragmentsWithViews(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().h0(), map);
            }
        }
    }

    @Deprecated
    private android.app.Fragment findFragment(View view, Activity activity) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToFragment.clear();
        return fragment;
    }

    private Fragment findSupportFragment(View view, d dVar) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(dVar.getSupportFragmentManager().h0(), this.tempViewToSupportFragment);
        View findViewById = dVar.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    @Deprecated
    private RequestManager fragmentGet(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment, z);
        RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager == null) {
            RequestManager build = this.factory.build(Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
            requestManagerFragment.setRequestManager(build);
            return build;
        }
        return requestManager;
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.applicationManager;
    }

    private static boolean isActivityVisible(Activity activity) {
        return !activity.isFinishing();
    }

    private RequestManager supportFragmentGet(Context context, m mVar, Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(mVar, fragment, z);
        RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager == null) {
            RequestManager build = this.factory.build(Glide.get(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
            supportRequestManagerFragment.setRequestManager(build);
            return build;
        }
        return requestManager;
    }

    public RequestManager get(Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof d) {
                    return get((d) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return get(((ContextWrapper) context).getBaseContext());
                }
            }
            return getApplicationManager(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public RequestManagerFragment getRequestManagerFragment(Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportRequestManagerFragment getSupportRequestManagerFragment(d dVar) {
        return getSupportRequestManagerFragment(dVar.getSupportFragmentManager(), null, isActivityVisible(dVar));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.pendingRequestManagerFragments.remove(obj);
        } else if (i2 == 2) {
            obj = (m) message.obj;
            remove = this.pendingSupportRequestManagerFragments.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    private RequestManagerFragment getRequestManagerFragment(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment == null && (requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                requestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    private SupportRequestManagerFragment getSupportRequestManagerFragment(m mVar, Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) mVar.Z(FRAGMENT_TAG);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(mVar)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.setParentFragmentHint(fragment);
            if (z) {
                supportRequestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingSupportRequestManagerFragments.put(mVar, supportRequestManagerFragment);
            mVar.j().e(supportRequestManagerFragment, FRAGMENT_TAG).k();
            this.handler.obtainMessage(2, mVar).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    public RequestManager get(d dVar) {
        if (Util.isOnBackgroundThread()) {
            return get(dVar.getApplicationContext());
        }
        assertNotDestroyed(dVar);
        return supportFragmentGet(dVar, dVar.getSupportFragmentManager(), null, isActivityVisible(dVar));
    }

    public RequestManager get(Fragment fragment) {
        Preconditions.checkNotNull(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return supportFragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager get(Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        return fragmentGet(activity, activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    public RequestManager get(View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity findActivity = findActivity(view.getContext());
        if (findActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (findActivity instanceof d) {
            Fragment findSupportFragment = findSupportFragment(view, (d) findActivity);
            return findSupportFragment != null ? get(findSupportFragment) : get(findActivity);
        }
        android.app.Fragment findFragment = findFragment(view, findActivity);
        if (findFragment == null) {
            return get(findActivity);
        }
        return get(findFragment);
    }

    @TargetApi(17)
    @Deprecated
    public RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!Util.isOnBackgroundThread() && Build.VERSION.SDK_INT >= 17) {
                return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}