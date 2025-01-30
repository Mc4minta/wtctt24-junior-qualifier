package com.coinbase.wallet.ethereum.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.ethereum.models.ERC20;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20TokenResponseDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20TokenResponseDTO;", "", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ethereumChain", "Lcom/coinbase/wallet/ethereum/models/ERC20;", "asERC20", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/ciphercore/ethereum/EthereumChain;)Lcom/coinbase/wallet/ethereum/models/ERC20;", "", "index", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "address", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "addressType", "derivationPath", "Lcom/coinbase/wallet/blockchains/models/Address;", "asAddress", "(ILcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/AddressType;Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/Address;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "Ljava/lang/String;", "getContractAddress", "()Ljava/lang/String;", ApiConstants.NAME, "getName", "symbol", "getSymbol", "image", "getImage", "decimals", "I", "getDecimals", "()I", "Ljava/math/BigInteger;", "balance", "Ljava/math/BigInteger;", "getBalance", "()Ljava/math/BigInteger;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;Ljava/lang/String;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20TokenResponseDTO {
    private final BigInteger balance;
    private final String contractAddress;
    private final int decimals;
    private final String image;
    private final String name;
    private final String symbol;

    public GetERC20TokenResponseDTO(String name, int i2, String contractAddress, String symbol, BigInteger bigInteger, String str) {
        m.g(name, "name");
        m.g(contractAddress, "contractAddress");
        m.g(symbol, "symbol");
        this.decimals = i2;
        this.contractAddress = contractAddress;
        this.balance = bigInteger;
        this.image = str;
        Locale US = Locale.US;
        m.f(US, "US");
        Objects.requireNonNull(contractAddress, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = contractAddress.toLowerCase(US);
        m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != -1727978733) {
            if (hashCode != 91005930) {
                if (hashCode == 1923172572 && lowerCase.equals("0xf5dce57282a584d2746faf1593d3121fcac444dc")) {
                    name = "Compound SAI";
                }
            } else if (lowerCase.equals("0x89d24a6b4ccb1b6faa2625fe562bdd9a23260359")) {
                name = "SAI Stablecoin v1.0";
            }
        } else if (lowerCase.equals("0xa0b86991c6218b36c1d19d4a2e9eb0ce3606eb48")) {
            name = "USD Coin";
        }
        this.name = name;
        m.f(US, "US");
        Objects.requireNonNull(contractAddress, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = contractAddress.toLowerCase(US);
        m.f(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        if (m.c(lowerCase2, "0x89d24a6b4ccb1b6faa2625fe562bdd9a23260359")) {
            symbol = "SAI";
        } else if (m.c(lowerCase2, "0xf5dce57282a584d2746faf1593d3121fcac444dc")) {
            symbol = "CSAI";
        }
        this.symbol = symbol;
    }

    public final Address asAddress(int i2, Blockchain blockchain, Network network, String address, AddressType addressType, String derivationPath) {
        m.g(blockchain, "blockchain");
        m.g(network, "network");
        m.g(address, "address");
        m.g(addressType, "addressType");
        m.g(derivationPath, "derivationPath");
        BigInteger bigInteger = this.balance;
        if (bigInteger == null) {
            return null;
        }
        return new Address(i2, address, bigInteger, new CurrencyCode(this.symbol), false, network, addressType, derivationPath, true, blockchain, this.contractAddress);
    }

    public final ERC20 asERC20(Blockchain blockchain, EthereumChain ethereumChain) {
        m.g(blockchain, "blockchain");
        m.g(ethereumChain, "ethereumChain");
        String str = this.name;
        int i2 = this.decimals;
        String str2 = this.contractAddress;
        int chainId = ethereumChain.getChainId();
        CurrencyCode currencyCode = new CurrencyCode(this.symbol);
        String str3 = this.image;
        return new ERC20(str, i2, str2, chainId, currencyCode, blockchain, str3 == null ? null : String_CoreKt.getAsURL(str3));
    }

    public final BigInteger getBalance() {
        return this.balance;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSymbol() {
        return this.symbol;
    }
}