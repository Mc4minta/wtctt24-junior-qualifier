package io.branch.referral.network;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.branch.referral.network.BranchRemoteInterface;
import io.branch.referral.q;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HttpRequestExecutor;
import org.json.JSONObject;

/* compiled from: BranchRemoteInterfaceUrlConnection.java */
/* loaded from: classes2.dex */
public class a extends BranchRemoteInterface {
    private q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.a = q.B(context);
    }

    private BranchRemoteInterface.a i(String str, int i2) throws BranchRemoteInterface.BranchRemoteException {
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                int R = this.a.R();
                if (R <= 0) {
                    R = HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
                }
                String str2 = str.contains("?") ? "&" : "?";
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str + str2 + "retryNumber=" + i2).openConnection()));
                try {
                    httpsURLConnection2.setConnectTimeout(R);
                    httpsURLConnection2.setReadTimeout(R);
                    int responseCode = httpsURLConnection2.getResponseCode();
                    if (responseCode >= 500 && i2 < this.a.M()) {
                        try {
                            Thread.sleep(this.a.N());
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        BranchRemoteInterface.a i3 = i(str, i2 + 1);
                        httpsURLConnection2.disconnect();
                        return i3;
                    }
                    if (responseCode != 200) {
                        try {
                            if (httpsURLConnection2.getErrorStream() != null) {
                                BranchRemoteInterface.a aVar = new BranchRemoteInterface.a(k(httpsURLConnection2.getErrorStream()), responseCode);
                                httpsURLConnection2.disconnect();
                                return aVar;
                            }
                        } catch (FileNotFoundException unused) {
                            q.a("A resource conflict occurred with this request " + str);
                            BranchRemoteInterface.a aVar2 = new BranchRemoteInterface.a(null, responseCode);
                            httpsURLConnection2.disconnect();
                            return aVar2;
                        }
                    }
                    BranchRemoteInterface.a aVar3 = new BranchRemoteInterface.a(k(httpsURLConnection2.getInputStream()), responseCode);
                    httpsURLConnection2.disconnect();
                    return aVar3;
                } catch (SocketException e3) {
                    e = e3;
                    q.a("Http connect exception: " + e.getMessage());
                    throw new BranchRemoteInterface.BranchRemoteException(-113);
                } catch (SocketTimeoutException unused2) {
                    httpsURLConnection = httpsURLConnection2;
                    if (i2 < this.a.M()) {
                        try {
                            Thread.sleep(this.a.N());
                        } catch (InterruptedException e4) {
                            e4.printStackTrace();
                        }
                        BranchRemoteInterface.a i4 = i(str, i2 + 1);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        return i4;
                    }
                    throw new BranchRemoteInterface.BranchRemoteException(-111);
                } catch (IOException e5) {
                    e = e5;
                    q.a("Branch connect exception: " + e.getMessage());
                    throw new BranchRemoteInterface.BranchRemoteException(-113);
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (SocketException e6) {
                e = e6;
            } catch (SocketTimeoutException unused3) {
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0129: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:73:0x0129 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.branch.referral.network.BranchRemoteInterface.a j(java.lang.String r9, org.json.JSONObject r10, int r11) throws io.branch.referral.network.BranchRemoteInterface.BranchRemoteException {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.a.j(java.lang.String, org.json.JSONObject, int):io.branch.referral.network.BranchRemoteInterface$a");
    }

    private String k(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new BufferedReader(new InputStreamReader(inputStream)).readLine();
            } catch (IOException unused) {
            }
        }
        return null;
    }

    @Override // io.branch.referral.network.BranchRemoteInterface
    public BranchRemoteInterface.a c(String str) throws BranchRemoteInterface.BranchRemoteException {
        return i(str, 0);
    }

    @Override // io.branch.referral.network.BranchRemoteInterface
    public BranchRemoteInterface.a d(String str, JSONObject jSONObject) throws BranchRemoteInterface.BranchRemoteException {
        return j(str, jSONObject, 0);
    }
}