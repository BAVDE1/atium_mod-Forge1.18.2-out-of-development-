package com.BAVDE.atium_mod.event;

import com.BAVDE.atium_mod.AtiumMod;
import com.BAVDE.atium_mod.event.loot.DrownedDropLeather;
import com.BAVDE.atium_mod.event.loot.HuskDropLeather;
import com.BAVDE.atium_mod.event.loot.ZombieDropLeather;
import com.BAVDE.atium_mod.event.loot.ZombieVillagerDropLeather;
import com.BAVDE.atium_mod.recipe.InfusingTableRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = AtiumMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@NotNull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new ZombieDropLeather.Serializer().setRegistryName
                        (new ResourceLocation(AtiumMod.MOD_ID,"leather_from_zombie")),
                new HuskDropLeather.Serializer().setRegistryName
                        (new ResourceLocation(AtiumMod.MOD_ID,"leather_from_husk")),
                new DrownedDropLeather.Serializer().setRegistryName
                        (new ResourceLocation(AtiumMod.MOD_ID,"leather_from_drowned")),
                new ZombieVillagerDropLeather.Serializer().setRegistryName
                        (new ResourceLocation(AtiumMod.MOD_ID,"leather_from_zombie_villager"))
        );
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event){
        Registry.register(Registry.RECIPE_TYPE, InfusingTableRecipe.Type.ID, InfusingTableRecipe.Type.INSTANCE);
    }
}
