package greymerk.roguelike.treasure.loot.provider;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import techguns.TGuns;
import techguns.TGItems;

import java.util.Random;

public class ItemTechguns extends ItemBase {

  public ItemTechguns(int weight, int level) {
    super(weight, level);
  }

  @Override
  public ItemStack getLootItem(Random rand, int level) {
    switch (rand.nextInt(12)) {
      case 0:
        return new ItemStack(TGuns.m4, 1);
      case 1:
        return new ItemStack(TGuns.ak47, 1);
      case 2:
        return new ItemStack(TGuns.vector, 1);
      case 3:
        return new ItemStack(TGuns.flamethrower, 1);
      case 4:
        return new ItemStack(TGuns.goldenrevolver, 1);
      case 5:
        return new ItemStack(TGuns.aug, 1);
      case 6:
        return TGItems.newStack(TGItems.GRENADE_40MM, 1);
      case 7:
      case 8:
        return new ItemStack(TGuns.chainsaw, 1);
      case 9:
      case 10:
      case 11:
        return new ItemStack(TGuns.combatshotgun, 1);
      default:
        return new ItemStack(TGuns.pistol, 1);
    }
  }
}
