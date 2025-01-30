package com.toshi.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.v;
import kotlin.x;
import org.spongycastle.i18n.TextBundle;
import org.toshi.R;

/* compiled from: VerifyBackupPhraseView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001a/B\u001d\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J!\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u001b\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f¢\u0006\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00100R*\u00105\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R\u0016\u00106\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00100¨\u0006>"}, d2 = {"Lcom/toshi/view/custom/VerifyBackupPhraseView;", "Landroid/widget/LinearLayout;", "Lkotlin/x;", "h", "()V", "f", "Lcom/google/android/flexbox/FlexboxLayout$a;", Constants.URL_CAMPAIGN, "()Lcom/google/android/flexbox/FlexboxLayout$a;", "Lcom/toshi/view/custom/BoxTextView;", "e", "()Lcom/toshi/view/custom/BoxTextView;", "d", "g", "clickedView", "Lcom/toshi/view/custom/VerifyBackupPhraseView$b;", "moveType", "q", "(Lcom/toshi/view/custom/BoxTextView;Lcom/toshi/view/custom/VerifyBackupPhraseView$b;)V", "n", "m", "textView", "", TextBundle.TEXT_ENTRY, "p", "(Lcom/toshi/view/custom/BoxTextView;Ljava/lang/String;)V", "a", "", "i", "()Z", "j", "", "recoveryPhrase", "setBackupPhrase", "(Ljava/util/List;)V", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "deselectWordClickListener", "Lkotlin/Function0;", "Lkotlin/e0/c/a;", "getOnErrorListener", "()Lkotlin/e0/c/a;", "setOnErrorListener", "(Lkotlin/e0/c/a;)V", "onErrorListener", "", "Lcom/toshi/view/custom/VerifyBackupPhraseView$a;", "b", "Ljava/util/List;", "userInputtedBackupPhrase", "shuffledBackupPhrase", "getOnFinishedListener", "setOnFinishedListener", "onFinishedListener", "selectWordClickListener", "correctBackupPhrase", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class VerifyBackupPhraseView extends LinearLayout {
    private final List<a> a;

    /* renamed from: b */
    private final List<a> f11175b;

    /* renamed from: c */
    private final List<a> f11176c;

    /* renamed from: d */
    private kotlin.e0.c.a<x> f11177d;

    /* renamed from: e */
    private kotlin.e0.c.a<x> f11178e;

    /* renamed from: f */
    private final View.OnClickListener f11179f;

    /* renamed from: g */
    private final View.OnClickListener f11180g;

    /* compiled from: VerifyBackupPhraseView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final String a;

        /* renamed from: b */
        private boolean f11181b;

        public a(String word, boolean z) {
            kotlin.jvm.internal.m.g(word, "word");
            this.a = word;
            this.f11181b = z;
        }

        public final boolean a() {
            return this.f11181b;
        }

        public final String b() {
            return this.a;
        }

        public final void c(boolean z) {
            this.f11181b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return kotlin.jvm.internal.m.c(this.a, aVar.a) && this.f11181b == aVar.f11181b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            boolean z = this.f11181b;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return hashCode + i2;
        }

        public String toString() {
            return "KeywordViewInfo(word=" + this.a + ", visibleInList=" + this.f11181b + ')';
        }
    }

    /* compiled from: VerifyBackupPhraseView.kt */
    /* loaded from: classes2.dex */
    public enum b {
        ToShuffledList,
        ToInputtedList
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int c2;
            c2 = kotlin.b0.b.c(Boolean.valueOf(!((a) t).a()), Boolean.valueOf(!((a) t2).a()));
            return c2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyBackupPhraseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        LinearLayout.inflate(context, R.layout.view_verify_backup_phrase, this);
        this.a = new ArrayList();
        this.f11175b = new ArrayList();
        this.f11176c = new ArrayList();
        this.f11179f = new View.OnClickListener() { // from class: com.toshi.view.custom.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyBackupPhraseView.k(VerifyBackupPhraseView.this, view);
            }
        };
        this.f11180g = new View.OnClickListener() { // from class: com.toshi.view.custom.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyBackupPhraseView.l(VerifyBackupPhraseView.this, view);
            }
        };
    }

    private final void a() {
        kotlin.e0.c.a<x> aVar;
        if (i()) {
            kotlin.e0.c.a<x> aVar2 = this.f11177d;
            if (aVar2 == null) {
                return;
            }
            aVar2.invoke();
        } else if (i() || !j() || (aVar = this.f11178e) == null) {
        } else {
            aVar.invoke();
        }
    }

    public static final void b(VerifyBackupPhraseView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        BoxTextView boxTextView = view instanceof BoxTextView ? (BoxTextView) view : null;
        if (boxTextView == null) {
            return;
        }
        this$0.q(boxTextView, b.ToShuffledList);
    }

    private final FlexboxLayout.a c() {
        FlexboxLayout.a aVar = new FlexboxLayout.a(-2, -2);
        int pxSize = View_CommonKt.getPxSize(this, R.dimen.backup_phrase_spacing);
        aVar.setMargins(0, 0, pxSize, pxSize);
        return aVar;
    }

    private final BoxTextView d() {
        View inflate = LinearLayout.inflate(getContext(), R.layout.view_drag_and_drop_text_view, null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.toshi.view.custom.BoxTextView");
        return (BoxTextView) inflate;
    }

    private final BoxTextView e() {
        View inflate = LinearLayout.inflate(getContext(), R.layout.view_drag_and_drop_text_view, null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.toshi.view.custom.BoxTextView");
        return (BoxTextView) inflate;
    }

    private final void f() {
        FlexboxLayout.a c2 = c();
        ((FlexboxLayout) findViewById(e.j.a.shuffledPhraseView)).removeAllViews();
        ((FlexboxLayout) findViewById(e.j.a.userInputtedPhraseView)).removeAllViews();
        for (a aVar : this.f11176c) {
            BoxTextView e2 = e();
            ((FlexboxLayout) findViewById(e.j.a.shuffledPhraseView)).addView(d(), c2);
            ((FlexboxLayout) findViewById(e.j.a.userInputtedPhraseView)).addView(e2, c2);
        }
        ((FlexboxLayout) findViewById(e.j.a.shuffledPhraseView)).requestLayout();
        ((FlexboxLayout) findViewById(e.j.a.userInputtedPhraseView)).requestLayout();
    }

    private final void g() {
        int childCount = ((FlexboxLayout) findViewById(e.j.a.shuffledPhraseView)).getChildCount();
        int i2 = 0;
        if (childCount > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                View childAt = ((FlexboxLayout) findViewById(e.j.a.shuffledPhraseView)).getChildAt(i3);
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.toshi.view.custom.BoxTextView");
                ((BoxTextView) childAt).setOnClickListener(this.f11179f);
                if (i4 >= childCount) {
                    break;
                }
                i3 = i4;
            }
        }
        int childCount2 = ((FlexboxLayout) findViewById(e.j.a.userInputtedPhraseView)).getChildCount();
        if (childCount2 <= 0) {
            return;
        }
        while (true) {
            int i5 = i2 + 1;
            View childAt2 = ((FlexboxLayout) findViewById(e.j.a.userInputtedPhraseView)).getChildAt(i2);
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type com.toshi.view.custom.BoxTextView");
            ((BoxTextView) childAt2).setOnClickListener(this.f11180g);
            if (i5 >= childCount2) {
                return;
            }
            i2 = i5;
        }
    }

    private final void h() {
        f();
        g();
        n();
        m();
    }

    private final boolean i() {
        return kotlin.jvm.internal.m.c(this.a, this.f11175b);
    }

    private final boolean j() {
        List<a> list = this.f11175b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (a aVar : list) {
            if (!aVar.a()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void k(VerifyBackupPhraseView verifyBackupPhraseView, View view) {
        o(verifyBackupPhraseView, view);
    }

    public static /* synthetic */ void l(VerifyBackupPhraseView verifyBackupPhraseView, View view) {
        b(verifyBackupPhraseView, view);
    }

    private final void m() {
        int size = this.f11176c.size() - 1;
        if (size < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = ((FlexboxLayout) findViewById(e.j.a.shuffledPhraseView)).getChildAt(i2);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.toshi.view.custom.BoxTextView");
            BoxTextView boxTextView = (BoxTextView) childAt;
            a aVar = this.f11176c.get(i2);
            p(boxTextView, aVar.b());
            boxTextView.setVisibility(aVar.a() ^ true ? 4 : 0);
            if (i3 > size) {
                return;
            }
            i2 = i3;
        }
    }

    private final void n() {
        int size = this.f11175b.size() - 1;
        if (size < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = ((FlexboxLayout) findViewById(e.j.a.userInputtedPhraseView)).getChildAt(i2);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.toshi.view.custom.BoxTextView");
            BoxTextView boxTextView = (BoxTextView) childAt;
            a aVar = this.f11175b.get(i2);
            p(boxTextView, aVar.b());
            boxTextView.setVisibility(aVar.a() ^ true ? 4 : 0);
            if (i3 > size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final void o(VerifyBackupPhraseView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        BoxTextView boxTextView = view instanceof BoxTextView ? (BoxTextView) view : null;
        if (boxTextView == null) {
            return;
        }
        this$0.q(boxTextView, b.ToInputtedList);
    }

    private final void p(BoxTextView boxTextView, String str) {
        boxTextView.setText(str);
        boxTextView.setBackgroundResource(str != null ? R.drawable.backup_phrase_background : 0);
    }

    private final void q(BoxTextView boxTextView, b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String text = boxTextView.getText();
        if (bVar == b.ToShuffledList) {
            for (a aVar : this.f11176c) {
                if (!kotlin.jvm.internal.m.c(aVar.b(), text) || aVar.a()) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (z3) {
                    aVar.c(true);
                    for (a aVar2 : this.f11175b) {
                        if (kotlin.jvm.internal.m.c(aVar2.b(), text) && aVar2.a()) {
                            z4 = true;
                            continue;
                        } else {
                            z4 = false;
                            continue;
                        }
                        if (z4) {
                            aVar2.c(false);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } else if (bVar == b.ToInputtedList) {
            for (a aVar3 : this.f11176c) {
                if (kotlin.jvm.internal.m.c(aVar3.b(), text) && aVar3.a()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    aVar3.c(false);
                    for (a aVar4 : this.f11175b) {
                        if (!kotlin.jvm.internal.m.c(aVar4.b(), text) || aVar4.a()) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            aVar4.c(true);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        List<a> list = this.f11175b;
        if (list.size() > 1) {
            v.x(list, new c());
        }
        n();
        m();
        a();
    }

    public final kotlin.e0.c.a<x> getOnErrorListener() {
        return this.f11178e;
    }

    public final kotlin.e0.c.a<x> getOnFinishedListener() {
        return this.f11177d;
    }

    public final void setBackupPhrase(List<String> recoveryPhrase) {
        int r;
        int r2;
        int r3;
        kotlin.jvm.internal.m.g(recoveryPhrase, "recoveryPhrase");
        List<a> list = this.a;
        list.clear();
        r = kotlin.a0.s.r(recoveryPhrase, 10);
        ArrayList arrayList = new ArrayList(r);
        for (String str : recoveryPhrase) {
            arrayList.add(new a(str, true));
        }
        list.addAll(arrayList);
        List<a> list2 = this.f11175b;
        list2.clear();
        r2 = kotlin.a0.s.r(recoveryPhrase, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (String str2 : recoveryPhrase) {
            arrayList2.add(new a(str2, false));
        }
        list2.addAll(arrayList2);
        Collections.shuffle(list2);
        List<a> list3 = this.f11176c;
        list3.clear();
        r3 = kotlin.a0.s.r(recoveryPhrase, 10);
        ArrayList arrayList3 = new ArrayList(r3);
        for (String str3 : recoveryPhrase) {
            arrayList3.add(new a(str3, true));
        }
        list3.addAll(arrayList3);
        Collections.shuffle(list3);
        h();
    }

    public final void setOnErrorListener(kotlin.e0.c.a<x> aVar) {
        this.f11178e = aVar;
    }

    public final void setOnFinishedListener(kotlin.e0.c.a<x> aVar) {
        this.f11177d = aVar;
    }
}