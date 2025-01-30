package com.coinbase.wallet.commonui.utilities;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: FragmentLifecycleScopeProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "Lcom/uber/autodispose/lifecycle/d;", "Landroidx/lifecycle/i$a;", "Lcom/uber/autodispose/lifecycle/CorrespondingEventsFunction;", "correspondingEvents", "()Lcom/uber/autodispose/lifecycle/CorrespondingEventsFunction;", "Lh/c/s;", "lifecycle", "()Lh/c/s;", "peekLifecycle", "()Landroidx/lifecycle/i$a;", "Lh/c/f;", "requestScope", "()Lh/c/f;", "Lcom/uber/autodispose/android/lifecycle/b;", "lifecycleScope", "Lcom/uber/autodispose/android/lifecycle/b;", "Landroidx/fragment/app/Fragment;", "fragment", "untilEvent", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/i$a;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FragmentLifecycleScopeProvider implements com.uber.autodispose.lifecycle.d<i.a> {
    private final com.uber.autodispose.android.lifecycle.b lifecycleScope;

    public FragmentLifecycleScopeProvider(Fragment fragment, i.a aVar) {
        com.uber.autodispose.android.lifecycle.b d2;
        m.g(fragment, "fragment");
        o viewLifecycleOwner = fragment.getView() != null ? fragment.getViewLifecycleOwner() : fragment;
        m.f(viewLifecycleOwner, "if (fragment.view == null) fragment else fragment.viewLifecycleOwner");
        if (aVar != null) {
            d2 = com.uber.autodispose.android.lifecycle.b.e(viewLifecycleOwner, aVar);
            m.f(d2, "{\n            AndroidLifecycleScopeProvider.from(source, untilEvent)\n        }");
        } else {
            d2 = com.uber.autodispose.android.lifecycle.b.d(viewLifecycleOwner);
            m.f(d2, "{\n            AndroidLifecycleScopeProvider.from(source)\n        }");
        }
        this.lifecycleScope = d2;
    }

    @Override // com.uber.autodispose.lifecycle.d
    public CorrespondingEventsFunction<i.a> correspondingEvents() {
        CorrespondingEventsFunction<i.a> correspondingEvents = this.lifecycleScope.correspondingEvents();
        m.f(correspondingEvents, "lifecycleScope.correspondingEvents()");
        return correspondingEvents;
    }

    @Override // com.uber.autodispose.lifecycle.d
    public s<i.a> lifecycle() {
        s<i.a> lifecycle = this.lifecycleScope.lifecycle();
        m.f(lifecycle, "lifecycleScope.lifecycle()");
        return lifecycle;
    }

    @Override // com.uber.autodispose.y
    public h.c.f requestScope() {
        h.c.f requestScope = this.lifecycleScope.requestScope();
        m.f(requestScope, "lifecycleScope.requestScope()");
        return requestScope;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.uber.autodispose.lifecycle.d
    public i.a peekLifecycle() {
        return this.lifecycleScope.peekLifecycle();
    }

    public /* synthetic */ FragmentLifecycleScopeProvider(Fragment fragment, i.a aVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, (i2 & 2) != 0 ? null : aVar);
    }
}