package wl.zl.luyouhongfan;

import java.util.ArrayList;
import java.util.List;

/**
 * 报文
 */
class Packet implements Cloneable {

    // 计数器
    private int TTL;
    // 传输路径
    private ArrayList<String> route = new ArrayList<String>();

    public Packet(int TTL) {
        this.TTL = TTL;
    }

    public int getTTL() {
        return TTL;
    }

    public List<String> getRoute() {
        return route;
    }

    public void decrement() {
        this.TTL = this.TTL - 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Packet clone() {
        Packet result = null;
        try {
            result = (Packet) super.clone();
            result.route = (ArrayList<String>) this.route.clone();//把当前传输路径表克隆一份表示该节点路由表
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("报文的传输路径为: %s", route);
    }

}
