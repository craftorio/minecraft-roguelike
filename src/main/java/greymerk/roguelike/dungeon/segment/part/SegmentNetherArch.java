package greymerk.roguelike.dungeon.segment.part;

import java.util.Random;

import greymerk.roguelike.dungeon.DungeonLevel;
import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.IStair;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.blocks.BlockType;

public class SegmentNetherArch extends SegmentBase {

  @Override
  protected void genWall(IWorldEditor editor, Random rand, DungeonLevel level, Cardinal dir, ITheme theme, Coord origin) {

    IStair step = theme.getSecondary().getStair();
    step.setOrientation(dir.reverse(), true);
    IBlockFactory pillar = theme.getSecondary().getPillar();


    Coord cursor;

    boolean hasLava = rand.nextInt(5) == 0;

    for (Cardinal orth : dir.orthogonal()) {
      cursor = new Coord(origin);
      cursor.translate(dir, 1);
      cursor.translate(orth, 1);
      cursor.translate(Cardinal.UP, 2);
      step.set(editor, cursor);

      cursor = new Coord(origin);
      cursor.translate(dir, 2);
      cursor.translate(orth, 1);
      pillar.set(editor, rand, cursor);
      cursor.translate(Cardinal.UP, 1);
      pillar.set(editor, rand, cursor);
    }

    MetaBlock fence = BlockType.get(BlockType.FENCE_NETHER_BRICK);
    MetaBlock lava = BlockType.get(BlockType.LAVA_FLOWING);

    cursor = new Coord(origin);
    cursor.translate(dir, 2);
    fence.set(editor, rand, cursor);
    cursor.translate(Cardinal.UP, 1);
    fence.set(editor, rand, cursor);

    if (hasLava) {
      cursor.translate(dir, 1);
      lava.set(editor, cursor);
      cursor.translate(Cardinal.DOWN, 1);
      lava.set(editor, cursor);
    }
  }
}
