package com.wuman.jreadability.news;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
/**
 * 
 * @author liyuncong
 *
 */
public class DOMUtil {
	/**
	 * 遍历节点树，所有叶子节点都是文本节点
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
	
}
