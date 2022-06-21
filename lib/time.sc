 
namespace time {
    public func sleep(millis) {
        _asm_("sleep", millis);
    }
    public func getRuntimeMillis() {
        _asm_("runtimeMillis");
        return _valueOfA_();
    }
}
