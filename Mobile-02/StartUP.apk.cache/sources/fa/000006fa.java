package com.appsflyer;

import java.util.Map;

/* loaded from: classes.dex */
public interface ConversionDataListener {
    void onConversionDataLoaded(Map<String, Object> map);

    void onConversionFailure(String str);
}