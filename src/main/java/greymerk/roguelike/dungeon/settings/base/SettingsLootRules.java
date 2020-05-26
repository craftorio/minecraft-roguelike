package greymerk.roguelike.dungeon.settings.base;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

import greymerk.roguelike.dungeon.settings.DungeonSettings;
import greymerk.roguelike.dungeon.settings.SettingIdentifier;
import greymerk.roguelike.dungeon.settings.SettingsContainer;
import greymerk.roguelike.treasure.Treasure;
import greymerk.roguelike.treasure.loot.Book;
import greymerk.roguelike.treasure.loot.Equipment;
import greymerk.roguelike.treasure.loot.ILoot;
import greymerk.roguelike.treasure.loot.Loot;
import greymerk.roguelike.treasure.loot.LootRuleManager;
import greymerk.roguelike.treasure.loot.LootTableRule;
import greymerk.roguelike.treasure.loot.Quality;
import greymerk.roguelike.treasure.loot.provider.ItemEnchBook;
import greymerk.roguelike.treasure.loot.provider.ItemSpecialty;

import static com.google.common.collect.Lists.newArrayList;

public class SettingsLootRules extends DungeonSettings {

  public static final SettingIdentifier ID = new SettingIdentifier(SettingsContainer.BUILTIN_NAMESPACE, "loot");

  public SettingsLootRules() {
    super(ID);
    setExclusive(false);
    setLootRules(new LootRuleManager());
    ILoot loot = Loot.getLoot();

    addStarterLoot(loot);

    addRewardLoot();

    for (int i = 0; i < 5; ++i) {
      getLootRules().add(Treasure.ARMOUR, loot.get(Loot.POTION, i), i, true, 1);
      getLootRules().add(Treasure.ARMOUR, loot.get(Loot.ARMOUR, i), i, true, 1);
      getLootRules().add(Treasure.ARMOUR, loot.get(Loot.FOOD, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.POTION, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.WEAPON, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.TECHGUNS, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.TECHGUNS_AMMO, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.TECHGUNS_ARMOR, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.FOOD, i), i, true, 1);
      getLootRules().add(Treasure.WEAPONS, loot.get(Loot.FOOD, i), i, true, 1);
      getLootRules().add(Treasure.BLOCKS, loot.get(Loot.BLOCK, i), i, true, 6);
      getLootRules().add(Treasure.ENCHANTING, loot.get(Loot.ENCHANTBONUS, i), i, true, 2);
      getLootRules().add(Treasure.ENCHANTING, loot.get(Loot.ENCHANTBOOK, i), i, true, 1);
      getLootRules().add(Treasure.FOOD, loot.get(Loot.FOOD, i), i, true, 8);
      getLootRules().add(Treasure.ORE, loot.get(Loot.ORE, i), i, true, 5);
      getLootRules().add(Treasure.POTIONS, loot.get(Loot.POTION, i), i, true, 6);
      getLootRules().add(Treasure.BREWING, loot.get(Loot.BREWING, i), i, true, 8);
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

  private void addRewardLoot() {
    useLootTableForLevel(LootTableList.CHESTS_SIMPLE_DUNGEON, 0);
    useLootTableForLevel(LootTableList.CHESTS_DESERT_PYRAMID, 1);
    useLootTableForLevel(LootTableList.CHESTS_JUNGLE_TEMPLE, 2);
    useLootTableForLevel(LootTableList.CHESTS_NETHER_BRIDGE, 3);
    useLootTableForLevel(LootTableList.CHESTS_END_CITY_TREASURE, 4);
  }

  private void useLootTableForLevel(ResourceLocation chestsSimpleDungeon, int level) {
    getLootTables().add(new LootTableRule(newArrayList(level), new ResourceLocation(chestsSimpleDungeon.getResourcePath()), newArrayList(Treasure.REWARD)));
  }

  private void addStarterLoot(ILoot loot) {
    getLootRules().add(Treasure.STARTER, Book.get(Book.CREDITS));
    getLootRules().add(Treasure.STARTER, loot.get(Loot.WEAPON, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.FOOD, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.TOOL, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.SUPPLY, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, loot.get(Loot.TECHGUNS_AMMO, 0), 0, true, 2);
    getLootRules().add(Treasure.STARTER, new ItemSpecialty(0, 0, Equipment.LEGS, Quality.WOOD), 0, true, 2);
  }
}
