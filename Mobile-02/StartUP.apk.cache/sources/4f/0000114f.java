package com.coinbase.wallet.analytics.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: AnalyticsUserProperty.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\"\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "", "", "", "asDictionary$analytics_release", "()Ljava/util/Map;", "asDictionary", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "propertyName", "value", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPropertyName", "setPropertyName", "(Ljava/lang/String;)V", "Ljava/lang/Object;", "getValue", "setValue", "(Ljava/lang/Object;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "analytics_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsUserProperty {
    private String propertyName;
    private Object value;

    public AnalyticsUserProperty(String propertyName, Object value) {
        m.g(propertyName, "propertyName");
        m.g(value, "value");
        this.propertyName = propertyName;
        this.value = value;
    }

    public static /* synthetic */ AnalyticsUserProperty copy$default(AnalyticsUserProperty analyticsUserProperty, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = analyticsUserProperty.propertyName;
        }
        if ((i2 & 2) != 0) {
            obj = analyticsUserProperty.value;
        }
        return analyticsUserProperty.copy(str, obj);
    }

    public final Map<String, Object> asDictionary$analytics_release() {
        Map<String, Object> e2;
        e2 = l0.e(u.a(this.propertyName, this.value));
        return e2;
    }

    public final String component1() {
        return this.propertyName;
    }

    public final Object component2() {
        return this.value;
    }

    public final AnalyticsUserProperty copy(String propertyName, Object value) {
        m.g(propertyName, "propertyName");
        m.g(value, "value");
        return new AnalyticsUserProperty(propertyName, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnalyticsUserProperty) {
            AnalyticsUserProperty analyticsUserProperty = (AnalyticsUserProperty) obj;
            return m.c(this.propertyName, analyticsUserProperty.propertyName) && m.c(this.value, analyticsUserProperty.value);
        }
        return false;
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.propertyName.hashCode() * 31) + this.value.hashCode();
    }

    public final void setPropertyName(String str) {
        m.g(str, "<set-?>");
        this.propertyName = str;
    }

    public final void setValue(Object obj) {
        m.g(obj, "<set-?>");
        this.value = obj;
    }

    public String toString() {
        return "AnalyticsUserProperty(propertyName=" + this.propertyName + ", value=" + this.value + ')';
    }
}