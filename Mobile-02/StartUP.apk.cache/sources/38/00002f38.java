package com.facebook.react.uimanager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import c.h.k.e0.d;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.HashMap;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ReactAccessibilityDelegate.java */
/* loaded from: classes2.dex */
public class q extends c.h.k.a {

    /* renamed from: d  reason: collision with root package name */
    private static int f5179d = 1056964608;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, Integer> f5180e;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<Integer, String> f5182g = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private Handler f5181f = new a();

    /* compiled from: ReactAccessibilityDelegate.java */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ((View) message.obj).sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactAccessibilityDelegate.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.IMAGEBUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.KEYBOARDKEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[c.ADJUSTABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[c.CHECKBOX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[c.RADIO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c.SPINBUTTON.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c.SWITCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[c.NONE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[c.LINK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[c.SUMMARY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[c.HEADER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[c.ALERT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[c.COMBOBOX.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[c.MENU.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[c.MENUBAR.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[c.MENUITEM.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[c.PROGRESSBAR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[c.RADIOGROUP.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[c.SCROLLBAR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[c.TAB.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[c.TABLIST.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[c.TIMER.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[c.TOOLBAR.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: ReactAccessibilityDelegate.java */
    /* loaded from: classes2.dex */
    public enum c {
        NONE,
        BUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        TOOLBAR;

        public static c h(String str) {
            c[] values;
            for (c cVar : values()) {
                if (cVar.name().equalsIgnoreCase(str)) {
                    return cVar;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: " + str);
        }

        public static String n(c cVar) {
            switch (b.a[cVar.ordinal()]) {
                case 1:
                    return "android.widget.Button";
                case 2:
                    return "android.widget.EditText";
                case 3:
                    return "android.widget.ImageView";
                case 4:
                    return "android.widget.ImageButon";
                case 5:
                    return "android.inputmethodservice.Keyboard$Key";
                case 6:
                    return "android.widget.TextView";
                case 7:
                    return "android.widget.SeekBar";
                case 8:
                    return "android.widget.CheckBox";
                case 9:
                    return "android.widget.RadioButton";
                case 10:
                    return "android.widget.SpinButton";
                case 11:
                    return "android.widget.Switch";
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    return "android.view.View";
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: " + cVar);
            }
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f5180e = hashMap;
        hashMap.put("activate", Integer.valueOf(d.a.f3036e.b()));
        hashMap.put("longpress", Integer.valueOf(d.a.f3037f.b()));
        hashMap.put("increment", Integer.valueOf(d.a.m.b()));
        hashMap.put("decrement", Integer.valueOf(d.a.n.b()));
    }

    private void n(View view) {
        if (this.f5181f.hasMessages(1, view)) {
            this.f5181f.removeMessages(1, view);
        }
        this.f5181f.sendMessageDelayed(this.f5181f.obtainMessage(1, view), 200L);
    }

    public static void o(View view) {
        if (c.h.k.v.L(view)) {
            return;
        }
        if (view.getTag(e.f.m.f.f12825d) == null && view.getTag(e.f.m.f.f12826e) == null && view.getTag(e.f.m.f.a) == null) {
            return;
        }
        c.h.k.v.k0(view, new q());
    }

    public static void p(c.h.k.e0.d dVar, c cVar, Context context) {
        if (cVar == null) {
            cVar = c.NONE;
        }
        dVar.T(c.n(cVar));
        if (cVar.equals(c.LINK)) {
            dVar.k0(context.getString(e.f.m.h.f12834f));
            if (dVar.o() != null) {
                SpannableString spannableString = new SpannableString(dVar.o());
                spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), 0);
                dVar.X(spannableString);
            }
            if (dVar.t() != null) {
                SpannableString spannableString2 = new SpannableString(dVar.t());
                spannableString2.setSpan(new URLSpan(""), 0, spannableString2.length(), 0);
                dVar.r0(spannableString2);
            }
        } else if (cVar.equals(c.SEARCH)) {
            dVar.k0(context.getString(e.f.m.h.n));
        } else if (cVar.equals(c.IMAGE)) {
            dVar.k0(context.getString(e.f.m.h.f12832d));
        } else if (cVar.equals(c.IMAGEBUTTON)) {
            dVar.k0(context.getString(e.f.m.h.f12833e));
            dVar.U(true);
        } else if (cVar.equals(c.BUTTON)) {
            dVar.k0(context.getString(e.f.m.h.f12830b));
            dVar.U(true);
        } else if (cVar.equals(c.SUMMARY)) {
            dVar.k0(context.getString(e.f.m.h.v));
        } else if (cVar.equals(c.HEADER)) {
            dVar.W(d.c.a(0, 1, 0, 1, true));
        } else if (cVar.equals(c.ALERT)) {
            dVar.k0(context.getString(e.f.m.h.a));
        } else if (cVar.equals(c.COMBOBOX)) {
            dVar.k0(context.getString(e.f.m.h.f12831c));
        } else if (cVar.equals(c.MENU)) {
            dVar.k0(context.getString(e.f.m.h.f12835g));
        } else if (cVar.equals(c.MENUBAR)) {
            dVar.k0(context.getString(e.f.m.h.f12836h));
        } else if (cVar.equals(c.MENUITEM)) {
            dVar.k0(context.getString(e.f.m.h.f12837i));
        } else if (cVar.equals(c.PROGRESSBAR)) {
            dVar.k0(context.getString(e.f.m.h.f12838j));
        } else if (cVar.equals(c.RADIOGROUP)) {
            dVar.k0(context.getString(e.f.m.h.f12839k));
        } else if (cVar.equals(c.SCROLLBAR)) {
            dVar.k0(context.getString(e.f.m.h.m));
        } else if (cVar.equals(c.SPINBUTTON)) {
            dVar.k0(context.getString(e.f.m.h.o));
        } else if (cVar.equals(c.TAB)) {
            dVar.k0(context.getString(e.f.m.h.f12840l));
        } else if (cVar.equals(c.TABLIST)) {
            dVar.k0(context.getString(e.f.m.h.w));
        } else if (cVar.equals(c.TIMER)) {
            dVar.k0(context.getString(e.f.m.h.x));
        } else if (cVar.equals(c.TOOLBAR)) {
            dVar.k0(context.getString(e.f.m.h.y));
        }
    }

    private static void q(c.h.k.e0.d dVar, ReadableMap readableMap, Context context) {
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Dynamic dynamic = readableMap.getDynamic(nextKey);
            if (nextKey.equals("selected") && dynamic.getType() == ReadableType.Boolean) {
                dVar.n0(dynamic.asBoolean());
            } else if (nextKey.equals("disabled") && dynamic.getType() == ReadableType.Boolean) {
                dVar.a0(!dynamic.asBoolean());
            } else if (nextKey.equals("checked") && dynamic.getType() == ReadableType.Boolean) {
                boolean asBoolean = dynamic.asBoolean();
                dVar.R(true);
                dVar.S(asBoolean);
                if (dVar.m().equals(c.n(c.SWITCH))) {
                    dVar.r0(context.getString(asBoolean ? e.f.m.h.u : e.f.m.h.t));
                }
            }
        }
    }

    @Override // c.h.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        ReadableMap readableMap = (ReadableMap) view.getTag(e.f.m.f.f12827f);
        if (readableMap != null && readableMap.hasKey("min") && readableMap.hasKey("now") && readableMap.hasKey("max")) {
            Dynamic dynamic = readableMap.getDynamic("min");
            Dynamic dynamic2 = readableMap.getDynamic("now");
            Dynamic dynamic3 = readableMap.getDynamic("max");
            if (dynamic != null) {
                ReadableType type = dynamic.getType();
                ReadableType readableType = ReadableType.Number;
                if (type == readableType && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                    int asInt = dynamic.asInt();
                    int asInt2 = dynamic2.asInt();
                    int asInt3 = dynamic3.asInt();
                    if (asInt3 <= asInt || asInt2 < asInt || asInt3 < asInt2) {
                        return;
                    }
                    accessibilityEvent.setItemCount(asInt3 - asInt);
                    accessibilityEvent.setCurrentItemIndex(asInt2);
                }
            }
        }
    }

    @Override // c.h.k.a
    public void g(View view, c.h.k.e0.d dVar) {
        super.g(view, dVar);
        c cVar = (c) view.getTag(e.f.m.f.f12825d);
        if (cVar != null) {
            p(dVar, cVar, view.getContext());
        }
        ReadableMap readableMap = (ReadableMap) view.getTag(e.f.m.f.f12826e);
        if (readableMap != null) {
            q(dVar, readableMap, view.getContext());
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(e.f.m.f.a);
        if (readableArray != null) {
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                ReadableMap map = readableArray.getMap(i2);
                if (map.hasKey(ApiConstants.NAME)) {
                    int i3 = f5179d;
                    String string = map.hasKey("label") ? map.getString("label") : null;
                    HashMap<String, Integer> hashMap = f5180e;
                    if (hashMap.containsKey(map.getString(ApiConstants.NAME))) {
                        i3 = hashMap.get(map.getString(ApiConstants.NAME)).intValue();
                    } else {
                        f5179d++;
                    }
                    this.f5182g.put(Integer.valueOf(i3), map.getString(ApiConstants.NAME));
                    dVar.b(new d.a(i3, string));
                } else {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
            }
        }
        ReadableMap readableMap2 = (ReadableMap) view.getTag(e.f.m.f.f12827f);
        if (readableMap2 != null && readableMap2.hasKey("min") && readableMap2.hasKey("now") && readableMap2.hasKey("max")) {
            Dynamic dynamic = readableMap2.getDynamic("min");
            Dynamic dynamic2 = readableMap2.getDynamic("now");
            Dynamic dynamic3 = readableMap2.getDynamic("max");
            if (dynamic != null) {
                ReadableType type = dynamic.getType();
                ReadableType readableType = ReadableType.Number;
                if (type == readableType && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                    int asInt = dynamic.asInt();
                    int asInt2 = dynamic2.asInt();
                    int asInt3 = dynamic3.asInt();
                    if (asInt3 <= asInt || asInt2 < asInt || asInt3 < asInt2) {
                        return;
                    }
                    dVar.j0(d.C0069d.a(0, asInt, asInt3, asInt2));
                }
            }
        }
    }

    @Override // c.h.k.a
    public boolean j(View view, int i2, Bundle bundle) {
        if (this.f5182g.containsKey(Integer.valueOf(i2))) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("actionName", this.f5182g.get(Integer.valueOf(i2)));
            ReactContext reactContext = (ReactContext) view.getContext();
            if (reactContext.hasActiveCatalystInstance()) {
                ((RCTEventEmitter) reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), "topAccessibilityAction", createMap);
            } else {
                ReactSoftException.logSoftException("ReactAccessibilityDelegate", new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
            }
            c cVar = (c) view.getTag(e.f.m.f.f12825d);
            ReadableMap readableMap = (ReadableMap) view.getTag(e.f.m.f.f12827f);
            if (cVar == c.ADJUSTABLE) {
                if (i2 == d.a.m.b() || i2 == d.a.n.b()) {
                    if (readableMap != null && !readableMap.hasKey(TextBundle.TEXT_ENTRY)) {
                        n(view);
                    }
                    return super.j(view, i2, bundle);
                }
                return true;
            }
            return true;
        }
        return super.j(view, i2, bundle);
    }
}