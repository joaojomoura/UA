/**
 * 
 */
package aula13.ex2;
import java.io.File;
import java.util.ArrayList; 
import java.util.Iterator;
/**
 * @author João Moura
 *
 */

abstract class PluginManager {
	public static IPlugin load(String name) throws Exception {
		Class<?> c = Class.forName(name);
		return (IPlugin) c.getDeclaredConstructor().newInstance(); }
}


public class Plugin {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File proxyList = new File("src/aula13/ex2/plugins"); 
		ArrayList<IPlugin> plgs = new ArrayList<IPlugin>(); 
		
		for (String f: proxyList.list()) {
			try { plgs.add(PluginManager.load("aula13.ex2.plugins."+f.substring(0,f.lastIndexOf('.'))));
			}
			catch (Exception e) { 
				e.printStackTrace();
			} 
		}
		Iterator<IPlugin> it = plgs.iterator(); 
		while (it.hasNext()) {
			it.next().fazQualQuerCoisa(); 
			}
		}

}


