
package org.zhangge.compress;

public class Node {

	Byte value;//字符值
	int weight;//权重
	short code;//编码，0或1
	Node parent = null;
	Node lchild = null;
	Node rchild = null;
	
	public Node(Byte value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}
