package com.coinbase.wallet.features.lend.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.coinbase.wallet.features.lend.models.UserAgreementPageItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendUserAgreementAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/features/lend/views/adapters/LendUserAgreementAdapter;", "Landroidx/viewpager/widget/a;", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "object", "Lkotlin/x;", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Landroid/view/View;", "view", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "getCount", "()I", "Lkotlin/Function1;", "onAgreementChecked", "Lkotlin/e0/c/l;", "", "Lcom/coinbase/wallet/features/lend/models/UserAgreementPageItem;", "pages", "Ljava/util/List;", "<init>", "(Ljava/util/List;Lkotlin/e0/c/l;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendUserAgreementAdapter extends androidx.viewpager.widget.a {
    private final l<Boolean, x> onAgreementChecked;
    private final List<UserAgreementPageItem> pages;

    /* JADX WARN: Multi-variable type inference failed */
    public LendUserAgreementAdapter(List<UserAgreementPageItem> pages, l<? super Boolean, x> onAgreementChecked) {
        m.g(pages, "pages");
        m.g(onAgreementChecked, "onAgreementChecked");
        this.pages = pages;
        this.onAgreementChecked = onAgreementChecked;
    }

    public static /* synthetic */ void a(LendUserAgreementAdapter lendUserAgreementAdapter, CompoundButton compoundButton, boolean z) {
        m1295instantiateItem$lambda0(lendUserAgreementAdapter, compoundButton, z);
    }

    /* renamed from: instantiateItem$lambda-0 */
    public static final void m1295instantiateItem$lambda0(LendUserAgreementAdapter this$0, CompoundButton compoundButton, boolean z) {
        m.g(this$0, "this$0");
        this$0.onAgreementChecked.invoke(Boolean.valueOf(z));
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup container, int i2, Object object) {
        m.g(container, "container");
        m.g(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.pages.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup container, int i2) {
        m.g(container, "container");
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.lend_user_agreement_page, container, false);
        m.f(inflate, "from(container.context)\n            .inflate(R.layout.lend_user_agreement_page, container, false)");
        UserAgreementPageItem userAgreementPageItem = this.pages.get(i2);
        View findViewById = inflate.findViewById(R.id.title);
        m.f(findViewById, "layout.findViewById(R.id.title)");
        View findViewById2 = inflate.findViewById(R.id.description);
        m.f(findViewById2, "layout.findViewById(R.id.description)");
        View findViewById3 = inflate.findViewById(R.id.illustration);
        m.f(findViewById3, "layout.findViewById(R.id.illustration)");
        View findViewById4 = inflate.findViewById(R.id.lendAgreementCheckbox);
        m.f(findViewById4, "layout.findViewById(R.id.lendAgreementCheckbox)");
        CheckBox checkBox = (CheckBox) findViewById4;
        ((TextView) findViewById).setText(userAgreementPageItem.getTitle());
        ((TextView) findViewById2).setText(userAgreementPageItem.getDescription());
        ((ImageView) findViewById3).setImageResource(userAgreementPageItem.getImageId());
        if (userAgreementPageItem.getShowAgreementCheckbox()) {
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.coinbase.wallet.features.lend.views.adapters.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LendUserAgreementAdapter.a(LendUserAgreementAdapter.this, compoundButton, z);
                }
            });
        } else {
            checkBox.setVisibility(8);
            checkBox.setOnCheckedChangeListener(null);
        }
        container.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object object) {
        m.g(view, "view");
        m.g(object, "object");
        return m.c(view, object);
    }
}