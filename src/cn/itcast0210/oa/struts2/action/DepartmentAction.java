package cn.itcast0210.oa.struts2.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.itcast0210.oa.domain.Department;
import cn.itcast0210.oa.service.DepartmentService;
import cn.itcast0210.oa.struts2.action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor;
import com.opensymphony.xwork2.interceptor.ParametersInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class DepartmentAction extends BaseAction implements ModelDriven<Department>{
	
	//数据模型
	private Department model = new Department();
	
	
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	//非注解方式，在xml里定义的bean，这里必须有属性的get set方法
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String findAllDepartment(){
		List<Department> departmentList = this.departmentService.getAllDepartment();
		
		/**
		 * 在ValueStack中加载departmentList的方法
		 */
			/**
			 * 1、利用request把departmentList放入到request中
			 */
			//ServletActionContext.getRequest().setAttribute("departmentList", departmentList);
			
			/*
			 * 2、利用ActionContext.getContext().put方法把departmentList放入到map中
			 */
			//ActionContext.getContext().put("departmentList", departmentList);
		
		    /*
		     * 3、valueStack.set方法
		     *       以map<"departmentList",departmentList>的形式放入到对象栈中
		     */
			//ActionContext.getContext().getValueStack().set("departmentList", departmentList);
			/*
			 * 4、利用valueStack.push放入到栈顶
			 */
			ActionContext.getContext().getValueStack().push(departmentList);
			  /**
			   *  放入到对象栈的栈底
			   */
			//ActionContext.getContext().getValueStack().getRoot().add(departmentList);
			  /**
			   * 放入到对象栈的栈顶
			   */
			//ActionContext.getContext().getValueStack().getRoot().add(0, departmentList);
			return listAll;
	}
	
	
	/**
	 * 跳转到增加页面
	 */
	public String addUI(){
		return add_ui;
	}
	
	/**
	 * 增加页面
	 */
	public String add(){
		/**
		 * 增加逻辑
		 * 	1、获取页面数据
		 * 		* 属性驱动
		 * 			属性和set、get方法
		 *      * 模型驱动
		 *          * 实现步骤：
			 *      	* 这个action必须实现ModelDriver接口
			 *               	为ModelDriverInterceptor的核心代码
			 *      		 	@Override
							    public String intercept(ActionInvocation invocation) throws Exception {
							        Object action = invocation.getAction();
							
							        if (action instanceof ModelDriven) {//判断当前的action是否实现了ModelDriver
							            ModelDriven modelDriven = (ModelDriven) action;//转换为ModelDriven
							            ValueStack stack = invocation.getStack();
							            Object model = modelDriven.getModel();//得到模型驱动对象
							            if (model !=  null) {
							            	stack.push(model);//把模型驱动对象放入到栈顶
							            }
							            if (refreshModelBeforeResult) {
							                invocation.addPreResultListener(new RefreshModelBeforeResult(modelDriven, model));
							            }
							        }
							        return invocation.invoke();
							    }
					    
		 *              * 建立一个私有的模型对象
			 *          * 在这个action中有一个getModel方法
		 *          
		 *          *  模型驱动的作用：
		 *                 把模型驱动对象放入到栈顶
		 *  2、把数据封装到javabean中
		 *  3、进行save操作
		 */
		
		//把模型对象变成持久化对象，所以最好别让模型对象和后台session交互
		/**
		 * 创建了一个department对象，然后把模型对象的值赋值给department对象
		 * 这样做保证了模型对象不和后台的session发生交互
		 */
		Department department = new Department();
		department.setDname(this.getModel().getDname());
		department.setDescription(this.getModel().getDescription());
		
		
		this.departmentService.saveDepartment(department);
	
		return action2action;
	}
	
	
	/**
	 * 跳转到修改页面
	 */
	public String updateUI(){
		/**
		 * 逻辑：
		 * 		1、根据id把要回显的值查出来
		 * 			  因为model的作用域是一次请求，所以在这里不能用model来回显
		 * 		2、把要回显的对象压入到栈顶
		 */
		Department department = (Department)this.departmentService.getDepartmentByID(this.getModel().getDid());
		//ActionContext.getContext().put("department", department);
		ActionContext.getContext().getValueStack().push(department);
		return update_ui;
	}
	
	/**
	 * 修改
	 */
	public String update(){
		/*
		 * 步骤：
		 * 	 1、从session中把ID为model.getDid()的值的对象提取出来
		 * 	 2、在提取的对象进行修改，修改的值来自于model
		 * 	 3、执行update方法
		 */
		//把要修改的原始数据提取出来
		Department department = this.departmentService.getDepartmentByID(this.getModel().getDid());
	
		department.setDname(this.getModel().getDname());
		department.setDescription(this.getModel().getDescription());
		
		
		//修改
		this.departmentService.updateDepartment(department);
		
		return action2action;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		this.departmentService.deleteDepartmentByID(this.getModel().getDid());
		return action2action;
	}
}
