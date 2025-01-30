package io.branch.referral;

/* compiled from: Defines.java */
/* loaded from: classes2.dex */
public enum n {
    RedeemRewards("v1/redeem"),
    GetURL("v1/url"),
    GetApp("v1/app-link-settings"),
    RegisterInstall("v1/install"),
    RegisterClose("v1/close"),
    RegisterOpen("v1/open"),
    RegisterView("v1/register-view"),
    GetCredits("v1/credits/"),
    GetCreditHistory("v1/credithistory"),
    CompletedAction("v1/event"),
    IdentifyUser("v1/profile"),
    Logout("v1/logout"),
    GetReferralCode("v1/referralcode"),
    ValidateReferralCode("v1/referralcode/"),
    ApplyReferralCode("v1/applycode/"),
    DebugConnect("v1/debug/connect"),
    ContentEvent("v1/content-events"),
    TrackStandardEvent("v2/event/standard"),
    TrackCustomEvent("v2/event/custom");
    
    private String y;

    n(String str) {
        this.y = "";
        this.y = str;
    }

    public String h() {
        return this.y;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.y;
    }
}