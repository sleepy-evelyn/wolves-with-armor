package draylar.wolveswitharmor.item;

import net.minecraft.item.DyeableItem;

public class DyeableWolfArmorItem extends WolfArmorItem implements DyeableItem {

    public DyeableWolfArmorItem(String type, int bonus) {
        super(type, bonus);
    }

    public DyeableWolfArmorItem(String type, int bonus, boolean fireproof) {
        super(type, bonus, fireproof);
    }
}

