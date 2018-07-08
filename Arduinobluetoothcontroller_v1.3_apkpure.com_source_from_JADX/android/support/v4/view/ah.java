package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

class ah implements Factory {
    final al f964a;

    ah(al alVar) {
        this.f964a = alVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f964a.mo180a(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.f964a + "}";
    }
}
