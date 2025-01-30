package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScreenFragment.java */
/* loaded from: classes2.dex */
public class g extends Fragment {
    protected b a;

    /* renamed from: b  reason: collision with root package name */
    private List<d> f11029b = new ArrayList();

    public g() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static View k(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.endViewTransition(view);
            viewGroup.removeView(view);
        }
        view.setVisibility(0);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        ((UIManagerModule) ((ReactContext) this.a.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new c(this.a.getId()));
        for (d dVar : this.f11029b) {
            if (dVar.getScreenCount() > 0) {
                dVar.i(dVar.getScreenCount() - 1).getFragment().d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        ((UIManagerModule) ((ReactContext) this.a.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new e(this.a.getId()));
        for (d dVar : this.f11029b) {
            if (dVar.getScreenCount() > 0) {
                dVar.i(dVar.getScreenCount() - 1).getFragment().e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        ((UIManagerModule) ((ReactContext) this.a.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new l(this.a.getId()));
        for (d dVar : this.f11029b) {
            if (dVar.getScreenCount() > 0) {
                dVar.i(dVar.getScreenCount() - 1).getFragment().f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        ((UIManagerModule) ((ReactContext) this.a.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new m(this.a.getId()));
        for (d dVar : this.f11029b) {
            if (dVar.getScreenCount() > 0) {
                dVar.i(dVar.getScreenCount() - 1).getFragment().g();
            }
        }
    }

    public b h() {
        return this.a;
    }

    public void i() {
        if (isResumed()) {
            d();
        } else {
            e();
        }
    }

    public void j() {
        if (isResumed()) {
            f();
        } else {
            g();
        }
    }

    public void l(d dVar) {
        this.f11029b.add(dVar);
    }

    public void m(d dVar) {
        this.f11029b.remove(dVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(k(this.a));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d container = this.a.getContainer();
        if (container == null || !container.j(this)) {
            ((UIManagerModule) ((ReactContext) this.a.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new f(this.a.getId()));
        }
        this.f11029b.clear();
    }

    @SuppressLint({"ValidFragment"})
    public g(b bVar) {
        this.a = bVar;
    }
}