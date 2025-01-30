package com.coinbase.wallet.features.send.repositories;

import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: RecipientRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u001e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/l0/k;", "validCharactersRegex", "Lkotlin/l0/k;", "", "bitcoincashPrefix", "Ljava/lang/String;", "", "minSearchCharacters", "I", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "bitcoincashPattern", "Ljava/util/regex/Pattern;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecipientRepositoryKt {
    private static final String bitcoincashPrefix = "bitcoincash:";
    private static final int minSearchCharacters = 3;
    private static final kotlin.l0.k validCharactersRegex = new kotlin.l0.k("^[a-zA-Z\\.\\-\\_0-9]+$");
    private static final Pattern bitcoincashPattern = Pattern.compile("^(bitcoincash\\:){1}([a-zA-Z\\.\\-\\_0-9]+)$");
}