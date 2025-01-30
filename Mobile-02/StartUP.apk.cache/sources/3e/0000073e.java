package com.appsflyer.internal.model.event;

/* loaded from: classes.dex */
public class ProxyEvent extends BackgroundEvent {

    /* renamed from: ɪ  reason: contains not printable characters */
    private String f278;

    public ProxyEvent() {
        super(null, null, Boolean.FALSE, null, null);
    }

    public BackgroundEvent body(String str) {
        this.f278 = str;
        return this;
    }

    @Override // com.appsflyer.internal.model.event.BackgroundEvent
    public String body() {
        return this.f278;
    }
}