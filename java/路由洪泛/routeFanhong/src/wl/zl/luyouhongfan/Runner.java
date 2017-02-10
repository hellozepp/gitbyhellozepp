package wl.zl.luyouhongfan;

//     最终是整个拓朴图的组织及模拟报文传递：
class Runner {

    public static void main(String[] args) {

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        Node node9 = new Node("9");
        Node node10 = new Node("10");

        node1.link(node2, node3, node6);
        node2.link(node3, node10);
        node4.link(node6);
        node5.link(node6);
        node6.link(node8);
        node7.link(node8);
        node8.link(node9, node10);

        // 设置节点7为终止结点
        node7.setEnd(true);
        // 从节点1出发，尝试跳跃次数为3
        node1.accept(new Packet(3));
    }

}