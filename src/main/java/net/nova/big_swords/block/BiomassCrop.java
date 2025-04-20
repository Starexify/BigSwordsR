package net.nova.big_swords.block;

import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.client.Texture;
import net.minecraft.client.TextureRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.nova.big_swords.init.BSBlocks;
import net.nova.big_swords.init.BSItems;

import java.lang.reflect.Method;
import java.util.Random;

public class BiomassCrop extends CropBlock {
    private static final int MAX_AGE = 3;
    private Texture[] biomassTextures;
    private static Method growthChanceMethod;

    static {
        try {
            growthChanceMethod = CropBlock.class.getDeclaredMethod("method_294", World.class, int.class, int.class, int.class);
            growthChanceMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            System.err.println("Failed to get method_294: " + e.getMessage());
        }
    }

    private float getGrowthChance(World world, int x, int y, int z) {
        try {
            if (growthChanceMethod != null) {
                return (float) growthChanceMethod.invoke(this, world, x, y, z);
            }
        } catch (Exception e) {
            System.err.println("Failed to call method_294: " + e.getMessage());
        }
        return 1.0F; // Default value if reflection fails
    }

    @Override
    protected boolean canPlantOnTop(Block block) {
        return block == BSBlocks.CREEP_BLOCK;
    }

    @Override
    protected Item getSeedItem() {
        return BSItems.BIOMASS_SEED;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (world.method_3720(x, y + 1, z) >= 9) {
            int age = world.getBlockData(x, y, z);
            if (age < MAX_AGE) {
                float growthChance = this.getGrowthChance(world, x, y, z);
                if (random.nextInt((int) (25.0F / growthChance) + 1) == 0) {
                    world.method_4718(x, y, z, ++age, 2);
                }
            }
        }
    }

    @Override
    public void method_293(World world, int i, int j, int k) {
        int var5 = world.getBlockData(i, j, k) + MathHelper.nextInt(world.random, 2, 5);
        if (var5 > MAX_AGE) var5 = MAX_AGE;
        world.method_4718(i, j, k, var5, 2);
    }

    @Override
    public void method_410(World world, int i, int j, int k, int l, float f, int m) {
        super.method_410(world, i, j, k, l, f, 0);
        if (!world.isClient) {
            if (l >= MAX_AGE) {
                int var8 = 3 + m;

                for (int var9 = 0; var9 < var8; var9++) {
                    if (world.random.nextInt(15) <= l)
                        this.method_422(world, i, j, k, new ItemStack(this.getSeedItem(), 1, 0));
                }
            }
        }
    }

    @Override
    public Item method_398(int i, Random random, int j) {
        return i == MAX_AGE ? this.getHarvestItem() : this.getSeedItem();
    }

    @Override
    public void registerTextures(TextureRegistry registry) {
        this.biomassTextures = new Texture[MAX_AGE + 1];

        for (int var2 = 0; var2 <= MAX_AGE; var2++) {
            this.biomassTextures[var2] = registry.registerTexture(this.getTextureName() + "_stage_" + var2);
        }
    }

    @Override
    public boolean method_6460(World world, int i, int j, int k, boolean bl) {
        return world.getBlockData(i, j, k) != MAX_AGE;
    }
}
