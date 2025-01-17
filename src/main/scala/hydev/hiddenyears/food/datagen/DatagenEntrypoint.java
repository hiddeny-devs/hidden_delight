package hydev.hiddenyears.food.datagen;

import hydev.hiddenyears.food.HiddenDelight;
import hydev.hiddenyears.food.datagen.generators.BlockLootTableGenerator;
import hydev.hiddenyears.food.datagen.generators.BlockTagGenerator;
import hydev.hiddenyears.food.datagen.generators.ItemTagGenerator;
import hydev.hiddenyears.food.datagen.generators.ModelGenerator;
import hydev.hiddenyears.food.datagen.generators.RecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public final class DatagenEntrypoint implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        HiddenDelight.LOGGER().info("Datagen started.");
        var pack = fabricDataGenerator.createPack();
        BlockTagGenerator blockTags = pack.addProvider(BlockTagGenerator::new);
        pack.addProvider((output, wrapperLookup) -> new ItemTagGenerator(output, wrapperLookup, blockTags));
        pack.addProvider(BlockLootTableGenerator::new);
        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(ModelGenerator::new);
    }

    @Override
    public String getEffectiveModId() {
        return HiddenDelight.MOD_ID();
    }
}
