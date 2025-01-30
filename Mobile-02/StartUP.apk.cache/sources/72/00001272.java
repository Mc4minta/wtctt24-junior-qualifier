package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;

/* compiled from: TopAwareRecyclerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\tR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/TopAwareRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/x;", "initListeners", "()V", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "scrolledToTopViewModel", "Lh/c/s;", "startTouchedObservable", "(Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;)Lh/c/s;", "startScrollToTopListener", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager$delegate", "Lkotlin/h;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Lh/c/v0/b;", "", "kotlin.jvm.PlatformType", "yDeltaSubject", "Lh/c/v0/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TopAwareRecyclerView extends RecyclerView {
    private final kotlin.h linearLayoutManager$delegate;
    private final h.c.v0.b<Integer> yDeltaSubject;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopAwareRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopAwareRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ TopAwareRecyclerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ x a(ScrolledToTopViewModel scrolledToTopViewModel, TopAwareRecyclerView topAwareRecyclerView, Integer num) {
        return m699startScrollToTopListener$lambda2(scrolledToTopViewModel, topAwareRecyclerView, num);
    }

    public static final /* synthetic */ h.c.v0.b access$getYDeltaSubject$p(TopAwareRecyclerView topAwareRecyclerView) {
        return topAwareRecyclerView.yDeltaSubject;
    }

    public static /* synthetic */ x c(TopAwareRecyclerView topAwareRecyclerView, Boolean bool) {
        return m701startTouchedObservable$lambda1(topAwareRecyclerView, bool);
    }

    public static /* synthetic */ boolean d(Boolean bool) {
        return m700startTouchedObservable$lambda0(bool);
    }

    private final LinearLayoutManager getLinearLayoutManager() {
        return (LinearLayoutManager) this.linearLayoutManager$delegate.getValue();
    }

    private final void initListeners() {
        addOnItemTouchListener(new RecyclerView.z() { // from class: com.coinbase.wallet.application.view.custom.TopAwareRecyclerView$initListeners$1
            @Override // androidx.recyclerview.widget.RecyclerView.z, androidx.recyclerview.widget.RecyclerView.s
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e2) {
                m.g(rv, "rv");
                m.g(e2, "e");
                if (!TopAwareRecyclerView.this.isNestedScrollingEnabled()) {
                    TopAwareRecyclerView.this.setNestedScrollingEnabled(true);
                }
                return super.onInterceptTouchEvent(rv, e2);
            }
        });
        addOnScrollListener(new RecyclerView.t() { // from class: com.coinbase.wallet.application.view.custom.TopAwareRecyclerView$initListeners$2
            @Override // androidx.recyclerview.widget.RecyclerView.t
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                m.g(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i2, i3);
                TopAwareRecyclerView.access$getYDeltaSubject$p(TopAwareRecyclerView.this).onNext(Integer.valueOf(i3));
            }
        });
    }

    /* renamed from: startScrollToTopListener$lambda-2 */
    public static final x m699startScrollToTopListener$lambda2(ScrolledToTopViewModel scrolledToTopViewModel, TopAwareRecyclerView this$0, Integer it) {
        m.g(scrolledToTopViewModel, "$scrolledToTopViewModel");
        m.g(this$0, "this$0");
        m.g(it, "it");
        scrolledToTopViewModel.scrolledToTop(this$0.getLinearLayoutManager().c2() <= 0);
        return x.a;
    }

    /* renamed from: startTouchedObservable$lambda-0 */
    public static final boolean m700startTouchedObservable$lambda0(Boolean isTouched) {
        m.g(isTouched, "isTouched");
        return isTouched.booleanValue();
    }

    /* renamed from: startTouchedObservable$lambda-1 */
    public static final x m701startTouchedObservable$lambda1(TopAwareRecyclerView this$0, Boolean it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        this$0.setNestedScrollingEnabled(false);
        return x.a;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final s<x> startScrollToTopListener(final ScrolledToTopViewModel scrolledToTopViewModel) {
        m.g(scrolledToTopViewModel, "scrolledToTopViewModel");
        scrolledToTopViewModel.scrolledToTop(getLinearLayoutManager().c2() <= 0);
        s<Integer> observeOn = this.yDeltaSubject.observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "yDeltaSubject\n            .observeOn(AndroidSchedulers.mainThread())");
        s<x> map = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).map(new n() { // from class: com.coinbase.wallet.application.view.custom.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TopAwareRecyclerView.a(ScrolledToTopViewModel.this, this, (Integer) obj);
            }
        });
        m.f(map, "yDeltaSubject\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .map {\n                scrolledToTopViewModel.scrolledToTop(\n                    linearLayoutManager.findFirstCompletelyVisibleItemPosition() <= 0\n                )\n            }");
        return map;
    }

    public final s<x> startTouchedObservable(ScrolledToTopViewModel scrolledToTopViewModel) {
        m.g(scrolledToTopViewModel, "scrolledToTopViewModel");
        s<Boolean> observeOn = scrolledToTopViewModel.isTouchedObservable().observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "scrolledToTopViewModel.isTouchedObservable\n            .observeOn(AndroidSchedulers.mainThread())");
        s<x> map = Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).filter(new p() { // from class: com.coinbase.wallet.application.view.custom.j
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return TopAwareRecyclerView.d((Boolean) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.application.view.custom.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TopAwareRecyclerView.c(TopAwareRecyclerView.this, (Boolean) obj);
            }
        });
        m.f(map, "scrolledToTopViewModel.isTouchedObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .filter { isTouched -> isTouched }\n            .map { isNestedScrollingEnabled = false }");
        return map;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopAwareRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.h b2;
        m.g(context, "context");
        h.c.v0.b<Integer> d2 = h.c.v0.b.d();
        m.f(d2, "create<Int>()");
        this.yDeltaSubject = d2;
        b2 = k.b(new TopAwareRecyclerView$linearLayoutManager$2(this));
        this.linearLayoutManager$delegate = b2;
        initListeners();
    }
}