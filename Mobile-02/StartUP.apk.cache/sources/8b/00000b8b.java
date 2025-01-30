package com.coinbase.android.apiv3.generated.authed.announcement_cards;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: AnnouncementCards.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u0012\u0010\rJ+\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCards;", "", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "dismissAnnouncementCard", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardRequest;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardResponse;", "getAnnouncementCard", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardRequest;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardResponse;", "getBuyUpsellCard", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetBuyUpsellCardRequest;)Lh/c/b0;", "getTradeDrawerPromotionCard", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/ListRecommendationCardsRequest;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/ListRecommendationCardsResponse;", "listRecommendationCards", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/ListRecommendationCardsRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface AnnouncementCards {
    @o("coinbase.public_api.authed.announcement_cards.AnnouncementCards/DismissAnnouncementCard")
    b0<NetworkResponse<DismissAnnouncementCardResponse, V3Error>> dismissAnnouncementCard(@a DismissAnnouncementCardRequest dismissAnnouncementCardRequest);

    @f("coinbase.public_api.authed.announcement_cards.AnnouncementCards/GetAnnouncementCard")
    b0<NetworkResponse<GetAnnouncementCardResponse, V3Error>> getAnnouncementCard(@t("q") GetAnnouncementCardRequest getAnnouncementCardRequest);

    @f("coinbase.public_api.authed.announcement_cards.AnnouncementCards/GetBuyUpsellCard")
    b0<NetworkResponse<GetBuyUpsellCardResponse, V3Error>> getBuyUpsellCard(@t("q") GetBuyUpsellCardRequest getBuyUpsellCardRequest);

    @f("coinbase.public_api.authed.announcement_cards.AnnouncementCards/GetTradeDrawerPromotionCard")
    b0<NetworkResponse<GetAnnouncementCardResponse, V3Error>> getTradeDrawerPromotionCard(@t("q") GetAnnouncementCardRequest getAnnouncementCardRequest);

    @f("coinbase.public_api.authed.announcement_cards.AnnouncementCards/ListRecommendationCards")
    b0<NetworkResponse<ListRecommendationCardsResponse, V3Error>> listRecommendationCards(@t("q") ListRecommendationCardsRequest listRecommendationCardsRequest);
}