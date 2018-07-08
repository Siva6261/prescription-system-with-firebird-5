package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class C0257q extends Filter {
    C0241r f1148a;

    C0257q(C0241r c0241r) {
        this.f1148a = c0241r;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1148a.mo441c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1148a.mo439a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1148a.mo438a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1148a.mo440a((Cursor) filterResults.values);
        }
    }
}
