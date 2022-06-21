#include <graphics>
#include <math>
#include <time>
#include <input>
#include <strings>

#define nodeSize 8
#define FPS 30
#define LIST_SIZE 128

namespace edgeList {
    var idx = 0;
    public var values[LIST_SIZE];

    public func add(value) {
        values[idx] = value;
        idx += 1;
    }

    public func get(index) {
        return values[index];
    }

    public func set(index, value) {
        values[index] = value;
    }

    public func size() {
        return idx;
    }
}

namespace nodeList {
    var idx = 0;
    public var values[LIST_SIZE];

    public func add(value) {
        values[idx] = value;
        idx += 1;
    }

    public func get(index) {
        return values[index];
    }

    public func set(index, value) {
        values[index] = value;
    }

    public func size() {
        return idx;
    }
}

namespace cube3D {
    var edge_n = 0;

    public func drawLine3D(x0, y0, z0, x1, y1, z1) {
        nodeList::add(x0);
        nodeList::add(y0);
        nodeList::add(z0);
        nodeList::add(x1);
        nodeList::add(y1);
        nodeList::add(z1);

        edgeList::add(edge_n);
        edgeList::add(edge_n + 1);

        edge_n += 2;
    }

    public func drawCube3D(x, y, z, w, h, d) {
        nodeList::add(x);
        nodeList::add(y);
        nodeList::add(z);
        nodeList::add(x);
        nodeList::add(y);
        nodeList::add(z+d);
        nodeList::add(x);
        nodeList::add(y+h);
        nodeList::add(z);
        nodeList::add(x);
        nodeList::add(y+h);
        nodeList::add(z+d);
        nodeList::add(x+w);
        nodeList::add(y);
        nodeList::add(z);
        nodeList::add(x+w);
        nodeList::add(y);
        nodeList::add(z+d);
        nodeList::add(x+w);
        nodeList::add(y+h);
        nodeList::add(z);
        nodeList::add(x+w);
        nodeList::add(y+h);
        nodeList::add(z+d);

        edgeList::add(edge_n);
        edgeList::add(1 + edge_n);
        edgeList::add(1 + edge_n);
        edgeList::add(3 + edge_n);
        edgeList::add(3 + edge_n);
        edgeList::add(2 + edge_n);
        edgeList::add(2 + edge_n);
        edgeList::add(edge_n);
        edgeList::add(4 + edge_n);
        edgeList::add(5 + edge_n);
        edgeList::add(5 + edge_n);
        edgeList::add(7 + edge_n);
        edgeList::add(7 + edge_n);
        edgeList::add(6 + edge_n);
        edgeList::add(6 + edge_n);
        edgeList::add(4 + edge_n);
        edgeList::add(edge_n);
        edgeList::add(4 + edge_n);
        edgeList::add(1 + edge_n);
        edgeList::add(5 + edge_n);
        edgeList::add(2 + edge_n);
        edgeList::add(6 + edge_n);
        edgeList::add(3 + edge_n);
        edgeList::add(7 + edge_n);

        edge_n += 8;
    }

    public func rotate3D(theta, xMul, yMul, zMul) {
        var xSinTheta = math::sin(theta) * xMul;
        var xCosTheta = math::cos(theta) * xMul;

        var ySinTheta = math::sin(theta) * yMul;
        var yCosTheta = math::cos(theta) * yMul;

        var zSinTheta = math::sin(theta) * zMul;
        var zCosTheta = math::cos(theta) * zMul;

        for (i from 0 to nodeList::size() by 3) {
            var x = nodeList::values[i];
            var y = nodeList::values[i + 1];
            var z = nodeList::values[i + 2];

            x = (x * yCosTheta) + (z * ySinTheta);
            z = (z * yCosTheta) - (x * ySinTheta);

            y = (y * xCosTheta) - (z * xSinTheta);
            z = (z * xCosTheta) + (y * xSinTheta);

            x = (x * zCosTheta) - (y * zSinTheta);

            nodeList::set(i, x);
            nodeList::set(i + 1, (y * zCosTheta) + (x * zSinTheta));
            nodeList::set(i + 2, z);
        }
    }

    func draw() {
        graphics::clear();
        graphics::setColor(graphics::createColor(0, 0, 255));

        for (e from 0 to edgeList::size() by 2) {
            var n0 = edgeList::get(e) * 3;
            var n1 = edgeList::get(e + 1) * 3;

            graphics::drawLine(nodeList::get(n0), nodeList::get(n0 + 1), nodeList::get(n1), nodeList::get(n1 + 1));
        }
    }

    public func main(){
        drawCube3D(100, 100, 100, 100, 100, 100);
        //drawCube3D(150, 50, 150, 50, 50, 50);
        //drawLine3D(100, 100, 100, 200, 200, 200);
        var FPS = 0;

        while (1) {
            var start = time::getRuntimeMillis();

            rotate3D(1, 1, 1, 1);
            draw();

            graphics::drawString(strings::join("FPS: ", math::round(FPS, 2)));
            graphics::flip();

            var end = time::getRuntimeMillis();
            var frameTime = end - start;
            FPS = (1000 / frameTime);
        }
    }

}

