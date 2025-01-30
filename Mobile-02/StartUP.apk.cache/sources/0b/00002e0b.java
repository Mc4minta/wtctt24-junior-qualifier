package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import java.util.Objects;

@e.f.l.a.a
/* loaded from: classes2.dex */
public class BatchMountItem implements g {
    private final g[] a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4806b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4807c;

    public BatchMountItem(g[] gVarArr, int i2, int i3) {
        Objects.requireNonNull(gVarArr);
        if (i2 >= 0 && i2 <= gVarArr.length) {
            this.a = gVarArr;
            this.f4806b = i2;
            this.f4807c = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid size received by parameter size: " + i2 + " items.size = " + gVarArr.length);
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        com.facebook.systrace.a.c(0L, "FabricUIManager::mountViews - " + this.f4806b + " items");
        int i2 = this.f4807c;
        if (i2 > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, null, i2);
        }
        for (int i3 = 0; i3 < this.f4806b; i3++) {
            this.a[i3].a(bVar);
        }
        int i4 = this.f4807c;
        if (i4 > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, null, i4);
        }
        com.facebook.systrace.a.g(0L);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < this.f4806b) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("BatchMountItem (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append("/");
            sb.append(this.f4806b);
            sb.append("): ");
            sb.append(this.a[i2]);
            i2 = i3;
        }
        return sb.toString();
    }
}