package io.branch.referral.j0;

import android.text.TextUtils;

/* compiled from: ProductCategory.java */
/* loaded from: classes2.dex */
public enum e {
    ANIMALS_AND_PET_SUPPLIES("Animals & Pet Supplies"),
    APPAREL_AND_ACCESSORIES("Apparel & Accessories"),
    ARTS_AND_ENTERTAINMENT("Arts & Entertainment"),
    BABY_AND_TODDLER("Baby & Toddler"),
    BUSINESS_AND_INDUSTRIAL("Business & Industrial"),
    CAMERAS_AND_OPTICS("Cameras & Optics"),
    ELECTRONICS("Electronics"),
    FOOD_BEVERAGES_AND_TOBACCO("Food, Beverages & Tobacco"),
    FURNITURE("Furniture"),
    HARDWARE("Hardware"),
    HEALTH_AND_BEAUTY("Health & Beauty"),
    HOME_AND_GARDEN("Home & Garden"),
    LUGGAGE_AND_BAGS("Luggage & Bags"),
    MATURE("Mature"),
    MEDIA("Media"),
    OFFICE_SUPPLIES("Office Supplies"),
    RELIGIOUS_AND_CEREMONIAL("Religious & Ceremonial"),
    SOFTWARE("Software"),
    SPORTING_GOODS("Sporting Goods"),
    TOYS_AND_GAMES("Toys & Games"),
    VEHICLES_AND_PARTS("Vehicles & Parts");
    
    private String A;

    e(String str) {
        this.A = str;
    }

    public static e n(String str) {
        e[] values;
        if (!TextUtils.isEmpty(str)) {
            for (e eVar : values()) {
                if (eVar.A.equalsIgnoreCase(str)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    public String h() {
        return this.A;
    }
}