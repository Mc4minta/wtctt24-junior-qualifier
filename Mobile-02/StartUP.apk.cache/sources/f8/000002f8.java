package androidx.lifecycle;

import androidx.lifecycle.i;
import com.appsflyer.internal.referrer.Payload;
import com.appsflyer.share.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.r0;

/* compiled from: LifecycleController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/lifecycle/o;", Payload.SOURCE, "Landroidx/lifecycle/i$a;", "<anonymous parameter 1>", "Lkotlin/x;", Constants.URL_CAMPAIGN, "(Landroidx/lifecycle/o;Landroidx/lifecycle/i$a;)V"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes.dex */
final class LifecycleController$observer$1 implements m {
    final /* synthetic */ j a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ r0 f1750b;

    @Override // androidx.lifecycle.m
    public final void c(o source, i.a aVar) {
        kotlin.jvm.internal.m.h(source, "source");
        kotlin.jvm.internal.m.h(aVar, "<anonymous parameter 1>");
        i lifecycle = source.getLifecycle();
        kotlin.jvm.internal.m.d(lifecycle, "source.lifecycle");
        if (lifecycle.b() != i.b.DESTROYED) {
            i lifecycle2 = source.getLifecycle();
            kotlin.jvm.internal.m.d(lifecycle2, "source.lifecycle");
            if (lifecycle2.b().compareTo(j.b(this.a)) < 0) {
                j.a(this.a);
                throw null;
            } else {
                j.a(this.a);
                throw null;
            }
        }
        r0.a.a(this.f1750b, null, 1, null);
        throw null;
    }
}