package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/* compiled from: Node.java */
/* loaded from: classes2.dex */
public abstract class m {
    private List<m> mChildren;
    private final Map<String, Long> mLastLoopID;
    private final Map<String, Object> mMemoizedValue;
    protected final int mNodeID;
    protected final com.swmansion.reanimated.b mNodesManager;
    protected final com.swmansion.reanimated.d mUpdateContext;
    public static final Double ZERO = Double.valueOf(0.0d);
    public static final Double ONE = Double.valueOf(1.0d);

    public m(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        HashMap hashMap = new HashMap();
        this.mLastLoopID = hashMap;
        this.mMemoizedValue = new HashMap();
        hashMap.put("", -1L);
        this.mNodeID = i2;
        this.mNodesManager = bVar;
        this.mUpdateContext = bVar.q;
    }

    private static void findAndUpdateNodes(m mVar, Set<m> set, Stack<j> stack) {
        if (set.contains(mVar)) {
            return;
        }
        set.add(mVar);
        List<m> list = mVar.mChildren;
        if (list != null) {
            for (m mVar2 : list) {
                findAndUpdateNodes(mVar2, set, stack);
            }
        }
        if (mVar instanceof j) {
            stack.push((j) mVar);
        }
    }

    public static void runUpdates(com.swmansion.reanimated.d dVar) {
        UiThreadUtil.assertOnUiThread();
        ArrayList<m> arrayList = dVar.f10959c;
        HashSet hashSet = new HashSet();
        Stack stack = new Stack();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            findAndUpdateNodes(arrayList.get(i2), hashSet, stack);
            if (i2 == arrayList.size() - 1) {
                while (!stack.isEmpty()) {
                    ((j) stack.pop()).a();
                }
            }
        }
        arrayList.clear();
        dVar.a++;
    }

    public void addChild(m mVar) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        this.mChildren.add(mVar);
        mVar.dangerouslyRescheduleEvaluate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dangerouslyRescheduleEvaluate() {
        this.mLastLoopID.put(this.mUpdateContext.f10958b, -1L);
        markUpdated();
    }

    public final Double doubleValue() {
        Object value = value();
        if (value == null) {
            return ZERO;
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return Double.valueOf(((Number) value).doubleValue());
        }
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue() ? ONE : ZERO;
        }
        throw new IllegalStateException("Value of node " + this + " cannot be cast to a number");
    }

    protected abstract Object evaluate();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void forceUpdateMemoizedValue(Object obj) {
        this.mMemoizedValue.put(this.mUpdateContext.f10958b, obj);
        markUpdated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markUpdated() {
        UiThreadUtil.assertOnUiThread();
        this.mUpdateContext.f10959c.add(this);
        this.mNodesManager.w();
    }

    public void removeChild(m mVar) {
        List<m> list = this.mChildren;
        if (list != null) {
            list.remove(mVar);
        }
    }

    public final Object value() {
        if (this.mLastLoopID.containsKey(this.mUpdateContext.f10958b)) {
            long longValue = this.mLastLoopID.get(this.mUpdateContext.f10958b).longValue();
            com.swmansion.reanimated.d dVar = this.mUpdateContext;
            if (longValue >= dVar.a) {
                return this.mMemoizedValue.get(dVar.f10958b);
            }
        }
        Map<String, Long> map = this.mLastLoopID;
        com.swmansion.reanimated.d dVar2 = this.mUpdateContext;
        map.put(dVar2.f10958b, Long.valueOf(dVar2.a));
        Object evaluate = evaluate();
        this.mMemoizedValue.put(this.mUpdateContext.f10958b, evaluate);
        return evaluate;
    }
}