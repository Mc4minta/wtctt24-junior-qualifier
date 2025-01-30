package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import c.a.o.b;
import c.h.k.e;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class h extends Dialog implements e {
    private f mDelegate;
    private final e.a mKeyDispatcher;

    /* compiled from: AppCompatDialog.java */
    /* loaded from: classes.dex */
    class a implements e.a {
        a() {
        }

        @Override // c.h.k.e.a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return h.this.superDispatchKeyEvent(keyEvent);
        }
    }

    public h(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(c.a.a.z, typedValue, true);
            return typedValue.resourceId;
        }
        return i2;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().d(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().s();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return c.h.k.e.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) getDelegate().i(i2);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.h(this, this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().n();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().o();
        super.onCreate(bundle);
        getDelegate().r(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().x();
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeFinished(c.a.o.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeStarted(c.a.o.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public c.a.o.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        getDelegate().B(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().G(charSequence);
    }

    boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().A(i2);
    }

    public h(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        this.mKeyDispatcher = new a();
        f delegate = getDelegate();
        delegate.F(getThemeResId(context, i2));
        delegate.r(null);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().C(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().D(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        getDelegate().G(getContext().getString(i2));
    }

    protected h(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new a();
    }
}