package com.wuman.jreadability.news;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;
/**
 * 
 * @author liyuncong
 *
 */
public class DOMUtil {
	/**
	 * 先根遍历节点树，获得所有文本节点，所有叶子节点都是文本节点
	 * @param node
	 * @return 该节点下的所有文本节点
	 */
	public static List<TextNode> getAllTextNodes(Node node) {
		List<TextNode> textNodes = new ArrayList<>();
		
		if (node instanceof TextNode) {
			textNodes.add((TextNode) node);
			return textNodes;
		}
		
		List<Node> childNode = node.childNodes();
		int childNum = childNode.size();
		for(int i = 0; i < childNum; i++) {
			Node temp = childNode.get(i);
			textNodes.addAll(getAllTextNodes(temp));
		}
		return textNodes;
	}
	
	/**
	 * 判断candidate是否为parent的后代节点
	 * @param parent 父节点
	 * @param candidate 可能的后代节点
	 * @return
	 */
	public static boolean isChild(Node parent, Node candidate) {
		class FindCandidate implements NodeOperate{
			private boolean find;
			private Node candidate;
			
			public FindCandidate(Node candidate) {
				this.candidate = candidate;
			}
			@Override
			public void action(Node node) {
				if (node == candidate) {
					find = true;
				}
			}
			public boolean isFind() {
				return find;
			}
			
		}
		FindCandidate findCandidate = new FindCandidate(candidate);
		traverse(parent, findCandidate);
		return findCandidate.isFind();
	}
	
	/**
	 * 先根遍历节点树
	 * @param node 根节点
	 * @param nodeOperate 根节点上的操作
	 */
	public static void traverse(Node node, NodeOperate nodeOperate) {
		if (node != null) {
			nodeOperate.action(node);
			List<Node> children = node.childNodes();
			for (Node child : children) {
				traverse(child, nodeOperate);
			}
		}
	}
}
