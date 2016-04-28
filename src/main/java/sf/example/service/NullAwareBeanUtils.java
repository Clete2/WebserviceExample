package sf.example.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Component;

/**
 * Behaves differently than BeanUtils in that it will not copy null values.
 */
@Component
public class NullAwareBeanUtils extends BeanUtilsBean {
	/**
	 * Only copies properties that aren't null. Useful for updating fields in
	 * the target object without overriding them with null values.
	 */
	@Override
	public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException {
		if (value == null) {
			return;
		}
		super.copyProperty(dest, name, value);
	}
}
