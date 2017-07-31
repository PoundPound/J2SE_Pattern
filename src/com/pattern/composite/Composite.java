/**    
 * @Title: Composit.java  
 * @Package com.pattern.composit  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:14:10 AM  
 * @version V1.0    
 */
package com.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Composit
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:14:10 AM
 * 
 */
public interface Composite extends Component
{
	public List<Component> child = new ArrayList<Component>();
	public void add(Component c);
	public void remove(Component c);
	public Component getChild(int index);
}
