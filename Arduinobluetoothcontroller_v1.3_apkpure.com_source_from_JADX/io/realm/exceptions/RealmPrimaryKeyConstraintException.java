package io.realm.exceptions;

import io.realm.internal.Keep;

@Keep
public class RealmPrimaryKeyConstraintException extends RuntimeException {
    public RealmPrimaryKeyConstraintException(String str) {
        super(str);
    }
}
