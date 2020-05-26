package greymerk.roguelike.monster.profiles;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import net.minecraft.world.World;

import java.util.Random;

public class ProfileCyberdemon implements IMonsterProfile {

  @Override
  public void addEquipment(World world, Random rand, int level, IEntity mob) {
    //mob.setMobClass(MobType.ZOMBIESOLDIER, true);
    //mob.setSlot(EntityEquipmentSlot.MAINHAND, ItemWeapon.getSword(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level)));
    //MonsterProfile.get(MonsterProfile.TALLMOB).addEquipment(world, rand, level, mob);
  }

}
