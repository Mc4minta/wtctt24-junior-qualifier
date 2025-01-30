package com.coinbase.walletlink.dtos;

import com.coinbase.android.apiv3.generated.authed.b;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetEventsDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/coinbase/walletlink/dtos/GetEventsDTO;", "", "", "Lcom/coinbase/walletlink/dtos/EventDTO;", "component1", "()Ljava/util/List;", "", "component2", "()J", "", "component3", "()Ljava/lang/String;", "events", "timestamp", "error", "copy", "(Ljava/util/List;JLjava/lang/String;)Lcom/coinbase/walletlink/dtos/GetEventsDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getEvents", "Ljava/lang/String;", "getError", "J", "getTimestamp", "<init>", "(Ljava/util/List;JLjava/lang/String;)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetEventsDTO {
    private final String error;
    private final List<EventDTO> events;
    private final long timestamp;

    public GetEventsDTO(List<EventDTO> list, long j2, String str) {
        this.events = list;
        this.timestamp = j2;
        this.error = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetEventsDTO copy$default(GetEventsDTO getEventsDTO, List list, long j2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getEventsDTO.events;
        }
        if ((i2 & 2) != 0) {
            j2 = getEventsDTO.timestamp;
        }
        if ((i2 & 4) != 0) {
            str = getEventsDTO.error;
        }
        return getEventsDTO.copy(list, j2, str);
    }

    public final List<EventDTO> component1() {
        return this.events;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.error;
    }

    public final GetEventsDTO copy(List<EventDTO> list, long j2, String str) {
        return new GetEventsDTO(list, j2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetEventsDTO) {
            GetEventsDTO getEventsDTO = (GetEventsDTO) obj;
            return m.c(this.events, getEventsDTO.events) && this.timestamp == getEventsDTO.timestamp && m.c(this.error, getEventsDTO.error);
        }
        return false;
    }

    public final String getError() {
        return this.error;
    }

    public final List<EventDTO> getEvents() {
        return this.events;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        List<EventDTO> list = this.events;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + b.a(this.timestamp)) * 31;
        String str = this.error;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "GetEventsDTO(events=" + this.events + ", timestamp=" + this.timestamp + ", error=" + ((Object) this.error) + ')';
    }
}