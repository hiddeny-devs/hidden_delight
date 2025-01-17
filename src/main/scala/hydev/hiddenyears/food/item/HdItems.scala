package hydev.hiddenyears.food.item

import hydev.hiddenyears.food.HiddenDelight
import hydev.hiddenyears.food.block.HdBlocks
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Block
import net.minecraft.component.{ComponentChanges, ComponentMap}
import net.minecraft.component.`type`.FoodComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item.Settings
import net.minecraft.item.{BlockItem, Item, ItemStack}
import net.minecraft.registry.{Registries, Registry}
import net.minecraft.util.{Identifier, Rarity}
import net.minecraft.world.World
import org.apache.commons.lang3.function.TriConsumer

//noinspection ScalaWeakerAccess
object HdItems {
  // candies
  val AMETHYST_CHOCOLATE: HdFoodItem = register(
    "amethyst_chocolate",
    new Settings(),
    HdFoodComponents.AMETHYST_CHOCOLATE,
    (_, _, livingEntity: LivingEntity) => {
      livingEntity match
        case player: PlayerEntity => player.addExperienceLevels(2)
        case _                    =>
    }
  )

  val AMETHYST_MARSHMALLOW: HdFoodItem = register(
    "amethyst_marshmallow",
    new Settings(),
    HdFoodComponents.AMETHYST_MARSHMALLOW,
    (_, _, livingEntity: LivingEntity) => {
      livingEntity match
        case player: PlayerEntity => player.addExperienceLevels(3)
        case _                    =>
    }
  )

  val CHOCOLATE: HdFoodItem = register("chocolate", new Settings(), HdFoodComponents.CHOCOLATE)

  val CHOCOLATE_BAR: HdFoodItem = register(
    "chocolate_bar",
    new Settings().attributeModifiers(HdAttributeModifiers.CHOCOLATE_BAR),
    HdFoodComponents.CHOCOLATE_BAR
  )

  val CHOCOLATE_PASTE: HdFoodItem = register(
    "chocolate_paste",
    new Settings(),
    HdFoodComponents.CHOCOLATE_PASTE
  )

  val HONEY_CANDY: HdFoodItem = register("honey_candy", new Settings(), HdFoodComponents.HONEY_CANDY)

  val MARSHMALLOW: HdFoodItem = register("marshmallow", new Settings(), HdFoodComponents.MARSHMALLOW)

  val MILK_CHOCOLATE: HdFoodItem = register(
    "milk_chocolate",
    new Settings(),
    HdFoodComponents.MILK_CHOCOLATE,
    (_, world: World, livingEntity: LivingEntity) => { if (!world.isClient) { livingEntity.clearStatusEffects() } }
  )

  val SWEET_BERRY_CHOCOLATE: HdFoodItem = register(
    "sweet_berry_chocolate",
    new Settings(),
    HdFoodComponents.SWEET_BERRY_CHOCOLATE
  )

  val SWEET_BERRY_MARSHMALLOW: HdFoodItem = register(
    "sweet_berry_marshmallow",
    new Settings(),
    HdFoodComponents.SWEET_BERRY_MARSHMALLOW
  )

  val SYRUP: HdDrinkItem = register(
    "syrup",
    new HdDrinkItem(new Settings().maxCount(1), HdFoodComponents.SYRUP)
  )

  // copper_foods
  val COPPER_APPLE: HdFoodItem = register(
    "copper_apple",
    new Settings().rarity(Rarity.RARE),
    HdFoodComponents.COPPER_APPLE
  )

  val ENCHANTED_COPPER_APPLE: HdFoodItem = register(
    "enchanted_copper_apple",
    new HdFoodItem(
      new Settings().rarity(Rarity.EPIC),
      HdFoodComponents.ENCHANTED_COPPER_APPLE
    ) {
      override def hasGlint(stack: ItemStack): Boolean = true
    }
  )

  val COPPER_BREAD: HdFoodItem = register(
    "copper_bread",
    new Settings(),
    HdFoodComponents.COPPER_BREAD
  )

