package com.toshi.view.custom;

import android.content.Context;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.l0.y;
import kotlin.x;
import org.toshi.R;

/* compiled from: AddressBarInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Y2\u00020\u0001:\u0001YB\u001d\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U¢\u0006\u0004\bW\u0010XJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\bR*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R0\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010\u0016\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00158\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u0018R*\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010\"\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R0\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00104\u001a\u0004\bE\u00106\"\u0004\bF\u00108R\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010IR\u0016\u0010L\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00101R0\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00104\u001a\u0004\bM\u00106\"\u0004\bN\u00108R\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010PR\u0016\u0010R\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010P¨\u0006Z"}, d2 = {"Lcom/toshi/view/custom/AddressBarInputView;", "Landroid/widget/LinearLayout;", "Lkotlin/x;", "z", "()V", "y", "", "x", "()Z", "f", "w", "L", "h", "N", "j", "O", "k", "M", "i", "I", "g", "", "url", "setStaticUrl", "(Ljava/lang/String;)V", "setClearButtonVisibility", "e", "Landroid/view/KeyEvent;", "event", "dispatchKeyEventPreIme", "(Landroid/view/KeyEvent;)Z", "clearFocus", "l", "Lkotlin/Function0;", "Lkotlin/e0/c/a;", "getOnHomeClickedListener", "()Lkotlin/e0/c/a;", "setOnHomeClickedListener", "(Lkotlin/e0/c/a;)V", "onHomeClickedListener", "getOnExtraActionsClickedListener", "setOnExtraActionsClickedListener", "onExtraActionsClickedListener", Constants.URL_CAMPAIGN, "getOnForwardClickedListener", "setOnForwardClickedListener", "onForwardClickedListener", "", "n", "F", "translationSmallPixels", "Lkotlin/Function1;", "Lkotlin/e0/c/l;", "getOnTextChangedListener", "()Lkotlin/e0/c/l;", "setOnTextChangedListener", "(Lkotlin/e0/c/l;)V", "onTextChangedListener", "value", "p", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "b", "getOnBackClickedListener", "setOnBackClickedListener", "onBackClickedListener", "d", "getOnGoClickedListener", "setOnGoClickedListener", "onGoClickedListener", "Landroid/text/method/KeyListener;", "Landroid/text/method/KeyListener;", "keyListener", "m", "translationNormalPixels", "getOnFocusChangedListener", "setOnFocusChangedListener", "onFocusChangedListener", "Z", "skipFirst", "editTextVisible", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AddressBarInputView extends LinearLayout {
    public static final a a = new a(null);

    /* renamed from: b */
    private kotlin.e0.c.a<x> f11154b;

    /* renamed from: c */
    private kotlin.e0.c.a<x> f11155c;

    /* renamed from: d */
    private kotlin.e0.c.l<? super String, x> f11156d;

    /* renamed from: e */
    private kotlin.e0.c.l<? super Boolean, x> f11157e;

    /* renamed from: f */
    private kotlin.e0.c.l<? super String, x> f11158f;

    /* renamed from: g */
    private kotlin.e0.c.a<x> f11159g;

    /* renamed from: h */
    private kotlin.e0.c.a<x> f11160h;

    /* renamed from: j */
    private KeyListener f11161j;

    /* renamed from: k */
    private boolean f11162k;

    /* renamed from: l */
    private boolean f11163l;
    private final float m;
    private final float n;
    private String p;

    /* compiled from: AddressBarInputView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AddressBarInputView.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.p<View, Boolean, x> {
        public static final b a = new b();

        b() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(View view, Boolean bool) {
            invoke(view, bool.booleanValue());
            return x.a;
        }

        public final void invoke(View view, boolean z) {
            kotlin.jvm.internal.m.g(view, "view");
            view.setVisibility(4);
        }
    }

    /* compiled from: AddressBarInputView.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.p<View, Boolean, x> {
        public static final c a = new c();

        c() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(View view, Boolean bool) {
            invoke(view, bool.booleanValue());
            return x.a;
        }

        public final void invoke(View view, boolean z) {
            kotlin.jvm.internal.m.g(view, "view");
            view.setVisibility(8);
        }
    }

    /* compiled from: AddressBarInputView.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.p<View, Boolean, x> {
        public static final d a = new d();

        d() {
            super(2);
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(View view, Boolean bool) {
            invoke(view, bool.booleanValue());
            return x.a;
        }

        public final void invoke(View view, boolean z) {
            kotlin.jvm.internal.m.g(view, "view");
            view.setVisibility(8);
        }
    }

    /* compiled from: AddressBarInputView.kt */
    /* loaded from: classes2.dex */
    public static final class e extends e.j.m.a.t.a {
        e() {
            AddressBarInputView.this = r1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x001a, code lost:
            if (r2 == false) goto L20;
         */
        @Override // e.j.m.a.t.a, android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onTextChanged(java.lang.CharSequence r1, int r2, int r3, int r4) {
            /*
                r0 = this;
                com.toshi.view.custom.AddressBarInputView r2 = com.toshi.view.custom.AddressBarInputView.this
                boolean r2 = com.toshi.view.custom.AddressBarInputView.a(r2)
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L1d
                if (r1 != 0) goto Le
            Lc:
                r2 = r4
                goto L1a
            Le:
                int r2 = r1.length()
                if (r2 != 0) goto L16
                r2 = r3
                goto L17
            L16:
                r2 = r4
            L17:
                if (r2 != r3) goto Lc
                r2 = r3
            L1a:
                if (r2 == 0) goto L1d
                goto L1e
            L1d:
                r3 = r4
            L1e:
                java.lang.String r1 = java.lang.String.valueOf(r1)
                if (r3 != 0) goto L30
                com.toshi.view.custom.AddressBarInputView r2 = com.toshi.view.custom.AddressBarInputView.this
                kotlin.e0.c.l r2 = r2.getOnTextChangedListener()
                if (r2 != 0) goto L2d
                goto L30
            L2d:
                r2.invoke(r1)
            L30:
                com.toshi.view.custom.AddressBarInputView r2 = com.toshi.view.custom.AddressBarInputView.this
                com.toshi.view.custom.AddressBarInputView.c(r2, r4)
                com.toshi.view.custom.AddressBarInputView r2 = com.toshi.view.custom.AddressBarInputView.this
                com.toshi.view.custom.AddressBarInputView.b(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.toshi.view.custom.AddressBarInputView.e.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }
    }

    /* compiled from: AddressBarInputView.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.p<View, Boolean, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(2);
            AddressBarInputView.this = r1;
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ x invoke(View view, Boolean bool) {
            invoke(view, bool.booleanValue());
            return x.a;
        }

        public final void invoke(View noName_0, boolean z) {
            kotlin.jvm.internal.m.g(noName_0, "$noName_0");
            AddressBarInputView.this.L();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressBarInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        LinearLayout.inflate(context, R.layout.view_address_bar_input, this);
        z();
        I();
        this.f11162k = true;
        this.m = View_CommonKt.getPxSize(this, R.dimen.translation_x_normal);
        this.n = View_CommonKt.getPxSize(this, R.dimen.translation_x_small);
        this.p = "";
    }

    public static final void A(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.e0.c.a<x> onBackClickedListener = this$0.getOnBackClickedListener();
        if (onBackClickedListener == null) {
            return;
        }
        onBackClickedListener.invoke();
    }

    public static final void B(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.e0.c.a<x> onForwardClickedListener = this$0.getOnForwardClickedListener();
        if (onForwardClickedListener == null) {
            return;
        }
        onForwardClickedListener.invoke();
    }

    public static final void C(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.x();
    }

    public static final boolean D(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        return this$0.x();
    }

    public static final void E(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.clearFocus();
    }

    public static final void F(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.e();
    }

    public static final void G(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.e0.c.a<x> onExtraActionsClickedListener = this$0.getOnExtraActionsClickedListener();
        if (onExtraActionsClickedListener == null) {
            return;
        }
        onExtraActionsClickedListener.invoke();
    }

    public static final void H(AddressBarInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.e0.c.a<x> onHomeClickedListener = this$0.getOnHomeClickedListener();
        if (onHomeClickedListener == null) {
            return;
        }
        onHomeClickedListener.invoke();
    }

    private final void I() {
        int i2 = e.j.a.userInput;
        this.f11161j = ((PlainTextPasteEditText) findViewById(i2)).getKeyListener();
        ((PlainTextPasteEditText) findViewById(i2)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.toshi.view.custom.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                AddressBarInputView.s(AddressBarInputView.this, view, z);
            }
        });
        ((PlainTextPasteEditText) findViewById(i2)).setOnKeyListener(new View.OnKeyListener() { // from class: com.toshi.view.custom.e
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                return AddressBarInputView.q(AddressBarInputView.this, view, i3, keyEvent);
            }
        });
        ((PlainTextPasteEditText) findViewById(i2)).addTextChangedListener(new e());
    }

    public static final void J(AddressBarInputView this$0, View view, boolean z) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        ((PlainTextPasteEditText) this$0.findViewById(e.j.a.userInput)).setKeyListener(z ? this$0.f11161j : null);
        kotlin.e0.c.l<Boolean, x> onFocusChangedListener = this$0.getOnFocusChangedListener();
        if (onFocusChangedListener == null) {
            return;
        }
        onFocusChangedListener.invoke(Boolean.valueOf(z));
    }

    public static final boolean K(AddressBarInputView this$0, View view, int i2, KeyEvent keyEvent) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        boolean z = keyEvent.getKeyCode() == 66;
        boolean z2 = keyEvent.getAction() == 1;
        if (z && z2) {
            this$0.clearFocus();
            this$0.g();
            return true;
        }
        return false;
    }

    public final void L() {
        LinearLayout addressInput = (LinearLayout) findViewById(e.j.a.addressInput);
        kotlin.jvm.internal.m.f(addressInput, "addressInput");
        addressInput.setVisibility(8);
        LinearLayout addressField = (LinearLayout) findViewById(e.j.a.addressField);
        kotlin.jvm.internal.m.f(addressField, "addressField");
        addressField.setVisibility(0);
    }

    private final void M() {
        ImageButton extraActionsButton = (ImageButton) findViewById(e.j.a.extraActionsButton);
        kotlin.jvm.internal.m.f(extraActionsButton, "extraActionsButton");
        e.j.f.d.g(extraActionsButton, 100L, 45.0f, true, null, 8, null);
        ImageButton closeSearchButton = (ImageButton) findViewById(e.j.a.closeSearchButton);
        kotlin.jvm.internal.m.f(closeSearchButton, "closeSearchButton");
        e.j.f.d.i(closeSearchButton, 100L, 45.0f, 0.0f, new f(), 4, null);
    }

    private final void N() {
        int i2 = e.j.a.leftButtonsLayout;
        LinearLayout leftButtonsLayout = (LinearLayout) findViewById(i2);
        kotlin.jvm.internal.m.f(leftButtonsLayout, "leftButtonsLayout");
        e.j.f.d.b(leftButtonsLayout, 100L, null, 2, null);
        ImageButton backButton = (ImageButton) findViewById(e.j.a.backButton);
        kotlin.jvm.internal.m.f(backButton, "backButton");
        e.j.f.d.j(backButton, 100L, (r16 & 2) != 0 ? 0.0f : this.n, (r16 & 4) != 0 ? 0.0f : 0.0f, (r16 & 8) != 0 ? false : true, (r16 & 16) != 0 ? null : null);
        ImageButton forwardButton = (ImageButton) findViewById(e.j.a.forwardButton);
        kotlin.jvm.internal.m.f(forwardButton, "forwardButton");
        e.j.f.d.j(forwardButton, 100L, (r16 & 2) != 0 ? 0.0f : this.m, (r16 & 4) != 0 ? 0.0f : 0.0f, (r16 & 8) != 0 ? false : true, (r16 & 16) != 0 ? null : null);
        Space leftButtonsPlaceholder = (Space) findViewById(e.j.a.leftButtonsPlaceholder);
        kotlin.jvm.internal.m.f(leftButtonsPlaceholder, "leftButtonsPlaceholder");
        e.j.f.d.e(leftButtonsPlaceholder, 100L, ((LinearLayout) findViewById(i2)).getWidth(), 0, null, 12, null);
    }

    private final void O() {
        int i2 = e.j.a.rightButtonsLayout;
        LinearLayout rightButtonsLayout = (LinearLayout) findViewById(i2);
        kotlin.jvm.internal.m.f(rightButtonsLayout, "rightButtonsLayout");
        e.j.f.d.b(rightButtonsLayout, 100L, null, 2, null);
        ImageButton homeButton = (ImageButton) findViewById(e.j.a.homeButton);
        kotlin.jvm.internal.m.f(homeButton, "homeButton");
        e.j.f.d.j(homeButton, 100L, (r16 & 2) != 0 ? 0.0f : -this.m, (r16 & 4) != 0 ? 0.0f : 0.0f, (r16 & 8) != 0 ? false : true, (r16 & 16) != 0 ? null : null);
        Space rightButtonsPlaceholder = (Space) findViewById(e.j.a.rightButtonsPlaceholder);
        kotlin.jvm.internal.m.f(rightButtonsPlaceholder, "rightButtonsPlaceholder");
        e.j.f.d.e(rightButtonsPlaceholder, 100L, ((LinearLayout) findViewById(i2)).getWidth(), 0, null, 12, null);
    }

    private final void e() {
        ((PlainTextPasteEditText) findViewById(e.j.a.userInput)).setText("");
    }

    private final void f() {
        ((PlainTextPasteEditText) findViewById(e.j.a.userInput)).setText(this.p);
        w();
    }

    private final void g() {
        CharSequence h1;
        setUrl(String.valueOf(((PlainTextPasteEditText) findViewById(e.j.a.userInput)).getText()));
        String str = this.p;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        h1 = y.h1(str);
        if (h1.toString().length() == 0) {
            return;
        }
        kotlin.e0.c.l<? super String, x> lVar = this.f11156d;
        if (lVar != null) {
            lVar.invoke(this.p);
        }
        y();
    }

    private final void h() {
        LinearLayout addressInput = (LinearLayout) findViewById(e.j.a.addressInput);
        kotlin.jvm.internal.m.f(addressInput, "addressInput");
        addressInput.setVisibility(0);
        LinearLayout addressField = (LinearLayout) findViewById(e.j.a.addressField);
        kotlin.jvm.internal.m.f(addressField, "addressField");
        addressField.setVisibility(8);
    }

    private final void i() {
        ImageButton extraActionsButton = (ImageButton) findViewById(e.j.a.extraActionsButton);
        kotlin.jvm.internal.m.f(extraActionsButton, "extraActionsButton");
        e.j.f.d.i(extraActionsButton, 100L, -45.0f, 0.0f, b.a, 4, null);
        ImageButton closeSearchButton = (ImageButton) findViewById(e.j.a.closeSearchButton);
        kotlin.jvm.internal.m.f(closeSearchButton, "closeSearchButton");
        e.j.f.d.g(closeSearchButton, 100L, -45.0f, true, null, 8, null);
    }

    private final void j() {
        int i2 = e.j.a.leftButtonsLayout;
        LinearLayout leftButtonsLayout = (LinearLayout) findViewById(i2);
        kotlin.jvm.internal.m.f(leftButtonsLayout, "leftButtonsLayout");
        e.j.f.d.c(leftButtonsLayout, 100L, c.a);
        ImageButton backButton = (ImageButton) findViewById(e.j.a.backButton);
        kotlin.jvm.internal.m.f(backButton, "backButton");
        e.j.f.d.j(backButton, 100L, (r16 & 2) != 0 ? 0.0f : -this.n, (r16 & 4) != 0 ? 0.0f : 0.0f, (r16 & 8) != 0 ? false : false, (r16 & 16) != 0 ? null : null);
        ImageButton forwardButton = (ImageButton) findViewById(e.j.a.forwardButton);
        kotlin.jvm.internal.m.f(forwardButton, "forwardButton");
        e.j.f.d.j(forwardButton, 100L, (r16 & 2) != 0 ? 0.0f : -this.m, (r16 & 4) != 0 ? 0.0f : 0.0f, (r16 & 8) != 0 ? false : false, (r16 & 16) != 0 ? null : null);
        int i3 = e.j.a.leftButtonsPlaceholder;
        ((Space) findViewById(i3)).setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout) findViewById(i2)).getWidth(), 0));
        Space leftButtonsPlaceholder = (Space) findViewById(i3);
        kotlin.jvm.internal.m.f(leftButtonsPlaceholder, "leftButtonsPlaceholder");
        e.j.f.d.e(leftButtonsPlaceholder, 100L, 0, ((LinearLayout) findViewById(i2)).getWidth(), null, 8, null);
    }

    private final void k() {
        int i2 = e.j.a.rightButtonsLayout;
        LinearLayout rightButtonsLayout = (LinearLayout) findViewById(i2);
        kotlin.jvm.internal.m.f(rightButtonsLayout, "rightButtonsLayout");
        e.j.f.d.c(rightButtonsLayout, 100L, d.a);
        ImageButton homeButton = (ImageButton) findViewById(e.j.a.homeButton);
        kotlin.jvm.internal.m.f(homeButton, "homeButton");
        e.j.f.d.j(homeButton, 100L, (r16 & 2) != 0 ? 0.0f : this.m, (r16 & 4) != 0 ? 0.0f : 0.0f, (r16 & 8) != 0 ? false : false, (r16 & 16) != 0 ? null : null);
        int i3 = e.j.a.rightButtonsPlaceholder;
        ((Space) findViewById(i3)).setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout) findViewById(i2)).getWidth(), 0));
        Space rightButtonsPlaceholder = (Space) findViewById(i3);
        kotlin.jvm.internal.m.f(rightButtonsPlaceholder, "rightButtonsPlaceholder");
        e.j.f.d.e(rightButtonsPlaceholder, 100L, 0, ((LinearLayout) findViewById(i2)).getWidth(), null, 8, null);
    }

    public static /* synthetic */ boolean m(AddressBarInputView addressBarInputView, View view) {
        return D(addressBarInputView, view);
    }

    public static /* synthetic */ void n(AddressBarInputView addressBarInputView, View view) {
        C(addressBarInputView, view);
    }

    public static /* synthetic */ void o(AddressBarInputView addressBarInputView, View view) {
        A(addressBarInputView, view);
    }

    public static /* synthetic */ void p(AddressBarInputView addressBarInputView, View view) {
        G(addressBarInputView, view);
    }

    public static /* synthetic */ boolean q(AddressBarInputView addressBarInputView, View view, int i2, KeyEvent keyEvent) {
        return K(addressBarInputView, view, i2, keyEvent);
    }

    public static /* synthetic */ void r(AddressBarInputView addressBarInputView, View view) {
        E(addressBarInputView, view);
    }

    public static /* synthetic */ void s(AddressBarInputView addressBarInputView, View view, boolean z) {
        J(addressBarInputView, view, z);
    }

    public final void setClearButtonVisibility(String str) {
        ImageButton clearButton = (ImageButton) findViewById(e.j.a.clearButton);
        kotlin.jvm.internal.m.f(clearButton, "clearButton");
        clearButton.setVisibility((str.length() == 0) ^ true ? 0 : 8);
    }

    private final void setStaticUrl(String str) {
        String A0;
        kotlin.l0.i b2 = kotlin.l0.k.b(new kotlin.l0.k("^(https?://)?(.+)"), str, 0, 2, null);
        kotlin.l0.h c2 = b2 == null ? null : b2.c();
        if (c2 != null && c2.size() >= 3) {
            kotlin.l0.g gVar = c2.get(2);
            String a2 = gVar != null ? gVar.a() : null;
            if (a2 == null) {
                a2 = "";
            }
            A0 = y.A0(a2, "www.");
            ((TextView) findViewById(e.j.a.address)).setText(A0);
        }
    }

    public static /* synthetic */ void t(AddressBarInputView addressBarInputView, View view) {
        H(addressBarInputView, view);
    }

    public static /* synthetic */ void u(AddressBarInputView addressBarInputView, View view) {
        B(addressBarInputView, view);
    }

    public static /* synthetic */ void v(AddressBarInputView addressBarInputView, View view) {
        F(addressBarInputView, view);
    }

    private final void w() {
        int i2 = e.j.a.userInput;
        ((PlainTextPasteEditText) findViewById(i2)).requestFocus();
        e.j.l.i.a.c((PlainTextPasteEditText) findViewById(i2));
        ((PlainTextPasteEditText) findViewById(i2)).selectAll();
    }

    private final boolean x() {
        if (this.f11163l) {
            return false;
        }
        h();
        j();
        k();
        i();
        this.f11163l = true;
        f();
        return true;
    }

    private final void y() {
        if (this.f11163l) {
            N();
            O();
            M();
            this.f11163l = false;
        }
    }

    private final void z() {
        ((ImageButton) findViewById(e.j.a.backButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.o(AddressBarInputView.this, view);
            }
        });
        ((ImageButton) findViewById(e.j.a.forwardButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.u(AddressBarInputView.this, view);
            }
        });
        int i2 = e.j.a.addressField;
        ((LinearLayout) findViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.n(AddressBarInputView.this, view);
            }
        });
        ((LinearLayout) findViewById(i2)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.toshi.view.custom.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AddressBarInputView.m(AddressBarInputView.this, view);
            }
        });
        ((ImageButton) findViewById(e.j.a.closeSearchButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.r(AddressBarInputView.this, view);
            }
        });
        ((ImageButton) findViewById(e.j.a.clearButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.v(AddressBarInputView.this, view);
            }
        });
        ((ImageButton) findViewById(e.j.a.extraActionsButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.p(AddressBarInputView.this, view);
            }
        });
        ((ImageButton) findViewById(e.j.a.homeButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.custom.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBarInputView.t(AddressBarInputView.this, view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        int i2 = e.j.a.userInput;
        ((PlainTextPasteEditText) findViewById(i2)).clearFocus();
        e.j.l.i.a.b((PlainTextPasteEditText) findViewById(i2));
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        boolean z = keyEvent != null && keyEvent.getAction() == 1;
        boolean z2 = keyEvent != null && keyEvent.getKeyCode() == 4;
        if (l() && z && z2) {
            y();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final kotlin.e0.c.a<x> getOnBackClickedListener() {
        return this.f11154b;
    }

    public final kotlin.e0.c.a<x> getOnExtraActionsClickedListener() {
        return this.f11159g;
    }

    public final kotlin.e0.c.l<Boolean, x> getOnFocusChangedListener() {
        return this.f11157e;
    }

    public final kotlin.e0.c.a<x> getOnForwardClickedListener() {
        return this.f11155c;
    }

    public final kotlin.e0.c.l<String, x> getOnGoClickedListener() {
        return this.f11156d;
    }

    public final kotlin.e0.c.a<x> getOnHomeClickedListener() {
        return this.f11160h;
    }

    public final kotlin.e0.c.l<String, x> getOnTextChangedListener() {
        return this.f11158f;
    }

    public final String getUrl() {
        return this.p;
    }

    public final boolean l() {
        return this.f11163l;
    }

    public final void setOnBackClickedListener(kotlin.e0.c.a<x> aVar) {
        this.f11154b = aVar;
    }

    public final void setOnExtraActionsClickedListener(kotlin.e0.c.a<x> aVar) {
        this.f11159g = aVar;
    }

    public final void setOnFocusChangedListener(kotlin.e0.c.l<? super Boolean, x> lVar) {
        this.f11157e = lVar;
    }

    public final void setOnForwardClickedListener(kotlin.e0.c.a<x> aVar) {
        this.f11155c = aVar;
    }

    public final void setOnGoClickedListener(kotlin.e0.c.l<? super String, x> lVar) {
        this.f11156d = lVar;
    }

    public final void setOnHomeClickedListener(kotlin.e0.c.a<x> aVar) {
        this.f11160h = aVar;
    }

    public final void setOnTextChangedListener(kotlin.e0.c.l<? super String, x> lVar) {
        this.f11158f = lVar;
    }

    public final void setUrl(String value) {
        kotlin.jvm.internal.m.g(value, "value");
        this.p = value;
        this.f11162k = true;
        setStaticUrl(value);
        if (l()) {
            f();
        }
    }
}