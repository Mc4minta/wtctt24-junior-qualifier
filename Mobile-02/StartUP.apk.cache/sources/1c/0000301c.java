package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;

/* compiled from: ReactEditTextInputConnectionWrapper.java */
/* loaded from: classes2.dex */
class d extends InputConnectionWrapper {
    private c a;

    /* renamed from: b  reason: collision with root package name */
    private com.facebook.react.uimanager.events.d f5504b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5505c;

    /* renamed from: d  reason: collision with root package name */
    private String f5506d;

    public d(InputConnection inputConnection, ReactContext reactContext, c cVar) {
        super(inputConnection, false);
        this.f5506d = null;
        this.f5504b = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.a = cVar;
    }

    private void a(String str) {
        if (str.equals("\n")) {
            str = "Enter";
        }
        this.f5504b.v(new j(this.a.getId(), str));
    }

    private void b(String str) {
        if (this.f5505c) {
            this.f5506d = str;
        } else {
            a(str);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f5505c = true;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i2) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 2) {
            if (charSequence2.equals("")) {
                charSequence2 = "Backspace";
            }
            b(charSequence2);
        }
        return super.commitText(charSequence, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        a("Backspace");
        return super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        this.f5505c = false;
        String str = this.f5506d;
        if (str != null) {
            a(str);
            this.f5506d = null;
        }
        return super.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 67) {
                a("Backspace");
            } else if (keyEvent.getKeyCode() == 66) {
                a("Enter");
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i2) {
        int selectionStart = this.a.getSelectionStart();
        int selectionEnd = this.a.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i2);
        int selectionStart2 = this.a.getSelectionStart();
        boolean z = false;
        boolean z2 = selectionStart == selectionEnd;
        boolean z3 = selectionStart2 == selectionStart;
        if (selectionStart2 < selectionStart || selectionStart2 <= 0) {
            z = true;
        }
        b((z || (!z2 && z3)) ? "Backspace" : String.valueOf(this.a.getText().charAt(selectionStart2 - 1)));
        return composingText;
    }
}