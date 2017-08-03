package com.xj.composite;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 抽象组件
 * @author WanYin
 *
 */
public interface Component {
	void operation();
}

//叶子组件
interface Leaf extends Component{
	
}

//容器组件
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);

}