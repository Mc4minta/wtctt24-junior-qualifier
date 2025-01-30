package com.coinbase.wallet.application.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.resources.paymentmethods.models.Limits;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.consumer.extensions.EventFeature_ConsumerKt;
import com.coinbase.wallet.consumer.extensions.EventProperty_ConsumerKt;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.wallets.extensions.legacy.Network_ApplicationKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.wallets.extensions.EventProperty_WalletsKt;
import com.coinbase.walletengine.services.resolver.ResolveType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.o;
import kotlin.u;

/* compiled from: AnalyticsEvent+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b&\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0003\u001a\u0011\u0010\u000b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0019\u0010\u000e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0003\u001a\u0019\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000f\u001a\u0019\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000f\u001a\u0019\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000f\u001a\u0011\u0010\u0015\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0003\u001a\u0019\u0010\u0016\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u000f\u001a\u0011\u0010\u0017\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u0019\u0010\u0018\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u000f\u001a\u0011\u0010\u0019\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0003\u001a\u0011\u0010\u001a\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0003\u001a\u0011\u0010\u001b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u0003\u001a\u0011\u0010\u001c\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u0003\u001a\u0011\u0010\u001d\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u0003\u001a\u0011\u0010\u001e\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u0003\u001a\u0011\u0010\u001f\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u001f\u0010\u0003\u001a\u0011\u0010 \u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b \u0010\u0003\u001a\u0011\u0010!\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b!\u0010\u0003\u001a\u0011\u0010\"\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\"\u0010\u0003\u001a\u0011\u0010#\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b#\u0010\u0003\u001a\u0011\u0010$\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b$\u0010\u0003\u001a\u0011\u0010%\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b%\u0010\u0003\u001a\u0011\u0010&\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b&\u0010\u0003\u001a\u0011\u0010'\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b'\u0010\u0003\u001a\u0011\u0010(\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b(\u0010\u0003\u001a\u0011\u0010)\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b)\u0010\u0003\u001a\u0011\u0010*\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b*\u0010\u0003\u001a\u001b\u0010,\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\f¢\u0006\u0004\b,\u0010\u000f\u001a\u0011\u0010-\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b-\u0010\u0003\u001a\u0011\u0010.\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b.\u0010\u0003\u001a\u0011\u0010/\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b/\u0010\u0003\u001a\u0011\u00100\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b0\u0010\u0003\u001a\u001b\u00101\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\f¢\u0006\u0004\b1\u0010\u000f\u001a\u0011\u00102\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b2\u0010\u0003\u001a\u0011\u00103\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b3\u0010\u0003\u001a\u0011\u00104\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b4\u0010\u0003\u001a\u0011\u00105\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b5\u0010\u0003\u001a\u0011\u00106\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b6\u0010\u0003\u001a\u0011\u00107\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b7\u0010\u0003\u001a\u0011\u00108\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b8\u0010\u0003\u001a\u0011\u00109\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b9\u0010\u0003\u001a\u0011\u0010:\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b:\u0010\u0003\u001a\u0011\u0010;\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b;\u0010\u0003\u001a\u0011\u0010<\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b<\u0010\u0003\u001a\u0011\u0010=\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b=\u0010\u0003\u001a\u0011\u0010>\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b>\u0010\u0003\u001a\u0011\u0010?\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b?\u0010\u0003\u001a\u0011\u0010@\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b@\u0010\u0003\u001a\u0011\u0010A\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bA\u0010\u0003\u001a\u0011\u0010B\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bB\u0010\u0003\u001a\u0011\u0010C\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bC\u0010\u0003\u001a\u0011\u0010D\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bD\u0010\u0003\u001a\u0019\u0010G\u001a\u00020\u0001*\u00020\u00002\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010H\u001a\u0011\u0010I\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bI\u0010\u0003\u001a+\u0010O\u001a\u00020\u0001*\u00020\u00002\u0006\u0010J\u001a\u00020\f2\u0006\u0010L\u001a\u00020K2\b\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\bO\u0010P\u001a\u0011\u0010Q\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bQ\u0010\u0003\u001a\u0019\u0010T\u001a\u00020\u0001*\u00020\u00002\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010U\u001a\u0011\u0010V\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bV\u0010\u0003\u001a\u0019\u0010X\u001a\u00020\u0001*\u00020\u00002\u0006\u0010W\u001a\u00020\f¢\u0006\u0004\bX\u0010\u000f\u001a\u0011\u0010Y\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bY\u0010\u0003\u001a\u0011\u0010Z\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bZ\u0010\u0003\u001a\u0011\u0010[\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b[\u0010\u0003\u001a%\u0010^\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\\\u001a\u00020\f2\b\b\u0002\u0010]\u001a\u00020\f¢\u0006\u0004\b^\u0010_\u001a%\u0010`\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\\\u001a\u00020\f2\b\b\u0002\u0010]\u001a\u00020\f¢\u0006\u0004\b`\u0010_\u001a%\u0010a\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\\\u001a\u00020\f2\b\b\u0002\u0010]\u001a\u00020\f¢\u0006\u0004\ba\u0010_\u001a!\u0010f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d¢\u0006\u0004\bf\u0010g\u001a\u0011\u0010h\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bh\u0010\u0003\u001a)\u0010l\u001a\u00020\u0001*\u00020\u00002\u0006\u0010i\u001a\u00020\f2\u0006\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\f¢\u0006\u0004\bl\u0010m\u001a)\u0010n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010i\u001a\u00020\f2\u0006\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\f¢\u0006\u0004\bn\u0010m\u001a\u0011\u0010o\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bo\u0010\u0003\u001a\u0011\u0010p\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bp\u0010\u0003\u001a\u0011\u0010q\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bq\u0010\u0003\u001a\u0011\u0010r\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\br\u0010\u0003\u001a\u0011\u0010s\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bs\u0010\u0003\u001a\u0011\u0010t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bt\u0010\u0003\u001a\u0011\u0010u\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bu\u0010\u0003\u001a\u0011\u0010v\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bv\u0010\u0003\u001a\u0011\u0010w\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bw\u0010\u0003\u001a\u0011\u0010x\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bx\u0010\u0003\u001a\u0011\u0010y\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\by\u0010\u0003\u001a\u0011\u0010z\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bz\u0010\u0003\u001a\u0019\u0010|\u001a\u00020\u0001*\u00020\u00002\u0006\u0010{\u001a\u00020E¢\u0006\u0004\b|\u0010H\u001a\u0019\u0010}\u001a\u00020\u0001*\u00020\u00002\u0006\u0010{\u001a\u00020E¢\u0006\u0004\b}\u0010H\u001a\u0011\u0010~\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b~\u0010\u0003\u001a\u0011\u0010\u007f\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u007f\u0010\u0003\u001a\u0013\u0010\u0080\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u0080\u0001\u0010\u0003\u001a%\u0010\u0083\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\f2\u0007\u0010\u0082\u0001\u001a\u00020\f¢\u0006\u0005\b\u0083\u0001\u0010_\u001a\u0013\u0010\u0084\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u0084\u0001\u0010\u0003\u001a\u0013\u0010\u0085\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u0085\u0001\u0010\u0003\u001a\u0013\u0010\u0086\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u0086\u0001\u0010\u0003\u001a&\u0010\u0089\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010L\u001a\u00020K2\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a:\u0010\u008f\u0001\u001a\u00020\u0001*\u00020\u00002\b\u0010\u008c\u0001\u001a\u00030\u008b\u00012\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u008d\u0001\u001a\u00020R2\u0007\u0010\u008e\u0001\u001a\u00020R¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a&\u0010\u0093\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0091\u0001\u001a\u00020\f2\u0007\u0010\u0092\u0001\u001a\u00020E¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a'\u0010\u0097\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0091\u0001\u001a\u00020\f2\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0013\u0010\u0099\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u0099\u0001\u0010\u0003\u001a\u0013\u0010\u009a\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u009a\u0001\u0010\u0003\u001a\u0013\u0010\u009b\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u009b\u0001\u0010\u0003\u001a\u0013\u0010\u009c\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u009c\u0001\u0010\u0003\u001a\u0013\u0010\u009d\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u009d\u0001\u0010\u0003\u001a\u0013\u0010\u009e\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u009e\u0001\u0010\u0003\u001a\u0013\u0010\u009f\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b\u009f\u0001\u0010\u0003\u001a\u0013\u0010 \u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b \u0001\u0010\u0003\u001a\u0013\u0010¡\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¡\u0001\u0010\u0003\u001a\u0013\u0010¢\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¢\u0001\u0010\u0003\u001a\u0013\u0010£\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b£\u0001\u0010\u0003\u001a\u0013\u0010¤\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¤\u0001\u0010\u0003\u001a\u0013\u0010¥\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¥\u0001\u0010\u0003\u001a\u0013\u0010¦\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¦\u0001\u0010\u0003\u001a\u0013\u0010§\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b§\u0001\u0010\u0003\u001a\u0013\u0010¨\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¨\u0001\u0010\u0003\u001a\u0013\u0010©\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b©\u0001\u0010\u0003\u001a\u001b\u0010ª\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010{\u001a\u00020E¢\u0006\u0005\bª\u0001\u0010H\u001a\u0013\u0010«\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b«\u0001\u0010\u0003\u001a\u0013\u0010¬\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b¬\u0001\u0010\u0003\u001a\u001b\u0010\u00ad\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010{\u001a\u00020E¢\u0006\u0005\b\u00ad\u0001\u0010H\u001a\u001c\u0010¯\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020E¢\u0006\u0005\b¯\u0001\u0010H\u001a\u0013\u0010°\u0001\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0005\b°\u0001\u0010\u0003\u001a&\u0010²\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010±\u0001\u001a\u00020E2\u0007\u0010®\u0001\u001a\u00020E¢\u0006\u0006\b²\u0001\u0010³\u0001\u001a\u001c\u0010´\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020E¢\u0006\u0005\b´\u0001\u0010H\u001a8\u0010µ\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010±\u0001\u001a\u00020E2\u0007\u0010®\u0001\u001a\u00020E2\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0006\u0010L\u001a\u00020K¢\u0006\u0006\bµ\u0001\u0010¶\u0001\u001a/\u0010·\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010®\u0001\u001a\u00020E2\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0006\u0010L\u001a\u00020K¢\u0006\u0006\b·\u0001\u0010¸\u0001\u001a\u001b\u0010¹\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010W\u001a\u00020\f¢\u0006\u0005\b¹\u0001\u0010\u000f\u001a\u001c\u0010»\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010º\u0001\u001a\u00020\f¢\u0006\u0005\b»\u0001\u0010\u000f\u001a'\u0010½\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\f2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\f¢\u0006\u0005\b½\u0001\u0010_\u001a2\u0010¿\u0001\u001a\u00020\u0001*\u00020\u00002\t\u0010¾\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0096\u0001\u001a\u00020\f2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\f¢\u0006\u0005\b¿\u0001\u0010m\u001a)\u0010À\u0001\u001a\u00020\u0001*\u00020\u00002\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\f2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\f¢\u0006\u0005\bÀ\u0001\u0010_\u001a)\u0010Á\u0001\u001a\u00020\u0001*\u00020\u00002\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\f2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\f¢\u0006\u0005\bÁ\u0001\u0010_\u001a%\u0010Â\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\f2\u0007\u0010¼\u0001\u001a\u00020\f¢\u0006\u0005\bÂ\u0001\u0010_\u001a8\u0010Å\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010Ã\u0001\u001a\u00020\f2\u0007\u0010Ä\u0001\u001a\u00020\f2\u0007\u0010\u0096\u0001\u001a\u00020\f2\u0007\u0010¼\u0001\u001a\u00020\f¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001\u001a\u001c\u0010È\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010Ç\u0001\u001a\u00020\f¢\u0006\u0005\bÈ\u0001\u0010\u000f\u001a\u001b\u0010É\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010W\u001a\u00020\f¢\u0006\u0005\bÉ\u0001\u0010\u000f\u001a\u001b\u0010Ê\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010W\u001a\u00020\f¢\u0006\u0005\bÊ\u0001\u0010\u000f\u001a\u001c\u0010Ì\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010Ë\u0001\u001a\u00020\f¢\u0006\u0005\bÌ\u0001\u0010\u000f\u001a\u001b\u0010Í\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010W\u001a\u00020\f¢\u0006\u0005\bÍ\u0001\u0010\u000f\u001a0\u0010Î\u0001\u001a\u00020\u0001*\u00020\u00002\t\u0010¾\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0096\u0001\u001a\u00020\f2\u0007\u0010¼\u0001\u001a\u00020\f¢\u0006\u0005\bÎ\u0001\u0010m\u001a`\u0010Õ\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\f2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ð\u0001\u001a\u00020\f2\u0007\u0010Ñ\u0001\u001a\u00020\f2\u0007\u0010¼\u0001\u001a\u00020\f2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ó\u0001\u001a\u00020\f2\u0007\u0010Ô\u0001\u001a\u00020R¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001\u001ai\u0010Ø\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\f2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010¼\u0001\u001a\u00020\f2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010×\u0001\u001a\u00020\f2\u0007\u0010Ð\u0001\u001a\u00020\f2\u0007\u0010Ñ\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020\f2\u0007\u0010Ô\u0001\u001a\u00020R¢\u0006\u0006\bØ\u0001\u0010Ù\u0001\u001aE\u0010Ú\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\f2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010¼\u0001\u001a\u00020\f2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ô\u0001\u001a\u00020R¢\u0006\u0006\bÚ\u0001\u0010Û\u0001\u001a0\u0010Þ\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010Ü\u0001\u001a\u00020\f2\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u0007\u0010J\u001a\u00030Ý\u0001¢\u0006\u0006\bÞ\u0001\u0010ß\u0001\u001a\u001c\u0010á\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010à\u0001\u001a\u00020\f¢\u0006\u0005\bá\u0001\u0010\u000f\u001a8\u0010æ\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010â\u0001\u001a\u00020\f2\u0007\u0010ã\u0001\u001a\u00020\f2\u0007\u0010ä\u0001\u001a\u00020E2\u0007\u0010å\u0001\u001a\u00020\f¢\u0006\u0006\bæ\u0001\u0010ç\u0001\u001a\u001c\u0010è\u0001\u001a\u00020\u0001*\u00020\u00002\u0007\u0010¾\u0001\u001a\u00020\f¢\u0006\u0005\bè\u0001\u0010\u000f\u001a\u001a\u0010é\u0001\u001a\u00020\f2\u0006\u0010{\u001a\u00020EH\u0002¢\u0006\u0006\bé\u0001\u0010ê\u0001\"\u0019\u0010ì\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bë\u0001\u0010\u0003\"\u0019\u0010î\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bí\u0001\u0010\u0003\"%\u0010ò\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\u000f\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0005\bñ\u0001\u0010\u0003\"\u0019\u0010ô\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bó\u0001\u0010\u0003\"\u0019\u0010ö\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bõ\u0001\u0010\u0003\"\u0019\u0010ø\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\b÷\u0001\u0010\u0003\"\u0019\u0010ú\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bù\u0001\u0010\u0003\"\u0019\u0010ü\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bû\u0001\u0010\u0003\"\u0019\u0010þ\u0001\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bý\u0001\u0010\u0003\"\u0019\u0010\u0080\u0002\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\bÿ\u0001\u0010\u0003\"\u0019\u0010\u0082\u0002\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0007\u001a\u0005\b\u0081\u0002\u0010\u0003¨\u0006\u0083\u0002"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "appStart", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "landingPageLanded", "userActivated", "walletTabLanded", "globalSendSelected", "universalQrScannerClicked", "globalReceiveSelected", "coinsTabLanded", "collectibleTabLanded", "", "collectibleTypeName", "collectibleTypeLanded", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "collectibleDetailLanded", "coinName", "coinDetailLanded", "coinDetailReceiveSelected", "coinDetailSendSelected", "sendCoinPickerLanded", "sendCoinPickerCoinSelected", "receiveCoinPickerLanded", "receiveCoinPickerCoinSelected", "displayAddressCopy", "displayAddressShare", "displayAddressInfoPromptSelected", "confirmTransactionTxSubmitted", "newWalletStart", "newWalletCreated", "legalLanded", "legalTosSelected", "legalPrivacySelected", "restoreWalletNewUserStart", "restoreWalletSuccess", "usernameLanded", "authMethodLanded", "authMethodBiometricSuccess", "authMethodPinSuccess", "onboardingSuccess", "restoreWalletLanded", "recoveryPhraseLanded", "service", "restoreWithCloudStart", "restoreWithCloudSuccess", "restoreWithManualStart", "restoreWithManualSuccess", "backupCloudStart", "backupCloudSuccess", "backupDeleted", "backupManualStart", "backupManualSuccess", "backupPromptDisplayed", "backupPromptCTASelected", "backupPromptDismissed", "providerSecurityPromptDismissed", "verifyAppsPromptEnabled", "enablingVerifyAppsFailed", "verifyAppsPromptDismissed", "updateSecurityProviderNotPossible", "recoveryPhraseCopiedToClipboard", "recoveryPhraseClearedFromClipboard", "settingsLanded", "legalSelected", "signOutSelected", "deviceLockLanded", "deviceLockAuthMethodPinSet", "deviceLockAuthMethodBiometricSet", "", "isEnabled", "deviceLockBiometryProtectionEnabled", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Z)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "networkPickerLanded", "network", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ethereumChain", "networkPickerNetworkChanged", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/ciphercore/ethereum/EthereumChain;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "walletPickerLanded", "", "number", "walletPickerWalletChanged", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;I)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "currencySettingsLanded", "code", "currencySettingsCurrencySet", "dappsTabLanded", "whatAreDappsLanded", "dappDirectoryLanded", ApiConstants.NAME, "categories", "dappDetailLanded", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "dappDetailDappOpened", "dappsTabDappBookmarked", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "event", "Lcom/coinbase/wallet/analytics/models/EventFeature;", "feature", "signerEvent", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;Lcom/coinbase/wallet/analytics/models/EventFeature;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "webExtensionApproved", WalletLinkCompleteArgs.DAPP_NAME, "dappUrl", "dappIcon", "dappConnectedViaWalletLink", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "dappConnectedViaExtension", "txSubmittedViaExtension", "sendCoinAmountLanded", "sendCoinAmountMaxSelected", "sendCoinAmountSwapSelected", "sendCoinAmountCoinPickerSelected", "sendCoinAmountNextSelected", "sendDestinationLanded", "sendDestinationManualSearchSelected", "sendDestinationManualMetadataSelected", "sendDestinationPasteSelected", "sendDestinationPasteShow", "sendDestinationAddressSelected", "isMax", "sendConfirmLanded", "sendConfirmTxSubmitted", "sendConfirmDetailsShow", "sendConfirmDetailsHide", "sendConfirmSendSelected", "coin", ApiConstants.DESCRIPTION, "sendConfirmErrorReceived", "sendSuccessLanded", "txGenerationError", "lendTxGenerationError", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "balanceUpdate", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "recipientType", "searchQueryLength", "sendCount", "recipientSelected", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;II)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "topLevelDomain", "resultsMatched", "domainNameCollision", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Z)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "Lcom/coinbase/walletengine/services/resolver/ResolveType;", Payload.SOURCE, "domainResult", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Lcom/coinbase/walletengine/services/resolver/ResolveType;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "lendEarnInterestNewUserStart", "lendEarnInterestExistingUserStart", "lendEarnInterestTestnet", "lendUserAgreementLanded", "lendCoinPickerLanded", "lendCoinPickerTransferSheetStart", "lendProviderPickerLanded", "lendAmountPickerLanded", "lendDashboardLanded", "lendDashboardPending", "lendDashboardConfirmed", "lendDashboardEarnMoreStart", "lendDashboardEarnMoreLendStart", "lendDashboardEarnMoreWithdrawStart", "lendAUCExplainerStart", "lendCollateralExplainerStart", "lendUtilizationExplainerStart", "lendConfirmationLanded", "lendConfirmationLendStart", "lendConfirmationWithdrawStart", "lendConfirmationTxSubmitted", "onrampEnabled", "walletsEmptyStateViewed", "transferCoinsCTASelected", "swapEnabled", "walletsFundActionViewed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZZ)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "walletsFundActionConsumerTapped", "walletDetailFundActionViewed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZZLcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "walletDetailFundActionConsumerTapped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "swapEntryPointNotSupported", Limits.TYPE_CARD, "swapAmountPickerCardSelected", "target", "swapAmountPickerConvertAll", "error", "swapAmountPickerGenericError", "swapAmountPickerInsufficientBalance", "swapAmountPickerLiquidityError", "swapAmountPickerToDisabled", "amountBase", "type", "swapAmountPickerProceed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "direction", "swapAssetPickerLanded", "swapNonConvertibleAssetSelected", "swapNotSupportedAssetSelected", "aggregatorID", "swapNotSupportedPromptAggregatorSelected", "swapSupportedAssetSelected", "swapConfirmErrorReceived", "sourceContractAddress", "sourceAmount", "sourceFiatAmount", "targetContractAddress", "targetAmount", RouteActionKey.RouteActionKeys.CHAIN_ID, "swapConfirmConvertSelected", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", ApiConstants.FEE, "swapConfirmMinerFee", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "swapPriceImpact", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "flowName", "Lcom/coinbase/wallet/blockchains/models/Network;", "adjustableMinerFeeButtonTapped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "presetName", "adjustableMinerFeePresetSelected", "gasPriceChangeDirection", "gasLimitChangeDirection", "isNonceChanged", "nonceChangeDirection", "adjustableMinerFeeCustomValueSelected", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "adjustableMinerFeeErrorReturned", "amountType", "(Z)Ljava/lang/String;", "getSwapEntryPointLend", "swapEntryPointLend", "getSwapAmountPickerLanded", "swapAmountPickerLanded", "blankWalletList$delegate", "Lkotlin/h;", "getBlankWalletList", "blankWalletList", "getSwapEntryPointDetails", "swapEntryPointDetails", "getSwapEntryPointHome", "swapEntryPointHome", "getSwapDisclaimerLanded", "swapDisclaimerLanded", "getSwapConfirmEstimatedAmountInfo", "swapConfirmEstimatedAmountInfo", "getSwapConfirmMinerFeeInfo", "swapConfirmMinerFeeInfo", "getSwapSuccessLanded", "swapSuccessLanded", "getSwapAmountPickerClose", "swapAmountPickerClose", "getSwapConfirmCoinbaseFeeInfo", "swapConfirmCoinbaseFeeInfo", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsEvent_ApplicationKt {
    private static final h blankWalletList$delegate;

    /* compiled from: AnalyticsEvent+Application.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipientType.values().length];
            iArr[RecipientType.Address.ordinal()] = 1;
            iArr[RecipientType.Coinbase.ordinal()] = 2;
            iArr[RecipientType.ENS.ordinal()] = 3;
            iArr[RecipientType.User.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        h b2;
        b2 = k.b(AnalyticsEvent_ApplicationKt$blankWalletList$2.INSTANCE);
        blankWalletList$delegate = b2;
    }

    public static final AnalyticsEvent adjustableMinerFeeButtonTapped(AnalyticsEvent.Companion companion, String flowName, CurrencyCode currencyCode, Network network) {
        Map l2;
        m.g(companion, "<this>");
        m.g(flowName, "flowName");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getFlowName(companion2), flowName), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.toString()), u.a(EventProperty_ApplicationKt.getNetworkName(companion2), network.getUuid()), u.a(EventProperty_ApplicationKt.getNetworkIsTestNet(companion2), String.valueOf(network.isTestnet())), u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(Network_ApplicationKt.asChainId(network))));
        return new AnalyticsEvent(eventType, "adjustable_miner_fee.button_tapped", EventFeature_ApplicationKt.getAdjustableMinerFee(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent adjustableMinerFeeCustomValueSelected(AnalyticsEvent.Companion companion, String gasPriceChangeDirection, String gasLimitChangeDirection, boolean z, String nonceChangeDirection) {
        Map l2;
        m.g(companion, "<this>");
        m.g(gasPriceChangeDirection, "gasPriceChangeDirection");
        m.g(gasLimitChangeDirection, "gasLimitChangeDirection");
        m.g(nonceChangeDirection, "nonceChangeDirection");
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getGasPriceChangeDirection(companion2), gasPriceChangeDirection), u.a(EventProperty_ApplicationKt.getGasLimitChangeDirection(companion2), gasLimitChangeDirection), u.a(EventProperty_ApplicationKt.getIsNonceChanged(companion2), String.valueOf(z)), u.a(EventProperty_ApplicationKt.getNonceChangeDirection(companion2), nonceChangeDirection));
        return new AnalyticsEvent(eventType, "adjustable_miner_fee.custom_selected", EventFeature_ApplicationKt.getAdjustableMinerFee(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent adjustableMinerFeeErrorReturned(AnalyticsEvent.Companion companion, String error) {
        Map e2;
        m.g(companion, "<this>");
        m.g(error, "error");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getErrorMessage(EventProperty.Companion), error));
        return new AnalyticsEvent(eventType, "adjustable_miner_fee.error_returned", EventFeature_ApplicationKt.getAdjustableMinerFee(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent adjustableMinerFeePresetSelected(AnalyticsEvent.Companion companion, String presetName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(presetName, "presetName");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getPresetName(EventProperty.Companion), presetName));
        return new AnalyticsEvent(eventType, "adjustable_miner_fee.preset_selected", EventFeature_ApplicationKt.getAdjustableMinerFee(EventFeature.Companion), false, e2, 8, null);
    }

    private static final String amountType(boolean z) {
        return z ? "max" : "amount";
    }

    public static final AnalyticsEvent appStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "app_start", null, false, null, 28, null);
    }

    public static final AnalyticsEvent authMethodBiometricSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.auth.biometric_success", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent authMethodLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.auth.landed", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent authMethodPinSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.auth.pin_success", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupCloudStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.cloud.start", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupCloudSuccess(AnalyticsEvent.Companion companion, String service) {
        Map e2;
        m.g(companion, "<this>");
        m.g(service, "service");
        EventFeature keyBackup = EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getBackupService(EventProperty.Companion), service));
        return new AnalyticsEvent(eventType, "key_backup.cloud.success", keyBackup, false, e2, 8, null);
    }

    public static /* synthetic */ AnalyticsEvent backupCloudSuccess$default(AnalyticsEvent.Companion companion, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "gdrive";
        }
        return backupCloudSuccess(companion, str);
    }

    public static final AnalyticsEvent backupDeleted(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.cloud.delete_backup", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupManualStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.manual.start", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupManualSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.manual.success", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupPromptCTASelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.prompt.backup_selected", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupPromptDismissed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.prompt.dismissed", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent backupPromptDisplayed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.prompt.displayed", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent balanceUpdate(AnalyticsEvent.Companion companion, Blockchain blockchain, CurrencyCode currencyCode) {
        Map l2;
        m.g(companion, "<this>");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.getRawValue()), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()));
        return new AnalyticsEvent(eventType, "balance_update", null, true, l2, 4, null);
    }

    public static final AnalyticsEvent coinDetailLanded(AnalyticsEvent.Companion companion, String coinName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(coinName, "coinName");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getCoinName(EventProperty.Companion), coinName));
        return new AnalyticsEvent(eventType, "coin_detail.landed", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent coinDetailReceiveSelected(AnalyticsEvent.Companion companion, String coinName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(coinName, "coinName");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getCoinName(EventProperty.Companion), coinName));
        return new AnalyticsEvent(eventType, "coin_detail.receive_selected", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent coinDetailSendSelected(AnalyticsEvent.Companion companion, String coinName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(coinName, "coinName");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getCoinName(EventProperty.Companion), coinName));
        return new AnalyticsEvent(eventType, "coin_detail.send_selected", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent coinsTabLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_tab.coins.landed", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent collectibleDetailLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "collectible_detail.landed", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent collectibleTabLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_tab.collectibles.landed", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent collectibleTypeLanded(AnalyticsEvent.Companion companion, String collectibleTypeName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(collectibleTypeName, "collectibleTypeName");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getCollectibleType(EventProperty.Companion), collectibleTypeName));
        return new AnalyticsEvent(eventType, "collectible_type.landed", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent confirmTransactionTxSubmitted(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "confirm_transaction.tx_submitted", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent currencySettingsCurrencySet(AnalyticsEvent.Companion companion, String code) {
        Map e2;
        m.g(companion, "<this>");
        m.g(code, "code");
        EventFeature settings = EventFeature_ApplicationKt.getSettings(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_WalletsKt.getCurrencyCode(EventProperty.Companion), code));
        return new AnalyticsEvent(eventType, "currency_settings.currency_set", settings, false, e2, 8, null);
    }

    public static final AnalyticsEvent currencySettingsLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "currency_settings.landed", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent dappConnectedViaExtension(AnalyticsEvent.Companion companion, String dappName, String dappUrl, String dappIcon) {
        Map l2;
        m.g(companion, "<this>");
        m.g(dappName, "dappName");
        m.g(dappUrl, "dappUrl");
        m.g(dappIcon, "dappIcon");
        EventFeature walletLink = EventFeature_ApplicationKt.getWalletLink(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getDappName(companion2), dappName), u.a(EventProperty_ApplicationKt.getDappUrl(companion2), dappUrl), u.a(EventProperty_ApplicationKt.getDappIcon(companion2), dappIcon));
        return new AnalyticsEvent(eventType, "walletlink.dapp_connected_via_extension", walletLink, false, l2, 8, null);
    }

    public static final AnalyticsEvent dappConnectedViaWalletLink(AnalyticsEvent.Companion companion, String dappName, String dappUrl, String dappIcon) {
        Map l2;
        m.g(companion, "<this>");
        m.g(dappName, "dappName");
        m.g(dappUrl, "dappUrl");
        m.g(dappIcon, "dappIcon");
        EventFeature walletLink = EventFeature_ApplicationKt.getWalletLink(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getDappName(companion2), dappName), u.a(EventProperty_ApplicationKt.getDappUrl(companion2), dappUrl), u.a(EventProperty_ApplicationKt.getDappIcon(companion2), dappIcon));
        return new AnalyticsEvent(eventType, "walletlink.dapp_connected_via_walletlink", walletLink, false, l2, 8, null);
    }

    public static final AnalyticsEvent dappDetailDappOpened(AnalyticsEvent.Companion companion, String name, String categories) {
        Map l2;
        m.g(companion, "<this>");
        m.g(name, "name");
        m.g(categories, "categories");
        EventFeature dApps = EventFeature_ApplicationKt.getDApps(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getDappName(companion2), name), u.a(EventProperty_ApplicationKt.getCategories(companion2), categories));
        return new AnalyticsEvent(eventType, "dapp_detail.dapp_opened", dApps, false, l2, 8, null);
    }

    public static /* synthetic */ AnalyticsEvent dappDetailDappOpened$default(AnalyticsEvent.Companion companion, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        return dappDetailDappOpened(companion, str, str2);
    }

    public static final AnalyticsEvent dappDetailLanded(AnalyticsEvent.Companion companion, String name, String categories) {
        Map l2;
        m.g(companion, "<this>");
        m.g(name, "name");
        m.g(categories, "categories");
        EventFeature dApps = EventFeature_ApplicationKt.getDApps(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getDappName(companion2), name), u.a(EventProperty_ApplicationKt.getCategories(companion2), categories));
        return new AnalyticsEvent(eventType, "dapp_detail.landed", dApps, false, l2, 8, null);
    }

    public static /* synthetic */ AnalyticsEvent dappDetailLanded$default(AnalyticsEvent.Companion companion, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        return dappDetailLanded(companion, str, str2);
    }

    public static final AnalyticsEvent dappDirectoryLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dapp_directory.landed", EventFeature_ApplicationKt.getDApps(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent dappsTabDappBookmarked(AnalyticsEvent.Companion companion, String name, String categories) {
        Map l2;
        m.g(companion, "<this>");
        m.g(name, "name");
        m.g(categories, "categories");
        EventFeature dApps = EventFeature_ApplicationKt.getDApps(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getDappName(companion2), name), u.a(EventProperty_ApplicationKt.getCategories(companion2), categories));
        return new AnalyticsEvent(eventType, "dapps_tab.dapp_bookmarked", dApps, false, l2, 8, null);
    }

    public static /* synthetic */ AnalyticsEvent dappsTabDappBookmarked$default(AnalyticsEvent.Companion companion, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        return dappsTabDappBookmarked(companion, str, str2);
    }

    public static final AnalyticsEvent dappsTabLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dapps_tab.landed", EventFeature_ApplicationKt.getDApps(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent deviceLockAuthMethodBiometricSet(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "device_lock.auth_method.biometric_set", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent deviceLockAuthMethodPinSet(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "device_lock.auth_method.pin_set", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent deviceLockBiometryProtectionEnabled(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getIsBiometricProtectionEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(EventType.PRODUCT, "device_lock.biometry_protection", null, false, e2, 12, null);
    }

    public static final AnalyticsEvent deviceLockLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "device_lock.landed", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent displayAddressCopy(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "display_address.copy_to_clipboard", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent displayAddressInfoPromptSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "display_address.info_prompt_selected", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent displayAddressShare(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "display_address.share", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent domainNameCollision(AnalyticsEvent.Companion companion, String topLevelDomain, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(topLevelDomain, "topLevelDomain");
        EventFeature send = EventFeature_ApplicationKt.getSend(EventFeature.Companion);
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getTopLevelDomain(companion2), topLevelDomain), u.a(EventProperty_ApplicationKt.getDomainResultsMatched(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "send_domain_name_collision", send, false, l2, 8, null);
    }

    public static final AnalyticsEvent domainResult(AnalyticsEvent.Companion companion, String topLevelDomain, ResolveType source) {
        Map l2;
        m.g(companion, "<this>");
        m.g(topLevelDomain, "topLevelDomain");
        m.g(source, "source");
        EventFeature send = EventFeature_ApplicationKt.getSend(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getTopLevelDomain(companion2), topLevelDomain), u.a(EventProperty_ApplicationKt.getDomainSource(companion2), source.getRawValue()));
        return new AnalyticsEvent(eventType, "send_domain_result", send, false, l2, 8, null);
    }

    public static final AnalyticsEvent enablingVerifyAppsFailed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "security_prompt.verify_apps.failed_to_enable", EventFeature_ApplicationKt.getSecurityNotifications(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getBlankWalletList(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return (AnalyticsEvent) blankWalletList$delegate.getValue();
    }

    public static final AnalyticsEvent getSwapAmountPickerClose(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_amount_picker.close", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapAmountPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_amount_picker.landed", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapConfirmCoinbaseFeeInfo(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_confirm.coinbase_fee_info_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapConfirmEstimatedAmountInfo(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_confirm.estimated_amount_info_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapConfirmMinerFeeInfo(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_confirm.miner_fee_info_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapDisclaimerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_disclaimer.landed", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapEntryPointDetails(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_entry_point.details", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapEntryPointHome(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_entry_point.home", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapEntryPointLend(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_entry_point.lend", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent getSwapSuccessLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "swap_success.landed", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent globalReceiveSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_tab.global_receive_selected", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent globalSendSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_tab.global_send_selected", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent landingPageLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "landing.landed", null, false, null, 28, null);
    }

    public static final AnalyticsEvent legalLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.legal.landed", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent legalPrivacySelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.legal.privacy_selected", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent legalSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "settings_tab.legal_selected", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent legalTosSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.legal.tos_selected", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendAUCExplainerStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "explainer.auc.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendAmountPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "amount_picker.landed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendCoinPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "coin_picker.landed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendCoinPickerTransferSheetStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "coin_picker.transfer_sheet.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendCollateralExplainerStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "explainer.collateral.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendConfirmationLanded(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getAmountType(EventProperty.Companion), amountType(z)));
        return new AnalyticsEvent(EventType.PRODUCT, "confirmation.lend.landed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent lendConfirmationLendStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "confirmation.lend.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendConfirmationTxSubmitted(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getAmountType(EventProperty.Companion), amountType(z)));
        return new AnalyticsEvent(EventType.PRODUCT, "confirmation.tx_submitted", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent lendConfirmationWithdrawStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "confirmation.withdraw.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendDashboardConfirmed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dashboard.confirmed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendDashboardEarnMoreLendStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dashboard.earn_more.lend.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendDashboardEarnMoreStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dashboard.earn_more.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendDashboardEarnMoreWithdrawStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dashboard.earn_more.withdraw.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendDashboardLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dashboard.landed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendDashboardPending(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dashboard.pending", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendEarnInterestExistingUserStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "earn_interest.existing_user.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendEarnInterestNewUserStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "earn_interest.new_user.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendEarnInterestTestnet(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "earn_interest.testnet", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendProviderPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "provider_picker.landed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendTxGenerationError(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.DIAGNOSTIC, "lend_tx_generation_error", null, false, null, 28, null);
    }

    public static final AnalyticsEvent lendUserAgreementLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "user_agreement.landed", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent lendUtilizationExplainerStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "explainer.utilization.start", EventFeature_ApplicationKt.getLend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent networkPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "network_picker.landed", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent networkPickerNetworkChanged(AnalyticsEvent.Companion companion, String network, Blockchain blockchain, EthereumChain ethereumChain) {
        Map l2;
        String displayName;
        m.g(companion, "<this>");
        m.g(network, "network");
        m.g(blockchain, "blockchain");
        EventFeature settings = EventFeature_ApplicationKt.getSettings(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[3];
        EventProperty.Companion companion2 = EventProperty.Companion;
        oVarArr[0] = u.a(EventProperty_ApplicationKt.getNetworkName(companion2), network);
        oVarArr[1] = u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.getRawValue());
        EventProperty chainName = EventProperty_WalletsKt.getChainName(companion2);
        String str = "";
        if (ethereumChain != null && (displayName = ethereumChain.getDisplayName()) != null) {
            str = displayName;
        }
        oVarArr[2] = u.a(chainName, str);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "network_picker.network_changed", settings, false, l2, 8, null);
    }

    public static final AnalyticsEvent newWalletCreated(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.new_wallet.created", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent newWalletStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.new_wallet.start", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent onboardingSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.success", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent providerSecurityPromptDismissed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "security_prompt.provider.dismissed", EventFeature_ApplicationKt.getSecurityNotifications(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent receiveCoinPickerCoinSelected(AnalyticsEvent.Companion companion, String coinName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(coinName, "coinName");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getCoinName(EventProperty.Companion), coinName));
        return new AnalyticsEvent(eventType, "receive_coin_picker.coin_selected", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent receiveCoinPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "receive_coin_picker.landed", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent recipientSelected(AnalyticsEvent.Companion companion, RecipientType recipientType, CurrencyCode currencyCode, int i2, int i3) {
        String str;
        Map l2;
        m.g(companion, "<this>");
        m.g(recipientType, "recipientType");
        m.g(currencyCode, "currencyCode");
        int i4 = WhenMappings.$EnumSwitchMapping$0[recipientType.ordinal()];
        if (i4 == 1) {
            str = "address";
        } else if (i4 == 2) {
            str = "coinbase";
        } else if (i4 == 3) {
            str = "ens";
        } else if (i4 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = ApiConstants.USER;
        }
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getRecipientType(companion2), str), u.a(EventProperty_ApplicationKt.getQueryLength(companion2), String.valueOf(i2)), u.a(EventProperty_ApplicationKt.getSendCount(companion2), String.valueOf(i3)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getCode()));
        return new AnalyticsEvent(eventType, "recipient_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent recoveryPhraseClearedFromClipboard(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.recovery_phrase_clipboard_cleared", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent recoveryPhraseCopiedToClipboard(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "key_backup.recovery_phrase_copied", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent recoveryPhraseLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "recovery_phrase.landed", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent restoreWalletLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "restore_wallet.landed ", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent restoreWalletNewUserStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.restore_wallet.start", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent restoreWalletSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.restore_wallet.success", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent restoreWithCloudStart(AnalyticsEvent.Companion companion, String service) {
        Map e2;
        m.g(companion, "<this>");
        m.g(service, "service");
        EventFeature keyBackup = EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getBackupService(EventProperty.Companion), service));
        return new AnalyticsEvent(eventType, "restore_wallet.cloud.start", keyBackup, false, e2, 8, null);
    }

    public static /* synthetic */ AnalyticsEvent restoreWithCloudStart$default(AnalyticsEvent.Companion companion, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "gdrive";
        }
        return restoreWithCloudStart(companion, str);
    }

    public static final AnalyticsEvent restoreWithCloudSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "restore_wallet.cloud.success", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent restoreWithManualStart(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "restore_wallet.manual.start", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent restoreWithManualSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "restore_wallet.manual.success", EventFeature_ApplicationKt.getKeyBackup(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendCoinAmountCoinPickerSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_coin_amount.coin_picker_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendCoinAmountLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_coin_amount.landed", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendCoinAmountMaxSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_coin_amount.max_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendCoinAmountNextSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_coin_amount.next_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendCoinAmountSwapSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_coin_amount.swap_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendCoinPickerCoinSelected(AnalyticsEvent.Companion companion, String coinName) {
        Map e2;
        m.g(companion, "<this>");
        m.g(coinName, "coinName");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getCoinName(EventProperty.Companion), coinName));
        return new AnalyticsEvent(eventType, "send_coin_picker.coin_selected", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent sendCoinPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_coin_picker.landed", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendConfirmDetailsHide(AnalyticsEvent.Companion companion) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getState(EventProperty.Companion), "hide"));
        return new AnalyticsEvent(EventType.PRODUCT, "send_confirm.details_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent sendConfirmDetailsShow(AnalyticsEvent.Companion companion) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getState(EventProperty.Companion), "show"));
        return new AnalyticsEvent(EventType.PRODUCT, "send_confirm.details_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent sendConfirmErrorReceived(AnalyticsEvent.Companion companion, String coin, String description) {
        Map l2;
        m.g(companion, "<this>");
        m.g(coin, "coin");
        m.g(description, "description");
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getCoinName(companion2), coin), u.a(companion2.getDescription(), description));
        return new AnalyticsEvent(EventType.PRODUCT, "send_confirm.error_received", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent sendConfirmLanded(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getAmountType(EventProperty.Companion), amountType(z)));
        return new AnalyticsEvent(EventType.PRODUCT, "send_confirm.landed", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent sendConfirmSendSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_confirm.send_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendConfirmTxSubmitted(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getAmountType(EventProperty.Companion), amountType(z)));
        return new AnalyticsEvent(EventType.PRODUCT, "confirm_transaction.tx_submitted", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent sendDestinationAddressSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_destination.address_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendDestinationLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_destination.landed", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendDestinationManualMetadataSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_destination.manual_metadata_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendDestinationManualSearchSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_destination.manual_search_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendDestinationPasteSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_destination.paste_selected", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendDestinationPasteShow(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_destination.paste_show", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent sendSuccessLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "send_success.landed", EventFeature_ApplicationKt.getSend(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent settingsLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "settings_tab.landed", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent signOutSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "settings_tab.sign_out", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent signerEvent(AnalyticsEvent.Companion companion, SigningSessionEvent event, EventFeature feature) {
        String str;
        Map e2;
        m.g(companion, "<this>");
        m.g(event, "event");
        m.g(feature, "feature");
        if (event instanceof SigningSessionEvent.SignedAndSubmittedTx) {
            str = "signer.sign_and_submit";
        } else if (event instanceof SigningSessionEvent.SignedTx) {
            str = "signer.sign_tx";
        } else if (event instanceof SigningSessionEvent.Cancelled) {
            str = "signer.cancelled";
        } else if (event instanceof SigningSessionEvent.SignedMessage) {
            str = "signer.sign_message";
        } else if (event instanceof SigningSessionEvent.RequestEthereumAccountsApproved) {
            str = "signer.dapp_permission";
        } else if (event instanceof SigningSessionEvent.Signing) {
            str = "signer.signing";
        } else if (event instanceof SigningSessionEvent.Failure) {
            str = "signer.failure";
        } else if (!(event instanceof SigningSessionEvent.SwitchEthereumChainApproved)) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = "signer.switch_ethereum_chain_approved";
        }
        String str2 = str;
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty.Companion.getUUID(), event.getUuid()));
        return new AnalyticsEvent(eventType, str2, feature, false, e2);
    }

    public static final AnalyticsEvent swapAmountPickerCardSelected(AnalyticsEvent.Companion companion, String card) {
        Map e2;
        m.g(companion, "<this>");
        m.g(card, "card");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getType(EventProperty.Companion), card));
        return new AnalyticsEvent(eventType, "swap_amount_picker.card_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent swapAmountPickerConvertAll(AnalyticsEvent.Companion companion, String source, String str) {
        Map l2;
        m.g(companion, "<this>");
        m.g(source, "source");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[2];
        EventProperty.Companion companion2 = EventProperty.Companion;
        oVarArr[0] = u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source);
        EventProperty swapToAsset = EventProperty_ApplicationKt.getSwapToAsset(companion2);
        if (str == null) {
            str = "not set";
        }
        oVarArr[1] = u.a(swapToAsset, str);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_amount_picker.convert_all", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapAmountPickerGenericError(AnalyticsEvent.Companion companion, String str, String source, String str2) {
        Map l2;
        m.g(companion, "<this>");
        m.g(source, "source");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[3];
        EventProperty.Companion companion2 = EventProperty.Companion;
        EventProperty description = companion2.getDescription();
        if (str == null) {
            str = "no description";
        }
        oVarArr[0] = u.a(description, str);
        oVarArr[1] = u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source);
        EventProperty swapToAsset = EventProperty_ApplicationKt.getSwapToAsset(companion2);
        if (str2 == null) {
            str2 = "not set";
        }
        oVarArr[2] = u.a(swapToAsset, str2);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_amount_picker.generic_error", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapAmountPickerInsufficientBalance(AnalyticsEvent.Companion companion, String str, String str2) {
        Map l2;
        m.g(companion, "<this>");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[2];
        EventProperty.Companion companion2 = EventProperty.Companion;
        EventProperty swapFromAsset = EventProperty_ApplicationKt.getSwapFromAsset(companion2);
        if (str == null) {
            str = "not set";
        }
        oVarArr[0] = u.a(swapFromAsset, str);
        EventProperty swapToAsset = EventProperty_ApplicationKt.getSwapToAsset(companion2);
        if (str2 == null) {
            str2 = "not set";
        }
        oVarArr[1] = u.a(swapToAsset, str2);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_amount_picker.insufficient_balance", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapAmountPickerLiquidityError(AnalyticsEvent.Companion companion, String str, String str2) {
        Map l2;
        m.g(companion, "<this>");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[2];
        EventProperty.Companion companion2 = EventProperty.Companion;
        EventProperty swapFromAsset = EventProperty_ApplicationKt.getSwapFromAsset(companion2);
        if (str == null) {
            str = "not set";
        }
        oVarArr[0] = u.a(swapFromAsset, str);
        EventProperty swapToAsset = EventProperty_ApplicationKt.getSwapToAsset(companion2);
        if (str2 == null) {
            str2 = "not set";
        }
        oVarArr[1] = u.a(swapToAsset, str2);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_amount_picker.not_enough_liquidity_error", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapAmountPickerProceed(AnalyticsEvent.Companion companion, String amountBase, String type, String source, String target) {
        Map l2;
        m.g(companion, "<this>");
        m.g(amountBase, "amountBase");
        m.g(type, "type");
        m.g(source, "source");
        m.g(target, "target");
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getAmountBase(companion2), amountBase), u.a(EventProperty_ApplicationKt.getType(companion2), type), u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source), u.a(EventProperty_ApplicationKt.getSwapToAsset(companion2), target));
        return new AnalyticsEvent(eventType, "swap_amount_picker.proceed", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapAmountPickerToDisabled(AnalyticsEvent.Companion companion, String source, String target) {
        Map l2;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(target, "target");
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source), u.a(EventProperty_ApplicationKt.getSwapToAsset(companion2), target));
        return new AnalyticsEvent(eventType, "swap_amount_picker.target_disabled", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapAssetPickerLanded(AnalyticsEvent.Companion companion, String direction) {
        Map e2;
        m.g(companion, "<this>");
        m.g(direction, "direction");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getType(EventProperty.Companion), direction));
        return new AnalyticsEvent(eventType, "swap_asset_picker.landed", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent swapConfirmConvertSelected(AnalyticsEvent.Companion companion, String source, String str, String sourceAmount, String sourceFiatAmount, String target, String str2, String targetAmount, int i2) {
        Map l2;
        String displayName;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(sourceAmount, "sourceAmount");
        m.g(sourceFiatAmount, "sourceFiatAmount");
        m.g(target, "target");
        m.g(targetAmount, "targetAmount");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[9];
        EventProperty.Companion companion2 = EventProperty.Companion;
        oVarArr[0] = u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source);
        EventProperty swapFromAssetContractAddress = EventProperty_ApplicationKt.getSwapFromAssetContractAddress(companion2);
        String str3 = "";
        if (str == null) {
            str = "";
        }
        oVarArr[1] = u.a(swapFromAssetContractAddress, str);
        oVarArr[2] = u.a(EventProperty_ApplicationKt.getSwapFromAssetAmount(companion2), sourceAmount);
        oVarArr[3] = u.a(EventProperty_ApplicationKt.getSwapFromAssetFiatAmount(companion2), sourceFiatAmount);
        oVarArr[4] = u.a(EventProperty_ApplicationKt.getSwapToAsset(companion2), target);
        EventProperty swapToAssetContractAddress = EventProperty_ApplicationKt.getSwapToAssetContractAddress(companion2);
        if (str2 == null) {
            str2 = "";
        }
        oVarArr[5] = u.a(swapToAssetContractAddress, str2);
        oVarArr[6] = u.a(EventProperty_ApplicationKt.getSwapToAssetAmount(companion2), targetAmount);
        oVarArr[7] = u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(i2));
        EventProperty chainName = EventProperty_WalletsKt.getChainName(companion2);
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(i2);
        if (fromChainId != null && (displayName = fromChainId.getDisplayName()) != null) {
            str3 = displayName;
        }
        oVarArr[8] = u.a(chainName, str3);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_confirm.convert_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapConfirmErrorReceived(AnalyticsEvent.Companion companion, String str, String source, String target) {
        Map l2;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(target, "target");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[3];
        EventProperty.Companion companion2 = EventProperty.Companion;
        EventProperty description = companion2.getDescription();
        if (str == null) {
            str = "no description";
        }
        oVarArr[0] = u.a(description, str);
        oVarArr[1] = u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source);
        oVarArr[2] = u.a(EventProperty_ApplicationKt.getSwapToAsset(companion2), target);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_confirm.error_received", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapConfirmMinerFee(AnalyticsEvent.Companion companion, String source, String str, String target, String str2, String fee, String sourceAmount, String sourceFiatAmount, String targetAmount, int i2) {
        Map l2;
        String displayName;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(target, "target");
        m.g(fee, "fee");
        m.g(sourceAmount, "sourceAmount");
        m.g(sourceFiatAmount, "sourceFiatAmount");
        m.g(targetAmount, "targetAmount");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[10];
        EventProperty.Companion companion2 = EventProperty.Companion;
        oVarArr[0] = u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source);
        EventProperty swapFromAssetContractAddress = EventProperty_ApplicationKt.getSwapFromAssetContractAddress(companion2);
        String str3 = "";
        if (str == null) {
            str = "";
        }
        oVarArr[1] = u.a(swapFromAssetContractAddress, str);
        oVarArr[2] = u.a(EventProperty_ApplicationKt.getSwapFromAssetAmount(companion2), sourceAmount);
        oVarArr[3] = u.a(EventProperty_ApplicationKt.getSwapFromAssetFiatAmount(companion2), sourceFiatAmount);
        oVarArr[4] = u.a(EventProperty_ApplicationKt.getSwapToAsset(companion2), target);
        EventProperty swapToAssetContractAddress = EventProperty_ApplicationKt.getSwapToAssetContractAddress(companion2);
        if (str2 == null) {
            str2 = "";
        }
        oVarArr[5] = u.a(swapToAssetContractAddress, str2);
        oVarArr[6] = u.a(EventProperty_ApplicationKt.getSwapToAssetAmount(companion2), targetAmount);
        oVarArr[7] = u.a(EventProperty_ApplicationKt.getSwapFeeAmount(companion2), fee);
        oVarArr[8] = u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(i2));
        EventProperty chainName = EventProperty_WalletsKt.getChainName(companion2);
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(i2);
        if (fromChainId != null && (displayName = fromChainId.getDisplayName()) != null) {
            str3 = displayName;
        }
        oVarArr[9] = u.a(chainName, str3);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_confirm.swap_miner_fee", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapEntryPointNotSupported(AnalyticsEvent.Companion companion, String code) {
        Map e2;
        m.g(companion, "<this>");
        m.g(code, "code");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_WalletsKt.getCurrencyCode(EventProperty.Companion), code));
        return new AnalyticsEvent(eventType, "swap_entry_point.not_supported_asset_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent swapNonConvertibleAssetSelected(AnalyticsEvent.Companion companion, String code) {
        Map e2;
        m.g(companion, "<this>");
        m.g(code, "code");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_WalletsKt.getCurrencyCode(EventProperty.Companion), code));
        return new AnalyticsEvent(eventType, "swap_asset_picker.non_convertible_asset_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent swapNotSupportedAssetSelected(AnalyticsEvent.Companion companion, String code) {
        Map e2;
        m.g(companion, "<this>");
        m.g(code, "code");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_WalletsKt.getCurrencyCode(EventProperty.Companion), code));
        return new AnalyticsEvent(eventType, "swap_asset_picker.non_supported_asset_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent swapNotSupportedPromptAggregatorSelected(AnalyticsEvent.Companion companion, String aggregatorID) {
        Map e2;
        m.g(companion, "<this>");
        m.g(aggregatorID, "aggregatorID");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getSwapAggregatorID(EventProperty.Companion), aggregatorID));
        return new AnalyticsEvent(eventType, "swap_asset_picker.prompt_aggregator_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent swapPriceImpact(AnalyticsEvent.Companion companion, String source, String str, String target, String str2, int i2) {
        Map l2;
        String displayName;
        m.g(companion, "<this>");
        m.g(source, "source");
        m.g(target, "target");
        EventType eventType = EventType.PRODUCT;
        o[] oVarArr = new o[6];
        EventProperty.Companion companion2 = EventProperty.Companion;
        oVarArr[0] = u.a(EventProperty_ApplicationKt.getSwapFromAsset(companion2), source);
        EventProperty swapFromAssetContractAddress = EventProperty_ApplicationKt.getSwapFromAssetContractAddress(companion2);
        String str3 = "";
        if (str == null) {
            str = "";
        }
        oVarArr[1] = u.a(swapFromAssetContractAddress, str);
        oVarArr[2] = u.a(EventProperty_ApplicationKt.getSwapToAsset(companion2), target);
        EventProperty swapToAssetContractAddress = EventProperty_ApplicationKt.getSwapToAssetContractAddress(companion2);
        if (str2 == null) {
            str2 = "";
        }
        oVarArr[3] = u.a(swapToAssetContractAddress, str2);
        oVarArr[4] = u.a(EventProperty_WalletsKt.getChainId(companion2), String.valueOf(i2));
        EventProperty chainName = EventProperty_WalletsKt.getChainName(companion2);
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(i2);
        if (fromChainId != null && (displayName = fromChainId.getDisplayName()) != null) {
            str3 = displayName;
        }
        oVarArr[5] = u.a(chainName, str3);
        l2 = m0.l(oVarArr);
        return new AnalyticsEvent(eventType, "swap_confirm.swap_price_impact", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, l2, 8, null);
    }

    public static final AnalyticsEvent swapSupportedAssetSelected(AnalyticsEvent.Companion companion, String code) {
        Map e2;
        m.g(companion, "<this>");
        m.g(code, "code");
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_WalletsKt.getCurrencyCode(EventProperty.Companion), code));
        return new AnalyticsEvent(eventType, "swap_asset_picker.supported_asset_selected", EventFeature_ApplicationKt.getSwap(EventFeature.Companion), false, e2, 8, null);
    }

    public static final AnalyticsEvent transferCoinsCTASelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.transfer_cta_selected", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent txGenerationError(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.DIAGNOSTIC, "tx_generation_error", null, false, null, 28, null);
    }

    public static final AnalyticsEvent txSubmittedViaExtension(AnalyticsEvent.Companion companion) {
        Map i2;
        m.g(companion, "<this>");
        EventFeature walletLink = EventFeature_ApplicationKt.getWalletLink(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        i2 = m0.i();
        return new AnalyticsEvent(eventType, "walletlink.tx_submitted_via_extension", walletLink, false, i2, 8, null);
    }

    public static final AnalyticsEvent universalQrScannerClicked(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_tab.universal_qr_scanner_selected", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent updateSecurityProviderNotPossible(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "security_prompt.update_security_provider.not_possible", EventFeature_ApplicationKt.getSecurityNotifications(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent userActivated(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "user_activated", null, false, null, 28, null);
    }

    public static final AnalyticsEvent usernameLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "onboarding.username.landed", EventFeature_ApplicationKt.getOnboarding(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent verifyAppsPromptDismissed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "security_prompt.verify_apps.dismissed", EventFeature_ApplicationKt.getSecurityNotifications(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent verifyAppsPromptEnabled(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "security_prompt.verify_apps.enabled", EventFeature_ApplicationKt.getSecurityNotifications(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent walletDetailFundActionConsumerTapped(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, Blockchain blockchain) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.toString()), u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.toString()));
        return new AnalyticsEvent(eventType, "wallet_detail.fund_action.consumer.tapped", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent walletDetailFundActionViewed(AnalyticsEvent.Companion companion, boolean z, boolean z2, CurrencyCode currencyCode, Blockchain blockchain) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(blockchain, "blockchain");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getSwapEnabled(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z2)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_WalletsKt.getBlockchain(companion2), blockchain.getRawValue()));
        return new AnalyticsEvent(eventType, "wallet_detail.fund_action.viewed", wallet, false, l2, 8, null);
    }

    public static final AnalyticsEvent walletPickerLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_picker.landed", EventFeature_ApplicationKt.getSettings(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent walletPickerWalletChanged(AnalyticsEvent.Companion companion, int i2) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature settings = EventFeature_ApplicationKt.getSettings(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ApplicationKt.getWalletNumber(EventProperty.Companion), String.valueOf(i2)));
        return new AnalyticsEvent(eventType, "wallet_picker.wallet_changed", settings, false, e2, 8, null);
    }

    public static final AnalyticsEvent walletTabLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "wallet_tab.landed", EventFeature_ApplicationKt.getWallet(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent walletsEmptyStateViewed(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "wallets.empty_state.viewed", wallet, false, e2, 8, null);
    }

    public static final AnalyticsEvent walletsFundActionConsumerTapped(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "wallets.fund_action.consumer.tapped", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent walletsFundActionViewed(AnalyticsEvent.Companion companion, boolean z, boolean z2) {
        Map l2;
        m.g(companion, "<this>");
        EventFeature wallet = EventFeature_ApplicationKt.getWallet(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ApplicationKt.getSwapEnabled(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z2)));
        return new AnalyticsEvent(eventType, "wallets.fund_action.viewed", wallet, false, l2, 8, null);
    }

    public static final AnalyticsEvent webExtensionApproved(AnalyticsEvent.Companion companion) {
        Map i2;
        m.g(companion, "<this>");
        EventFeature walletLink = EventFeature_ApplicationKt.getWalletLink(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        i2 = m0.i();
        return new AnalyticsEvent(eventType, "walletlink.extension_approved", walletLink, false, i2, 8, null);
    }

    public static final AnalyticsEvent whatAreDappsLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "dapps_tab.what_are_dapps.landed", EventFeature_ApplicationKt.getDApps(EventFeature.Companion), false, null, 24, null);
    }
}