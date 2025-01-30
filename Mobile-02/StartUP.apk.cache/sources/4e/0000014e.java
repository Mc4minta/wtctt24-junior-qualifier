package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
final class t {
    private TextView a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f894b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TextView textView) {
        this.a = (TextView) androidx.core.util.h.b(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f894b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f894b = textClassifier;
    }
}