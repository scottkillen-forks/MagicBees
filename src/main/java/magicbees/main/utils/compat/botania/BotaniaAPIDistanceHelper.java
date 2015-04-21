package magicbees.main.utils.compat.botania;

import magicbees.main.utils.compat.BotaniaHelper;
import magicbees.main.utils.compat.BotaniaHelper.ManaResource;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.lexicon.LexiconPage;
import vazkii.botania.api.recipe.RecipePetals;

/**
 * Subordinate helper to the Botania Helper that has references to Botania API stuff that will cause
 * NoClassDefFoundErrors if included in the Botania Helper proper.
 */
public class BotaniaAPIDistanceHelper {
	
	public static LexiconEntry entryBeegonia;
	public static LexiconEntry entryHiveacynth;
	
	public static void registerSubtiles() {
		BotaniaAPI.registerSubTile(SubTileBeegonia.NAME, SubTileBeegonia.class);
		BotaniaAPI.registerSubTileSignature(SubTileBeegonia.class, new BotaniaSignature(SubTileBeegonia.NAME));
		BotaniaAPI.addSubTileToCreativeMenu(SubTileBeegonia.NAME);
		
		BotaniaAPI.registerSubTile(SubTileHiveacynth.NAME, SubTileHiveacynth.class);
		BotaniaAPI.registerSubTileSignature(SubTileHiveacynth.class, new BotaniaSignature(SubTileHiveacynth.NAME));
		BotaniaAPI.addSubTileToCreativeMenu(SubTileHiveacynth.NAME);
	}

	public static void setupCraftingAndLexicon() {

		RecipePetals beegoniaRecipe = BotaniaAPI.registerPetalRecipe(BotaniaAPI.internalHandler.getSubTileAsStack(SubTileBeegonia.NAME), new Object[] {
				new ItemStack(BotaniaHelper.itemPetal), new ItemStack(BotaniaHelper.itemManaPetal),
				new ItemStack(BotaniaHelper.itemPetal, 1, 4), new ItemStack(BotaniaHelper.itemPetal, 1, 4),
				new ItemStack(BotaniaHelper.itemPetal, 1, 4), new ItemStack(BotaniaHelper.itemManaPetal, 1, 4),
				new ItemStack(BotaniaHelper.itemManaPetal, 1, 15)
			});
		BotaniaAPIDistanceHelper.entryBeegonia = new BotaniaLexiconEntry(SubTileBeegonia.NAME, BotaniaAPI.categoryGenerationFlowers);
		BotaniaAPIDistanceHelper.entryBeegonia.setLexiconPages(new LexiconPage[] {
				BotaniaAPI.internalHandler.textPage("magicbees.botania.lexicon.beegonia.0"),
				BotaniaAPI.internalHandler.textPage("magicbees.botania.lexicon.beegonia.1"),
				BotaniaAPI.internalHandler.petalRecipePage("magicbees.botania.lexicon.beegonia.crafting", beegoniaRecipe),
				BotaniaAPI.internalHandler.textPage("magicbees.botania.lexicon.beegonia.2")
			});
		
		RecipePetals hiveacynthRecipe = BotaniaAPI.registerPetalRecipe(BotaniaAPI.internalHandler.getSubTileAsStack(SubTileHiveacynth.NAME), new Object[] {
				new ItemStack(BotaniaHelper.itemPetal, 1, 3), new ItemStack(BotaniaHelper.itemPetal, 1, 9),
				new ItemStack(BotaniaHelper.itemPetal, 1, 9), new ItemStack(BotaniaHelper.itemPetal, 1, 11),
				new ItemStack(BotaniaHelper.itemManaPetal, 1, 3), new ItemStack(BotaniaHelper.itemManaPetal, 1, 9),
				new ItemStack(BotaniaHelper.itemManaPetal, 1, 11), new ItemStack(BotaniaHelper.itemManaPetal, 1, 11),
				new ItemStack(BotaniaHelper.itemManaResource, 1, ManaResource.REDSTONE_ROOT.ordinal())
			});
		BotaniaAPIDistanceHelper.entryHiveacynth = new BotaniaLexiconEntry(SubTileHiveacynth.NAME, BotaniaAPI.categoryFunctionalFlowers);
		BotaniaAPIDistanceHelper.entryHiveacynth.setLexiconPages(new LexiconPage[] {
				BotaniaAPI.internalHandler.textPage("magicbees.botania.lexicon.hiveacynth.0"),
				BotaniaAPI.internalHandler.textPage("magicbees.botania.lexicon.hiveacynth.1"),
				BotaniaAPI.internalHandler.petalRecipePage("magicbees.botania.lexicon.hiveacynth.crafting", hiveacynthRecipe)
			});
	}
}