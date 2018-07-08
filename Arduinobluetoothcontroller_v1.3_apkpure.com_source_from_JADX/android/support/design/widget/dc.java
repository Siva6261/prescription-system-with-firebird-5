package android.support.design.widget;

import android.os.Build.VERSION;

final class dc implements cl {
    dc() {
    }

    public ci mo136a() {
        return new ci(VERSION.SDK_INT >= 12 ? new cr() : new cp());
    }
}
