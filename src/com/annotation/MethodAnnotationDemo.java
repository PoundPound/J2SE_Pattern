/**    
 * @Title: AnnotationDemo.java  
 * @Package com.annotation  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 5, 2017 9:18:04 AM  
 * @version V1.0    
 */
package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @ClassName: AnnotationDemo  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 5, 2017 9:18:04 AM  
 *    
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface MethodAnnotationDemo
{
	String value();
}
