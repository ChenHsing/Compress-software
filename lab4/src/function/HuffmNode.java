package function;

/*
 * �������ڵ���
 */
public class HuffmNode {
	//������
	private int data;
	//����
	private int index;
	//���ӽڵ�
	private HuffmNode left;
	//���ӽڵ�
	private HuffmNode right;
	
	//�������ڵ�Ĺ��캯��
	public HuffmNode(int data,int index){
		this.data=data;
		this.index=index;
	}
	
	//˽�����Եķ�װ
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