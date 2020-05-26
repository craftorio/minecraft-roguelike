package greymerk.roguelike.monster.profiles;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MobType;
import greymerk.roguelike.monster.MonsterProfile;
import greymerk.roguelike.treasure.loot.Enchant;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.World;

import java.util.Random;

public class ProfileZombieSoldier implements IMonsterProfile {

  @Override
  public void addEquipment(World world, Random rand, int level, IEntity mob) {
    //mob.setMobClass(MobType.ZOMBIESOLDIER, true);
  }

}
