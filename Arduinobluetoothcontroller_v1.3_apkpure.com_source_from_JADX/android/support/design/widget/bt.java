package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.MotionEvent;
import android.view.View;

final class bt extends SwipeDismissBehavior {
    final /* synthetic */ Snackbar f402a;

    bt(Snackbar snackbar) {
        this.f402a = snackbar;
    }

    public boolean m648a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.m414a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    bx.m653a().m665c(this.f402a.f291h);
                    break;
                case 1:
                case 3:
                    bx.m653a().m666d(this.f402a.f291h);
                    break;
            }
        }
        return super.mo36a(coordinatorLayout, (View) snackbarLayout, motionEvent);
    }

    public boolean mo115a(View view) {
        return view instanceof SnackbarLayout;
    }
}
