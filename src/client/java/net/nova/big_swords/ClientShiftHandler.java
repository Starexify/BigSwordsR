package net.nova.big_swords;

import net.minecraft.client.Minecraft;

public class ClientShiftHandler implements IShiftHandler {
  @Override
  public boolean getShift() {
    return Minecraft.getInstance().hasShiftDown();
  }
}