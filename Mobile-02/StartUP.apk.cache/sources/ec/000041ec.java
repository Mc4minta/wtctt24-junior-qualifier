package com.toshi.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import org.spongycastle.i18n.TextBundle;
import org.toshi.R;

/* compiled from: BoxTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/toshi/view/custom/BoxTextView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/x;", "b", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "()V", "", "getText", "()Ljava/lang/String;", TextBundle.TEXT_ENTRY, "setText", "(Ljava/lang/String;)V", "Ljava/lang/String;", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class BoxTextView extends FrameLayout {
    private String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        b(context, attributeSet);
        a();
    }

    private final void a() {
        FrameLayout.inflate(getContext(), R.layout.view_box_text_view, this);
        setText(this.a);
    }

    private final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.b.w);
        kotlin.jvm.internal.m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.BoxTextView)");
        this.a = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
    }

    public final String getText() {
        return ((TextView) findViewById(e.j.a.textView)).getText().toString();
    }

    public final void setText(String str) {
        ((TextView) findViewById(e.j.a.textView)).setText(str);
    }
}