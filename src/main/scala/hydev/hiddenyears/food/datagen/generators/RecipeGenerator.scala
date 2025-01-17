package hydev.hiddenyears.food.datagen.generators

import hydev.hiddenyears.food.item.{HdItems, HdMedicineItem}
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags
import net.minecraft.data.server.recipe.{CookingRecipeJsonBuilder, RecipeExporter, RecipeProvider, ShapedRecipeJsonBuilder, ShapelessRecipeJsonBuilder}
import net.minecraft.item.{Item, ItemStack, Items}
import net.minecraft.recipe.book.{CookingRecipeCategory, RecipeCategory}
import net.minecraft.recipe.{AbstractCookingRecipe, CampfireCookingRecipe, Ingredient, RecipeSerializer, SmokingRecipe}
import net.minecraft.registry.RegistryWrapper.WrapperLookup

import java.util.concurrent.CompletableFuture

final class RecipeGenerator(output: FabricDataOutput, registriesFuture: CompletableFuture[WrapperLookup])
    extends FabricRecipeProvider(output, registriesFuture) {
  override def generate(exporter: RecipeExporter): Unit = {
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.AMETHYST_CHOCOLATE)
      .input(ConventionalItemTags.AMETHYST_GEMS)
      .input(HdItems.CHOCOLATE)
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE))
      .offerTo(exporter)
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.AMETHYST_MARSHMALLOW)
      .input(ConventionalItemTags.AMETHYST_GEMS)
      .input(HdItems.MARSHMALLOW)
      .criterion(RecipeProvider.hasItem(HdItems.MARSHMALLOW), RecipeProvider.conditionsFromItem(HdItems.MARSHMALLOW))
      .offerTo(exporter)
    ShapedRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.CHOCOLATE_BAR)
      .pattern("X")
      .pattern("X")
      .input('X', HdItems.CHOCOLATE)
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE))
      .offerTo(exporter)
    ShapedRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.CHOCOLATE_BLOCK)
      .pattern("XX")
      .pattern("XX")
      .input('X', HdItems.CHOCOLATE)
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE))
      .offerTo(exporter)
    ShapedRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.CHOCOLATE_BRICKS)
      .pattern("XX")
      .pattern("XX")
      .input('X', HdItems.CHOCOLATE_BLOCK)
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE_BLOCK), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE_BLOCK))
      .offerTo(exporter)
    RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.MISC, HdItems.CHOCOLATE_BRICKS, HdItems.CHOCOLATE_BLOCK)
    CookingRecipeJsonBuilder
      .createSmelting(Ingredient.ofItems(Items.COCOA_BEANS), RecipeCategory.FOOD, HdItems.CHOCOLATE, 0.35f, 200)
      .criterion(RecipeProvider.hasItem(Items.COCOA_BEANS), RecipeProvider.conditionsFromItem(Items.COCOA_BEANS))
      .offerTo(exporter)
    CookingRecipeJsonBuilder
      .createSmelting(Ingredient.ofItems(HdItems.CHOCOLATE), RecipeCategory.FOOD, HdItems.CHOCOLATE_PASTE, 0.35f, 200)
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE))
      .offerTo(exporter)
    generateCopperFoodsRecipes(exporter, Items.APPLE, HdItems.COPPER_APPLE)
    generateCopperFoodsRecipes(exporter, Items.BREAD, HdItems.COPPER_BREAD)
    generateCopperFoodsRecipes(exporter, Items.CARROT, HdItems.COPPER_CARROT)
    generateCopperFoodsRecipes(exporter, Items.KELP, HdItems.COPPER_KELP)
    generateCopperFoodsRecipes(exporter, Items.MELON_SLICE, HdItems.COPPER_MELON_SLICE)
    generateCopperFoodsRecipes(exporter, Items.POTATO, HdItems.COPPER_POTATO)
    generateCopperFoodsRecipes(exporter, Items.BOWL, HdItems.COPPER_HODGEPODGE)
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.HONEY_CANDY)
      .input(Items.SUGAR)
      .input(Items.HONEYCOMB)
      .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
      .criterion(RecipeProvider.hasItem(Items.HONEYCOMB), RecipeProvider.conditionsFromItem(Items.HONEYCOMB))
      .offerTo(exporter)
    CookingRecipeJsonBuilder
      .createSmelting(Ingredient.ofItems(Items.SUGAR), RecipeCategory.FOOD, HdItems.MARSHMALLOW, 0.35f, 200)
      .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
      .offerTo(exporter)
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.MILK_CHOCOLATE)
      .input(ConventionalItemTags.MILK_BUCKETS)
      .input(HdItems.CHOCOLATE)
      .criterion(RecipeProvider.hasItem(Items.MILK_BUCKET), RecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE))
      .offerTo(exporter)
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.SWEET_BERRY_CHOCOLATE)
      .input(Items.SWEET_BERRIES)
      .input(HdItems.CHOCOLATE)
      .criterion(RecipeProvider.hasItem(Items.SWEET_BERRIES), RecipeProvider.conditionsFromItem(Items.SWEET_BERRIES))
      .criterion(RecipeProvider.hasItem(HdItems.CHOCOLATE), RecipeProvider.conditionsFromItem(HdItems.CHOCOLATE))
      .offerTo(exporter)
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.SWEET_BERRY_MARSHMALLOW)
      .input(Items.SWEET_BERRIES)
      .input(HdItems.MARSHMALLOW)
      .criterion(RecipeProvider.hasItem(Items.SWEET_BERRIES), RecipeProvider.conditionsFromItem(Items.SWEET_BERRIES))
      .criterion(RecipeProvider.hasItem(HdItems.MARSHMALLOW), RecipeProvider.conditionsFromItem(HdItems.MARSHMALLOW))
      .offerTo(exporter)
    ShapelessRecipeJsonBuilder
      .create(RecipeCategory.MISC, HdItems.SYRUP)
      .input(Items.SUGAR)
      .input(Items.POTION)
      .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
      .criterion(RecipeProvider.hasItem(Items.POTION), RecipeProvider.conditionsFromItem(Items.POTION))
      .offerTo(exporter)
    // no medicines because shapeless recipe builder does not support for adding components
    // mojang really sucks
    // generate like what's in vanilla
    // it's hideous
    generateCookingRecipes(
      exporter,
      "smoking",
      RecipeSerializer.SMOKING,
      (group: String, category: CookingRecipeCategory, ingredient: Ingredient, result: ItemStack, experience: Float, cookingTime: Int) =>
        new SmokingRecipe(group, category, ingredient, result, experience, cookingTime),
      100
    )
    generateCookingRecipes(
      exporter,
      "campfire_cooking",
      RecipeSerializer.CAMPFIRE_COOKING,
      (group: String, category: CookingRecipeCategory, ingredient: Ingredient, result: ItemStack, experience: Float, cookingTime: Int) =>
        new CampfireCookingRecipe(group, category, ingredient, result, experience, cookingTime),
      600
    )
  }

  private def generateCookingRecipes[T <: AbstractCookingRecipe](
      exporter: RecipeExporter,
      cooker: String,
      serializer: RecipeSerializer[T],
      recipeFactory: AbstractCookingRecipe.RecipeFactory[T],
      cookingTime: Int
  ): Unit = {
    RecipeProvider.offerFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, Items.COCOA_BEANS, HdItems.CHOCOLATE, 0.35f)
    RecipeProvider.offerFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, HdItems.CHOCOLATE, HdItems.CHOCOLATE_PASTE, 0.35f)
    RecipeProvider.offerFoodCookingRecipe(exporter, cooker, serializer, recipeFactory, cookingTime, Items.SUGAR, HdItems.MARSHMALLOW, 0.35f)
  }
  private def generateCopperFoodsRecipes(exporter: RecipeExporter, input: Item, output: Item): Unit = {
    ShapedRecipeJsonBuilder
      .create(RecipeCategory.MISC, output)
      .pattern("XXX")
      .pattern("XAX")
      .pattern("XXX")
      .input('X', ConventionalItemTags.COPPER_INGOTS)
      .input('A', input)
      .criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input))
      // There isn't like `hasItemWithTag`, so we can only specify vanilla copper here
      .criterion(RecipeProvider.hasItem(Items.COPPER_INGOT), RecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
      .offerTo(exporter)
  }
}
