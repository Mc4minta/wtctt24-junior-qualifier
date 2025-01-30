package com.coinbase.resources.trades;

import com.google.gson.l;
import com.google.gson.p;
import com.google.gson.q;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class PlaceTradeOrderBodySerializer implements q<PlaceTradeOrderBody> {
    @Override // com.google.gson.q
    public l serialize(PlaceTradeOrderBody placeTradeOrderBody, Type type, p pVar) {
        return pVar.b(placeTradeOrderBody, placeTradeOrderBody.getClass());
    }
}