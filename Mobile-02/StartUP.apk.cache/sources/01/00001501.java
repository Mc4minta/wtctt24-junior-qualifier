package com.coinbase.wallet.commonui.views;

import android.view.View;
import c.h.k.d0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StyledFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", "Landroid/view/View;", "view", "Lc/h/k/d0;", "insets", "applyWindowInsets", "(Landroid/view/View;Lc/h/k/d0;)Lc/h/k/d0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Attributes", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface StyledFragment {

    /* compiled from: StyledFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static d0 applyWindowInsets(StyledFragment styledFragment, View view, d0 insets) {
            m.g(styledFragment, "this");
            m.g(view, "view");
            m.g(insets, "insets");
            c.h.e.b f2 = insets.f(d0.m.b());
            m.f(f2, "insets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), f2.f2928e);
            return insets;
        }

        public static Attributes getAttributes(StyledFragment styledFragment) {
            Attributes attributes;
            m.g(styledFragment, "this");
            attributes = StyledFragmentKt.DEFAULT_ATTRIBUTES;
            return attributes;
        }
    }

    d0 applyWindowInsets(View view, d0 d0Var);

    Attributes getAttributes();

    /* compiled from: StyledFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\b\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0007\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "", "", "component1", "()Z", "component2", "component3", "isFullScreen", "isDarkTheme", "hasDarkNavBar", "copy", "(ZZZ)Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasDarkNavBar", "<init>", "(ZZZ)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Attributes {
        private final boolean hasDarkNavBar;
        private final boolean isDarkTheme;
        private final boolean isFullScreen;

        public Attributes() {
            this(false, false, false, 7, null);
        }

        public Attributes(boolean z, boolean z2, boolean z3) {
            this.isFullScreen = z;
            this.isDarkTheme = z2;
            this.hasDarkNavBar = z3;
        }

        public static /* synthetic */ Attributes copy$default(Attributes attributes, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = attributes.isFullScreen;
            }
            if ((i2 & 2) != 0) {
                z2 = attributes.isDarkTheme;
            }
            if ((i2 & 4) != 0) {
                z3 = attributes.hasDarkNavBar;
            }
            return attributes.copy(z, z2, z3);
        }

        public final boolean component1() {
            return this.isFullScreen;
        }

        public final boolean component2() {
            return this.isDarkTheme;
        }

        public final boolean component3() {
            return this.hasDarkNavBar;
        }

        public final Attributes copy(boolean z, boolean z2, boolean z3) {
            return new Attributes(z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Attributes) {
                Attributes attributes = (Attributes) obj;
                return this.isFullScreen == attributes.isFullScreen && this.isDarkTheme == attributes.isDarkTheme && this.hasDarkNavBar == attributes.hasDarkNavBar;
            }
            return false;
        }

        public final boolean getHasDarkNavBar() {
            return this.hasDarkNavBar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z = this.isFullScreen;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i2 = r0 * 31;
            ?? r2 = this.isDarkTheme;
            int i3 = r2;
            if (r2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z2 = this.hasDarkNavBar;
            return i4 + (z2 ? 1 : z2 ? 1 : 0);
        }

        public final boolean isDarkTheme() {
            return this.isDarkTheme;
        }

        public final boolean isFullScreen() {
            return this.isFullScreen;
        }

        public String toString() {
            return "Attributes(isFullScreen=" + this.isFullScreen + ", isDarkTheme=" + this.isDarkTheme + ", hasDarkNavBar=" + this.hasDarkNavBar + ')';
        }

        public /* synthetic */ Attributes(boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3);
        }
    }
}