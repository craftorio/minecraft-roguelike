package greymerk.roguelike.treasure.loot.provider;

import net.minecraft.item.ItemStack;
import techguns.TGArmors;
import techguns.TGItems;

import java.util.Random;

public class ItemTechgunsArmor extends ItemBase {

  public ItemTechgunsArmor(int weight, int level) {
    super(weight, level);
  }

  @Override
  public ItemStack getLootItem(Random rand, int level) {

    switch (rand.nextInt(10)) {
      case 0:
        return level > 3 ? new ItemStack(TGArmors.t4_power_Boots): new ItemStack(TGArmors.t2_riot_Boots);
      case 1:
        return level > 3 ? new ItemStack(TGArmors.t4_power_Leggings): new ItemStack(TGArmors.t2_riot_Leggings);
      case 2:
        return level > 3 ? new ItemStack(TGArmors.t4_power_Chestplate): new ItemStack(TGArmors.t2_riot_Chestplate);
      case 3:
        return level > 3 ? new ItemStack(TGArmors.t4_power_Helmet): new ItemStack(TGArmors.t2_riot_Helmet);
      case 4:
        return level > 3 ? new ItemStack(TGArmors.t4_praetor_Boots): new ItemStack(TGArmors.t2_combat_Boots);
      case 5:
        return level > 3 ? new ItemStack(TGArmors.t4_praetor_Leggings): new ItemStack(TGArmors.t2_combat_Leggings);
      case 6:
        return level > 3 ? new ItemStack(TGArmors.t4_praetor_Chestplate): new ItemStack(TGArmors.t2_combat_Chestplate);
      case 7:
        return level > 3 ? new ItemStack(TGArmors.t4_praetor_Helmet): new ItemStack(TGArmors.t2_combat_Helmet);
      case 8:
        return new ItemStack(TGArmors.advanced_shield);
      case 9:
        return new ItemStack(TGArmors.ballistic_shield);
      default:
        return (rand.nextInt(1) > 0 ? new ItemStack(TGItems.SHOTGUN_ROUNDS.getItem(), rand.nextInt(16)+1) : new ItemStack(TGItems.GRENADE_40MM.getItem(), rand.nextInt(6)+1));
    }
  }
}
