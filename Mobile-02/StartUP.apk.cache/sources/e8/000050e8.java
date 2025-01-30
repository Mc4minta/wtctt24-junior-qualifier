package io.branch.referral;

import com.appsflyer.AppsFlyerProperties;

/* compiled from: Defines.java */
/* loaded from: classes2.dex */
public enum m {
    Tags("tags"),
    Alias("alias"),
    Type("type"),
    Duration("duration"),
    Channel(AppsFlyerProperties.CHANNEL),
    Feature("feature"),
    Stage("stage"),
    Campaign("campaign"),
    Data("data"),
    URL("url");
    
    private String m;

    m(String str) {
        this.m = "";
        this.m = str;
    }

    public String h() {
        return this.m;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.m;
    }
}