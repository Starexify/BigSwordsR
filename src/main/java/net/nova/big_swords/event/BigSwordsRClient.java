package net.nova.big_swords.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.nova.big_swords.BigSwordsR;
import net.nova.big_swords.data.BSPackMetaGenerator;

import static net.nova.big_swords.BigSwordsR.MODID;

@EventBusSubscriber(modid = MODID)
public class BigSwordsRClient {
  // Integrated Resourcepack
  @SubscribeEvent
  public static void onAddPackFinders(AddPackFindersEvent event) {
    if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

    for (String packId : BSPackMetaGenerator.RESOURCE_PACKS) {
      event.addPackFinders(
          BigSwordsR.rl("resourcepacks/" + packId),
          PackType.CLIENT_RESOURCES,
          Component.translatable("resourcePack." + BigSwordsR.MODID + "." + packId + ".name"),
          PackSource.BUILT_IN,
          false,
          Pack.Position.TOP
      );
    }
  }
}
