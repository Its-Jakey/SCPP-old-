namespace strings {
    public func charAt(string, idx) {
        _asm_("charAt", string, idx);
        return _valueOfA_();
    }
    public func sizeOf(string) {
        _asm_("sizeOf", string);
        return _valueOfA_();
    }
    public func contains(string, x) {
        _asm_("contains", string, x);
        return _valueOfA_();
    }
    public func join(a, b) {
        _asm_("loadAtVar", a, "join", b);
        return _valueOfA_();
    }
    public func substring(string, start, end) {
        var ret = "";
        var i = start;

        while (i < end) {
            ret = join(ret, charAt(string, i));
        }
        return ret;
    }
    public func repeat(string, times) {
        var ret = "";

        for (i from 0 to times)
            ret = join(ret, string);
        return ret;
    }
    public func indexOfChar(string, char) {
        _asm_("indexOfChar", string, char);
        return _valueOfA_();
    }
}
