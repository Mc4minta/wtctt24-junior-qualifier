package com.appsflyer.internal.model.event;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class Purchase extends BackgroundEvent {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Purchase() {
        this(null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Purchase(String str, Boolean bool, Context context) {
        super(str, Boolean.FALSE, null, bool, context);
    }
}