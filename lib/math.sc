namespace math {
    public func round(x, dec) {
        _asm_("round", x, dec);
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
    func int(x) {
        return round(x - 1, 0);
    }
    public func bitwiseAnd(a, b) {
        var curA = a;
        var curB = b;
        var result = 0;
        var n = 1;

        while ((curA > 0) && (curB > 0)) {
            if ((int(curA % 2) == 1) && (int(curB % 2) == 1))
            result += n;
            curA = int(a / 2);
            curB = int(b / 2);
            n = n * 2;
        }
    }
}
