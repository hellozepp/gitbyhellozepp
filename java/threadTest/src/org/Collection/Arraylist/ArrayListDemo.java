package org.Collection.Arraylist;

/**
 * Created by Hello Zepp on 2016/7/31 0031.
 */
public interface ArrayListDemo<T> {
    /*
    * 接口定义要实现的几个功能
    * 2.add
    * 3.remove
    * 4.contains 是否存在数据
    * 5.isEmety是否为空
    * 6.size获得List长度
    * **/

    void add(T t);
//    void remove(int index);
//    void contains(int index,T t);
//    boolean isEmety();
//    int size();

}

class ArrayList<T> implements ArrayListDemo<T> {

    /*
    * 方法：
    * 构造器ArrayList（）
    *       ArrayList（int size）//自定义定长数组
    *       判断角标长度不能小于零
    *
    *       current=0（首次定义则初始化角标）
    *       初始化长度size
    *       初始化元素elements
    * 添加元素add(E e)
          * 判断当前容量confirmSize（）
                        *满足对elements赋值
                        * 不满足复制长度，复制内容
          *  thisDemo.elements[current] = e; 对数字当前角标复制
          *  current++
    * **/
    private static final int DEFAULT_SIZE = 10;
    /**
     * 当前下标
     */
    private int current;
    /**
     * 存储队列中的元素
     */
    private Object[] elements=null;
    /**
     *数组大小指针
     */
    private  int capacity;
    public ArrayList() {
        this(DEFAULT_SIZE);
    }
    public ArrayList(int size){
    if(size<0){
        throw new RuntimeException("数组长度不能小于0！");
    }else {
        //长度大于零则设置当前长度
        current=0;
        this.elements= new Object[size];
        capacity=size;
    }
    }
    @Override
    public void add(T t) {
        confirmSize();
        this.elements[current] = t;
        this.current++;
    }
    public void confirmSize(){
        if (this.capacity==this.current){
            this.capacity=this.capacity<<1;
            Object[] newElements = new Object[this.capacity];
            for (int i =0;i<this.elements.length;i++){
                newElements[i]=this.elements[i];
            }
            this.elements =newElements;
        }
    }
    public void remove(int index) {
        confirmIndex(index);
        for (int i = index; i < elements.length; i++) {
            if(i + 1 < elements.length){
                elements[i] = elements[i+1];
            }
        }
        current--;
    }
    /**
     * 判断下标是否越界
     */
    private void confirmIndex(int index){
        if(index > capacity || index < 0){
            throw new RuntimeException("下标越界");
        }
    }
    public void insert(int index,T t) {
        confirmIndex(index);
        for (int i = 0; i < elements.length; i++) {
            if(i >= index && i+2 < elements.length){
                elements[i] = t;
                elements[i+1] = elements[i+2];
            }
        }
        current++;
    }

    public boolean contains(Object o) {
        for (Object element : this.elements) {
            if(o.equals(element)){
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.current;
    }

    public boolean isEmpty() {
        if(this.current >0){
            return true;
        }
        return false;
    }
    public T get(int index) {
        confirmIndex(index);
        return (T) this.elements[index];
    }

}
