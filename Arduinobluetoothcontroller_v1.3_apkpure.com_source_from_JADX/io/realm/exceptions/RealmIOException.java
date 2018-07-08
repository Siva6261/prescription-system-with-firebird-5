package io.realm.exceptions;

import io.realm.internal.Keep;

@Keep
public class RealmIOException extends RuntimeException {
    public RealmIOException(String str) {
        super(str);
    }

    public RealmIOException(String str, Throwable th) {
        super(str, th);
    }

    public RealmIOException(Throwable th) {
        super(th);
    }
}
