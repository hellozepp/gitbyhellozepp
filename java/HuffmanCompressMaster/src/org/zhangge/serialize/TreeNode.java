/**  
 * @Title: TreeNode.java 
 * @Package org.zhangge 
 * @Description: TODO
 * @author zhgeaits@gmail.com
 * @date 2012-11-12 下午06:08:36 
 * @version V1.0
*/ 
package org.zhangge.serialize;


/**
 * @project TreeSerialization
 * @file org.zhangge.TreeNode.java
 * @author zhangge
 * @email zhgeaits@gmail.com
 * @date 2012-11-12
 * @description
 *
 *
 */

public class TreeNode {

	private TreeNode[] childrens;
	private String values = "张戈";
	private Integer id = 27;

	/**
	 * @return the childrens
	 */
	public TreeNode[] getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens the childrens to set
	 */
	public void setChildrens(TreeNode[] childrens) {
		this.childrens = childrens;
	}

	/**
	 * @return the values
	 */
	public String getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(String values) {
		this.values = values;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
