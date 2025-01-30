package com.toshi.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.appsflyer.share.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.x;
import org.toshi.R;

/* compiled from: PinCodeIndicator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\tJ\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\tR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/toshi/view/custom/PinCodeIndicator;", "Landroid/widget/LinearLayout;", "", "char", "Lkotlin/x;", "d", "(Ljava/lang/String;)V", "a", "i", "()V", "h", "f", "b", "", "isValid", Constants.URL_CAMPAIGN, "(Ljava/lang/String;Z)V", "g", "getPin", "()Ljava/lang/String;", "e", "Ljava/util/Stack;", "Lcom/toshi/view/custom/p;", "Ljava/util/Stack;", "pin", "Lkotlin/Function1;", "Lkotlin/e0/c/l;", "getOnFullPinListener", "()Lkotlin/e0/c/l;", "setOnFullPinListener", "(Lkotlin/e0/c/l;)V", "onFullPinListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PinCodeIndicator extends LinearLayout {
    private final Stack<p> a;

    /* renamed from: b  reason: collision with root package name */
    private kotlin.e0.c.l<? super String, x> f11164b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinCodeIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        this.a = new Stack<>();
        f();
    }

    private final void a(String str) {
        p pVar = (p) kotlin.a0.p.l0(this.a);
        if ((pVar == null || pVar.b()) ? false : true) {
            i();
            return;
        }
        this.a.add(new p(str, false));
        i();
        h();
    }

    private final void d(String str) {
        kotlin.e0.c.l<? super String, x> lVar;
        this.a.add(new p(str, true));
        h();
        if (this.a.size() != getChildCount() || (lVar = this.f11164b) == null) {
            return;
        }
        lVar.invoke(getPin());
    }

    private final void h() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = getChildAt(i2);
            p pVar = (p) kotlin.a0.p.b0(this.a, i2);
            if ((pVar == null || pVar.b()) ? false : true) {
                childAt.setBackgroundResource(R.drawable.pin_error_circle);
            } else if (i2 < this.a.size()) {
                childAt.setBackgroundResource(R.drawable.pin_circle);
            } else {
                childAt.setBackgroundResource(R.drawable.pin_border_circle);
            }
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    private final void i() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake));
    }

    public final void b(String str) {
        kotlin.jvm.internal.m.g(str, "char");
        if (this.a.size() >= getChildCount()) {
            return;
        }
        d(str);
    }

    public final void c(String str, boolean z) {
        kotlin.jvm.internal.m.g(str, "char");
        if (this.a.size() >= getChildCount()) {
            return;
        }
        if (z) {
            d(str);
        } else {
            a(str);
        }
    }

    public final void e() {
        this.a.clear();
        h();
    }

    public final void f() {
        LinearLayout.inflate(getContext(), R.layout.view_pincode_indicator, this);
    }

    public final void g() {
        if (this.a.size() == 0) {
            return;
        }
        this.a.pop();
        h();
    }

    public final kotlin.e0.c.l<String, x> getOnFullPinListener() {
        return this.f11164b;
    }

    public final String getPin() {
        int r;
        List I0;
        String h0;
        Stack<p> stack = this.a;
        r = kotlin.a0.s.r(stack, 10);
        ArrayList arrayList = new ArrayList(r);
        for (p pVar : stack) {
            arrayList.add(pVar.a());
        }
        I0 = z.I0(arrayList);
        h0 = z.h0(I0, "", null, null, 0, null, null, 62, null);
        return h0;
    }

    public final void setOnFullPinListener(kotlin.e0.c.l<? super String, x> lVar) {
        this.f11164b = lVar;
    }
}