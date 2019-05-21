package function;

/*
 * 哈夫曼节点类
 */
public class HuffmNode {
	//数据域
	private int data;
	//索引
	private int index;
	//左子节点
	private HuffmNode left;
	//右子节点
	private HuffmNode right;
	
	//哈夫曼节点的构造函数
	public HuffmNode(int data,int index){
		this.data=data;
		this.index=index;
	}
	
	//私有属性的封装
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public HuffmNode getLeft() {
		return left;
	}
	public void setLeft(HuffmNode left) {
		this.left = left;
	}
	public HuffmNode getRight() {
		return right;
	}
	public void setRight(HuffmNode right) {
		this.right = right;
	}
 
}