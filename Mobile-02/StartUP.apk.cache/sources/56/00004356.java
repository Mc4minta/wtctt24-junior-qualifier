package com.toshi.view.fragment.r0;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: AuthFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/toshi/view/fragment/r0/d;", "Landroidx/fragment/app/c;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lkotlin/x;", "e", "()V", "Le/j/d/c;", "permit", "f", "(Le/j/d/c;)V", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", Constants.URL_CAMPAIGN, "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", "getCallback", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;", "h", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationCallback;)V", "callback", "", "d", "Lkotlin/h;", "g", "()Z", "isCancellable", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class d extends androidx.fragment.app.c {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final String f11377b = "is_cancellable";

    /* renamed from: c  reason: collision with root package name */
    private AuthenticationCallback f11378c;

    /* renamed from: d  reason: collision with root package name */
    private final h f11379d;

    /* compiled from: AuthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return d.f11377b;
        }
    }

    /* compiled from: AuthFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends o implements kotlin.e0.c.a<Boolean> {
        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            Bundle arguments = d.this.getArguments();
            if (arguments == null) {
                return true;
            }
            return arguments.getBoolean(d.a.a());
        }
    }

    /* compiled from: AuthFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends androidx.appcompat.app.h {
        c(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            if (d.this.g()) {
                d.this.e();
            }
        }
    }

    public d() {
        h b2;
        b2 = k.b(new b());
        this.f11379d = b2;
    }

    public final void e() {
        AuthenticationCallback authenticationCallback = this.f11378c;
        if (authenticationCallback != null) {
            authenticationCallback.onAuthenticationCancelled();
        }
        dismiss();
    }

    public final void f(e.j.d.c permit) {
        m.g(permit, "permit");
        AuthenticationCallback authenticationCallback = this.f11378c;
        if (authenticationCallback != null) {
            authenticationCallback.onAuthenticationSucceeded(permit);
        }
        dismiss();
    }

    public final boolean g() {
        return ((Boolean) this.f11379d.getValue()).booleanValue();
    }

    public final void h(AuthenticationCallback authenticationCallback) {
        this.f11378c = authenticationCallback;
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        c cVar = new c(requireContext(), getTheme());
        Window window = cVar.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = cVar.getWindow();
        if (window2 != null) {
            window2.addFlags(PKIFailureInfo.certRevoked);
        }
        cVar.setCanceledOnTouchOutside(false);
        return cVar;
    }
}