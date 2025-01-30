package com.coinbase.resources.accounts;

import com.google.gson.f;
import com.google.gson.s;
import com.google.gson.stream.b;
import com.google.gson.stream.c;
import com.google.gson.t;
import com.google.gson.v.a;
import java.io.IOException;

/* loaded from: classes.dex */
public class Currency {
    private String addressRegex;
    private String assetId;
    private String code;
    private String color;
    private String destinationTagName;
    private Integer exponent;
    private String name;
    private String type;

    /* loaded from: classes.dex */
    public static class CurrencyDeserializationFactory implements t {
        @Override // com.google.gson.t
        public <T> s<T> create(f fVar, a<T> aVar) {
            s<T> n = fVar.n(this, aVar);
            if (aVar.getRawType().equals(Currency.class)) {
                final s<T> n2 = fVar.n(this, a.get(Currency.class));
                return (s<T>) new s<Currency>() { // from class: com.coinbase.resources.accounts.Currency.CurrencyDeserializationFactory.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.google.gson.s
                    public Currency read(com.google.gson.stream.a aVar2) throws IOException {
                        if (aVar2.k0() == b.STRING) {
                            Currency currency = new Currency();
                            currency.code = aVar2.e0();
                            return currency;
                        }
                        return (Currency) n2.read(aVar2);
                    }

                    @Override // com.google.gson.s
                    public void write(c cVar, Currency currency) throws IOException {
                        n2.write(cVar, currency);
                    }
                };
            }
            return n;
        }
    }

    public String getAddressRegex() {
        return this.addressRegex;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public String getCode() {
        return this.code;
    }

    public String getColor() {
        return this.color;
    }

    public String getDestinationTagName() {
        return this.destinationTagName;
    }

    public Integer getExponent() {
        return this.exponent;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}