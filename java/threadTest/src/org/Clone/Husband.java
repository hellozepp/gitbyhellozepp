package org.Clone;
/**浅克隆
 *
 *(1)浅克隆（shallow clone），浅拷贝是指拷贝对象时仅仅拷贝对象本身和对象中的基本变量，而不拷贝对象包含的引用指向的对象。
 (2)深克隆（deep clone），深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。

 举例区别一下：对象A1中包含对B1的引用，B1中包含对C1的引用。浅拷贝A1得到A2，A2中依然包含对B1的引用，B1中依然包含对C1的引用。
 深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2中包含对C2（C1的copy）的引用。
 * */
public class Husband implements Cloneable {
    private int id;
    private Wife wife;

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Husband(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {//myeclipse自动生成的
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Husband husband = (Husband) super.clone();
        husband.wife = (Wife) husband.getWife().clone();
        return husband;
    }

    @Override
    public boolean equals(Object obj) {//myeclipse自动生成的
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Husband other = (Husband) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Wife wife = new Wife(1,"jin");
        Husband husband = new Husband(1);
        Husband husband2 = null;
        husband.setWife(wife);
        husband2 = (Husband) husband.clone();
        System.out.println("husband class same="+(husband.getClass()==husband2.getClass()));//true
        System.out.println("husband object same="+(husband==husband2));//false
        System.out.println("husband object equals="+(husband.equals(husband)));//true
        System.out.println("wife class same="+(husband.getWife().getClass()==husband2.getWife().getClass()));//true
        System.out.println("wife object same="+(husband.getWife()==husband2.getWife()));//false
        System.out.println("wife object equals="+(husband.getWife().equals(husband.getWife())));//true
    }
}
//
//
//
///**深克隆*/
//public class Husband implements Cloneable {
//    private int id;
//    private Wife wife;
//
//    public Wife getWife() {
//        return wife;
//    }
//
//    public void setWife(Wife wife) {
//        this.wife = wife;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Husband(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public int hashCode() {//myeclipse自动生成的
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + id;
//        return result;
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//    @Override
//    public boolean equals(Object obj) {//myeclipse自动生成的
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Husband other = (Husband) obj;
//        if (id != other.id)
//            return false;
//        return true;
//    }
//
//    /**
//     * @param args
//     * @throws CloneNotSupportedException
//     */
//    public static void main(String[] args) throws CloneNotSupportedException {
//        Wife wife = new Wife(1,"jin");
//        Husband husband = new Husband(1);
//        Husband husband2 = null;
//        husband.setWife(wife);
//        husband2 = (Husband) husband.clone();
//        System.out.println("husband class same="+(husband.getClass()==husband2.getClass()));//true
//        System.out.println("husband object same="+(husband==husband2));//false
//        System.out.println("husband object equals="+(husband.equals(husband)));//true
//        System.out.println("wife class same="+(husband.getWife().getClass()==husband2.getWife().getClass()));//true
//        System.out.println("wife object same="+(husband.getWife()==husband2.getWife()));//true
//        System.out.println("wife object equals="+(husband.getWife().equals(husband.getWife())));//true
//    }
//}