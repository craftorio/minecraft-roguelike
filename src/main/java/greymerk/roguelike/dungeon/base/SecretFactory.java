package greymerk.roguelike.dungeon.base;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;

public class SecretFactory {

  private Map<DungeonRoom, ISecretRoom> secrets;


  public SecretFactory() {
    secrets = new HashMap<DungeonRoom, ISecretRoom>();
  }

  public SecretFactory(SecretFactory toCopy) {
    this();
    for (DungeonRoom type : toCopy.secrets.keySet()) {
      int count = toCopy.secrets.get(type).getCount();
      addRoom(type, count);
    }
  }

  public SecretFactory(SecretFactory base, SecretFactory other) {
    this();
    if (base != null) {
      for (DungeonRoom type : base.secrets.keySet()) {
        int count = base.secrets.get(type).getCount();
        addRoom(type, count);
      }
    }

    if (other != null) {
      for (DungeonRoom type : other.secrets.keySet()) {
        int count = other.secrets.get(type).getCount();
        addRoom(type, count);
      }
    }
  }

  public SecretFactory(JsonArray data) {
    this();
    for (JsonElement e : data) {
      JsonObject room = e.getAsJsonObject();
      add(room);
    }
  }

  public static SecretFactory getRandom(Random rand, int count) {
    SecretFactory secrets = new SecretFactory();
    for (int i = 0; i < count; ++i) {
      secrets.addRoom(DungeonRoom.getRandomSecret(rand));
    }
    return secrets;
  }

  public void add(JsonObject room) {
    String type = room.get("name").getAsString();
    int count = room.get("count").getAsInt();
    addRoom(DungeonRoom.valueOf(type), count);
  }

  public void addRoom(DungeonRoom type) {
    addRoom(type, 1);
  }

  public void addRoom(DungeonRoom type, int count) {

    ISecretRoom room;

    if (secrets.containsKey(type)) {
      room = secrets.get(type);
      room.add(count);
      return;
    }

    room = new SecretRoom(type, count);
    secrets.put(type, room);
  }

  public IDungeonRoom generateRoom(IWorldEditor editor, Random rand, LevelSettings settings, Cardinal dir, Coord pos) {
    return secrets.values().stream()
        .map(room -> room.generate(editor, rand, settings, dir, pos))
        .filter(Objects::nonNull).findFirst()
        .orElse(null);
  }

  @Override
  public boolean equals(Object o) {

    SecretFactory other = (SecretFactory) o;

    if (!secrets.keySet().equals(other.secrets.keySet())) {
      return false;
    }

    for (DungeonRoom type : secrets.keySet()) {
      if (!secrets.get(type).equals(other.secrets.get(type))) {
        return false;
      }
    }

    return true;
  }
}