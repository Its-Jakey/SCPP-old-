package main;

import compiler.Compiler;
import org.apache.commons.cli.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        Options options = new Options();

        Option inputOpt = new Option("i", "input", true, "Input file to compile");
        inputOpt.setRequired(true);
        Option outputOpt = new Option("o", "output", true, "Output file");
        outputOpt.setRequired(true);
        Option logOpt = new Option("l", "showLogs", false, "Show logs");

        options.addOption(inputOpt);
        options.addOption(outputOpt);
        options.addOption(logOpt);

        CommandLine cmd = null;
        CommandLineParser parser = new BasicParser();
        HelpFormatter helper = new HelpFormatter();

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            helper.printHelp("Usage:", options);
            System.exit(0);
        }


        String input = cmd.getOptionValue("i");
        String output = cmd.getOptionValue("o");

        Compiler.showLogs = cmd.hasOption("l");
        String asm = Compiler.compileTopLevel(new File(input));
        Files.writeString(Path.of(output), asm);
    }
}
