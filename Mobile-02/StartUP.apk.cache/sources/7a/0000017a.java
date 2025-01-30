package androidx.biometric;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.coinbase.ApiConstants;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: FingerprintDialogFragment.java */
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes.dex */
public class d extends androidx.fragment.app.c {

    /* renamed from: b  reason: collision with root package name */
    private Bundle f990b;

    /* renamed from: c  reason: collision with root package name */
    private int f991c;

    /* renamed from: d  reason: collision with root package name */
    private int f992d;

    /* renamed from: e  reason: collision with root package name */
    private int f993e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f994f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f995g;

    /* renamed from: h  reason: collision with root package name */
    private Context f996h;

    /* renamed from: k  reason: collision with root package name */
    DialogInterface.OnClickListener f998k;
    private HandlerC0015d a = new HandlerC0015d();

    /* renamed from: j  reason: collision with root package name */
    private boolean f997j = true;

    /* renamed from: l  reason: collision with root package name */
    private final DialogInterface.OnClickListener f999l = new a();

    /* compiled from: FingerprintDialogFragment.java */
    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {

        /* compiled from: FingerprintDialogFragment.java */
        /* renamed from: androidx.biometric.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0014a implements Runnable {
            final /* synthetic */ DialogInterface a;

            RunnableC0014a(DialogInterface dialogInterface) {
                this.a = dialogInterface;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.onCancel(this.a);
            }
        }

        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                if (Build.VERSION.SDK_INT < 21) {
                    Log.e("FingerprintDialogFrag", "Failed to check device credential. Not supported prior to L.");
                } else {
                    m.e("FingerprintDialogFrag", d.this.getActivity(), d.this.f990b, new RunnableC0014a(dialogInterface));
                }
            }
        }
    }

    /* compiled from: FingerprintDialogFragment.java */
    /* loaded from: classes.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (d.this.w()) {
                d.this.f999l.onClick(dialogInterface, i2);
                return;
            }
            DialogInterface.OnClickListener onClickListener = d.this.f998k;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i2);
            } else {
                Log.w("FingerprintDialogFrag", "No suitable negative button listener.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FingerprintDialogFragment.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FingerprintDialogFragment.java */
    /* renamed from: androidx.biometric.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class HandlerC0015d extends Handler {
        HandlerC0015d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    d.this.v((CharSequence) message.obj);
                    return;
                case 2:
                    d.this.u((CharSequence) message.obj);
                    return;
                case 3:
                    d.this.s((CharSequence) message.obj);
                    return;
                case 4:
                    d.this.t();
                    return;
                case 5:
                    d.this.m();
                    return;
                case 6:
                    Context context = d.this.getContext();
                    d.this.f997j = context != null && m.g(context, Build.MODEL);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean A(int i2, int i3) {
        if (i2 == 0 && i3 == 1) {
            return false;
        }
        if (i2 == 1 && i3 == 2) {
            return true;
        }
        if (i2 == 2 && i3 == 1) {
            return true;
        }
        if (i2 != 1 || i3 == 3) {
        }
        return false;
    }

    private void B(int i2) {
        Drawable n;
        if (this.f994f == null || Build.VERSION.SDK_INT < 23 || (n = n(this.f993e, i2)) == null) {
            return;
        }
        AnimatedVectorDrawable animatedVectorDrawable = n instanceof AnimatedVectorDrawable ? (AnimatedVectorDrawable) n : null;
        this.f994f.setImageDrawable(n);
        if (animatedVectorDrawable != null && A(this.f993e, i2)) {
            animatedVectorDrawable.start();
        }
        this.f993e = i2;
    }

    private void l(CharSequence charSequence) {
        TextView textView = this.f995g;
        if (textView != null) {
            textView.setTextColor(this.f991c);
            if (charSequence != null) {
                this.f995g.setText(charSequence);
            } else {
                this.f995g.setText(k.fingerprint_error_lockout);
            }
        }
        this.a.postDelayed(new c(), p(this.f996h));
    }

    private Drawable n(int i2, int i3) {
        int i4;
        if (i2 == 0 && i3 == 1) {
            i4 = h.fingerprint_dialog_fp_to_error;
        } else if (i2 == 1 && i3 == 2) {
            i4 = h.fingerprint_dialog_fp_to_error;
        } else if (i2 == 2 && i3 == 1) {
            i4 = h.fingerprint_dialog_error_to_fp;
        } else if (i2 != 1 || i3 != 3) {
            return null;
        } else {
            i4 = h.fingerprint_dialog_error_to_fp;
        }
        return this.f996h.getDrawable(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(Context context) {
        return (context == null || !m.g(context, Build.MODEL)) ? 2000 : 0;
    }

    private int r(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f996h.getTheme().resolveAttribute(i2, typedValue, true);
        TypedArray obtainStyledAttributes = getActivity().obtainStyledAttributes(typedValue.data, new int[]{i2});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(CharSequence charSequence) {
        if (this.f997j) {
            m();
        } else {
            l(charSequence);
        }
        this.f997j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        B(1);
        TextView textView = this.f995g;
        if (textView != null) {
            textView.setTextColor(this.f992d);
            this.f995g.setText(this.f996h.getString(k.fingerprint_dialog_touch_sensor));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(CharSequence charSequence) {
        B(2);
        this.a.removeMessages(4);
        TextView textView = this.f995g;
        if (textView != null) {
            textView.setTextColor(this.f991c);
            this.f995g.setText(charSequence);
        }
        HandlerC0015d handlerC0015d = this.a;
        handlerC0015d.sendMessageDelayed(handlerC0015d.obtainMessage(3), p(this.f996h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(CharSequence charSequence) {
        B(2);
        this.a.removeMessages(4);
        TextView textView = this.f995g;
        if (textView != null) {
            textView.setTextColor(this.f991c);
            this.f995g.setText(charSequence);
        }
        HandlerC0015d handlerC0015d = this.a;
        handlerC0015d.sendMessageDelayed(handlerC0015d.obtainMessage(4), 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return this.f990b.getBoolean("allow_device_credential");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d x() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        if (getFragmentManager() == null) {
            Log.e("FingerprintDialogFrag", "Failed to dismiss fingerprint dialog fragment. Fragment manager was null.");
        } else {
            dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler o() {
        return this.a;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        e eVar = (e) getFragmentManager().Z("FingerprintHelperFragment");
        if (eVar != null) {
            eVar.j(1);
        }
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        this.f996h = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f991c = r(16844099);
        } else {
            this.f991c = androidx.core.content.a.d(context, g.biometric_error_color);
        }
        this.f992d = r(16842808);
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence charSequence;
        if (bundle != null && this.f990b == null) {
            this.f990b = bundle.getBundle("SavedBundle");
        }
        c.a aVar = new c.a(getContext());
        aVar.o(this.f990b.getCharSequence(MessageBundle.TITLE_ENTRY));
        View inflate = LayoutInflater.from(aVar.b()).inflate(j.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(i.fingerprint_subtitle);
        TextView textView2 = (TextView) inflate.findViewById(i.fingerprint_description);
        CharSequence charSequence2 = this.f990b.getCharSequence("subtitle");
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence2);
        }
        CharSequence charSequence3 = this.f990b.getCharSequence(ApiConstants.DESCRIPTION);
        if (TextUtils.isEmpty(charSequence3)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(charSequence3);
        }
        this.f994f = (ImageView) inflate.findViewById(i.fingerprint_icon);
        this.f995g = (TextView) inflate.findViewById(i.fingerprint_error);
        if (w()) {
            charSequence = getString(k.confirm_device_credential_password);
        } else {
            charSequence = this.f990b.getCharSequence("negative_text");
        }
        aVar.h(charSequence, new b());
        aVar.p(inflate);
        androidx.appcompat.app.c a2 = aVar.a();
        a2.setCanceledOnTouchOutside(false);
        return a2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.a.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f993e = 0;
        B(1);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle("SavedBundle", this.f990b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence q() {
        return this.f990b.getCharSequence("negative_text");
    }

    public void y(Bundle bundle) {
        this.f990b = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(DialogInterface.OnClickListener onClickListener) {
        this.f998k = onClickListener;
    }
}