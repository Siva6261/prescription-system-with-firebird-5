package io.realm;

import com.giumig.apps.bluetoothcontroller.p025d.C0393a;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.C0427m;
import io.realm.internal.C0428b;
import io.realm.internal.C0469g;
import io.realm.internal.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C0433e extends C0393a implements C0392g, C0427m {
    private static final List f2849d;
    private final C0434f f2850c;

    static {
        List arrayList = new ArrayList();
        arrayList.add("currentlyUsed");
        arrayList.add("profileId");
        arrayList.add("profileName");
        arrayList.add("leftArrow");
        arrayList.add("rightArrow");
        arrayList.add("upArrow");
        arrayList.add("downArrow");
        arrayList.add("selectButton");
        arrayList.add("startButton");
        arrayList.add("leftButton");
        arrayList.add("rightButton");
        arrayList.add("upButton");
        arrayList.add("downButton");
        f2849d = Collections.unmodifiableList(arrayList);
    }

    C0433e(C0428b c0428b) {
        this.f2850c = (C0434f) c0428b;
    }

    static C0393a m5444a(C0483m c0483m, C0393a c0393a, C0393a c0393a2, Map map) {
        c0393a.mo840b(c0393a2.mo841l());
        c0393a.mo845n(c0393a2.mo844n());
        c0393a.mo847o(c0393a2.mo846o());
        c0393a.mo849p(c0393a2.mo848p());
        c0393a.mo851q(c0393a2.mo850q());
        c0393a.mo853r(c0393a2.mo852r());
        c0393a.mo855s(c0393a2.mo854s());
        c0393a.mo857t(c0393a2.mo856t());
        c0393a.mo859u(c0393a2.mo858u());
        c0393a.mo861v(c0393a2.mo860v());
        c0393a.mo863w(c0393a2.mo862w());
        c0393a.mo865x(c0393a2.mo864x());
        return c0393a;
    }

    public static C0393a m5445a(C0483m c0483m, C0393a c0393a, boolean z, Map map) {
        if (c0393a.f2729b != null && c0393a.f2729b.f2786c != c0483m.c) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if (c0393a.f2729b != null && c0393a.f2729b.mo889f().equals(c0483m.mo889f())) {
            return c0393a;
        } else {
            boolean z2;
            C0393a c0393a2 = null;
            if (z) {
                Table d = c0483m.m5804d(C0393a.class);
                long e = d.m5549e();
                if (c0393a.mo842m() == null) {
                    throw new IllegalArgumentException("Primary key value must not be null.");
                }
                e = d.m5532a(e, c0393a.mo842m());
                if (e != -1) {
                    c0393a2 = new C0433e(c0483m.g.m5418a(C0393a.class));
                    c0393a2.f2729b = c0483m;
                    c0393a2.f2728a = d.m5555h(e);
                    map.put(c0393a, (C0427m) c0393a2);
                    z2 = z;
                } else {
                    z2 = false;
                }
            } else {
                z2 = z;
            }
            return z2 ? C0433e.m5444a(c0483m, c0393a2, c0393a, map) : C0433e.m5447b(c0483m, c0393a, z, map);
        }
    }

    public static Table m5446a(C0469g c0469g) {
        if (c0469g.m5492a("class_ControllerProfile")) {
            return c0469g.m5493b("class_ControllerProfile");
        }
        Table b = c0469g.m5493b("class_ControllerProfile");
        b.m5534a(RealmFieldType.BOOLEAN, "currentlyUsed", false);
        b.m5534a(RealmFieldType.STRING, "profileId", false);
        b.m5534a(RealmFieldType.STRING, "profileName", true);
        b.m5534a(RealmFieldType.STRING, "leftArrow", true);
        b.m5534a(RealmFieldType.STRING, "rightArrow", true);
        b.m5534a(RealmFieldType.STRING, "upArrow", true);
        b.m5534a(RealmFieldType.STRING, "downArrow", true);
        b.m5534a(RealmFieldType.STRING, "selectButton", true);
        b.m5534a(RealmFieldType.STRING, "startButton", true);
        b.m5534a(RealmFieldType.STRING, "leftButton", true);
        b.m5534a(RealmFieldType.STRING, "rightButton", true);
        b.m5534a(RealmFieldType.STRING, "upButton", true);
        b.m5534a(RealmFieldType.STRING, "downButton", true);
        b.m5560j(b.m5536a("profileId"));
        b.m5543b("profileId");
        return b;
    }

    public static C0393a m5447b(C0483m c0483m, C0393a c0393a, boolean z, Map map) {
        C0393a c0393a2 = (C0393a) c0483m.m5797a(C0393a.class, c0393a.mo842m());
        map.put(c0393a, (C0427m) c0393a2);
        c0393a2.mo840b(c0393a.mo841l());
        c0393a2.mo843m(c0393a.mo842m());
        c0393a2.mo845n(c0393a.mo844n());
        c0393a2.mo847o(c0393a.mo846o());
        c0393a2.mo849p(c0393a.mo848p());
        c0393a2.mo851q(c0393a.mo850q());
        c0393a2.mo853r(c0393a.mo852r());
        c0393a2.mo855s(c0393a.mo854s());
        c0393a2.mo857t(c0393a.mo856t());
        c0393a2.mo859u(c0393a.mo858u());
        c0393a2.mo861v(c0393a.mo860v());
        c0393a2.mo863w(c0393a.mo862w());
        c0393a2.mo865x(c0393a.mo864x());
        return c0393a2;
    }

    public static C0434f m5448b(C0469g c0469g) {
        if (c0469g.m5492a("class_ControllerProfile")) {
            Table b = c0469g.m5493b("class_ControllerProfile");
            if (b.m5545c() != 13) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field count does not match - expected 13 but was " + b.m5545c());
            }
            Map hashMap = new HashMap();
            for (long j = 0; j < 13; j++) {
                hashMap.put(b.m5546c(j), b.m5548d(j));
            }
            C0434f c0434f = new C0434f(c0469g.m5702f(), b);
            if (!hashMap.containsKey("currentlyUsed")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'currentlyUsed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("currentlyUsed") != RealmFieldType.BOOLEAN) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'boolean' for field 'currentlyUsed' in existing Realm file.");
            } else if (b.m5544b(c0434f.f2851a)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'currentlyUsed' does support null values in the existing Realm file. Use corresponding boxed type for field 'currentlyUsed' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            } else if (!hashMap.containsKey("profileId")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'profileId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("profileId") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'profileId' in existing Realm file.");
            } else if (b.m5544b(c0434f.f2852b)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'profileId' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'profileId' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            } else if (b.m5549e() != b.m5536a("profileId")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Primary key not defined for field 'profileId' in existing Realm file. Add @PrimaryKey.");
            } else if (!b.m5564l(b.m5536a("profileId"))) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Index not defined for field 'profileId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            } else if (!hashMap.containsKey("profileName")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'profileName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("profileName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'profileName' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2853c)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'profileName' is required. Either set @Required to field 'profileName' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("leftArrow")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'leftArrow' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("leftArrow") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'leftArrow' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2854d)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'leftArrow' is required. Either set @Required to field 'leftArrow' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("rightArrow")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'rightArrow' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("rightArrow") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'rightArrow' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2855e)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'rightArrow' is required. Either set @Required to field 'rightArrow' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("upArrow")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'upArrow' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("upArrow") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'upArrow' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2856f)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'upArrow' is required. Either set @Required to field 'upArrow' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("downArrow")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'downArrow' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("downArrow") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'downArrow' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2857g)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'downArrow' is required. Either set @Required to field 'downArrow' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("selectButton")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'selectButton' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("selectButton") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'selectButton' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2858h)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'selectButton' is required. Either set @Required to field 'selectButton' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("startButton")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'startButton' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("startButton") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'startButton' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2859i)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'startButton' is required. Either set @Required to field 'startButton' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("leftButton")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'leftButton' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("leftButton") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'leftButton' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2860j)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'leftButton' is required. Either set @Required to field 'leftButton' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("rightButton")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'rightButton' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("rightButton") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'rightButton' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2861k)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'rightButton' is required. Either set @Required to field 'rightButton' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("upButton")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'upButton' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("upButton") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'upButton' in existing Realm file.");
            } else if (!b.m5544b(c0434f.f2862l)) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'upButton' is required. Either set @Required to field 'upButton' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            } else if (!hashMap.containsKey("downButton")) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Missing field 'downButton' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            } else if (hashMap.get("downButton") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Invalid type 'String' for field 'downButton' in existing Realm file.");
            } else if (b.m5544b(c0434f.f2863m)) {
                return c0434f;
            } else {
                throw new RealmMigrationNeededException(c0469g.m5702f(), "Field 'downButton' is required. Either set @Required to field 'downButton' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
        }
        throw new RealmMigrationNeededException(c0469g.m5702f(), "The ControllerProfile class is missing from the schema for this Realm.");
    }

    public static String m5449y() {
        return "class_ControllerProfile";
    }

    public void mo840b(boolean z) {
        this.f2729b.m5368e();
        this.f2728a.mo905a(this.f2850c.f2851a, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0433e c0433e = (C0433e) obj;
        String f = this.f2729b.mo889f();
        String f2 = c0433e.f2729b.mo889f();
        if (f == null ? f2 != null : !f.equals(f2)) {
            return false;
        }
        f = this.f2728a.mo907b().m5561k();
        f2 = c0433e.f2728a.mo907b().m5561k();
        return (f == null ? f2 != null : !f.equals(f2)) ? false : this.f2728a.mo908c() == c0433e.f2728a.mo908c();
    }

    public int hashCode() {
        int i = 0;
        String f = this.f2729b.mo889f();
        String k = this.f2728a.mo907b().m5561k();
        long c = this.f2728a.mo908c();
        int hashCode = ((f != null ? f.hashCode() : 0) + 527) * 31;
        if (k != null) {
            i = k.hashCode();
        }
        return ((i + hashCode) * 31) + ((int) ((c >>> 32) ^ c));
    }

    public boolean mo841l() {
        this.f2729b.m5368e();
        return this.f2728a.mo911d(this.f2850c.f2851a);
    }

    public String mo842m() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2852b);
    }

    public void mo843m(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field profileId to null.");
        }
        this.f2728a.mo904a(this.f2850c.f2852b, str);
    }

    public String mo844n() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2853c);
    }

    public void mo845n(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2853c);
        } else {
            this.f2728a.mo904a(this.f2850c.f2853c, str);
        }
    }

    public String mo846o() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2854d);
    }

    public void mo847o(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2854d);
        } else {
            this.f2728a.mo904a(this.f2850c.f2854d, str);
        }
    }

    public String mo848p() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2855e);
    }

    public void mo849p(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2855e);
        } else {
            this.f2728a.mo904a(this.f2850c.f2855e, str);
        }
    }

    public String mo850q() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2856f);
    }

    public void mo851q(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2856f);
        } else {
            this.f2728a.mo904a(this.f2850c.f2856f, str);
        }
    }

    public String mo852r() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2857g);
    }

    public void mo853r(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2857g);
        } else {
            this.f2728a.mo904a(this.f2850c.f2857g, str);
        }
    }

    public String mo854s() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2858h);
    }

    public void mo855s(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2858h);
        } else {
            this.f2728a.mo904a(this.f2850c.f2858h, str);
        }
    }

    public String mo856t() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2859i);
    }

    public void mo857t(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2859i);
        } else {
            this.f2728a.mo904a(this.f2850c.f2859i, str);
        }
    }

    public String toString() {
        if (!m5232z()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ControllerProfile = [");
        stringBuilder.append("{currentlyUsed:");
        stringBuilder.append(mo841l());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profileId:");
        stringBuilder.append(mo842m());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profileName:");
        stringBuilder.append(mo844n() != null ? mo844n() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{leftArrow:");
        stringBuilder.append(mo846o() != null ? mo846o() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rightArrow:");
        stringBuilder.append(mo848p() != null ? mo848p() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{upArrow:");
        stringBuilder.append(mo850q() != null ? mo850q() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{downArrow:");
        stringBuilder.append(mo852r() != null ? mo852r() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selectButton:");
        stringBuilder.append(mo854s() != null ? mo854s() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startButton:");
        stringBuilder.append(mo856t() != null ? mo856t() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{leftButton:");
        stringBuilder.append(mo858u() != null ? mo858u() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rightButton:");
        stringBuilder.append(mo860v() != null ? mo860v() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{upButton:");
        stringBuilder.append(mo862w() != null ? mo862w() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{downButton:");
        stringBuilder.append(mo864x() != null ? mo864x() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String mo858u() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2860j);
    }

    public void mo859u(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2860j);
        } else {
            this.f2728a.mo904a(this.f2850c.f2860j, str);
        }
    }

    public String mo860v() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2861k);
    }

    public void mo861v(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2861k);
        } else {
            this.f2728a.mo904a(this.f2850c.f2861k, str);
        }
    }

    public String mo862w() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2862l);
    }

    public void mo863w(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2862l);
        } else {
            this.f2728a.mo904a(this.f2850c.f2862l, str);
        }
    }

    public String mo864x() {
        this.f2729b.m5368e();
        return this.f2728a.mo915h(this.f2850c.f2863m);
    }

    public void mo865x(String str) {
        this.f2729b.m5368e();
        if (str == null) {
            this.f2728a.mo920m(this.f2850c.f2863m);
        } else {
            this.f2728a.mo904a(this.f2850c.f2863m, str);
        }
    }
}
