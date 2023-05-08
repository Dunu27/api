package utility.externalFileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import utility.Iconstants;


public class PropertyUtility {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	Properties p=null;
	/**
	 * This constructor will  internally call initialize()
	 */
	public PropertyUtility() {
		initialize();
	}
	/**
	 * This generic method will initialize and load the property file
	 */
	private void initialize() {

		try {
			fis=new FileInputStream(Iconstants.filePath);
			p=new Properties();
			p.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This generic method will initialize the FileOutputStream instance
	 */
	public void set() {
		try {
			fos=new FileOutputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
/**
 * This generic method will get the data from the property file using Key
 * @param key
 * @return
 */
	public String getPropertyData(String key) {				
		String data=p.getProperty(key).trim();
		return data;
	}
	/**
	 * This generic method will set the data in the property file
	 * @param key
	 * @param value
	 */
	public void setPropertyData(String key,String value) {
		p.setProperty(key, value);
	       try {
			p.store(fos, " New Data Added ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}


