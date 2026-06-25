package net.nova.big_swords.block;

import net.minecraft.block.Block;
import net.minecraft.block.PlantBlock;
import net.minecraft.client.render.texture.Sprite;
import net.minecraft.client.render.texture.SpriteRegistry;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

public class BiomassCrop extends PlantBlock {
  private Sprite[] blockSprite;

  public BiomassCrop() {
    this.setTicksRandomly(true);
    float f = 0.5F;
    this.setShape(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    this.setCreativeModeTab(null);
    this.setStrength(0.0F);
    this.setSounds(GRASS_SOUNDS);
    this.disableStats();
  }

  @Override
  protected boolean canBePlacedOn(Block block) {
    return block == BSBlocks.CREEP_BLOCK;
  }

  protected Item getSeedItem() {
    return BSItems.BIOMASS_SEEDS.get();
  }

  @Override
  public Item getPickItem(World world, int x, int y, int z) {
    return this.getSeedItem();
  }

  @Override
  public Sprite getSprite(int face, int metadata) {
    if (metadata < 0 || metadata > 4) metadata = 4;

    return this.blockSprite[metadata];
  }

  @Override
  public void registerSprites(SpriteRegistry registry) {
    this.blockSprite = new Sprite[4];

    for (int i = 0; i < this.blockSprite.length; i++) {
      this.blockSprite[i] = registry.registerSprite(this.getSpriteName() + "_stage" + i);
    }
  }
}
