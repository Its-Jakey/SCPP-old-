#include <errors>

namespace lists {
    public func new(maxItems, itemSize) {
        var list = malloc((maxItems * itemSize) + 3);
        ~(list + 1) = maxItems;
        ~(list + 2) = itemSize;

        return list;
    }

    public func get(list, index) {
        if ((index > ~list) || (index < 0))
            errors::throw(concat("List index ", index, " out of bounds for length ", ~list));

        var itemSize = ~(list + 2);
        if (itemSize == 1)
            return ~(list + 3 + index);

        var ret = malloc(itemSize);
        var i = 0;
        var end = (list + 3 + index + itemSize);

        for (item from (list + 3 + index) to end) {
            ~(ret + i) = ~item;
            i++;
        }
        return ret;
    }

    public func add(list, item) {
        if ((~list) == ~(list + 1))
            errors::throw("Cannot add item to list, list is full.");

        var itemSize = ~(list + 2);
        if (itemSize == 1) {
            ~(list + 3 + ~list) = item;
            ~list = ~(list) + 1;
            println(~list);
            return;
        }

        var i = 0;
        var end = ~(list + 3 + ((~list) * (itemSize + 1)));

        for (idx from ~(list + 3 + ((~list) * itemSize)) to end) {
            ~idx = ~(item + i);
            i++;
        }
        ~list = ~list + 1;
    }

    public func sizeOf(list) {
        return ~list;
    }

    public func maxSizeOf(list) {
        return ~(list + 1);
    }
}
