package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import c.h.k.v;
import com.caverock.androidsvg.SVGParser;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o0;
import com.facebook.react.views.text.b0;
import com.facebook.react.views.text.c0;
import com.facebook.react.views.text.q;
import com.facebook.react.views.text.s;
import com.facebook.react.views.text.x;
import com.facebook.react.views.text.z;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.crypto.tls.CipherSuite;

@e.f.m.x.a.a(name = ReactTextInputManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactTextInputManager extends BaseViewManager<com.facebook.react.views.textinput.c, com.facebook.react.uimanager.h> {
    private static final int AUTOCAPITALIZE_FLAGS = 28672;
    private static final int BLUR_TEXT_INPUT = 2;
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    private static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    private static final int SET_TEXT_AND_SELECTION = 4;
    public static final String TAG = "ReactTextInputManager";
    private static final int UNSET = -1;
    protected s mReactTextViewManagerCallback;
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];

    /* loaded from: classes2.dex */
    class a implements View.OnLongClickListener {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnFocusChangeListener {
        final /* synthetic */ i0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.facebook.react.views.textinput.c f5474b;

        b(i0 i0Var, com.facebook.react.views.textinput.c cVar) {
            this.a = i0Var;
            this.f5474b = cVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            com.facebook.react.uimanager.events.d eventDispatcher = ReactTextInputManager.getEventDispatcher(this.a, this.f5474b);
            if (z) {
                eventDispatcher.v(new i(this.f5474b.getId()));
                return;
            }
            eventDispatcher.v(new com.facebook.react.views.textinput.f(this.f5474b.getId()));
            eventDispatcher.v(new com.facebook.react.views.textinput.g(this.f5474b.getId(), this.f5474b.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextView.OnEditorActionListener {
        final /* synthetic */ com.facebook.react.views.textinput.c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i0 f5476b;

        c(com.facebook.react.views.textinput.c cVar, i0 i0Var) {
            this.a = cVar;
            this.f5476b = i0Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if ((i2 & 255) != 0 || i2 == 0) {
                boolean blurOnSubmit = this.a.getBlurOnSubmit();
                boolean k2 = this.a.k();
                ReactTextInputManager.getEventDispatcher(this.f5476b, this.a).v(new n(this.a.getId(), this.a.getText().toString()));
                if (blurOnSubmit) {
                    this.a.clearFocus();
                }
                return blurOnSubmit || !k2 || i2 == 5 || i2 == 7;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private class d implements com.facebook.react.views.textinput.a {
        private com.facebook.react.views.textinput.c a;

        /* renamed from: b  reason: collision with root package name */
        private com.facebook.react.uimanager.events.d f5478b;

        /* renamed from: c  reason: collision with root package name */
        private int f5479c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f5480d = 0;

        public d(com.facebook.react.views.textinput.c cVar) {
            this.a = cVar;
            this.f5478b = ((UIManagerModule) o0.c(cVar).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        @Override // com.facebook.react.views.textinput.a
        public void a() {
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            if (this.a.getLayout() != null) {
                width = this.a.getCompoundPaddingLeft() + this.a.getLayout().getWidth() + this.a.getCompoundPaddingRight();
                height = this.a.getCompoundPaddingTop() + this.a.getLayout().getHeight() + this.a.getCompoundPaddingBottom();
            }
            if (width == this.f5479c && height == this.f5480d) {
                return;
            }
            this.f5480d = height;
            this.f5479c = width;
            this.f5478b.v(new com.facebook.react.views.textinput.b(this.a.getId(), com.facebook.react.uimanager.o.a(width), com.facebook.react.uimanager.o.a(height)));
        }
    }

    /* loaded from: classes2.dex */
    private class e implements o {
        private com.facebook.react.views.textinput.c a;

        /* renamed from: b  reason: collision with root package name */
        private com.facebook.react.uimanager.events.d f5482b;

        /* renamed from: c  reason: collision with root package name */
        private int f5483c;

        /* renamed from: d  reason: collision with root package name */
        private int f5484d;

        public e(com.facebook.react.views.textinput.c cVar) {
            this.a = cVar;
            this.f5482b = ReactTextInputManager.getEventDispatcher(o0.c(cVar), cVar);
        }

        @Override // com.facebook.react.views.textinput.o
        public void a(int i2, int i3, int i4, int i5) {
            if (this.f5483c == i2 && this.f5484d == i3) {
                return;
            }
            this.f5482b.v(com.facebook.react.views.scroll.h.n(this.a.getId(), com.facebook.react.views.scroll.i.SCROLL, i2, i3, 0.0f, 0.0f, 0, 0, this.a.getWidth(), this.a.getHeight()));
            this.f5483c = i2;
            this.f5484d = i3;
        }
    }

    /* loaded from: classes2.dex */
    private class f implements p {
        private com.facebook.react.views.textinput.c a;

        /* renamed from: b  reason: collision with root package name */
        private com.facebook.react.uimanager.events.d f5486b;

        /* renamed from: c  reason: collision with root package name */
        private int f5487c;

        /* renamed from: d  reason: collision with root package name */
        private int f5488d;

        public f(com.facebook.react.views.textinput.c cVar) {
            this.a = cVar;
            this.f5486b = ReactTextInputManager.getEventDispatcher(o0.c(cVar), cVar);
        }

        @Override // com.facebook.react.views.textinput.p
        public void a(int i2, int i3) {
            int min = Math.min(i2, i3);
            int max = Math.max(i2, i3);
            if (this.f5487c == min && this.f5488d == max) {
                return;
            }
            this.f5486b.v(new l(this.a.getId(), min, max));
            this.f5487c = min;
            this.f5488d = max;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements TextWatcher {
        private com.facebook.react.uimanager.events.d a;

        /* renamed from: b  reason: collision with root package name */
        private com.facebook.react.views.textinput.c f5490b;

        /* renamed from: c  reason: collision with root package name */
        private String f5491c = null;

        public g(ReactContext reactContext, com.facebook.react.views.textinput.c cVar) {
            this.a = ReactTextInputManager.getEventDispatcher(reactContext, cVar);
            this.f5490b = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f5491c = charSequence.toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            String str;
            int i6;
            String str2;
            String str3;
            int i7 = i2;
            int i8 = i3;
            if (this.f5490b.K) {
                return;
            }
            if (i4 == 0 && i8 == 0) {
                return;
            }
            e.f.k.a.a.c(this.f5491c);
            int i9 = i7 + i4;
            String substring = charSequence.toString().substring(i7, i9);
            int i10 = i7 + i8;
            String substring2 = this.f5491c.substring(i7, i10);
            if (i4 == i8 && substring.equals(substring2)) {
                return;
            }
            JavaOnlyMap javaOnlyMap = this.f5490b.I;
            if (javaOnlyMap == null || !javaOnlyMap.hasKey("fragments")) {
                i5 = 0;
                str = substring2;
            } else {
                String charSequence2 = charSequence.subSequence(i7, i9).toString();
                String string = javaOnlyMap.getString("string");
                StringBuilder sb = new StringBuilder();
                sb.append(string.substring(0, i7));
                sb.append(charSequence2);
                String str4 = "";
                sb.append(string.length() > i10 ? string.substring(i10) : "");
                javaOnlyMap.putString("string", sb.toString());
                JavaOnlyArray javaOnlyArray = (JavaOnlyArray) javaOnlyMap.getArray("fragments");
                int i11 = 0;
                boolean z = false;
                int i12 = 0;
                while (i11 < javaOnlyArray.size() && !z) {
                    JavaOnlyMap javaOnlyMap2 = (JavaOnlyMap) javaOnlyArray.getMap(i11);
                    JavaOnlyArray javaOnlyArray2 = javaOnlyArray;
                    String string2 = javaOnlyMap2.getString("string");
                    int length = i12 + string2.length();
                    if (length < i7) {
                        str2 = substring2;
                        i6 = length;
                        str3 = str4;
                    } else {
                        int i13 = i7 - i12;
                        int length2 = string2.length() - i13;
                        i6 = length;
                        StringBuilder sb2 = new StringBuilder();
                        str2 = substring2;
                        str3 = str4;
                        sb2.append(string2.substring(0, i13));
                        sb2.append(charSequence2);
                        sb2.append(string2.substring(i13 + Math.min(i8, length2)));
                        javaOnlyMap2.putString("string", sb2.toString());
                        if (length2 < i8) {
                            i7 += length2;
                            i8 -= length2;
                            z = false;
                            charSequence2 = str3;
                        } else {
                            z = true;
                        }
                    }
                    i11++;
                    i12 = i6;
                    javaOnlyArray = javaOnlyArray2;
                    str4 = str3;
                    substring2 = str2;
                }
                str = substring2;
                i5 = 0;
            }
            if (this.f5490b.J != null && javaOnlyMap != null) {
                WritableMap writableNativeMap = new WritableNativeMap();
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                while (i5 < javaOnlyMap.getArray("fragments").size()) {
                    ReadableMap map = javaOnlyMap.getArray("fragments").getMap(i5);
                    WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                    writableNativeMap3.putDouble("reactTag", map.getInt("reactTag"));
                    writableNativeMap3.putString("string", map.getString("string"));
                    writableNativeArray.pushMap(writableNativeMap3);
                    i5++;
                }
                writableNativeMap2.putString("string", javaOnlyMap.getString("string"));
                writableNativeMap2.putArray("fragments", writableNativeArray);
                writableNativeMap.putInt("mostRecentEventCount", this.f5490b.j());
                writableNativeMap.putMap("textChanged", writableNativeMap2);
                this.f5490b.J.a(writableNativeMap);
            }
            this.a.v(new com.facebook.react.views.textinput.e(this.f5490b.getId(), charSequence.toString(), this.f5490b.j()));
            this.a.v(new h(this.f5490b.getId(), substring, str, i7, i7 + i8));
        }
    }

    private static void checkPasswordType(com.facebook.react.views.textinput.c cVar) {
        if ((cVar.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) == 0 || (cVar.getStagedInputType() & 128) == 0) {
            return;
        }
        updateStagedInputTypeFlag(cVar, 128, 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.react.uimanager.events.d getEventDispatcher(ReactContext reactContext, com.facebook.react.views.textinput.c cVar) {
        return o0.b(reactContext, cVar.getId());
    }

    private q getReactTextUpdate(String str, int i2, int i3, int i4) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) c0.h(str, c0.UNSET));
        return new q(spannableStringBuilder, i2, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, i3, i4);
    }

    private void setAutofillHints(com.facebook.react.views.textinput.c cVar, String... strArr) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        cVar.setAutofillHints(strArr);
    }

    private static void updateStagedInputTypeFlag(com.facebook.react.views.textinput.c cVar, int i2, int i3) {
        cVar.setStagedInputType(((~i2) & cVar.getStagedInputType()) | i3);
    }

    protected EditText createInternalEditText(i0 i0Var) {
        return new EditText(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.e("focusTextInput", 1, "blurTextInput", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return com.facebook.react.common.c.a().b("topSubmitEditing", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).b("topEndEditing", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).b("topTextInput", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onTextInput", "captured", "onTextInputCapture"))).b("topFocus", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onFocus", "captured", "onFocusCapture"))).b("topBlur", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onBlur", "captured", "onBlurCapture"))).b("topKeyPress", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.e("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).a();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.a().b(com.facebook.react.views.scroll.i.h(com.facebook.react.views.scroll.i.SCROLL), com.facebook.react.common.c.d("registrationName", "onScroll")).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map getExportedViewConstants() {
        return com.facebook.react.common.c.d("AutoCapitalizationType", com.facebook.react.common.c.g("none", 0, "characters", 4096, "words", Integer.valueOf((int) PKIFailureInfo.certRevoked), "sentences", 16384));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends com.facebook.react.uimanager.h> getShadowNodeClass() {
        return m.class;
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setAllowFontScaling(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "autoCapitalize")
    public void setAutoCapitalize(com.facebook.react.views.textinput.c cVar, Dynamic dynamic) {
        int i2 = 16384;
        if (dynamic.getType() == ReadableType.Number) {
            i2 = dynamic.asInt();
        } else if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals("none")) {
                i2 = 0;
            } else if (asString.equals("characters")) {
                i2 = 4096;
            } else if (asString.equals("words")) {
                i2 = PKIFailureInfo.certRevoked;
            } else {
                asString.equals("sentences");
            }
        }
        updateStagedInputTypeFlag(cVar, AUTOCAPITALIZE_FLAGS, i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "autoCorrect")
    public void setAutoCorrect(com.facebook.react.views.textinput.c cVar, Boolean bool) {
        int i2;
        if (bool != null) {
            i2 = bool.booleanValue() ? 32768 : PKIFailureInfo.signerNotTrusted;
        } else {
            i2 = 0;
        }
        updateStagedInputTypeFlag(cVar, 557056, i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setAutoFocus(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "blurOnSubmit")
    public void setBlurOnSubmit(com.facebook.react.views.textinput.c cVar, Boolean bool) {
        cVar.setBlurOnSubmit(bool);
    }

    @com.facebook.react.uimanager.c1.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(com.facebook.react.views.textinput.c cVar, int i2, Integer num) {
        cVar.w(SPACING_TYPES[i2], num == null ? Float.NaN : num.intValue() & 16777215, num != null ? num.intValue() >>> 24 : Float.NaN);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(com.facebook.react.views.textinput.c cVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = com.facebook.react.uimanager.o.c(f2);
        }
        if (i2 == 0) {
            cVar.setBorderRadius(f2);
        } else {
            cVar.x(f2, i2 - 1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "borderStyle")
    public void setBorderStyle(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setBorderStyle(str);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(com.facebook.react.views.textinput.c cVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = com.facebook.react.uimanager.o.c(f2);
        }
        cVar.y(SPACING_TYPES[i2], f2);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setCursorVisible(!z);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "color")
    public void setColor(com.facebook.react.views.textinput.c cVar, Integer num) {
        if (num == null) {
            ColorStateList b2 = com.facebook.react.views.text.d.b(cVar.getContext());
            if (b2 != null) {
                cVar.setTextColor(b2);
                return;
            }
            Context context = cVar.getContext();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not get default text color from View Context: ");
            sb.append(context != null ? context.getClass().getCanonicalName() : "null");
            ReactSoftException.logSoftException(str, new IllegalStateException(sb.toString()));
            return;
        }
        cVar.setTextColor(num.intValue());
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setOnLongClickListener(new a(z));
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "cursorColor")
    public void setCursorColor(com.facebook.react.views.textinput.c cVar, Integer num) {
        if (num == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Drawable textCursorDrawable = cVar.getTextCursorDrawable();
            if (textCursorDrawable != null) {
                textCursorDrawable.setColorFilter(new BlendModeColorFilter(num.intValue(), BlendMode.SRC_IN));
                cVar.setTextCursorDrawable(textCursorDrawable);
            }
        } else if (i2 == 28) {
        } else {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                int i3 = declaredField.getInt(cVar);
                if (i3 == 0) {
                    return;
                }
                Drawable f2 = androidx.core.content.a.f(cVar.getContext(), i3);
                f2.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                Drawable[] drawableArr = {f2, f2};
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(cVar);
                Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                declaredField3.setAccessible(true);
                declaredField3.set(obj, drawableArr);
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setDisableFullscreenUI(z);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "editable")
    public void setEditable(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "fontFamily")
    public void setFontFamily(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setFontFamily(str);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(com.facebook.react.views.textinput.c cVar, float f2) {
        cVar.setFontSize(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "fontStyle")
    public void setFontStyle(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setFontStyle(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "fontWeight")
    public void setFontWeight(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setFontWeight(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "importantForAutofill")
    public void setImportantForAutofill(com.facebook.react.views.textinput.c cVar, String str) {
        int i2;
        if (SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO.equals(str)) {
            i2 = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i2 = 8;
        } else if ("yes".equals(str)) {
            i2 = 1;
        } else {
            i2 = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(cVar, i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setIncludeFontPadding(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "inlineImageLeft")
    public void setInlineImageLeft(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setCompoundDrawablesWithIntrinsicBounds(e.f.m.b0.b.c.a().c(cVar.getContext(), str), 0, 0, 0);
    }

    @com.facebook.react.uimanager.c1.a(name = "inlineImagePadding")
    public void setInlineImagePadding(com.facebook.react.views.textinput.c cVar, int i2) {
        cVar.setCompoundDrawablePadding(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "keyboardType")
    public void setKeyboardType(com.facebook.react.views.textinput.c cVar, String str) {
        int i2;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i2 = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i2 = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i2 = INPUT_TYPE_KEYBOARD_DECIMAL_PAD;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            i2 = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i2 = 3;
        } else {
            i2 = KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str) ? CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA : 1;
        }
        updateStagedInputTypeFlag(cVar, 15, i2);
        checkPasswordType(cVar);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(com.facebook.react.views.textinput.c cVar, float f2) {
        cVar.setLetterSpacingPt(f2);
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(com.facebook.react.views.textinput.c cVar, float f2) {
        cVar.setMaxFontSizeMultiplier(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "maxLength")
    public void setMaxLength(com.facebook.react.views.textinput.c cVar, Integer num) {
        InputFilter[] filters = cVar.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < filters.length; i2++) {
                    if (!(filters[i2] instanceof InputFilter.LengthFilter)) {
                        linkedList.add(filters[i2]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i3 = 0; i3 < filters.length; i3++) {
                if (filters[i3] instanceof InputFilter.LengthFilter) {
                    filters[i3] = new InputFilter.LengthFilter(num.intValue());
                    z = true;
                }
            }
            if (!z) {
                InputFilter[] inputFilterArr2 = new InputFilter[filters.length + 1];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(num.intValue());
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(num.intValue())};
        }
        cVar.setFilters(inputFilterArr);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "multiline")
    public void setMultiline(com.facebook.react.views.textinput.c cVar, boolean z) {
        updateStagedInputTypeFlag(cVar, z ? 0 : 131072, z ? 131072 : 0);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(com.facebook.react.views.textinput.c cVar, int i2) {
        cVar.setLines(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(com.facebook.react.views.textinput.c cVar, boolean z) {
        if (z) {
            cVar.setContentSizeWatcher(new d(cVar));
        } else {
            cVar.setContentSizeWatcher(null);
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setOnKeyPress(z);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(com.facebook.react.views.textinput.c cVar, boolean z) {
        if (z) {
            cVar.setScrollWatcher(new e(cVar));
        } else {
            cVar.setScrollWatcher(null);
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(com.facebook.react.views.textinput.c cVar, boolean z) {
        if (z) {
            cVar.setSelectionWatcher(new f(cVar));
        } else {
            cVar.setSelectionWatcher(null);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "placeholder")
    public void setPlaceholder(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setHint(str);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(com.facebook.react.views.textinput.c cVar, Integer num) {
        if (num == null) {
            cVar.setHintTextColor(com.facebook.react.views.text.d.d(cVar.getContext()));
        } else {
            cVar.setHintTextColor(num.intValue());
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "returnKeyLabel")
    public void setReturnKeyLabel(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setImeActionLabel(str, IME_ACTION_ID);
    }

    @com.facebook.react.uimanager.c1.a(name = "returnKeyType")
    public void setReturnKeyType(com.facebook.react.views.textinput.c cVar, String str) {
        cVar.setReturnKeyType(str);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(com.facebook.react.views.textinput.c cVar, boolean z) {
        updateStagedInputTypeFlag(cVar, z ? 0 : CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, z ? 128 : 0);
        checkPasswordType(cVar);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setSelectAllOnFocus(z);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "selectionColor")
    public void setSelectionColor(com.facebook.react.views.textinput.c cVar, Integer num) {
        if (num == null) {
            cVar.setHighlightColor(com.facebook.react.views.text.d.c(cVar.getContext()));
        } else {
            cVar.setHighlightColor(num.intValue());
        }
        setCursorColor(cVar, num);
    }

    @com.facebook.react.uimanager.c1.a(name = "textAlign")
    public void setTextAlign(com.facebook.react.views.textinput.c cVar, String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                cVar.setJustificationMode(1);
            }
            cVar.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            cVar.setJustificationMode(0);
        }
        if (str != null && !"auto".equals(str)) {
            if ("left".equals(str)) {
                cVar.setGravityHorizontal(3);
                return;
            } else if ("right".equals(str)) {
                cVar.setGravityHorizontal(5);
                return;
            } else if ("center".equals(str)) {
                cVar.setGravityHorizontal(1);
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
            }
        }
        cVar.setGravityHorizontal(0);
    }

    @com.facebook.react.uimanager.c1.a(name = "textAlignVertical")
    public void setTextAlignVertical(com.facebook.react.views.textinput.c cVar, String str) {
        if (str != null && !"auto".equals(str)) {
            if ("top".equals(str)) {
                cVar.setGravityVertical(48);
                return;
            } else if ("bottom".equals(str)) {
                cVar.setGravityVertical(80);
                return;
            } else if ("center".equals(str)) {
                cVar.setGravityVertical(16);
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
            }
        }
        cVar.setGravityVertical(0);
    }

    @com.facebook.react.uimanager.c1.a(name = "autoCompleteType")
    public void setTextContentType(com.facebook.react.views.textinput.c cVar, String str) {
        if (str == null) {
            setImportantForAutofill(cVar, 2);
        } else if ("username".equals(str)) {
            setAutofillHints(cVar, "username");
        } else if ("password".equals(str)) {
            setAutofillHints(cVar, "password");
        } else if ("email".equals(str)) {
            setAutofillHints(cVar, "emailAddress");
        } else if (ApiConstants.NAME.equals(str)) {
            setAutofillHints(cVar, ApiConstants.NAME);
        } else if ("tel".equals(str)) {
            setAutofillHints(cVar, "phone");
        } else if ("street-address".equals(str)) {
            setAutofillHints(cVar, "postalAddress");
        } else if ("postal-code".equals(str)) {
            setAutofillHints(cVar, "postalCode");
        } else if ("cc-number".equals(str)) {
            setAutofillHints(cVar, "creditCardNumber");
        } else if ("cc-csc".equals(str)) {
            setAutofillHints(cVar, "creditCardSecurityCode");
        } else if ("cc-exp".equals(str)) {
            setAutofillHints(cVar, "creditCardExpirationDate");
        } else if ("cc-exp-month".equals(str)) {
            setAutofillHints(cVar, "creditCardExpirationMonth");
        } else if ("cc-exp-year".equals(str)) {
            setAutofillHints(cVar, "creditCardExpirationYear");
        } else if ("off".equals(str)) {
            setImportantForAutofill(cVar, 2);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid autoCompleteType: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(com.facebook.react.views.textinput.c cVar, Integer num) {
        Drawable background = cVar.getBackground();
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e2) {
                e.f.d.d.a.j(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", e2);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(com.facebook.react.views.textinput.c cVar, boolean z) {
        cVar.setShowSoftInputOnFocus(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.textinput.c cVar) {
        cVar.addTextChangedListener(new g(i0Var, cVar));
        cVar.setOnFocusChangeListener(new b(i0Var, cVar));
        cVar.setOnEditorActionListener(new c(cVar, i0Var));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.text.h createShadowNodeInstance() {
        return new m();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.textinput.c createViewInstance(i0 i0Var) {
        com.facebook.react.views.textinput.c cVar = new com.facebook.react.views.textinput.c(i0Var);
        cVar.setInputType(cVar.getInputType() & (-131073));
        cVar.setReturnKeyType("done");
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(com.facebook.react.views.textinput.c cVar) {
        super.onAfterUpdateTransaction((ReactTextInputManager) cVar);
        cVar.r();
        cVar.h();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(com.facebook.react.views.textinput.c cVar, int i2, int i3, int i4, int i5) {
        cVar.setPadding(i2, i3, i4, i5);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(com.facebook.react.views.textinput.c cVar, Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            int f2 = (int) qVar.f();
            int h2 = (int) qVar.h();
            int g2 = (int) qVar.g();
            int e2 = (int) qVar.e();
            if (f2 != -1 || h2 != -1 || g2 != -1 || e2 != -1) {
                if (f2 == -1) {
                    f2 = cVar.getPaddingLeft();
                }
                if (h2 == -1) {
                    h2 = cVar.getPaddingTop();
                }
                if (g2 == -1) {
                    g2 = cVar.getPaddingRight();
                }
                if (e2 == -1) {
                    e2 = cVar.getPaddingBottom();
                }
                cVar.setPadding(f2, h2, g2, e2);
            }
            if (qVar.b()) {
                z.g(qVar.k(), cVar);
            }
            cVar.q(qVar);
            cVar.n(qVar.c(), qVar.j(), qVar.i());
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(com.facebook.react.views.textinput.c cVar, a0 a0Var, h0 h0Var) {
        ReadableNativeMap state = h0Var.getState();
        if (!state.getBoolean("hasThemeData")) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ReactContext c2 = o0.c(cVar);
            if (c2 instanceof i0) {
                EditText createInternalEditText = createInternalEditText((i0) c2);
                writableNativeMap.putNull("textChanged");
                writableNativeMap.putDouble("themePaddingStart", com.facebook.react.uimanager.o.a(v.D(createInternalEditText)));
                writableNativeMap.putDouble("themePaddingEnd", com.facebook.react.uimanager.o.a(v.C(createInternalEditText)));
                writableNativeMap.putDouble("themePaddingTop", com.facebook.react.uimanager.o.a(createInternalEditText.getPaddingTop()));
                writableNativeMap.putDouble("themePaddingBottom", com.facebook.react.uimanager.o.a(createInternalEditText.getPaddingBottom()));
                h0Var.a(writableNativeMap);
            } else {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("ReactContext is not a ThemedReactContent: ");
                sb.append(c2 != null ? c2.getClass().getName() : "null");
                ReactSoftException.logSoftException(str, new IllegalStateException(sb.toString()));
            }
        }
        ReadableNativeMap map = state.getMap("attributedString");
        ReadableNativeMap map2 = state.getMap("paragraphAttributes");
        Spannable c3 = b0.c(cVar.getContext(), map, this.mReactTextViewManagerCallback);
        int j2 = x.j(map2.getString("textBreakStrategy"));
        cVar.J = h0Var;
        return q.a(c3, state.getInt("mostRecentEventCount"), false, x.i(a0Var), j2, x.f(a0Var), map);
    }

    public com.facebook.react.views.text.h createShadowNodeInstance(s sVar) {
        return new m(sVar);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.textinput.c cVar, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            receiveCommand(cVar, "focus", readableArray);
        } else if (i2 == 2) {
            receiveCommand(cVar, "blur", readableArray);
        } else if (i2 != 4) {
        } else {
            receiveCommand(cVar, "setTextAndSelection", readableArray);
        }
    }

    private void setImportantForAutofill(com.facebook.react.views.textinput.c cVar, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        cVar.setImportantForAutofill(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.textinput.c cVar, String str, ReadableArray readableArray) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1699362314:
                if (str.equals("blurTextInput")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3027047:
                if (str.equals("blur")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 97604824:
                if (str.equals("focus")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1427010500:
                if (str.equals("setTextAndSelection")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1690703013:
                if (str.equals("focusTextInput")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                cVar.g();
                return;
            case 2:
            case 4:
                cVar.t();
                return;
            case 3:
                int i2 = readableArray.getInt(0);
                if (i2 == -1) {
                    return;
                }
                String string = readableArray.getString(1);
                int i3 = readableArray.getInt(2);
                int i4 = readableArray.getInt(3);
                if (i4 == -1) {
                    i4 = i3;
                }
                cVar.p(getReactTextUpdate(string, i2, i3, i4));
                cVar.n(i2, i3, i4);
                return;
            default:
                return;
        }
    }
}