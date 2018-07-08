package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.p008c.C0066a;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ay {
    private final ImageView f1967a;
    private final aq f1968b;

    public ay(ImageView imageView, aq aqVar) {
        this.f1967a = imageView;
        this.f1968b = aqVar;
    }

    public void m4110a(int i) {
        if (i != 0) {
            Drawable a = this.f1968b != null ? this.f1968b.m4100a(this.f1967a.getContext(), i) : C0066a.m958a(this.f1967a.getContext(), i);
            if (a != null) {
                cj.m4347a(a);
            }
            this.f1967a.setImageDrawable(a);
            return;
        }
        this.f1967a.setImageDrawable(null);
    }

    public void m4111a(AttributeSet attributeSet, int i) {
        gf a = gf.m4787a(this.f1967a.getContext(), attributeSet, C0308l.AppCompatImageView, i, 0);
        try {
            Drawable b = a.m4794b(C0308l.AppCompatImageView_android_src);
            if (b != null) {
                this.f1967a.setImageDrawable(b);
            }
            int g = a.m4803g(C0308l.AppCompatImageView_srcCompat, -1);
            if (g != -1) {
                b = this.f1968b.m4100a(this.f1967a.getContext(), g);
                if (b != null) {
                    this.f1967a.setImageDrawable(b);
                }
            }
            b = this.f1967a.getDrawable();
            if (b != null) {
                cj.m4347a(b);
            }
            a.m4791a();
        } catch (Throwable th) {
            a.m4791a();
        }
    }
}
