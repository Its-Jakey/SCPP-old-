package compiler;

import java.util.HashMap;

public class Namespace {
    private final HashMap<String, Variable> variables = new HashMap<>();
    private final HashMap<String, Method> methods = new HashMap<>();
    private final String name;
    public boolean isSystemLibrary = false;

    public Namespace(String name) {
        this.name = name;
    }


    public void addVariable(String name, Variable variable) {
        variables.put(name, variable);
    }

    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }

    public Variable getVariable(String name) {
        return variables.get(name);
    }

    public void addMethod(String name, Method method) {
        methods.put(name, method);
    }

    public boolean hasMethod(String name) {
        return methods.containsKey(name);
    }

    public Method getMethod(String name) {
        return methods.get(name);
    }

    public String getName(){
        return name;
    }
}
