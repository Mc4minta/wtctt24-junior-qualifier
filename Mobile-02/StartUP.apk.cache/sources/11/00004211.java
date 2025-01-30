package com.toshi.view.custom.recoveryPhrase;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.y;
import kotlin.o;
import kotlin.x;
import org.apache.http.message.TokenParser;
import org.toshi.R;

/* compiled from: RecoveryPhraseInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u0001:\u0002UVB\u001b\b\u0016\u0012\u0006\u0010O\u001a\u00020N\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010\u0004J\u001f\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0004J\r\u0010'\u001a\u00020\u0002¢\u0006\u0004\b'\u0010\u0004J\r\u0010(\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u0004J\u001b\u0010*\u001a\u00020\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\b¢\u0006\u0004\b-\u0010\u000bJ\r\u0010.\u001a\u00020\b¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\b¢\u0006\u0004\b0\u0010/J\u0013\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b1\u00102J\r\u00104\u001a\u000203¢\u0006\u0004\b4\u00105R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00107R0\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R0\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010DR\u001d\u0010J\u001a\u00020F8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010G\u001a\u0004\bH\u0010IR0\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010:\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>¨\u0006W"}, d2 = {"Lcom/toshi/view/custom/recoveryPhrase/RecoveryPhraseInputView;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lkotlin/x;", "p", "()V", "s", "h", "q", "", "input", "u", "(Ljava/lang/String;)V", "", "recoveryPhrase", "invalidWords", "f", "(Ljava/util/List;Ljava/util/List;)V", "", "i", "(Ljava/util/List;)Ljava/util/List;", "recoveryPhraseList", "Landroid/text/SpannableStringBuilder;", "j", "(Ljava/util/List;Ljava/util/List;)Landroid/text/SpannableStringBuilder;", "word", "Landroid/text/SpannableString;", "l", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "Landroid/text/style/ForegroundColorSpan;", "getSpannableColor", "()Landroid/text/style/ForegroundColorSpan;", "v", "t", "", "selectionStart", "extraSpaces", "k", "(II)I", "o", "m", "n", "keywords", "setKeywordList", "(Ljava/util/List;)V", "suggestion", "g", "getPreviousWord", "()Ljava/lang/String;", "getCurrentWord", "getRecoveryPhraseAsList", "()Ljava/util/List;", "", "r", "()Z", "Lcom/toshi/view/custom/recoveryPhrase/RecoveryPhraseInputView$b;", "Lcom/toshi/view/custom/recoveryPhrase/RecoveryPhraseInputView$b;", "recoveryPhraseSpacesHelper", "Lkotlin/Function1;", "Lkotlin/e0/c/l;", "getOnInvalidLengthListener", "()Lkotlin/e0/c/l;", "setOnInvalidLengthListener", "(Lkotlin/e0/c/l;)V", "onInvalidLengthListener", "getAfterTextChangedListener", "setAfterTextChangedListener", "afterTextChangedListener", "e", "Ljava/util/List;", "keywordList", "Le/j/l/w/a;", "Lkotlin/h;", "getSearch", "()Le/j/l/w/a;", "search", "getOnTextChangedListener", "setOnTextChangedListener", "onTextChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "a", "b", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RecoveryPhraseInputView extends AppCompatEditText {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11185d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private List<String> f11186e;

    /* renamed from: f  reason: collision with root package name */
    private final h f11187f;

    /* renamed from: g  reason: collision with root package name */
    private l<? super String, x> f11188g;

    /* renamed from: h  reason: collision with root package name */
    private l<? super String, x> f11189h;

    /* renamed from: j  reason: collision with root package name */
    private l<? super String, x> f11190j;

    /* renamed from: k  reason: collision with root package name */
    private List<String> f11191k;

    /* renamed from: l  reason: collision with root package name */
    private final b f11192l;

    /* compiled from: RecoveryPhraseInputView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RecoveryPhraseInputView.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        public final o<List<String>, Integer> a(String text) {
            List K0;
            m.g(text, "text");
            K0 = y.K0(text, new String[]{" "}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : K0) {
                String str = (String) obj;
                if (str.length() == 0) {
                    i2++;
                }
                if (str.length() > 0) {
                    arrayList.add(obj);
                }
            }
            return new o<>(arrayList, Integer.valueOf(i2));
        }

        public final boolean b(CharSequence charSequence, int i2) {
            int length;
            boolean d2;
            boolean d3;
            boolean d4;
            boolean d5;
            boolean d6;
            if (charSequence != null && (length = charSequence.length()) >= 4) {
                if (i2 >= length - 2) {
                    d6 = kotlin.l0.c.d(charSequence.charAt(length - 1), TokenParser.SP, true);
                    if (d6) {
                        return false;
                    }
                }
                if (i2 <= 2) {
                    return false;
                }
                d2 = kotlin.l0.c.d(charSequence.charAt(i2 - 1), TokenParser.SP, true);
                if (d2) {
                    d3 = kotlin.l0.c.d(charSequence.charAt(i2), TokenParser.SP, true);
                    if (d3) {
                        d4 = kotlin.l0.c.d(charSequence.charAt(i2 - 2), TokenParser.SP, true);
                        if (d4) {
                            return false;
                        }
                        d5 = kotlin.l0.c.d(charSequence.charAt(i2 + 1), TokenParser.SP, true);
                        return !d5;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public final boolean c(CharSequence charSequence, int i2) {
            int length;
            boolean z;
            boolean d2;
            if (charSequence == null || (length = charSequence.length()) == 0 || i2 != length) {
                return false;
            }
            z = kotlin.l0.x.z(charSequence.toString(), " ", false, 2, null);
            if (z) {
                if (length != 1) {
                    d2 = kotlin.l0.c.d(charSequence.charAt(charSequence.length() - 2), TokenParser.SP, true);
                    if (d2) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public final boolean d(CharSequence text) {
            m.g(text, "text");
            k kVar = new k("[^A-Za-z ]");
            return kVar.e(kVar.e(text, ""), "").length() != text.length();
        }
    }

    /* compiled from: RecoveryPhraseInputView.kt */
    /* loaded from: classes2.dex */
    public static final class c extends e.j.m.a.t.a {
        c() {
        }

        @Override // e.j.m.a.t.a, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            RecoveryPhraseInputView.this.removeTextChangedListener(this);
            l<String, x> afterTextChangedListener = RecoveryPhraseInputView.this.getAfterTextChangedListener();
            if (afterTextChangedListener != null) {
                afterTextChangedListener.invoke(String.valueOf(editable));
            }
            RecoveryPhraseInputView.this.addTextChangedListener(this);
        }

        @Override // e.j.m.a.t.a, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String h0;
            RecoveryPhraseInputView.this.removeTextChangedListener(this);
            if (charSequence == null) {
                return;
            }
            int i5 = i4 + i2;
            if (RecoveryPhraseInputView.this.f11192l.d(charSequence.subSequence(i2, i5).toString())) {
                charSequence = m.o(charSequence.subSequence(0, i2).toString(), charSequence.subSequence(i5, charSequence.length()).toString());
                RecoveryPhraseInputView.this.setText(charSequence);
                RecoveryPhraseInputView.this.v();
                RecoveryPhraseInputView.this.t();
                Context context = RecoveryPhraseInputView.this.getContext();
                m.f(context, "context");
                e.j.f.h.l(context, R.string.error__invalid_special_characters, 0, 2, null);
            }
            boolean c2 = RecoveryPhraseInputView.this.f11192l.c(charSequence, RecoveryPhraseInputView.this.getSelectionStart());
            boolean b2 = RecoveryPhraseInputView.this.f11192l.b(charSequence, RecoveryPhraseInputView.this.getSelectionStart());
            o<List<String>, Integer> a = RecoveryPhraseInputView.this.f11192l.a(String.valueOf(RecoveryPhraseInputView.this.getText()));
            List<String> a2 = a.a();
            int intValue = a.b().intValue();
            if (intValue > 0 && ((!c2 && !b2) || a2.size() == 12)) {
                RecoveryPhraseInputView recoveryPhraseInputView = RecoveryPhraseInputView.this;
                int k2 = recoveryPhraseInputView.k(recoveryPhraseInputView.getSelectionStart(), intValue);
                h0 = z.h0(a2, " ", null, null, 0, null, null, 62, null);
                RecoveryPhraseInputView.this.setText(h0);
                RecoveryPhraseInputView.this.setSelection(k2);
                l<String, x> onTextChangedListener = RecoveryPhraseInputView.this.getOnTextChangedListener();
                if (onTextChangedListener != null) {
                    onTextChangedListener.invoke(h0);
                }
                RecoveryPhraseInputView.this.u(h0);
            } else {
                l<String, x> onTextChangedListener2 = RecoveryPhraseInputView.this.getOnTextChangedListener();
                if (onTextChangedListener2 != null) {
                    onTextChangedListener2.invoke(charSequence.toString());
                }
                RecoveryPhraseInputView.this.u(charSequence.toString());
            }
            RecoveryPhraseInputView.this.addTextChangedListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecoveryPhraseInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h b2;
        m.g(context, "context");
        this.f11186e = new ArrayList();
        b2 = kotlin.k.b(com.toshi.view.custom.recoveryPhrase.a.a);
        this.f11187f = b2;
        this.f11191k = new ArrayList();
        this.f11192l = new b();
        p();
    }

    private final void f(List<String> list, List<String> list2) {
        int selectionStart = getSelectionStart();
        setText(j(list, list2));
        setSelection(selectionStart);
    }

    private final e.j.l.w.a getSearch() {
        return (e.j.l.w.a) this.f11187f.getValue();
    }

    private final ForegroundColorSpan getSpannableColor() {
        return new ForegroundColorSpan(e.j.f.y.b(this, R.color.errorColor));
    }

    private final void h() {
        setShowSoftInputOnFocus(false);
    }

    private final List<String> i(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (((String) getSearch().a(this.f11186e, str)) == null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private final SpannableStringBuilder j(List<String> list, List<String> list2) {
        String h0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        h0 = z.h0(list, " ", null, null, 0, null, null, 62, null);
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            String str = (String) obj;
            boolean contains = list2.contains(str);
            SpannableString spannableString = str;
            if (contains) {
                spannableString = l(h0, str);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            if (i2 < list.size() - 1) {
                spannableStringBuilder.append((CharSequence) " ");
            }
            i2 = i3;
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    private final SpannableString l(String str, String str2) {
        int i0;
        List<String> b2;
        SpannableString spannableString = new SpannableString(str2);
        String str3 = null;
        i b3 = k.b(new k(str2), str, 0, 2, null);
        if (b3 != null && (b2 = b3.b()) != null) {
            str3 = (String) p.a0(b2);
        }
        if (str3 != null) {
            i0 = y.i0(str2, str3, 0, false, 6, null);
            spannableString.setSpan(getSpannableColor(), i0, str3.length() + i0, 33);
        }
        return spannableString;
    }

    private final void p() {
        s();
        h();
        q();
    }

    private final void q() {
        addTextChangedListener(new c());
    }

    private final void s() {
        setBackgroundResource(R.drawable.background_with_radius_4dp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        setBackgroundResource(R.drawable.background_with_error_radius_4dp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String str) {
        List K0;
        l<? super String, x> lVar;
        K0 = y.K0(str, new String[]{" "}, false, 0, 6, null);
        if (K0.size() <= 12 || (lVar = this.f11189h) == null) {
            return;
        }
        lVar.invoke(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake));
    }

    public final void g(String suggestion) {
        m.g(suggestion, "suggestion");
        String c2 = getSearch().c(String.valueOf(getText()), getSelectionStart());
        Editable text = getText();
        if (text == null) {
            return;
        }
        e.j.f.l.b(text, suggestion, c2, getSelectionStart(), true);
    }

    public final l<String, x> getAfterTextChangedListener() {
        return this.f11190j;
    }

    public final String getCurrentWord() {
        return getSearch().c(String.valueOf(getText()), getSelectionStart());
    }

    public final l<String, x> getOnInvalidLengthListener() {
        return this.f11189h;
    }

    public final l<String, x> getOnTextChangedListener() {
        return this.f11188g;
    }

    public final String getPreviousWord() {
        return getSearch().d(String.valueOf(getText()), getSelectionStart() - 1);
    }

    public final List<String> getRecoveryPhraseAsList() {
        return this.f11192l.a(String.valueOf(getText())).c();
    }

    public final void m() {
        List<String> K0;
        K0 = y.K0(String.valueOf(getText()), new String[]{" "}, false, 0, 6, null);
        List<String> i2 = i(K0);
        this.f11191k = i2;
        f(K0, i2);
    }

    public final void n() {
        List<String> K0;
        K0 = y.K0(String.valueOf(getText()), new String[]{" "}, false, 0, 6, null);
        List<String> i2 = i(K0);
        this.f11191k = i2;
        f(K0, i2);
        v();
        t();
    }

    public final void o() {
        List<String> K0;
        K0 = y.K0(String.valueOf(getText()), new String[]{" "}, false, 0, 6, null);
        if (this.f11191k.contains(getCurrentWord())) {
            this.f11191k.remove(getCurrentWord());
        }
        f(K0, this.f11191k);
    }

    public final boolean r() {
        return getRecoveryPhraseAsList().size() == 12;
    }

    public final void setAfterTextChangedListener(l<? super String, x> lVar) {
        this.f11190j = lVar;
    }

    public final void setKeywordList(List<String> keywords) {
        m.g(keywords, "keywords");
        List<String> list = this.f11186e;
        list.clear();
        list.addAll(keywords);
    }

    public final void setOnInvalidLengthListener(l<? super String, x> lVar) {
        this.f11189h = lVar;
    }

    public final void setOnTextChangedListener(l<? super String, x> lVar) {
        this.f11188g = lVar;
    }
}