package com.toshi.view.fragment.r0;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import c.h.k.q;
import c.h.k.v;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.toshi.view.custom.PinCodeIndicator;
import com.toshi.view.custom.SpinnerOverlayLayout;
import com.toshi.view.fragment.r0.e;
import e.j.n.p3.n;
import h.c.a0;
import h.c.b0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: PinLockDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u000b*\u00012\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b9\u0010\u0006J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0006R\u0016\u0010#\u001a\u00020 8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R(\u00101\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/toshi/view/fragment/r0/e;", "Lcom/toshi/view/fragment/r0/d;", "Lkotlin/x;", "u", "()Lkotlin/x;", "init", "()V", "initViewModel", "initClickListener", "r", "q", "p", "", "value", "o", "(C)V", "n", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lh/c/a0;", "kotlin.jvm.PlatformType", "f", "Lh/c/a0;", "mainScheduler", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/p3/n;", "j", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "com/toshi/view/fragment/r0/e$b", "h", "Lcom/toshi/view/fragment/r0/e$b;", "amountClickedListener", "g", "Le/j/n/p3/n;", "viewModel", "<init>", "e", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class e extends com.toshi.view.fragment.r0.d {

    /* renamed from: e */
    public static final a f11380e = new a(null);

    /* renamed from: g */
    private n f11382g;

    /* renamed from: j */
    public GenericViewModelFactory<n> f11384j;

    /* renamed from: f */
    private final a0 f11381f = h.c.j0.c.a.b();

    /* renamed from: h */
    private final b f11383h = new b();

    /* compiled from: PinLockDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PinLockDialog.kt */
    /* loaded from: classes2.dex */
    public static final class b implements NumberKeyboardInputView.OnDigitPressedListener {

        /* compiled from: PinLockDialog.kt */
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

        b() {
            e.this = r1;
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
                    e eVar = e.this;
                    p1 = kotlin.l0.a0.p1(digit.getDescription());
                    eVar.o(p1);
                    xVar = x.a;
                    break;
                case 11:
                    View view = e.this.getView();
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

    /* compiled from: PinLockDialog.kt */
    /* loaded from: classes2.dex */
    public static final class c extends o implements l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            e.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            m.g(it, "it");
            e.this.e();
        }
    }

    /* compiled from: PinLockDialog.kt */
    /* loaded from: classes2.dex */
    public static final class d extends o implements l<String, x> {

        /* compiled from: PinLockDialog.kt */
        /* loaded from: classes2.dex */
        public static final class a extends o implements l<Throwable, x> {
            final /* synthetic */ e a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(1);
                this.a = eVar;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(Throwable th) {
                invoke2(th);
                return x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(Throwable it) {
                m.g(it, "it");
                this.a.n();
            }
        }

        /* compiled from: PinLockDialog.kt */
        /* loaded from: classes2.dex */
        public static final class b extends o implements l<Boolean, x> {
            final /* synthetic */ e a;

            /* renamed from: b */
            final /* synthetic */ String f11385b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(e eVar, String str) {
                super(1);
                this.a = eVar;
                this.f11385b = str;
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
                invoke2(bool);
                return x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(Boolean valid) {
                m.f(valid, "valid");
                if (valid.booleanValue()) {
                    this.a.f(new e.j.d.d(this.f11385b));
                } else {
                    this.a.n();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            e.this = r1;
        }

        public static final void a(e this$0, h.c.k0.b bVar) {
            m.g(this$0, "this$0");
            View view = this$0.getView();
            ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(true);
        }

        public static final void b(e this$0) {
            m.g(this$0, "this$0");
            View view = this$0.getView();
            ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(false);
        }

        public static /* synthetic */ void c(e eVar) {
            b(eVar);
        }

        public static /* synthetic */ void d(e eVar, h.c.k0.b bVar) {
            a(eVar, bVar);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(String str) {
            invoke2(str);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String pin) {
            m.g(pin, "pin");
            n nVar = e.this.f11382g;
            if (nVar != null) {
                b0<Boolean> observeOn = nVar.a(pin).observeOn(e.this.f11381f);
                final e eVar = e.this;
                b0<Boolean> doOnSubscribe = observeOn.doOnSubscribe(new h.c.m0.f() { // from class: com.toshi.view.fragment.r0.c
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        e.d.d(e.this, (h.c.k0.b) obj);
                    }
                });
                final e eVar2 = e.this;
                Object as = doOnSubscribe.doAfterTerminate(new h.c.m0.a() { // from class: com.toshi.view.fragment.r0.b
                    @Override // h.c.m0.a
                    public final void run() {
                        e.d.c(e.this);
                    }
                }).as(com.uber.autodispose.d.a(e.this.getOnDestroyScopeProvider()));
                m.f(as, "viewModel.checkPin(pin)\n                .observeOn(mainScheduler)\n                .doOnSubscribe { spinnerOverlay.isOverlayVisible(true) }\n                .doAfterTerminate { spinnerOverlay.isOverlayVisible(false) }\n                .`as`(autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new a(e.this), new b(e.this, pin));
                return;
            }
            m.w("viewModel");
            throw null;
        }
    }

    public final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final void init() {
        initViewModel();
        initClickListener();
        r();
        q();
        p();
        View view = getView();
        View backButton = view == null ? null : view.findViewById(e.j.a.backButton);
        m.f(backButton, "backButton");
        backButton.setVisibility(g() ? 0 : 8);
        View view2 = getView();
        ((NumberKeyboardInputView) (view2 == null ? null : view2.findViewById(e.j.a.amountInput))).setTextColorResId(R.color.primary_black);
        View view3 = getView();
        ((NumberKeyboardInputView) (view3 == null ? null : view3.findViewById(e.j.a.amountInput))).setTextSizeResId(R.dimen.text_size_28);
        View view4 = getView();
        ((NumberKeyboardInputView) (view4 != null ? view4.findViewById(e.j.a.amountInput) : null)).setHideDecimal(true);
    }

    private final void initClickListener() {
        View view = getView();
        View backButton = view == null ? null : view.findViewById(e.j.a.backButton);
        m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new c(), 1, null);
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a2 = new d0(this, getViewModelFactory()).a(n.class);
        m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11382g = (n) a2;
    }

    public final void n() {
        Integer a2 = e.j.f.m.a(this, R.color.errorColor);
        if (a2 != null) {
            int intValue = a2.intValue();
            View view = getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.pinInfo))).setTextColor(intValue);
        }
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.pinInfo))).setText(R.string.incorrect);
        View view3 = getView();
        ((PinCodeIndicator) (view3 != null ? view3.findViewById(e.j.a.pinCodeIndicator) : null)).e();
    }

    public final void o(char c2) {
        View view = getView();
        ((PinCodeIndicator) (view == null ? null : view.findViewById(e.j.a.pinCodeIndicator))).b(String.valueOf(c2));
    }

    private final void p() {
        View view = getView();
        ((NumberKeyboardInputView) (view == null ? null : view.findViewById(e.j.a.amountInput))).setOnDigitPressedListener(this.f11383h);
    }

    private final void q() {
        View view = getView();
        ((PinCodeIndicator) (view == null ? null : view.findViewById(e.j.a.pinCodeIndicator))).setOnFullPinListener(new d());
    }

    private final void r() {
        View view = getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.pinInfo))).setText(R.string.type_your_pin);
    }

    public static /* synthetic */ c.h.k.d0 s(View view, c.h.k.d0 d0Var) {
        return t(view, d0Var);
    }

    public static final c.h.k.d0 t(View v, c.h.k.d0 d0Var) {
        m.f(v, "v");
        v.setPadding(v.getPaddingLeft(), v.getPaddingTop(), v.getPaddingRight(), d0Var.i());
        return d0Var;
    }

    private final x u() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return null;
        }
        window.setLayout(-1, -1);
        return x.a;
    }

    public final GenericViewModelFactory<n> getViewModelFactory() {
        GenericViewModelFactory<n> genericViewModelFactory = this.f11384j;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        BaseApplication.Companion.getComponent().inject(this);
        super.onCreate(bundle);
        setStyle(0, R.style.FullscreenDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        return inflater.inflate(R.layout.fragment_pin_lock, viewGroup);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        u();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        v.w0(view, new q() { // from class: com.toshi.view.fragment.r0.a
            @Override // c.h.k.q
            public final c.h.k.d0 a(View view2, c.h.k.d0 d0Var) {
                return e.s(view2, d0Var);
            }
        });
        init();
    }
}