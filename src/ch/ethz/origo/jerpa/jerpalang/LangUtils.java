/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *  
 *    Copyright (C) 2009 - 2010 
 *    							University of West Bohemia, 
 *                  Department of Computer Science and Engineering, 
 *                  Pilsen, Czech Republic
 */
package ch.ethz.origo.jerpa.jerpalang;

import java.io.IOException;
import java.util.Properties;

/**
 * Contains many of methods for work with language. Next contains important language 
 * constants.
 * 
 * @author Vaclav Souhrada (v.souhrada at gmail.com)
 * @version 0.1.2 (4/17/2010)
 * @since 0.1.0 (09/15/09)
 */
public class LangUtils {

	/** PATH to the main package where are language files saved */
	public static final String MAIN_FILE_PATH = "ch.ethz.origo.jerpa.jerpalang.JERPA";
	/** Path to the main Language properties file */
	public static final String JERPA_LANG_FILE = "ch/ethz/origo/jerpa/jerpalang/JERPA_LANGUAGE.properties";
	/** Path for perspective Signal Processing */
	public static final String SIGNAL_PERSP_LANG_FILE_KEY = "perspective.signalprocessing.lang"; 
	/** Path to the JERPA errors files */
	public static final String JERPA_ERROR_LIST_PATH = "ch.ethz.origo.jerpa.jerpalang.jerpa-errors";

	/**
	 * Return list of the supported languages
	 * @return list of the supported languages
	 */
	public static String[] getListOfLanguage() {
		return LangUtils.loadProperties(LangUtils.MAIN_FILE_PATH).getProperty(
				"menu.language.item").trim().split(",");
	}

	/**
	 * Load properties
	 * 
	 * @throws PropertiesException properties can not be loaded or not found
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	public static java.util.Properties loadProperties(String path) {
		Properties properties = new Properties();
		try {
			properties.load(ClassLoader.getSystemResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
		/**
		 * Return property from the main Language properties file by given name
		 * @param propertyName name of property - name of key
		 * @return property from the main Language properties file by given name
		 */
	public static String getPerspectiveLangPathProp(String propertyName) {
		return LangUtils.loadProperties(LangUtils.JERPA_LANG_FILE).getProperty(propertyName);
	}
	
	/**
	 * Only for testing this class
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getPerspectiveLangPathProp("perspective.signalprocessing.lang"));
	}

}