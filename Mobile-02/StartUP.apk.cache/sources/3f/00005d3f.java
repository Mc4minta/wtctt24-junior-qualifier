package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
public class BasicResponseHandler extends AbstractResponseHandler<String> {
    @Override // org.apache.http.impl.client.AbstractResponseHandler
    public String handleEntity(HttpEntity httpEntity) throws IOException {
        return EntityUtils.toString(httpEntity);
    }

    @Override // org.apache.http.impl.client.AbstractResponseHandler, org.apache.http.client.ResponseHandler
    public String handleResponse(HttpResponse httpResponse) throws HttpResponseException, IOException {
        return (String) super.handleResponse(httpResponse);
    }
}