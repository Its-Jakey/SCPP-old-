package compiler;

import antlr.CParser;

import java.util.Objects;

public final class ValueOrOperatorOrID {
    private final CParser.ValueContext value;
    private final String operator;
    private String id = null;

    public ValueOrOperatorOrID(CParser.ValueContext value, String operator) {
        this.value = value;
        this.operator = operator;
    }

    public CParser.ValueContext value() {
        return value;
    }

    public String operator() {
        return operator;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ValueOrOperatorOrID) obj;
        return Objects.equals(this.value, that.value) &&
                Objects.equals(this.operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, operator);
    }

    @Override
    public String toString() {
        return "ValueOrOperatorOrID[" +
                "value=" + (value == null ? null : value.getText()) + ", " +
                "operator=" + operator + ", " +
                "id=" + id + "]";
    }
}
