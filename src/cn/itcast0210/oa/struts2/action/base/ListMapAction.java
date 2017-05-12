package cn.itcast0210.oa.struts2.action.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 在list中含有map,这种情况在页面中怎么样进行遍历？
 * 
 * @author Administrator
 * 
 */
public class ListMapAction extends ActionSupport {
	public String testIterator() {
		List<Map<String, Object>> emList = new ArrayList<Map<String, Object>>();
		Map<String, Object> emap = new HashMap<String, Object>();
		emap.put("a1", "A-enum");
		emap.put("b1", 5);
		emap.put("c1", 6.7);
		emap.put("d1", "D-enum");

		Map<String, Object> emap1 = new HashMap<String, Object>();
		emap1.put("a1", "A1-enum");
		emap1.put("b1", "B1-enum");
		emap1.put("c1", "C1-enum");
		emap1.put("d1", "D1-enum");

		Map<String, Object> emap2 = new HashMap<String, Object>();
		emap2.put("a1", "A2-enum");
		emap2.put("b1", "B2-enum");
		emap2.put("c1", "C2-enum");
		emap2.put("d1", "D2-enum");

		emList.add(emap);
		emList.add(emap1);
		emList.add(emap2);

		ActionContext.getContext().put("emList", emList);
		return "emList";

	}
	/**
	 * 如何迭代map
	 * @return
	 */
	public String testIteratorMap() {
		Map<String, Object> emap2 = new HashMap<String, Object>();
		emap2.put("a1", "A2-enum");
		emap2.put("b1", "B2-enum");
		emap2.put("c1", "C2-enum");
		emap2.put("d1", "D2-enum");
		//ActionContext.getContext().put("emap2", emap2);
		ActionContext.getContext().getValueStack().push(emap2);
		return "emMap";
	}
}
