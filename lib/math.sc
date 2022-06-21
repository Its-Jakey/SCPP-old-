namespace math {
    public func round(x, places) {
        _asm_("round", x, places);
        return _valueOfA_();
    }
    public func floor(x, places) {
        _asm_("floor", x, places);
        return _valueOfA_();
    }
    public func ceil(x, places) {
        _asm_("ceil", x, places);
        return _valueOfA_();
    }
    public func sin(x) {
        _asm_("sin", x);
        return _valueOfA_();
    }
    public func cos(x) {
        _asm_("cos", x);
        return _valueOfA_();
    }
    public func sqrt(x) {
        _asm_("sqrt", x);
        return _valueOfA_();
    }
    public func atan2(x, y) {
        _asm_("atan2", x, y);
        return _valueOfA_();
    }
    public func negate(x) {
        if (x > 0)
            return 0 - x;
        return x;
    }
    public func min(a, b) {
        if (a < b) {
            return a;
        }
        return b;
    }
    public func max(a, b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    public func inRange(x, a, b) {
        return x > a && x < b;
    }
    public func abs(x) {
        if (x < 0)
            return (0 - x);
        return x;
    }
}
