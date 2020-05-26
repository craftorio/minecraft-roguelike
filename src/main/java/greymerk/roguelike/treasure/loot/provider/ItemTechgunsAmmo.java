package greymerk.roguelike.treasure.loot.provider;

import net.minecraft.item.ItemStack;
import techguns.TGItems;
import techguns.TGuns;;

import java.util.Random;

public class ItemTechgunsAmmo extends ItemBase {

  public ItemTechgunsAmmo(int weight, int level) {
    super(weight, level);
  }

  @Override
  public ItemStack getLootItem(Random rand, int level) {

    switch (rand.nextInt(10)) {
      case 0:
        return TGItems.newStack(TGItems.PISTOL_MAGAZINE, rand.nextInt(8) + 1);
      case 1:
        return TGItems.newStack(TGItems.FUEL_TANK, rand.nextInt(8) + 1);
      case 2:
        return TGItems.newStack(TGItems.ADVANCED_MAGAZINE, rand.nextInt(8) + 1);
      case 3:
        return TGItems.newStack(TGItems.SMG_MAGAZINE, rand.nextInt(8) + 1);
      case 4:
        return TGItems.newStack(TGItems.AS50_MAGAZINE, rand.nextInt(8) + 1);
      case 5:
        return TGItems.newStack(TGItems.ASSAULTRIFLE_MAGAZINE, rand.nextInt(8) + 1);
      case 6:
        return TGItems.newStack(TGItems.PISTOL_MAGAZINE_INCENDIARY, rand.nextInt(8) + 1);
      case 7:
        return TGItems.newStack(TGItems.PISTOL_MAGAZINE, rand.nextInt(4) + 1);
      case 8:
        return TGItems.newStack(TGItems.ROCKET, rand.nextInt(4) + 1);
      case 9:
        return TGItems.newStack(TGItems.MINIGUN_DRUM, rand.nextInt(4) + 1);
      default:
        return new ItemStack(TGuns.pistol, 1);
    }
  }
}
