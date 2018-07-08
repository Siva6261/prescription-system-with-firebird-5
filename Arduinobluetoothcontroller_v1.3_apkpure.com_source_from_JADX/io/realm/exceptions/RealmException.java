package io.realm.exceptions;

import io.realm.internal.Keep;

@Keep
public class RealmException extends RuntimeException {
    public RealmException(String str) {
        super(str);
    }

    public RealmException(String str, Throwable th) {
        super(str, th);
    }
}
