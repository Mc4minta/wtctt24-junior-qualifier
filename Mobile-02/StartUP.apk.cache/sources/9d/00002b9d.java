package com.coinbase.walletlink.dtos;

import com.coinbase.walletlink.models.EventType;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetEventsDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/coinbase/walletlink/dtos/EventDTO;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/walletlink/models/EventType;", "component2", "()Lcom/coinbase/walletlink/models/EventType;", "component3", "id", "event", "data", "copy", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/EventDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/coinbase/walletlink/models/EventType;", "getEvent", "getData", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletlink/models/EventType;Ljava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EventDTO {
    private final String data;
    private final EventType event;
    private final String id;

    public EventDTO(String id, EventType event, String data) {
        m.g(id, "id");
        m.g(event, "event");
        m.g(data, "data");
        this.id = id;
        this.event = event;
        this.data = data;
    }

    public static /* synthetic */ EventDTO copy$default(EventDTO eventDTO, String str, EventType eventType, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = eventDTO.id;
        }
        if ((i2 & 2) != 0) {
            eventType = eventDTO.event;
        }
        if ((i2 & 4) != 0) {
            str2 = eventDTO.data;
        }
        return eventDTO.copy(str, eventType, str2);
    }

    public final String component1() {
        return this.id;
    }

    public final EventType component2() {
        return this.event;
    }

    public final String component3() {
        return this.data;
    }

    public final EventDTO copy(String id, EventType event, String data) {
        m.g(id, "id");
        m.g(event, "event");
        m.g(data, "data");
        return new EventDTO(id, event, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EventDTO) {
            EventDTO eventDTO = (EventDTO) obj;
            return m.c(this.id, eventDTO.id) && this.event == eventDTO.event && m.c(this.data, eventDTO.data);
        }
        return false;
    }

    public final String getData() {
        return this.data;
    }

    public final EventType getEvent() {
        return this.event;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.event.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "EventDTO(id=" + this.id + ", event=" + this.event + ", data=" + this.data + ')';
    }
}