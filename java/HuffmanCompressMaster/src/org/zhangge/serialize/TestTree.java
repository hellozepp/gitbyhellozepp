/**  
 * @Title: TestTree.java 
 * @Package org.zhangge 
 * @Description: TODO
 * @author zhgeaits@gmail.com
 * @date 2012-11-12 下午06:14:57 
 * @version V1.0
*/ 
package org.zhangge.serialize;

/**
 * @project TreeSerialization
 * @file org.zhangge.TestTree.java
 * @author zhangge
 * @email zhgeaits@gmail.com
 * @date 2012-11-12
 * @description
 *
 *
 */

public class TestTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		
		TreeOutputStream tos = new TreeOutputStream("/home/zhangge/testtree");
		tos.writeTree(tree);
		
		TreeInputStream tis = new TreeInputStream("/home/zhangge/testtree");
		TreeNode tree0 = tis.readTree();
		System.out.println(tree);
	}
}
