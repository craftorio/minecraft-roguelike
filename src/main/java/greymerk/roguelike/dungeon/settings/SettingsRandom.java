package greymerk.roguelike.dungeon.settings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import greymerk.roguelike.dungeon.LevelGenerator;
import greymerk.roguelike.dungeon.base.RoomsSetting;
import greymerk.roguelike.dungeon.base.SecretsSetting;
import greymerk.roguelike.dungeon.segment.SegmentGenerator;
import greymerk.roguelike.dungeon.towers.Tower;
import greymerk.roguelike.treasure.Treasure;
import greymerk.roguelike.treasure.loot.Equipment;
import greymerk.roguelike.treasure.loot.ILoot;
import greymerk.roguelike.treasure.loot.Loot;
import greymerk.roguelike.treasure.loot.LootRuleManager;
import greymerk.roguelike.treasure.loot.Quality;
import greymerk.roguelike.treasure.loot.provider.ItemEnchBook;
import greymerk.roguelike.treasure.loot.provider.ItemSpecialty;

import static greymerk.roguelike.theme.Theme.randomTheme;

public class SettingsRandom extends DungeonSettings {

  public SettingsRandom(Random rand) {

    setTowerSettings(new TowerSettings(Tower.randomTower(rand), randomTheme()));

    Map<Integer, LevelSettings> levels = new HashMap<>();

    IntStream.range(0, 5)
        .forEach(i -> levels.put(i, createRandomLevel(rand, i)));

    setLevels(levels);

    setLootRules(new LootRuleManager());
    ILoot loot = Loot.getLoot();
    getLootRules().add(Treasure.STARTER, loot.get(Loot.TECHGUNS, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.TECHGUNS_AMMO, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.FOOD, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.TOOL, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, new ItemSpecialty(0, 0, Equipment.LEGS, Quality.WOOD), 0, true, 2);
    for (int i = 0; i < 5; ++i) {
      getLootRules().add(Treasure.ARMOUR, loot.get(Loot.POTION, i), i, true, 1);
      getLootRules().add(Treasure.ARMOUR, loot.get(Loot.ARMOUR, i), i, true, 1);
      getLootRules().add(Treasure.ARMOUR, loot.get(Loot.FOOD, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.TECHGUNS, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.TECHGUNS_ARMOR, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.TECHGUNS_AMMO, i), i, true, 1);
      getLootRules().add(Treasure.RARE_WEAPONS, loot.get(Loot.TECHGUNS, i), i, true, 1);
      getLootRules().add(Treasure.RARE_WEAPONS, loot.get(Loot.TECHGUNS_AMMO, i), i, true, 1);
      getLootRules().add(Treasure.RARE_ARMOUR, loot.get(Loot.TECHGUNS_ARMOR, i), i, true, 1);
      getLootRules().add(Treasure.AMMO, loot.get(Loot.TECHGUNS_AMMO, i), i, true, 1);
      getLootRules().add(Treasure.BLOCKS, loot.get(Loot.BLOCK, i), i, true, 6);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.FOOD, i), i, true, 1);
      getLootRules().add(Treasure.ENCHANTING, loot.get(Loot.ENCHANTBONUS, i), i, true, 2);
      getLootRules().add(Treasure.ENCHANTING, loot.get(Loot.ENCHANTBOOK, i), i, true, 1);
      getLootRules().add(Treasure.FOOD, loot.get(Loot.FOOD, i), i, true, 8);
      getLootRules().add(Treasure.ORE, loot.get(Loot.ORE, i), i, true, 5);
      getLootRules().add(Treasure.POTIONS, loot.get(Loot.POTION, i), i, true, 6);
      getLootRules().add(Treasure.TOOLS, loot.get(Loot.ORE, i), i, true, 1);
      getLootRules().add(Treasure.TOOLS, loot.get(Loot.TOOL, i), i, true, 1);
      getLootRules().add(Treasure.TOOLS, loot.get(Loot.BLOCK, i), i, true, 1);
      getLootRules().add(Treasure.SUPPLIES, loot.get(Loot.SUPPLY, i), i, true, 6);
      getLootRules().add(Treasure.SMITH, loot.get(Loot.ORE, i), i, true, 6);
      getLootRules().add(Treasure.SMITH, loot.get(Loot.SMITHY, i), i, true, 1);
      getLootRules().add(Treasure.MUSIC, loot.get(Loot.MUSIC, i), i, true, 1);
      getLootRules().add(Treasure.REWARD, loot.get(Loot.REWARD, i), i, true, 1);
      getLootRules().add(null, loot.get(Loot.JUNK, i), i, true, 6);
      getLootRules().add(null, new ItemSpecialty(0, i, Quality.get(i)), i, false, 3);
      getLootRules().add(null, new ItemEnchBook(0, i), i, false, i * 2 + 5);
    }
  }

  private LevelSettings createRandomLevel(Random rand, int i) {
    LevelSettings level = new LevelSettings();
    level.setDifficulty(i);
    level.setGenerator(LevelGenerator.CLASSIC);
    level.setNumRooms(15);
    level.setRange(60);
    level.setRooms(RoomsSetting.getRandom(rand, 8));
    level.setScatter(15);
    level.setSecrets(SecretsSetting.getRandom(rand, 2));
    level.setSegments(SegmentGenerator.getRandom(rand, 12));
    level.setTheme(randomTheme());
    return level;
  }
}
