package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class di implements OnTouchListener {
    final /* synthetic */ cx f2185a;

    private di(cx cxVar) {
        this.f2185a = cxVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f2185a.f2019e != null && this.f2185a.f2019e.isShowing() && x >= 0 && x < this.f2185a.f2019e.getWidth() && y >= 0 && y < this.f2185a.f2019e.getHeight()) {
            this.f2185a.f2013C.postDelayed(this.f2185a.f2038x, 250);
        } else if (action == 1) {
            this.f2185a.f2013C.removeCallbacks(this.f2185a.f2038x);
        }
        return false;
    }
}
