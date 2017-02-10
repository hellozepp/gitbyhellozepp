package wl.zl.luyouhongfan;
import java.util.HashSet;
import java.util.Set;

public class Node {

    // 结点名称
    private String name;
    // 是否结束节点
    private boolean isEnd = false;
    private Set<Node> relativeNodes = new HashSet<Node>();

    public Node(String name) {
        this.name = name;
    }

    public void link(Node... nodes) {
        for (Node node : nodes) {
            this.relativeNodes.add(node);
            node.getRelativeNodes().add(this);
        }
    }

    public Set<Node> getRelativeNodes() {
        return relativeNodes;
    }

    public void accept(Packet packet) {
        // 记录当前节点
           packet.getRoute().add(this.name);

        // 如果计数器仍然等于零 或 当前节点已经是最终节点，则打印路由信息
        // 否则继续传输，否则输出报文传输路径
        if (this.isEnd) {
            System.out.println("传输成功: " + packet);

        } else if (packet.getTTL() == 0) {
            System.out.println("传输失败，已超出生命周期: " + packet);

        } else {
            packet.decrement();
            boolean isAvailableNodeExist = false;
            for (Node nextNode : relativeNodes) {
                if (!packet.getRoute().contains(nextNode.getName())) {//节点未在路由表中（不是重复路径）
                    isAvailableNodeExist = true;
                    nextNode.accept(packet.clone());
                }
            }
            if (!isAvailableNodeExist) {
                System.out.println("传输失败，无法找到下一结点: " + packet);
            }
        }
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public String getName() {
        return this.name;
    }

}