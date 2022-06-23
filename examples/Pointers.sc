

namespace pointers {
    public func main() {
        var numbers = {1, 2, 3, 4, 5};
        *(numbers + 2) = 6;

        for (number from numbers to numbers + 5) {
            println(*number);
        }
    }
}