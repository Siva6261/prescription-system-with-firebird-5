package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

class bj implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter f2007a;
    private ListAdapter f2008b;

    public bj(SpinnerAdapter spinnerAdapter, Theme theme) {
        this.f2007a = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f2008b = (ListAdapter) spinnerAdapter;
        }
        if (theme == null) {
            return;
        }
        if (bh.f1993a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        } else if (spinnerAdapter instanceof gb) {
            gb gbVar = (gb) spinnerAdapter;
            if (gbVar.m4780a() == null) {
                gbVar.m4781a(theme);
            }
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f2008b;
        return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
    }

    public int getCount() {
        return this.f2007a == null ? 0 : this.f2007a.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.f2007a == null ? null : this.f2007a.getDropDownView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        return this.f2007a == null ? null : this.f2007a.getItem(i);
    }

    public long getItemId(int i) {
        return this.f2007a == null ? -1 : this.f2007a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDropDownView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return this.f2007a != null && this.f2007a.hasStableIds();
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isEnabled(int i) {
        ListAdapter listAdapter = this.f2008b;
        return listAdapter != null ? listAdapter.isEnabled(i) : true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f2007a != null) {
            this.f2007a.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.f2007a != null) {
            this.f2007a.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
