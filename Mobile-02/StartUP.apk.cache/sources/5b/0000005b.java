package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class c extends h implements DialogInterface {
    final AlertController a;

    /* compiled from: AlertDialog.java */
    /* loaded from: classes.dex */
    public static class a {
        private final AlertController.f a;

        /* renamed from: b  reason: collision with root package name */
        private final int f447b;

        public a(Context context) {
            this(context, c.b(context, 0));
        }

        public c a() {
            c cVar = new c(this.a.a, this.f447b);
            this.a.a(cVar.a);
            cVar.setCancelable(this.a.r);
            if (this.a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.a.s);
            cVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.a.a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.a.f433g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.a.f430d = drawable;
            return this;
        }

        public a f(int i2) {
            AlertController.f fVar = this.a;
            fVar.f434h = fVar.a.getText(i2);
            return this;
        }

        public a g(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.f438l = fVar.a.getText(i2);
            this.a.n = onClickListener;
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.f438l = charSequence;
            fVar.n = onClickListener;
            return this;
        }

        public a i(DialogInterface.OnCancelListener onCancelListener) {
            this.a.s = onCancelListener;
            return this;
        }

        public a j(DialogInterface.OnDismissListener onDismissListener) {
            this.a.t = onDismissListener;
            return this;
        }

        public a k(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a l(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.f435i = fVar.a.getText(i2);
            this.a.f437k = onClickListener;
            return this;
        }

        public a m(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public a n(int i2) {
            AlertController.f fVar = this.a;
            fVar.f432f = fVar.a.getText(i2);
            return this;
        }

        public a o(CharSequence charSequence) {
            this.a.f432f = charSequence;
            return this;
        }

        public a p(View view) {
            AlertController.f fVar = this.a;
            fVar.z = view;
            fVar.y = 0;
            fVar.E = false;
            return this;
        }

        public c q() {
            c a = a();
            a.show();
            return a;
        }

        public a(Context context, int i2) {
            this.a = new AlertController.f(new ContextThemeWrapper(context, c.b(context, i2)));
            this.f447b = i2;
        }
    }

    protected c(Context context, int i2) {
        super(context, b(context, i2));
        this.a = new AlertController(getContext(), this, getWindow());
    }

    static int b(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.a.o, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.a.g(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.a.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.q(charSequence);
    }
}