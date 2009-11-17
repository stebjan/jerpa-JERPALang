package ch.ethz.origo.jerpa.jerpalang;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * 
 * @author Vaclav Souhrada (v.souhrada@gmail.com)
 * @version 0.1.0 09/15/09
 * @since 0.1.0
 */
public class LangUtils {

	public static final String MAIN_FILE_PATH = "ch.ethz.origo.jerpa.jerpalang.JERPA";

	public static String[] getListOfLanguage() {
		return LangUtils.loadProperties(LangUtils.MAIN_FILE_PATH).getProperty(
				"menu.language.item").trim().split(",");
	}

	/**
	 * Load properties
	 * 
	 * @throws PropertiesException
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

}
