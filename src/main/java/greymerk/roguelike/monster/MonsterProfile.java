package greymerk.roguelike.monster;

import greymerk.roguelike.monster.profiles.*;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

import java.util.Random;

public enum MonsterProfile {

  TALLMOB,
  ZOMBIE,
  ZOMBIESOLDIER,
  SUPERMUTANT,
  ALIENBUG,
  SKELETONSOLDIER,
  CYBERDEMON,
  PIGMAN,
  SKELETON,
  VILLAGER,
  HUSK,
  BABY,
  ASHLEA,
  RLEAHY,
  ARCHER,
  WITHER,
  POISONARCHER,
  MAGICARCHER,
  SWORDSMAN,
  EVOKER,
  VINDICATOR,
  WITCH,
  JOHNNY;

  public static IMonsterProfile get(MonsterProfile profile) {
    switch (profile) {
      case TALLMOB:
        return new ProfileTallMob();
      case ZOMBIE:
        return new ProfileZombie();
      case ZOMBIESOLDIER:
        return new ProfileZombieSoldier();
      case SUPERMUTANT:
        return new ProfileSupermutant();
      case ALIENBUG:
        return new ProfileAlienbug();
      case SKELETONSOLDIER:
        return new ProfileSkeletonsoldier();
      case CYBERDEMON:
        return new ProfileCyberdemon();
      case PIGMAN:
        return new ProfilePigman();
      case SKELETON:
        return new ProfileSkeleton();
      case VILLAGER:
        return new ProfileVillager();
      case HUSK:
        return new ProfileHusk();
      case BABY:
        return new ProfileBaby();
      case ASHLEA:
        return new ProfileAshlea();
      case RLEAHY:
        return new ProfileRleahy();
      case ARCHER:
        return new ProfileArcher();
      case WITHER:
        return new ProfileWither();
      case POISONARCHER:
        return new ProfilePoisonArcher();
      case MAGICARCHER:
        return new ProfileMagicArcher();
      case SWORDSMAN:
        return new ProfileSwordsman();
      case EVOKER:
        return new ProfileEvoker();
      case VINDICATOR:
        return new ProfileVindicator();
      case WITCH:
        return new ProfileWitch();
      case JOHNNY:
        return new ProfileJohnny();
      default:
        return new ProfileTallMob();
    }
  }

  public static void equip(World world, Random rand, int level, IEntity mob) {

    IMonsterProfile profile = null;

    if (mob.instance(EntityZombie.class)) {
      profile = get(ZOMBIE);
    }

    if (mob.instance(EntitySkeleton.class)) {
      profile = get(SKELETONSOLDIER);
    }

    if (profile == null) {
      return;
    }

    profile.addEquipment(world, rand, level, mob);
  }


}
