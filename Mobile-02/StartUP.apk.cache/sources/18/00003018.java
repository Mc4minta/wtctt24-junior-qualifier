package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import c.h.k.v;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.o0;
import com.facebook.react.views.text.q;
import com.facebook.react.views.text.t;
import com.facebook.react.views.text.y;
import com.facebook.react.views.text.z;
import java.util.ArrayList;
import java.util.Iterator;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: ReactEditText.java */
/* loaded from: classes2.dex */
public class c extends AppCompatEditText {

    /* renamed from: d  reason: collision with root package name */
    private static final KeyListener f5495d = QwertyKeyListener.getInstanceForFullKeyboard();
    private y A;
    private boolean B;
    private String C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private com.facebook.react.views.view.e H;
    protected JavaOnlyMap I;
    protected h0 J;
    protected boolean K;
    protected boolean L;

    /* renamed from: e  reason: collision with root package name */
    private final InputMethodManager f5496e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f5497f;

    /* renamed from: g  reason: collision with root package name */
    private int f5498g;

    /* renamed from: h  reason: collision with root package name */
    private int f5499h;

    /* renamed from: j  reason: collision with root package name */
    protected int f5500j;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<TextWatcher> f5501k;

    /* renamed from: l  reason: collision with root package name */
    private C0126c f5502l;
    private int m;
    protected boolean n;
    private Boolean p;
    private boolean q;
    private String t;
    private p u;
    private com.facebook.react.views.textinput.a v;
    private o w;
    private final b x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactEditText.java */
    /* loaded from: classes2.dex */
    public class a extends c.h.k.a {
        a() {
        }

