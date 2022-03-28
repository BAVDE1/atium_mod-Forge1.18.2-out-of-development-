package com.BAVDE.atium_mod.world.feature;

import com.BAVDE.atium_mod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CRYSTALLINE_TREE =
            FeatureUtils.register("crystalline", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.CRYSTALLINE_LOG.get()),
                    new FancyTrunkPlacer(5, 11, 0), // -, bigness, -

                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.CRYSTALLINE_LEAVES.get().defaultBlockState(), 6)
                            .add(ModBlocks.BUDDING_CRYSTALLINE_LEAVES.get().defaultBlockState(), 1)),
                    new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(0, 0, 0)).build());

    public static final Holder<PlacedFeature> CRYSTALLINE_CHECKED = PlacementUtils.register("crystalline_checked", CRYSTALLINE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CRYSTALLINE_SAPLING.get()));

    /*public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CRYSTALLINE_SPAWN =
            FeatureUtils.register("crystalline_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CRYSTALLINE_CHECKED,
                            0.5F)), CRYSTALLINE_CHECKED));*/
}
