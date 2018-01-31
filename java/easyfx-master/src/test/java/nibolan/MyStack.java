package nibolan;

class MyStack<T> {
    private Entry<T> top = new Entry<T>(null, null);  
    private int size;  
  
    public MyStack() {  
        top.next = null;  
        top.element = null;  
    }  
  
    // 进栈  
    public MyStack<T> push(T t) {  
        Entry<T> node = new Entry<T>(top.next, t);  
        top.next = node;  
        size++;  
        return this;  
    }  
  
    // 出栈  
    public T pop() {  
        if (size == 0) {  
            return null;  
        }  
        Entry<T> t = top.next;  
        Entry<T> foo = top.next.next;  
        top.next = foo;  
        foo = null;  
        size--;  
        return t.element;  
    }  
//得到栈顶元素  
    public T top() {  
        return top.next.element;  
    }  
  
    public int size() {  
        return size;  
    }  
}  
  
// 元素节点  
class Entry<T> {  
    T element;  
    Entry<T> next;  
  
    Entry(Entry<T> next, T e) {  
        this.element = e;  
        this.next = next;  
    }  
}  