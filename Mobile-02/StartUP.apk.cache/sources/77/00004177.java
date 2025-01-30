package com.toshi.view.activity.pin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.applock.legacy.AuthenticationCallback;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.toshi.model.local.authentication.AuthenticationMethod;
import com.toshi.model.local.authentication.EncryptionMethod;
import com.toshi.view.custom.PinCodeIndicator;
import com.toshi.view.custom.SpinnerOverlayLayout;
import e.j.n.p3.p;
import e.j.n.p3.s;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.l0.a0;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwitchPinLockFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001!\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R(\u0010-\u001a\b\u0012\u0004\u0012\u00020&0%8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u001d\u00109\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b\"\u00108R\"\u0010A\u001a\u00020:8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/toshi/view/activity/pin/SwitchPinLockFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "g", "v", "initClickListener", "p", "k", "", "newChar", "i", "(C)V", "initObservers", "Le/j/n/p3/p;", "pinStatus", "h", "(Le/j/n/p3/p;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "com/toshi/view/activity/pin/SwitchPinLockFragment$c", "f", "Lcom/toshi/view/activity/pin/SwitchPinLockFragment$c;", "amountClickedListener", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/p3/s;", Constants.URL_CAMPAIGN, "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "d", "Le/j/n/p3/s;", "viewModel", "Le/j/l/v/a;", "e", "Lkotlin/h;", "()Le/j/l/v/a;", "pinResource", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "b", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper$app_productionRelease", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper$app_productionRelease", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "authenticationHelper", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwitchPinLockFragment extends BaseFragment implements StyledFragment {
    public static final a a = new a(null);

    /* renamed from: b */
    public AuthenticationHelper f11134b;

    /* renamed from: c */
    public GenericViewModelFactory<s> f11135c;

    /* renamed from: d */
    private s f11136d;

    /* renamed from: e */
    private final kotlin.h f11137e;

    /* renamed from: f */
    private final c f11138f;

    /* compiled from: SwitchPinLockFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String pin) {
            m.g(pin, "pin");
            Bundle bundle = new Bundle();
            bundle.putString("pin", pin);
            return bundle;
        }
    }

    /* compiled from: SwitchPinLockFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AuthenticationMethod.values().length];
            iArr[AuthenticationMethod.BIOMETRIC.ordinal()] = 1;
            iArr[AuthenticationMethod.PIN.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: SwitchPinLockFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c implements NumberKeyboardInputView.OnDigitPressedListener {

        /* compiled from: SwitchPinLockFragment.kt */
        /* loaded from: classes2.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[NumberKeyboardDigit.values().length];
                iArr[NumberKeyboardDigit.One.ordinal()] = 1;
                iArr[NumberKeyboardDigit.Two.ordinal()] = 2;
                iArr[NumberKeyboardDigit.Three.ordinal()] = 3;
                iArr[NumberKeyboardDigit.Four.ordinal()] = 4;
                iArr[NumberKeyboardDigit.Five.ordinal()] = 5;
                iArr[NumberKeyboardDigit.Six.ordinal()] = 6;
                iArr[NumberKeyboardDigit.Seven.ordinal()] = 7;
                iArr[NumberKeyboardDigit.Eight.ordinal()] = 8;
                iArr[NumberKeyboardDigit.Nine.ordinal()] = 9;
                iArr[NumberKeyboardDigit.Zero.ordinal()] = 10;
                iArr[NumberKeyboardDigit.Delete.ordinal()] = 11;
                iArr[NumberKeyboardDigit.DecimalSeparator.ordinal()] = 12;
                iArr[NumberKeyboardDigit.GroupSeparator.ordinal()] = 13;
                a = iArr;
            }
        }

        c() {
            SwitchPinLockFragment.this = r1;
        }

        @Override // com.coinbase.wallet.commonui.views.NumberKeyboardInputView.OnDigitPressedListener
        public void onDigitPressed(NumberKeyboardDigit digit, boolean z) {
            char p1;
            x xVar;
            m.g(digit, "digit");
            switch (a.a[digit.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    SwitchPinLockFragment switchPinLockFragment = SwitchPinLockFragment.this;
                    p1 = a0.p1(digit.getDescription());
                    switchPinLockFragment.i(p1);
                    xVar = x.a;
                    break;
                case 11:
                    View view = SwitchPinLockFragment.this.getView();
                    ((PinCodeIndicator) (view == null ? null : view.findViewById(e.j.a.pinCodeIndicator))).g();
                case 12:
                case 13:
                    xVar = x.a;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            SafeWhen_CommonKt.getSafe(xVar);
        }
    }

    /* compiled from: SwitchPinLockFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends o implements kotlin.e0.c.l<String, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            SwitchPinLockFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(String str) {
            invoke2(str);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            m.g(it, "it");
            s sVar = SwitchPinLockFragment.this.f11136d;
            if (sVar != null) {
                sVar.t(it);
            } else {
                m.w("viewModel");
                throw null;
            }
        }
    }

    /* compiled from: SwitchPinLockFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends o implements kotlin.e0.c.a<e.j.l.v.a> {
        public static final e a = new e();

        e() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final e.j.l.v.a invoke() {
            return new e.j.l.v.a();
        }
    }

    /* compiled from: SwitchPinLockFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends AuthenticationCallback {
        f() {
            SwitchPinLockFragment.this = r1;
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationCancelled() {
            e.j.f.m.k(SwitchPinLockFragment.this, R.id.appLockSettingsFragment, false, 2, null);
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationLockout(boolean z) {
        }

        @Override // com.coinbase.wallet.features.applock.legacy.AuthenticationCallback
        public void onAuthenticationSucceeded(e.j.d.c permit) {
            m.g(permit, "permit");
            if (permit instanceof e.j.d.a) {
                s sVar = SwitchPinLockFragment.this.f11136d;
                if (sVar != null) {
                    sVar.I((e.j.d.a) permit);
                    return;
                } else {
                    m.w("viewModel");
                    throw null;
                }
            }
            onAuthenticationCancelled();
        }
    }

    public SwitchPinLockFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(e.a);
        this.f11137e = b2;
        this.f11138f = new c();
    }

    private final e.j.l.v.a f() {
        return (e.j.l.v.a) this.f11137e.getValue();
    }

    private final void g() {
        s sVar = this.f11136d;
        if (sVar == null) {
            m.w("viewModel");
            throw null;
        }
        AuthenticationMethod v = sVar.v();
        if ((v == null ? -1 : b.a[v.ordinal()]) != 1) {
            return;
        }
        v();
    }

    private final void h(p pVar) {
        e.j.l.v.a f2 = f();
        androidx.fragment.app.d requireActivity = requireActivity();
        m.f(requireActivity, "requireActivity()");
        int b2 = f2.b(requireActivity, pVar);
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.pinInfo))).setTextColor(b2);
        e.j.l.v.a f3 = f();
        androidx.fragment.app.d requireActivity2 = requireActivity();
        m.f(requireActivity2, "requireActivity()");
        String a2 = f3.a(requireActivity2, pVar);
        View view2 = getView();
        ((TextView) (view2 != null ? view2.findViewById(e.j.a.pinInfo) : null)).setText(a2);
    }

    public final void i(char c2) {
        View view = getView();
        String o = m.o(((PinCodeIndicator) (view == null ? null : view.findViewById(e.j.a.pinCodeIndicator))).getPin(), Character.valueOf(c2));
        s sVar = this.f11136d;
        if (sVar != null) {
            boolean a2 = sVar.a(o);
            s sVar2 = this.f11136d;
            if (sVar2 != null) {
                sVar2.u(a2);
                View view2 = getView();
                ((PinCodeIndicator) (view2 != null ? view2.findViewById(e.j.a.pinCodeIndicator) : null)).c(String.valueOf(c2), a2);
                return;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    private final void init() {
        initViewModel();
        e.j.f.m.o(this, getAuthenticationHelper$app_productionRelease());
        initClickListener();
        p();
        k();
        initObservers();
        g();
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(e.j.a.amountInput))).setTextColorResId(R.color.primary_black);
        View view2 = getView();
        ((NumberKeyboardInputView) (view2 == null ? null : view2.findViewById(e.j.a.amountInput))).setTextSizeResId(R.dimen.text_size_28);
        View view3 = getView();
        ((NumberKeyboardInputView) (view3 != null ? view3.findViewById(e.j.a.amountInput) : null)).setHideDecimal(true);
    }

    private final void initClickListener() {
        View view = getView();
        ((ImageView) (view == null ? null : view.findViewById(e.j.a.backButton))).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.activity.pin.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SwitchPinLockFragment.t(SwitchPinLockFragment.this, view2);
            }
        });
    }

    private final void initObservers() {
        s sVar = this.f11136d;
        if (sVar != null) {
            sVar.k().g(getViewLifecycleOwner(), new v() { // from class: com.toshi.view.activity.pin.j
                @Override // androidx.lifecycle.v
                public final void a(Object obj) {
                    SwitchPinLockFragment.u(SwitchPinLockFragment.this, (p) obj);
                }
            });
            s sVar2 = this.f11136d;
            if (sVar2 != null) {
                sVar2.y().g(getViewLifecycleOwner(), new v() { // from class: com.toshi.view.activity.pin.f
                    @Override // androidx.lifecycle.v
                    public final void a(Object obj) {
                        SwitchPinLockFragment.q(SwitchPinLockFragment.this, (Boolean) obj);
                    }
                });
                s sVar3 = this.f11136d;
                if (sVar3 != null) {
                    e.j.l.k<x> i2 = sVar3.i();
                    androidx.lifecycle.o viewLifecycleOwner = getViewLifecycleOwner();
                    m.f(viewLifecycleOwner, "viewLifecycleOwner");
                    i2.g(viewLifecycleOwner, new v() { // from class: com.toshi.view.activity.pin.h
                        @Override // androidx.lifecycle.v
                        public final void a(Object obj) {
                            SwitchPinLockFragment.s(SwitchPinLockFragment.this, (x) obj);
                        }
                    });
                    s sVar4 = this.f11136d;
                    if (sVar4 == null) {
                        m.w("viewModel");
                        throw null;
                    }
                    e.j.l.k<String> l2 = sVar4.l();
                    androidx.lifecycle.o viewLifecycleOwner2 = getViewLifecycleOwner();
                    m.f(viewLifecycleOwner2, "viewLifecycleOwner");
                    l2.g(viewLifecycleOwner2, new v() { // from class: com.toshi.view.activity.pin.g
                        @Override // androidx.lifecycle.v
                        public final void a(Object obj) {
                            SwitchPinLockFragment.r(SwitchPinLockFragment.this, (String) obj);
                        }
                    });
                    return;
                }
                m.w("viewModel");
                throw null;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    private final void initViewModel() {
        b0 a2 = new d0(this, getViewModelFactory$app_productionRelease()).a(s.class);
        m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        s sVar = (s) a2;
        this.f11136d = sVar;
        if (sVar == null) {
            m.w("viewModel");
            throw null;
        }
        Bundle arguments = getArguments();
        sVar.H(arguments != null ? arguments.getString("pin") : null);
    }

    public static final void j(SwitchPinLockFragment this$0, View view) {
        m.g(this$0, "this$0");
        e.j.f.m.k(this$0, R.id.appLockSettingsFragment, false, 2, null);
    }

    private final void k() {
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(e.j.a.amountInput))).setOnDigitPressedListener(this.f11138f);
    }

    public static final void l(SwitchPinLockFragment this$0, p pVar) {
        m.g(this$0, "this$0");
        if (pVar != null) {
            this$0.h(pVar);
        }
    }

    public static final void m(SwitchPinLockFragment this$0, Boolean bool) {
        m.g(this$0, "this$0");
        if (bool != null) {
            View view = this$0.getView();
            ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(bool.booleanValue());
        }
    }

    public static final void n(SwitchPinLockFragment this$0, x xVar) {
        m.g(this$0, "this$0");
        if (xVar != null) {
            View view = this$0.getView();
            PinCodeIndicator pinCodeIndicator = (PinCodeIndicator) (view == null ? null : view.findViewById(e.j.a.pinCodeIndicator));
            if (pinCodeIndicator == null) {
                return;
            }
            pinCodeIndicator.e();
        }
    }

    public static final void o(SwitchPinLockFragment this$0, String str) {
        m.g(this$0, "this$0");
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.deviceLockAuthMethodPinSet(AnalyticsEvent.Companion));
        e.j.f.m.k(this$0, R.id.appLockSettingsFragment, false, 2, null);
    }

    private final void p() {
        View view = getView();
        ((PinCodeIndicator) (view == null ? null : view.findViewById(e.j.a.pinCodeIndicator))).setOnFullPinListener(new d());
    }

    public static /* synthetic */ void q(SwitchPinLockFragment switchPinLockFragment, Boolean bool) {
        m(switchPinLockFragment, bool);
    }

    public static /* synthetic */ void r(SwitchPinLockFragment switchPinLockFragment, String str) {
        o(switchPinLockFragment, str);
    }

    public static /* synthetic */ void s(SwitchPinLockFragment switchPinLockFragment, x xVar) {
        n(switchPinLockFragment, xVar);
    }

    public static /* synthetic */ void t(SwitchPinLockFragment switchPinLockFragment, View view) {
        j(switchPinLockFragment, view);
    }

    public static /* synthetic */ void u(SwitchPinLockFragment switchPinLockFragment, p pVar) {
        l(switchPinLockFragment, pVar);
    }

    private final void v() {
        s sVar = this.f11136d;
        if (sVar == null) {
            m.w("viewModel");
            throw null;
        }
        if (sVar.w() == null) {
            AuthenticationHelper.authenticateWithBiometricPrompt$default(getAuthenticationHelper$app_productionRelease(), EncryptionMethod.DECRYPTION, new f(), null, 4, null);
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 6, null);
    }

    public final AuthenticationHelper getAuthenticationHelper$app_productionRelease() {
        AuthenticationHelper authenticationHelper = this.f11134b;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        m.w("authenticationHelper");
        throw null;
    }

    public final GenericViewModelFactory<s> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<s> genericViewModelFactory = this.f11135c;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.activity_setup_pin_lock, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }
}