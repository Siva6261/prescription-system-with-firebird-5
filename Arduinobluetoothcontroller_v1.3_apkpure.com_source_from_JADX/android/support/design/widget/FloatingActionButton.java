package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0024e;
import android.support.design.C0027h;
import android.support.design.C0028i;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.bv;
import android.support.v7.widget.aq;
import android.support.v7.widget.ay;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@ac(a = Behavior.class)
public class FloatingActionButton extends dh {
    private ColorStateList f268a;
    private Mode f269b;
    private int f270c;
    private int f271d;
    private int f272e;
    private int f273f;
    private boolean f274g;
    private final Rect f275h;
    private ay f276i;
    private ay f277j;

    public class Behavior extends ab {
        private static final boolean f263a = (VERSION.SDK_INT >= 11);
        private ci f264b;
        private float f265c;
        private Rect f266d;

        private float m426a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float f = 0.0f;
            List d = coordinatorLayout.m424d((View) floatingActionButton);
            int size = d.size();
            int i = 0;
            while (i < size) {
                View view = (View) d.get(i);
                float min = ((view instanceof SnackbarLayout) && coordinatorLayout.m415a((View) floatingActionButton, view)) ? Math.min(f, bv.m2037n(view) - ((float) view.getHeight())) : f;
                i++;
                f = min;
            }
            return f;
        }

        private boolean m427a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((ae) floatingActionButton.getLayoutParams()).m502a() != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f266d == null) {
                this.f266d = new Rect();
            }
            Rect rect = this.f266d;
            ct.m756b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m447b(null, false);
            } else {
                floatingActionButton.m444a(null, false);
            }
            return true;
        }

        private void m428b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect a = floatingActionButton.f275h;
            if (a != null && a.centerX() > 0 && a.centerY() > 0) {
                ae aeVar = (ae) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - aeVar.rightMargin ? a.right : floatingActionButton.getLeft() <= aeVar.leftMargin ? -a.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - aeVar.bottomMargin) {
                    i = a.bottom;
                } else if (floatingActionButton.getTop() <= aeVar.topMargin) {
                    i = -a.top;
                }
                floatingActionButton.offsetTopAndBottom(i);
                floatingActionButton.offsetLeftAndRight(i2);
            }
        }

        private void m429c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            float a = m426a(coordinatorLayout, floatingActionButton);
            if (this.f265c != a) {
                float n = bv.m2037n(floatingActionButton);
                if (this.f264b != null && this.f264b.m712b()) {
                    this.f264b.m715e();
                }
                if (!floatingActionButton.isShown() || Math.abs(n - a) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                    bv.m2015b((View) floatingActionButton, a);
                } else {
                    if (this.f264b == null) {
                        this.f264b = db.m769a();
                        this.f264b.m711a(C0031a.f303b);
                        this.f264b.m710a(new am(this, floatingActionButton));
                    }
                    this.f264b.m707a(n, a);
                    this.f264b.m706a();
                }
                this.f265c = a;
            }
        }

        public boolean m430a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List d = coordinatorLayout.m424d((View) floatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) d.get(i2);
                if ((view instanceof AppBarLayout) && m427a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m408a((View) floatingActionButton, i);
            m428b(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean m431a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f263a && (view instanceof SnackbarLayout);
        }

        public boolean m433b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m429c(coordinatorLayout, floatingActionButton, view);
            } else if (view instanceof AppBarLayout) {
                m427a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean mo58b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m431a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public /* synthetic */ boolean mo59c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m433b(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f275h = new Rect();
        ch.m705a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.FloatingActionButton, i, C0027h.Widget_Design_FloatingActionButton);
        this.f268a = obtainStyledAttributes.getColorStateList(C0028i.FloatingActionButton_backgroundTint);
        this.f269b = m438a(obtainStyledAttributes.getInt(C0028i.FloatingActionButton_backgroundTintMode, -1), null);
        this.f271d = obtainStyledAttributes.getColor(C0028i.FloatingActionButton_rippleColor, 0);
        this.f272e = obtainStyledAttributes.getInt(C0028i.FloatingActionButton_fabSize, 0);
        this.f270c = obtainStyledAttributes.getDimensionPixelSize(C0028i.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(C0028i.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0028i.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f274g = obtainStyledAttributes.getBoolean(C0028i.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.f276i = new ay(this, aq.m4079a());
        this.f276i.m4111a(attributeSet, i);
        this.f273f = (getSizeDimension() - ((int) getResources().getDimension(C0024e.design_fab_image_size))) / 2;
        getImpl().mo84a(this.f268a, this.f269b, this.f271d, this.f270c);
        getImpl().m560c(dimension);
        getImpl().m561d(dimension2);
        getImpl().m565g();
    }

    private static int m437a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    static Mode m438a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }

    private ay m440a() {
        int i = VERSION.SDK_INT;
        return i >= 21 ? new bb(this, new ao()) : i >= 14 ? new av(this, new ao()) : new ap(this, new ao());
    }

    private ba m441a(an anVar) {
        return anVar == null ? null : new al(this, anVar);
    }

    private void m444a(an anVar, boolean z) {
        getImpl().mo91b(m441a(anVar), z);
    }

    private void m447b(an anVar, boolean z) {
        getImpl().mo87a(m441a(anVar), z);
    }

    private ay getImpl() {
        if (this.f277j == null) {
            this.f277j = m440a();
        }
        return this.f277j;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo88a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f268a;
    }

    public Mode getBackgroundTintMode() {
        return this.f269b;
    }

    public float getCompatElevation() {
        return getImpl().mo80a();
    }

    public Drawable getContentBackground() {
        return getImpl().m564f();
    }

    final int getSizeDimension() {
        switch (this.f272e) {
            case 1:
                return getResources().getDimensionPixelSize(C0024e.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(C0024e.design_fab_size_normal);
        }
    }

    public boolean getUseCompatPadding() {
        return this.f274g;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo89b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m566h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m567i();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        sizeDimension = Math.min(m437a(sizeDimension, i), m437a(sizeDimension, i2));
        setMeasuredDimension((this.f275h.left + sizeDimension) + this.f275h.right, (sizeDimension + this.f275h.top) + this.f275h.bottom);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f268a != colorStateList) {
            this.f268a = colorStateList;
            getImpl().mo83a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f269b != mode) {
            this.f269b = mode;
            getImpl().mo85a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().m560c(f);
    }

    public void setImageResource(int i) {
        this.f276i.m4110a(i);
    }

    public void setRippleColor(int i) {
        if (this.f271d != i) {
            this.f271d = i;
            getImpl().mo82a(i);
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f274g != z) {
            this.f274g = z;
            getImpl().mo92c();
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
