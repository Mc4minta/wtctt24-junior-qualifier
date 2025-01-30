package k.b.a;

import android.util.SparseArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: BarcodeFormatUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static final SparseArray<String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f17194b;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1, "CODE_128");
        sparseArray.put(2, "CODE_39");
        sparseArray.put(4, "CODE_93");
        sparseArray.put(8, "CODABAR");
        sparseArray.put(16, "DATA_MATRIX");
        sparseArray.put(32, "EAN_13");
        sparseArray.put(64, "EAN_8");
        sparseArray.put(128, "ITF");
        sparseArray.put(256, "QR_CODE");
        sparseArray.put(512, "UPC_A");
        sparseArray.put(1024, "UPC_E");
        sparseArray.put(PKIFailureInfo.wrongIntegrity, "PDF417");
        sparseArray.put(4096, "AZTEC");
        sparseArray.put(0, "ALL");
        sparseArray.put(11, "CALENDAR_EVENT");
        sparseArray.put(1, "CONTACT_INFO");
        sparseArray.put(12, "DRIVER_LICENSE");
        sparseArray.put(2, "EMAIL");
        sparseArray.put(10, "GEO");
        sparseArray.put(3, "ISBN");
        sparseArray.put(4, "PHONE");
        sparseArray.put(5, "PRODUCT");
        sparseArray.put(6, "SMS");
        sparseArray.put(7, "TEXT");
        sparseArray.put(512, "UPC_A");
        sparseArray.put(8, "URL");
        sparseArray.put(9, "WIFI");
        sparseArray.put(-1, "None");
        a = sparseArray;
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            hashMap.put(sparseArray.valueAt(i2), Integer.valueOf(sparseArray.keyAt(i2)));
        }
        f17194b = Collections.unmodifiableMap(hashMap);
    }

    public static String a(int i2) {
        return a.get(i2, "UNKNOWN_FORMAT");
    }
}