

namespace input {
    public func mouseX() {
        _asm_("mouseX");
        return _valueOfA_();
    }
    public func mouseY() {
        _asm_("mouseY");
        return _valueOfA_();
    }
    public func isMouseDown() {
        _asm_("mouseDown");
        return _valueOfA_();
    }
    public func isKeyPressed(key) {
        _asm_("isKeyPressed", key);
        return _valueOfA_();
    }
    public func ask(message) {
        _asm_("ask", message);
        return _valueOfA_();
    }
}
