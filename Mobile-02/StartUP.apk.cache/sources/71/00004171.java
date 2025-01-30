package com.toshi.view.activity.pin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import c.h.k.d0;
import c.h.k.v;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Activity_CommonKt;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import com.toshi.view.custom.PinCodeIndicator;
import e.j.n.p3.p;
import e.j.n.p3.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.l0.a0;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* compiled from: SetupPinLockActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001a\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\u0016\u0010,\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010+¨\u0006/"}, d2 = {"Lcom/toshi/view/activity/pin/SetupPinLockActivity;", "Ldagger/android/g/b;", "Lkotlin/x;", "g", "()V", "q", "i", "p", "k", "", "newChar", "f", "(C)V", "l", "Le/j/n/p3/p;", "pinStatus", "e", "(Le/j/n/p3/p;)V", "", "pin", Constants.URL_CAMPAIGN, "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "com/toshi/view/activity/pin/SetupPinLockActivity$b", "Lcom/toshi/view/activity/pin/SetupPinLockActivity$b;", "amountClickedListener", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Le/j/n/p3/q;", "b", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Le/j/l/v/a;", "d", "Lkotlin/h;", "()Le/j/l/v/a;", "pinResource", "Le/j/n/p3/q;", "viewModel", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SetupPinLockActivity extends dagger.android.g.b {
    public static final a a = new a(null);

    /* renamed from: b */
    public GenericViewModelFactory<q> f11130b;

    /* renamed from: c */
    private q f11131c;

    /* renamed from: d */
    private final kotlin.h f11132d;

    /* renamed from: e */
    private final b f11133e;

    /* compiled from: SetupPinLockActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SetupPinLockActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements NumberKeyboardInputView.OnDigitPressedListener {

        /* compiled from: SetupPinLockActivity.kt */
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
            SetupPinLockActivity.this = r1;
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
                    SetupPinLockActivity setupPinLockActivity = SetupPinLockActivity.this;
                    p1 = a0.p1(digit.getDescription());
                    setupPinLockActivity.f(p1);
                    xVar = x.a;
                    break;
                case 11:
                    ((PinCodeIndicator) SetupPinLockActivity.this.findViewById(e.j.a.pinCodeIndicator)).g();
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

    /* compiled from: SetupPinLockActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends o implements kotlin.e0.c.l<String, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            SetupPinLockActivity.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(String str) {
            invoke2(str);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(String it) {
            m.g(it, "it");
            q qVar = SetupPinLockActivity.this.f11131c;
            if (qVar != null) {
                qVar.t(it);
            } else {
                m.w("viewModel");
                throw null;
            }
        }
    }

    /* compiled from: SetupPinLockActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends o implements kotlin.e0.c.a<e.j.l.v.a> {
        public static final d a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final e.j.l.v.a invoke() {
            return new e.j.l.v.a();
        }
    }

    public SetupPinLockActivity() {
        kotlin.h b2;
        b2 = kotlin.k.b(d.a);
        this.f11132d = b2;
        this.f11133e = new b();
    }

    private final void c(String str) {
        Intent intent = new Intent();
        intent.putExtra("pin", str);
        setResult(-1, intent);
        finish();
    }

    private final e.j.l.v.a d() {
        return (e.j.l.v.a) this.f11132d.getValue();
    }

    private final void e(p pVar) {
        int b2 = d().b(this, pVar);
        int i2 = e.j.a.pinInfo;
        ((TextView) findViewById(i2)).setTextColor(b2);
        ((TextView) findViewById(i2)).setText(d().a(this, pVar));
    }

    public final void f(char c2) {
        int i2 = e.j.a.pinCodeIndicator;
        String pin = ((PinCodeIndicator) findViewById(i2)).getPin();
        if (pin.length() == 6) {
            return;
        }
        String o = m.o(pin, Character.valueOf(c2));
        q qVar = this.f11131c;
        if (qVar != null) {
            boolean a2 = qVar.a(o);
            q qVar2 = this.f11131c;
            if (qVar2 != null) {
                qVar2.u(a2);
                ((PinCodeIndicator) findViewById(i2)).c(String.valueOf(c2), a2);
                return;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    private final void g() {
        v.w0((ConstraintLayout) findViewById(e.j.a.J5), new c.h.k.q() { // from class: com.toshi.view.activity.pin.c
            @Override // c.h.k.q
            public final d0 a(View view, d0 d0Var) {
                return SetupPinLockActivity.t(view, d0Var);
            }
        });
        q();
        i();
        p();
        k();
        l();
        int i2 = e.j.a.amountInput;
        ((NumberKeyboardInputView) findViewById(i2)).setTextColorResId(R.color.primary_black);
        ((NumberKeyboardInputView) findViewById(i2)).setTextSizeResId(R.dimen.text_size_28);
        ((NumberKeyboardInputView) findViewById(i2)).setHideDecimal(true);
    }

    public static final d0 h(View view, d0 d0Var) {
        m.f(view, "view");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), d0Var.i());
        return d0Var;
    }

    private final void i() {
        ((ImageView) findViewById(e.j.a.backButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.activity.pin.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetupPinLockActivity.u(SetupPinLockActivity.this, view);
            }
        });
    }

    public static final void j(SetupPinLockActivity this$0, View view) {
        m.g(this$0, "this$0");
        this$0.finish();
    }

    private final void k() {
        ((NumberKeyboardInputView) findViewById(e.j.a.amountInput)).setOnDigitPressedListener(this.f11133e);
    }

    private final void l() {
        q qVar = this.f11131c;
        if (qVar != null) {
            qVar.l().g(this, new androidx.lifecycle.v() { // from class: com.toshi.view.activity.pin.e
                @Override // androidx.lifecycle.v
                public final void a(Object obj) {
                    SetupPinLockActivity.v(SetupPinLockActivity.this, (String) obj);
                }
            });
            q qVar2 = this.f11131c;
            if (qVar2 != null) {
                qVar2.k().g(this, new androidx.lifecycle.v() { // from class: com.toshi.view.activity.pin.a
                    @Override // androidx.lifecycle.v
                    public final void a(Object obj) {
                        SetupPinLockActivity.r(SetupPinLockActivity.this, (p) obj);
                    }
                });
                q qVar3 = this.f11131c;
                if (qVar3 != null) {
                    qVar3.i().g(this, new androidx.lifecycle.v() { // from class: com.toshi.view.activity.pin.b
                        @Override // androidx.lifecycle.v
                        public final void a(Object obj) {
                            SetupPinLockActivity.s(SetupPinLockActivity.this, (x) obj);
                        }
                    });
                    return;
                } else {
                    m.w("viewModel");
                    throw null;
                }
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    public static final void m(SetupPinLockActivity this$0, String str) {
        m.g(this$0, "this$0");
        if (str != null) {
            this$0.c(str);
        }
    }

    public static final void n(SetupPinLockActivity this$0, p pVar) {
        m.g(this$0, "this$0");
        if (pVar != null) {
            this$0.e(pVar);
        }
    }

    public static final void o(SetupPinLockActivity this$0, x xVar) {
        PinCodeIndicator pinCodeIndicator;
        m.g(this$0, "this$0");
        if (xVar == null || (pinCodeIndicator = (PinCodeIndicator) this$0.findViewById(e.j.a.pinCodeIndicator)) == null) {
            return;
        }
        pinCodeIndicator.e();
    }

    private final void p() {
        ((PinCodeIndicator) findViewById(e.j.a.pinCodeIndicator)).setOnFullPinListener(new c());
    }

    private final void q() {
        b0 a2 = e0.b(this, getViewModelFactory$app_productionRelease()).a(q.class);
        m.f(a2, "of(this, viewModelFactory).get(T::class.java)");
        this.f11131c = (q) a2;
    }

    public static /* synthetic */ void r(SetupPinLockActivity setupPinLockActivity, p pVar) {
        n(setupPinLockActivity, pVar);
    }

    public static /* synthetic */ void s(SetupPinLockActivity setupPinLockActivity, x xVar) {
        o(setupPinLockActivity, xVar);
    }

    public static /* synthetic */ d0 t(View view, d0 d0Var) {
        return h(view, d0Var);
    }

    public static /* synthetic */ void u(SetupPinLockActivity setupPinLockActivity, View view) {
        j(setupPinLockActivity, view);
    }

    public static /* synthetic */ void v(SetupPinLockActivity setupPinLockActivity, String str) {
        m(setupPinLockActivity, str);
    }

    public final GenericViewModelFactory<q> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<q> genericViewModelFactory = this.f11130b;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // dagger.android.g.b, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(PKIFailureInfo.certRevoked, PKIFailureInfo.certRevoked);
        setContentView(R.layout.activity_setup_pin_lock);
        Activity_CommonKt.enableFullscreenWindow(this);
        g();
    }
}