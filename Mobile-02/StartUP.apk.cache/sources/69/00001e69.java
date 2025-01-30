package com.coinbase.wallet.features.lend.models;

import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.lending.models.LendToken;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.b0.b;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import org.toshi.R;

/* compiled from: LendCoinPickerItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendCoinPickerItem$supplyRate$2 extends o implements a<String> {
    final /* synthetic */ LendCoinPickerItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendCoinPickerItem$supplyRate$2(LendCoinPickerItem lendCoinPickerItem) {
        super(0);
        this.this$0 = lendCoinPickerItem;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        int r;
        List B0;
        BigInteger bigInteger;
        List<LendToken> tokens = this.this$0.getTokens();
        r = s.r(tokens, 10);
        ArrayList arrayList = new ArrayList(r);
        for (LendToken lendToken : tokens) {
            arrayList.add(new kotlin.o(lendToken.getSupplyInterestRate(), Integer.valueOf(lendToken.getRateDecimals())));
        }
        B0 = z.B0(arrayList, new Comparator<T>() { // from class: com.coinbase.wallet.features.lend.models.LendCoinPickerItem$supplyRate$2$invoke$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = b.c((BigInteger) ((kotlin.o) t).c(), (BigInteger) ((kotlin.o) t2).c());
                return c2;
            }
        });
        if (B0.size() > 1) {
            kotlin.o oVar = (kotlin.o) p.Y(B0);
            int intValue = ((Number) oVar.b()).intValue();
            kotlin.o oVar2 = (kotlin.o) p.j0(B0);
            return LocalizedStrings.INSTANCE.get(R.string.lend_coin_apr_min_max, BigInteger_CommonKt.asRoundedPercentage((BigInteger) oVar.a(), intValue), BigInteger_CommonKt.asRoundedPercentage((BigInteger) oVar2.a(), ((Number) oVar2.b()).intValue()));
        }
        kotlin.o oVar3 = (kotlin.o) p.a0(B0);
        String str = null;
        if (oVar3 != null && (bigInteger = (BigInteger) oVar3.c()) != null) {
            str = BigInteger_CommonKt.asRoundedPercentage(bigInteger, ((Number) oVar3.d()).intValue());
        }
        return str != null ? LocalizedStrings.INSTANCE.get(R.string.lend_coin_apr, str) : Strings_CoreKt.getEmpty(Strings.INSTANCE);
    }
}