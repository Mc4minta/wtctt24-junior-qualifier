package com.toshi.view.custom.recoveryPhrase.keyboard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.google.android.flexbox.FlexboxLayout;
import com.toshi.view.custom.o;
import com.toshi.view.custom.recoveryPhrase.keyboard.m.a;
import e.j.f.y;
import java.util.Objects;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: RecoveryPhraseKeyboardKeyBuilder.kt */
/* loaded from: classes2.dex */
public final class l {
    private final TextView c(Context context, int i2, int i3, int i4) {
        TextView textView = new TextView(context);
        textView.setBackground(y.c(textView, i2));
        textView.setGravity(17);
        String d2 = y.d(textView, i3);
        Objects.requireNonNull(d2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = d2.toLowerCase();
        m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        textView.setText(lowerCase);
        textView.setElevation(View_CommonKt.getPxSize(textView, R.dimen.elevation_default));
        textView.setTextSize(0, View_CommonKt.getPxSize(textView, R.dimen.text_size_subtitle));
        textView.setTextColor(y.b(textView, i4));
        return textView;
    }

    private final void i(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout.LayoutParams");
        FlexboxLayout.a aVar = (FlexboxLayout.a) layoutParams;
        ((ViewGroup.MarginLayoutParams) aVar).width = -2;
        ((ViewGroup.MarginLayoutParams) aVar).height = View_CommonKt.getPxSize(view, R.dimen.keyboard_key_height);
        aVar.b(1.0f);
        aVar.a(0.25f);
        k(view, aVar, z);
    }

    private final void k(View view, FlexboxLayout.a aVar, boolean z) {
        if (z) {
            return;
        }
        aVar.setMarginEnd(View_CommonKt.getPxSize(view, R.dimen.view_size_8));
    }

    private final void l(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout.LayoutParams");
        FlexboxLayout.a aVar = (FlexboxLayout.a) layoutParams;
        ((ViewGroup.MarginLayoutParams) aVar).width = View_CommonKt.getPxSize(view, R.dimen.keyboard_backspace_width);
        ((ViewGroup.MarginLayoutParams) aVar).height = View_CommonKt.getPxSize(view, R.dimen.keyboard_key_height);
        aVar.b(1.0f);
        k(view, aVar, z);
    }

    private final void m(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout.LayoutParams");
        FlexboxLayout.a aVar = (FlexboxLayout.a) layoutParams;
        ((ViewGroup.MarginLayoutParams) aVar).width = -2;
        ((ViewGroup.MarginLayoutParams) aVar).height = View_CommonKt.getPxSize(view, R.dimen.keyboard_key_height);
        aVar.a(0.5f);
        k(view, aVar, z);
    }

    private final void n(TextView textView, boolean z) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout.LayoutParams");
        FlexboxLayout.a aVar = (FlexboxLayout.a) layoutParams;
        ((ViewGroup.MarginLayoutParams) aVar).width = View_CommonKt.getPxSize(textView, R.dimen.keyboard_key_width);
        ((ViewGroup.MarginLayoutParams) aVar).height = View_CommonKt.getPxSize(textView, R.dimen.keyboard_key_height);
        aVar.b(1.0f);
        k(textView, aVar, z);
    }

    public final o a(Context context) {
        m.g(context, "context");
        o oVar = new o(context);
        oVar.setBackground(y.c(oVar, R.drawable.keyboard_action_key_background));
        oVar.setForegroundResource(R.drawable.ic_backspace);
        oVar.setElevation(View_CommonKt.getPxSize(oVar, R.dimen.elevation_default));
        return oVar;
    }

    public final o b(Context context) {
        m.g(context, "context");
        o oVar = new o(context);
        oVar.setForegroundResource(R.drawable.ic_language);
        oVar.setBackground(y.c(oVar, R.drawable.keyboard_action_key_background));
        oVar.setElevation(View_CommonKt.getPxSize(oVar, R.dimen.elevation_default));
        return oVar;
    }

    public final TextView d(Context context) {
        m.g(context, "context");
        return c(context, R.drawable.keyboard_with_action_key_background, R.string.next, R.color.textColorContrast);
    }

    public final TextView e(Context context) {
        m.g(context, "context");
        return c(context, R.drawable.keyboard_action_key_background, R.string.return_key, R.color.keyboard_tex_color_disabled);
    }

    public final o f(Context context) {
        m.g(context, "context");
        o oVar = new o(context);
        oVar.setForegroundResource(R.drawable.ic_shift);
        oVar.setBackground(y.c(oVar, R.drawable.keyboard_action_key_background));
        oVar.setElevation(View_CommonKt.getPxSize(oVar, R.dimen.elevation_default));
        return oVar;
    }

    public final TextView g(Context context) {
        m.g(context, "context");
        TextView textView = new TextView(context);
        textView.setBackground(y.c(textView, R.drawable.keyboard_char_key_background));
        textView.setGravity(17);
        String d2 = y.d(textView, R.string.next);
        Objects.requireNonNull(d2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = d2.toLowerCase();
        m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        textView.setText(lowerCase);
        textView.setElevation(View_CommonKt.getPxSize(textView, R.dimen.elevation_default));
        textView.setTextSize(0, View_CommonKt.getPxSize(textView, R.dimen.text_size_subtitle));
        textView.setTextColor(y.b(textView, R.color.textColorPrimary));
        return textView;
    }

    public final TextView h(Context context, String value) {
        m.g(context, "context");
        m.g(value, "value");
        TextView textView = new TextView(context);
        textView.setBackground(y.c(textView, R.drawable.keyboard_char_key_background));
        textView.setGravity(17);
        textView.setText(value);
        textView.setElevation(View_CommonKt.getPxSize(textView, R.dimen.elevation_default));
        textView.setTextColor(y.b(textView, R.color.textColorPrimary));
        textView.setTextSize(0, View_CommonKt.getPxSize(textView, R.dimen.text_size_keyboard));
        return textView;
    }

    public final void j(boolean z, View view, Object key) {
        m.g(view, "view");
        m.g(key, "key");
        if (key == a.b.BACKSPACE) {
            l(view, z);
        } else if (key == a.b.SHIFT) {
            l(view, z);
        } else if (key == a.b.LANGUAGE) {
            i(view, z);
        } else if (key == a.b.SPACEBAR) {
            m(view, z);
        } else if (key == a.b.RETURN) {
            i(view, z);
        } else if (view instanceof TextView) {
            n((TextView) view, z);
        }
    }
}