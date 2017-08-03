package com.xj.composite;

import org.omg.Messaging.SyncScopeHelper;

/**
 * �������
 * @author WanYin
 *
 */
public interface Component {
	void operation();
}

//Ҷ�����
interface Leaf extends Component{
	
}

//�������
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);

}