package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import okhttp3.internal.http2.Settings;

/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class d extends ComponentActivity implements a.c, a.e {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final androidx.lifecycle.p mFragmentLifecycleRegistry;
    final h mFragments;
    int mNextCandidateRequestIndex;
    c.e.h<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped;

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    class a extends j<d> implements g0, androidx.activity.c {
        public a() {
            super(d.this);
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public View b(int i2) {
            return d.this.findViewById(i2);
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public boolean c() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.j
        public void g(Fragment fragment) {
            d.this.onAttachFragment(fragment);
        }

        @Override // androidx.lifecycle.o
        public androidx.lifecycle.i getLifecycle() {
            return d.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return d.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.g0
        public f0 getViewModelStore() {
            return d.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.j
        public LayoutInflater i() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.j
        public void j(Fragment fragment, String[] strArr, int i2) {
            d.this.requestPermissionsFromFragment(fragment, strArr, i2);
        }

        @Override // androidx.fragment.app.j
        public boolean k(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.j
        public boolean l(String str) {
            return androidx.core.app.a.v(d.this, str);
        }

        @Override // androidx.fragment.app.j
        public void m(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            d.this.startActivityFromFragment(fragment, intent, i2, bundle);
        }

        @Override // androidx.fragment.app.j
        public void n(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
            d.this.startIntentSenderFromFragment(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
        }

        @Override // androidx.fragment.app.j
        public void o() {
            d.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.j
        /* renamed from: p */
        public d h() {
            return d.this;
        }
    }

    public d() {
        this.mFragments = h.b(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.p(this);
        this.mStopped = true;
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.p() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.i(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i2 = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.l(i2, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void checkForValidRequestCode(int i2) {
        if ((i2 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), i.b.CREATED));
    }

    private static boolean markState(m mVar, i.b bVar) {
        boolean z = false;
        for (Fragment fragment : mVar.h0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), bVar);
                }
                if (fragment.getLifecycle().b().h(i.b.STARTED)) {
                    fragment.mLifecycleRegistry.p(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.w(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            c.o.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.u().N(str, fileDescriptor, printWriter, strArr);
    }

    public m getSupportFragmentManager() {
        return this.mFragments.u();
    }

    @Deprecated
    public c.o.a.a getSupportLoaderManager() {
        return c.o.a.a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.v();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String f2 = this.mPendingFragmentActivityResults.f(i5);
            this.mPendingFragmentActivityResults.n(i5);
            if (f2 == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t = this.mFragments.t(f2);
            if (t == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + f2);
                return;
            }
            t.onActivityResult(i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE, i3, intent);
            return;
        }
        a.d o = androidx.core.app.a.o();
        if (o == null || !o.onActivityResult(this, i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.v();
        this.mFragments.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mFragments.a(null);
        if (bundle != null) {
            this.mFragments.x(bundle.getParcelable(FRAGMENTS_TAG));
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.mPendingFragmentActivityResults = new c.e.h<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.mPendingFragmentActivityResults.l(intArray[i2], stringArray[i2]);
                    }
                } else {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new c.e.h<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(i.a.ON_CREATE);
        this.mFragments.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.mFragments.g(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.i(i.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 != 0) {
            if (i2 != 6) {
                return false;
            }
            return this.mFragments.e(menuItem);
        }
        return this.mFragments.k(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.j(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.i(i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.n(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.v();
        int i3 = (i2 >> 16) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String f2 = this.mPendingFragmentActivityResults.f(i4);
            this.mPendingFragmentActivityResults.n(i4);
            if (f2 == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t = this.mFragments.t(f2);
            if (t == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + f2);
                return;
            }
            t.onRequestPermissionsResult(i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.v();
        this.mFragments.s();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(i.a.ON_RESUME);
        this.mFragments.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.i(i.a.ON_STOP);
        Parcelable y = this.mFragments.y();
        if (y != null) {
            bundle.putParcelable(FRAGMENTS_TAG, y);
        }
        if (this.mPendingFragmentActivityResults.p() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.p()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.p()];
            for (int i2 = 0; i2 < this.mPendingFragmentActivityResults.p(); i2++) {
                iArr[i2] = this.mPendingFragmentActivityResults.k(i2);
                strArr[i2] = this.mPendingFragmentActivityResults.q(i2);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.v();
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.i(i.a.ON_START);
        this.mFragments.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.i(i.a.ON_STOP);
    }

    void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            androidx.core.app.a.r(this, strArr, i2);
            return;
        }
        checkForValidRequestCode(i2);
        try {
            this.mRequestedPermissionsFromFragment = true;
            androidx.core.app.a.r(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    public void setEnterSharedElementCallback(androidx.core.app.p pVar) {
        androidx.core.app.a.t(this, pVar);
    }

    public void setExitSharedElementCallback(androidx.core.app.p pVar) {
        androidx.core.app.a.u(this, pVar);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        this.mStartedIntentSenderFromFragment = true;
        try {
            if (i2 == -1) {
                androidx.core.app.a.x(this, intentSender, i2, intent, i3, i4, i5, bundle);
                return;
            }
            checkForValidRequestCode(i2);
            androidx.core.app.a.x(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE), intent, i3, i4, i5, bundle);
        } finally {
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.n(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.p(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.y(this);
    }

    @Override // androidx.core.app.a.e
    public final void validateRequestPermissionsRequestCode(int i2) {
        if (this.mRequestedPermissionsFromFragment || i2 == -1) {
            return;
        }
        checkForValidRequestCode(i2);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        try {
            if (i2 == -1) {
                androidx.core.app.a.w(this, intent, -1, bundle);
                return;
            }
            checkForValidRequestCode(i2);
            androidx.core.app.a.w(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & Settings.DEFAULT_INITIAL_WINDOW_SIZE), bundle);
        } finally {
            this.mStartedActivityFromFragment = false;
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public d(int i2) {
        super(i2);
        this.mFragments = h.b(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.p(this);
        this.mStopped = true;
    }
}