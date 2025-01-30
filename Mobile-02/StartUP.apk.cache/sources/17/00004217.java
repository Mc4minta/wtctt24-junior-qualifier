package com.toshi.view.custom.recoveryPhrase.keyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.google.android.flexbox.FlexboxLayout;
import com.toshi.view.custom.o;
import com.toshi.view.custom.recoveryPhrase.keyboard.m.a;
import e.j.f.y;
import h.c.m0.n;
import h.c.s;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: RecoveryPhraseKeyboard.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J%\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J-\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u0004\u0018\u00010\"2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00162\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0016H\u0002¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020-H\u0002¢\u0006\u0004\b8\u0010/J\u000f\u00109\u001a\u00020-H\u0002¢\u0006\u0004\b9\u0010/J\u000f\u0010:\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010\bJ\u000f\u0010;\u001a\u00020&H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020&H\u0002¢\u0006\u0004\b=\u0010<J\u0017\u0010@\u001a\u00020&2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010DJ\u001f\u0010I\u001a\u00020\u00042\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020\u00042\u0006\u0010F\u001a\u00020E2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u00042\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00042\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bO\u0010NJ\r\u0010P\u001a\u00020\u0004¢\u0006\u0004\bP\u0010\bJ\r\u0010Q\u001a\u00020\u0004¢\u0006\u0004\bQ\u0010\bJ\r\u0010R\u001a\u00020\u0004¢\u0006\u0004\bR\u0010\bJ\r\u0010S\u001a\u00020\u0004¢\u0006\u0004\bS\u0010\bJ\u0019\u0010V\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010TH\u0014¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020TH\u0014¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u0004H\u0014¢\u0006\u0004\bZ\u0010\bR*\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010cR\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010eR\u0016\u0010\n\u001a\u00020f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010gR\u001d\u0010l\u001a\u00020h8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010i\u001a\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lcom/toshi/view/custom/recoveryPhrase/keyboard/RecoveryPhraseKeyboard;", "Landroid/widget/LinearLayout;", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/x;", "J", "(Landroid/util/AttributeSet;)V", "I", "()V", "Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a;", "keyboardLayout", "a0", "(Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a;)V", "d", "", "", "keys", "a", "(Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a;Ljava/util/List;)V", "e", "f", "b", "", "isFirstRow", "isSecondRow", "isLastRow", "Lcom/google/android/flexbox/FlexboxLayout;", "j", "(ZZZ)Lcom/google/android/flexbox/FlexboxLayout;", "flexboxLayout", Constants.URL_CAMPAIGN, "(Lcom/google/android/flexbox/FlexboxLayout;ZZZ)V", "parent", "key", "Landroid/view/View;", "g", "(Lcom/google/android/flexbox/FlexboxLayout;Ljava/lang/Object;)Landroid/view/View;", "", "Landroid/widget/TextView;", "y", "(Ljava/lang/String;)Landroid/widget/TextView;", "Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a$b;", "action", "p", "(Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a$b;)Landroid/view/View;", "Lcom/toshi/view/custom/o;", "l", "()Lcom/toshi/view/custom/o;", "Landroid/view/MotionEvent;", "event", "G", "(Landroid/view/MotionEvent;)Z", "V", "()Z", "Z", "()Lkotlin/x;", "v", "q", "i", "w", "()Landroid/widget/TextView;", "s", "Landroid/content/Context;", "context", "t", "(Landroid/content/Context;)Landroid/widget/TextView;", "input", "E", "(Ljava/lang/Object;)V", "Landroid/widget/EditText;", "editText", "", "charSequence", "F", "(Landroid/widget/EditText;Ljava/lang/CharSequence;)V", "D", "(Landroid/widget/EditText;Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a$b;)V", "B", "(Landroid/widget/EditText;)V", "h", "U", "H", "C", "A", "Landroid/os/Parcelable;", ApiConstants.STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "onSaveInstanceState", "()Landroid/os/Parcelable;", "onDetachedFromWindow", "Lkotlin/Function0;", "Lkotlin/e0/c/a;", "getOnNextActionClickListener", "()Lkotlin/e0/c/a;", "setOnNextActionClickListener", "(Lkotlin/e0/c/a;)V", "onNextActionClickListener", "Lh/c/k0/b;", "Lh/c/k0/b;", "backspaceSubscription", "Ljava/lang/String;", "Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a$e;", "Lcom/toshi/view/custom/recoveryPhrase/keyboard/m/a$e;", "Lcom/toshi/view/custom/recoveryPhrase/keyboard/l;", "Lkotlin/h;", "getBuilder", "()Lcom/toshi/view/custom/recoveryPhrase/keyboard/l;", "builder", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RecoveryPhraseKeyboard extends LinearLayout {
    public static final a a = new a(null);

    /* renamed from: b */
    private static final int f11193b = -2061391210;

    /* renamed from: c */
    private final kotlin.h f11194c;

    /* renamed from: d */
    private a.e f11195d;

    /* renamed from: e */
    private h.c.k0.b f11196e;

    /* renamed from: f */
    private String f11197f;

    /* renamed from: g */
    private kotlin.e0.c.a<x> f11198g;

    /* compiled from: RecoveryPhraseKeyboard.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RecoveryPhraseKeyboard.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.b.values().length];
            iArr[a.b.BACKSPACE.ordinal()] = 1;
            iArr[a.b.SHIFT.ordinal()] = 2;
            iArr[a.b.LANGUAGE.ordinal()] = 3;
            iArr[a.b.SPACEBAR.ordinal()] = 4;
            iArr[a.b.RETURN.ordinal()] = 5;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPhraseKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.h b2;
        m.g(context, "context");
        m.g(attrs, "attrs");
        b2 = kotlin.k.b(k.a);
        this.f11194c = b2;
        this.f11195d = a.e.QWERTY;
        this.f11197f = "none";
        J(attrs);
        I();
    }

    private final void B(EditText editText) {
        editText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0));
    }

    private final void D(EditText editText, a.b bVar) {
        int i2 = b.a[bVar.ordinal()];
        if (i2 == 1) {
            B(editText);
        } else if (i2 != 4) {
        } else {
            h(editText);
        }
    }

    private final void E(Object obj) {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        View currentFocus = ((androidx.appcompat.app.d) context).getWindow().getCurrentFocus();
        if (currentFocus == null || (currentFocus.getClass() instanceof EditText)) {
            return;
        }
        EditText editText = (EditText) currentFocus;
        if (obj instanceof CharSequence) {
            F(editText, (CharSequence) obj);
        } else if (obj instanceof a.b) {
            D(editText, (a.b) obj);
        }
    }

    private final void F(EditText editText, CharSequence charSequence) {
        editText.getText().insert(editText.getSelectionStart(), charSequence);
    }

    private final boolean G(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Z();
            return false;
        }
        return false;
    }

    private final void I() {
        setOrientation(1);
        setBackgroundColor(y.b(this, R.color.sectioned_recyclerview_background));
        b0(this, null, 1, null);
    }

    private final void J(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.j.b.h1);
        m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.RecoveryPhraseKeyboard)");
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "none";
        }
        this.f11197f = string;
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void K(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view) {
        z(recoveryPhraseKeyboard, view);
    }

    public static /* synthetic */ void L(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view) {
        x(recoveryPhraseKeyboard, view);
    }

    public static /* synthetic */ void M(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view) {
        r(recoveryPhraseKeyboard, view);
    }

    public static /* synthetic */ boolean O(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view, MotionEvent motionEvent) {
        return m(recoveryPhraseKeyboard, view, motionEvent);
    }

    public static /* synthetic */ void P(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view) {
        u(recoveryPhraseKeyboard, view);
    }

    public static /* synthetic */ void Q(RecoveryPhraseKeyboard recoveryPhraseKeyboard, Boolean bool) {
        X(recoveryPhraseKeyboard, bool);
    }

    public static /* synthetic */ void R(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view) {
        n(recoveryPhraseKeyboard, view);
    }

    public static /* synthetic */ void S(Throwable th) {
        Y(th);
    }

    public static /* synthetic */ boolean T(RecoveryPhraseKeyboard recoveryPhraseKeyboard, View view) {
        return o(recoveryPhraseKeyboard, view);
    }

    private final boolean V() {
        h.c.k0.b bVar = this.f11196e;
        if (bVar != null && bVar != null) {
            bVar.dispose();
        }
        this.f11196e = s.just(Boolean.TRUE).repeatWhen(new n() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h.c.x W;
                W = RecoveryPhraseKeyboard.W((s) obj);
                return W;
            }
        }).observeOn(h.c.j0.c.a.b()).subscribe(new h.c.m0.f() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.g
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                RecoveryPhraseKeyboard.Q(RecoveryPhraseKeyboard.this, (Boolean) obj);
            }
        }, new h.c.m0.f() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.i
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                RecoveryPhraseKeyboard.S((Throwable) obj);
            }
        });
        return true;
    }

    public static final h.c.x W(s it) {
        m.g(it, "it");
        return it.delay(50L, TimeUnit.MILLISECONDS);
    }

    public static final void X(RecoveryPhraseKeyboard this$0, Boolean bool) {
        m.g(this$0, "this$0");
        this$0.E(a.b.BACKSPACE);
    }

    public static final void Y(Throwable th) {
        l.a.a.f(th, "Error while holding backspace", new Object[0]);
    }

    private final x Z() {
        h.c.k0.b bVar = this.f11196e;
        if (bVar == null) {
            return null;
        }
        bVar.dispose();
        return x.a;
    }

    private final void a(com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar, List<? extends Object> list) {
        FlexboxLayout k2 = k(this, true, false, false, 6, null);
        for (Object obj : list) {
            View g2 = g(k2, obj);
            boolean b2 = aVar.b(obj);
            l builder = getBuilder();
            if (g2 == null) {
                return;
            }
            builder.j(b2, g2, obj);
        }
    }

    private final void a0(com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar) {
        removeAllViews();
        d(aVar);
    }

    private final void b(com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar, List<? extends Object> list) {
        FlexboxLayout k2 = k(this, false, false, true, 3, null);
        for (Object obj : list) {
            View g2 = g(k2, obj);
            boolean b2 = aVar.b(obj);
            l builder = getBuilder();
            if (g2 == null) {
                return;
            }
            builder.j(b2, g2, obj);
        }
    }

    static /* synthetic */ void b0(RecoveryPhraseKeyboard recoveryPhraseKeyboard, com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = new a.f();
        }
        recoveryPhraseKeyboard.a0(aVar);
    }

    private final void c(FlexboxLayout flexboxLayout, boolean z, boolean z2, boolean z3) {
        int pxSize;
        int pxSize2 = z ? View_CommonKt.getPxSize(this, R.dimen.view_size_12) : 0;
        if (z2) {
            pxSize = View_CommonKt.getPxSize(this, R.dimen.view_size_8) + (View_CommonKt.getPxSize(this, R.dimen.keyboard_key_width) / 2);
        } else {
            pxSize = View_CommonKt.getPxSize(this, R.dimen.view_size_8);
        }
        flexboxLayout.setPadding(pxSize, pxSize2, pxSize, z3 ? View_CommonKt.getPxSize(this, R.dimen.view_size_12) : View_CommonKt.getPxSize(this, R.dimen.view_size_8));
    }

    private final void d(com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar) {
        int i2 = 0;
        for (Object obj : aVar.a()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            com.toshi.view.custom.recoveryPhrase.keyboard.m.b bVar = (com.toshi.view.custom.recoveryPhrase.keyboard.m.b) obj;
            if (i2 == 0) {
                a(aVar, bVar.a());
            } else if (i2 == 1) {
                e(aVar, bVar.a());
            } else if (i2 == 2) {
                f(aVar, bVar.a());
            } else if (i2 == 3) {
                b(aVar, bVar.a());
            }
            i2 = i3;
        }
    }

    private final void e(com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar, List<? extends Object> list) {
        FlexboxLayout k2 = k(this, false, true, false, 5, null);
        for (Object obj : list) {
            View g2 = g(k2, obj);
            boolean b2 = aVar.b(obj);
            l builder = getBuilder();
            if (g2 == null) {
                return;
            }
            builder.j(b2, g2, obj);
        }
    }

    private final void f(com.toshi.view.custom.recoveryPhrase.keyboard.m.a aVar, List<? extends Object> list) {
        FlexboxLayout k2 = k(this, false, false, false, 7, null);
        for (Object obj : list) {
            View g2 = g(k2, obj);
            boolean b2 = aVar.b(obj);
            l builder = getBuilder();
            if (g2 == null) {
                return;
            }
            builder.j(b2, g2, obj);
        }
    }

    private final View g(FlexboxLayout flexboxLayout, Object obj) {
        View p;
        if (obj instanceof String) {
            p = y((String) obj);
        } else {
            p = obj instanceof a.b ? p((a.b) obj) : null;
        }
        if (p == null) {
            return null;
        }
        flexboxLayout.addView(p);
        return p;
    }

    private final l getBuilder() {
        return (l) this.f11194c.getValue();
    }

    private final void h(EditText editText) {
        editText.getText().insert(editText.getSelectionStart(), " ");
    }

    private final void i() {
        int F;
        a.e eVar = this.f11195d;
        a.e[] values = a.e.values();
        F = kotlin.a0.n.F(values, eVar);
        int i2 = F + 1;
        if (i2 >= values.length) {
            i2 = 0;
        }
        a.e eVar2 = values[i2];
        this.f11195d = eVar2;
        a0(com.toshi.view.custom.recoveryPhrase.keyboard.m.a.a.a(eVar2));
    }

    private final FlexboxLayout j(boolean z, boolean z2, boolean z3) {
        FlexboxLayout flexboxLayout = new FlexboxLayout(getContext());
        flexboxLayout.setClipToPadding(false);
        setGravity(17);
        c(flexboxLayout, z, z2, z3);
        addView(flexboxLayout);
        return flexboxLayout;
    }

    static /* synthetic */ FlexboxLayout k(RecoveryPhraseKeyboard recoveryPhraseKeyboard, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            z3 = false;
        }
        return recoveryPhraseKeyboard.j(z, z2, z3);
    }

    private final o l() {
        l builder = getBuilder();
        Context context = getContext();
        m.f(context, "context");
        o a2 = builder.a(context);
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryPhraseKeyboard.R(RecoveryPhraseKeyboard.this, view);
            }
        });
        a2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return RecoveryPhraseKeyboard.T(RecoveryPhraseKeyboard.this, view);
            }
        });
        a2.setOnTouchListener(new View.OnTouchListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return RecoveryPhraseKeyboard.O(RecoveryPhraseKeyboard.this, view, motionEvent);
            }
        });
        return a2;
    }

    public static final boolean m(RecoveryPhraseKeyboard this$0, View view, MotionEvent event) {
        m.g(this$0, "this$0");
        m.f(event, "event");
        return this$0.G(event);
    }

    public static final void n(RecoveryPhraseKeyboard this$0, View view) {
        m.g(this$0, "this$0");
        this$0.E(a.b.BACKSPACE);
    }

    public static final boolean o(RecoveryPhraseKeyboard this$0, View view) {
        m.g(this$0, "this$0");
        return this$0.V();
    }

    private final View p(a.b bVar) {
        int i2 = b.a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return s();
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return w();
                }
                return q();
            }
            return v();
        }
        return l();
    }

    private final o q() {
        l builder = getBuilder();
        Context context = getContext();
        m.f(context, "context");
        o b2 = builder.b(context);
        b2.setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryPhraseKeyboard.M(RecoveryPhraseKeyboard.this, view);
            }
        });
        return b2;
    }

    public static final void r(RecoveryPhraseKeyboard this$0, View view) {
        m.g(this$0, "this$0");
        this$0.i();
    }

    private final TextView s() {
        if (m.c(this.f11197f, "next")) {
            Context context = getContext();
            m.f(context, "context");
            return t(context);
        }
        l builder = getBuilder();
        Context context2 = getContext();
        m.f(context2, "context");
        return builder.e(context2);
    }

    private final TextView t(Context context) {
        TextView d2 = getBuilder().d(context);
        d2.setId(f11193b);
        d2.setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryPhraseKeyboard.P(RecoveryPhraseKeyboard.this, view);
            }
        });
        return d2;
    }

    public static final void u(RecoveryPhraseKeyboard this$0, View view) {
        m.g(this$0, "this$0");
        kotlin.e0.c.a<x> onNextActionClickListener = this$0.getOnNextActionClickListener();
        if (onNextActionClickListener == null) {
            return;
        }
        onNextActionClickListener.invoke();
    }

    private final o v() {
        l builder = getBuilder();
        Context context = getContext();
        m.f(context, "context");
        return builder.f(context);
    }

    private final TextView w() {
        l builder = getBuilder();
        Context context = getContext();
        m.f(context, "context");
        TextView g2 = builder.g(context);
        g2.setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryPhraseKeyboard.L(RecoveryPhraseKeyboard.this, view);
            }
        });
        return g2;
    }

    public static final void x(RecoveryPhraseKeyboard this$0, View view) {
        m.g(this$0, "this$0");
        this$0.E(a.b.SPACEBAR);
    }

    private final TextView y(String str) {
        l builder = getBuilder();
        Context context = getContext();
        m.f(context, "context");
        TextView h2 = builder.h(context, str);
        h2.setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.recoveryPhrase.keyboard.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveryPhraseKeyboard.K(RecoveryPhraseKeyboard.this, view);
            }
        });
        return h2;
    }

    public static final void z(RecoveryPhraseKeyboard this$0, View view) {
        m.g(this$0, "this$0");
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        CharSequence text = ((TextView) view).getText();
        m.f(text, "text");
        this$0.E(text);
    }

    public final void A() {
        TextView textView = (TextView) findViewById(f11193b);
        if (textView == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.keyboard_action_key_background);
        textView.setTextColor(y.b(textView, R.color.keyboard_tex_color_disabled));
        textView.setEnabled(false);
    }

    public final void C() {
        TextView textView = (TextView) findViewById(f11193b);
        if (textView == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.keyboard_with_action_key_background);
        textView.setTextColor(y.b(textView, R.color.textColorContrast));
        textView.setEnabled(true);
    }

    public final void H() {
        setVisibility(8);
    }

    public final void U() {
        setVisibility(0);
    }

    public final kotlin.e0.c.a<x> getOnNextActionClickListener() {
        return this.f11198g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        h.c.k0.b bVar = this.f11196e;
        if (bVar != null) {
            bVar.dispose();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Serializable serializable = bundle.getSerializable("keyboardLayout");
            a.e eVar = serializable instanceof a.e ? (a.e) serializable : null;
            if (eVar == null) {
                eVar = a.e.QWERTY;
            }
            this.f11195d = eVar;
            super.onRestoreInstanceState(bundle.getParcelable("superState"));
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("keyboardLayout", this.f11195d);
        bundle.putParcelable("superState", super.onSaveInstanceState());
        return bundle;
    }

    public final void setOnNextActionClickListener(kotlin.e0.c.a<x> aVar) {
        this.f11198g = aVar;
    }
}