package io.branch.referral.j0;

import android.text.TextUtils;

/* compiled from: BranchContentSchema.java */
/* loaded from: classes2.dex */
public enum a {
    COMMERCE_AUCTION,
    COMMERCE_BUSINESS,
    COMMERCE_OTHER,
    COMMERCE_PRODUCT,
    COMMERCE_RESTAURANT,
    COMMERCE_SERVICE,
    COMMERCE_TRAVEL_FLIGHT,
    COMMERCE_TRAVEL_HOTEL,
    COMMERCE_TRAVEL_OTHER,
    GAME_STATE,
    MEDIA_IMAGE,
    MEDIA_MIXED,
    MEDIA_MUSIC,
    MEDIA_OTHER,
    MEDIA_VIDEO,
    OTHER,
    TEXT_ARTICLE,
    TEXT_BLOG,
    TEXT_OTHER,
    TEXT_RECIPE,
    TEXT_REVIEW,
    TEXT_SEARCH_RESULTS,
    TEXT_STORY,
    TEXT_TECHNICAL_DOC;

    public static a h(String str) {
        a[] values;
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : values()) {
                if (aVar.name().equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }
}