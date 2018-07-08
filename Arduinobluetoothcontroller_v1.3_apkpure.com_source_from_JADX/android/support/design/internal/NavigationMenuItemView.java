package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0022c;
import android.support.design.C0024e;
import android.support.design.C0025f;
import android.support.design.C0026g;
import android.support.v4.p010d.p011a.C0106a;
import android.support.v4.widget.ba;
import android.support.v7.view.menu.C0337m;
import android.support.v7.view.menu.aa;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0029a implements aa {
    private static final int[] f111c = new int[]{16842912};
    private final int f112d;
    private final CheckedTextView f113e;
    private FrameLayout f114f;
    private C0337m f115g;
    private ColorStateList f116h;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0026g.design_navigation_menu_item, this, true);
        this.f112d = context.getResources().getDimensionPixelSize(C0024e.design_navigation_icon_size);
        this.f113e = (CheckedTextView) findViewById(C0025f.design_menu_item_text);
        this.f113e.setDuplicateParentStateEnabled(true);
    }

    private StateListDrawable m97b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0022c.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f111c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (this.f114f == null) {
            this.f114f = (FrameLayout) ((ViewStub) findViewById(C0025f.design_menu_item_action_area_stub)).inflate();
        }
        this.f114f.removeAllViews();
        if (view != null) {
            this.f114f.addView(view);
        }
    }

    public void mo24a(C0337m c0337m, int i) {
        this.f115g = c0337m;
        setVisibility(c0337m.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m97b());
        }
        setCheckable(c0337m.isCheckable());
        setChecked(c0337m.isChecked());
        setEnabled(c0337m.isEnabled());
        setTitle(c0337m.getTitle());
        setIcon(c0337m.getIcon());
        setActionView(c0337m.getActionView());
    }

    public boolean mo25a() {
        return false;
    }

    public C0337m getItemData() {
        return this.f115g;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f115g != null && this.f115g.isCheckable() && this.f115g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f111c);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f113e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C0106a.m1346f(drawable).mutate();
            drawable.setBounds(0, 0, this.f112d, this.f112d);
            C0106a.m1336a(drawable, this.f116h);
        }
        ba.m2710a(this.f113e, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f116h = colorStateList;
        if (this.f115g != null) {
            setIcon(this.f115g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f113e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f113e.setText(charSequence);
    }
}
