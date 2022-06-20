package main;

import compiler.Compiler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    private static void tmp(){
        String listName = "edgeList";
        String tmp = """
                [0, 1, 1, 3, 3, 2, 2, 0, 4, 5, 5, 7, 7, 6, 6, 4, 0, 4, 1, 5, 2, 6, 3, 7]""".replaceAll(" ", "").replaceAll("\n", "").replaceAll("\\[", "").replaceAll("]", "");
        int i = 0;
        StringBuilder ret = new StringBuilder();

        for (String s : tmp.split(",")) {
            ret.append("\n").append(listName).append("::add(").append(s).append(");");

            i++;
        }
        System.out.println(ret.substring(1));

    }

    private static void tmp2() {
        String input = """
                wire(size/2, size/2, size/2, -size/2, size/2, size/2);
                wire(size/2, -size/2, size/2, -size/2, -size/2, size/2);
                wire(size/2, size/2, size/2, size/2, -size/2, size/2);
                wire(-size/2, size/2, size/2, -size/2, -size/2, size/2);
                wire(size/2, size/2, -size/2, -size/2, size/2, -size/2);
                wire(size/2, -size/2, -size/2, -size/2, -size/2, -size/2);
                wire(size/2, size/2, -size/2, size/2, -size/2, -size/2);
                wire(-size/2, size/2, -size/2, -size/2, -size/2, -size/2);
                wire(size/2, size/2, size/2, size/2, size/2, -size/2);
                wire(size/2, -size/2, size/2, size/2, -size/2, -size/2);
                wire(-size/2, -size/2, size/2, -size/2, -size/2, -size/2);
                wire(-size/2, size/2, size/2, -size/2, size/2, -size/2);""".replaceAll("-size", "negSize");

        System.out.println("var negSize = math::negate(size);\n" + input);
    }

    private static void test(double x, double y, double z) {
        double screenWidth = 480, screenHeight = 360;
        double angleH = Math.toRadians(Math.atan2(x, y)), angleV = Math.toRadians(Math.atan2(z, x));
        //System.out.println(Math.atan2(x, y) + ", " + Math.atan2(z, x) + ", " + Math.cos(0));
        double fov = Math.PI / 2;

        System.out.println(angleH + ", " + angleV + ", " + (Math.round(Math.cos(angleH) * 1000) / 1000) + ", " + Math.cos(angleV));

        angleH /= Math.abs(Math.cos(angleH));
        angleV /= Math.abs(Math.cos(angleV));

        double pointX = screenWidth / 2 - angleH * screenWidth / fov;
        double pointY = screenHeight / 2 - angleV * screenWidth / fov;

        System.out.println((Math.round(pointX * 1000) / 1000) + ", " + (Math.round(pointY * 1000) / 1000) + ", " + (Math.round(angleH * 1000) / 1000) + ", " + (Math.round(angleV * 1000) / 1000));
    }

    public static void main(String[] args) throws Exception {
        //test(100, 0, 0);
        //tmp2();

        if (args.length != 2) {
            System.err.println("2 arguments were expected (input file, output file), got " + args.length + " instead.");
            System.exit(1);
        }


        //tmp();
        String asm = Compiler.compileTopLevel(new File(args[0]));
        Files.writeString(Path.of(args[1]), asm);
    }
}
