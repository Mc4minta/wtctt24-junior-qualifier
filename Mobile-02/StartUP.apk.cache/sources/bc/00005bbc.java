package org.apache.commons.lang3.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultExceptionContext.java */
/* loaded from: classes3.dex */
public class a implements b, Serializable {
    private final List<org.apache.commons.lang3.c.a<String, Object>> a = new ArrayList();

    @Override // org.apache.commons.lang3.exception.b
    public String a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (this.a.size() > 0) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Exception Context:\n");
            int i2 = 0;
            for (org.apache.commons.lang3.c.a<String, Object> aVar : this.a) {
                sb.append("\t[");
                i2++;
                sb.append(i2);
                sb.append(':');
                sb.append(aVar.getKey());
                sb.append("=");
                Object value = aVar.getValue();
                if (value == null) {
                    sb.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e2) {
                        str2 = "Exception thrown on toString(): " + c.a(e2);
                    }
                    sb.append(str2);
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }
}