package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class C0350c extends Drawable {
    final ActionBarContainer f2087a;

    public C0350c(ActionBarContainer actionBarContainer) {
        this.f2087a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2087a.f1669d) {
            if (this.f2087a.f1666a != null) {
                this.f2087a.f1666a.draw(canvas);
            }
            if (this.f2087a.f1667b != null && this.f2087a.f1670e) {
                this.f2087a.f1667b.draw(canvas);
            }
        } else if (this.f2087a.f1668c != null) {
            this.f2087a.f1668c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
