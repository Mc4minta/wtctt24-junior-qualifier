package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.features.send.models.AddressSearchResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062^\u0010\u0005\u001aZ\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004 \u0003*,\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/features/send/models/AddressSearchResult;", "kotlin.jvm.PlatformType", "", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerViewModel$search$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends List<? extends AddressSearchResult>, ? extends Boolean>, kotlin.x> {
    final /* synthetic */ String $metadata;
    final /* synthetic */ String $query;
    final /* synthetic */ SendDestinationPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerViewModel$search$2(String str, SendDestinationPickerViewModel sendDestinationPickerViewModel, String str2) {
        super(1);
        this.$query = str;
        this.this$0 = sendDestinationPickerViewModel;
        this.$metadata = str2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends List<? extends AddressSearchResult>, ? extends Boolean> oVar) {
        invoke2((kotlin.o<? extends List<AddressSearchResult>, Boolean>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends List<AddressSearchResult>, Boolean> oVar) {
        String str;
        boolean isValidMetadata;
        List<AddressSearchResult> searchResults = oVar.a();
        Boolean isValidAddress = oVar.b();
        String str2 = this.$query;
        str = this.this$0.currentSearchQuery;
        if (kotlin.jvm.internal.m.c(str2, str)) {
            SendDestinationPickerViewModel sendDestinationPickerViewModel = this.this$0;
            String str3 = this.$query;
            kotlin.jvm.internal.m.f(searchResults, "searchResults");
            kotlin.jvm.internal.m.f(isValidAddress, "isValidAddress");
            boolean booleanValue = isValidAddress.booleanValue();
            isValidMetadata = this.this$0.isValidMetadata(this.$metadata);
            sendDestinationPickerViewModel.processSearchResults(str3, searchResults, booleanValue, isValidMetadata);
        }
    }
}