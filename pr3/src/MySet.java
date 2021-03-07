import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MySet<E> implements Set<E> {
    private static final Semaphore semaphore = new Semaphore(1);
    private final HashSet<E> hashSet;

    MySet() {
        hashSet = new HashSet<>();
    }

    @Override
    public int size() {
        int size = 0;

        try {
            semaphore.acquire();
            size = hashSet.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;

        try {
            semaphore.acquire();
            isEmpty = hashSet.isEmpty();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;

        try {
            semaphore.acquire();
            contains = hashSet.contains(o);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return contains;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = null;

        try {
            semaphore.acquire();
            iterator = hashSet.iterator();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert iterator != null;

        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[0];

        try {
            semaphore.acquire();
            arr = hashSet.toArray();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] arr = a;

        try {
            semaphore.acquire();
            arr = hashSet.toArray(a);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return arr;
    }

    @Override
    public boolean add(E e) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.add(e);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean remove(Object o) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.remove(o);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.containsAll(c);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.addAll(c);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.retainAll(c);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.removeAll(c);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            hashSet.clear();
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean flag = false;

        try {
            semaphore.acquire();
            flag = hashSet.equals(o);
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return flag;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        try {
            semaphore.acquire();
            hashCode = hashSet.hashCode();
            semaphore.release();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        return hashCode;
    }
}
