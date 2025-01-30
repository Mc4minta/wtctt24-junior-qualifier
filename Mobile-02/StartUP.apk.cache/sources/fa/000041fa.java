package com.toshi.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.appsflyer.share.Constants;
import e.j.f.y;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: UsernameStatusView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/toshi/view/custom/UsernameStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/x;", "a", "()V", "b", Constants.URL_CAMPAIGN, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UsernameStatusView extends ConstraintLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameStatusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        a();
    }

    private final void a() {
        ViewGroup.inflate(getContext(), R.layout.view_username_status, this);
    }

    public final void b() {
        ((ImageView) findViewById(e.j.a.statusImage)).setImageResource(R.drawable.ic_check);
        TextView textView = (TextView) findViewById(e.j.a.statusText);
        kotlin.jvm.internal.m.f(textView, "");
        textView.setText(y.d(textView, R.string.available));
        textView.setTextColor(y.b(textView, R.color.approvedColor));
        setVisibility(0);
    }

    public final void c() {
        ((ImageView) findViewById(e.j.a.statusImage)).setImageResource(R.drawable.ic_fail);
        int i2 = e.j.a.statusText;
        TextView textView = (TextView) findViewById(i2);
        kotlin.jvm.internal.m.f(textView, "");
        ((TextView) textView.findViewById(i2)).setText(y.d(textView, R.string.not_available));
        ((TextView) textView.findViewById(i2)).setTextColor(y.b(textView, R.color.errorColor));
        setVisibility(0);
    }
}