package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.lend.models.UserAgreementPageItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import org.toshi.R;

/* compiled from: LendUserAgreementViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/coinbase/wallet/features/lend/models/UserAgreementPageItem;", "<anonymous>", "()Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendUserAgreementViewModel$data$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<List<? extends UserAgreementPageItem>> {
    public static final LendUserAgreementViewModel$data$2 INSTANCE = new LendUserAgreementViewModel$data$2();

    LendUserAgreementViewModel$data$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final List<? extends UserAgreementPageItem> invoke() {
        List<? extends UserAgreementPageItem> j2;
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        j2 = r.j(new UserAgreementPageItem(localizedStrings.get(R.string.lend_user_agreement_page_1_title), localizedStrings.get(R.string.lend_user_agreement_page_1_body), R.drawable.illustration_lend_interest, false), new UserAgreementPageItem(localizedStrings.get(R.string.lend_user_agreement_page_2_title), localizedStrings.get(R.string.lend_user_agreement_page_2_body), R.drawable.illustration_caution, true));
        return j2;
    }
}