        @Override // c.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (i2 == 16) {
                return c.this.u();
            }
            return super.j(view, i2, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactEditText.java */
    /* loaded from: classes2.dex */
    public static class b implements KeyListener {
        private int a = 0;

        public void a(int i2) {
            this.a = i2;
        }

        @Override // android.text.method.KeyListener
        public void clearMetaKeyState(View view, Editable editable, int i2) {
            c.f5495d.clearMetaKeyState(view, editable, i2);
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return this.a;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
            return c.f5495d.onKeyDown(view, editable, i2, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return c.f5495d.onKeyOther(view, editable, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
            return c.f5495d.onKeyUp(view, editable, i2, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactEditText.java */
    /* renamed from: com.facebook.react.views.textinput.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0126c implements TextWatcher {
        private C0126c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c cVar = c.this;
            if (cVar.f5497f || cVar.f5501k == null) {
                return;
            }
            Iterator it = c.this.f5501k.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c cVar = c.this;
            if (cVar.f5497f || cVar.f5501k == null) {
                return;
            }
            Iterator it = c.this.f5501k.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).beforeTextChanged(charSequence, i2, i3, i4);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c cVar = c.this;
            if (!cVar.f5497f && cVar.f5501k != null) {
                Iterator it = c.this.f5501k.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i2, i3, i4);
                }
            }
            c.this.s();
        }

        /* synthetic */ C0126c(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context) {
        super(context);
        this.y = false;
        this.z = false;
        this.B = false;
        this.C = null;
        this.D = -1;
        this.E = -1;
        this.F = false;
        this.G = false;
        this.I = null;
        this.J = null;
        this.K = false;
        this.L = false;
        setFocusableInTouchMode(false);
        this.H = new com.facebook.react.views.view.e(this);
        this.f5496e = (InputMethodManager) e.f.k.a.a.c(context.getSystemService("input_method"));
        this.f5498g = getGravity() & 8388615;
        this.f5499h = getGravity() & 112;
        this.f5500j = 0;
        this.f5497f = false;
        this.p = null;
        this.q = false;
        this.f5501k = null;
        this.f5502l = null;
        this.m = getInputType();
        this.x = new b();
        this.w = null;
        this.A = new y();
        e();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && i2 <= 27) {
            setLayerType(1, null);
        }
        v.k0(this, new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B() {
        /*
            r9 = this;
            java.lang.String r0 = r9.t
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 6
            if (r0 == 0) goto L70
            r0.hashCode()
            r7 = -1
            int r8 = r0.hashCode()
            switch(r8) {
                case -1273775369: goto L58;
                case -906336856: goto L4d;
                case 3304: goto L42;
                case 3089282: goto L37;
                case 3377907: goto L2c;
                case 3387192: goto L21;
                case 3526536: goto L16;
                default: goto L15;
            }
        L15:
            goto L62
        L16:
            java.lang.String r8 = "send"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L1f
            goto L62
        L1f:
            r7 = r6
            goto L62
        L21:
            java.lang.String r8 = "none"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L2a
            goto L62
        L2a:
            r7 = r1
            goto L62
        L2c:
            java.lang.String r8 = "next"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L35
            goto L62
        L35:
            r7 = r2
            goto L62
        L37:
            java.lang.String r8 = "done"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L40
            goto L62
        L40:
            r7 = r3
            goto L62
        L42:
            java.lang.String r8 = "go"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L4b
            goto L62
        L4b:
            r7 = r4
            goto L62
        L4d:
            java.lang.String r8 = "search"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L56
            goto L62
        L56:
            r7 = r5
            goto L62
        L58:
            java.lang.String r8 = "previous"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L61
            goto L62
        L61:
            r7 = 0
        L62:
            switch(r7) {
                case 0: goto L6e;
                case 1: goto L6c;
                case 2: goto L6a;
                case 3: goto L70;
                case 4: goto L71;
                case 5: goto L68;
                case 6: goto L66;
                default: goto L65;
            }
        L65:
            goto L70
        L66:
            r1 = r2
            goto L71
        L68:
            r1 = r5
            goto L71
        L6a:
            r1 = r4
            goto L71
        L6c:
            r1 = r3
            goto L71
        L6e:
            r1 = 7
            goto L71
        L70:
            r1 = r6
        L71:
            boolean r0 = r9.q
            if (r0 == 0) goto L7c
            r0 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 | r1
            r9.setImeOptions(r0)
            goto L7f
        L7c:
            r9.setImeOptions(r1)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.c.B():void");
    }

    private C0126c getTextWatcherDelegator() {
        if (this.f5502l == null) {
            this.f5502l = new C0126c(this, null);
        }
        return this.f5502l;
    }

    private boolean l() {
        return (getInputType() & CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA) != 0;
    }

    private void m(SpannableStringBuilder spannableStringBuilder) {
        Object[] spans = getText().getSpans(0, length(), Object.class);
        for (int i2 = 0; i2 < spans.length; i2++) {
            if (spans[i2] instanceof com.facebook.react.views.text.l) {
                getText().removeSpan(spans[i2]);
            }
            if ((getText().getSpanFlags(spans[i2]) & 33) == 33) {
                Object obj = spans[i2];
                int spanStart = getText().getSpanStart(spans[i2]);
                int spanEnd = getText().getSpanEnd(spans[i2]);
                int spanFlags = getText().getSpanFlags(spans[i2]);
                getText().removeSpan(spans[i2]);
                if (v(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.facebook.react.views.textinput.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        setFocusableInTouchMode(true);
        boolean requestFocus = super.requestFocus(130, null);
        if (getShowSoftInputOnFocus()) {
            A();
        }
        return requestFocus;
    }

    private static boolean v(Editable editable, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        if (i2 > spannableStringBuilder.length() || i3 > spannableStringBuilder.length()) {
            return false;
        }
        while (i2 < i3) {
            if (editable.charAt(i2) != spannableStringBuilder.charAt(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private void z() {
        if (this.J == null) {
            ReactContext c2 = o0.c(this);
            ((UIManagerModule) c2.getNativeModule(UIManagerModule.class)).setViewLocalData(getId(), new k(this));
        }
    }

    protected boolean A() {
        return this.f5496e.showSoftInput(this, 0);
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.f5501k == null) {
            this.f5501k = new ArrayList<>();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.f5501k.add(textWatcher);
    }

    @Override // android.view.View
    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        i();
    }

    protected void e() {
        setTextSize(0, this.A.c());
        if (Build.VERSION.SDK_INT >= 21) {
            float d2 = this.A.d();
            if (Float.isNaN(d2)) {
                return;
            }
            setLetterSpacing(d2);
        }
    }

    public boolean f(int i2) {
        return i2 >= this.f5500j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        clearFocus();
    }

    public boolean getBlurOnSubmit() {
        Boolean bool = this.p;
        if (bool == null) {
            return !k();
        }
        return bool.booleanValue();
    }

    public boolean getDisableFullscreenUI() {
        return this.q;
    }

    public String getReturnKeyType() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStagedInputType() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (getInputType() != this.m) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.m);
            setSelection(selectionStart, selectionEnd);
        }
    }

    protected void i() {
        this.f5496e.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.n) {
            Editable text = getText();
            for (z zVar : (z[]) text.getSpans(0, text.length(), z.class)) {
                if (zVar.a() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    @Override // android.view.View
    public boolean isLayoutRequested() {
        return false;
    }

    public int j() {
        int i2 = this.f5500j + 1;
        this.f5500j = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return (getInputType() & PKIFailureInfo.unsupportedVersion) != 0;
    }

    public void n(int i2, int i3, int i4) {
        if (!f(i2) || i3 == -1 || i4 == -1) {
            return;
        }
        setSelection(i3, i4);
    }

    public void o(q qVar) {
        if (!(l() && TextUtils.equals(getText(), qVar.k())) && f(qVar.c())) {
            ReadableMap readableMap = qVar.m;
            if (readableMap != null) {
                this.I = JavaOnlyMap.deepClone(readableMap);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(qVar.k());
            m(spannableStringBuilder);
            this.n = qVar.b();
            this.K = true;
            if (qVar.k().length() == 0) {
                setText((CharSequence) null);
            } else {
                getText().replace(0, length(), spannableStringBuilder);
            }
            this.K = false;
            if (Build.VERSION.SDK_INT < 23 || getBreakStrategy() == qVar.m()) {
                return;
            }
            setBreakStrategy(qVar.m());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n) {
            Editable text = getText();
            for (z zVar : (z[]) text.getSpans(0, text.length(), z.class)) {
                zVar.c();
            }
        }
        if (this.F && !this.G) {
            u();
        }
        this.G = true;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext c2 = o0.c(this);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && this.z) {
            onCreateInputConnection = new d(onCreateInputConnection, c2, this);
        }
        if (k() && getBlurOnSubmit()) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.n) {
            Editable text = getText();
            for (z zVar : (z[]) text.getSpans(0, text.length(), z.class)) {
                zVar.d();
            }
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.n) {
            Editable text = getText();
            for (z zVar : (z[]) text.getSpans(0, text.length(), z.class)) {
                zVar.e();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        p pVar;
        super.onFocusChanged(z, i2, rect);
        if (!z || (pVar = this.u) == null) {
            return;
        }
        pVar.a(getSelectionStart(), getSelectionEnd());
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 66 && !k()) {
            i();
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        s();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        o oVar = this.w;
        if (oVar != null) {
            oVar.a(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        if (this.u == null || !hasFocus()) {
            return;
        }
        this.u.a(i2, i3);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.n) {
            Editable text = getText();
            for (z zVar : (z[]) text.getSpans(0, text.length(), z.class)) {
                zVar.f();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && this.y) {
                if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                this.y = false;
            }
        } else {
            this.y = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(q qVar) {
        this.f5497f = true;
        o(qVar);
        this.f5497f = false;
    }

    public void q(q qVar) {
        this.L = true;
        o(qVar);
        this.L = false;
    }

    public void r() {
        if (this.B) {
            this.B = false;
            setTypeface(t.a(getTypeface(), this.E, this.D, this.C, getContext().getAssets()));
        }
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList<TextWatcher> arrayList = this.f5501k;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.f5501k.isEmpty()) {
                this.f5501k = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    @Override // android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        return isFocused();
    }

    public void setAllowFontScaling(boolean z) {
        if (this.A.b() != z) {
            this.A.m(z);
            e();
        }
    }

    public void setAutoFocus(boolean z) {
        this.F = z;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.H.b(i2);
    }

    public void setBlurOnSubmit(Boolean bool) {
        this.p = bool;
    }

    public void setBorderRadius(float f2) {
        this.H.d(f2);
    }

    public void setBorderStyle(String str) {
        this.H.f(str);
    }

    public void setContentSizeWatcher(com.facebook.react.views.textinput.a aVar) {
        this.v = aVar;
    }

    public void setDisableFullscreenUI(boolean z) {
        this.q = z;
        B();
    }

    public void setFontFamily(String str) {
        this.C = str;
        this.B = true;
    }

    public void setFontSize(float f2) {
        this.A.n(f2);
        e();
    }

    public void setFontStyle(String str) {
        int b2 = t.b(str);
        if (b2 != this.E) {
            this.E = b2;
            this.B = true;
        }
    }

    public void setFontWeight(String str) {
        int d2 = t.d(str);
        if (d2 != this.D) {
            this.D = d2;
            this.B = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGravityHorizontal(int i2) {
        if (i2 == 0) {
            i2 = this.f5498g;
        }
        setGravity(i2 | (getGravity() & (-8) & (-8388616)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGravityVertical(int i2) {
        if (i2 == 0) {
            i2 = this.f5499h;
        }
        setGravity(i2 | (getGravity() & (-113)));
    }

    @Override // android.widget.TextView
    public void setInputType(int i2) {
        super.setTypeface(super.getTypeface());
        if (i2 == 32 && Build.VERSION.SDK_INT == 29 && Build.MANUFACTURER.startsWith("Xiaomi")) {
            i2 = 1;
        }
        super.setInputType(i2);
        this.m = i2;
        if (k()) {
            setSingleLine(false);
        }
        this.x.a(i2);
        setKeyListener(this.x);
    }

    public void setLetterSpacingPt(float f2) {
        this.A.p(f2);
        e();
    }

    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 != this.A.k()) {
            this.A.r(f2);
            e();
        }
    }

    public void setOnKeyPress(boolean z) {
        this.z = z;
    }

    public void setReturnKeyType(String str) {
        this.t = str;
        B();
    }

    public void setScrollWatcher(o oVar) {
        this.w = oVar;
    }

    @Override // android.widget.EditText
    public void setSelection(int i2, int i3) {
        super.setSelection(i2, i3);
    }

    public void setSelectionWatcher(p pVar) {
        this.u = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStagedInputType(int i2) {
        this.m = i2;
    }

    public void t() {
        u();
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.n) {
            Editable text = getText();
            for (z zVar : (z[]) text.getSpans(0, text.length(), z.class)) {
                if (zVar.a() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void w(int i2, float f2, float f3) {
        this.H.c(i2, f2, f3);
    }

    public void x(float f2, int i2) {
        this.H.e(f2, i2);
    }

    public void y(int i2, float f2) {
        this.H.g(i2, f2);
    }
}