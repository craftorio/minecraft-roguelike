package greymerk.roguelike.dungeon.tasks;

import java.util.Random;

import greymerk.roguelike.dungeon.Dungeon;
import greymerk.roguelike.dungeon.settings.DungeonSettings;
import greymerk.roguelike.dungeon.towers.Tower;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;

public class DungeonTaskTower implements IDungeonTask {

  @Override
  public void execute(IWorldEditor editor, Random rand, Dungeon dungeon, DungeonSettings settings) {
    Coord pos = dungeon.getPosition();

    Tower tower = settings.getTower().getTower();
    Random r = Dungeon.getRandom(editor, pos);
    Tower.get(tower).generate(editor, r, settings.getTower().getTheme(), pos);


  }

}
