package com.hm.achievement.category;

/**
 * List of multiple achievements, ie. with sub-categories
 * 
 * @author Pyves
 *
 */
public enum MultipleAchievements {

	PLACES("Places", "Blocks Placed", "When a specific block is placed (specify material name, lower case).", "blockid"),
	BREAKS("Breaks", "Blocks Broken", "When a specific block is broken (specify material name, lower case).", "blockid"),
	KILLS("Kills", "Entities Killed", "When a specific mob is killed (specify an entity name or poweredcreeper or player, lower case).", "mobname"),
	CRAFTS("Crafts", "Items Crafted", "When a specific item is crafted (specify material name, lower case).", "item"),
	PLAYERCOMMANDS("PlayerCommands", "Commands Entered", "When a player enters a specific command (specify command prefixes in lower case without spaces).", "command");

	private final String categoryName;
	private final String langDefault;
	private final String configComment;
	private final String subcategoryDBName;

	private MultipleAchievements(String categoryName, String langDefault, String configComment,
			String subcategoryName) {

		this.categoryName = categoryName;
		this.langDefault = langDefault;
		this.configComment = configComment;
		this.subcategoryDBName = subcategoryName;
	}

	@Override
	public String toString() {

		return categoryName;
	}

	/**
	 * Converts to database name: name of the enum in lower case.
	 * 
	 * @param type
	 * @return
	 */
	public String toDBName() {

		return name().toLowerCase();
	}

	/**
	 * Converts to permission name: common prefix + name of the category in lower case.
	 * 
	 * @param type
	 * @return
	 */
	public String toPermName() {

		return "achievement.count." + categoryName.toLowerCase();
	}

	/**
	 * Converts to the key in the language file used in the list command.
	 * 
	 * @param type
	 * @return
	 */
	public String toLangName() {

		return "list-" + name().toLowerCase();
	}

	/**
	 * Converts to the default name that appears in the list command, if not found in the configuration.
	 * 
	 * @param type
	 * @return
	 */
	public String toLangDefault() {

		return langDefault;
	}

	/**
	 * Converts to the comment that is inserted about the category name in the configuration file.
	 * 
	 * @param type
	 * @return
	 */
	public String toConfigComment() {

		return configComment;
	}

	/**
	 * Converts to the name of the column name containing the subcategory information in the database.
	 * 
	 * @param type
	 * @return
	 */
	public String toSubcategoryDBName() {

		return subcategoryDBName;
	}
}