  val COPPER_CARROT: HdFoodItem = register(
    "copper_carrot",
    new Settings(),
    HdFoodComponents.COPPER_CARROT
  )

  val COPPER_KELP: HdFoodItem = register(
    "copper_kelp",
    new Settings(),
    HdFoodComponents.COPPER_KELP
  )

  val COPPER_MELON_SLICE: HdFoodItem = register(
    "copper_melon_slice",
    new Settings(),
    HdFoodComponents.COPPER_MELON_SLICE
  )

  val COPPER_POTATO: HdFoodItem = register(
    "copper_potato",
    new Settings(),
    HdFoodComponents.COPPER_POTATO
  )

  val COPPER_HODGEPODGE: HdFoodItem = register(
    "copper_hodgepodge",
    new Settings().maxCount(1),
    HdFoodComponents.COPPER_HODGEPODGE
  )
  // medicines
  val MEDICINE: HdMedicineItem = register(
    "medicine",
    new HdMedicineItem()
  )
  // blocks
  val CHOCOLATE_BRICKS: BlockItem = registerBlockItem("chocolate_bricks", HdBlocks.CHOCOLATE_BRICKS);

  val CHOCOLATE_BLOCK: BlockItem = registerBlockItem("chocolate_block", HdBlocks.CHOCOLATE_BLOCK);

  def init(): Unit = {
    ItemGroupEvents
      .modifyEntriesEvent(HdItemGroups.ITEM_GROUP_KEY)
      .register((itemGroup) => {
        itemGroup.add(AMETHYST_CHOCOLATE)
        itemGroup.add(AMETHYST_MARSHMALLOW)
        itemGroup.add(CHOCOLATE)
        itemGroup.add(CHOCOLATE_BAR)
        itemGroup.add(CHOCOLATE_PASTE)
        itemGroup.add(HONEY_CANDY)
        itemGroup.add(MARSHMALLOW)
        itemGroup.add(MILK_CHOCOLATE)
        itemGroup.add(SWEET_BERRY_CHOCOLATE)
        itemGroup.add(SWEET_BERRY_MARSHMALLOW)
        itemGroup.add(SYRUP)
        itemGroup.add(COPPER_APPLE)
        itemGroup.add(ENCHANTED_COPPER_APPLE)
        itemGroup.add(COPPER_BREAD)
        itemGroup.add(COPPER_CARROT)
        itemGroup.add(COPPER_KELP)
        itemGroup.add(COPPER_MELON_SLICE)
        itemGroup.add(COPPER_POTATO)
        itemGroup.add(COPPER_HODGEPODGE)
        itemGroup.add(CHOCOLATE_BRICKS)
        itemGroup.add(CHOCOLATE_BLOCK)
        (1 to 14)
          .foreach(i =>
            itemGroup.add(
              new ItemStack(
                MEDICINE.getRegistryEntry,
                1,
                ComponentChanges
                  .builder()
                  .add(HdDataComponentTypes.MEDICINE_ID, i)
                  .build()
              )
            )
          )
      })
  }

  private def register(id: String, settings: Settings, foodComponent: FoodComponent): HdFoodItem = {
    val itemId: Identifier = HiddenDelight.ofMod(id)
    Registry.register(Registries.ITEM, itemId, new HdFoodItem(settings, foodComponent))
  }

  private def register(id: String, settings: Settings, foodComponent: FoodComponent, onUse: TriConsumer[ItemStack, World, LivingEntity]): HdFoodItem = {
    val itemId: Identifier = HiddenDelight.ofMod(id)
    Registry.register(Registries.ITEM, itemId, new HdFoodItem(settings, foodComponent, onUse))
  }

  private def registerBlockItem(id: String, block: Block): BlockItem = {
    register(id, new BlockItem(block, new Settings()))
  }

  private def register[T <: Item](id: String, item: T): T = {
    val itemId: Identifier = HiddenDelight.ofMod(id)
    Registry.register(Registries.ITEM, itemId, item)
  }
}
