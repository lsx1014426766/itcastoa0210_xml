1执行itcastoa0210_xml/src/cn/itcast0210/utils/ExportDB.java
 通过项目反向生成数据表
 注意：需要手动创建db，再执行上面的方法，否则不生成表
 应用技术：struts2,spring,hibernate 后端
2启动项目：
  localhost:8080/itcastoa0210_xml
  
  person的action处理
  public class PersonAction extends ActionSupport
  department的action处理
  public class DepartmentAction extends BaseAction implements ModelDriven<Department>
 
 
  savePerson :
  http://localhost:8080/itcastoa0210_xml/personAction/personAction_savePerson
  getPersonById
  http://localhost:8080/itcastoa0210_xml/personAction/personAction_getPersonById 
  注意：此项目为非注解形式
     2需要在spring配置文件中定义所有的bean
     3在需要用到关联bean的地方，引入ref="beanid",
                同时在对应的class中相应的属性写上get set方法
     4项目中虽然可以写@Controller之类的注解，但是没有配置注解驱动，所以无效，可以去掉了
     5访问url的后缀action可以省略
     
     
  http://localhost:8080/itcastoa0210_xml/departmentAction_findAllDepartment
  注意：
   这里action的方法名为getXXX时，如果在jsp里面加上<s:debug/>会报错
   改为findXXX就可以了
     