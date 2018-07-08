package io.realm;

enum C0487r {
    TYPED_REALM,
    DYNAMIC_REALM;

    static C0487r m5816a(Class cls) {
        if (cls == C0483m.class) {
            return TYPED_REALM;
        }
        if (cls == C0435h.class) {
            return DYNAMIC_REALM;
        }
        throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
    }
}
