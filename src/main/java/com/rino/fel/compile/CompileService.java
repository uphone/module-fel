package com.rino.fel.compile;

import com.rino.fel.Expression;
import com.rino.fel.context.FelContext;
import com.rino.fel.parser.FelNode;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CompileService {

    private com.rino.fel.compile.SourceGenerator srcGen;
    private com.rino.fel.compile.FelCompiler complier;

    public com.rino.fel.compile.SourceGenerator getSrcGen() {
        return srcGen;
    }

    public void setSrcGen(com.rino.fel.compile.SourceGenerator srcGen) {
        this.srcGen = srcGen;
    }

    public com.rino.fel.compile.FelCompiler getComplier() {
        return complier;
    }

    public void setComplier(com.rino.fel.compile.FelCompiler complier) {
        this.complier = complier;
    }

    {
        srcGen = new com.rino.fel.compile.SourceGeneratorImpl();
        String name = getCompilerClassName();
        com.rino.fel.compile.FelCompiler comp = newCompiler(name);
        complier = comp;
    }

    public static List<String> getClassPath(ClassLoader cl) {
        List<String> paths = new ArrayList<String>();
        while (cl != null) {
            boolean isUrlClassloader = cl instanceof URLClassLoader;
            if (isUrlClassloader) {
                URLClassLoader urlClassLoader = (URLClassLoader) cl;
                for (URL url : urlClassLoader.getURLs()) {
                    paths.add(url.getFile());
                }
            } else {
                Enumeration<URL> resources = null;
                try {
                    resources = cl.getResources("/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (resources != null) {
                    while (resources.hasMoreElements()) {
                        URL resource = resources.nextElement();
                        paths.add(resource.getFile());
                    }
                }
            }
            cl = cl.getParent();
        }
        return paths;
    }

    private com.rino.fel.compile.FelCompiler newCompiler(String name) {
        com.rino.fel.compile.FelCompiler comp = null;
        try {
            @SuppressWarnings("unchecked")
            Class<com.rino.fel.compile.FelCompiler> cls = (Class<com.rino.fel.compile.FelCompiler>) Class.forName(name);
            comp = cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
        return comp;
    }

    private String getCompilerClassName() {
        String version = System.getProperty("java.version");
        String compileClassName = com.rino.fel.compile.FelCompiler.class.getName();
        compileClassName += "16";
        return compileClassName;
    }

    public Expression compile(FelContext ctx, FelNode node, String originalExp) {
        try {
            com.rino.fel.compile.JavaSource src = srcGen.getSource(ctx, node);
            if (src instanceof com.rino.fel.compile.ConstExpSrc) {
                com.rino.fel.compile.ConstExpSrc s = (com.rino.fel.compile.ConstExpSrc) src;
                return s.getValue();
            }
            src.setSource("// 表达式:" + originalExp + "\n" + src.getSource());
            // System.out.println("****************\n" + src.getSource());
            return complier.compile(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().list(System.out);
    }

}
