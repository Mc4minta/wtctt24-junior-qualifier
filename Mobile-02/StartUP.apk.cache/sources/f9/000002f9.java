package androidx.lifecycle;

import androidx.lifecycle.i;
import com.appsflyer.internal.referrer.Payload;
import com.appsflyer.share.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.u0;

/* compiled from: Lifecycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\u00020\n8\u0010@\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/k;", "Landroidx/lifecycle/m;", "Landroidx/lifecycle/o;", Payload.SOURCE, "Landroidx/lifecycle/i$a;", "event", "Lkotlin/x;", Constants.URL_CAMPAIGN, "(Landroidx/lifecycle/o;Landroidx/lifecycle/i$a;)V", "Landroidx/lifecycle/i;", "a", "Landroidx/lifecycle/i;", "i", "()Landroidx/lifecycle/i;", "lifecycle", "Lkotlin/c0/f;", "b", "Lkotlin/c0/f;", "h", "()Lkotlin/c0/f;", "coroutineContext", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends k implements m {
    private final i a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.c0.f f1751b;

    @Override // androidx.lifecycle.m
    public void c(o source, i.a event) {
        kotlin.jvm.internal.m.h(source, "source");
        kotlin.jvm.internal.m.h(event, "event");
        if (i().b().compareTo(i.b.DESTROYED) <= 0) {
            i().c(this);
            u0.b(h(), null, 1, null);
        }
    }

    public kotlin.c0.f h() {
        return this.f1751b;
    }

    public i i() {
        return this.a;
    }
}