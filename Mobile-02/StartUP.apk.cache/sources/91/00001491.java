package com.coinbase.wallet.commonui.extensions;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.lifecycle.z;
import androidx.navigation.NavController;
import androidx.navigation.fragment.b;
import androidx.navigation.p;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.commonui.R;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseNavHostFragment;
import h.c.a0;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.i18n.TextBundle;

/* compiled from: Fragment+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000e\u001a\u00020\r*\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\b*\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u0010*\u00020\u00012\b\b\u0001\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010!\u001a\u00020\b*\u00020\u00012\b\b\u0001\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010%\u001a\u0004\u0018\u00010$*\u00020\u00012\u0006\u0010#\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&\u001a?\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020'*\u00020\u00012\u0014\b\u0004\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00028\u00000(H\u0086\bø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a(\u00100\u001a\u00028\u0000\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020'*\u00020\u00012\u0006\u0010/\u001a\u00020.H\u0086\b¢\u0006\u0004\b0\u00101\u001a4\u00102\u001a\u00028\u0000\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020'*\u00020\u00012\u0006\u0010/\u001a\u00020.2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086\b¢\u0006\u0004\b2\u00103\u001a\u0015\u00104\u001a\u0004\u0018\u00010\u001b*\u00020\u001bH\u0002¢\u0006\u0004\b4\u00105\u001a%\u00108\u001a\u00020\b*\u00020\u00012\b\b\u0001\u00106\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\u0015¢\u0006\u0004\b8\u00109\u001a#\u00108\u001a\u00020\b*\u00020\u00012\u0006\u0010:\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u0015¢\u0006\u0004\b8\u0010;\u001a;\u0010D\u001a\u00020\b*\u00020\u00012\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0BH\u0007¢\u0006\u0004\bD\u0010E\u001a\u001b\u0010G\u001a\u00020F*\u00020\u00012\b\b\u0001\u00106\u001a\u00020\u0015¢\u0006\u0004\bG\u0010H\u001a\u0011\u0010I\u001a\u00020\b*\u00020\u0001¢\u0006\u0004\bI\u0010\u0014\"\u0017\u0010L\u001a\u00020\u001d*\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0017\u0010P\u001a\u00020M*\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010O\"\u0017\u0010T\u001a\u00020Q*\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\bR\u0010S\"\u0017\u0010W\u001a\u00020\u001d*\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010V\"\u0017\u0010W\u001a\u00020\u001d*\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010K\"\u0017\u0010Y\u001a\u00020\u001d*\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\bX\u0010K\"\u0019\u0010]\u001a\u0004\u0018\u00010\u0001*\u00020Z8F@\u0006¢\u0006\u0006\u001a\u0004\b[\u0010\\\"\u0017\u0010P\u001a\u00020M*\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010^\"\u0017\u0010L\u001a\u00020\u001d*\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\bJ\u0010V\"\u0017\u0010`\u001a\u00020\u001d*\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\b_\u0010K\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006a"}, d2 = {"T", "Landroidx/fragment/app/Fragment;", "", "key", "Lh/c/h;", "getNavigationResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)Lh/c/h;", "result", "Lkotlin/x;", "setNavigationResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/Object;)V", "Landroidx/lifecycle/i$a;", "untilEvent", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getFragmentLifecycleScopeProvider", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/i$a;)Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "", "navigateUp", "(Landroidx/fragment/app/Fragment;)Z", "navigateUpToRoot", "(Landroidx/fragment/app/Fragment;)V", "", "destination", "inclusive", "navigateUpTo", "(Landroidx/fragment/app/Fragment;IZ)Z", "resId", "Landroid/os/Bundle;", "args", "Landroidx/navigation/p;", "navOptions", "Landroidx/navigation/fragment/b$b;", "navExtras", "navigate", "(Landroidx/fragment/app/Fragment;ILandroid/os/Bundle;Landroidx/navigation/p;Landroidx/navigation/fragment/b$b;)V", "nextAnim", "Landroid/view/animation/Animation;", "fixOnCreateAnimation", "(Landroidx/fragment/app/Fragment;I)Landroid/view/animation/Animation;", "Landroidx/lifecycle/b0;", "Lkotlin/Function1;", "Landroidx/lifecycle/z;", "provider", "Lkotlin/h;", "viewModel", "(Landroidx/fragment/app/Fragment;Lkotlin/e0/c/l;)Lkotlin/h;", "Landroidx/lifecycle/d0$b;", "viewModelFactory", "getViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/d0$b;)Landroidx/lifecycle/b0;", "getSharedViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/d0$b;Ljava/lang/String;)Landroidx/lifecycle/b0;", "forwardArgs", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "id", "duration", "toast", "(Landroidx/fragment/app/Fragment;II)V", TextBundle.TEXT_ENTRY, "(Landroidx/fragment/app/Fragment;Ljava/lang/String;I)V", "", "delay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lh/c/a0;", "scheduler", "Lkotlin/Function0;", "exec", "withDelay", "(Landroidx/fragment/app/Fragment;JLjava/util/concurrent/TimeUnit;Lh/c/a0;Lkotlin/e0/c/a;)V", "Landroid/graphics/drawable/Drawable;", "requireDrawableById", "(Landroidx/fragment/app/Fragment;I)Landroid/graphics/drawable/Drawable;", "hideKeyboard", "getFadeInNavOptions", "(Landroidx/lifecycle/b0;)Landroidx/navigation/p;", "fadeInNavOptions", "Landroidx/navigation/p$a;", "getFadeInNavOptionsBuilder", "(Landroidx/lifecycle/b0;)Landroidx/navigation/p$a;", "fadeInNavOptionsBuilder", "Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;", "getScreenshotProtectionBehavior", "(Landroidx/fragment/app/Fragment;)Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;", "screenshotProtectionBehavior", "getVerticalNavOptions", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/p;", "verticalNavOptions", "getNoneNavOptions", "noneNavOptions", "Landroidx/navigation/fragment/d;", "getCurrentVisibleFragment", "(Landroidx/navigation/fragment/d;)Landroidx/fragment/app/Fragment;", "currentVisibleFragment", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/p$a;", "getHoldNavOptions", "holdNavOptions", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Fragment_CommonKt {
    public static /* synthetic */ void a(z zVar, String str, Object obj) {
        m794getNavigationResult$lambda1(zVar, str, obj);
    }

    public static /* synthetic */ void b(Throwable th) {
        m796withDelay$lambda8(th);
    }

    public static /* synthetic */ boolean c(Object obj) {
        return m793getNavigationResult$lambda0(obj);
    }

    public static /* synthetic */ void d(kotlin.e0.c.a aVar) {
        m795withDelay$lambda7(aVar);
    }

    public static final Animation fixOnCreateAnimation(Fragment fragment, int i2) {
        m.g(fragment, "<this>");
        if (i2 == R.anim.fragment_enter) {
            Animation loadAnimation = AnimationUtils.loadAnimation(fragment.requireContext(), i2);
            loadAnimation.setAnimationListener(new Fragment_CommonKt$fixOnCreateAnimation$1(fragment));
            return loadAnimation;
        }
        return null;
    }

    private static final Bundle forwardArgs(Bundle bundle) {
        ForwardArgs forwardArgs = ForwardArgs.INSTANCE;
        Integer modalSourceFromArgs = forwardArgs.modalSourceFromArgs(bundle);
        if (modalSourceFromArgs == null) {
            return null;
        }
        return forwardArgs.create(modalSourceFromArgs.intValue());
    }

    public static final Fragment getCurrentVisibleFragment(androidx.navigation.fragment.d dVar) {
        Object obj;
        boolean z;
        m.g(dVar, "<this>");
        List<Fragment> h0 = dVar.getChildFragmentManager().h0();
        m.f(h0, "childFragmentManager.fragments");
        Iterator<T> it = h0.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Fragment fragment = (Fragment) obj;
            if (fragment.isAdded() && fragment.isVisible() && !fragment.isRemoving()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (Fragment) obj;
    }

    public static final p getFadeInNavOptions(Fragment fragment) {
        m.g(fragment, "<this>");
        p.a aVar = new p.a();
        int i2 = R.anim.fragment_fade_enter;
        p.a b2 = aVar.b(i2);
        int i3 = R.anim.fragment_fade_exit;
        p a = b2.c(i3).e(i2).f(i3).a();
        m.f(a, "Builder()\n        .setEnterAnim(R.anim.fragment_fade_enter)\n        .setExitAnim(R.anim.fragment_fade_exit)\n        .setPopEnterAnim(R.anim.fragment_fade_enter)\n        .setPopExitAnim(R.anim.fragment_fade_exit)\n        .build()");
        return a;
    }

    public static final p.a getFadeInNavOptionsBuilder(b0 b0Var) {
        m.g(b0Var, "<this>");
        p.a aVar = new p.a();
        int i2 = R.anim.fragment_fade_enter;
        p.a b2 = aVar.b(i2);
        int i3 = R.anim.fragment_fade_exit;
        p.a f2 = b2.c(i3).e(i2).f(i3);
        m.f(f2, "Builder()\n        .setEnterAnim(R.anim.fragment_fade_enter)\n        .setExitAnim(R.anim.fragment_fade_exit)\n        .setPopEnterAnim(R.anim.fragment_fade_enter)\n        .setPopExitAnim(R.anim.fragment_fade_exit)");
        return f2;
    }

    public static final FragmentLifecycleScopeProvider getFragmentLifecycleScopeProvider(Fragment fragment, i.a aVar) {
        m.g(fragment, "<this>");
        return new FragmentLifecycleScopeProvider(fragment, aVar);
    }

    public static /* synthetic */ FragmentLifecycleScopeProvider getFragmentLifecycleScopeProvider$default(Fragment fragment, i.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        return getFragmentLifecycleScopeProvider(fragment, aVar);
    }

    public static final p getHoldNavOptions(b0 b0Var) {
        m.g(b0Var, "<this>");
        p a = new p.a().b(R.anim.hold_enter).c(R.anim.hold_exit).e(R.anim.hold_pop_enter).f(R.anim.hold_pop_exit).a();
        m.f(a, "Builder()\n        .setEnterAnim(R.anim.hold_enter)\n        .setExitAnim(R.anim.hold_exit)\n        .setPopEnterAnim(R.anim.hold_pop_enter)\n        .setPopExitAnim(R.anim.hold_pop_exit)\n        .build()");
        return a;
    }

    public static final <T> h.c.h<T> getNavigationResult(Fragment fragment, final String key) {
        m.g(fragment, "<this>");
        m.g(key, "key");
        androidx.navigation.e h2 = androidx.navigation.fragment.a.a(fragment).h();
        final z d2 = h2 == null ? null : h2.d();
        u<T> c2 = d2 != null ? d2.c(key) : null;
        if (c2 == null) {
            h.c.h<T> empty = h.c.h.empty();
            m.f(empty, "empty()");
            return empty;
        }
        h.c.h<T> onBackpressureDrop = h.c.h.fromPublisher(s.a(fragment.getViewLifecycleOwner(), c2)).filter(new h.c.m0.p() { // from class: com.coinbase.wallet.commonui.extensions.d
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return Fragment_CommonKt.c(obj);
            }
        }).doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.commonui.extensions.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Fragment_CommonKt.a(z.this, key, obj);
            }
        }).onBackpressureDrop();
        m.f(onBackpressureDrop, "fromPublisher(\n            toPublisher(\n                this.viewLifecycleOwner,\n                liveData\n            )\n        )\n        .filter { it != null }\n        .doOnNext {\n            savedStateHandle.set(key, null)\n        }\n        .onBackpressureDrop()");
        return onBackpressureDrop;
    }

    /* renamed from: getNavigationResult$lambda-0 */
    public static final boolean m793getNavigationResult$lambda0(Object obj) {
        return obj != null;
    }

    /* renamed from: getNavigationResult$lambda-1 */
    public static final void m794getNavigationResult$lambda1(z zVar, String key, Object obj) {
        m.g(key, "$key");
        zVar.g(key, null);
    }

    public static final p getNoneNavOptions(b0 b0Var) {
        m.g(b0Var, "<this>");
        p.a aVar = new p.a();
        int i2 = R.anim.none;
        p a = aVar.b(i2).c(i2).e(i2).f(i2).a();
        m.f(a, "Builder()\n        .setEnterAnim(R.anim.none)\n        .setExitAnim(R.anim.none)\n        .setPopEnterAnim(R.anim.none)\n        .setPopExitAnim(R.anim.none)\n        .build()");
        return a;
    }

    public static final ScreenshotProtection.Behavior getScreenshotProtectionBehavior(Fragment fragment) {
        ScreenshotProtection screenshotProtection;
        m.g(fragment, "<this>");
        Annotation[] annotations = fragment.getClass().getAnnotations();
        m.f(annotations, "this::class.java.annotations");
        int length = annotations.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                screenshotProtection = null;
                break;
            }
            screenshotProtection = annotations[i2];
            if (screenshotProtection instanceof ScreenshotProtection) {
                break;
            }
            i2++;
        }
        ScreenshotProtection screenshotProtection2 = screenshotProtection instanceof ScreenshotProtection ? screenshotProtection : null;
        ScreenshotProtection.Behavior behavior = screenshotProtection2 != null ? screenshotProtection2.behavior() : null;
        return behavior == null ? ScreenshotProtection.Behavior.ALLOW : behavior;
    }

    public static final /* synthetic */ <T extends b0> T getSharedViewModel(Fragment fragment, d0.b viewModelFactory, String str) {
        m.g(fragment, "<this>");
        m.g(viewModelFactory, "viewModelFactory");
        if (str == null) {
            d0 d0Var = new d0(fragment.requireActivity(), viewModelFactory);
            m.l(4, "T");
            T t = (T) d0Var.a(b0.class);
            m.f(t, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
            return t;
        }
        d0 d0Var2 = new d0(fragment.requireActivity(), viewModelFactory);
        m.l(4, "T");
        T t2 = (T) d0Var2.b(str, b0.class);
        m.f(t2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(key, T::class.java)\n}");
        return t2;
    }

    public static /* synthetic */ b0 getSharedViewModel$default(Fragment fragment, d0.b viewModelFactory, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        m.g(fragment, "<this>");
        m.g(viewModelFactory, "viewModelFactory");
        if (str == null) {
            d0 d0Var = new d0(fragment.requireActivity(), viewModelFactory);
            m.l(4, "T");
            b0 a = d0Var.a(b0.class);
            m.f(a, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
            return a;
        }
        d0 d0Var2 = new d0(fragment.requireActivity(), viewModelFactory);
        m.l(4, "T");
        b0 b2 = d0Var2.b(str, b0.class);
        m.f(b2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(key, T::class.java)\n}");
        return b2;
    }

    public static final p getVerticalNavOptions(b0 b0Var) {
        m.g(b0Var, "<this>");
        p a = new p.a().b(R.anim.fragment_enter_vertical).c(R.anim.fragment_exit_vertical).e(R.anim.fragment_pop_enter_vertical).f(R.anim.fragment_pop_exit_vertical).a();
        m.f(a, "Builder()\n        .setEnterAnim(R.anim.fragment_enter_vertical)\n        .setExitAnim(R.anim.fragment_exit_vertical)\n        .setPopEnterAnim(R.anim.fragment_pop_enter_vertical)\n        .setPopExitAnim(R.anim.fragment_pop_exit_vertical)\n        .build()");
        return a;
    }

    public static final /* synthetic */ <T extends b0> T getViewModel(Fragment fragment, d0.b viewModelFactory) {
        m.g(fragment, "<this>");
        m.g(viewModelFactory, "viewModelFactory");
        d0 d0Var = new d0(fragment, viewModelFactory);
        m.l(4, "T");
        T t = (T) d0Var.a(b0.class);
        m.f(t, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        return t;
    }

    public static final void hideKeyboard(Fragment fragment) {
        m.g(fragment, "<this>");
        View currentFocus = fragment.requireActivity().getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(fragment.requireActivity());
        }
        Object systemService = fragment.requireActivity().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static final void navigate(Fragment fragment, int i2, Bundle bundle, p pVar, b.C0036b c0036b) {
        Bundle bundle2;
        m.g(fragment, "<this>");
        if (fragment instanceof BaseNavHostFragment) {
            ((BaseNavHostFragment) fragment).initializeNavGraph();
        }
        Bundle arguments = fragment.getArguments();
        Bundle forwardArgs = arguments == null ? null : forwardArgs(arguments);
        if (forwardArgs != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            forwardArgs.putAll(bundle);
            bundle2 = forwardArgs;
        } else {
            bundle2 = bundle;
        }
        NavController findNavController = androidx.navigation.fragment.d.findNavController(fragment);
        m.f(findNavController, "findNavController(this)");
        Resources resources = fragment.getResources();
        m.f(resources, "resources");
        NavController_CommonKt.navigateSafely(findNavController, i2, resources, bundle2, pVar, c0036b);
    }

    public static /* synthetic */ void navigate$default(Fragment fragment, int i2, Bundle bundle, p pVar, b.C0036b c0036b, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            pVar = null;
        }
        if ((i3 & 8) != 0) {
            c0036b = null;
        }
        navigate(fragment, i2, bundle, pVar, c0036b);
    }

    public static final boolean navigateUp(Fragment fragment) {
        m.g(fragment, "<this>");
        try {
            Integer modalSourceFromArgs = ForwardArgs.INSTANCE.modalSourceFromArgs(fragment.getArguments());
            if (modalSourceFromArgs != null) {
                if (androidx.navigation.fragment.d.findNavController(fragment).u(modalSourceFromArgs.intValue(), false)) {
                    return true;
                }
            }
            return androidx.navigation.fragment.d.findNavController(fragment).r();
        } catch (IllegalStateException e2) {
            l.a.a.f(e2, "Exception when trying to navigate up!", new Object[0]);
            return false;
        }
    }

    public static final boolean navigateUpTo(Fragment fragment, int i2, boolean z) {
        m.g(fragment, "<this>");
        return androidx.navigation.fragment.d.findNavController(fragment).u(i2, z);
    }

    public static /* synthetic */ boolean navigateUpTo$default(Fragment fragment, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        return navigateUpTo(fragment, i2, z);
    }

    public static final void navigateUpToRoot(Fragment fragment) {
        m.g(fragment, "<this>");
        try {
            navigateUpTo(fragment, androidx.navigation.fragment.d.findNavController(fragment).k().J(), false);
        } catch (IllegalStateException e2) {
            l.a.a.f(e2, "Exception when trying to navigate up!", new Object[0]);
        }
    }

    public static final Drawable requireDrawableById(Fragment fragment, int i2) {
        m.g(fragment, "<this>");
        Drawable f2 = androidx.core.content.a.f(fragment.requireContext(), i2);
        if (f2 != null) {
            return f2;
        }
        throw new Resources.NotFoundException();
    }

    public static final <T> void setNavigationResult(Fragment fragment, String key, T t) {
        androidx.navigation.e n;
        z d2;
        m.g(fragment, "<this>");
        m.g(key, "key");
        Integer modalSourceFromArgs = ForwardArgs.INSTANCE.modalSourceFromArgs(fragment.getArguments());
        if (modalSourceFromArgs != null) {
            n = androidx.navigation.fragment.a.a(fragment).f(modalSourceFromArgs.intValue());
        } else {
            n = androidx.navigation.fragment.a.a(fragment).n();
        }
        if (n == null || (d2 = n.d()) == null) {
            return;
        }
        d2.g(key, t);
    }

    public static final void toast(Fragment fragment, int i2, int i3) {
        m.g(fragment, "<this>");
        Toast.makeText(fragment.getContext(), i2, i3).show();
    }

    public static /* synthetic */ void toast$default(Fragment fragment, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        toast(fragment, i2, i3);
    }

    public static final /* synthetic */ <T extends b0> kotlin.h<T> viewModel(Fragment fragment, l<? super z, ? extends T> provider) {
        m.g(fragment, "<this>");
        m.g(provider, "provider");
        Fragment_CommonKt$viewModel$1 fragment_CommonKt$viewModel$1 = new Fragment_CommonKt$viewModel$1(fragment, provider);
        Fragment_CommonKt$viewModel$$inlined$viewModels$default$1 fragment_CommonKt$viewModel$$inlined$viewModels$default$1 = new Fragment_CommonKt$viewModel$$inlined$viewModels$default$1(fragment);
        m.l(4, "T");
        return androidx.fragment.app.z.a(fragment, e0.b(b0.class), new Fragment_CommonKt$viewModel$$inlined$viewModels$default$2(fragment_CommonKt$viewModel$$inlined$viewModels$default$1), fragment_CommonKt$viewModel$1);
    }

    @SuppressLint({"AutoDispose"})
    public static final void withDelay(Fragment fragment, long j2, TimeUnit timeUnit, a0 scheduler, final kotlin.e0.c.a<x> exec) {
        m.g(fragment, "<this>");
        m.g(timeUnit, "timeUnit");
        m.g(scheduler, "scheduler");
        m.g(exec, "exec");
        h.c.c.g().j(j2, TimeUnit.SECONDS).s(scheduler).l(new h.c.m0.a() { // from class: com.coinbase.wallet.commonui.extensions.e
            @Override // h.c.m0.a
            public final void run() {
                Fragment_CommonKt.d(kotlin.e0.c.a.this);
            }
        }).m(new h.c.m0.f() { // from class: com.coinbase.wallet.commonui.extensions.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                Fragment_CommonKt.b((Throwable) obj);
            }
        }).subscribe();
    }

    public static /* synthetic */ void withDelay$default(Fragment fragment, long j2, TimeUnit timeUnit, a0 a0Var, kotlin.e0.c.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        withDelay(fragment, j2, timeUnit, a0Var, aVar);
    }

    /* renamed from: withDelay$lambda-7 */
    public static final void m795withDelay$lambda7(kotlin.e0.c.a exec) {
        m.g(exec, "$exec");
        exec.invoke();
    }

    /* renamed from: withDelay$lambda-8 */
    public static final void m796withDelay$lambda8(Throwable th) {
        l.a.a.f(th, "Error while performing delayed execution", new Object[0]);
    }

    public static final void toast(Fragment fragment, String text, int i2) {
        m.g(fragment, "<this>");
        m.g(text, "text");
        Toast.makeText(fragment.getContext(), text, i2).show();
    }

    public static /* synthetic */ void toast$default(Fragment fragment, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        toast(fragment, str, i2);
    }

    public static final p.a getFadeInNavOptionsBuilder(Fragment fragment) {
        m.g(fragment, "<this>");
        p.a aVar = new p.a();
        int i2 = R.anim.fragment_fade_enter;
        p.a b2 = aVar.b(i2);
        int i3 = R.anim.fragment_fade_exit;
        p.a f2 = b2.c(i3).e(i2).f(i3);
        m.f(f2, "Builder()\n        .setEnterAnim(R.anim.fragment_fade_enter)\n        .setExitAnim(R.anim.fragment_fade_exit)\n        .setPopEnterAnim(R.anim.fragment_fade_enter)\n        .setPopExitAnim(R.anim.fragment_fade_exit)");
        return f2;
    }

    public static final p getFadeInNavOptions(b0 b0Var) {
        m.g(b0Var, "<this>");
        p a = getFadeInNavOptionsBuilder(b0Var).a();
        m.f(a, "fadeInNavOptionsBuilder.build()");
        return a;
    }

    public static final p getVerticalNavOptions(Fragment fragment) {
        m.g(fragment, "<this>");
        p a = new p.a().b(R.anim.fragment_enter_vertical).c(R.anim.fragment_exit_vertical).e(R.anim.fragment_pop_enter_vertical).f(R.anim.fragment_pop_exit_vertical).a();
        m.f(a, "Builder()\n        .setEnterAnim(R.anim.fragment_enter_vertical)\n        .setExitAnim(R.anim.fragment_exit_vertical)\n        .setPopEnterAnim(R.anim.fragment_pop_enter_vertical)\n        .setPopExitAnim(R.anim.fragment_pop_exit_vertical)\n        .build()");
        return a;
    }
}