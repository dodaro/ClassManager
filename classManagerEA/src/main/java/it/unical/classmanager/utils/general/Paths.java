package it.unical.classmanager.utils.general;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * Static class that contains all the path of the various environments
 * 
 * @author sera
 *
 */
public class Paths {
	
	private static String sep = File.separator;

	public static String root = FileSystemView.getFileSystemView().getHomeDirectory().toString()+sep;
	
	public static String workspace = root + "EACompilerWorkspace"+sep;
	
	public static String environments = workspace + "environments"+sep;
	
	//cpp environments
	public static String cppEnvironment = environments + "cppEnv"+sep;
	
	
	//java environments
	public static String javaEnvironment = environments + "javaEnv"+sep;
	
}
