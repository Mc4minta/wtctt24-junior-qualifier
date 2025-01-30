package com.facebook.react.devsupport;

import android.content.Context;
import java.util.Map;

/* compiled from: DevSupportManagerFactory.java */
/* loaded from: classes2.dex */
public class a {
    public static com.facebook.react.devsupport.g.c a(Context context, d dVar, String str, boolean z, e eVar, com.facebook.react.devsupport.g.a aVar, int i2, Map<String, ?> map) {
        if (!z) {
            return new b();
        }
        try {
            return (com.facebook.react.devsupport.g.c) Class.forName("com.facebook.react.devsupport.DevSupportManagerImpl").getConstructor(Context.class, d.class, String.class, Boolean.TYPE, e.class, com.facebook.react.devsupport.g.a.class, Integer.TYPE, Map.class).newInstance(context, dVar, str, Boolean.TRUE, eVar, aVar, Integer.valueOf(i2), map);
        } catch (Exception e2) {
            throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", e2);
        }
    }
}