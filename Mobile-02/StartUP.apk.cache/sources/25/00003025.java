package com.facebook.react.views.textinput;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.EditText;
import c.h.k.v;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.t0;
import com.facebook.react.views.text.q;
import com.facebook.react.views.text.s;
import org.spongycastle.i18n.TextBundle;

/* compiled from: ReactTextInputShadowNode.java */
@TargetApi(23)
/* loaded from: classes2.dex */
public class m extends com.facebook.react.views.text.h implements com.facebook.yoga.m {
    private int e0;
    private EditText f0;
    private k g0;
    private String h0;
    private String i0;
    private int j0;
    private int k0;

    public m(s sVar) {
        super(sVar);
        this.e0 = -1;
        this.h0 = null;
        this.i0 = null;
        this.j0 = -1;
        this.k0 = -1;
        this.M = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        t1();
    }

    private void t1() {
        R0(this);
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void E(Object obj) {
        e.f.k.a.a.a(obj instanceof k);
        this.g0 = (k) obj;
        h();
    }

    @Override // com.facebook.yoga.m
    public long T(com.facebook.yoga.p pVar, float f2, com.facebook.yoga.n nVar, float f3, com.facebook.yoga.n nVar2) {
        EditText editText = (EditText) e.f.k.a.a.c(this.f0);
        k kVar = this.g0;
        if (kVar != null) {
            kVar.a(editText);
        } else {
            editText.setTextSize(0, this.F.c());
            int i2 = this.K;
            if (i2 != -1) {
                editText.setLines(i2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                int breakStrategy = editText.getBreakStrategy();
                int i3 = this.M;
                if (breakStrategy != i3) {
                    editText.setBreakStrategy(i3);
                }
            }
        }
        editText.setHint(r1());
        editText.measure(com.facebook.react.views.view.b.a(f2, nVar), com.facebook.react.views.view.b.a(f3, nVar2));
        return com.facebook.yoga.o.b(editText.getMeasuredWidth(), editText.getMeasuredHeight());
    }

    @Override // com.facebook.react.uimanager.z
    public void T0(int i2, float f2) {
        super.T0(i2, f2);
        w0();
    }

    protected EditText q1() {
        return new EditText(F());
    }

    public String r1() {
        return this.i0;
    }

    public String s1() {
        return this.h0;
    }

    @com.facebook.react.uimanager.c1.a(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i2) {
        this.e0 = i2;
    }

    @com.facebook.react.uimanager.c1.a(name = "placeholder")
    public void setPlaceholder(String str) {
        this.i0 = str;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "selection")
    public void setSelection(ReadableMap readableMap) {
        this.k0 = -1;
        this.j0 = -1;
        if (readableMap != null && readableMap.hasKey("start") && readableMap.hasKey("end")) {
            this.j0 = readableMap.getInt("start");
            this.k0 = readableMap.getInt("end");
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(name = TextBundle.TEXT_ENTRY)
    public void setText(String str) {
        this.h0 = str;
        if (str != null) {
            if (this.j0 > str.length()) {
                this.j0 = str.length();
            }
            if (this.k0 > str.length()) {
                this.k0 = str.length();
            }
        } else {
            this.j0 = -1;
            this.k0 = -1;
        }
        w0();
    }

    @Override // com.facebook.react.views.text.h
    public void setTextBreakStrategy(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (str != null && !"simple".equals(str)) {
            if ("highQuality".equals(str)) {
                this.M = 1;
                return;
            } else if ("balanced".equals(str)) {
                this.M = 2;
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + str);
            }
        }
        this.M = 0;
    }

    @Override // com.facebook.react.uimanager.z
    public boolean t0() {
        return true;
    }

    @Override // com.facebook.react.uimanager.z
    public boolean u0() {
        return true;
    }

    @Override // com.facebook.react.uimanager.z
    public void y0(t0 t0Var) {
        super.y0(t0Var);
        if (this.e0 != -1) {
            t0Var.R(q(), new q(p1(this, s1(), false, null), this.e0, this.c0, j0(0), j0(1), j0(2), j0(3), this.L, this.M, this.O, this.j0, this.k0));
        }
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void z(i0 i0Var) {
        super.z(i0Var);
        EditText q1 = q1();
        F0(4, v.D(q1));
        F0(1, q1.getPaddingTop());
        F0(5, v.C(q1));
        F0(3, q1.getPaddingBottom());
        this.f0 = q1;
        q1.setPadding(0, 0, 0, 0);
        this.f0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    public m() {
        this(null);
    }
}