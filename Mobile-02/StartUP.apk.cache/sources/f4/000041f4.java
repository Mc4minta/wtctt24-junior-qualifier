package com.toshi.view.custom;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.l0.y;
import kotlin.x;

/* compiled from: PlainTextPasteEditText.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/toshi/view/custom/PlainTextPasteEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lkotlin/x;", "a", "()V", "", "getTextFromClipboard", "()Ljava/lang/CharSequence;", "", "id", "", "onTextContextMenuItem", "(I)Z", "Lkotlin/Function1;", "d", "Lkotlin/e0/c/l;", "getOnPasteListener", "()Lkotlin/e0/c/l;", "setOnPasteListener", "(Lkotlin/e0/c/l;)V", "onPasteListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PlainTextPasteEditText extends AppCompatEditText {

    /* renamed from: d  reason: collision with root package name */
    private kotlin.e0.c.l<? super CharSequence, x> f11165d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlainTextPasteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
    }

    private final void a() {
        CharSequence h1;
        CharSequence textFromClipboard = getTextFromClipboard();
        if (textFromClipboard == null) {
            return;
        }
        ClipData newPlainText = ClipData.newPlainText("", textFromClipboard);
        if (newPlainText.getItemCount() < 1) {
            return;
        }
        ClipData.Item itemAt = newPlainText.getItemAt(0);
        CharSequence text = itemAt == null ? null : itemAt.getText();
        if (text != null) {
            h1 = y.h1(text);
            kotlin.e0.c.l<? super CharSequence, x> lVar = this.f11165d;
            if (lVar != null) {
                lVar.invoke(h1);
            }
            setText(h1);
        }
    }

    private final CharSequence getTextFromClipboard() {
        ClipData.Item itemAt;
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if ((primaryClip != null && primaryClip.getItemCount() < 1) || primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null) {
            return null;
        }
        return itemAt.getText();
    }

    public final kotlin.e0.c.l<CharSequence, x> getOnPasteListener() {
        return this.f11165d;
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        if (i2 == 16908322) {
            a();
        }
        return onTextContextMenuItem;
    }

    public final void setOnPasteListener(kotlin.e0.c.l<? super CharSequence, x> lVar) {
        this.f11165d = lVar;
    }
}