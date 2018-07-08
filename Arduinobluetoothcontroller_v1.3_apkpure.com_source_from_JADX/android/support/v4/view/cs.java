package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class cs implements OnApplyWindowInsetsListener {
    final /* synthetic */ bm f992a;

    cs(bm bmVar) {
        this.f992a = bmVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((et) this.f992a.mo69a(view, new et(windowInsets))).m2465g();
    }
}
