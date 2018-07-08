package android.support.v4.p006b;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class bb extends EpicenterCallback {
    final /* synthetic */ Rect f685a;

    bb(Rect rect) {
        this.f685a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f685a;
    }
}
