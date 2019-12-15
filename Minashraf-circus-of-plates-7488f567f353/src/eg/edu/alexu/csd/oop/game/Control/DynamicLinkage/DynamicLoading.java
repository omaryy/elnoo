package eg.edu.alexu.csd.oop.game.Control.DynamicLinkage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

//TODO 3ayzin nezawed bomb tewa2a3 awel taba2
//TODO clown w el barObject mn 3and folder Omar
public class DynamicLoading {
    List<Class<?>> Classes=new ArrayList<>();
    public List<Class<?>> load()
    {
            File Folder=new File("Lib");
            File[] Files=Folder.listFiles();
            for(File i:Files)
                Load(i);
            return Classes;
    }
    private void Load(File jar)
    {
        try {
            JarFile jarFile = new JarFile(jar);
            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = { new URL("jar:file:" + jar + "!/") };
            URLClassLoader cl = URLClassLoader.newInstance(urls);
            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                Class c = cl.loadClass(className);
                Classes.add(c);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
