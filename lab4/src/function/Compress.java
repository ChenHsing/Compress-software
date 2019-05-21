package function;

import java.io.FileInputStream;



import java.io.FileOutputStream;

import java.util.LinkedList;

public class Compress {

	public int[] times = new int[256];
	public String[] HuffmCodes = new String[256];
	public LinkedList<HuffmNode> list = new LinkedList<HuffmNode>();
	// ͳ�ƴ���

	// ��ʼ��
	public Compress() {
		for (int i = 0; i < HuffmCodes.length; i++) {
			HuffmCodes[i] = "";
		}
	}

	public void countTimes(String path) throws Exception {
		// �����ļ�������
		FileInputStream fis = new FileInputStream(path);
		// ��ȡ�ļ�
		int value = fis.read();
		while (value != -1) {
			times[value]++;
			value = fis.read();
		}
		// �ر���
		fis.close();
	}

	// �����������
	public HuffmNode createTree() {
		// ��������ΪȨֵ����ɭ��
		for (int i = 0; i < times.length; i++) {
			if (times[i] != 0) {
				HuffmNode node = new HuffmNode(times[i], i);
				// ������õĽڵ���뵽�����е���ȷλ��
				list.add(getIndex(node), node);
			}
		}

		// ��ɭ�֣������еĸ����ڵ㣩����ɹ�������
		while (list.size() > 1) {
			// ��ȡ�����е�һ��Ԫ�أ�Ȩֵ��С�Ľڵ㣩
			HuffmNode firstNode = list.removeFirst();
			// ��ȡ���µĵ�һ��Ԫ�أ�ԭ���ĵ�һ��Ԫ���Ѿ����Ƴ��ˣ�Ȩֵ��С�Ľڵ㣩
			HuffmNode secondNode = list.removeFirst();
			// ��Ȩֵ��С�������ڵ㹹��ɸ��ڵ�
			HuffmNode fatherNode = new HuffmNode(firstNode.getData() + secondNode.getData(), -1);
			fatherNode.setLeft(firstNode);
			fatherNode.setRight(secondNode);
			// ���ڵ���뵽�����е���ȷλ��
			list.add(getIndex(fatherNode), fatherNode);
		}
		// �����������ĸ��ڵ�
		return list.getFirst();
	}

	// ����ǰ�������ȡ�����
	public void getHuffmCode(HuffmNode root, String code) {
		// �����ߣ������������0
		if (root.getLeft() != null) {
			getHuffmCode(root.getLeft(), code + "0");
		}
		// �����ߣ������������1
		if (root.getRight() != null) {
			getHuffmCode(root.getRight(), code + "1");
		}
		// �����Ҷ�ӽڵ㣬���ظ�Ҷ�ӽڵ�Ĺ���������
		if (root.getLeft() == null && root.getRight() == null) {
			// System.out.println(root.getIndex()+"�ı���Ϊ��"+code);
			HuffmCodes[root.getIndex()] = code;
		}
	}

	// ѹ���ļ�
	public void compress(String path, String destpath) throws Exception {

		// �����ļ������
		FileOutputStream fos = new FileOutputStream(destpath);
		FileInputStream fis = new FileInputStream(path);
		/** ===============�����д���ļ�================ */
		// �����������������Լ�ÿ������ĳ���д���ļ�
		String code = "";
		for (int i = 0; i < 256; i++) {
			fos.write(HuffmCodes[i].length());
			code += HuffmCodes[i];
			fos.flush();
		}
		// �ѹ���������д���ļ�

		// System.out.println("code="+code);
		String str1 = "";
		while (code.length() >= 8) {
			str1 = code.substring(0, 8);
			int c = changeStringToInt(str1);
			// System.out.println(c);
			fos.write(c);
			fos.flush();
			code = code.substring(8);
		}
		// �������һ����Ϊ8����
		int last = 8 - code.length();
		for (int i = 0; i < last; i++) {
			code += "0";
		}
		str1 = code.substring(0, 8);
		int c = changeStringToInt(str1);
		fos.write(c);
		fos.flush();

		/** ===============������д�뵽�ļ���================ */

		// ���ļ���������Ӧ�Ĺ��������봮�ӳ��ַ���
		int value = fis.read();
		String str = "";
		while (value != -1) {
			str += HuffmCodes[value];
			// System.out.println((char)value+":"+str);
			value = fis.read();
		}
		System.out.println(str);
		fis.close();

		String s = "";
		// ���ַ�8λ�ָ����һ���ֽ�
		while (str.length() >= 8) {
			s = str.substring(0, 8);
			int b = changeStringToInt(s);
			// System.out.println(c);
			fos.write(b);
			fos.flush();
			str = str.substring(8);
		}

		// ��󲻹�8λ��0
		int last1 = 8 - str.length();
		for (int i = 0; i < last1; i++) {
			str += "0";
		}
		s = str.substring(0, 8);
		// System.out.println(s);
		int d = changeStringToInt(s);
		fos.write(d);

		// ѹ���󲻹���0�ĸ�����
		fos.write(last1);
		fos.flush();

		fos.close();

	}

	// ����Ԫ��λ�õ�����
	public int getIndex(HuffmNode node) {
		for (int i = 0; i < list.size(); i++) {
			if (node.getData() <= list.get(i).getData()) {
				return i;
			}
		}
		return list.size();
	}

	// ���ַ���ת��������
	public int changeStringToInt(String s) {
		int v1 = (s.charAt(0) - 48) * 128;
		int v2 = (s.charAt(1) - 48) * 64;
		int v3 = (s.charAt(2) - 48) * 32;
		int v4 = (s.charAt(3) - 48) * 16;
		int v5 = (s.charAt(4) - 48) * 8;
		int v6 = (s.charAt(5) - 48) * 4;
		int v7 = (s.charAt(6) - 48) * 2;
		int v8 = (s.charAt(7) - 48) * 1;
		return v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8;

	}
}