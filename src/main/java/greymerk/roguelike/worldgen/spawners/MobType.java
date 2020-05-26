package greymerk.roguelike.worldgen.spawners;

import com.google.common.collect.Lists;

import net.minecraft.nbt.NBTTagCompound;

import java.util.Arrays;

public enum MobType {

  BAT("bat"),
  BLAZE("blaze"),
  CAVESPIDER("cave_spider"),
  CREEPER("creeper"),
  ENDERMAN("enderman"),
  GHAST("ghast"),
  LAVASLIME("magma_cube"),
  PIGZOMBIE("zombie_pigman"),
  PRIMEDTNT("tnt"),
  SILVERFISH("silverfish"),
  SKELETON("skeleton"),
  SLIME("slime"),
  SPIDER("spider"),
  WITCH("witch"),
  WITHERBOSS("wither"),
  WITHERSKELETON("wither_skeleton"),
  ZOMBIE("zombie"),
  ZOMBIESOLDIER("techguns:zombiesoldier"),
  ZOMBIEMINER("techguns:zombieminer"),
  ZOMBIEPOLICEMAN("techguns:zombiepoliceman"),
  ZOMBIEPIGMANSOLDIER("techguns:zombiepigmansoldier"),
  ZOMBIEFARMER("techguns:zombiefarmer"),
  ALIENBUG("techguns:alienbug"),
  SUPERMUTANT("techguns:supermutantbasic"),
  CYBERDEMON("techguns:cyberdemon"),
  SKELETONSOLDIER("techguns:skeletonsoldier");


  public static final MobType[] COMMON_MOBS = {ZOMBIEFARMER, SPIDER, ALIENBUG, ZOMBIEMINER};
  public static final MobType[] COMMON_TECH_MOBS = {ZOMBIESOLDIER, ALIENBUG, ZOMBIE, SKELETONSOLDIER};
  public static final MobType[] UNCOMMON_MOBS = {CAVESPIDER, CREEPER, SUPERMUTANT};
  public static final MobType[] UNCOMMON_TECH_MOBS = {ZOMBIEMINER, ZOMBIESOLDIER, SKELETONSOLDIER, ZOMBIEPIGMANSOLDIER};
  public static final MobType[] RARE_MOBS = {ENDERMAN, SLIME, WITCH};
  public static final MobType[] EPIC_MOBS = {WITHERBOSS};
  public static final MobType[] LEGENDARY_MOBS = {};


  public static final MobType[] HUMANOID_MOBS = {SKELETON, WITCH, ZOMBIE};
  public static final MobType[] UNDEAD_MOBS = {ZOMBIEPOLICEMAN, SKELETONSOLDIER, ZOMBIEFARMER, ZOMBIEMINER};
  public static final MobType[] NETHER_MOBS = {BLAZE, LAVASLIME, ZOMBIEPIGMANSOLDIER, CYBERDEMON};

  public static final MobType[] TECH_MOBS = {ZOMBIESOLDIER, ZOMBIEMINER, ZOMBIEPOLICEMAN,
          ZOMBIEPIGMANSOLDIER, ZOMBIEFARMER, ALIENBUG,
          SUPERMUTANT, CYBERDEMON, SKELETONSOLDIER};

  private String name;
  private Boolean equip = true;

  MobType(String name) {
    if (0 == name.indexOf("techguns:")) {
      this.name = name;
      this.equip = false;
    } else {
      this.name = "minecraft:" + name;
    }
  }

  public String getName() {
    return name;
  }

  public Boolean useEquip() {
    return equip;
  }

  public SpawnerSettings newSpawnerSetting() {
    return MobType.newSpawnerSetting(this);
  }

  public static SpawnerSettings newSpawnerSetting(MobType... mobTypes) {
    SpawnerSettings spawnerSettings = new SpawnerSettings();

    Arrays.stream(mobTypes)
        .map(spawner -> new SpawnPotential(spawner.getName(), spawner.useEquip(), 1, new NBTTagCompound()))
        .map(spawnPotential -> new Spawnable(Lists.newArrayList(spawnPotential)))
        .forEach(spawnable -> spawnerSettings.add(spawnable, 1));

    return spawnerSettings;
  }

}
