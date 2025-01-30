package com.coinbase.wallet.consumer.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.EventFeature;
import com.coinbase.wallet.analytics.models.EventProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.wallets.extensions.EventProperty_WalletsKt;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: AnalyticsEvent+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b&\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\n\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\f\u0010\t\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0005\u001a\u0019\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u0011\u0010\u000f\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\t\u001a\u0011\u0010\u0010\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\t\u001a\u0011\u0010\u0011\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\t\u001a\u0011\u0010\u0012\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\t\u001a\u0011\u0010\u0013\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\t\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0005\u001a\u0019\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u0005\u001a\u0011\u0010\u001b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\t\u001a\u0011\u0010\u001c\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\t\u001a\u0011\u0010\u001d\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\t\u001a\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u0019\u0010\u001f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001f\u0010\u0005\u001a\u0011\u0010 \u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b \u0010\t\u001a\u0011\u0010!\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b!\u0010\t\u001a\u0011\u0010\"\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\"\u0010\t\u001a\u0011\u0010#\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b#\u0010\t\u001a\u0019\u0010&\u001a\u00020\u0003*\u00020\u00002\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'\u001a\u0011\u0010(\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b(\u0010\t\u001a\u0019\u0010*\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\b*\u0010\u0017\u001a\u0011\u0010+\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b+\u0010\t\u001a\u0011\u0010,\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b,\u0010\t\u001a\u0011\u0010-\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b-\u0010\t\u001a\u0011\u0010.\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b.\u0010\t\u001a\u0011\u0010/\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b/\u0010\t\u001a\u0019\u00100\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\b0\u0010\u0017\u001a!\u00103\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104\u001a!\u00105\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\b5\u00104\u001a!\u00106\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\b6\u00104\u001a!\u00109\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:\u001a)\u0010;\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u000201¢\u0006\u0004\b;\u0010<\u001a)\u0010=\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u000201¢\u0006\u0004\b=\u0010<\u001a1\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\b?\u0010@\u001a1\u0010A\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bA\u0010@\u001a)\u0010B\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bB\u0010C\u001a!\u0010D\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u000201¢\u0006\u0004\bD\u0010E\u001a!\u0010F\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u000201¢\u0006\u0004\bF\u0010E\u001a\u0011\u0010G\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\bG\u0010\t\u001a;\u0010I\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bI\u0010J\u001a;\u0010K\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bK\u0010J\u001a!\u0010L\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u0001¢\u0006\u0004\bL\u0010M\u001aC\u0010O\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bO\u0010P\u001a9\u0010Q\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bQ\u0010R\u001a9\u0010S\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bS\u0010R\u001a9\u0010T\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bT\u0010R\u001a9\u0010U\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bU\u0010R\u001a9\u0010V\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bV\u0010R\u001aQ\u0010[\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u0002012\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\\u001a9\u0010]\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\b]\u0010R\u001aI\u0010_\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u0002012\u0006\u0010^\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b_\u0010`\u001aA\u0010a\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u00102\u001a\u0002012\u0006\u0010W\u001a\u00020\u0014¢\u0006\u0004\ba\u0010b\u001aC\u0010c\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bc\u0010P\u001aC\u0010d\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u00102\u001a\u000201¢\u0006\u0004\bd\u0010P\u001aK\u0010e\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u00142\u0006\u0010N\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u00102\u001a\u0002012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\be\u0010f\u001a\u0011\u0010g\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\bg\u0010\t\u001a\u0011\u0010h\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\bh\u0010\t\u001a\u0011\u0010i\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\bi\u0010\t\u001a\u0011\u0010j\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\bj\u0010\t\u001a)\u0010k\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\bk\u0010l\u001a)\u0010m\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\bm\u0010l\u001a)\u0010n\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\bn\u0010l\u001a)\u0010o\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\bo\u0010l\u001a)\u0010p\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010)\u001a\u00020\u00142\u0006\u00102\u001a\u000201¢\u0006\u0004\bp\u0010l\u001a!\u0010q\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u0001¢\u0006\u0004\bq\u0010M\u001a!\u0010r\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u0001¢\u0006\u0004\br\u0010M\u001a)\u0010s\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\bs\u0010t\u001a!\u0010u\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u0001¢\u0006\u0004\bu\u0010M\u001a3\u0010v\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bv\u0010w\u001a!\u0010x\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u0001¢\u0006\u0004\bx\u0010M\u001a)\u0010y\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u0010>\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0014¢\u0006\u0004\by\u0010t\u001a)\u0010z\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\bz\u0010{\u001a)\u0010|\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b|\u0010{\u001a)\u0010}\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b}\u0010{\u001a)\u0010~\u001a\u00020\u0003*\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00102\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b~\u0010{¨\u0006\u007f"}, d2 = {"Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;", "", "onrampEnabled", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferInitiated", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Z)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerConnectStart", "consumerSignInApptoAppStarted", "consumerApptoAppSuccess", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerApptoAppError", "consumerApptoAppDisabled", "consumerApptoAppUserCanceled", "consumerSignInWebviewStarted", "consumerSigninWebviewViewed", "oauthSignInLanded", "oauthTwoFaLanded", "oauthVerifyEmailLanded", "oauthAllowAccessLanded", "consumerSignupButtonTapped", "", "oauthType", "consumerConnectSuccess", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerOnrampOnboardingShown", "consumerOnrampOnboardingSuccess", "consumerOnrampOnboardingCanceled", "consumerOnrampNewUserPaymentMethodFlowShown", "consumerOnrampNewUserAddedPaymentMethod", "consumerSplashScreenViewed", "consumerAccountsViewed", "consumerAccountsSettingsTapped", "congratsTransferLaterSelected", "congratsTransferNowSelected", "consumerAccountSettingsPaymentMethodFlowTapped", "consumerConnectDisconnected", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "account", "transferCoinSelected", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerPaymentMethodsViewed", "paymentMethodType", "consumerPaymentMethodTapped", "consumerAddCardViewed", "consumerAddCardLoaded", "consumerAddCardSuccessCDVRequired", "consumerAddCardCancel", "consumerAddCardSuccess", "consumerCardCDVViewed", "Ljava/util/UUID;", "uuid", "consumerCardCDVSubmitted", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Ljava/lang/String;Ljava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerCardCDVSuccess", "consumerCardCDVError", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "consumerAmountPickerViewed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerAmountPickerMaxTapped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerAmountPickerCachedMaxViewed", "fiatSelected", "consumerAmountPickerContinueTapped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerAmountPickerToConfirmationNavigated", "consumerAmountPickerToTransferMethodsNavigated", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerAmountPickerWBLViewed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerAmountPickerInsufficientBalanceViewed", "consumerAmountPickerCurrencySelectorTapped", "sendSelected", "consumerTransferConfirmationViewed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;ZZLjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferConfirmationTransferSelected", "consumerTransferConfirmationToTransferMethodsNavigated", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Z)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "maxTransfer", "consumerTransferConfirmationConfirmTapped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;ZZLjava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferConfirmationBuyCommitStarted", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;ZLjava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferConfirmationBuyCommitError", "consumerTransferConfirmationCompleteBuyAfterSecure3DStarted", "consumerTransferConfirmationCompleteBuyAfterSecure3DError", "consumerTransferConfirmationBuyGetStatusStarted", "buyStatus", "requiresCompletionStep", "", "attemptNumber", "consumerTransferConfirmationBuyGetStatusEvent", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;ZLjava/util/UUID;Ljava/lang/String;ZI)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferConfirmationBuyAccountBalanceCheckStarted", "balanceIncreased", "consumerTransferConfirmationBuyAccountBalanceCheckStatus", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;ZLjava/util/UUID;ZI)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferConfirmationBuyGetStatusError", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;ZLjava/util/UUID;Ljava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferConfirmSendStarted", "consumerTransferConfirmSendCompleted", "consumerTransferConfirmSendError", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;ZZLjava/util/UUID;I)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferTwoFaViewed", "consumerTransferTwoFaSubmitted", "consumerTransferTwoFaError", "consumerTransferTwoFaSuccess", "consumerSecure3DVerificationViewed", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/util/UUID;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerSecure3DVerificationPageLoaded", "consumerSecure3DVerificationAuthorizationCompleted", "consumerSecure3DVerificationAuthorizationFailed", "consumerSecure3DVerificationCanceled", "consumerTransferMethodsViewed", "consumerTransferMethodsAddPaymentTapped", "consumerTransferMethodsVerifyPaymentTapped", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferMethodsAddPaymentSuccess", "consumerTransferMethodsTransferSelected", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZZLjava/lang/String;)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerTransferMethodsWBLViewed", "consumerTransferMethodsPaymentLimitViewed", "consumerMaxTransferStarted", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent$Companion;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/util/UUID;Z)Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "consumerMaxTransferCompleted", "consumerAvailableTransferStarted", "consumerAvailableTransferCompleted", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AnalyticsEvent_ConsumerKt {
    public static final AnalyticsEvent congratsTransferLaterSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.congrats.transfer_later", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent congratsTransferNowSelected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.congrats.transfer_now", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAccountSettingsPaymentMethodFlowTapped(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.account_settings.payment_method_flow.tapped", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAccountsSettingsTapped(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.consumer_accounts_settings_tapped", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerAccountsViewed(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.consumer_accounts_viewed", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerAddCardCancel(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.add_card.cancel", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAddCardLoaded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.add_card.loaded", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAddCardSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.add_card.success", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAddCardSuccessCDVRequired(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.add_card.success.cdv_required", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAddCardViewed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.add_card.viewed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAmountPickerCachedMaxViewed(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker.cached_max.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerContinueTapped(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker.continue.tapped", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerCurrencySelectorTapped(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.amount_picker.currency_selector.tapped", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAmountPickerInsufficientBalanceViewed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker.insufficient_balance.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerMaxTapped(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker.max.tapped", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerToConfirmationNavigated(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker_to_confirmation.navigated", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerToTransferMethodsNavigated(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker_to_transfer_methods.navigated", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerViewed(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAmountPickerWBLViewed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.amount_picker.wbl.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerApptoAppDisabled(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.app_to_app.disabled", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerApptoAppError(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.app_to_app.error", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerApptoAppSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.app_to_app.success", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerApptoAppUserCanceled(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.app_to_app.canceled", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerAvailableTransferCompleted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, UUID uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.available_transfer.completed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerAvailableTransferStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, UUID uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.available_transfer.started", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerCardCDVError(AnalyticsEvent.Companion companion, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.card_cdv.error", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerCardCDVSubmitted(AnalyticsEvent.Companion companion, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.card_cdv.submitted", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerCardCDVSuccess(AnalyticsEvent.Companion companion, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.card_cdv.success", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerCardCDVViewed(AnalyticsEvent.Companion companion, String paymentMethodType) {
        Map e2;
        m.g(companion, "<this>");
        m.g(paymentMethodType, "paymentMethodType");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getPaymentMethodType(EventProperty.Companion), paymentMethodType));
        return new AnalyticsEvent(eventType, "consumer_connect.card_cdv.viewed", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerConnectDisconnected(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.consumerConnectDisconnected", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerConnectStart(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.start", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerConnectSuccess(AnalyticsEvent.Companion companion, String oauthType) {
        Map e2;
        m.g(companion, "<this>");
        m.g(oauthType, "oauthType");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOAuthType(EventProperty.Companion), oauthType));
        return new AnalyticsEvent(eventType, "consumer_connect.success", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerMaxTransferCompleted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, UUID uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.max_transfer.completed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerMaxTransferStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, UUID uuid, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.DIAGNOSTIC;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.max_transfer.started", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerOnrampNewUserAddedPaymentMethod(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.onramp.new_user.added_payment_method", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerOnrampNewUserPaymentMethodFlowShown(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.onramp.new_user.payment_method_flow.shown", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerOnrampOnboardingCanceled(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.onramp.onboarding.canceled", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerOnrampOnboardingShown(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.onramp.onboarding.shown", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerOnrampOnboardingSuccess(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.onramp.onboarding.success", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerPaymentMethodTapped(AnalyticsEvent.Companion companion, String paymentMethodType) {
        Map e2;
        m.g(companion, "<this>");
        m.g(paymentMethodType, "paymentMethodType");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getPaymentMethodType(EventProperty.Companion), paymentMethodType));
        return new AnalyticsEvent(eventType, "consumer_connect.payment_method.tapped", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerPaymentMethodsViewed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.payment_methods.viewed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerSecure3DVerificationAuthorizationCompleted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.secure_3d_verification.completed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerSecure3DVerificationAuthorizationFailed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.secure_3d_verification.failed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerSecure3DVerificationCanceled(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.secure_3d_verification.canceled", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerSecure3DVerificationPageLoaded(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.secure_3d_verification.page_loaded", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerSecure3DVerificationViewed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, String paymentMethodType, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.secure_3d_verification.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerSignInApptoAppStarted(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.sign_in.app_to_app.started", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerSignInWebviewStarted(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.sign_in.webview.started", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerSigninWebviewViewed(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.sign_in.webview.viewed", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerSignupButtonTapped(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.sign_up_button.tapped", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerSplashScreenViewed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.splash_screen.viewed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmSendCompleted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String str, boolean z2, boolean z3, UUID uuid) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z3)), u.a(companion2.getUUID(), uuid.toString()));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.send.completed", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmSendError(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String str, boolean z2, boolean z3, UUID uuid, int i2) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z3)), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getAttemptNumber(companion2), String.valueOf(i2)));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.send.error", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmSendStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String str, boolean z2, boolean z3, UUID uuid) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z3)), u.a(companion2.getUUID(), uuid.toString()));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.send.started", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyAccountBalanceCheckStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.account_balance.check.started", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyAccountBalanceCheckStatus(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid, boolean z3, int i2) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getBalanceIncreased(companion2), String.valueOf(z3)), u.a(EventProperty_ConsumerKt.getAttemptNumber(companion2), String.valueOf(i2)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.account_balance.check.status", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyCommitError(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.commit.error", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyCommitStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.commit.started", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyGetStatusError(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid, String buyStatus) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        m.g(buyStatus, "buyStatus");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getBuyStatus(companion2), buyStatus));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.get_status.error", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyGetStatusEvent(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid, String buyStatus, boolean z3, int i2) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        m.g(buyStatus, "buyStatus");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()), u.a(EventProperty_ConsumerKt.getBuyStatus(companion2), buyStatus), u.a(EventProperty_ConsumerKt.getRequiresCompletionStep(companion2), String.valueOf(z3)), u.a(EventProperty_ConsumerKt.getAttemptNumber(companion2), String.valueOf(i2)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.get_status.event", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationBuyGetStatusStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.get_status.started", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationCompleteBuyAfterSecure3DError(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.complete_after_secure3d.error", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationCompleteBuyAfterSecure3DStarted(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType, boolean z2, UUID uuid) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(companion2.getUUID(), uuid.toString()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.buy.complete_after_secure3d.started", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationConfirmTapped(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String str, boolean z2, boolean z3, UUID uuid) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(uuid, "uuid");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getMaxTransfer(companion2), String.valueOf(z2)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z3)), u.a(companion2.getUUID(), uuid.toString()));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.confirm.tapped", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationToTransferMethodsNavigated(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation_to_transfer_methods.navigated", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationTransferSelected(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, boolean z2, boolean z3, String str) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z2)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z3)));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.transfer.selected", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferConfirmationViewed(AnalyticsEvent.Companion companion, boolean z, CurrencyCode currencyCode, boolean z2, boolean z3, String str) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_ConsumerKt.getOnrampEnabled(companion2), String.valueOf(z)), u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z2)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z3)));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_confirmation.viewed", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferInitiated(AnalyticsEvent.Companion companion, boolean z) {
        Map e2;
        m.g(companion, "<this>");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_ConsumerKt.getOnrampEnabled(EventProperty.Companion), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_initiated", consumerConnect, false, e2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsAddPaymentSuccess(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.add_payment.success", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsAddPaymentTapped(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.add_payment.tapped", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsPaymentLimitViewed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.payment_limit.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsTransferSelected(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, boolean z2, String str) {
        Map m;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        m = m0.m(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getSendSelected(companion2), String.valueOf(z2)));
        if (str != null) {
            m.put(EventProperty_ConsumerKt.getPaymentMethodType(companion2), str);
        }
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.transfer_selected", consumerConnect, false, m, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsVerifyPaymentTapped(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z, String paymentMethodType) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        m.g(paymentMethodType, "paymentMethodType");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)), u.a(EventProperty_ConsumerKt.getPaymentMethodType(companion2), paymentMethodType));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.verify_payment.tapped", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsViewed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferMethodsWBLViewed(AnalyticsEvent.Companion companion, CurrencyCode currencyCode, boolean z) {
        Map l2;
        m.g(companion, "<this>");
        m.g(currencyCode, "currencyCode");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        EventProperty.Companion companion2 = EventProperty.Companion;
        l2 = m0.l(u.a(EventProperty_WalletsKt.getCurrencyCode(companion2), currencyCode.getRawValue()), u.a(EventProperty_ConsumerKt.getFiatSelected(companion2), String.valueOf(z)));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer_methods.wbl_viewed", consumerConnect, false, l2, 8, null);
    }

    public static final AnalyticsEvent consumerTransferTwoFaError(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.transfer_confirmation.send_2fa.error", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerTransferTwoFaSubmitted(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.transfer_confirmation.send_2fa.submitted", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerTransferTwoFaSuccess(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.transfer_confirmation.send_2fa.success", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent consumerTransferTwoFaViewed(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.transfer_confirmation.send_2fa.viewed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent oauthAllowAccessLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.oauth_allow_access.landed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent oauthSignInLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.oauth_sign_in.landed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent oauthTwoFaLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.oauth_two_fa.landed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent oauthVerifyEmailLanded(AnalyticsEvent.Companion companion) {
        m.g(companion, "<this>");
        return new AnalyticsEvent(EventType.PRODUCT, "consumer_connect.oauth_verify_email.landed", EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion), false, null, 24, null);
    }

    public static final AnalyticsEvent transferCoinSelected(AnalyticsEvent.Companion companion, ConsumerAccount account) {
        Map e2;
        m.g(companion, "<this>");
        m.g(account, "account");
        EventFeature consumerConnect = EventFeature_ConsumerKt.getConsumerConnect(EventFeature.Companion);
        EventType eventType = EventType.PRODUCT;
        e2 = l0.e(u.a(EventProperty_WalletsKt.getCurrencyCode(EventProperty.Companion), account.getCurrencyCode().getRawValue()));
        return new AnalyticsEvent(eventType, "consumer_connect.transfer.coin_selected", consumerConnect, false, e2, 8, null);
    }
}