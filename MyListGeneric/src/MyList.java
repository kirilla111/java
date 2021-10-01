import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
    private MyNode<T> l_guard;
    private MyNode<T> r_guard;
    private MyNode<T> last_node;
    private Iterator iterator;
    private MyNode<T> iterator_node;

    public MyList() {
        r_guard = new MyNode<T>(null, null, null);
        l_guard = new MyNode<T>(null, null, null);

        r_guard.setLeftLink(l_guard);
        l_guard.setRightLink(r_guard);

        iterator_node = l_guard;
        last_node = l_guard;

        this.iterator = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator_node.next() != r_guard;
            }

            @Override
            public T next() {
                iterator_node = iterator_node.next();
                return iterator_node.getData();
            }
        };
    }


    public void add(T data) {
        MyNode<T> node = new MyNode<>(last_node, r_guard, data);
        last_node.setRightLink(node);
        r_guard.setLeftLink(node);
        last_node = node;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }

    private class MyNode<T> {
        private MyNode<T> l;
        private MyNode<T> r;
        private T data;

        public MyNode(MyNode<T> l, MyNode<T> r, T data) {
            this.l = l;
            this.r = r;
            this.data = data;
        }

        public void setLeftLink(MyNode<T> l) {
            this.l = l;
        }

        public void setRightLink(MyNode<T> r) {
            this.r = r;
        }

        public MyNode<T> next() {
            return r;
        }

        public T getData() {
            return this.data;
        }
    }

}
