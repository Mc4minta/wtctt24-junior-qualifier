package com.toshi.view.custom.recoveryPhrase;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import e.j.f.y;
import e.j.m.a.q;
import e.j.m.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: SuggestionsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/toshi/view/custom/recoveryPhrase/SuggestionsView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/x;", "a", "()V", "", "", "suggestions", "setSuggestions", "(Ljava/util/List;)V", "Lkotlin/Function1;", "listener", "setOnItemClickedListener", "(Lkotlin/e0/c/l;)V", "Le/j/m/a/q;", "Le/j/m/a/q;", "suggestionsAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SuggestionsView extends RecyclerView {
    private final q a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        this.a = new q();
        a();
    }

    private final void a() {
        y.a(this);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        setAdapter(this.a);
        setOverScrollMode(2);
        addItemDecoration(new b(View_CommonKt.getPxSize(this, R.dimen.view_size_8), false, false, false, false, 14, null));
    }

    public final void setOnItemClickedListener(l<? super String, x> listener) {
        m.g(listener, "listener");
        this.a.d(listener);
    }

    public final void setSuggestions(List<String> suggestions) {
        m.g(suggestions, "suggestions");
        this.a.e(suggestions);
        setMinimumHeight(getHeight());
    }
}